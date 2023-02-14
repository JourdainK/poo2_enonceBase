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

    // return true if oeuvre found in listOuvrages
    public boolean isOuvrageIn(Ouvrage oeuvre){
        boolean checkOeuvreIn = false;
        for(Ouvrage o:listOuvrages){
            if(oeuvre.equals(o)){
                checkOeuvreIn = true;
            }
        }

        return checkOeuvreIn;
    }

    public boolean addOuvrage(Ouvrage oeuvre){
        boolean checkIsin;

        checkIsin = isOuvrageIn(oeuvre);
        if(checkIsin){
            System.out.println(oeuvre.getTitre() + " est déja inscrit dans la liste des oeuvres de " + this.getNom());
            return false;
        }
        else{
            listOuvrages.add(oeuvre);
            return true;
        }
    }

    public boolean suppressOuvrage(Ouvrage oeuvre){
        boolean isIn;
        isIn = isOuvrageIn(oeuvre);
        if(isIn){
            listOuvrages.remove(oeuvre);
            System.out.println(oeuvre.getTitre() + " a été effacé de la liste des oeuvres de " + this.nom);
            return true;
        }

        else{
            System.out.println(oeuvre.getTitre() + " n'était pas présent dans la liste de " + this.nom + " et n'as donc pas pu être retiré.");
            return false;
        }
    }

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
