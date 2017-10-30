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
    private int id = -1;
    private String nome = "Anonimo";
    private int idade = 0;
    private float salario = (float) 0.0;

    Pessoa(String nome, int idade) {
        this.setNome(nome);
        this.setIdade(idade);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    Pessoa(String nome, int idade, float salario) {
        this.setNome(nome);
        this.setIdade(idade);
        this.setSalario(salario);
    }
    
    Pessoa(int id, String nome, int idade, float salario) {
        this.setId(id);
        this.setNome(nome);
        this.setIdade(idade);
        this.setSalario(salario);
    }
    
    /**
     * Retorna salario da pessoa
     * @return salario
     */
    public float getSalario() {
        return salario;
    }
    /**
     * Define salario da pessoa
     * @param salario salario da pessoa
     */
    public void setSalario(float salario) {
        this.salario = salario;
    }
    /**
     * retorna nome da pessoa
     * @return 
     */
    public String getNome() {
        return nome;
    }
    /**
     * define nome da pessoa
     * @param nome nome da pessoa
     */
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
    /**
     * retorna idade da pessoa
     * @return 
     */
    public int getIdade() {
        return idade;
    }
    /**
     * define idade da pessoa
     * @param idade idade da pessoa
     */
    public void setIdade(int idade) {
        if(idade < 0)
        {
            System.out.println("A idade " + idade + " é inválida");
            return;
        }
        this.idade = idade;
    }
    
}
