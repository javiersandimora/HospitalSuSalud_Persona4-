package com.mycompany.hospitalsusalud;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/** Expediente clínico único identificado por la cédula del paciente. */
public class Expediente {
    private final String cedula,nombre;
    private final List<String> historial=new ArrayList<>();
    public Expediente(String cedula,String nombre){this.cedula=cedula;this.nombre=nombre;}
    public String getCedula(){return cedula;} public String getNombre(){return nombre;}
    public void agregarRegistro(String registro){historial.add(registro);}
    public List<String> getHistorial(){return Collections.unmodifiableList(historial);}
    @Override public String toString(){return "Expediente: "+nombre+" | Cédula: "+cedula+" | Registros: "+historial.size();}
}
