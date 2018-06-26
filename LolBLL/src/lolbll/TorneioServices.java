/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lolbll;

import hibernate.HibernateGenericLib;
import java.util.List;
import loldal.model.Equipa;
import loldal.model.Torneio;

/**
 *
 * @author joaoc
 */
public class TorneioServices {

    public TorneioServices() {
    }

    public static List<Torneio> listaNumTrofeusEquipa(Equipa eq) {
        List<Torneio> lista = HibernateGenericLib.executeHQLQuery("from Torneio where equipa = " + eq.getId());
        return lista;
    }

    public static List<Torneio> listaTorneios() {
        List<Torneio> lista = HibernateGenericLib.executeHQLQuery("from Torneio");

        return lista;
    }

}
