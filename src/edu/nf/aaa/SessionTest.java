package edu.nf.aaa;


import edu.nf.aaa.entity.Fish;
import edu.nf.aaa.util.SessionUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class SessionTest {

    private Session session = null;
    private Transaction transaction = null;

    @Before
    public void setup() {
        session = SessionUtil.getSession();
        transaction = session.beginTransaction();
    }

    @After
    public void last() {
        if (session.isOpen()) {
            transaction.commit();
            session.close();
        }
    }

    @Test
    public void testLoad() {
        Fish f1 = session.load(Fish.class, 101l);
        System.out.println(f1);
    }

    @Test
    public void testGet() {
        // 1. get
        // Fish f1 = (Fish) session.get("edu.nf.aaa.entity.Fish", 10l);
        Fish f2 = (Fish) session.get(Fish.class, 101l);
        System.out.println(f2);
    }

    @Test
    public void testQuery() {
        Query query = session.createQuery("from Fish where id = :id");
        query.setLong("id", 101l);
        Fish f1 = (Fish) query.uniqueResult();
        System.out.println(f1);
    }


    @Test
    public void testGetLoadQuery() {

        System.out.println("----- query --------");
        session.createQuery("from Fish where id = :id").setLong("id", 10l).uniqueResult();


        System.out.println("----- load --------");
        Fish fish1 = session.load(Fish.class, 10l);

        System.out.println("----- get --------");
        session.get(Fish.class, 10l);
        session.get(Fish.class, 10l);
        session.get(Fish.class, 10l);
        session.get(Fish.class, 10l);
        session.get(Fish.class, 10l);
        session.get(Fish.class, 10l);
        session.get(Fish.class, 10l);
        session.get(Fish.class, 10l);
        session.get(Fish.class, 10l);
        session.load(Fish.class, 10l).getId();
        session.load(Fish.class, 10l).getId();
        session.load(Fish.class, 10l).getId();
        session.load(Fish.class, 10l).getId();
        session.load(Fish.class, 10l).getId();
        session.get(Fish.class, 10l);


    }


    @Test
    public void testLazyOrNot() {
        System.out.println("----- load --------");
        Fish fish1 = session.get(Fish.class, 10l);

        session.close();

        System.out.println(fish1.getName());
    }

    @Test
    public void testIsExist() {
        // Fish fish = session.load(Fish.class, 111l);
        Fish fish = session.get(Fish.class, 111l);
        System.out.println(fish);
    }

}