public class Main {
    public static void main(String [] args)
    {
        int [] a= {5,9,6};
        int [] b= {3,4,5,7,9,10};
        
        OperaArrays.imprimeAtemB(a, b);
        int [] x = OperaArrays.criarVetorAmaisB(a, b);
        OperaArrays.imprimeOrdemCrescente(x);
        OperaArrays.BnaotemA(a, b);
        OperaArrays.imprimeOrdemInversa(a);
    }
}
