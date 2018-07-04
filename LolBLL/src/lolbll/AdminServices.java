/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lolbll;

import hibernate.HibernateGenericLib;
import java.util.List;
import loldal.model.Admin;

/**
 *
 * @author joaoc
 */
public class AdminServices {

    public AdminServices() {
    }

    public static List<Admin> listaAdmins() {
        List<Admin> admins = hibernate.HibernateGenericLib.executeHQLQuery("from Admin");

        return admins;
    }
    
    public static void saveAdmin(Admin admin){
        HibernateGenericLib.saveObject(admin);
    }
    
    public static void updateAdmin(Admin admin){
        HibernateGenericLib.updateObject(admin);
    }
}
