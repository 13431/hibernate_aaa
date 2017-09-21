package edu.nf.aaa;

import edu.nf.aaa.entity.Fish;
import edu.nf.aaa.entity.Girl;
import edu.nf.aaa.util.SessionUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class Main {

    public static void main(String[] args) {
        testQueryOfQuery();
    }

    // 3
    public static void testQueryOfQuery () {
        Session session = SessionUtil.getSession();

        Query query = session.createQuery("from Fish where id = :id");
        query.setLong("id", 10l);
        Fish f1 = (Fish) query.uniqueResult();
        System.out.println(f1);

        session.close();
    }

    // 2
    public static void testQueryOfLoad () {
        Session session = SessionUtil.getSession();

        Fish f1 = session.load(Fish.class, 10l);
        System.out.println(f1);

        session.close();
    }

    // 1
    public static void testQueryOfGet () {
        // 1. get
        Session session = SessionUtil.getSession();
        // Fish f1 = (Fish) session.get("edu.nf.aaa.entity.Fish", 10l);
        Fish f2 = (Fish) session.get(Fish.class, 10l);
        System.out.println(f2);

        session.close();
    }

    public static void testFishSaveOrUpdate () {
        Session session = SessionUtil.getSession();
        session.beginTransaction();

        // 创建完毕之后，得到了一个瞬时对象
        Fish no01 = new Fish("鲤鱼", 18);

        // 开始持久化，但是在 commit 之前，并没有真正提交到数据库
        // 这一步，只是获得并赋予了 id 值
        session.persist(no01);

        session.flush();

        // commit 的时候，才会真正的保存到数据库
        // 因为，在 commit 的时候，会触发 flush 操作，它会将 session 缓存中的数据同步到数据库内
        session.getTransaction().commit();

        session.close();

        session = SessionUtil.getSession();
        session.beginTransaction();
        no01.setPrice(33.3f);
        session.saveOrUpdate(no01);
        session.getTransaction().commit();
        session.close();

    }


    public static void testGirl () {
        Session session = SessionUtil.getSession();
        Transaction transaction = session.beginTransaction();

        Girl cat = new Girl();
        cat.setName("i am a cat");
        session.save(cat);

        transaction.commit();
        session.close();
    }
}
