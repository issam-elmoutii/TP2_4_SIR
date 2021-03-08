package domain;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.*;
import domain.*;
import java.util.ArrayList;
import java.util.List;
import jpa.EntityManagerHelper;
import javax.persistence.EntityTransaction;
/**
 * Author: ELMOUTII Issam & GOURIRANE Yassine
 * Date: 2020/2021
 * Version 1.0
 */
@Entity
public class Utilisateur {
    private String name;
    private Long id;
    private List<Fiche> fiches = new ArrayList<Fiche>();
    public Utilisateur() {}
    public Utilisateur(String name) {
        this.name = name;
    }
    public Utilisateur(String name, Fiche fiche) {
        this.name = name;
        this.fiches.add(fiche);
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

    @Override
    public String toString() {
        return "User { id=" + id + ", name=" + name + ", tableau=" + fiches.get(0).getName() + "}";
    }


    @ManyToMany
    public List<Fiche> getFiches() {
        return fiches;
    }
    public void setFiches(List<Fiche> fiches) {
        this.fiches = fiches;
    }



    public static void saveUtilisateur(Utilisateur utilisateur) {
        EntityTransaction u = EntityManagerHelper.getEntityManager().getTransaction();

        u.begin();
        EntityManagerHelper.getEntityManager().persist(utilisateur);
        u.commit();
    }

    public static List<Utilisateur> getAllUtilisateursDao() {
        String query = "select u from Utilisateur as u";
        return EntityManagerHelper.getEntityManager().createQuery(query, Utilisateur.class).getResultList();
    }

    public static List<Utilisateur> getUtilisateur1() {
        String query = "select u from Utilisateur as u where u.name='Karla Rosas'";
        return EntityManagerHelper.getEntityManager().createQuery(query, Utilisateur.class).getResultList();
    }

    public static List<Utilisateur> getAllUtilisateursSansFicheDao() {
        String query = "select u from Utilisateur as u where u.fiches is EMPTY";
        return EntityManagerHelper.getEntityManager().createQuery(query, Utilisateur.class).getResultList();
    }

    public static List<Utilisateur> getAllUtilisateursNameLong13() {
        String query = "select u from Utilisateur as u " +
                "where LENGTH(u.name) = 13";
        return EntityManagerHelper.getEntityManager().createQuery(query, Utilisateur.class).getResultList();
    }

    public  static List<Utilisateur> get2UtilisateursASC() {
        String query = "select u from Utilisateur as u ORDER BY u.name ASC";
        return EntityManagerHelper.getEntityManager().
                createQuery(query, Utilisateur.class)
                .setFirstResult(1).setMaxResults(2)
                .getResultList();
    }
    public static List<Utilisateur> get2FirstDESCUtilisateurs() {
        String query = "select u from Utilisateur as u ORDER BY u.name DESC";
        return EntityManagerHelper.getEntityManager().
                createQuery(query, Utilisateur.class)
                .setFirstResult(1).setMaxResults(2)
                .getResultList();
    }

    public static List<Utilisateur> getAllUtilisateursNatifs() {
        String query = "select * from Utilisateur ";
        return EntityManagerHelper.getEntityManager().
                createNativeQuery(query, Utilisateur.class).getResultList();
    }
    public  static List<Utilisateur> getUtilisateurWithFichesLoaded() {
        String query = "SELECT u from Utilisateur as u "
                + "where s.name='Rabeea Kessal' join fetch u.fiche.name";
        return EntityManagerHelper.getEntityManager().createQuery(query, Utilisateur.class).getResultList();
    }

}
