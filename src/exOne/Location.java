package exOne;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Location {
    private String dateLoc, dateRestitution;
    private double amende;
    private Exemplaire exemplaire;
    private Lecteur lecteurLocation;

    /*
    public Location (String dateRestitution){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/YYYY");
        String today = LocalDate.now().format(formatter);
        //System.out.println(todday);
        this.dateLoc = today;
    }

     */

    public Location(String dateLoc, String dateRestitution, Exemplaire exemplaire,Lecteur lecteurLocation) {
        this.dateLoc = dateLoc;
        this.dateRestitution = dateRestitution;
        this.exemplaire = exemplaire;
        this.lecteurLocation = lecteurLocation;
        this.amende = 0;
    }

    public Location(Exemplaire exemplaire,  Lecteur lecteurLocation) {
        this.exemplaire = exemplaire;
        this.lecteurLocation = lecteurLocation;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return Objects.equals(dateLoc, location.dateLoc) && Objects.equals(exemplaire, location.exemplaire) && Objects.equals(lecteurLocation, location.lecteurLocation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dateLoc, exemplaire, lecteurLocation);
    }
}
