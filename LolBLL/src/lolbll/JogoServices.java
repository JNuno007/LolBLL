/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lolbll;

import hibernate.HibernateGenericLib;
import java.math.BigDecimal;
import java.util.List;
import loldal.model.Equipa;
import loldal.model.Jogo;

/**
 *
 * @author joaoc
 */
public class JogoServices {

    public JogoServices() {
    }

    public static List<Jogo> listaJogosEquipa1(Equipa eq) {
        List<Jogo> lista = HibernateGenericLib.executeHQLQuery("from Jogo where equipaByEquipa1 = " + eq.getId());

        return lista;
    }

    public static List<Jogo> listaJogosEquipa2(Equipa eq) {
        List<Jogo> lista = HibernateGenericLib.executeHQLQuery("from Jogo where equipaByEquipa2 = " + eq.getId());

        return lista;
    }
    
    public static void saveJogo(Jogo j){
        HibernateGenericLib.saveObject(j);
    }
    
    public static void updateJogo(Jogo j){
        HibernateGenericLib.updateObject(j);
    }
    
    public static void addDeathsEquipa1(Jogo j, int deaths){
        j.setDeathsequipa1(new BigDecimal(j.getDeathsequipa1().intValue() + deaths));
        updateJogo(j);
    }
    public static void addDeathsEquipa2(Jogo j, int deaths){
        j.setDeathequipa2(new BigDecimal(j.getDeathequipa2().intValue() + deaths));
        updateJogo(j);
    }
    
    public static void addKillsEquipa1(Jogo j, int kills){
        j.setKillsequipa1(new BigDecimal(j.getKillsequipa1().intValue() + kills));
        updateJogo(j);
    }
    public static void addKillsEquipa2(Jogo j, int kills){
        j.setKillsequipa2(new BigDecimal(j.getKillsequipa2().intValue() + kills));
        updateJogo(j);
    }
    public static void addAssistsEquipa1(Jogo j, int assists){
        j.setAssistsequipa1(new BigDecimal(j.getAssistsequipa1().intValue() + assists));
        updateJogo(j);
    }
    public static void addAssistsEquipa2(Jogo j, int assists){
        j.setAssistsequipa2(new BigDecimal(j.getAssistsequipa2().intValue() + assists));
        updateJogo(j);
    }
}
