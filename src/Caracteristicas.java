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
import java.util.logging.Level;
import java.util.logging.Logger;


public class Caracteristicas {

    static void Caracteristicas() {
        // TODO code application logic here
        
        Scanner scan = new Scanner(System.in);
        int opcion = 0;
        String nomCaracteristica = "";
        
        File f = new File("C:/ProyectoAlgoritmos/Caracteristicas.txt");
        
        System.out.println("1. Agregar Caracteristicas");
        System.out.println("2. Leer Caracetristicas");
        System.out.println("3. Actualizar Caracteristcias");
        System.out.println("4. Eliminar Caracteristicas");
        System.out.print("Seleccione operacion a realizar: ");
        opcion = scan.nextInt();
        
        switch (opcion) {
            
            case 1: 
                    try {
                        FileWriter fw = new FileWriter(f, true); //El true indica que hay dats en el archivo para que no los borre y solo agregue datos 
                        BufferedWriter bw = new BufferedWriter(fw);
                        System.out.println("Ingrese el nombre de la Caracteristica ");
                        nomCaracteristica = scan.nextLine();
                        bw.write(nomCaracteristica + "\n"); 
                        while (nomCaracteristica.isEmpty()) {
                            System.out.println("El nombre no puede estar en blanco");
                            System.out.println("Ingrese el nombre de la caracteristica ");
                            nomCaracteristica = scan.nextLine(); }                
                        bw.close();
                    } catch (IOException ex) {
                        Logger.getLogger(Caracteristicas.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;

            case 2: //Permite leer los datos que se encuentren en el archivo
                    try {
                        FileReader fr = new FileReader(f); //Abre un archivo para leerlo
                        BufferedReader br = new BufferedReader(fr);
                        String linea = ""; 
                        while((linea = br.readLine()) != null) { //Realiza la lectura hasta que no haya mas lineas por leer
                            System.out.println(linea);
                        } 
                        br.close();
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(Caracteristicas.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                    Logger.getLogger(Caracteristicas.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
            case 3:
                    try {
                        FileReader fr = new FileReader(f);
                        BufferedReader br = new BufferedReader(fr); //Abren el archivo
                        
                        File fc = new File("C:/ProyectoAlgoritmos/CopiaCaracteristicas.txt");
                        FileWriter fw = new FileWriter(fc);
                        BufferedWriter bw = new BufferedWriter(fw);               
                        String linea = "";
                        
                        while((linea = br.readLine()) != null) {
                            String [] datos = linea.split("\\|");
                            if (datos[0].compareTo("1234") == 0) {
                                linea = "123456|caracteristica actualizada";
                            }
                            
                            bw.write(linea+"\n");
                        } 
                        
                        bw.close();
                        br.close();
                        
                        Files.move(fc.toPath(), f.toPath(), REPLACE_EXISTING);
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(Caracteristicas.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                    Logger.getLogger(Caracteristicas.class.getName()).log(Level.SEVERE, null, ex);
                    } 
                    break;
            case 4: //Por medio del identificador verifica si es igual al que quiero eliminar y copia todos los datos en un archivo nuevo menos ek que dese eliminar
                    try {
                        FileReader fr = new FileReader(f);
                        BufferedReader br = new BufferedReader(fr); //Las primeras 2 lineas abren el archivo para lectura
                        
                       
                        File fc = new File("C:/ProyectoAlgoritmos/CopiaCaracteristicas.txt"); //
                        FileWriter fw = new FileWriter(fc);
                        BufferedWriter bw = new BufferedWriter(fw);
                        
                        String linea = "";
                        
                        while((linea = br.readLine()) != null) { //Lee el archivo original linea por linea
                            String [] datos = linea.split("\\|"); //Utiliza el split que divide la cadena en subcadenas por medio de "|" 
                            if (datos[0].compareTo("123456") != 0) { //Verifica si el elemento que tiene la posicion 0, el identificador es igual a lo del parentesis lo elimina
                                bw.write(linea+"\n"); 
                            }
                        } 
                        
                        bw.close();
                        br.close();
                        
                        Files.move(fc.toPath(), f.toPath(), REPLACE_EXISTING);
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



