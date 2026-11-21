package com.mycompany.hospitalsusalud;
import java.util.Date;
/** Gestiona los abandonos de cola y su registro como quejas. */
public class GestionQuejas {
    private final Pila quejas=new Pila();
    public String abandonarCola(GestionPacientes gp,String ficha,String motivo){
        Pacientes p=gp.eliminarPacientePorFicha(ficha);
        if(p==null)return "No se encontro ningun paciente con la ficha "+ficha+".";
        quejas.apilar(new Queja(p.getNumeroFicha(),p.getNombre(),p.getCedula(),motivo,new Date()));
        return "El paciente "+p.getNombre()+" (ficha "+p.getNumeroFicha()+") abandono la cola. Queja registrada.";
    }
    public void mostrarQuejas(){quejas.imprimirPila();}
}
