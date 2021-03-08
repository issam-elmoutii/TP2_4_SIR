package domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.GeneratedValue;
import javax.persistence.EntityTransaction;
import jpa.EntityManagerHelper;

/**
 * Author: ELMOUTII Issam & GOURIRANE Yassine
 * Date: 2020/2021
 * Version 1.0
 */

@Entity
public class Section {
    private Long id;
    private List<Fiche> fiches = new ArrayList<Fiche>();
    private String name;
    private Tableau tableau;
    public Section() {}
    public Section(String name, Tableau tableau) {
        this.name = name;
        this.tableau = tableau;
    }
    public Section(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
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



    @ManyToOne
    public Tableau getTableau() {
        return tableau;
    }

    public void setTableau(Tableau tableau) {
        this.tableau = tableau;
    }

    @OneToMany(mappedBy = "section", cascade = CascadeType.PERSIST)
    public List<Fiche> getFiches() {
        return fiches;
    }

    public void setFiches(List<Fiche> fiches) {
        this.fiches = fiches;
    }



    @Override
    public String toString() {
        return "Section { id=" + id + ", name=" + name + ", tableau=" + tableau.getName() + "}";
    }



    public static void saveSection(Section section) {
        EntityTransaction s = EntityManagerHelper.getEntityManager().getTransaction();

        s.begin();
        EntityManagerHelper.getEntityManager().persist(section);
        s.commit();
    }
    public static List<Section> getAllSectionsDao() {
        String query = "select s from Section as s";
        return EntityManagerHelper.getEntityManager().createQuery(query, Section.class).getResultList();
    }

    public static List<Section> getAllSection1() {
        String query = "select s from Section as s where s.name='Ã€ faire B'";
        return EntityManagerHelper.getEntityManager().createQuery(query, Section.class).getResultList();
    }

    public static List<Section> getAllSectionsSansTableauDao() {
        String query = "select s from Section as s where s.tableau is EMPTY";
        return EntityManagerHelper.getEntityManager().createQuery(query, Section.class).getResultList();
    }

    public static List<Section> getAllSectionsNameLong6() {
        String query = "select s from Section as s " +
                "where LENGTH(s.name) = 6";
        return EntityManagerHelper.getEntityManager().createQuery(query, Section.class).getResultList();
    }

    public static List<Section> getSectionASC() {
        String query = "select s from Section as s ORDER BY s.name ASC";
        return EntityManagerHelper.getEntityManager().
                createQuery(query, Section.class)
                .setFirstResult(1).setMaxResults(10)
                .getResultList();
    }
    public static List<Section> getSectionDESC() {
        String query = "select s from Section as s ORDER BY s.name DESC";
        return EntityManagerHelper.getEntityManager().
                createQuery(query, Section.class)
                .setFirstResult(1).setMaxResults(10)
                .getResultList();
    }

    public  static List<Section> getAllSectionsNative() {
        String query = "select * from Section ";
        return EntityManagerHelper.getEntityManager().
                createNativeQuery(query, Section.class).getResultList();
    }
    public static List<Section> getAllSectionParam(String name) {
        String query = "select t from Section as t join t.fiches as a where a.name=:name";
        return EntityManagerHelper.getEntityManager().createQuery(query, Section.class)
                .setParameter("name", name).getResultList();
    }


}
