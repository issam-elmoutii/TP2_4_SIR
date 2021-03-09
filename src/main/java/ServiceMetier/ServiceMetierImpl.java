package ServiceMetier;

import java.util.List;

import domain.Utilisateur;

public class ServiceMetierImpl implements ServiceMetier {

    public List<Utilisateur> getUsers(Utilisateur user) {

        return jpa.EntityManagerHelper.getEntityManager()
                .createQuery("select u from User u", Utilisateur.class)
                .setParameter("user", user).getResultList();


    }

}
