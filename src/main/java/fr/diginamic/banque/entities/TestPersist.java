package fr.diginamic.banque.entities;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestPersist {
    public static void main(String[] args) {
        Banque banque = new Banque();
        banque.setNom("CA");

        Adresse adresse = new Adresse();
        adresse.setNumero(21);
        adresse.setRue("blabla");
        adresse.setCodePostal(34500);
        adresse.setVille("Béziers");

        Client client = new Client();
        client.setAdresse(adresse);
        client.setNom("melheb");
        client.setPrenom("Younes");
        client.setBanque(banque);

        Compte compte = new Compte();
        compte.setNumero("2154");
        compte.setSold(2546.00);

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("banque");
        System.out.println("connected db");
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(banque);
        em.persist(client);
        transaction.commit();
        em.close();
        emf.close();
    }
}
