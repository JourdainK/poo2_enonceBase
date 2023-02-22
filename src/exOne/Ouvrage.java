package exOne;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class Ouvrage {
    protected String titre, langue, genre;
    protected LocalDate dateParution;
    protected TypeOuvrage typeOuvrage;
    protected byte ageMin;
    protected  double prixLocation;
    protected List<Auteur> listAuteurs;
    protected List<Exemplaire> listExemplaire;

    public Ouvrage(String titre, LocalDate dateParution, String langue, String genre, TypeOuvrage typeOuvrage, byte ageMin, double prixLocation, Auteur auteur) {
        this.titre = titre;
        this.dateParution = dateParution;
        this.langue = langue;
        this.genre = genre;
        this.typeOuvrage = typeOuvrage;
        this.ageMin = ageMin;
        this.prixLocation = prixLocation;
        this.listExemplaire = new ArrayList<>();
        this.listAuteurs = new ArrayList<>();
        this.listAuteurs.add(auteur);
        //TODO Ask teacher about this ???? seems wrong but works ? mustn't be good pratice
        this.listAuteurs.get(this.listAuteurs.indexOf(auteur)).addOuvrage(this);
    }

    public String getTitre() {
        return titre;
    }

    public LocalDate getDateParution() {
        return dateParution;
    }

    public String getLangue() {
        return langue;
    }

    public String getGenre() {
        return genre;
    }

    public TypeOuvrage getTypeOuvrage() {
        return typeOuvrage;
    }

    public byte getAgeMin() {
        return ageMin;
    }

    public double getPrixLocation() {
        return prixLocation;
    }

    public List<Auteur> getListAuteurs() {
        return listAuteurs;
    }

    public List<Exemplaire> getListExemplaire() {
        return listExemplaire;
    }

    public void setListAuteurs(List<Auteur> listAuteurs) {
        this.listAuteurs = listAuteurs;
    }

    public void setListExemplaire(List<Exemplaire> listExemplaire) {
        this.listExemplaire = listExemplaire;
    }

    @Override
    public String toString() {


        return
                "Titre :" + titre +
                "\n\nDate de parution : " + dateParution +
                "\t\tLangue : " + langue +
                "\nGenre : " + genre +
                "\t\tType d'ouvrage : " + typeOuvrage +
                "\nÂge minimum : " + ageMin +
                "\t\tPrix de la location : " + prixLocation ;
    }

    //check if author is in listAuteurs ==> return true if author is found in listAuteurs
    public boolean isAuthorIn(Auteur author){
        boolean checkAuthor = false;

        for(Auteur m:listAuteurs){
            if(author.equals(m)){
                checkAuthor = true;
            }
        }
        return checkAuthor;
    }

    //add method that'll add one author to the List of authors if it isn't in the List 'listAuteurs'
    public void addAuthor(Auteur auteur){
        boolean checkAddAuthor;

        checkAddAuthor = isAuthorIn(auteur);
        if(checkAddAuthor){
            System.out.println("L'auteur est déja présent dans la liste");
        }
        else{
            listAuteurs.add(auteur);
            System.out.println(auteur.getNom() + "à été ajouté à la liste des auteurs de " + titre + ".");
        }
    }


    //add a copy to the List "listExemplaire" => return true > success
    public boolean addExemplaire(Exemplaire copy){
        boolean isCopyIn,isCopyAdded;
        isCopyIn = isExemplaireIn(copy);

        if(isCopyIn){
            isCopyAdded = false;
        }
        else{
            listExemplaire.add(copy);
            System.out.println("Exemplaire ajouté.");
            isCopyAdded = true;
        }

        return isCopyAdded;
    }

    //check if copy is in listExemplaire > return true if found
    public boolean isExemplaireIn(Exemplaire copy){
        boolean checkIfIsIn = false;

        for(Exemplaire c:listExemplaire){
            if(copy.equals(c)){
                checkIfIsIn = true;
            }
        }

        return checkIfIsIn;
    }

    public void listerExemplaires(){
        int i=1;

        for(Exemplaire l:listExemplaire){
            System.out.print("\n" + i + " ) ");
            System.out.println(l.getOuvrage() + "\n");
            i++;
        }
    }

    //TODO verify this when correction comes in
    public void listerExemplaires(boolean Enlocation){
        int j = 1;

        for(Exemplaire le:listExemplaire){
            if(le.enLocation()){
                System.out.print(j + " ) ");
                System.out.println(le);
                j++;
            }
        }
    }

    //TODO AmendeRetard -> abstract IN OUVRAGE-> methods in DVD,CD , Livre
    //??? comment récuperer le prix de l'amende ? -> qui se trouve dans Location...?
    //calculerAmende dans Location ????
    //public abstract double amendeRetard(int njours);

}
