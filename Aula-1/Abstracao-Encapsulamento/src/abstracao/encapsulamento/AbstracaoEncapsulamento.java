/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package abstracao.encapsulamento;
public class AbstracaoEncapsulamento {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Aluno joao = new Aluno();
        joao.setIdade(12);
        System.out.println(joao.getIdade());
        joao.setMatricula("696969");
        System.out.println(joao.getMatricula());
        joao.setMatricula("696dasdsada969");
        System.out.println(joao.getMatricula());
    }
    
}
