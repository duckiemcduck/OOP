/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacote03;

/**
 *
 * @author aluno
 */
public class Pacote03 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        boolean [] arrayBool = new boolean[10];
        String [] arrayString = new String[10];
        Character [] arrayChar = {'a','b','c'};
        float [] arrayFloat = {2,(float)5.34,(float)4.23,7};
        
        System.out.println("Array Booleana:");
        for(int i = 0; i<arrayBool.length; i++)
        {
            arrayBool[i] = (i % 2 == 0);
            System.out.println(arrayBool[i]);
        }
        System.out.println("Array String:");
        for(int i = 0; i<arrayString.length; i++)
        {
            System.out.println(arrayString[i]);
        }
        System.out.println("Array Char:");
        for(int i = 0; i<arrayChar.length; i++)
        {
            System.out.println(arrayChar[i]);
        }
        System.out.println("Array Float:");
        for(int i = 0; i<arrayFloat.length; i++)
        {
            System.out.println(arrayFloat[i]);
        }
        
    }
    
}
