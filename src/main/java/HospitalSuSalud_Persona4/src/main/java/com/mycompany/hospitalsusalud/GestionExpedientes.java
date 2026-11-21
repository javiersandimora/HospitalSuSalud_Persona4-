package com.mycompany.hospitalsusalud;
/** Administra expedientes únicos y el cursor de navegación circular. */
public class GestionExpedientes {
    private final ListaDobleCircular expedientes=new ListaDobleCircular();
    /** Obtiene el expediente por cédula o crea uno si todavía no existe. */
    public Expediente obtenerOCrear(String cedula,String nombre){
        Expediente e=expedientes.buscar(cedula);
        if(e!=null)return e;
        e=new Expediente(cedula,nombre);expedientes.agregar(e);return e;
    }
    public Expediente buscar(String cedula){return expedientes.buscar(cedula);}
    public Expediente avanzar(){return expedientes.avanzar();}
    public Expediente retroceder(){return expedientes.retroceder();}
    public Expediente getActual(){return expedientes.getActual();}
    public int getCantidad(){return expedientes.getTamanio();}
}
