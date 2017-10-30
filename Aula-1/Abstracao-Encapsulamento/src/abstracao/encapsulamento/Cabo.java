/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package abstracao.encapsulamento;

/**
 *
 * @author aluno
 */
public class Cabo {
    private int tipo = 0;
    private double tamanho = 0.00;
    private String cor = "preto";

    public String getTipo() {
        switch(this.tipo)
        {
            case 0: return "Forca";
            case 1: return "Jumper";
            case 2: return "Extensao";
            case 3: return "Rede";
            default:
                return "USB";
        }
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public double getTamanho() {
        return tamanho;
    }
    
    public void setTamanho(double tamanho) {
        this.tamanho = tamanho;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }
    
}
