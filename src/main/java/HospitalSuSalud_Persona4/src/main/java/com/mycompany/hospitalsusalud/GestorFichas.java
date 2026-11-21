package com.mycompany.hospitalsusalud;
/** Genera consecutivos independientes para fichas regulares y preferenciales. */
public class GestorFichas {
    private int contadorPreferenciales, contadorRegulares;
    public GestorFichas(){contadorPreferenciales=0; contadorRegulares=0;}
    public String generarFichaPreferencial(){return String.format("P%03d",++contadorPreferenciales);}
    public String generarFichaRegulares(){return String.format("R%03d",++contadorRegulares);}
}
