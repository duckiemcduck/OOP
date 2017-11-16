/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rh.modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author aluno
 */
@Entity
@Table(name = "Empregados")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Empregado.findAll", query = "SELECT e FROM Empregado e"),
    @NamedQuery(name = "Empregado.findByIdEmpregados", query = "SELECT e FROM Empregado e WHERE e.idEmpregados = :idEmpregados"),
    @NamedQuery(name = "Empregado.findByNome", query = "SELECT e FROM Empregado e WHERE e.nome = :nome"),
    @NamedQuery(name = "Empregado.findByDatanas", query = "SELECT e FROM Empregado e WHERE e.datanas = :datanas"),
    @NamedQuery(name = "Empregado.findBySalario", query = "SELECT e FROM Empregado e WHERE e.salario = :salario"),
    @NamedQuery(name = "Empregado.findByCargo", query = "SELECT e FROM Empregado e WHERE e.cargo = :cargo"),
    @NamedQuery(name = "Empregado.findByChefe", query = "SELECT e FROM Empregado e WHERE e.chefe = :chefe")})
public class Empregado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idEmpregados")
    private Integer idEmpregados;
    @Column(name = "nome")
    private String nome;
    @Column(name = "datanas")
    @Temporal(TemporalType.DATE)
    private Date datanas;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "salario")
    private Float salario;
    @Column(name = "cargo")
    private String cargo;
    @Column(name = "chefe")
    private Integer chefe;
    @JoinColumn(name = "Departamentos_idDepartamentos", referencedColumnName = "idDepartamentos")
    @ManyToOne(optional = false)
    private Departamento departamentosidDepartamentos;

    public Empregado() {
    }

    public Empregado(Integer idEmpregados) {
        this.idEmpregados = idEmpregados;
    }

    public Integer getIdEmpregados() {
        return idEmpregados;
    }

    public void setIdEmpregados(Integer idEmpregados) {
        this.idEmpregados = idEmpregados;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDatanas() {
        return datanas;
    }

    public void setDatanas(Date datanas) {
        this.datanas = datanas;
    }

    public Float getSalario() {
        return salario;
    }

    public void setSalario(Float salario) {
        this.salario = salario;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Integer getChefe() {
        return chefe;
    }

    public void setChefe(Integer chefe) {
        this.chefe = chefe;
    }

    public Departamento getDepartamentosidDepartamentos() {
        return departamentosidDepartamentos;
    }

    public void setDepartamentosidDepartamentos(Departamento departamentosidDepartamentos) {
        this.departamentosidDepartamentos = departamentosidDepartamentos;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEmpregados != null ? idEmpregados.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empregado)) {
            return false;
        }
        Empregado other = (Empregado) object;
        if ((this.idEmpregados == null && other.idEmpregados != null) || (this.idEmpregados != null && !this.idEmpregados.equals(other.idEmpregados))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "rh.modelo.Empregado[ idEmpregados=" + idEmpregados + " ]";
    }
    
}
