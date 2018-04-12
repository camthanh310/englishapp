/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package englishapp;


import englishapp.models.CauHoi;
import englishapp.models.DapAn;
import englishapp.models.NguoiDung;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author thanhtieu
 */
public class HibernateUtil {
    private static final SessionFactory FACTORY;
    static {
        Configuration config = new Configuration();
        config.addAnnotatedClass(NguoiDung.class);
        config.addAnnotatedClass(CauHoi.class);
        config.addAnnotatedClass(DapAn.class);
        config.configure("hibernate.cfg.xml");
        StandardServiceRegistryBuilder builder = 
                new StandardServiceRegistryBuilder().
                        applySettings(config.getProperties());
        FACTORY = config.buildSessionFactory(builder.build());
    }
    
    public static SessionFactory getSessionFactory(){
        return FACTORY;
    }
    
}
