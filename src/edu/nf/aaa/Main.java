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

//        Girl cat = new Girl();
//        cat.setName("我收一只猫儿");
//        session.save(cat);

        Boy tom = new Boy();
        tom.setName("aaaaa");
        tom.setAge(22);
        tom.setAddress("黑龙江");
        tom.setWeixin("12");
        session.save(tom);


        System.out.println(tom.getHahaah());

        transaction.commit();

        session.close();
    }
}
