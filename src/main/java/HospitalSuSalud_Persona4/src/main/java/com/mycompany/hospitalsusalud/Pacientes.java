package com.mycompany.hospitalsusalud;
import java.util.Date;
/** Representa a una persona registrada en el sistema de atención. */
public class Pacientes {
    private String numeroFicha, cedula, nombre;
    private Date fechaLlegada;
    private boolean preferencial;
    public Pacientes() {}
    public Pacientes(String numeroFicha, String cedula, String nombre, Date fechaLlegada, boolean preferencial) {
        this.numeroFicha=numeroFicha; this.cedula=cedula; this.nombre=nombre;
        this.fechaLlegada=fechaLlegada; this.preferencial=preferencial;
    }
    public String getNumeroFicha(){return numeroFicha;}
    public Date getFechaLlegada(){return fechaLlegada;}
    public String getCedula(){return cedula;}
    public String getNombre(){return nombre;}
    public boolean isPreferencial(){return preferencial;}
    public void setNombre(String v){nombre=v;}
    public void setCedula(String v){cedula=v;}
    public void setNumeroFicha(String v){numeroFicha=v;}
    public void setFechaLlegada(Date v){fechaLlegada=v;}
    public void setPreferencial(boolean v){preferencial=v;}
}
