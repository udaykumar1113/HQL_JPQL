package com.uday.basicqueries;

import com.uday.basicqueries.entites.Account;
import com.uday.basicqueries.entites.Transaction;
import com.uday.util.ConnectionFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.Date;
import java.util.List;


public class HQLQueryUsage {

    public static void main(String args[]) {

        SessionFactory sessionFactory=ConnectionFactory.getSessionFactory();
        Session session=sessionFactory.openSession();

        org.hibernate.Transaction hibernateTransaction=session.beginTransaction();

        Account account=new Account();
        account.setTotalBalance(10000);

        Transaction transaction_1=new Transaction();
        transaction_1.setTransactionAmount(100);
        transaction_1.setPurchaseName("BOOK PURCHASE");
        transaction_1.setTransactionDate(new Date());
        transaction_1.setAccount(account);

        Transaction transaction_2=new Transaction();
        transaction_2.setPurchaseName("LAPTOP PURCHASE");
        transaction_2.setTransactionAmount(1200);
        transaction_2.setTransactionDate(new Date());
        transaction_2.setAccount(account);

        account.getTransactionList().add(transaction_1);
        account.getTransactionList().add(transaction_2);

        session.save(account);

        hibernateTransaction.commit();

        Query query=session.createQuery("select t from Transaction t");
        List<Transaction> queryList=query.list();

        for (Transaction transaction: queryList) {
            System.out.println(transaction.getPurchaseName());
        }
        session.close();

    }

}
