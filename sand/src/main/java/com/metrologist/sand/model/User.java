package com.metrologist.sand.model;


import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "date")
    private Date date = new Date(System.currentTimeMillis());

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Transient
    private String confirmPassword;
    @Column (name = "user_fullname")
    private String user_fullname;

    @Column (name = "user_email")
    private String user_email;
    @Column(name = "company_name")
    private String company_name;
    @Column (name = "position_name")
    private String position_name;

    @ManyToMany
    @JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles ;



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public String getUser_fullname() {
        return user_fullname;
    }
    public void setUser_fullname(String user_fullname) {
        this.user_fullname = user_fullname;
    }


    public String getUser_email() {
        return user_email;
    }
    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public String getCompany_name() {
        return company_name;
    }
    public void setCompany_name(String company_name) {
        this. company_name =  company_name;
    }

    public String getPosition_name() {return position_name;}
    public void setPosition_name(String position_name) {
        this.position_name = position_name;
    }

}
