
import java.util.Arrays;

public class OperaArrays {
    public static void imprimeAtemB(int [] a, int [] b)
    {
        for (int i =0; i<b.length; i++)
        {
            for(int j = 0; j<a.length; j++)
            {
                if(a[j] == b[i])
                {
                    System.out.println("sim");
                }
            }
        }
    }
    
    public static void imprimeBtemA(int [] a, int [] b)
    {
        
    }
    
    public static int [] criarVetorAmaisB(int [] a, int [] b)
    {
        int j=0;
        int [] saida = new int[a.length + b.length];
        for(int i= 0; i < a.length; i ++)
        {
            saida[i] = a[i]; 
        }
        
        for(int i= 0; i < b.length; i ++)
        {
            j++;
            saida[j] = b[i];
        }
        return null;
    }
    
    public static void imprimeOrdemInversa(int [] a)
    {
        Arrays.sort(a);
        for(int i= a.length -1; i >=0; i --)
        {
            System.out.println(a[i] + " ");
        }
    }
    
    public static void imprimeOrdemCrescente(int [] a)
    {
        Arrays.sort(a);
        for (int i=0; i<a.length; i++)
        {
            System.out.println(a[i] + " ");
        }
        
    }
    
    public static void BnaotemA(int []a, int []b)
    {
        for(int i=0; i < a.length; i++)
        {
            boolean achou = false;
            for(int j =0; j<b.length; i++)
            {
                if (a[i] == b[j])
                {
                    achou = true;
                }
            }
            if(!achou)
            {
                System.out.println(a[i]);
            }
        }
    }
    
}
