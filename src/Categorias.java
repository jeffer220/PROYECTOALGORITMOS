/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Categorias {

    static void Categorias() {
        // TODO code application logic here
        
        Scanner scan = new Scanner(System.in);
        int opcion = 0;
        String nomCategoria = "";
        String codigoActualizacion = "";
        String codigoEliminacion = "";
        String nuevaCat = "";
        String confirmacion = "";
       
        File f = new File("C:/PROYECTOALGORITMOSJAVA/Categorias.txt");
         
        System.out.println("Estas son las categorias existentes: ");
         try {
                        FileReader fr = new FileReader(f); //Abre un archivo para leerlo
                        BufferedReader br = new BufferedReader(fr);
                        String linea = ""; 
                        while((linea = br.readLine()) != null) { //Realiza la lectura hasta que no haya mas lineas por leer
                            System.out.println(linea);
                        } 
                        br.close();
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(Categorias.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                    Logger.getLogger(Categorias.class.getName()).log(Level.SEVERE, null, ex);
                    }

         
        System.out.println("1. Agregar Categoria");
        System.out.println("2. Actualizar Categorias");
        System.out.println("3. Eliminar Categorias");
        System.out.print("Seleccione operacion a realizar: ");
        opcion = scan.nextInt();
       
        scan.nextLine();
        switch (opcion) {    
                    
            case 1:                
               try {
        //Abre el archivo y lo ejecuta para que se pueda escribir en el
        FileWriter fw = new FileWriter(f, true); 
        BufferedWriter bw = new BufferedWriter(fw);
        //Se le pide al usuario ingresar el codigo y el nombre de la categoria
        System.out.println("Ingrese el codigo y nombre de la categoria separados por | ");
        nomCategoria = scan.nextLine();
        // Especifica el delimitador
       String delimitador = "|"; 
       //Utiliza la clase Tokenizer para dividir la cadena en partes delimitadas por "|"
       StringTokenizer tokenizer = new StringTokenizer(nomCategoria, delimitador);
       //El ciclo while evalua que el usuario no deje en blanco el nombre de la categoria
        while (nomCategoria.isEmpty()) {
            //Se le notifica al usuario que no se debe dejar en blanco el nombre
            System.out.println("El nombre de la categoria no puede estar en blanco");
            //Se le pide de nuevo al usuario las veces que sean necesarias que ingrese un nombre valido
                System.out.println("Ingrese el nombre de la categoria ");
                    nomCategoria = scan.nextLine(); }
        //Escribe el nombre de la categoria ingresada en el archivo
        bw.write(nomCategoria + "\n");
        //Cierra el BufferedWriter para asegurarse de que todos los datos se escriban en el archivo.
        bw.close();
        } catch (IOException ex) {
        Logger.getLogger(Categorias.class.getName()).log(Level.SEVERE, null, ex);
        }
          break;
    
            case 2:
                    try {
                        //Abre el archivo y lo ejecuta para que pueda escribir en el
                        FileReader fr = new FileReader(f);
                        BufferedReader br = new BufferedReader(fr); 
                        //Crea un nuevo archivo llamado copiaCategorias.txt en la ruta especificada
                        File fc = new File("C:/PROYECTOALGORITMOSJAVA/copiaCategorias.txt"); //Crea una copia
                        //Crea un FileWriter para escribir en el archivo
                        FileWriter fw = new FileWriter(fc);
                        BufferedWriter bw = new BufferedWriter(fw); 
                        //Se declara la variable linea para que se lean todas las lineas existentes
                        String linea = "";  
                        //Se le pide al usuario ingresar el codigo correspondiente a la categoria
                        System.out.println("Ingrese el codigo");
                            codigoActualizacion = scan.nextLine(); 
                            // el ciclo while lee cada línea del archivo original hasta que no haya más líneas
                           while((linea = br.readLine()) != null) { 
                               // Divide la línea leída en un arreglo de Strings usando el carácter '|' como delimitador
                            String [] datos = linea.split("\\|");  
                            //Compara la primer division delimitada por "|" con el codigo ingresado por el usuario
                            if (datos[0].compareTo(codigoActualizacion) == 0) {
                                //Solicita al usuario que ingrese el nuevo codigo y nombre de la categoria
                                System.out.println("Ingrese el codigo y el nombre actualizado separados por |");
                                nuevaCat = scan.nextLine();
                                //El ciclo while evalua que el nuevo nombre de la categoria no este vacio
                                while (nuevaCat.isEmpty()) {
                                    //Se le notifica al usuario que el nombre no puede estar en blanco
                                System.out.println("El nombre de la nueva categoria no puede estar en blanco");
                                //Se le pide al usuario que ingrese un nombre valido las veces necesarias
                                System.out.println("Ingrese el codigo y el nombre actualizado separados por |");
                                nuevaCat = scan.nextLine();
                                }
                                //Actualiza la línea con la nueva categoría ingresada por el usuario
                                linea = nuevaCat;
                            }
                            //Escribe la categoria modificada en el archivo
                            bw.write(linea+"\n");
                        } 
                        //Cierra el BufferedWriter para asegurarse de que todos los datos se escriban en el archivo
                        bw.close();
                        br.close();
                        //Mueve el archivo de copia a la ubicación del archivo original, reemplazando el archivo original si ya existe
                        Files.move(fc.toPath(), f.toPath(), REPLACE_EXISTING);
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(Categorias.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                    Logger.getLogger(Categorias.class.getName()).log(Level.SEVERE, null, ex);
                    } 
                    break;
                    
            case 3: //Por medio del identificador verifica si es igual al que quiero eliminar y copia todos los datos en un archivo nuevo menos ek que dese eliminar
                    try {
                        FileReader fr = new FileReader(f);
                        BufferedReader br = new BufferedReader(fr); //Las primeras 2 lineas abren el archivo para lectura
                        
                       
                        File fc = new File("C:/PROYECTOALGORITMOSJAVA/copiaCategorias.txt"); //
                        FileWriter fw = new FileWriter(fc);
                        BufferedWriter bw = new BufferedWriter(fw);
                        
                        String linea = "";
                        System.out.println("Ingrese el codigo");
                         codigoEliminacion = scan.nextLine();  
                         
                          System.out.println("Desea eliminar la Categoria? (Si/No) ");
                         confirmacion = scan.nextLine();
                        if (!confirmacion.equalsIgnoreCase("si")) {
                            System.out.println("Eliminacion Cancelada");
                            return;
                        }
                         
                        while((linea = br.readLine()) != null) { //Lee el archivo original linea por linea
                            String [] datos = linea.split("\\|"); //Utiliza el split que divide la cadena en subcadenas por medio de "|" 
                            if (datos[0].compareTo(codigoEliminacion) != 0) { //Verifica si el elemento que tiene la posicion 0, el identificador es igual a lo del parentesis lo elimina
                                bw.write(linea+"\n"); 
                            }
                        } 
                        
                        bw.close();
                        br.close();
                        
                        Files.move(fc.toPath(), f.toPath(), REPLACE_EXISTING);
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(Categorias.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                    Logger.getLogger(Categorias.class.getName()).log(Level.SEVERE, null, ex);
                    } 
                    break;
            default: System.out.println("Ingrese una opción válida.");
        }
    }
    
}


