package exOne;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Auteur {
    private String nom, prenom, nationalite;
    private List<Ouvrage> listOuvrages;

    public Auteur(String nom, String prenom, String nationalite) {
        this.nom = nom;
        this.prenom = prenom;
        this.nationalite = nationalite;
        this.listOuvrages = new ArrayList<>();
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

    public void setListOuvrages(List<Ouvrage> listOuvrages) {
        this.listOuvrages = listOuvrages;
    }

    //TODO make IsOuvrageIn ==> Check if added Ouvrage isn't already inside List of Ouvrages

    //TODO check the equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Auteur auteur = (Auteur) o;
        return Objects.equals(nom, auteur.nom) &&
                Objects.equals(prenom, auteur.prenom) &&
                Objects.equals(nationalite, auteur.nationalite);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nom);
    }


    @Override
    public String toString() {
        return "\n-- Auteur --" +
                "\nNom : " + nom +
                "\t\tPrénom : " + prenom +
                "\nNationalite : " + nationalite;
    }
}
