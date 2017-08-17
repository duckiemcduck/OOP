/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desafio2;

/**
 *
 * @author aluno
 */
public class Pessoa {
    private String nome = "Anonimo";
    private int idade = 0;

    Pessoa(String nome, int idade) {
        this.setNome(nome);
        this.setIdade(idade);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        char array[]=nome.toCharArray();
        if (array[0]==' ')
        {
           System.out.println("O nome " + nome + " é inválido");
           return;
        }
        
        for(char letra : array)
        {
            if(Character.isDigit(letra))
            {
                System.out.println("O nome " + nome + " é inválido");
                return;
            }
            
        }
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        if(idade < 0)
        {
            System.out.println("A idade " + idade + " é inválida");
            return;
        }
        this.idade = idade;
    }
    
}
