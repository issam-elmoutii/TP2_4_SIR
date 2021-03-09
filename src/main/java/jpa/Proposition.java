package jpa;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Proposition {
    private long id;
    private Date choixDate;
    List<Sondage> sondage;
    public Proposition() {
        super();
    }

    public Proposition(long id, Date choixDate, List<Sondage> sondage) {
        super();
        this.id = id;
        this.choixDate = choixDate;
        this.sondage = sondage;
    }

    @Id
    @GeneratedValue
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Temporal(TemporalType.DATE)
    public Date getChoixDate() {
        return choixDate;
    }

    public void setChoixDate(Date choixDate) {
        this.choixDate = choixDate;
    }

    @ManyToMany
    public List<Sondage> getSondage() {
        return sondage;
    }

    public void setSondage(List<Sondage> sondage) {
        this.sondage = sondage;
    }
}