/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lolbll;

import hibernate.HibernateGenericLib;
import java.util.List;
import loldal.model.Runa;

/**
 *
 * @author joaoc
 */
public class RunesServices {

    public RunesServices() {
    }
    
    public static List<Runa> getListRuna(){
        List<Runa> list = HibernateGenericLib.executeHQLQuery(" from Runa");
        
        return list;
    }
    
}
