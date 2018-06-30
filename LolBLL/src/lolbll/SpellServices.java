/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lolbll;

import hibernate.HibernateGenericLib;
import java.util.Comparator;
import java.util.List;
import loldal.model.Spell;

/**
 *
 * @author joaoc
 */
public class SpellServices {

    public SpellServices() {
    }
    
    public static List<Spell> getListaSpells(){
        List<Spell> list = HibernateGenericLib.executeHQLQuery("from Spell");
        list.sort(Comparator.comparing((spell) -> spell.getNome()));
        return list;
    }
    
}
