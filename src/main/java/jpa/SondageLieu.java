package jpa;

import java.util.List;
import domain.Utilisateur;
import javax.persistence.Entity;

@Entity
public class SondageLieu extends Sondage {

    private String lieu;

    public SondageLieu() {
        super();
        // TODO Auto-generated constructor stub
    }

    public SondageLieu(Boolean pause, Reunion reunion, Utilisateur user, List<Proposition> propositions) {
        super(pause, reunion, user, propositions);
        // TODO Auto-generated constructor stub
    }

    public SondageLieu(Boolean pause, Reunion reunion, Utilisateur user) {
        super(pause, reunion, user);
        // TODO Auto-generated constructor stub
    }

    public SondageLieu(long id, Boolean pause, Reunion reunion, Utilisateur user) {
        super(id, pause, reunion, user);
        // TODO Auto-generated constructor stub
    }

    public SondageLieu(String lieu) {
        super();
        this.lieu = lieu;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

}
