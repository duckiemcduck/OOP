/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desafio;

import javax.swing.JOptionPane;

/**
 *
 * @author aluno
 */
public class Interface {
    
    int input(String mensagem)
    {
        return Integer.parseInt(JOptionPane.showInputDialog(mensagem));
    }
    void log(int mensagem)
    {
        System.out.println(Integer.toString(mensagem));
    }
    void log(double mensagem)
    {
        System.out.println(Double.toString(mensagem));
    }
    void log(String mensagem)
    {
        System.out.println(mensagem);
    }
}
