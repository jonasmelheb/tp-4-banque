package fr.digi.jpa;

import fr.digi.jpa.entities.Livre;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class TestJpa {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-hibernate");
        System.out.println("connected db");
        EntityManager em = emf.createEntityManager();

        Livre livre1 = em.find(Livre.class, 1);
        System.out.println("Titre: " + livre1.getTitre() + "\nAuteur :" + livre1.getAuteur());

        em.getTransaction().begin();
        Livre livre = new Livre();
        livre.setTitre("YOUNES");
        livre.setAuteur("MELHEB");
        Integer id = livre.getId();
        System.out.println(id);
        em.persist(livre);
        em.getTransaction().commit();

        Livre livreID5 = em.find(Livre.class, 5);
        if (livreID5 != null) {
            System.out.println(livreID5.getTitre());
            livreID5.setTitre("Du plaisir dans la cuisine");
            em.persist(livreID5);
        }

        TypedQuery<Livre> query2 = em.createQuery("select l from Livre l where l.titre='Vingt mille lieues sous les mers'", Livre.class);
        System.out.println(query2.getResultList().get(0));

        emf.close();
    }
}
