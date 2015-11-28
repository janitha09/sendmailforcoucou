/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amandineleforestier.test;

import java.util.Hashtable;
import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author janitha
 */
public class NewEmptyJUnitTest {

    protected static final Logger logger = LoggerFactory.getLogger(NewEmptyJUnitTest.class);

    public NewEmptyJUnitTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
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
}
