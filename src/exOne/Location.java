package exOne;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Location {
    private String dateLoc, dateRestitution;
    private double amende;
    private Exemplaire exemplaire;
    private Lecteur lecteurLocation;

    public Location (String dateRestitution){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/YYYY");
        String today = LocalDate.now().format(formatter);
        //System.out.println(todday);
        this.dateLoc = today;
    }

    public Location(String dateLoc, String dateRestitution, Exemplaire exemplaire,Lecteur lecteurLocation) {
        this.dateLoc = dateLoc;
        this.dateRestitution = dateRestitution;
        this.exemplaire = exemplaire;
        this.lecteurLocation = lecteurLocation;
        this.amende = 0;
    }

    public Location(String dateLoc, String dateRestitution,Exemplaire exemplaire, double amende, Lecteur lecteurLocation) {
        this.dateLoc = dateLoc;
        this.dateRestitution = dateRestitution;
        this.exemplaire = exemplaire;
        this.lecteurLocation = lecteurLocation;
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

    public void setDateRestitution(String dateRestitution) {
        this.dateRestitution = dateRestitution;
    }

    public void setExemplaire(Exemplaire exemplaire) {
        this.exemplaire = exemplaire;
    }

    public void setLecteurLocation(Lecteur lecteurLocation) {
        this.lecteurLocation = lecteurLocation;
    }


}
