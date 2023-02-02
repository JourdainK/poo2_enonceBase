package exOne;

import java.util.Objects;

public class Exemplaire {
    private long matricule;
    private String descriptionEtat;

    public Exemplaire(long matricule, String descriptionEtat){
        this.matricule = matricule;
        this.descriptionEtat = descriptionEtat;
    }

    public long getMatricule() {
        return matricule;
    }

    public String getDescriptionEtat() {
        return descriptionEtat;
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
                "\tÉtat de l'exemplaire : " + descriptionEtat;
    }


}
