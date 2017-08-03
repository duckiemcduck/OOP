package abstracao.encapsulamento;
public class Aluno 
{
    private String matricula="0";
    private int idade=0;

    public String getMatricula() {
        
        return matricula;
    }

    public int getIdade() {
        return idade;
    }

    public void setMatricula(String matricula) 
    {
        if(matricula.matches("(\\d)*"))
        {
            this.matricula = matricula;
        }
        else
        {
            System.out.println("Não é uma sequência de digitos");
        }
    }

    public void setIdade(int idade) {
        if(idade<0)
        {
            this.idade=0;
        }
        this.idade = idade;
    }
}
