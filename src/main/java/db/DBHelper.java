package db;

import models.League;
import models.Manager;
import models.Player;
import models.Team;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import java.util.Calendar;
import java.util.List;

public class DBHelper {
    private static Transaction transaction;
    private static Session session;

    public static void saveOrUpdate(Object object) {

        session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            session.saveOrUpdate(object);
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public static <T> List<T> getList(Criteria criteria){
        List<T> results = null;
        try {
            transaction = session.beginTransaction();
            results = criteria.list();
            transaction.commit();
        } catch (HibernateException e){
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return results;
    }

    public static <T> T getUnique(Criteria criteria){
        T result = null;
        try {
            transaction = session.beginTransaction();
            result = (T)criteria.uniqueResult();
            transaction.commit();
        } catch (HibernateException e){
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return result;
    }

    public static void delete(Object object){
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            session.delete(object);
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public static <T> T find(Class classType, int id){
        session = HibernateUtil.getSessionFactory().openSession();
        T result = null;
        Criteria criteria = session.createCriteria(classType);
        criteria.add(Restrictions.idEq(id));
        result = getUnique(criteria);
        return result;
    }

    public static <T> List<T> getAll(Class classType){
        session = HibernateUtil.getSessionFactory().openSession();
        List<T> results = null;
        Criteria criteria = session.createCriteria(classType);
        results = getList(criteria);
        return results;
    }


    public static List<Team> getTeamsInLeague(League league){
    session = HibernateUtil.getSessionFactory().openSession();
    List<Team> results = null;
    Criteria criteria = session.createCriteria(Team.class);
    criteria.add(Restrictions.eq("league", league));
    criteria.addOrder(Order.desc("points"));
    results = getList(criteria);
    return results;

    }

    public static Player findPlayerByName(String name){
        session = HibernateUtil.getSessionFactory().openSession();
        Player found = null;
        Criteria criteria = session.createCriteria(Player.class);
        criteria.add(Restrictions.eq("name", name));
        found = getUnique(criteria);
        return found;
    }

    public static List<Player> findPlayersOfTeam(Team team, Manager manager){
        session = HibernateUtil.getSessionFactory().openSession();
        List<Player> results = null;
        Criteria criteria = session.createCriteria(Player.class);
        criteria.add(Restrictions.geProperty("manager","manager"));
        results = getList(criteria);
        return results;
    }


}
