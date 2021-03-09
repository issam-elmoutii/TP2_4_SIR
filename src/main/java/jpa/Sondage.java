package jpa;

import java.util.List;
import domain.Utilisateur;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


@Entity
public class Sondage {
    private long id;
    private Boolean pause;
    private Reunion reunion;
    private Utilisateur user;
    private List<Proposition> propositions;

    public Sondage() {
        super();
    }

    public Sondage(long id, Boolean pause, Reunion reunion, Utilisateur user) {
        super();
        this.id = id;

        this.pause = pause;
        this.reunion = reunion;
        this.user = user;
    }


    public Sondage(Boolean pause, Reunion reunion, Utilisateur user, List<Proposition> propositions) {
        super();
        this.pause = pause;
        this.reunion = reunion;
        this.user = user;
        this.propositions = propositions;
    }

    public Sondage(Boolean pause, Reunion reunion, Utilisateur user) {
        super();
        this.pause = pause;
        this.reunion = reunion;
        this.user = user;
    }

    @Id
    @GeneratedValue
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Boolean getPause() {
        return pause;
    }

    public void setPause(Boolean pause) {
        this.pause = pause;
    }

    @OneToOne
    public Reunion getReunion() {
        return reunion;
    }

    public void setReunion(Reunion reunion) {
        this.reunion = reunion;
    }

    @ManyToOne
    public Utilisateur getUser() {
        return user;
    }

    @OneToMany(mappedBy="sondages")
    public void setUser(Utilisateur user) {
        this.user = user;
    }

    @ManyToMany
    public List<Proposition> getPropositions() {
        return propositions;
    }

    public void setPropositions(List<Proposition> propositions) {
        this.propositions = propositions;
    }

}
