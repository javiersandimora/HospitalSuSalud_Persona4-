package com.mycompany.hospitalsusalud;
/** Cola FIFO enlazada para almacenar pacientes. */
public class Cola {
    private Nodo frente, fin;
    public Cola() { frente=null; fin=null; }
    public Nodo getFrente(){return frente;}
    public Nodo getFin(){return fin;}
    /** Agrega un paciente al final de la cola. */
    public void encolar(Pacientes paciente) {
        if (paciente == null) throw new IllegalArgumentException("El paciente no puede ser null.");
        Nodo nuevo=new Nodo(paciente);
        if(fin!=null) fin.setSiguiente(nuevo); else frente=nuevo;
        fin=nuevo;
    }
    /** Retira y devuelve el primer paciente. */
    public Pacientes desencolar() throws Exception {
        if(estaVacia()) throw new Exception("La cola esta vacia");
        Pacientes p=frente.getPaciente(); frente=frente.getSiguiente();
        if(frente==null) fin=null;
        return p;
    }
    public boolean estaVacia(){return frente==null;}
    public void imprimirCola(){
        if(estaVacia()){System.out.println("La cola esta vacia."); return;}
        Nodo actual=frente;
        while(actual!=null){Pacientes p=actual.getPaciente(); System.out.println(p.getNumeroFicha()+" - "+p.getNombre()+" - "+p.getCedula()); actual=actual.getSiguiente();}
    }
    /** Elimina una ficha de la cola y devuelve su paciente, o null si no existe. */
    public Pacientes eliminarPorFicha(String ficha) {
        Nodo actual=frente, anterior=null;
        while(actual!=null){
            if(actual.getPaciente().getNumeroFicha().equalsIgnoreCase(ficha)){
                if(anterior==null) frente=actual.getSiguiente(); else anterior.setSiguiente(actual.getSiguiente());
                if(actual==fin) fin=anterior;
                return actual.getPaciente();
            }
            anterior=actual; actual=actual.getSiguiente();
        }
        return null;
    }
}
