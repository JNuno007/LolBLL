/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lolbll;

import loldal.model.Ronda;

/**
 *
 * @author joaoc
 */
public class RondaServices {

    public RondaServices() {
    }
    
    public static void saveRonda(Ronda r){
        hibernate.HibernateGenericLib.saveObject(r);
    }
    
}
