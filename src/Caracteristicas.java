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


public class Caracteristicas {

    static void Caracteristicas() {
        // TODO code application logic here
        
        Scanner scan = new Scanner(System.in);
        int opcion = 0;
        String codActuCarac = "";
        String nomCaracteristica = "";
        String nuevaCarac = "";
        String codigoEliminacion = "";
        
        File carac = new File("C:/PROYECTOALGORITMOSJAVA/Caracteristicas.txt");
        
        System.out.println("1. Agregar Caracteristicas");
        System.out.println("2. Actualizar Caracteristcias");
        System.out.println("3. Eliminar Caracteristicas");
        System.out.print("Seleccione operacion a realizar: ");
        opcion = scan.nextInt();
        scan.nextLine();
        switch (opcion) {
            
            case 1: 
                    try {
                        FileWriter FW = new FileWriter(carac, true);  
                        BufferedWriter BW = new BufferedWriter(FW);
                       System.out.println("Ingrese el codigo y nombre de la categoria separados por | ");
                        nomCaracteristica = scan.nextLine();
                     String delimitador = "|"; // Especifica el delimitador
                        StringTokenizer tokenizer = new StringTokenizer(nomCaracteristica, delimitador);
                        while (nomCaracteristica.isEmpty()) {
                             System.out.println("El nombre de la caracteristica no puede estar en blanco");
                             System.out.println("Ingrese el nombre de la caracteristica ");
                             nomCaracteristica = scan.nextLine(); }
                    BW.write(nomCaracteristica + "\n");
                    BW.close();
                } catch (IOException ex) {
                Logger.getLogger(Caracteristicas.class.getName()).log(Level.SEVERE, null, ex);
            }
                break;    
            case 2:
                    try {
                        FileReader FR = new FileReader(carac);
                        BufferedReader br = new BufferedReader(FR); //Abren el archivo
                        
                        File fcarac = new File("C:/PROYECTOALGORITMOSJAVA/CopiaCaracteristicas.txt");
                        FileWriter FW = new FileWriter(fcarac);
                        BufferedWriter bw = new BufferedWriter(FW);               
                        String linea = "";
                        System.out.println("Ingrese el codigo");
                            codActuCarac = scan.nextLine();
                        
                        while((linea = br.readLine()) != null) {
                            String [] datos = linea.split("\\|");
                            if (datos[0].compareTo(codActuCarac) == 0) {
                                 System.out.println("Ingrese el codigo y el nombre actualizado separados por |");
                                nuevaCarac = scan.nextLine();
                                while (nuevaCarac.isEmpty()) {
                                System.out.println("El nombre de la nueva caracteristica no puede estar en blanco");
                                System.out.println("Ingrese el codigo y el nombre actualizado separados por |");
                                nuevaCarac = scan.nextLine();
                                }
                                linea = nuevaCarac;                               
                            }                           
                            bw.write(linea+"\n");
                        }                         
                        bw.close();
                        br.close();
                        
                        Files.move(fcarac.toPath(), carac.toPath(), REPLACE_EXISTING);
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(Caracteristicas.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                    Logger.getLogger(Caracteristicas.class.getName()).log(Level.SEVERE, null, ex);
                    } 
                    break;
                    
            case 3: //Por medio del identificador verifica si es igual al que quiero eliminar y copia todos los datos en un archivo nuevo menos ek que dese eliminar
                    try {
                        FileReader fr = new FileReader(carac);
                        BufferedReader br = new BufferedReader(fr); //Las primeras 2 lineas abren el archivo para lectura
                        
                       
                        File fc = new File("C:/PROYECTOALGORITMOSJAVA/CopiaCaracteristicas.txt"); //
                        FileWriter fw = new FileWriter(fc);
                        BufferedWriter bw = new BufferedWriter(fw);
                        
                        String linea = "";
                        System.out.println("Ingrese el codigo");
                         codigoEliminacion = scan.nextLine(); 
                        
                        while((linea = br.readLine()) != null) { //Lee el archivo original linea por linea
                            String [] datos = linea.split("\\|"); //Utiliza el split que divide la cadena en subcadenas por medio de "|" 
                            if (datos[0].compareTo(codigoEliminacion) != 0) { //Verifica si el elemento que tiene la posicion 0, el identificador es igual a lo del parentesis lo elimina
                                bw.write(linea+"\n"); 
                            }
                        } 
                        
                        bw.close();
                        br.close();
                        
                        Files.move(fc.toPath(), carac.toPath(), REPLACE_EXISTING);
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(Caracteristicas.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                    Logger.getLogger(Caracteristicas.class.getName()).log(Level.SEVERE, null, ex);
                    } 
                    break;
            default: System.out.println("Ingrese una opción válida.");
        }
    }
    
}



