package construtores;
public class Aluno {
    private String nome;
    private char sexo;
    private double nota;
    private double piroca=1000;
    
    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }
    public Aluno(String nome)
    {
        this.nome=nome;
    }

    public Aluno(String nome, char sexo, double nota) {
        this.nome = nome;
        this.sexo = sexo;
        this.nota = nota;
    }
    public Aluno(String nome, char sexo) {
        this.nome = nome;
        this.sexo = sexo;
    }
    public String getNome() {
        return nome;
    }
    public String toString()
    {
        return Double.toString(this.piroca);
    }
    public void setNome(String nome) {
        if((nome==null) || (nome.charAt(0) == ' ' )) 
            return;
        this.nome = nome;
    }
}
