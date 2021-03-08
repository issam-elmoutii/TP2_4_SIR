package jpa;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import domain.*;
import sun.tools.jconsole.Tab;


public class JpaTest{

	private EntityManager manager;

	public JpaTest(EntityManager manager) {
		this.manager = manager;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		EntityManager manager = EntityManagerHelper.getEntityManager();
		JpaTest test = new JpaTest(manager);


		EntityTransaction tx = manager.getTransaction();


		tx.begin();
		try {
			test.createFiches();



		} catch (Exception e) {
			e.printStackTrace();
		}
		tx.commit();




		List<Fiche> fich = Fiche.getFichesParam("Important");
		System.err.println("          ");
		System.err.println("Fiches Types Important");
		for (Fiche f: fich) {
			System.err.println("Fiche:"+f.getId()+ " Name:  "+ f.getName());}


		List<Fiche> fiche = Fiche.getFichesWithOutUsers();
		System.err.println("             ");
		System.err.println("Fiches");
		for (Fiche f: fiche) {
			System.err.println("Fiche:"+f.getId()+ " Name:  "+ f.getName());}




		List<Section> sect = Section.getAllSectionParam("fiche1");
		System.err.println("                              ");
		System.err.println(" Sections ");
		for (Section s: sect) {
			System.err.println(s.getTableau().getName()+ "      Section Name:  "+ s.getName());}




		List<Tableau> tableau = Tableau.getAllSectionOFTableauParam("En processus B");
		System.err.println("      ");
		System.err.println(" Tableaux  ");
		for (Tableau t: tableau) {
			System.err.println("Tableau Name:  "+ t.getName());}



		List<Utilisateur> Utilisateur = domain.Utilisateur.get2FirstDESCUtilisateurs();
		System.err.println("                              ");
		System.err.println("  Utilisateurs ");
		for (Utilisateur u: Utilisateur) {
			System.err.println("Utilisateur " + u.getName());}





		manager.close();
		System.out.println(".. done");
		EntityManagerHelper.closeEntityManagerFactory();
	}

	private void createFiches() {
		int numOfFiches = manager.createQuery("Select a From Fiche a", Fiche.class).getResultList().size();
		if (numOfFiches == 0) {
			Tableau tableau1 = new Tableau("Tableau Backend");
			Tableau tableau2 = new Tableau("Tableau Frontend");

			Section section1 = new Section("A faire B",tableau1);
			Section section2 = new Section("En processus B",tableau1);
			Section section3 = new Section("Taches finis  B ",tableau1);
			Section section4 = new Section("A faire F",tableau2);
			Section section5 = new Section("En processus F",tableau2);
			Section section6 = new Section("Taches finis  F ",tableau2 );
			//List<Fiche> fiches = new ArrayList<Fiche>();

			Fiche fiche1 = new Fiche("fiche1",section1,"https://www.ISTIC.fr/", "RENNES", "Faire PR1",60);
			Fiche fiche2 = new Fiche("fiche2",section2,"https://www.ISTIC.fr/", "RENNES", "Faire PR1",60);
			Fiche fiche3 = new Fiche("fiche3",section3,"https://www.ISTIC.fr/", "RENNES", "Faire PR1",60);



			Tags tag1 = new Tags("Priority",fiche2);
			Tags tag2 = new Tags("Important",fiche3);

			Utilisateur utilisateur1 = new Utilisateur("ISSAM ELMOUTII",fiche1);
			Utilisateur utilisateur2 = new Utilisateur("YASSINE GOURIRANE",fiche2);


			//fiches.add(fiche2);

			manager.persist(tableau1);
			manager.persist(tableau2);

			manager.persist(section1);
			manager.persist(section2);
			manager.persist(section3);
			manager.persist(section4);
			manager.persist(section5);
			manager.persist(section6);

			manager.persist(fiche1);
			manager.persist(fiche2);
			manager.persist(fiche3);


			manager.persist(utilisateur1 );
			manager.persist(utilisateur2 );

			manager.persist(tag1);
			manager.persist(tag2);

		}
	}

	private void listFiches() {
		List<Fiche> resultList = manager.createQuery("Select a From Fiche a", Fiche.class).getResultList();
		System.out.println("num of fiches:" + resultList.size());
		for (Fiche next : resultList) {
			System.out.println("next fiche: " + next);
		}
	}

	private void getFicheThibaultMich() {
		Fiche resultFiche = manager.createQuery("SELECT t from Fiche as t " + " where t.name='Thibault Mich'", Fiche.class).getSingleResult();
		System.out.println("La ficha es " + resultFiche);

	}

	private void listTableaux() {
		List<Tableau> resultList = manager.createQuery("Select a From Tableau a", Tableau.class).getResultList();
		System.out.println("num of fiches:" + resultList.size());
		for (Tableau next : resultList) {
			System.out.println("next Tableau: id=" + next.getId() +" Name: "+ next.getName()+" Sections: "+next.getSections());
		}
	}
}

