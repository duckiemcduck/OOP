/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleEstoques.modelo;

/**
 *
 * @author aluno
 */
public class Material {
    private int codigo = -1;
    private String descricao  = "Nenhuma";
    private int unidade = 0;
    private float preco = (float) 0.0;
    private String unidadeQuantitativa = "ml";

    public Material() {
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getUnidade() {
        return unidade;
    }

    public void setUnidade(int unidade) {
        this.unidade = unidade;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public String getUnidadeQuantitativa() {
        return unidadeQuantitativa;
    }

    public void setUnidadeQuantitativa(String unidadeQuantitativa) {
        this.unidadeQuantitativa = unidadeQuantitativa;
    }
    
    
}