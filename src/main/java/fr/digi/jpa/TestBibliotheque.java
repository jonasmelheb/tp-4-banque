package fr.digi.jpa;

import fr.digi.jpa.entities.Client;
import fr.digi.jpa.entities.Emprunt;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class TestBibliotheque {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-hibernate");
        System.out.println("connected db");
        EntityManager em = emf.createEntityManager();

        //Réalisez une requête qui permet d’extraire un emprunt et tous ses livres associés.
        TypedQuery<Emprunt> query2 = em.createQuery("select e from Emprunt e where e.id=1", Emprunt.class);
        Emprunt emprunt = query2.getResultList().get(0);

        System.out.println(emprunt.getId());
        System.out.println("2 nd query");
        System.out.println(emprunt.getClient().getNom());
        System.out.println("3 rd query");
        System.out.println(emprunt.getLivres());

        //Réalisez une requête qui permet d’extraire tous les emprunts d’un client donné.
        TypedQuery<Emprunt> query3 = em.createQuery("select e from Emprunt e join e.client c where c.id=1", Emprunt.class);
        List<Emprunt> emprunts = query3.getResultList();
        for (Emprunt e :
                emprunts) {
            System.out.println(e.getId() + " " + e.getDate_debut());
        }

        em.close();
        emf.close();
    }
}
