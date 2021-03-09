package jpa;

import java.util.Date;
import java.util.List;
import domain.Utilisateur;
import javax.persistence.Entity;

@Entity
public class SondageDateLieu extends Sondage {

    private String lieu;

    private Date date;

    public SondageDateLieu() {
        super();
        // TODO Auto-generated constructor stub
    }

    public SondageDateLieu(Boolean pause, Reunion reunion, Utilisateur user, List<Proposition> propositions) {
        super(pause, reunion, user, propositions);
        // TODO Auto-generated constructor stub
    }

    public SondageDateLieu(Boolean pause, Reunion reunion, Utilisateur user) {
        super(pause, reunion, user);
        // TODO Auto-generated constructor stub
    }

    public SondageDateLieu(long id, Boolean pause, Reunion reunion, Utilisateur user) {
        super(id, pause, reunion, user);
        // TODO Auto-generated constructor stub
    }

    public SondageDateLieu(String lieu, Date date) {
        super();
        this.lieu = lieu;
        this.date = date;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
