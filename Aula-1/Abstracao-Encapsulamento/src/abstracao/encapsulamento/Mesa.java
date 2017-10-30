/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package abstracao.encapsulamento;

public class Mesa {
    
    private double tamanho = 0;
    private String cor = "branca";

    public void setTamanho(double tamanho) {
        this.tamanho = tamanho;
    }

    public String getCor() {
        return cor;
    }
    public double getTamanho()
    {
        return tamanho;
    }
    public void setCor(String cor) {
        this.cor = cor;
    }
    
}
