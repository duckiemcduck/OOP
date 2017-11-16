/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacote04;

/**
 *
 * @author aluno
 */
public class Celular {
    private String modelo = "PROTOTIPO";
    private int Id = -1;
    private float chaveBluetooth = 0;

    Celular(String modelo, int id, float chave) {
        /**
         * Construtor completo
         */
        this.setModelo(modelo);
        this.setId(id);
        this.setChaveBluetooth(chave);
    }
    Celular(String modelo, int id) {
        /**
         * Construtor sem chave
         */
        this.setModelo(modelo);
        this.setId(id);
    }

    public String getModelo() {
        /**
         * Retorna o modelo do aparelho
         */
        return modelo;
    }

    public void setModelo(String modelo) {
        /**
         * Permite modificar o modelo do aparelho, impede espaço vazio e digitos
         */
        char array[]=modelo.toCharArray();
        if (array[0]==' ')
        {
           System.out.println("O nome " + modelo + " é inválido");
           return;
        }
        
        for(char letra : array)
        {
            if(Character.isDigit(letra))
            {
                System.out.println("O nome " + modelo + " é inválido");
                return;
            }
            
        }
        this.modelo = modelo;
    }

    public float getChaveBluetooth() {
    /**
     * Retorna a ID interna do aparelho, rejeita numeros negativos 
     */
        return chaveBluetooth;
    }

    public void setChaveBluetooth(float chaveBluetooth) {
     /**
      * Atualiza a chave interna do aparelho, rejeita numeros negativos 
      */
        if(chaveBluetooth < 0)
        {
            System.out.println("A chave " + chaveBluetooth + " é inválida");
            return;
        }
        this.chaveBluetooth = chaveBluetooth;
    }

    public int getId() { 
    /**
     * Retorna a ID interna do aparelho
     */
        return Id;
    }
    public void setId(int Id) {
    /**
     * Atualiza a ID interna do aparelho, rejeita numeros negativos 
     */
        if(Id < 0)
        {
            System.out.println("A Id " + Id + " é inválida");
            return;
        }
        this.Id = Id;
        
    }

    @Override
    public String toString() {
        return "Celular{" + "modelo=" + modelo + ", Id=" + Id + ", chaveBluetooth=" + chaveBluetooth + '}';
    }
}
