
package entrega;

public class handlerArray {
    Interface console = new Interface();
    double array[];
    int posicoesOcupadas=0;
    handlerArray(int posicoes)
    {
        if(posicoes > 0)
            this.array = new double[posicoes];
        else 
        { 
            console.log("Valor invalido");
            System.exit(69);
        }
    }
    void ordenarArray()
    {
        double aux;
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
        if(valor<0)
            valor = 0;
        this.array[posicoesOcupadas++]=valor;
    }
    void inserirValor(double valor)
    {
        if(array.length <= posicoesOcupadas)
        {
            console.log("Array está cheio");
            return;
        }
        if(valor<0)
            valor = 0;
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
    
    double retornarSoma(char op)
    {
        double soma = 0;
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
    double retornarMenor()
    {
        double menor = 0;
        for(int i = 0; i<this.array.length; i++)
        {
            if(this.array[i] < menor)
                menor  = this.array[i];
        }
        return menor;
    }
    double retornarMaior()
    {
        double maior = 0;
        for(int i = 0; i<this.array.length; i++)
        {
            if(this.array[i] > maior)
                maior = this.array[i];
        }
        return maior;
    }
    int retornarMaior(int limite)
    {
        int numSalarios=0;
        for(int i = 0; i<this.array.length; i++)
        {
            if(this.array[i] > limite)
                numSalarios++;
        }
        return numSalarios;
    }
    void imprimirArray()
    {
        for(int i = 0; i<this.array.length;i++)
        {
            console.log(Double.toString(this.array[i]));
        }
        
    }
   
}
