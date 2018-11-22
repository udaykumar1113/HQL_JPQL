package com.uday.basicqueries;

import com.uday.basicqueries.entites.Transaction;
import com.uday.util.ConnectionFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class HQLPropertyAccess {
    public static void main(String args[]){
        SessionFactory sessionFactory= ConnectionFactory.getSessionFactory();
        Session session=sessionFactory.openSession();

        Query query=session.createQuery("select t.account.totalBalance from Transaction t");
        List<Float> transactionList=query.list();

        for(Float transaction: transactionList){
            System.out.println("The purchase amount is: "
                    +transaction);
        }
    }
}
