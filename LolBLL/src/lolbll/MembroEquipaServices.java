/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lolbll;

import hibernate.HibernateGenericLib;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import loldal.model.Equipa;
import loldal.model.Membroequipa;

/**
 *
 * @author joaoc
 */
public class MembroEquipaServices {

    public MembroEquipaServices() {
    }

    public static List<Membroequipa> listaJogadores() {

        List<Membroequipa> listaPesquisa = HibernateGenericLib.executeHQLQuery(" from Membroequipa where cargo = 'player'");
//        Comparator<Membroequipa> comparator = Comparator.comparing(m -> m.getEquipa().toString());
//        comparator = comparator.thenComparing(Comparator.comparing(m -> m.getNome()));
        Comparator<Membroequipa> comparator = Comparator.comparing(m -> m.getNome().toLowerCase());
        Stream<Membroequipa> membroStream = listaPesquisa.stream().sorted(comparator);
        List<Membroequipa> listaOrdenada = membroStream.collect(Collectors.toList());
        return listaOrdenada;

    }

    public static List<Membroequipa> listaAll() {
        List<Membroequipa> listaPesquisa = HibernateGenericLib.executeHQLQuery(" from Membroequipa");
        return listaPesquisa;
    }

    public static void criarMembroEquipa(Membroequipa m) {
        HibernateGenericLib.saveObject(m);
    }
    
    public static void updateMembroEquipa(Membroequipa m) {
        HibernateGenericLib.updateObject(m);
    }
    
    public static List<Membroequipa> getAllMembrosDisponiveis() {
        List<Membroequipa> listaPesquisa = HibernateGenericLib.executeHQLQuery(" from Membroequipa where equipa is null");
        return listaPesquisa;
    }

    
    public static Set<Membroequipa> getAllMembrosFromTeam(Equipa team) {
        List<Membroequipa> listaPesquisa = HibernateGenericLib.executeHQLQuery(" from Membroequipa where equipa = " + team.getId());
        Set<Membroequipa> setPesquisa = new HashSet<>(listaPesquisa);
        return setPesquisa;
    }
    
    
}
