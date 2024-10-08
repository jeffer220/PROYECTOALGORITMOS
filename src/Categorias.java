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

public class Categorias {

    static void Categorias() {
        // TODO code application logic here
        
        Scanner scan = new Scanner(System.in);
        int opcion = 0;
        String nomCategoria = "";
        File f = new File("C:/PROYECTOALGORITMOSJAVA/Categorias.txt");
        
        
        System.out.println("1. Agregar Categoria");
        System.out.println("2. Actualizar Categorias");
        System.out.println("3. Eliminar Categorias");
        System.out.print("Seleccione operacion a realizar: ");
        opcion = scan.nextInt();
        scan.nextLine();
        switch (opcion) {    
                    
            case 1:                
               try {
        FileWriter fw = new FileWriter(f, true); 
        BufferedWriter bw = new BufferedWriter(fw);
        System.out.println("Ingrese el nombre de la categoria ");
        nomCategoria = scan.nextLine();
        while (nomCategoria.isEmpty()) {
            System.out.println("El nombre no puede estar en blanco");
                System.out.println("Ingrese el nombre de la categoria ");
                    nomCategoria = scan.nextLine(); }
        bw.write(nomCategoria + "\n");
        bw.close();
    } catch (IOException ex) {
        Logger.getLogger(Categorias.class.getName()).log(Level.SEVERE, null, ex);
    }
    break;
            case 2:
                    try {
                        FileReader fr = new FileReader(f);
                        BufferedReader br = new BufferedReader(fr); //Abren el archivo
                        
                        File fc = new File("C:/PROYECTOALGORITMOSJAVA/copiaCategorias.txt"); //Crea una copia
                        FileWriter fw = new FileWriter(fc);
                        BufferedWriter bw = new BufferedWriter(fw);               
                        String linea = "";
                        
                        while((linea = br.readLine()) != null) {
                            String [] datos = linea.split("\\|");
                            if (datos[0].compareTo("1") == 0) {
                                linea = "Categoria Nueva";
                            }
                            
                            bw.write(linea+"\n");
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
            case 3: //Por medio del identificador verifica si es igual al que quiero eliminar y copia todos los datos en un archivo nuevo menos ek que dese eliminar
                    try {
                        FileReader fr = new FileReader(f);
                        BufferedReader br = new BufferedReader(fr); //Las primeras 2 lineas abren el archivo para lectura
                        
                       
                        File fc = new File("C:/PROYECTOALGORITMOSJAVA/copiaCategorias.txt"); //
                        FileWriter fw = new FileWriter(fc);
                        BufferedWriter bw = new BufferedWriter(fw);
                        
                        String linea = "";
                        
                        while((linea = br.readLine()) != null) { //Lee el archivo original linea por linea
                            String [] datos = linea.split("\\|"); //Utiliza el split que divide la cadena en subcadenas por medio de "|" 
                            if (datos[0].compareTo("1") != 0) { //Verifica si el elemento que tiene la posicion 0, el identificador es igual a lo del parentesis lo elimina
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


