package com.uday.basicqueries;

import com.uday.basicqueries.entites.Transaction;
import com.uday.util.ConnectionFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class HQLNamedQueryUsage {
    public static void main(String args[]){
        SessionFactory sessionFactory= ConnectionFactory.getSessionFactory();
        Session session=sessionFactory.openSession();

        Query query=session.getNamedQuery("Transaction.allTransactions");
        List<Transaction> transactionList=query.list();

        for(Transaction transaction: transactionList){
            System.out.println("The purchase made under the query condition is: "+transaction.getPurchaseName());
        }
    }
}
