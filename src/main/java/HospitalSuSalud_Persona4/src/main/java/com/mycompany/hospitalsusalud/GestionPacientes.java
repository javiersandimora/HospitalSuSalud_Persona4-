package com.mycompany.hospitalsusalud;
import java.util.Date;
/** Coordina el registro, atención y retiro de pacientes de las colas. */
public class GestionPacientes {
    private final ColaPacientes colaRegular=new ColaPacientes(), colaPreferencial=new ColaPacientes();
    private final GestorFichas gestorDeFichas=new GestorFichas();
    private int preferencialesAtendidosSeguidos=0;
    /** Registra la llegada, asigna ficha y coloca al paciente en su cola. */
    public void registrarPaciente(Pacientes p){
        if(p==null) throw new IllegalArgumentException("Paciente requerido.");
        p.setFechaLlegada(new Date());
        if(p.isPreferencial()){p.setNumeroFicha(gestorDeFichas.generarFichaPreferencial()); colaPreferencial.encolar(p);}
        else {p.setNumeroFicha(gestorDeFichas.generarFichaRegulares()); colaRegular.encolar(p);}
    }
    /** Atiende según la regla de hasta dos preferenciales por cada regular. */
    public Pacientes atenderSiguiente() throws Exception {
        boolean pref=!colaPreferencial.estaVacia(), reg=!colaRegular.estaVacia();
        if(!pref&&!reg)return null;
        if(!pref){preferencialesAtendidosSeguidos=0;return colaRegular.desencolar();}
        if(!reg||preferencialesAtendidosSeguidos<2){preferencialesAtendidosSeguidos++;return colaPreferencial.desencolar();}
        preferencialesAtendidosSeguidos=0;return colaRegular.desencolar();
    }
    public void mostrarColaRegular(){colaRegular.imprimirCola();}
    public void mostrarColaPreferencia(){colaPreferencial.imprimirCola();}
    public String seleccionarFichaRegular(){return colaRegular.estaVacia()?null:colaRegular.getFrente().getPaciente().getNumeroFicha();}
    public String seleccionarFichaPreferencial(){return colaPreferencial.estaVacia()?null:colaPreferencial.getFrente().getPaciente().getNumeroFicha();}
    /** Busca y elimina una ficha de cualquiera de las dos colas. */
    public Pacientes eliminarPacientePorFicha(String ficha){
        Pacientes p=colaRegular.eliminarPorFicha(ficha); return p!=null?p:colaPreferencial.eliminarPorFicha(ficha);
    }
}
