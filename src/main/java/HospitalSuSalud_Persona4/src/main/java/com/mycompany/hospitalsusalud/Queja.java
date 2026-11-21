package com.mycompany.hospitalsusalud;
import java.util.Date;
/** Información de un abandono de cola y su motivo. */
public class Queja {
    private String numeroFicha,nombrePaciente,cedula,motivo; private Date fechaHora;
    public Queja(){}
    public Queja(String f,String n,String c,String m,Date d){numeroFicha=f;nombrePaciente=n;cedula=c;motivo=m;fechaHora=d;}
    public String getNumeroFicha(){return numeroFicha;} public void setNumeroFicha(String v){numeroFicha=v;}
    public String getNombrePaciente(){return nombrePaciente;} public void setNombrePaciente(String v){nombrePaciente=v;}
    public String getCedula(){return cedula;} public void setCedula(String v){cedula=v;}
    public String getMotivo(){return motivo;} public void setMotivo(String v){motivo=v;}
    public Date getFechaHora(){return fechaHora;} public void setFechaHora(Date v){fechaHora=v;}
    @Override public String toString(){return numeroFicha+" - "+nombrePaciente+" ("+cedula+") | Motivo: "+motivo+" | Fecha: "+fechaHora;}
}
