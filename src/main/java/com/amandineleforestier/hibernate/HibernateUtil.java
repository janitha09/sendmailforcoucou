/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package com.amandineleforestier.hibernate;
//
//import org.hibernate.SessionFactory;
//import org.hibernate.cfg.Configuration;
//import org.hibernate.service.ServiceRegistry;
////http://stackoverflow.com/questions/8640619/hibernate-serviceregistrybuilder
//import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
//
//public class HibernateUtil {
//
//    private static final SessionFactory sessionFactory;
//    private static final ServiceRegistry serviceRegistry;
//
//    static {
//        Configuration conf = new Configuration();
//        conf.configure("hibernate.cfg.xml");
////        conf.addClass(com.amandineleforestier.model.Whattoemail.class);
//        serviceRegistry = new StandardServiceRegistryBuilder().applySettings(conf.getProperties()).build();
//        try {
//            sessionFactory = conf.buildSessionFactory(serviceRegistry);
//        } catch (Exception e) {
//            System.err.println("Initial SessionFactory creation failed." + e);
//            throw new ExceptionInInitializerError(e);
//        }
//    }
//
//    public static SessionFactory getSessionFactory() {
//        return sessionFactory;
//    }
//}
