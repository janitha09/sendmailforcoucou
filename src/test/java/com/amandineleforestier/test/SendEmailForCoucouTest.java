/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amandineleforestier.test;

//import com.amandineleforestier.hibernate.HibernateUtil;
import com.amandineleforestier.model.Emailaddresses;
import com.amandineleforestier.model.Shopsthathaveemailaddresses;
import com.amandineleforestier.model.Whattoemail;
import com.amandineleforestier.sendmailforcoucou.SendEmail;
import java.util.Hashtable;
import java.util.List;
import java.util.logging.Level;
import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author janitha
 */
public class SendEmailForCoucouTest {

    protected static final Logger logger = LoggerFactory.getLogger(SendEmailForCoucouTest.class);

    public SendEmailForCoucouTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void checkWhetherTheDomainIsActive() throws NamingException {
//        http://www.rgagnon.com/javadetails/java-0452.html
        Hashtable<String, String> env = new Hashtable<String, String>();
        env.put("java.naming.factory.initial", "com.sun.jndi.dns.DnsContextFactory");
        DirContext ictx = new InitialDirContext(env);
        Attributes attrs = ictx.getAttributes("gmail.com", new String[]{"MX"});
        Attribute attr = attrs.get("MX");
        logger.info(attrs.toString());
        if (attr == null) {

        } // No MX record
        else {
            // If attr.size() > 0, there is an MX record
        }
        assertEquals(0, 0 /*attrs.size()*/);
    }

    @Test
//    @Ignore
    public void sendAnEmail() {
//        http://dyn.com/blog/tracking-email-opens-via-google-analytics/
        SendEmail se = new SendEmail();
        se.SendAnEmail("janitha.jayaweera@gmail.com", "Seek Capsule Rooms, You Choose!", "2016114");
    }

//    @Test
//    @Ignore
//    public void dataUsingHibernate() {
//        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
//        Session session = sessionFactory.openSession();
//        session.beginTransaction();
//
//        Whattoemail wte = new Whattoemail();
//        wte.setSubject("hibernate subject");
//
//        session.save(wte);
////        session.getTransaction().commit();
////        
////        List<Whattoemail> wtes = session.createQuery("from Whattoemail").list();
////        session.close();
////        
////        assertEquals(0,wtes.size());
//
//    }
    @Test
    public void replaceText() {
        String text = "Hi my name is <name></name>";
        String replace = text.replace("<name></name>", "Janitha");
        assertEquals("Hi my name is Janitha", replace);
        text = "Your shop <shopname></shopname>, carries <brandname></brandname>. By including Amandine Leforestier on your shop floor you could further enhance the atmosphere you have created";
        replace = text.replace("<shopname></shopname>", "Le66").replace("<brandname></brandname>", "margaux laumbert");
        assertEquals("Your shop Le66, carries margaux laumbert. By including Amandine Leforestier on your shop floor you could further enhance the atmosphere you have created", replace);
    }

    @Test
    public void getEmailText() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("sendmailPU");
        Whattoemail[] bi = null;
        try {
            javax.persistence.Query q = emf.createEntityManager().createNamedQuery("Whattoemail.findBySubject").setParameter("subject", "Amandine Leforestier AW 2016");
            bi = (Whattoemail[]) q.getResultList().toArray(new Whattoemail[0]);
        } finally {
            emf.createEntityManager().close();
        }
        assertEquals("Amandine Leforestier AW 2016", bi[0].getSubject());
    }

    @Test
//    @Ignore
    public void preFetchShopUrlsFromTable() {
        int offset = 0;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("sendmailPU");
        EntityManager em = emf.createEntityManager();
        List<Shopsthathaveemailaddresses> models = null;//where sh.placetypes like '%clothing%' and sh.shopurl is not null and sh.shopurl <> ''
//        EmailScraper emailFinder = new EmailScraper();
        int i = 0;
//        String text = "We are Amandine Leforestier. We are contacting you because you carry <brandname> in your shop <shopname>";
        while ((models = getIterableModels(em, offset, Shopsthathaveemailaddresses.class)).size() > 0) {
            em.getTransaction().begin();

            for (Shopsthathaveemailaddresses model : models) {
//                java.util.logging.Logger.getLogger(SendEmailForCoucouTest.class.getName()).log(Level.INFO, "Url: {0} ", model.getEmail()+ model.getSrc1()+model.getShopname());
                String text = "We are Amandine Leforestier. We are contacting you because you carry <brandname> in your shop <shopname>";
                text = text.replace("<brandname>", model.getBrandname()).replace("<shopname>", model.getShopname());
                System.out.println(i + " " + text);
                System.out.println(i + " " + model.getBrandname() + " " + model.getId() + " " + model.getEmail() + " " + model.getSrc1() + " " + model.getShopname());
//                crawlForEmailAddresses(model.getShopurl());
                i++;
            }
            em.flush();
            em.clear();
            em.getTransaction().commit();
            offset += models.size();
        }
    }

    private List<Shopsthathaveemailaddresses> getIterableModels(EntityManager em, int offset, Class<Shopsthathaveemailaddresses> aClass) {
        return em.createQuery("FROM Shopsthathaveemailaddresses as a", aClass).
                setFirstResult(offset).
                setMaxResults(100).
                getResultList();
    }
    @Test
    @Ignore
    public void getListOfEmailsFromSpreadSheet() throws InterruptedException{
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("sendmailPU");
        Emailaddresses[] bi = null;
        try {
            javax.persistence.Query q = emf.createEntityManager().createNamedQuery("Emailaddresses.fromSpreadSheet").setParameter("sid", 62267).setParameter("lid", 62437);
            bi = (Emailaddresses[]) q.getResultList().toArray(new Emailaddresses[0]);
        } finally {
            emf.createEntityManager().close();
        }
        assertEquals("belen.cabido@molet.com", bi[169].getEmail());
        String recipientid;
        SendEmail se = new SendEmail();
        for (int i = 10 ; i < bi.length ; i++){ //bi.length
            recipientid = Integer.toString(62268 + i);
            System.out.println(recipientid + " " + bi[i].getEmail() );
            se.SendAnEmail(bi[i].getEmail(), "Seek Capsule Rooms, You Choose!", recipientid);
            Thread.sleep(60000);
        }
    }
}
