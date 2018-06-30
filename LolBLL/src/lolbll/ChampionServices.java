/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lolbll;

import hibernate.HibernateGenericLib;
import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import loldal.model.Champion;

/**
 *
 * @author joaoc
 */
public class ChampionServices extends Champion {

    public ChampionServices() {
    }

    public static List<Champion> getListChampions(){
        List<Champion> list = HibernateGenericLib.executeHQLQuery(" from Champion");
        list.sort(Comparator.comparing((champion) -> champion.getNome()));
        return list;
    }

}
