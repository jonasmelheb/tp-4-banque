package fr.diginamic.banque.entities;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Set;

@Entity
@DiscriminatorValue("LA")
public class LivretA extends Compte{

    @Column(name = "TAUX")
    private Double taux;

    public LivretA() {
    }

    public LivretA(Double taux) {
        this.taux = taux;
    }

    public LivretA(String numero, Double sold, Set<Client> clients, Operation operation, Double taux) {
        super(numero, sold, clients, operation);
        this.taux = taux;
    }

    public LivretA(Long id, String numero, Double sold, Set<Client> clients, Operation operation, Double taux) {
        super(id, numero, sold, clients, operation);
        this.taux = taux;
    }

    public Double getTaux() {
        return taux;
    }

    public void setTaux(Double taux) {
        this.taux = taux;
    }

    @Override
    public String toString() {
        return "LivretA{" +
                "taux=" + taux +
                '}';
    }
}
