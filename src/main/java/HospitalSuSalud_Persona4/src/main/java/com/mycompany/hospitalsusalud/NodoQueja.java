package com.mycompany.hospitalsusalud;
/** Nodo enlazado que almacena una queja. */
public class NodoQueja {
    private Queja queja; private NodoQueja siguiente;
    public NodoQueja(){} public NodoQueja(Queja q){queja=q;}
    public Queja getQueja(){return queja;} public NodoQueja getSiguiente(){return siguiente;}
    public void setQueja(Queja q){queja=q;} public void setSiguiente(NodoQueja n){siguiente=n;}
}
