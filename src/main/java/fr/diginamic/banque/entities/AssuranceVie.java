package fr.diginamic.banque.entities;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.time.LocalDate;
import java.util.Set;

@Entity
@DiscriminatorValue("AV")
public class AssuranceVie extends Compte{

    @Column(name = "DATE_FIN")
    private LocalDate dateFin;

    @Column(name = "TAUX")
    private Double taux;

    public AssuranceVie() {
    }

    public AssuranceVie(LocalDate dateFin, Double taux) {
        this.dateFin = dateFin;
        this.taux = taux;
    }

    public LocalDate getDateFin() {
        return dateFin;
    }

    public void setDateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
    }

    public Double getTaux() {
        return taux;
    }

    public void setTaux(Double taux) {
        this.taux = taux;
    }

    @Override
    public String toString() {
        return "AssuranceVie{" +
                "dateFin=" + dateFin +
                ", taux=" + taux +
                '}';
    }
}
