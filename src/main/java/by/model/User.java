package by.model;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Роман on 21.07.2017.
 */
@Entity
public class User {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Basic
    @Column(name = "username")
    private String username;
    @Basic
    @Column(name = "password")
    private String password;
    @Transient
    private String confirmPassword;
@ManyToMany(fetch = FetchType.EAGER)
@JoinTable(name = "user_roles",joinColumns = @JoinColumn(name = "role_id"),
inverseJoinColumns = @JoinColumn(name = "user_id"))
private Set<Role> roles;
@ManyToOne
@JoinColumn(name = "employee_id")
private Employee employee;

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
}
