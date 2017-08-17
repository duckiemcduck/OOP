/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desafio2;

import java.util.ArrayList;

/**
 *
 * @author aluno
 */
public class OperaPessoa {
    Interface console = new Interface();
    ArrayList <Pessoa> pessoas = new ArrayList();
    
    void inserirPessoa(Pessoa pessoa)
    {
        this.pessoas.add(pessoa);
    }
    
    void registrarPessoa()
    {
        Pessoa nova = new Pessoa(console.scan("Entre o nome da pessoa"), console.input("Entre a idade da pessoa"));
        this.pessoas.add(nova);
    }
    
    void imprimirPessoas()
    {
        for(int i=0; i<this.pessoas.size(); i++)
        {
            console.log("Nome:" + this.pessoas.get(i).getNome());
            console.log("Idade:" + this.pessoas.get(i).getIdade());
        }
    }
    
    double retornarIdadeMedia()
    {
        double total = 0;
        int numeroPessoas = this.pessoas.size();
        for(int i=0; i<numeroPessoas; i++)
        {
            total += this.pessoas.get(i).getIdade();
        }
        return total / (double)numeroPessoas;
    }
    
    void imprimirPessoa(Pessoa pessoa)
    {
            console.log("****");
            console.log("Nome:" + pessoa.getNome());
            console.log("Idade:" + pessoa.getIdade());
            console.log("****");
    }
    
    Pessoa retornarMaisVelha()
    {
        Pessoa maisVelha = new Pessoa("Anonimo", 0);
        for(int i=0; i<this.pessoas.size(); i++)
        {
            if(this.pessoas.get(i).getIdade() >  maisVelha.getIdade())
            {
                maisVelha = this.pessoas.get(i);
            }
        }
        return maisVelha;
    }
    Pessoa retornarMaisNova()
    {
        Pessoa maisNova = retornarMaisVelha();
        for(int i=0; i<this.pessoas.size(); i++)
        {
            if(this.pessoas.get(i).getIdade() <=  maisNova.getIdade())
            {
                maisNova = this.pessoas.get(i);
            }
        }
        return maisNova;
    }
}
