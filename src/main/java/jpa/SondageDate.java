package jpa;

import java.util.Date;
import java.util.List;
import domain.Utilisateur;
import javax.persistence.Entity;

@Entity
public class SondageDate extends Sondage {


    private Date date;

    public SondageDate() {
        super();
    }

    public SondageDate(Boolean pause, Reunion reunion, Utilisateur user, List<Proposition> propositions) {
        super(pause, reunion, user, propositions);
    }

    public SondageDate(Boolean pause, Reunion reunion, Utilisateur user) {
        super(pause, reunion, user);
    }

    public SondageDate(long id, Boolean pause, Reunion reunion, Utilisateur user) {
        super(id, pause, reunion, user);
    }

    public SondageDate( Date date) {
        super();
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
