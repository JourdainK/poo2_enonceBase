package exOne;

import java.util.Objects;

public class Exemplaire {
    private long matricule;
    private String descriptionEtat;
    private Rayon rayonExamplaire;

    public Exemplaire(long matricule, String descriptionEtat, Rayon rayonExemplaire){
        this.matricule = matricule;
        this.descriptionEtat = descriptionEtat;
        this.rayonExamplaire = rayonExemplaire;
    }

    public long getMatricule() {
        return matricule;
    }

    public String getDescriptionEtat() {
        return descriptionEtat;
    }

    public void setRayonExamplaire(Rayon rayonExamplaire) {
        this.rayonExamplaire = rayonExamplaire;
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
