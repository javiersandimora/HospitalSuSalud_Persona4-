package com.mycompany.hospitalsusalud;
/** Nodo de la cola de pacientes. */
public class Nodo {
    private Pacientes paciente;
    private Nodo siguiente;
    public Nodo() {}
    public Nodo(Pacientes paciente) { this.paciente = paciente; }
    public Pacientes getPaciente() { return paciente; }
    public Nodo getSiguiente() { return siguiente; }
    public void setPaciente(Pacientes paciente) { this.paciente = paciente; }
    public void setSiguiente(Nodo siguiente) { this.siguiente = siguiente; }
}
