package exOne;

public class Location {
    private String dateLoc, dateRestitution;
    private double amende;
    private Exemplaire exemplaire;

    public Location(String dateLoc, String dateRestitution, Exemplaire examplaire) {
        this.dateLoc = dateLoc;
        this.dateRestitution = dateRestitution;
        this.exemplaire = examplaire;
        this.amende = 0;
    }

    public Location(String dateLoc, String dateRestitution,Exemplaire exemplaire, double amende) {
        this.dateLoc = dateLoc;
        this.dateRestitution = dateRestitution;
        this.exemplaire = exemplaire;
        this.amende = amende;
    }

    public String getDateLoc() {
        return dateLoc;
    }

    public String getDateRestitution() {
        return dateRestitution;
    }

    public double getAmende() {
        return amende;
    }

    public void setAmende(double amende) {
        this.amende = amende;
    }

    //TODO add lecteur and method needed to handle them

}
