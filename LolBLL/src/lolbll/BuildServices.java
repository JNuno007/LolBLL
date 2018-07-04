/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lolbll;

import hibernate.HibernateGenericLib;
import loldal.model.Build;

/**
 *
 * @author joaoc
 */
public class BuildServices {

    public BuildServices() {
    }
    
    public static void saveBuild(Build b){
        HibernateGenericLib.saveObject(b);
    }
}
