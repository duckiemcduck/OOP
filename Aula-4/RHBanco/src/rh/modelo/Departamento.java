/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rh.modelo;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author aluno
 */
@Entity
@Table(name = "Departamentos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Departamento.findAll", query = "SELECT d FROM Departamento d"),
    @NamedQuery(name = "Departamento.findByIdDepartamentos", query = "SELECT d FROM Departamento d WHERE d.idDepartamentos = :idDepartamentos"),
    @NamedQuery(name = "Departamento.findByNome", query = "SELECT d FROM Departamento d WHERE d.nome = :nome"),
    @NamedQuery(name = "Departamento.findByLocalizacao", query = "SELECT d FROM Departamento d WHERE d.localizacao = :localizacao")})
public class Departamento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idDepartamentos")
    private Integer idDepartamentos;
    @Column(name = "nome")
    private String nome;
    @Column(name = "localizacao")
    private String localizacao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "departamentosidDepartamentos")
    private Collection<Empregado> empregadoCollection;

    public Departamento() {
    }

    public Departamento(Integer idDepartamentos) {
        this.idDepartamentos = idDepartamentos;
    }

    public Integer getIdDepartamentos() {
        return idDepartamentos;
    }

    public void setIdDepartamentos(Integer idDepartamentos) {
        this.idDepartamentos = idDepartamentos;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    @XmlTransient
    public Collection<Empregado> getEmpregadoCollection() {
        return empregadoCollection;
    }

    public void setEmpregadoCollection(Collection<Empregado> empregadoCollection) {
        this.empregadoCollection = empregadoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDepartamentos != null ? idDepartamentos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Departamento)) {
            return false;
        }
        Departamento other = (Departamento) object;
        if ((this.idDepartamentos == null && other.idDepartamentos != null) || (this.idDepartamentos != null && !this.idDepartamentos.equals(other.idDepartamentos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "rh.modelo.Departamento[ idDepartamentos=" + idDepartamentos + " ]";
    }
    
}
