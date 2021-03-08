package domain;

import jpa.EntityManagerHelper;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import java.time.format.DateTimeFormatter;

import javax.persistence.Id;
import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;


import javax.persistence.EntityTransaction;

@Entity
public class Fiche {

    private String lieu;
    private String note;
    private Long id;
    private String name;
    private String url;
    private Integer tempsMinutes;
    private Section section;
    private List<Tags> tags = new ArrayList<Tags>();
    private List<Utilisateur> utilisateurs = new ArrayList<Utilisateur>();
    public Fiche() {}
    public Fiche(String name, Section section, String url, String lieu, String note, Integer tempsMinutes) {
        this.url = url;
        this.note =note;
        this.tempsMinutes =tempsMinutes;
        this.name = name;
        this.section = section;
        this.lieu = lieu;
    }

    public Fiche(String name) {
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


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }





    public Integer getTempsMinutes() {
        return tempsMinutes;
    }

    public void setTempsMinutes(Integer tempsMinutes) {
        this.tempsMinutes = tempsMinutes;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    @OneToMany(mappedBy = "fiche", cascade = CascadeType.PERSIST)
    public List<Tags> getTags() {
        return tags;
    }

    public void setTags(List<Tags> tags) {
        this.tags = tags;
    }



    @Override
    public String toString() {
        return "Fiche {   id=" + id + ", name=" + name + ", section="
                +section.toString()+" }";
    }



    @ManyToOne
    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }

    @ManyToMany(mappedBy = "fiches", cascade = CascadeType.PERSIST)
    public List<Utilisateur> getUtilisateurs() {
        return utilisateurs;
    }

    public void setUtilisateurs(List<Utilisateur> utilisateurs) {
        this.utilisateurs = utilisateurs;
    }



    public static List<Fiche> getFiches() {
        String query = "select * from Fiche";
        return EntityManagerHelper.getEntityManager().createQuery(query, Fiche.class).getResultList();
    }


    public static void saveFiche(Fiche ficheAO)
    {
        EntityTransaction et= EntityManagerHelper.getEntityManager().getTransaction();
        et.begin();

        EntityManagerHelper.getEntityManager().persist(ficheAO);

        et.commit();
    }


    public static List<Fiche> getFichesWithOutUsers() {
        String query = "select * from Fiche where utilisateurs is EMPTY";
        return EntityManagerHelper.getEntityManager().createQuery(query, Fiche.class).getResultList();
    }

    public  static List<Fiche> getFichesWithOutTags() {
        String query = "select * from Fiche  where tags is EMPTY";
        return EntityManagerHelper.getEntityManager().createQuery(query, Fiche.class).getResultList();
    }



    public static List<Fiche> getFiche1() {
        String query = "select * from Fiche  where name='fiche1'";
        return EntityManagerHelper.getEntityManager().createQuery(query, Fiche.class).getResultList();
    }



    public static List<Fiche> getFichesTagsImportant() {
        String query = "select * from Fiche  join tags  where tags.name='Important'";
        return EntityManagerHelper.getEntityManager().createQuery(query, Fiche.class).getResultList();
    }

    public static List<Fiche> getFichesTagsPriority() {
        String query = "select * from Fiche  join tags  where tags.name='Priority'";
        return EntityManagerHelper.getEntityManager().createQuery(query, Fiche.class).getResultList();
    }

    public static List<Fiche> getFichesParam(String name) {
        String query = "select * from Fiche join  tags  where tags.name=:name";
        return EntityManagerHelper.getEntityManager().createQuery(query, Fiche.class)
                .setParameter("name", name).getResultList();
    }



    public  static List<Fiche> get4FichesASCfiches() {
        String query = "select  * from Fiche  ORDER BY name ASC";
        return EntityManagerHelper.getEntityManager().
                createQuery(query, Fiche.class)
                .setFirstResult(1).setMaxResults(4)
                .getResultList();
    }
    public static List<Fiche> get4FirstDESCfiches() {
        String query = "select * from Fiche  ORDER BY name DESC";
        return EntityManagerHelper.getEntityManager().
                createQuery(query, Fiche.class)
                .setFirstResult(1).setMaxResults(4)
                .getResultList();
    }

    public static List<Fiche> getAllMFichenative() {
        String query = "select * from Fiche";
        return EntityManagerHelper.getEntityManager().
                createNativeQuery(query, Fiche.class).getResultList();
    }
    public static List<Fiche> getAllficheswithutilisateursLoaded() {
        String query = "SELECT * from Fiche  "
                + "where name='fiche1' join fetch utilisateurs.name";
        return EntityManagerHelper.getEntityManager().createQuery(query, Fiche.class).getResultList();
    }




}
