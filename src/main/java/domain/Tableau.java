package domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.*;
import jpa.EntityManagerHelper;

import javax.persistence.EntityTransaction;



@Entity
public class Tableau {

    private Long id;
    private List<Section> sections = new ArrayList<Section>();
    private String name;
    public Tableau() {super();}
    public Tableau(String name) { this.name = name; }

    @Id
    @GeneratedValue
    public Long getId() { return id;}
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    @OneToMany(mappedBy = "tableau", cascade = CascadeType.PERSIST)
    public List<Section> getSections() {
        return sections;
    }
    public void setSections(List<Section> sections) { this.sections = sections; }




    public static void saveTableau(Tableau tableau) {
        EntityTransaction tab = EntityManagerHelper.getEntityManager().getTransaction();

        tab.begin();
        EntityManagerHelper.getEntityManager().persist(tableau);
        tab.commit();
    }
    public static List<Tableau> getAllTableauxDao() {
        String query = "select tab from Tableau as tab";
        return EntityManagerHelper.getEntityManager().createQuery(query, Tableau.class).getResultList();
    }

    public static List<Tableau> getAllTableaux1() {
        String query = "select tab from Tableau as tab where tab.name='Tableau Backend'";
        return EntityManagerHelper.getEntityManager().createQuery(query, Tableau.class).getResultList();
    }

    public static List<Tableau> getAllTableaux2() {
        String query = "select tab from Tableau as tab where tab.name='Tableau Frontend'";
        return EntityManagerHelper.getEntityManager().createQuery(query, Tableau.class).getResultList();
    }

    public static List<Tableau> getAllTableauxSansSectionDao() {
        String query = "select tab from Tableau as tab where tab.sections is EMPTY";
        return EntityManagerHelper.getEntityManager().createQuery(query, Tableau.class).getResultList();
    }


    public static List<Tableau> getAllTableauxNamelong15() {
        String query = "select tab from Tableau as tab " +
                "where LENGTH(tab.name) = 15";
        return EntityManagerHelper.getEntityManager().createQuery(query, Tableau.class).getResultList();
    }

    public  static List<Tableau> getTableauASC() {
        String query = "select tab from Tableau as tab ORDER BY tab.name ASC";
        return EntityManagerHelper.getEntityManager().
                createQuery(query, Tableau.class)
                .setFirstResult(0).setMaxResults(10)
                .getResultList();
    }
    public static List<Tableau> getTableauDESC() {
        String query = "select tab from Tableau as tab ORDER BY tab.name DESC";
        return EntityManagerHelper.getEntityManager().
                createQuery(query, Tableau.class)
                .setFirstResult(0).setMaxResults(10)
                .getResultList();
    }

    public static List<Tableau> getAllTableauxNatifs() {
        String query = "select * from Tableau";
        return EntityManagerHelper.getEntityManager().
                createNativeQuery(query, Tableau.class).getResultList();
    }

    public static List<Tableau> getAllSectionOFTableauParam(String name) {
        String query = "select t from Tableau as t join t.sections as a where a.name=:name";
        return EntityManagerHelper.getEntityManager().createQuery(query, Tableau.class)
                .setParameter("name", name).getResultList();
    }


}



