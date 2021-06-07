package fr.digi.jpa.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Set;

@Entity
@Table(name = "EMPRUNT")
public class Emprunt implements Serializable {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "DATE_DEBUT")
    private Timestamp date_debut;

    @Column(name = "DELAI")
    private Integer delai;

    @Column(name = "DATE_FIN")
    private Timestamp date_fin;

    @ManyToOne
    @JoinColumn(name = "ID_CLIENT")
    private Client client;

    @ManyToMany
    @JoinTable(name="COMPO",
            joinColumns= @JoinColumn(name="ID_LIV", referencedColumnName="ID"),
            inverseJoinColumns= @JoinColumn(name="ID_EMP", referencedColumnName= "ID")
    )
    private Set<Livre> livres;

    public Emprunt() {
    }

    public Emprunt(Long id, Timestamp date_debut, Integer delai, Timestamp date_fin, Client client, Set<Livre> livres) {
        this.id = id;
        this.date_debut = date_debut;
        this.delai = delai;
        this.date_fin = date_fin;
        this.client = client;
        this.livres = livres;
    }

    public Emprunt(Timestamp date_debut, Integer delai, Timestamp date_fin, Client client, Set<Livre> livres) {
        this.date_debut = date_debut;
        this.delai = delai;
        this.date_fin = date_fin;
        this.client = client;
        this.livres = livres;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Timestamp getDate_debut() {
        return date_debut;
    }

    public void setDate_debut(Timestamp date_debut) {
        this.date_debut = date_debut;
    }

    public Integer getDelai() {
        return delai;
    }

    public void setDelai(Integer delai) {
        this.delai = delai;
    }

    public Timestamp getDate_fin() {
        return date_fin;
    }

    public void setDate_fin(Timestamp date_fin) {
        this.date_fin = date_fin;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Set<Livre> getLivres() {
        return livres;
    }

    public void setLivres(Set<Livre> livres) {
        this.livres = livres;
    }

    @Override
    public String toString() {
        return "Emprunt{" +
                "id=" + id +
                ", date_debut=" + date_debut +
                ", delai=" + delai +
                ", date_fin=" + date_fin +
                ", clients=" + client +
                ", livres=" + livres +
                '}';
    }
}
