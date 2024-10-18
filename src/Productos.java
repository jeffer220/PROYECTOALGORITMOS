/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

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

public class Productos {
    static void Productos(){
     Scanner scan = new Scanner(System.in);
        int opcion = 0;
        String nomProducto = "";
        String codProdNuevo = "";
        String nuevoProducto = "";
        String codEliminacion = "";
        String confirmacion = "";
        File f = new File("C:/PROYECTOALGORITMOSJAVA/Productos.txt");
        
        
        System.out.println("1. Agregar productos");       
        System.out.println("2. Eliminar productos");
        System.out.print("Seleccione operacion a realizar: ");
        opcion = scan.nextInt();
        scan.nextLine();
        
        switch (opcion) {
            case 1: 
                    try {
                        FileWriter fw = new FileWriter(f, true); //El true indica que hay dats en el archivo para que no los borre y solo agregue datos 
                        BufferedWriter bw = new BufferedWriter(fw);
                        System.out.println("Ingrese el codigo, nombre del Producto, descripcion y precio separados por | ");
                        nomProducto = scan.nextLine(); 
                       
                        
                         String delimitador = "|"; // Especifica el delimitador
                        StringTokenizer tokenizer = new StringTokenizer(nomProducto, delimitador);
                        while (nomProducto.isEmpty()) {
                             System.out.println("El nombre del producto no puede estar en blanco");
                             System.out.println("Ingrese el nombre del producto ");
                             nomProducto = scan.nextLine(); }
                        bw.write(nomProducto + "\n");
                        
                        bw.close();
                    } catch (IOException ex) {
                        Logger.getLogger(Productos.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                    
                    case 2: //Por medio del identificador verifica si es igual al que quiero eliminar y copia todos los datos en un archivo nuevo menos ek que dese eliminar
                    try {
                        FileReader fr = new FileReader(f);
                        BufferedReader br = new BufferedReader(fr); //Las primeras 2 lineas abren el archivo para lectura
                        
                       
                        File fc = new File("C:/PROYECTOALGORITMOSJAVA/copiaProductos.txt"); //
                        FileWriter fw = new FileWriter(fc);
                        BufferedWriter bw = new BufferedWriter(fw);
                        
                        String linea = "";
                        System.out.println("Ingrese el codigo");
                         codEliminacion = scan.nextLine(); 
                         
                          System.out.println("Desea eliminar el producto? (Si/No) ");
                         confirmacion = scan.nextLine();
                        if (!confirmacion.equalsIgnoreCase("si")) {
                            System.out.println("Eliminacion Cancelada");
                            return;
                        }
                         
                        while((linea = br.readLine()) != null) { //Lee el archivo original linea por linea
                            String [] datos = linea.split("\\|"); //Utiliza el split que divide la cadena en subcadenas por medio de "|" 
                            if (datos[0].compareTo(codEliminacion) != 0) { //Verifica si el elemento que tiene la posicion 0, el identificador es igual a lo del parentesis lo elimina
                                bw.write(linea+"\n"); 
                            }
                        } 
                        
                        bw.close();
                        br.close();
                        
                        Files.move(fc.toPath(), f.toPath(), REPLACE_EXISTING);
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(Productos.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                    Logger.getLogger(Productos.class.getName()).log(Level.SEVERE, null, ex);
                    } 
                    break;
                    
                    /*case 2:
                    try {
                        FileReader FR = new FileReader(f);
                        BufferedReader br = new BufferedReader(FR); //Abren el archivo
                        
                        File fcarac = new File("C:/PROYECTOALGORITMOSJAVA/copiaProductos.txt");
                        FileWriter FW = new FileWriter(fcarac);
                        BufferedWriter bw = new BufferedWriter(FW);               
                        String linea = "";
                        System.out.println("Ingrese el codigo");
                            codProdNuevo = scan.nextLine();
                        
                        while((linea = br.readLine()) != null) {
                            String [] datos = linea.split("\\|");
                            if (datos[0].compareTo(codProdNuevo) == 0) {
                                 System.out.println("Ingrese el codigo y el nombre actualizado separados por |");
                                nuevoProducto = scan.nextLine();
                                while (nuevoProducto.isEmpty()) {
                                System.out.println("El nombre del producto no puede estar en blanco");
                                System.out.println("Ingrese el codigo y el nombre actualizado separados por |");
                                nuevoProducto = scan.nextLine();
                                }
                                linea = nuevoProducto;                               
                            }                           
                            bw.write(linea+"\n");
                        }                         
                        bw.close();
                        br.close();
                        
                        Files.move(fcarac.toPath(), f.toPath(), REPLACE_EXISTING);
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(Caracteristicas.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                    Logger.getLogger(Productos.class.getName()).log(Level.SEVERE, null, ex);
                    } 
                      break;*/
        }
    }
}
