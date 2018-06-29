/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lolbll;

import hibernate.HibernateGenericLib;
import java.util.Comparator;
import java.util.List;
import loldal.model.Regiao;

/**
 *
 * @author joaoc
 */
public class RegiaoServices {

    public RegiaoServices() {
    }
    
    public static List<Regiao> getRegioes(){
        List<Regiao> list = hibernate.HibernateGenericLib.executeHQLQuery(" from Regiao");
        list.sort(Comparator.comparing((regiao) -> regiao.getDescricao()));
        return list;
    }
    
    public static void saveRegiao(Regiao r){
        HibernateGenericLib.saveObject(r);
    }
}
