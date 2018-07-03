/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lolbll;

import hibernate.HibernateGenericLib;
import java.math.BigDecimal;
import java.util.List;
import java.util.Set;
import loldal.model.Champion;
import loldal.model.Estatisticasmembrojogo;
import loldal.model.Jogo;
import loldal.model.Membroequipa;

/**
 *
 * @author joaoc
 */
public class EstatisticasMembroJogoServices extends Estatisticasmembrojogo {

    public EstatisticasMembroJogoServices() {
    }

    public EstatisticasMembroJogoServices(BigDecimal id) {
        super(id);
    }

    public EstatisticasMembroJogoServices(BigDecimal id, Jogo jogo, Membroequipa membroequipa, Champion champion, BigDecimal kills, BigDecimal deaths, BigDecimal assists, BigDecimal cs, Set builds, Set spellescolhidos, Set runaescolhidas) {
        super(id, jogo, membroequipa, champion, kills, deaths, assists, cs, builds, spellescolhidos, runaescolhidas);
    }

    public static List<Estatisticasmembrojogo> listaEstatisticas(Membroequipa me) {
        List<Estatisticasmembrojogo> lista = HibernateGenericLib.executeHQLQuery(" from Estatisticasmembrojogo where membroequipa=" + me.getId());

        return lista;
    }

    public static List<Estatisticasmembrojogo> top3(Membroequipa me) {
        List<Estatisticasmembrojogo> lista = HibernateGenericLib.executeHQLQuery(" from Estatisticasmembrojogo where membroequipa=" + me.getId());

        return lista;
    }
    
    public static void saveEstatisticasMembroJogo(Estatisticasmembrojogo est){
        HibernateGenericLib.saveObject(est);
    }

}
