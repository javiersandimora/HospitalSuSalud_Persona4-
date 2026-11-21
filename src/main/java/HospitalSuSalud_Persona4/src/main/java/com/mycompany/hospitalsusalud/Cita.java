package com.mycompany.hospitalsusalud;
import java.util.Date;
/** Representa una cita médica concluida y su tiempo de espera. */
public class Cita {
    private final String ficha, cedula, nombre, doctor, diagnostico;
    private final Date fechaLlegada, fechaAtencion;
    private final long esperaSegundos;
    public Cita(Pacientes p,String doctor,String diagnostico,Date atencion){
        this.ficha=p.getNumeroFicha();this.cedula=p.getCedula();this.nombre=p.getNombre();
        this.doctor=doctor;this.diagnostico=diagnostico;this.fechaLlegada=p.getFechaLlegada();
        this.fechaAtencion=atencion;this.esperaSegundos=Math.max(0,(atencion.getTime()-fechaLlegada.getTime())/1000);
    }
    public String getFicha(){return ficha;} public String getCedula(){return cedula;} public String getNombre(){return nombre;}
    public String getDoctor(){return doctor;} public String getDiagnostico(){return diagnostico;}
    public Date getFechaLlegada(){return new Date(fechaLlegada.getTime());}
    public Date getFechaAtencion(){return new Date(fechaAtencion.getTime());}
    public long getEsperaSegundos(){return esperaSegundos;}
    /** Devuelve la categoría solicitada para colorear la cita en la bitácora. */
    public String getColorEspera(){
        if(esperaSegundos>=1 && esperaSegundos<=30)return "VERDE";
        if(esperaSegundos>30 && esperaSegundos<=60)return "AMARILLO";
        if(esperaSegundos>60)return "ROJO";
        return "SIN ESPERA";
    }
}
