package com.vti.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "customer", catalog = "phone_store")
public class customer implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name = "Id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short customer_id;

    @Column(name = "Email", length = 50, nullable = false, unique = true, updatable = false)
    private String email;

    @Column(name = "Username", length = 50, nullable = false, unique = true, updatable = false)
    private String username;

    @Column(name = "Fullname", length = 50, nullable = false)
    private String fullname;

    @Column(name = "Address", length = 100, nullable = false)
    private String address;

    @Column(name = "phone_num", nullable = false, unique = true)
    private Integer phoneNum;

    @Column(name = "password", length = 100, nullable = false)
    private String password;

    @Column(name = "CreateDate")
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date createDate;

    @OneToMany(mappedBy = "customer_id")
    List<order> orders;

    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private role role = com.vti.entity.role.user;

//    @Column(name = "status")
//    @Enumerated(EnumType.STRING)
//    private status status = com.vti.entity.status.not_active;

    public customer() {
        super();
    }

    public short getId() {
        return customer_id;
    }

    public void setId(short id) {
        this.customer_id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String andress) {
        this.address = andress;
    }

    public Integer getPhone_num() {
        return phoneNum;
    }

    public void setPhone_num(Integer phone_num) {
        this.phoneNum = phone_num;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public com.vti.entity.role getRole() {
        return role;
    }

    public void setRole(com.vti.entity.role role) {
        this.role = role;
    }
}
