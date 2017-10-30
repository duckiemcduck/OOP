/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desafio2;

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
    int input(String mensagem)
    {
        return Integer.parseInt(JOptionPane.showInputDialog(mensagem));
    }
    String log(int mensagem)
    {
        System.out.println(Integer.toString(mensagem));
        return Integer.toString(mensagem) + "\n";
    }
    String log(double mensagem)
    {
        System.out.println(Double.toString(mensagem));
        return Double.toString(mensagem) + "\n";
    }
    String log(String mensagem)
    {
        System.out.println(mensagem);
        return mensagem + "\n";
    }
}
