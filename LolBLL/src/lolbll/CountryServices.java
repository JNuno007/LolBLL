/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lolbll;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import loldal.model.Pais;

/**
 *
 * @author joaoc
 */
public class CountryServices {

    public CountryServices() {
    }
    
    public static List<Pais> getListaPaises(){
        List<Pais> paises = hibernate.HibernateGenericLib.executeHQLQuery("from Pais");
        paises.sort(Comparator.comparing((pais) -> pais.getNome()));
        return paises;
    } 
    
}
