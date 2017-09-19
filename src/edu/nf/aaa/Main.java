package edu.nf.aaa;

import edu.nf.aaa.entity.Boy;
import edu.nf.aaa.entity.Girl;
import edu.nf.aaa.util.SessionUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Main {


    public static void main(String[] args) {

        Session session = SessionUtil.getSession();
        Transaction transaction = session.beginTransaction();

        Boy tom = new Boy();
        tom.setName("jboss");
        tom.setAge(22);
        tom.setWeixin("888");
        tom.setAddress("中山");
        session.save(tom);

        transaction.commit();

        session.close();
    }
}
