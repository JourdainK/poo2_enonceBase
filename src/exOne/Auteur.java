package exOne;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Auteur {
    private String nom, prenom, nationalite;
    private List<Ouvrage> listOuvrages = new ArrayList<>();

    public Auteur(String nom, String prenom, String nationalite) {
        this.nom = nom;
        this.prenom = prenom;
        this.nationalite = nationalite;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getNationalite() {
        return nationalite;
    }

    //TODO check the equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Auteur auteur = (Auteur) o;
        return Objects.equals(nom, auteur.nom) &&
                Objects.equals(prenom, auteur.prenom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nom);
    }

    public void setListOuvrages(Ouvrage ouvrage) {
        this.listOuvrages.add(ouvrage);
    }
}
