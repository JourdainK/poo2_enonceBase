package exOne;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Exemplaire {
    private long matricule;
    private String descriptionEtat;
    private Ouvrage ouvrage;
    private Rayon rayonExamplaire;
    private List<Location> listLocations;

    public Exemplaire(long matricule, String descriptionEtat, Ouvrage ouvrage){
        this.matricule = matricule;
        this.descriptionEtat = descriptionEtat;
        this.ouvrage = ouvrage;
        this.ouvrage.getListExemplaire().add(this);
        this.listLocations = new ArrayList<>();
    }

    public long getMatricule() {
        return matricule;
    }

    public String getDescriptionEtat() {
        return descriptionEtat;
    }

    public Rayon getRayonExamplaire() {
        return rayonExamplaire;
    }

    public List<Location> getListLocations() {
        return listLocations;
    }

    public void setRayonExamplaire(Rayon rayonExamplaire) {
        // check /understand/ fix ==> get list of copies , remove 'this' from the list of the 'Rayon'
        if(this.rayonExamplaire!=null) this.rayonExamplaire.getListExemplaires().remove(this);
        this.rayonExamplaire = rayonExamplaire;
        //add the copy to the bookshelf (objects -> communication)
        this.rayonExamplaire.getListExemplaires().add(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Exemplaire that = (Exemplaire) o;
        return matricule == that.matricule;
    }

    @Override
    public int hashCode() {
        return Objects.hash(matricule);
    }

    @Override
    public String toString() {
        return "\n-- Exemplaire --" +
                "\nMatricule : " + matricule +
                "\tÉtat de l'exemplaire : " + descriptionEtat +
                "\nRayon : " + rayonExamplaire.getCodeRayon();
    }


}
