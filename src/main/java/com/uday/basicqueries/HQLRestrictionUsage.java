package com.uday.basicqueries;

import com.uday.basicqueries.entites.Transaction;
import com.uday.util.ConnectionFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class HQLRestrictionUsage {
    public static void main(String args[]){

        SessionFactory sessionFactory= ConnectionFactory.getSessionFactory();
        Session session=sessionFactory.openSession();
        org.hibernate.Transaction transactions=session.beginTransaction();
        Criterion criterion_1= Restrictions.le("transactionAmount",5000f);
        Criterion criterion_2=Restrictions.like("purchaseName","BOOK");

        List<Transaction> transactionList=session.createCriteria(Transaction.class)
                .add(Restrictions.and(criterion_1,criterion_2)).list();

        System.out.println(transactionList.toString());

        for (Transaction transaction: transactionList) {
            System.out.println(transaction.getPurchaseName());
        }

        session.close();
    }
}
