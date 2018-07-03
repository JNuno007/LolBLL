/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lolbll;

import hibernate.HibernateGenericLib;
import java.math.BigDecimal;
import java.util.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import loldal.model.Encontro;
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
    
    public static void verificaRondaConcluida(Ronda r){
        int nEquipas = r.getTorneio().getEquipatorneios().size();
        int cont = 0;
        if(nEquipas == 8){
            for(Encontro e: (Set<Encontro>)r.getEncontros()){
                if(e.getEquipaByVencedor()!=null){
                    cont++;
                }
            }
            if(r.getEncontros().size() == cont){
                r.setEstado("FINALIZADO");
                RondaServices.saveRonda(r);
                List<Encontro> listaEncontros = new ArrayList<>();
                Ronda ronda = new Ronda();
                switch(r.getNronda().intValue()){
                    case 1:
                        r.getTorneio().setRondaatual(new BigDecimal(2));

                        listaEncontros.addAll(r.getEncontros());
                        listaEncontros.sort(Comparator.comparing((encontro) -> encontro.getId()));

                        ronda.setTorneio(r.getTorneio());
                        ronda.setNumequipas(new BigDecimal(4));
                        ronda.setNronda(new BigDecimal(2));
                        ronda.setDescricao("Semi finals");
                        ronda.setEstado("CRIADO");

                        Encontro encontro1 = new Encontro();
                        Encontro encontro2 = new Encontro();

                        encontro1.setData(addDays(r.getTorneio().getDatafim(), 3));
                        encontro1.setEstado("CRIADO");
                        encontro1.setTotaljogos(new BigDecimal(5));
                        encontro1.setVitoriaequipa1(BigDecimal.ZERO);
                        encontro1.setVitoriaequipa2(BigDecimal.ZERO);
                        encontro2.setData(addDays(r.getTorneio().getDatafim(), 6));
                        encontro2.setEstado("CRIADO");
                        encontro2.setTotaljogos(new BigDecimal(5));
                        encontro2.setVitoriaequipa1(BigDecimal.ZERO);
                        encontro2.setVitoriaequipa2(BigDecimal.ZERO);

                        encontro1.setRonda(ronda);
                        encontro2.setRonda(ronda);

                        encontro1.setEquipaByEquipa1(listaEncontros.get(0).getEquipaByVencedor());
                        encontro1.setEquipaByEquipa2(listaEncontros.get(1).getEquipaByVencedor());
                        encontro2.setEquipaByEquipa1(listaEncontros.get(2).getEquipaByVencedor());
                        encontro2.setEquipaByEquipa2(listaEncontros.get(3).getEquipaByVencedor());


                        TorneioServices.saveTorneio(r.getTorneio());
                        RondaServices.saveRonda(ronda);
                        EncontroServices.saveEncontro(encontro1);
                        EncontroServices.saveEncontro(encontro2);
                        HibernateGenericLib.clearCache();
                        break;
                    case 2:
                        r.getTorneio().setRondaatual(new BigDecimal(3));
                        listaEncontros.addAll(r.getEncontros());
                        listaEncontros.sort(Comparator.comparing((encontro) -> encontro.getId()));

                        ronda.setTorneio(r.getTorneio());
                        ronda.setNumequipas(new BigDecimal(2));
                        ronda.setNronda(new BigDecimal(3));
                        ronda.setDescricao("Final");
                        ronda.setEstado("CRIADO");
                        
                        Encontro finals = new Encontro();

                        finals.setData(addDays(r.getTorneio().getDatafim(), 6));
                        finals.setEstado("CRIADO");
                        finals.setTotaljogos(new BigDecimal(5));
                        finals.setVitoriaequipa1(BigDecimal.ZERO);
                        finals.setVitoriaequipa2(BigDecimal.ZERO);
                         
                        finals.setRonda(ronda);

                        finals.setEquipaByEquipa1(listaEncontros.get(0).getEquipaByVencedor());
                        finals.setEquipaByEquipa2(listaEncontros.get(1).getEquipaByVencedor());
                        
                        TorneioServices.saveTorneio(r.getTorneio());
                        RondaServices.saveRonda(ronda);
                        EncontroServices.saveEncontro(finals);
                        HibernateGenericLib.clearCache();
                        break;
                    case 3:
                        List<Encontro> temp = new ArrayList<>();
                        temp.addAll(r.getEncontros());
                        r.getTorneio().setEstado("FINALIZADO");
                        r.getTorneio().setEquipa(temp.get(0).getEquipaByVencedor());
                        TorneioServices.saveTorneio(r.getTorneio());
                        HibernateGenericLib.clearCache();
                        break;
                }
            }
        }
        if(nEquipas == 16){
            for(Encontro e: (Set<Encontro>)r.getEncontros()){
                if(e.getEquipaByVencedor()!=null){
                    cont++;
                }
            }
            if(r.getEncontros().size() == cont){
                r.setEstado("FINALIZADO");
                RondaServices.saveRonda(r);
                List<Encontro> listaEncontros = new ArrayList<>();
                Ronda ronda = new Ronda();
                switch(r.getNronda().intValue()){
                    case 1:
                        r.getTorneio().setRondaatual(new BigDecimal(2));

                        listaEncontros.addAll(r.getEncontros());
                        listaEncontros.sort(Comparator.comparing((encontro) -> encontro.getId()));

                        ronda.setTorneio(r.getTorneio());
                        ronda.setNumequipas(new BigDecimal(8));
                        ronda.setNronda(new BigDecimal(2));
                        ronda.setDescricao("Quarter finals");
                        ronda.setEstado("CRIADO");

                        Encontro encontro1 = new Encontro();
                        Encontro encontro2 = new Encontro();
                        Encontro encontro3 = new Encontro();
                        Encontro encontro4 = new Encontro();

                        encontro1.setData(addDays(r.getTorneio().getDatafim(), 3));
                        encontro1.setEstado("CRIADO");
                        encontro1.setTotaljogos(new BigDecimal(5));
                        encontro1.setVitoriaequipa1(BigDecimal.ZERO);
                        encontro1.setVitoriaequipa2(BigDecimal.ZERO);
                        encontro2.setData(addDays(r.getTorneio().getDatafim(), 3));
                        encontro2.setEstado("CRIADO");
                        encontro2.setTotaljogos(new BigDecimal(5));
                        encontro2.setVitoriaequipa1(BigDecimal.ZERO);
                        encontro2.setVitoriaequipa2(BigDecimal.ZERO);
                        encontro3.setData(addDays(r.getTorneio().getDatafim(), 3));
                        encontro3.setEstado("CRIADO");
                        encontro3.setTotaljogos(new BigDecimal(5));
                        encontro3.setVitoriaequipa1(BigDecimal.ZERO);
                        encontro3.setVitoriaequipa2(BigDecimal.ZERO);
                        encontro4.setData(addDays(r.getTorneio().getDatafim(), 3));
                        encontro4.setEstado("CRIADO");
                        encontro4.setTotaljogos(new BigDecimal(5));
                        encontro4.setVitoriaequipa1(BigDecimal.ZERO);
                        encontro4.setVitoriaequipa2(BigDecimal.ZERO);

                        encontro1.setRonda(ronda);
                        encontro2.setRonda(ronda);
                        encontro3.setRonda(ronda);
                        encontro4.setRonda(ronda);

                        encontro1.setEquipaByEquipa1(listaEncontros.get(0).getEquipaByVencedor());
                        encontro1.setEquipaByEquipa2(listaEncontros.get(1).getEquipaByVencedor());
                        encontro2.setEquipaByEquipa1(listaEncontros.get(2).getEquipaByVencedor());
                        encontro2.setEquipaByEquipa2(listaEncontros.get(3).getEquipaByVencedor());
                        encontro3.setEquipaByEquipa1(listaEncontros.get(4).getEquipaByVencedor());
                        encontro3.setEquipaByEquipa2(listaEncontros.get(5).getEquipaByVencedor());
                        encontro4.setEquipaByEquipa1(listaEncontros.get(6).getEquipaByVencedor());
                        encontro4.setEquipaByEquipa2(listaEncontros.get(7).getEquipaByVencedor());


                        TorneioServices.saveTorneio(r.getTorneio());
                        RondaServices.saveRonda(ronda);
                        EncontroServices.saveEncontro(encontro1);
                        EncontroServices.saveEncontro(encontro2);
                        EncontroServices.saveEncontro(encontro3);
                        EncontroServices.saveEncontro(encontro4);
                        HibernateGenericLib.clearCache();
                        break;
                    case 2:
                        r.getTorneio().setRondaatual(new BigDecimal(3));

                        listaEncontros.addAll(r.getEncontros());
                        listaEncontros.sort(Comparator.comparing((encontro) -> encontro.getId()));

                        ronda.setTorneio(r.getTorneio());
                        ronda.setNumequipas(new BigDecimal(4));
                        ronda.setNronda(new BigDecimal(3));
                        ronda.setDescricao("Semi finals");
                        ronda.setEstado("CRIADO");

                        Encontro encontroSF1 = new Encontro();
                        Encontro encontroSF2 = new Encontro();

                        encontroSF1.setData(addDays(r.getTorneio().getDatafim(), 6));
                        encontroSF1.setEstado("CRIADO");
                        encontroSF1.setTotaljogos(new BigDecimal(5));
                        encontroSF1.setVitoriaequipa1(BigDecimal.ZERO);
                        encontroSF1.setVitoriaequipa2(BigDecimal.ZERO);
                        encontroSF2.setData(addDays(r.getTorneio().getDatafim(), 6));
                        encontroSF2.setEstado("CRIADO");
                        encontroSF2.setTotaljogos(new BigDecimal(5));
                        encontroSF2.setVitoriaequipa1(BigDecimal.ZERO);
                        encontroSF2.setVitoriaequipa2(BigDecimal.ZERO);

                        encontroSF1.setRonda(ronda);
                        encontroSF2.setRonda(ronda);

                        encontroSF1.setEquipaByEquipa1(listaEncontros.get(0).getEquipaByVencedor());
                        encontroSF1.setEquipaByEquipa2(listaEncontros.get(1).getEquipaByVencedor());
                        encontroSF2.setEquipaByEquipa1(listaEncontros.get(2).getEquipaByVencedor());
                        encontroSF2.setEquipaByEquipa2(listaEncontros.get(3).getEquipaByVencedor());


                        TorneioServices.saveTorneio(r.getTorneio());
                        RondaServices.saveRonda(ronda);
                        EncontroServices.saveEncontro(encontroSF1);
                        EncontroServices.saveEncontro(encontroSF2);
                        HibernateGenericLib.clearCache();
                        break;
                    case 3:
                        r.getTorneio().setRondaatual(new BigDecimal(4));
                        listaEncontros.addAll(r.getEncontros());
                        listaEncontros.sort(Comparator.comparing((encontro) -> encontro.getId()));

                        ronda.setTorneio(r.getTorneio());
                        ronda.setNumequipas(new BigDecimal(2));
                        ronda.setNronda(new BigDecimal(4));
                        ronda.setDescricao("Final");
                        ronda.setEstado("CRIADO");
                        
                        Encontro finals = new Encontro();

                        finals.setData(addDays(r.getTorneio().getDatafim(), 9));
                        finals.setEstado("CRIADO");
                        finals.setTotaljogos(new BigDecimal(5));
                        finals.setVitoriaequipa1(BigDecimal.ZERO);
                        finals.setVitoriaequipa2(BigDecimal.ZERO);
                         
                        finals.setRonda(ronda);

                        finals.setEquipaByEquipa1(listaEncontros.get(0).getEquipaByVencedor());
                        finals.setEquipaByEquipa2(listaEncontros.get(1).getEquipaByVencedor());
                        
                        TorneioServices.saveTorneio(r.getTorneio());
                        RondaServices.saveRonda(ronda);
                        EncontroServices.saveEncontro(finals);
                        HibernateGenericLib.clearCache();
                        break;
                    case 4:
                        List<Encontro> temp = new ArrayList<>();
                        temp.addAll(r.getEncontros());
                        r.getTorneio().setEstado("FINALIZADO");
                        r.getTorneio().setEquipa(temp.get(0).getEquipaByVencedor());
                        TorneioServices.saveTorneio(r.getTorneio());
                        HibernateGenericLib.clearCache();
                        break;
                }
            }
        }
    }
    
    public static Date addDays(Date date, int days)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, days); //minus number would decrement the days
        return cal.getTime();
    }
    
}
