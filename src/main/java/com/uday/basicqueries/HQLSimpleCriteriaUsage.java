package com.uday.basicqueries;

import com.uday.basicqueries.entites.Transaction;
import com.uday.util.ConnectionFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import java.util.List;

public class HQLSimpleCriteriaUsage {
    public static void main(String arg[]){

        SessionFactory sessionFactory= ConnectionFactory.getSessionFactory();
        Session session=sessionFactory.openSession();

        List<Transaction> transactionList=session.createCriteria(Transaction.class)
                                            .addOrder(Order.asc("purchaseName")).list();
        for(Transaction transaction:transactionList){
            System.out.println(transaction.getPurchaseName());
        }
    }
}
