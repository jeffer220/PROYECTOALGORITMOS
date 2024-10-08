
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

public class PROYECTOALGORITMOS {
     public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int opMenu = 0;
        
        System.out.println("1. Seccion de Categorias");
        System.out.println("2. Seccion de Caracteristicas");
        System.out.println("3. Seccion de Especificaciones");
        //System.out.println("4. Eliminar Categorias");//
        System.out.print("Seleccione la seccion que desee modificar: ");
        opMenu = scan.nextInt();
        
        
        switch (opMenu) {
            case 1:
                Categorias cat = new Categorias();
                Categorias.Categorias(); 
                break;
                
            case 2: 
                Caracteristicas caract = new Caracteristicas();
                Caracteristicas.Caracteristicas();
                break;
                
            case 3:
                Especificaciones especi = new Especificaciones();
                Especificaciones.Especificaciones();
                break;
            
        
        
        
        
        
        }
        
        
        
        
        } 
   } 

