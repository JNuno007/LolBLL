/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lolbll;

import loldal.model.Equipatorneio;

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
    
}
