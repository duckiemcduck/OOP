/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacote02;

/**
 *
 * @author aluno
 */
public class Pacote02 {
    public static void main(String[] args) {
        Exemplo obj = new Exemplo();
        System.out.println(obj.equals(obj));
        System.out.println(obj.getClass());
        System.out.println(obj.hashCode());
        System.out.println(obj.toString());
        //obj.notify();
        //obj.notifyAll();
        //obj.wait();
    }
    
}
