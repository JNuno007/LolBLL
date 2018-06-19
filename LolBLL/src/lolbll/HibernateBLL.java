/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lolbll;

import hibernate.HibernateGenericLib;
import hibernate.HibernateUtil;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 *
 * @author joaoc
 */
public class HibernateBLL{
       
    
    public static void close(){
        HibernateGenericLib.closeSession();
        StandardServiceRegistryBuilder.destroy(HibernateUtil.getSessionFactory().getSessionFactoryOptions().getServiceRegistry());
    }
        
}
