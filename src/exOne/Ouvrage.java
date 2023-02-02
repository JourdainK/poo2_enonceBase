package exOne;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class Ouvrage {
    protected String titre, dateParution, langue, genre, typeOuvrage;
    protected byte ageMin;
    protected  double prixLocation;
    protected List<Auteur> listAuteurs;
    protected List<Exemplaire> listExemplaire;

    public Ouvrage(String titre, String dateParution, String langue, String genre, String typeOuvrage, byte ageMin, double prixLocation) {
        this.titre = titre;
        this.dateParution = dateParution;
        this.langue = langue;
        this.genre = genre;
        this.typeOuvrage = typeOuvrage;
        this.ageMin = ageMin;
        this.prixLocation = prixLocation;
        this.listExemplaire = new ArrayList<>();
    }

    public String getTitre() {
        return titre;
    }

    public String getDateParution() {
        return dateParution;
    }

    public String getLangue() {
        return langue;
    }

    public String getGenre() {
        return genre;
    }

    public String getTypeOuvrage() {
        return typeOuvrage;
    }

    public byte getAgeMin() {
        return ageMin;
    }

    public double getPrixLocation() {
        return prixLocation;
    }

    public void setListAuteurs(List<Auteur> listAuteurs) {
        this.listAuteurs = listAuteurs;
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

    /*
    had hesitation about whether to created "Exemplaire" inside or outside "Ouvrage"
    => After asking chatGpt : chosen to create it outside "Ouvrage" for more flexibility
    ?? make the reference null after having created the "Exemplaire" => so the only ref is within "Ouvrage"
     */
    //add a copy to the List "listExemplaire" => return true > success
    public boolean addExemplaire(Exemplaire copy){
        Exemplaire exTmp;
        boolean isCopyIn,isCopyAdded;
        Scanner sc = new Scanner(System.in);
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


}
