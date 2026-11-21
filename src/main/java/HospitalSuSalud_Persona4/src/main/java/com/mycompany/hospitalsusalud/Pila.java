package com.mycompany.hospitalsusalud;
/** Pila LIFO para conservar las quejas recibidas. */
public class Pila {
    private NodoQueja tope;
    public Pila(){tope=null;} public NodoQueja getTope(){return tope;}
    public void apilar(Queja q){NodoQueja n=new NodoQueja(q);n.setSiguiente(tope);tope=n;}
    public Queja desapilar() throws Exception {if(estaVacia())throw new Exception("La pila esta vacia");Queja q=tope.getQueja();tope=tope.getSiguiente();return q;}
    public boolean estaVacia(){return tope==null;}
    public void imprimirPila(){if(estaVacia()){System.out.println("No hay quejas registradas.");return;}for(NodoQueja n=tope;n!=null;n=n.getSiguiente())System.out.println(n.getQueja());}
}
