/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lolbll;

import hibernate.HibernateGenericLib;
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

}
