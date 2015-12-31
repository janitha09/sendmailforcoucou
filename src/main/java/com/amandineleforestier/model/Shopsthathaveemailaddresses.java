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
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author janitha
 */
@Entity
@Table(name = "shopsthathaveemailaddresses")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Shopsthathaveemailaddresses.findAll", query = "SELECT s FROM Shopsthathaveemailaddresses s"),
    @NamedQuery(name = "Shopsthathaveemailaddresses.findById", query = "SELECT s FROM Shopsthathaveemailaddresses s WHERE s.id = :id"),
    @NamedQuery(name = "Shopsthathaveemailaddresses.findByShopname", query = "SELECT s FROM Shopsthathaveemailaddresses s WHERE s.shopname = :shopname"),
    @NamedQuery(name = "Shopsthathaveemailaddresses.findByAddress", query = "SELECT s FROM Shopsthathaveemailaddresses s WHERE s.address = :address"),
    @NamedQuery(name = "Shopsthathaveemailaddresses.findByPhone", query = "SELECT s FROM Shopsthathaveemailaddresses s WHERE s.phone = :phone"),
    @NamedQuery(name = "Shopsthathaveemailaddresses.findByPlacetypes", query = "SELECT s FROM Shopsthathaveemailaddresses s WHERE s.placetypes = :placetypes"),
    @NamedQuery(name = "Shopsthathaveemailaddresses.findBySrc1", query = "SELECT s FROM Shopsthathaveemailaddresses s WHERE s.src1 = :src1"),
    @NamedQuery(name = "Shopsthathaveemailaddresses.findByBrandname", query = "SELECT s FROM Shopsthathaveemailaddresses s WHERE s.brandname = :brandname"),
    @NamedQuery(name = "Shopsthathaveemailaddresses.findByEmail", query = "SELECT s FROM Shopsthathaveemailaddresses s WHERE s.email = :email"),
    @NamedQuery(name = "Shopsthathaveemailaddresses.findBySrc2", query = "SELECT s FROM Shopsthathaveemailaddresses s WHERE s.src2 = :src2")})
public class Shopsthathaveemailaddresses implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    @Id
    private int id;
    @Size(max = 80)
    @Column(name = "shopname")
    private String shopname;
    @Size(max = 255)
    @Column(name = "address")
    private String address;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 20)
    @Column(name = "phone")
    private String phone;
    @Size(max = 255)
    @Column(name = "placetypes")
    private String placetypes;
    @Size(max = 255)
    @Column(name = "src1")
    private String src1;
    @Size(max = 45)
    @Column(name = "brandname")
    private String brandname;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 45)
    @Column(name = "email")
    private String email;
    @Size(max = 255)
    @Column(name = "src2")
    private String src2;

    public Shopsthathaveemailaddresses() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getShopname() {
        return shopname;
    }

    public void setShopname(String shopname) {
        this.shopname = shopname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPlacetypes() {
        return placetypes;
    }

    public void setPlacetypes(String placetypes) {
        this.placetypes = placetypes;
    }

    public String getSrc1() {
        return src1;
    }

    public void setSrc1(String src1) {
        this.src1 = src1;
    }

    public String getBrandname() {
        return brandname;
    }

    public void setBrandname(String brandname) {
        this.brandname = brandname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSrc2() {
        return src2;
    }

    public void setSrc2(String src2) {
        this.src2 = src2;
    }
    
}
