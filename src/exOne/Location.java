package exOne;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Location {
    private LocalDate dateLoc, dateRestitution;
    private double amende;
    private Exemplaire exemplaire;
    private Lecteur lecteurLocation;

    public Location(LocalDate dateLoc, LocalDate dateRestitution, Exemplaire exemplaire,Lecteur lecteurLocation) {
        this.dateLoc = dateLoc;
        this.dateRestitution = dateRestitution;
        this.exemplaire = exemplaire;
        this.lecteurLocation = lecteurLocation;
        this.amende = 0;
        this.exemplaire.getListLocations().add(this);
    }

    public LocalDate getDateLoc() {
        return dateLoc;
    }

    public LocalDate getDateRestitution() {
        return dateRestitution;
    }

    public Lecteur getLecteurLocation() {
        return lecteurLocation;
    }

    public double getAmende() {
        return amende;
    }

    public void setAmende(double amende) {
        this.amende = amende;
    }

    public void setDateRestitution(LocalDate dateRestitution) {
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

    @Override
    public String toString() {
        return "-- Location --\n" +
                "\nDate de la location : " + dateLoc +
                "\nDate de la restitution : " + dateRestitution +
                "\nAmende : " + amende +
                "\n" + exemplaire +
                "\n" + lecteurLocation;
    }
}
