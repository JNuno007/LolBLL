/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lolbll;

import hibernate.HibernateGenericLib;
import java.util.List;
import loldal.model.Encontro;
import loldal.model.Equipa;

/**
 *
 * @author joaoc
 */
public class EncontroServices {

    public EncontroServices() {
    }

    public static List<Encontro> listaEncontrosFromTeam(Equipa eq) {
        List<Encontro> lista = HibernateGenericLib.executeHQLQuery("from Encontro WHERE equipaByEquipa1 = " + eq.getId() + " OR equipaByEquipa2 = " + eq.getId());
        return lista;
    }
    
    public static void saveEncontro(Encontro e){
        HibernateGenericLib.saveObject(e);
    }

}
