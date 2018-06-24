/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lolbll;

import java.util.List;
import loldal.model.Posicao;

/**
 *
 * @author joaoc
 */
public class PosicaoServices {

    public PosicaoServices() {
    }
    
    public static Posicao getPosicao(String pos){
        List<Posicao> lista = hibernate.HibernateGenericLib.executeHQLQuery("from Posicao where sigla = '" + pos + "'");
        Posicao posicao = lista.get(0);
        return posicao;
    }
    
}
