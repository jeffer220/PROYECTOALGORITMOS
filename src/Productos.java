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
        
        File f = new File("C:/PROYECTOALGORITMOSJAVA/Productos.txt");
        
        
        System.out.println("1. Agregar productos");       
        System.out.println("2. Actualizar datos del producto");
        System.out.print("Seleccione operacion a realizar: ");
        opcion = scan.nextInt();
        scan.nextLine();
        
        switch (opcion) {
            case 1: 
                    try {
                        FileWriter fw = new FileWriter(f, true); //El true indica que hay dats en el archivo para que no los borre y solo agregue datos 
                        BufferedWriter bw = new BufferedWriter(fw);
                        System.out.println("Ingrese el nombre del Producto ");
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
