/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amandineleforestier.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author 222252
 */
@Entity
@Table(name = "emailaddressesfromatmosphere")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Emailaddressesfromatmosphere.findAll", query = "SELECT e FROM Emailaddressesfromatmosphere e"),
    @NamedQuery(name = "Emailaddressesfromatmosphere.findByTitle", query = "SELECT e FROM Emailaddressesfromatmosphere e WHERE e.title = :title"),
    @NamedQuery(name = "Emailaddressesfromatmosphere.findByFirstname", query = "SELECT e FROM Emailaddressesfromatmosphere e WHERE e.firstname = :firstname"),
    @NamedQuery(name = "Emailaddressesfromatmosphere.findBySurname", query = "SELECT e FROM Emailaddressesfromatmosphere e WHERE e.surname = :surname"),
    @NamedQuery(name = "Emailaddressesfromatmosphere.findByCompany", query = "SELECT e FROM Emailaddressesfromatmosphere e WHERE e.company = :company"),
    @NamedQuery(name = "Emailaddressesfromatmosphere.findByCountry", query = "SELECT e FROM Emailaddressesfromatmosphere e WHERE e.country = :country"),
    @NamedQuery(name = "Emailaddressesfromatmosphere.findByEmail", query = "SELECT e FROM Emailaddressesfromatmosphere e WHERE e.email = :email"),
    @NamedQuery(name = "Emailaddressesfromatmosphere.findById", query = "SELECT e FROM Emailaddressesfromatmosphere e WHERE e.id = :id")})
public class Emailaddressesfromatmosphere implements Serializable {
    private static final long serialVersionUID = 1L;
    @Size(max = 5)
    @Column(name = "title")
    private String title;
    @Size(max = 25)
    @Column(name = "firstname")
    private String firstname;
    @Size(max = 25)
    @Column(name = "surname")
    private String surname;
    @Size(max = 80)
    @Column(name = "company")
    private String company;
    @Size(max = 25)
    @Column(name = "country")
    private String country;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 45)
    @Column(name = "email")
    private String email;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    public Emailaddressesfromatmosphere() {
    }

    public Emailaddressesfromatmosphere(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Emailaddressesfromatmosphere)) {
            return false;
        }
        Emailaddressesfromatmosphere other = (Emailaddressesfromatmosphere) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.amandineleforestier.model.Emailaddressesfromatmosphere[ id=" + id + " ]";
    }
    
}
