package com.mycompany.hospitalsusalud;
/** Nodo de la lista doble circular de expedientes. */
public class NodoExpediente {
    private Expediente expediente; private NodoExpediente siguiente,anterior;
    public NodoExpediente(Expediente e){expediente=e;}
    public Expediente getExpediente(){return expediente;}
    public NodoExpediente getSiguiente(){return siguiente;} public NodoExpediente getAnterior(){return anterior;}
    public void setSiguiente(NodoExpediente n){siguiente=n;} public void setAnterior(NodoExpediente n){anterior=n;}
}
