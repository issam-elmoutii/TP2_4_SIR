package domain;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.*;

import jpa.EntityManagerHelper;
import sun.security.krb5.internal.ccache.Tag;
import javax.persistence.EntityTransaction;

import java.util.List;


@Entity
public class Tags {
    private String name;
    private Fiche fiche;
    private Long id;

    public Tags() {
    }
    public Tags(String name, Fiche fiche) {
        this.name = name;
        this.fiche = fiche;
    }
    public Tags(String name) {
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
    public Fiche getFiche() {
        return fiche;
    }

    public void setFiche(Fiche fiche) {
        this.fiche = fiche;
    }

    @Override
    public String toString() {
        return "Tags { id=" + id + ", name=" + name + ", tableau=" + fiche.getName() + "}";
    }

    public  static void saaveTag(Tags tag) {
        EntityTransaction ta = EntityManagerHelper.getEntityManager().getTransaction();

        ta.begin();
        EntityManagerHelper.getEntityManager().persist(tag);
        ta.commit();
    }
    public static List<Tags> getAlTagsDao() {
        String query = "select ta from Tags as ta";
        return EntityManagerHelper.getEntityManager().createQuery(query, Tags.class).getResultList();
    }


    public static List<Tags> getAlTagsImportantDao() {
        String query = "select ta from Tags as ta where ta.name='Important'";
        return EntityManagerHelper.getEntityManager().createQuery(query, Tags.class).getResultList();
    }

    public static List<Tag> getAlTagsPriorityDao() {
        String query = "select ta from Tags as ta where ta.name='Priority'";
        return EntityManagerHelper.getEntityManager().createQuery(query, Tag.class).getResultList();
    }


    public static List<Tag> getImportantTagsWithFichesLoadedd() {
        String query = "SELECT ta from Tags as ta "
                + "where ta.name='Important' join fetch ta.fiches.name";
        return EntityManagerHelper.getEntityManager().createQuery(query, Tag.class).getResultList();
    }
    public static List<Tag> getPriorityTagsWithFichesLoadedd() {
        String query = "SELECT ta from Tags as ta "
                + "where ta.name='Priority' join fetch ta.fiches.name";
        return EntityManagerHelper.getEntityManager().createQuery(query, Tag.class).getResultList();
    }
    public  static void saveTag(Tags tag) {
        EntityTransaction ta = EntityManagerHelper.getEntityManager().getTransaction();

        ta.begin();
        EntityManagerHelper.getEntityManager().persist(tag);
        ta.commit();
    }
    public  static List<Tags> getAllTagsDao() {
        String query = "select ta from Tags as ta";
        return EntityManagerHelper.getEntityManager().createQuery(query, Tags.class).getResultList();
    }


    public static List<Tags> getAllTagsImportantDao() {
        String query = "select ta from Tags as ta where ta.name='Important'";
        return EntityManagerHelper.getEntityManager().createQuery(query, Tags.class).getResultList();
    }

    public static List<Tag> getAllTagsPriorityDao() {
        String query = "select ta from Tags as ta where ta.name='Priority'";
        return EntityManagerHelper.getEntityManager().createQuery(query, Tag.class).getResultList();
    }


    public static List<Tag> getImportantTagsWithFichesLoaded() {
        String query = "SELECT ta from Tags as ta "
                + "where ta.name='Important' join fetch ta.fiches.name";
        return EntityManagerHelper.getEntityManager().createQuery(query, Tag.class).getResultList();
    }
    public static List<Tag> getPriorityTagsWithFichesLoaded() {
        String query = "SELECT ta from Tags as ta "
                + "where ta.name='Priority' join fetch ta.fiches.name";
        return EntityManagerHelper.getEntityManager().createQuery(query, Tag.class).getResultList();
    }




}
