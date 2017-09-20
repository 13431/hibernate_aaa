package edu.nf.aaa;

import edu.nf.aaa.entity.Boy;
import edu.nf.aaa.entity.Girl;
import edu.nf.aaa.util.SessionUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Main {


    public static void main(String[] args) {

        Session session = SessionUtil.getSession();
        Transaction transaction = session.beginTransaction();

        Girl cat = new Girl();
        cat.setName("i am a cat");
        session.save(cat);

        transaction.commit();

        session.close();
    }
}
