package exOne;

import java.util.ArrayList;
import java.util.List;

public abstract class Ouvrage {
    protected String titre, dateParution, langue, genre, typeOuvrage;
    protected byte ageMin;
    protected  double prixLocation;
    protected List<Auteur> listAuteurs;

    public Ouvrage(String titre, String dateParution, String langue, String genre, String typeOuvrage, byte ageMin, double prixLocation) {
        this.titre = titre;
        this.dateParution = dateParution;
        this.langue = langue;
        this.genre = genre;
        this.typeOuvrage = typeOuvrage;
        this.ageMin = ageMin;
        this.prixLocation = prixLocation;
        this.listAuteurs = new ArrayList<>();
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
    public void setListAuteurs(Auteur auteur) {
        this.listAuteurs.add(auteur);
    }
}
