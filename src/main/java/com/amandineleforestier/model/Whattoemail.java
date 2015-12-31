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
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author janitha
 */
@Entity
@Table(name = "whattoemail", catalog = "shops", schema = "")
@NamedQueries({
    @NamedQuery(name = "Whattoemail.findAll", query = "SELECT w FROM Whattoemail w"),
    @NamedQuery(name = "Whattoemail.findById", query = "SELECT w FROM Whattoemail w WHERE w.id = :id"),
    @NamedQuery(name = "Whattoemail.findBySubject", query = "SELECT w FROM Whattoemail w WHERE w.subject = :subject")})
public class Whattoemail implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "subject")
    private String subject;
    @Lob
    @Column(name = "messagebody")
    private String messagebody;

    public Whattoemail() {
    }

    public Whattoemail(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessagebody() {
        return messagebody;
    }

    public void setMessagebody(String messagebody) {
        this.messagebody = messagebody;
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
        if (!(object instanceof Whattoemail)) {
            return false;
        }
        Whattoemail other = (Whattoemail) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.amandineleforestier.model.Whattoemail[ id=" + id + " ]";
    }
    
}
