package bibliotheque.metier;

import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

public class Location {
    private LocalDate dateLocation;
    private LocalDate dateRestitution;
    private Lecteur loueur;
    private Exemplaire exemplaire;

    public Location(LocalDate dateLocation, LocalDate dateRestitution, Lecteur loueur, Exemplaire exemplaire) {
        this.dateLocation = dateLocation;
        this.dateRestitution = dateRestitution;
        this.loueur = loueur;
        this.exemplaire = exemplaire;
        if(this.getExemplaire().getOuvrage() instanceof Livre){
            this.dateRestitution = dateLocation.plusDays(15);
        } else if (this.getExemplaire().getOuvrage() instanceof DVD) {
            this.dateRestitution = dateLocation.plusDays(3);
        }
        else{
            //cd
            this.dateRestitution = dateLocation.plusDays(7);
        }
        this.loueur.getLloc().add(this);
        this.exemplaire.getLloc().add(this);
    }

    public Location(Lecteur loueur, Exemplaire exemplaire) {
        this.loueur = loueur;
        this.exemplaire = exemplaire;
        this.dateLocation=LocalDate.now();
    }

    public LocalDate getDateLocation() {
        return dateLocation;
    }

    public void setDateLocation(LocalDate dateLocation) {
        this.dateLocation = dateLocation;
    }

    public LocalDate getDateRestitution() {
        return dateRestitution;
    }

    public void setDateRestitution(LocalDate dateRestitution) {
        this.dateRestitution = dateRestitution;
    }

    public Lecteur getLoueur() {
        return loueur;
    }

    public void setLoueur(Lecteur loueur) {
        this.loueur = loueur;
    }

    public Exemplaire getExemplaire() {
        return exemplaire;
    }

    public void setExemplaire(Exemplaire exemplaire) {
        this.exemplaire = exemplaire;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return Objects.equals(dateLocation, location.dateLocation) && Objects.equals(loueur, location.loueur) && Objects.equals(exemplaire, location.exemplaire);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dateLocation, loueur, exemplaire);
    }

    @Override
    public String toString() {
        //TODO check old version / compare
        return "Location{" +
                "dateLocation=" + dateLocation +
                ", dateRestitution=" + dateRestitution +
                ", loueur=" + loueur +
                ", exemplaire=" + exemplaire +
                '}';
    }

    public double calculerAmende(){
        //dateRestitution -> selon instance of calculée directement selon cd, dvd, livres
        Period diff;
        double amende;
        int jRetard = 0;

        diff = this.dateRestitution.until(LocalDate.now());
        jRetard = ((diff.getYears()*12)*30) + (diff.getMonths()*30) + diff.getDays();
        amende = this.getExemplaire().getOuvrage().amendeRetard(jRetard);

        return amende;

    }
    public void enregistrerRetour(){
        this.dateRestitution = LocalDate.now();
    }
}
