package ServiceMetier;

import java.util.List;

import domain.Utilisateur;

public interface ServiceMetier {

    List<Utilisateur> getUsers(Utilisateur user);
}
