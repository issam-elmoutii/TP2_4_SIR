package jpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Reunion {
    long idReunion;
    String intitule;
    String resume;
    String notes;
    Sondage sondage;

    public Reunion() {
        super();
    }

    public Reunion(long idReunion, String intitule, String resume, String notes) {
        super();
        this.idReunion = idReunion;
        this.intitule = intitule;
        this.resume = resume;
        this.notes = notes;
    }

    public Reunion(String intitule, String resume, String notes) {
        super();
        this.intitule = intitule;
        this.resume = resume;
        this.notes = notes;
    }

    public Reunion(long idReunion, String intitule, String resume, String notes, Sondage sondage) {
        super();
        this.idReunion = idReunion;
        this.intitule = intitule;
        this.resume = resume;
        this.notes = notes;
        this.sondage = sondage;
    }

    @Id
    @GeneratedValue
    public long getIdReunion() {
        return idReunion;
    }

    public void setIdReunion(long idReunion) {
        this.idReunion = idReunion;
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @OneToOne
    public Sondage getSondage() {
        return sondage;
    }

    public void setSondage(Sondage sondage) {
        this.sondage = sondage;
    }
}
