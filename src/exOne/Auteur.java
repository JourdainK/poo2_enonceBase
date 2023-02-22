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


    public void addOuvrage(Ouvrage o){
        listOuvrages.add(o);
        o.listAuteurs.add(this);
    }

    public void suppressOuvrage(Ouvrage o){
        listOuvrages.remove(o);
        o.listAuteurs.remove(this);
    }

    public void listerOuvrages(){
        int i = 1;

        System.out.println("Auteur : " + this.getNom() + "\t" + this.getPrenom() + "\n");
        for(Ouvrage o:listOuvrages){
            System.out.print(i + " ) ");
            System.out.println(o);
        }
    }

    public void listerOuvrages(TypeOuvrage typeOuvrage, TypeLivre typeLivre){
        int j=1;

        System.out.println("Auteur : " + this.getNom() + "\t" + this.getPrenom() + "\n");
        for(Ouvrage ou:listOuvrages){
            if(((Livre) ou).getTypeLivre().equals(typeLivre) && ou instanceof Livre){
                System.out.print(j + " ) ");
                System.out.println(ou);
            }
        }
    }

}
