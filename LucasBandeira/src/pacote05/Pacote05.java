package pacote05;

public class Pacote05 {
    public static void main(String[] args) {
        OperadorString operador =  new OperadorString();
        operador.A();
        operador.B();
        operador.C();
        
        String [] arrayA = operador.lerStrings("oi","tchau", "argumentos", "infinitos");
        String [] arrayB = operador.lerStrings("oi", "falou", "TchaU", "argumentos");
        String [] maiusculos = operador.lerStrings("oi", "falou", "MAIUSCULO", "mAiOr", "capaZ");
        System.out.println("//Impressao///"); //////////////
        
        operador.imprimirArrayString(arrayA);
        System.out.println("//Coincidentes///");//////////////
        
        String [] coincidentes = operador.coincidentes(arrayA, arrayB);
        operador.imprimirArrayString(coincidentes);
        System.out.println("//Maisculos///"); //////////////
        
        operador.imprimirComMaiusculas(arrayB);
        operador.imprimirComMaiusculas(maiusculos);
    }
    
}