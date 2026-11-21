package com.mycompany.hospitalsusalud;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/** Mantiene las citas atendidas durante el día actual. */
public class Bitacora {
    private final LocalDate fecha=LocalDate.now();
    private final List<Cita> citas=new ArrayList<>();
    public void registrar(Cita cita){if(cita!=null)citas.add(cita);}
    public List<Cita> getCitas(){return Collections.unmodifiableList(citas);}
    public LocalDate getFecha(){return fecha;}
    /** Imprime las citas con códigos ANSI de color en terminales compatibles. */
    public void mostrar(){
        System.out.println("\nBITACORA DE CITAS - "+fecha);
        if(citas.isEmpty()){System.out.println("No hay citas registradas para el día.");return;}
        for(Cita c:citas){
            String ansi=switch(c.getColorEspera()){case "VERDE"->"\u001B[32m";case "AMARILLO"->"\u001B[33m";case "ROJO"->"\u001B[31m";default->"\u001B[0m";};
            System.out.println(ansi+c.getFicha()+" | "+c.getNombre()+" | Doctor: "+c.getDoctor()+" | Espera: "+c.getEsperaSegundos()+" s | "+c.getColorEspera()+"\u001B[0m");
        }
        System.out.println("Leyenda: VERDE 1-30 s | AMARILLO >30-60 s | ROJO >60 s");
    }
}
