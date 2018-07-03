/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lolbll;

import hibernate.HibernateGenericLib;
import loldal.model.Runaescolhida;

/**
 *
 * @author joaoc
 */
public class RunaEscolhidaServices {

    public RunaEscolhidaServices() {
    }
    
    public static void saveRunaEscolhida(Runaescolhida re){
        HibernateGenericLib.saveObject(re);
    }
    
}
