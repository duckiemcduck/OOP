/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desafio;

/**
 *
 * @author aluno
 */
public class Desafio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Interface console = new Interface();
        int posicoes  = console.input("Entre o numero de posicoes");
        
        handlerArray objArray = new handlerArray(posicoes);
        
        for(int i=0; i<posicoes; i++)
            objArray.inserirValor(console.input("Entre um valor:"));
        
        objArray.imprimirArray();
        console.log("Media:" + objArray.retornarMedia());
        console.log("Soma:" + objArray.retornarSoma());
        console.log("Soma positivos:" + objArray.retornarSoma('+'));
        console.log("Soma negativos:" + objArray.retornarSoma('-'));
        objArray.ordenarArray();
        
    }
    
}
