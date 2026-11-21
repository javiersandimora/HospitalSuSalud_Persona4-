package com.mycompany.hospitalsusalud;
/** Lista doblemente enlazada circular que permite recorrer expedientes en ambos sentidos. */
public class ListaDobleCircular {
    private NodoExpediente actual; private int tamanio;
    public ListaDobleCircular(){actual=null;tamanio=0;}
    public int getTamanio(){return tamanio;} public boolean estaVacia(){return actual==null;}
    /** Inserta un expediente al final y lo deja como actual si es el primero. */
    public void agregar(Expediente e){
        if(e==null)throw new IllegalArgumentException("Expediente requerido.");
        NodoExpediente n=new NodoExpediente(e);
        if(actual==null){n.setSiguiente(n);n.setAnterior(n);actual=n;}
        else{NodoExpediente ultimo=actual.getAnterior();n.setSiguiente(actual);n.setAnterior(ultimo);ultimo.setSiguiente(n);actual.setAnterior(n);}
        tamanio++;
    }
    /** Busca por cédula y posiciona el cursor en el expediente encontrado. */
    public Expediente buscar(String cedula){
        if(actual==null)return null;NodoExpediente n=actual;
        do{if(n.getExpediente().getCedula().equalsIgnoreCase(cedula)){actual=n;return n.getExpediente();}n=n.getSiguiente();}while(n!=actual);
        return null;
    }
    /** Avanza circularmente al expediente siguiente. */
    public Expediente avanzar(){if(actual==null)return null;actual=actual.getSiguiente();return actual.getExpediente();}
    /** Retrocede circularmente al expediente anterior. */
    public Expediente retroceder(){if(actual==null)return null;actual=actual.getAnterior();return actual.getExpediente();}
    public Expediente getActual(){return actual==null?null:actual.getExpediente();}
}
