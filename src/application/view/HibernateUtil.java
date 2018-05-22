package application.view;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */





public class HibernateUtil 
{
    private static final SessionFactory sessionFactory;

    static 
    {
        try 
        {
            sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
        }
            catch (Throwable ex) 
        {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
