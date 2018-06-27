/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lolbll;

import hibernate.HibernateGenericLib;
import java.util.List;
import loldal.model.Equipa;

/**
 *
 * @author joaoc
 */
public class EquipaServices {

    public EquipaServices() {
    }

    public static List<Equipa> listaEquipas() {
        List<Equipa> lista = HibernateGenericLib.executeHQLQuery(" from Equipa");
        return lista;
    }

    public static void saveEquipa(Equipa e) {
        HibernateGenericLib.saveObject(e);
    }
    
    public static void atualizarEstadoEquipa(){
        List<Equipa> lista = HibernateGenericLib.executeHQLQuery(" from Equipa");
        
        for(Equipa eq: lista){
            if(eq.getMembroequipas().size() == 6){
                eq.setAtivo(true);
            }else{
                eq.setAtivo(false);
            }
            saveEquipa(eq);
        }
    }

}
