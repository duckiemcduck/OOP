/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacote05;

/**
 *
 * @author aluno
 */
public class OperadorString {
    public String [] lerStrings(String... args) 
    {
        /**
         * Lê um número indeterminado de strings e coloca-as em uma array
         */
        String [] retorno = new String[args.length];
        int pos = 0;
        for (String arg : args) {
            retorno[pos++] = arg;
        }
        return retorno;
    }
    public void imprimirArrayString(String [] array)
    {
         /**
         * Imprime todas as Strings em um array
         */
        for (String string : array)
        {
            System.out.println(string);
        }
    }
    public String maiorString(String [] array)
    {
        /**
         * Checa o tamanho de cada string no array e retorna o maior deles
         */
        String maior = "";
        for (String string : array)
        {
            if(string.length() > maior.length())
            {
                maior = string;
            }
        }
        return maior;
    }
    public String [] maiorArray(String [] A, String[] B)
    {
        /**
         * Retorna o array com o maior numero de posicoes
         */
        return (A.length > B.length) ? A:B;
    }
    public String [] menorArray(String [] A, String[] B)
    {
        /**
         * Retorna o array com o menor numero de posicoes
         */
        return (A.length > B.length) ? B:A;
    }
    public int posicoesValidas(String [] array)
    {
        /**
         * Retorna o numero de posicoes consecutivas não-nulas em um array
         */
        int validos = 0;
        for(String posicao : array)
        {
            if(posicao == null)
                return validos;
            else
                validos++;
        }
        return validos;
    }
    
    public String [] coincidentes(String [] arrayA, String[] arrayB)
    {
        /**
         * Cria um array temporario com o tamanho do maior array,
         * verifica quais valores são iguais em ambos os arrays,
         * cria um array com o tamanho de valores iguais,
         * retorna um array de strings com estes valores repetidos.
         */
        String [] temp = new String[this.maiorArray(arrayA, arrayB).length];
        int pos = 0;
        for(String stringDoMaior : this.maiorArray(arrayA, arrayB))
        {
           for(String stringDoMenor : this.menorArray(arrayA, arrayB))
           {
               if (stringDoMaior == stringDoMenor)
               {
                   temp[pos++] = stringDoMenor;
               }
           }
        }
        int posValidas = this.posicoesValidas(temp);
        String [] retorno = new String[this.posicoesValidas(temp)];
        for(int i = 0 ; i<posValidas ; i++)
        {
            retorno[i] = temp[i];
        }
        return retorno;
    }
    public void A(){
        /**
         * Imprime um possível exemplo do item A
         */
        System.out.println("Item A)");
        this.imprimirArrayString(this.lerStrings("Isso", "é", "um", "exemplo"));
        System.out.println("******");
    }
     public void B(){
        /**
         * Imprime um possível exemplo do item B
         */
        System.out.println("Item B)");
        System.out.println(
                this.maiorString(
                        this.lerStrings("Isso", "é", "um", "exemplo")
                )
        );
        System.out.println("******");
    }
     public void C(){
        /**
         * Imprime um possível exemplo do item C
         */
        System.out.println("Item C)");
        this.imprimirArrayString(
                this.coincidentes(
                        this.lerStrings("Isso", "é", "um", "exemplo"), 
                        this.lerStrings("é","exemplo")
                )
        );
        System.out.println("******");
    }
    
    public void imprimirComMaiusculas(String [] array)
    {   
        /**
         * Checa cada letra de cada string no array,
         * verifica se há letra maiúscula,
         * caso sim, imprime a string inteira e pula para a próxima 
         * caso não, continue checando até acabar as letras.
         */
        for (String string : array)
        {
            char arrayChar[]=string.toCharArray();
            for(char letra : arrayChar)
            {
                if (Character.isUpperCase(letra))
                {
                    System.out.println(string);
                    break;
                }
            }
        }
    }
}
