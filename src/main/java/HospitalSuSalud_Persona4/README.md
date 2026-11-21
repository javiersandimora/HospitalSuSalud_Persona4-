# Hospital Su Salud — Persona 4 (Avance 2)

Proyecto Java/Maven integrado. Requiere JDK 17 o superior.

## Ejecutar
Desde esta carpeta:
```bash
mvn clean package
mvn exec:java -Dexec.mainClass=com.mycompany.hospitalsusalud.HospitalSuSalud
```
Si no se tiene el plugin exec instalado, ejecutar la clase `HospitalSuSalud` desde NetBeans/IntelliJ.

## Funciones de Persona 4
- Consulta de bitácora diaria con tiempo de espera calculado desde la llegada hasta la atención.
- Clasificación: verde 1–30 s; amarillo >30–60 s; rojo >60 s. La salida usa códigos ANSI en terminales compatibles.
- Expediente único por cédula, con navegación circular doble.
- Menú principal y ayuda actualizados a versión 2.0.

## Nota de integración
El ZIP de entrada contenía un ejemplo separado de árbol binario. Este proyecto se armó con el código fuente de Hospital Su Salud pegado en la conversación y las funciones solicitadas. Los integrantes en Ayuda se tomaron de los autores/nombres presentes en el material: Emily, vvictogo, XSF y GO-0140; confirmar/cambiar si la lista oficial del grupo es distinta.
