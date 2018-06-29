/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lolbll;

import hibernate.HibernateGenericLib;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import loldal.model.Equipa;
import loldal.model.Membroequipa;

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
    
    public static List<Equipa> listaEquipasAtivas() {
        List<Equipa> lista = HibernateGenericLib.executeHQLQuery(" from Equipa where ativo = 1");
        return lista;
    }

    public static void saveEquipa(Equipa e) {
        HibernateGenericLib.saveObject(e);
    }
    
    public static void atualizarEstadoEquipa(){
        List<Equipa> lista = HibernateGenericLib.executeHQLQuery(" from Equipa");
        
        for(Equipa eq: lista){
           int cont = 0;
           List<Membroequipa> list = new ArrayList<>();
           list.addAll(eq.getMembroequipas());
           
           for(Membroequipa m: list){
               if(m.getPosicao()!=null){
                   cont++;
               }
           }
           if(cont == 5){
               eq.setAtivo(true);
           }else{
               eq.setAtivo(false);
           }
            saveEquipa(eq);
        }
    }
    
    public static List<Equipa> listaEquipasRegiao(String sigla){
        List<Equipa> list = HibernateGenericLib.executeHQLQuery(" from Equipa where ativo = 1");
        List<Equipa> listFiltrada = new ArrayList<>();
        
        for(Equipa eq: list){
            if(eq.getPais().getRegiao().getSigla().equals(sigla)){
                listFiltrada.add(eq);
            }
        }
        return listFiltrada;
    }
    
    public static List<Equipa> listaEquipasPais(String sigla){
        List<Equipa> list = HibernateGenericLib.executeHQLQuery(" from Equipa where ativo = 1");
        List<Equipa> listFiltrada = new ArrayList<>();
        
        for(Equipa eq: list){
            if(eq.getPais().getSigla().equals(sigla)){
                listFiltrada.add(eq);
            }
        }
        return listFiltrada;
    }

}
