/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package abstracao.encapsulamento;

import static java.io.FileDescriptor.in;
import static java.lang.System.in;
import static javax.management.Query.in;

public class Pessoa {
    private String cpf;
    private String nome="Anônimo";
    private int idade=0;
    
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        if(cpf.matches("(\\d)*"))
        {
            this.cpf = cpf;
        }
        {
            System.out.println("Não é uma sequência de digitos");
        }
        
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        char array[]=nome.toCharArray();
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
        this.idade = idade;
    }
}
