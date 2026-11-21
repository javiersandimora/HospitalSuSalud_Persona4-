package com.mycompany.hospitalsusalud;
import java.util.Date;
import java.util.Scanner;
/** Punto de entrada y menús del sistema Hospital Su Salud, versión 2.0. */
public class HospitalSuSalud {
    private static final Scanner teclado=new Scanner(System.in);
    private static final GestionPacientes gestionPacientes=new GestionPacientes();
    private static final GestionQuejas gestionQuejas=new GestionQuejas();
    private static final Bitacora bitacora=new Bitacora();
    private static final GestionExpedientes gestionExpedientes=new GestionExpedientes();
    public static void main(String[] args){System.out.println("HOSPITAL SU SALUD - Sistema de Gestión de Pacientes");menuPrincipal();}
    /** Presenta las opciones principales del sistema. */
    public static void menuPrincipal(){
        int op;
        do{
            System.out.println("\n=== MENU PRINCIPAL ===");
            System.out.println("1. Gestionar Llegada de Pacientes");
            System.out.println("2. Consulta de Bitácora de Citas del día");
            System.out.println("3. Consulta de Expediente único de Pacientes");
            System.out.println("4. Ayuda");
            System.out.println("5. Salir");
            op=leerInt("Seleccione una opción: ");
            switch(op){
                case 1->menuGestionarLlegada();
                case 2->{bitacora.mostrar();pausar();}
                case 3->consultarExpedientes();
                case 4->{mostrarAyuda();pausar();}
                case 5->System.out.println("Gracias por utilizar Hospital Su Salud.");
                default->{System.out.println("Opción inválida.");}
            }
        }while(op!=5);
    }
    private static void menuGestionarLlegada(){
        int op;
        do{
            System.out.println("\n=== GESTIONAR LLEGADA ===");
            System.out.println("1. Seleccionar ficha");System.out.println("2. Atender paciente");
            System.out.println("3. Abandonar cola");System.out.println("4. Mostrar fichas pendientes");
            System.out.println("5. Mostrar quejas");System.out.println("6. Regresar");
            op=leerInt("Opción: ");
            switch(op){
                case 1->seleccionarFicha();case 2->atenderPaciente();case 3->abandonarCola();
                case 4->{System.out.println("Preferenciales:");gestionPacientes.mostrarColaPreferencia();System.out.println("Regulares:");gestionPacientes.mostrarColaRegular();pausar();}
                case 5->{gestionQuejas.mostrarQuejas();pausar();}case 6->{}default->System.out.println("Opción inválida.");
            }
        }while(op!=6);
    }
    private static void seleccionarFicha(){
        String tipo=leerTexto("Tipo (1 regular / 2 preferencial): ");
        if(!tipo.equals("1")&&!tipo.equals("2")){System.out.println("Tipo inválido.");return;}
        Pacientes p=new Pacientes();p.setCedula(leerTexto("Cédula: "));p.setNombre(leerTexto("Nombre completo: "));
        p.setPreferencial(tipo.equals("2"));gestionPacientes.registrarPaciente(p);
        System.out.println("Ficha asignada: "+p.getNumeroFicha());pausar();
    }
    private static void atenderPaciente(){
        try{
            Pacientes p=gestionPacientes.atenderSiguiente();
            if(p==null){System.out.println("No hay pacientes pendientes.");pausar();return;}
            Date atencion=new Date();
            System.out.println("Ficha: "+p.getNumeroFicha()+" | Paciente: "+p.getNombre()+" | Cédula: "+p.getCedula());
            String doctor=leerTexto("Nombre del doctor: ");
            String diagnostico=leerTexto("Diagnóstico: ");
            Cita cita=new Cita(p,doctor,diagnostico,atencion);bitacora.registrar(cita);
            Expediente e=gestionExpedientes.obtenerOCrear(p.getCedula(),p.getNombre());
            e.agregarRegistro("Cita "+atencion+" | Doctor: "+doctor+" | Diagnóstico: "+diagnostico+" | Espera: "+cita.getEsperaSegundos()+" s");
            System.out.println("Cita registrada. Tiempo de espera: "+cita.getEsperaSegundos()+" segundos.");
            System.out.println("Expediente actualizado: "+e);
        }catch(Exception ex){System.out.println("Error al atender: "+ex.getMessage());}
        pausar();
    }
    private static void abandonarCola(){
        String ficha=leerTexto("Número de ficha: "),motivo=leerTexto("Motivo del abandono: ");
        System.out.println(gestionQuejas.abandonarCola(gestionPacientes,ficha,motivo));pausar();
    }
    /** Permite consultar un expediente y navegar hacia adelante o atrás circularmente. */
    public static void consultarExpedientes(){
        String cedula=leerTexto("Ingrese la cédula del paciente: ");
        Expediente e=gestionExpedientes.buscar(cedula);
        if(e==null){System.out.println("No existe expediente para esa cédula.");pausar();return;}
        int op;
        do{
            mostrarExpediente(e);
            System.out.println("1. Siguiente expediente");System.out.println("2. Expediente anterior");System.out.println("3. Buscar otra cédula");System.out.println("4. Regresar al menú");
            op=leerInt("Opción: ");
            switch(op){
                case 1->{e=gestionExpedientes.avanzar();if(e==null)System.out.println("Lista vacía.");}
                case 2->{e=gestionExpedientes.retroceder();if(e==null)System.out.println("Lista vacía.");}
                case 3->{String otra=leerTexto("Cédula: ");e=gestionExpedientes.buscar(otra);if(e==null)System.out.println("Expediente no encontrado.");}
                case 4->{}
                default->System.out.println("Opción inválida.");
            }
        }while(op!=4);
    }
    private static void mostrarExpediente(Expediente e){
        System.out.println("\n--- EXPEDIENTE ÚNICO ---");System.out.println(e);
        if(e.getHistorial().isEmpty())System.out.println("Sin citas registradas.");
        else for(String r:e.getHistorial())System.out.println(" • "+r);
    }
    /** Muestra las instrucciones, integrantes y versión del sistema. */
    public static void mostrarAyuda(){
        System.out.println("\n=== AYUDA ===");
        System.out.println("Hospital Su Salud - Sistema de Gestión de Pacientes");
        System.out.println("Versión: 2.0 (Avance 2)");
        System.out.println("\nINTEGRANTES:");
        System.out.println("- Emily");
        System.out.println("- vvictogo");
        System.out.println("- XSF");
        System.out.println("- GO-0140");
        System.out.println("\nOPCIONES:");
        System.out.println("1. Gestionar llegada: registra, atiende y retira pacientes.");
        System.out.println("2. Bitácora: consulta las citas del día y sus tiempos de espera.");
        System.out.println("   Verde: 1 a 30 s; amarillo: más de 30 y hasta 60 s; rojo: más de 60 s.");
        System.out.println("3. Expediente único: consulta el historial clínico y navega circularmente");
        System.out.println("   al siguiente o anterior expediente.");
        System.out.println("Los expedientes se identifican por cédula para evitar duplicados.");
    }
    private static int leerInt(String mensaje){
        while(true){System.out.print(mensaje);String s=teclado.nextLine().trim();try{return Integer.parseInt(s);}catch(NumberFormatException ex){System.out.println("Ingrese un número válido.");}}
    }
    private static String leerTexto(String mensaje){System.out.print(mensaje);return teclado.nextLine().trim();}
    private static void pausar(){System.out.println("\nPresione Enter para continuar...");teclado.nextLine();}
}
