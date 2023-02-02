package exOne;

public abstract class Ouvrage {
    protected String titre, dateParution, langue, genre, typeOuvrage;
    protected byte ageMin;
    protected  double prixLocation;

    public Ouvrage(String titre, String dateParution, String langue, String genre, String typeOuvrage, byte ageMin, double prixLocation) {
        this.titre = titre;
        this.dateParution = dateParution;
        this.langue = langue;
        this.genre = genre;
        this.typeOuvrage = typeOuvrage;
        this.ageMin = ageMin;
        this.prixLocation = prixLocation;
    }





}
