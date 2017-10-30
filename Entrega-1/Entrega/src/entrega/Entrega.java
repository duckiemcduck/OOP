
package entrega;
public class Entrega {
    public static void main(String[] args) {
        Interface console = new Interface();
        int posicoes;
        int limite;
        handlerArray objArray;
        
        limite = 1000;
        posicoes = (int)console.input("Entre o numero de posicoes");
        objArray = new handlerArray(posicoes);
        
        
        for(int i=0; i<posicoes; i++)
            objArray.inserirValor(console.input("Entre um valor:"));
        
        console.log("Media salários:" + objArray.retornarMedia());
        console.log("Maior salário:" + objArray.retornarMaior());
        
        console.log("Salários maiores que " + limite + ":");
        objArray.retornarMaior(limite);
    }
    
}
