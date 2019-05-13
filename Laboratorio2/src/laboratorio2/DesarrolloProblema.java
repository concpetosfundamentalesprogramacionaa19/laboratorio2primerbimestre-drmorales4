/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laboratorio2;

import java.util.Scanner;

/**
 *
 * @author drmorales4
 */
public class DesarrolloProblema {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Scanner entrada = new Scanner(System.in);
        
        // declaracion de variables
        String nombre;
        String apellido;
        String mensajeFinal;
        
        boolean continuar = true; // utilice un bool para poner la condicion en el ciclo
        
        double sueldo,pasaje,bar,salida;
        double suma1, suma2, suma3, suma_total;
        int hijos, reporte, eleccion;
        
        reporte = 1;
        
        while (continuar == true ){ // ciclo para poder ingresar datos de diferentes personas y asi hacer varios reportes
            
            suma_total = 0; // inicializamos algunas variables
            suma1= 0;
            suma2 = 0;
            suma3 = 0;
            eleccion = 0;
            
            mensajeFinal = "";
                
            mensajeFinal = String.format("%s%s\n\nReporte 00%d\n\n", // encabezado
                    mensajeFinal, "Reporte Gastos de Padres de Familia", 
                    reporte);

            System.out.println("Ingrese los Nombres del Padre de Familia"); // se ingresa los nombres del padre de familia
            nombre = entrada.nextLine();
            System.out.println("Ingrese los Apellidos del Padre de Familia"); // se ingresa los apellidos del padre de familia
            apellido = entrada.nextLine();
            System.out.println("Ingrese Sueldo semanal del Padre de familia"); // se ingresa el sueldo semanal del padre de familia
            sueldo = entrada.nextDouble();
            System.out.println("Ingrese el numero de hijos"); // se ingresa el numero de hijos que tiene el padre de familia
            hijos = entrada.nextInt();

            mensajeFinal = String.format("%sNombre de Padre de Familia: %s %s " // para mostrar en pantalla luego los datos del padre de familia
                    + "\nSueldo Semanal: $%.3f \nNúmero de Hijos: %d \n\n%s\n"
                    + "Persona \t Pasaje \tBar \t Salidas\n", mensajeFinal, // los titulos de la tabla
                    nombre, apellido, sueldo, hijos, "Reporte de Gastos");

            for (int i = 1; i <= hijos; i++) { // ciclo for para poder ingresar los datos de los hijos empezando en 1

                System.out.printf("Ingrese el gasto del Pasaje del Hijo " // ingresar el gasto del pasaje 
                        + "%d:\n",i);
                pasaje = entrada.nextDouble();
                System.out.printf("Ingrese el gasto del Bar del Hijo %d:" // ingresar el gasto en el bar
                        + "\n",i);
                bar = entrada.nextDouble();
                System.out.printf("Ingrese el gasto de Salidas del Hijo " // ingresar el gasto de salidas
                        + "%d:\n",i);
                salida = entrada.nextDouble();

                suma1 = pasaje + suma1; // calculo la suma de todos los pasajes de los hijos
                suma2 = bar + suma2; // calculo la suma del bar de todos de los hijos
                suma3 = salida + suma3; // calculo la suma de todos las salidas de los hijos

                mensajeFinal = String.format("%s Hijo %d \t %.2f \t\t%.2f \t "
                        + "%.2f\n", mensajeFinal, i, pasaje, bar, salida); // para mostrar luego en pantalla los gastos ingresados

            }
            mensajeFinal = String.format("%sTotales \t %.2f \t\t%.2f \t %.2f"
                    + "\n", mensajeFinal, suma1, suma2, suma3); // para mostrar los totales de pasaje, bar y salidas

            suma_total = suma1 + suma2 + suma3;

            if (suma_total <= sueldo) { // condicion
                System.out.println("\n-----------------------------------------"
                        + "-------------------------------------------------"); // lineas de separacion

                mensajeFinal = String.format("%sEl padre de familia %s %s le "
                        + "alcanza el dinero semanal, para sus gastos\n\nFin "
                        + "reporte 00%d\n",mensajeFinal, nombre, apellido, 
                        reporte); // si el sueldo es mayor que la suma total de todos los gastos de los hijos
                                  // imprimira que el sueldo si le 'alcanza' para sus gastos

                System.out.printf("%s", mensajeFinal); // impresion en pantalla

            }else{
                System.out.println("\n----------------------------------------"
                        + "--------------------------------------------------"); // lineas de separacion
                mensajeFinal = String.format("%sEl padre de familia %s %s le "
                        + "falta el dinero semanal, para sus gastos\n\nFin "
                        + "reporte 00%d\n",mensajeFinal, nombre, apellido, 
                        reporte);// si el sueldo es menor que la suma total de todos los gastos de los hijos
                                  // imprimira que el sueldo le 'falta' para sus gastos
                                  
                System.out.printf("%s", mensajeFinal); // impresion en pantalla

            }
            System.out.println("----------------------------------------------"
                    + "--------------------------------------------"); // lineas de separacion
            
           
            System.out.printf("Desea continuar ingresando datos y creando " // preguntamos si desea continuar
                    + "reporte?\n1. SI \n2. NO\n");
            eleccion = entrada.nextInt();
            
            while(eleccion < 1 || eleccion > 2){ // si la repuesta es incorrecta
                System.out.println("Seleccione una opcion correcta (1 o 2)"); // entrara en este ciclo hasta que dijiste una repuesta correcta
                eleccion = entrada.nextInt();
            }
            
            if (eleccion == 1) { // si la repuesta es SI (1), volvera a repetirse el ciclo
                continuar = true; // pidiendo datos de nuevo para hacer otro reporte
                
            }else{
                continuar = false; // si la respuesta es NO (2), 'continuar' se hace falso y saldra del ciclo
            }
            
            reporte = reporte + 1; // sumo 1 a reporte para luego mostrar el numero de reporte que vamos
            
            entrada.nextLine();  // limpieza de buffer de entrada de datos
            System.out.println("----------------------------------------------"
                    + "--------------------------------------------\n"); // lineas de separacion
         
        }
        
        
    }
    
}
