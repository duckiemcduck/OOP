package abstracao.encapsulamento;
public class Aluno extends Pessoa
{
    private String matricula="0";

    public String getMatricula() {
        
        return matricula;
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
}
