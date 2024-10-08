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

/**
 *
 * @author miguelcatalan
 */
public class Especificaciones {

    static void Especificaciones() {
        // TODO code application logic here
        
        Scanner scan = new Scanner(System.in);
        int opcion = 0;
        
        File f = new File("archivo_texto.txt");
        
        System.out.println("1. Agregar especificaciones");
        System.out.println("2. Leer especificaciones");
        System.out.println("3. Actualizar especificaciones");
        System.out.println("4. Eliminar especificaciones");
        System.out.print("Seleccione operacion a realizar: ");
        opcion = scan.nextInt();
        
        switch (opcion) {
            case 1: 
                    try {
                        FileWriter fw = new FileWriter(f, true); //El true indica que hay dats en el archivo para que no los borre y solo agregue datos 
                        BufferedWriter bw = new BufferedWriter(fw);
                        bw.write("654321|ESPECIFICACION AGREGADA|\n");
                        bw.close();
                    } catch (IOException ex) {
                        Logger.getLogger(Especificaciones.class.getName()).log(Level.SEVERE, null, ex);
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
                        Logger.getLogger(Especificaciones.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                    Logger.getLogger(Especificaciones.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
            case 3:
                    try {
                        FileReader fr = new FileReader(f);
                        BufferedReader br = new BufferedReader(fr); //Abren el archivo
                        
                        File fc = new File("archivo_texto_copia.txt"); //Crea una copia
                        FileWriter fw = new FileWriter(fc);
                        BufferedWriter bw = new BufferedWriter(fw);               
                        String linea = "";
                        
                        while((linea = br.readLine()) != null) {
                            String [] datos = linea.split("\\|");
                            if (datos[0].compareTo("12345") == 0) {
                                linea = "123456|ESPECIFICACION ACTUALIZADA";
                            }
                            
                            bw.write(linea+"\n");
                        } 
                        
                        bw.close();
                        br.close();
                        
                        Files.move(fc.toPath(), f.toPath(), REPLACE_EXISTING);
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(Especificaciones.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                    Logger.getLogger(Especificaciones.class.getName()).log(Level.SEVERE, null, ex);
                    } 
                    break;
            case 4: //Por medio del identificador verifica si es igual al que quiero eliminar y copia todos los datos en un archivo nuevo menos ek que dese eliminar
                    try {
                        FileReader fr = new FileReader(f);
                        BufferedReader br = new BufferedReader(fr); //Las primeras 2 lineas abren el archivo para lectura
                        
                       
                        File fc = new File("archivo_texto_copia.txt"); //
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
                        Logger.getLogger(Especificaciones.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                    Logger.getLogger(Especificaciones.class.getName()).log(Level.SEVERE, null, ex);
                    } 
                    break;
            default: System.out.println("Ingrese una opción válida.");
        }
    }
    
}


