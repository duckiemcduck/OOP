/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacote02;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aluno
 */
public class Pacote02 {
    public static void main(String[] args){
        Exemplo obj = new Exemplo();
        System.out.println(obj.equals(obj));
        
        System.out.println(obj.hashCode());
        System.out.println(obj.toString());
        ////////////
        try {
            Object clone = obj.clone();
        } catch (CloneNotSupportedException ex) {
            Logger.getLogger(Pacote02.class.getName()).log(Level.SEVERE, null, ex);
        }
        ////////////
        try {
            obj.finalize();
        } catch (Throwable ex) {
            Logger.getLogger(Pacote02.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
