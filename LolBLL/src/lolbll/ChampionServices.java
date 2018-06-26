/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lolbll;

import java.math.BigDecimal;
import java.util.Set;
import loldal.model.Champion;

/**
 *
 * @author joaoc
 */
public class ChampionServices extends Champion {

    public ChampionServices() {
    }

    public ChampionServices(BigDecimal id, String nome, boolean ativo) {
        super(id, nome, ativo);
    }

    public ChampionServices(BigDecimal id, String nome, boolean ativo, Set estatisticasmembrojogos) {
        super(id, nome, ativo, estatisticasmembrojogos);
    }

}
