package domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * Author: ELMOUTII Issam & GOURIRANE Yassine
 * Date: 2020/2021
 * Version 1.0
 */


/* ADD class Department*/


@Entity
public class Department {

    private Long id;

    private String name;

    private List<Employee> employees = new ArrayList<Employee>();

    public Department() {
        super();
    }

    public Department(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(mappedBy = "department", cascade = CascadeType.PERSIST)
    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}

