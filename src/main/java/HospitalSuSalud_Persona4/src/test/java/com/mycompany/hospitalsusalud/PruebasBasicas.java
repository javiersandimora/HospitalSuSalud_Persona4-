package com.mycompany.hospitalsusalud;
/** Pruebas básicas ejecutables sin bibliotecas externas. */
public class PruebasBasicas {
    public static void main(String[] args) {
        ListaDobleCircular lista = new ListaDobleCircular();
        Expediente a = new Expediente("1","A"), b = new Expediente("2","B");
        lista.agregar(a); lista.agregar(b);
        if (!lista.avanzar().getCedula().equals("2")) throw new AssertionError("Avance circular");
        if (!lista.avanzar().getCedula().equals("1")) throw new AssertionError("Retorno circular");
        if (!lista.retroceder().getCedula().equals("2")) throw new AssertionError("Retroceso circular");
        GestionExpedientes gestion = new GestionExpedientes();
        gestion.obtenerOCrear("123","Paciente");
        gestion.obtenerOCrear("123","Paciente duplicado");
        if (gestion.getCantidad()!=1) throw new AssertionError("Expediente duplicado");
        System.out.println("Pruebas básicas superadas.");
    }
}
