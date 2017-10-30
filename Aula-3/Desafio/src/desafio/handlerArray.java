
package desafio;

public class handlerArray {
    Interface console = new Interface();
    int array[];
    int posicoesOcupadas=0;
    handlerArray(int posicoes)
    {
        if(posicoes > 0)
            this.array = new int[posicoes];
        else 
        { 
            console.log("Valor invalido");
            System.exit(69);
        }
    }
    void ordenarArray()
    {
        int aux;
        int ok = 0;
        do
        {
            ok = 1;
            for(int i = 0; i<this.posicoesOcupadas-1; i++)
            {
                    if (this.array[i]>this.array[i+1])
                    {
                        aux = this.array[i];
                        this.array[i] = this.array[i+1];
                        this.array[i+1] = aux;
                        ok = 0;
                    }  
            }
        }while(ok==0);
        this.imprimirArray();
    }
    void inserirValor(int valor)
    {
        if(array.length <= posicoesOcupadas)
        {
            console.log("Array está cheio");
            return;
        }
        this.array[posicoesOcupadas++]=valor;
    }
    int retornarSoma()
    {
        int soma = 0;
        for(int i = 0; i<this.array.length; i++)
        {
            soma += this.array[i];
        }
        return soma;
    }
    double retornarMedia()
    {
        double total = (double)this.retornarSoma();
        return total / (double)this.posicoesOcupadas;
    }
    
    int retornarSoma(char op)
    {
        int soma = 0;
        for(int i = 0; i<this.array.length; i++)
        {
            if(op == '+')
                if (this.array[i]>=0)
                    soma += this.array[i];
            if(op == '-')
                if (this.array[i]<=0)
                    soma += this.array[i];
        }
        return soma;
    }
    int retornarMenor()
    {
        int menor = 0;
        for(int i = 0; i<this.array.length; i++)
        {
            if(this.array[i] < menor)
                menor  = this.array[i];
        }
        return menor;
    }
    int retornarMaior()
    {
        int maior = 0;
        for(int i = 0; i<this.array.length; i++)
        {
            if(this.array[i] > maior)
                maior = this.array[i];
        }
        return maior;
    }
    void imprimirArray()
    {
        for(int i = 0; i<this.array.length;i++)
        {
            console.log(Integer.toString(this.array[i]));
        }
        
    }
   
}
