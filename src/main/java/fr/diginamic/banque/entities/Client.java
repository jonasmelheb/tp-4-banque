package fr.diginamic.banque.entities;

import fr.diginamic.banque.service.ListService;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "CLIENT")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NOM")
    private String nom;

    @Column(name = "PRENOM")
    private String prenom;

    @Embedded
    private Adresse adresse;

    @ManyToOne
    @JoinColumn(name = "ID_BANQUE")
    private Banque banque;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name="CLI_COM",
            joinColumns= @JoinColumn(name="ID_CLI", referencedColumnName="ID"),
            inverseJoinColumns= @JoinColumn(name="ID_COM", referencedColumnName= "ID")
    )
    private Set<Compte> comptes;

    {
        comptes = new HashSet<>();
    }

    public Client() {
    }

    public Client(String nom, String prenom, Adresse adresse, Banque banque, Set<Compte> comptes) {
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.banque = banque;
        this.comptes = comptes;
    }

    public Client(Long id, String nom, String prenom, Adresse adresse, Banque banque, Set<Compte> comptes) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.banque = banque;
        this.comptes = comptes;
    }

    public Client(String nom, String prenom, Adresse adresse, Banque banque) {
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.banque = banque;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public Banque getBanque() {
        return banque;
    }

    public void setBanque(Banque banque) {
        // Si ce client était déjà lié à une banque
        // -> Suppression du client dans la liste de la banque associé
        if (this.banque != null){
            this.banque.getClients().remove(this);
        }

        //Changement de banque associé
        this.banque = banque;

        //Ajout du client dans la liste de la banque associé
        if (banque != null) {
            banque.getClients().add(this);
        }
    }

    public Set<Compte> getComptes() {
        return comptes;
    }

    public void setComptes(Set<Compte> comptes) {
        if (comptes == null){
            return;
        }
        this.comptes = comptes;
    }

    public void addCompte(Compte compte) {
        if (compte == null) {
            return;
        }

        // this.addCompte se fait en caché lors de l'ajout du client au compte en question
        compte.addClient(this);
    }

    public void removeCompte(Compte compte) throws Exception {
        if (compte == null){
            return;
        }
        //Le retrait du compte de la liste de nos comptes se fait dans la methode
        // de retrait de client du compte en question
        compte.removeClient(this);
    }

    public void checkIfRemovePermitOnComptes(Set<Compte> list) throws Exception {
        if (ListService.isNullAfterRemove(list)){
            throw new Exception("comptes can't be empty");
        }
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", adresse=" + adresse +
                ", banque=" + banque +
                ", comptes=" + comptes +
                '}';
    }
}
