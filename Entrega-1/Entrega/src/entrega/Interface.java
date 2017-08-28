/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entrega;

import javax.swing.JOptionPane;

/**
 *
 * @author aluno
 */
public class Interface {
    String scan(String mensagem)
    {
        return JOptionPane.showInputDialog(mensagem);
    }
    double input(String mensagem)
    {
        return Double.parseDouble(JOptionPane.showInputDialog(mensagem));
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