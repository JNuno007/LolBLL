/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lolbll;

import hibernate.HibernateGenericLib;
import java.util.List;
import loldal.model.Equipatorneio;
import loldal.model.Torneio;

/**
 *
 * @author joaoc
 */
public class EquipaTorneioServices {

    public EquipaTorneioServices() {
    }
    
    public static void saveEquipaTorneio(Equipatorneio et){
        hibernate.HibernateGenericLib.saveObject(et);
    }
    
    public static void deleteEquipaTorneio(Equipatorneio et){
        HibernateGenericLib.deleteObject(et);
    }
    
    public static List<Equipatorneio> getListaDeTorneio(Torneio t){
        List<Equipatorneio> list = HibernateGenericLib.executeHQLQuery("from Equipatorneio where torneio="+t.getId());
        return list;
    }
    
}
