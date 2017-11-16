package pacote04;

public class Pacote04 {
    public static void main(String[] args) {
        Celular galaxyIV = new Celular("Galaxy IV", 1, (float)87.2);
        
        System.out.println(galaxyIV.getModelo());
        System.out.println(galaxyIV.getChaveBluetooth());
        System.out.println(galaxyIV.getId());
        ////////////////////////////////////// 
        //Mudanças válidas
        galaxyIV.setChaveBluetooth(0);
        galaxyIV.setModelo("descarte");
        galaxyIV.setId(99);
        
        //////////////////////////////////////
        System.out.println(galaxyIV.getModelo());
        System.out.println(galaxyIV.getChaveBluetooth());
        System.out.println(galaxyIV.getId());
        
        //////////////////////////////////////
        //Mudanças inválidas
        galaxyIV.setChaveBluetooth(-1);
        galaxyIV.setModelo("MEGATRON29382382");
        galaxyIV.setModelo(" MEGATRONII");
        galaxyIV.setId(-1);
        
        //////////////////////////////////////
        
        System.out.println(galaxyIV.toString());
        System.out.println(galaxyIV.hashCode());
        
        
    }
    
}