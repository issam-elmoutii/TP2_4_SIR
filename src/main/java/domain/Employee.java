package domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Author: ELMOUTII Issam & GOURIRANE Yassine
 * Date: 2020/2021
 * Version 1.0
 */

@Entity

/*
 Question 1.

 Transformez  une première classe en entité.


 Travaillez uniquement sur le champ id et les attributs de la classe. Créez plusieurs instances de cette classe. Rendez ces instances persistantes. Regardez dans le manager de la base de données le résultat.

 Vous devez obtenir ce genre de code mais sur vos classes métier
 */
public class Employee {
    private Long id;

    private String name;

    private Department department;

    public Employee() {
    }

    public Employee(String name, Department department) {
        this.name = name;
        this.department = department;
    }

    public Employee(String name) {
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

    @ManyToOne
    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name + ", department="
                + department.getName() + "]";
    }

}
