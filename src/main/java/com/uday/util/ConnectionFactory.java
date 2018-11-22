package com.uday.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ConnectionFactory {
    public static SessionFactory getSessionFactory(){

        return new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

    }
}
