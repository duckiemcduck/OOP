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
    
    /**
     * Insere pessoa pelo processo padrao a array list do objeto
     * @param pessoa objeto pessoa a ser definido
     */
    int inserirPessoa(Pessoa pessoa)
    {
        for(int i=0; i<this.pessoas.size(); i++)
        {
            if(this.pessoas.get(i).getId() == pessoa.getId())
            {
                return 1;
            }
        }
        this.pessoas.add(pessoa);
        return 0;
    }
    /**
     * guia inserção de pessoa a array list do objeto
     */
    void registrarPessoa()
    {
        Pessoa nova = new Pessoa(console.scan("Entre o nome da pessoa"), console.input("Entre a idade da pessoa"));
        this.pessoas.add(nova);
    }
    
    /**
     * imprime todas as pessoas registradas no objeto
     * @return 
     */
    String imprimirPessoas()
    {
        String retorno = "";
        for(int i=0; i<this.pessoas.size(); i++)
        {
            console.log("Nome:" + this.pessoas.get(i).getNome());
            console.log("Idade:" + this.pessoas.get(i).getIdade());
            console.log("Salario:" + this.pessoas.get(i).getSalario());
            retorno += "\n" + "{ Nome:" + this.pessoas.get(i).getNome() + ", Idade:" +  this.pessoas.get(i).getIdade() + ", Salario:" + this.pessoas.get(i).getSalario() + "}";
        }
        return retorno;
    }
    /**
     * retorna a pessoa com a dada idade
     * @param idade idade da pessoa
     * @return 
     */
    Pessoa pesquisarPorId(int id)
    {
        for(int i=0; i<this.pessoas.size(); i++)
        {
            if (this.pessoas.get(i).getId() == id)
            {
                return this.pessoas.get(i);
            }    
        }
        return null;
    }
    
    /**
     * retorna a idade mediana de todas as pessoas no array do objeto
     * @return 
     */
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
    
    String imprimirPessoa(Pessoa pessoa)
    {
            String retorno = "";
            retorno += console.log("****");
            retorno += console.log("Nome:" + pessoa.getNome());
            retorno += console.log("Idade:" + pessoa.getIdade());
            retorno += console.log("Salario:" + pessoa.getSalario());
            retorno += console.log("****");
            
            return retorno;
    }
    /**
     * exclui a pessoa identificada
     * @param pessoaExcluir objeto da pessoa a ser excluida
     */
    void excluirPessoa(Pessoa pessoaExcluir)
    {
        Pessoa maisVelha = new Pessoa("Anonimo", 0);
        for(int i=0; i<this.pessoas.size(); i++)
        {
            if(this.pessoas.get(i).equals(pessoaExcluir))
            {
                this.pessoas.remove(i);
            }
                    
        }
    }
    /**
     * retorna a pessoa mais velha do array
     * @return 
     */
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
    /**
     * retorna a pessoa mais nova do array
     * @return 
     */
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
