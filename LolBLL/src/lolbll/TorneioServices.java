/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lolbll;

import hibernate.HibernateGenericLib;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import loldal.model.Encontro;
import loldal.model.Equipa;
import loldal.model.Ronda;
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
    
    public static List<Torneio> listaTorneiosNaoInicializados(){
        List<Torneio> lista = HibernateGenericLib.executeHQLQuery("from Torneio");
        List<Torneio> temp = new ArrayList<>();
        boolean jogoExiste = false;
        for(Torneio t: lista){
            if(t.getEstado().equals("CRIADO")){
                temp.add(t);
            }
        }
        return temp;
    }
    
    public static void saveTorneio(Torneio t){
        HibernateGenericLib.saveObject(t);
    }
    
    public static void updateTorneio(Torneio t){
        HibernateGenericLib.updateObject(t);
    }

}
