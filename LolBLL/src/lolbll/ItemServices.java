/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lolbll;

import hibernate.HibernateGenericLib;
import java.util.Comparator;
import java.util.List;
import loldal.model.Item;

/**
 *
 * @author joaoc
 */
public class ItemServices {

    public ItemServices() {
    }
    
    public static List<Item> getListaItems(){
        List<Item> items = HibernateGenericLib.executeHQLQuery("from Item");
        items.sort(Comparator.comparing((item) -> item.getNome()));
        return items;
    }
    
}
