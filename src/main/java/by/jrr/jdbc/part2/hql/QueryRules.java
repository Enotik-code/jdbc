package by.jrr.jdbc.part2.hql;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.List;
import java.util.Queue;

public class QueryRules {

    private static SessionFactory sessionFactory;


    public static void main(String[] args) {


        Session session = sessionFactory.openSession();

        //select all
        Query query1 = session.createQuery("FROM Developer");
        //List<Developer> developers = query.list();

        //insert
        Query insertQuery = session.createQuery("INSERT INTO Developer(firstName, lastName, specialty, experience)");

        //update
        Query query2 = session.createQuery("UPDATE Developer SET experience =: exp WHERE id =: devId");
        query2.setParameter("exp", 3);
        query2.setParameter("devId", 1);

        //delete
        Query query = session.createQuery("DELETE FROM Developer WHERE id = :developerId");
        query.setParameter("developerId", 1);

        //select one colunm
        Query query = session.createQuery("SELECT D.lastName FROM Developer D");
        //List developers = query.list();

        //as
        Query query = session.createQuery("FROM Developer AS D");
        List developers = query.list();

        //where
        Query query = session.createQuery("FROM Developer D WHERE D.id = 1");
        List developer = query.list();

        //order by
        Query query = session.createQuery("FROM Developer D WHERE experience > 3 ORDER BY D.experience DESC");

        //group by
        Query query = session.createQuery("SELECT MAX(D.experience), D.lastName, D.specialty FROM Developer D GROUP BY D.lastName");
        List developers = query.list();

    }


    public void listDevelopers() {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();
        Query sqlQuery = session.createSQLQuery("SELECT * FROM HIBERNATE_DEVELOPERS");
        sqlQuery.addEntity(Developer.class);
        List developers = sqlQuery.list();

        for (Developer developer : developers) {
            System.out.println("=======================");
            System.out.println(developer);
            System.out.println("=======================");
        }
        transaction.commit();
        session.close();
    }
}
