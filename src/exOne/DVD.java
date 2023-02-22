package exOne;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import static exOne.TypeOuvrage.DVD;

public class DVD extends Ouvrage{
    private long code;
    private String dureeTotale;
    private byte nbreBonus;
    private List<String> autresLangues, sousTitres;

    public DVD(String titre, LocalDate dateParution, String langue, String genre, byte ageMin, double prixLocation, Auteur auteur, long code, String dureeTotale, byte nbreBonus) {
        super(titre, dateParution, langue, genre, DVD, ageMin, prixLocation, auteur);
        this.code = code;
        this.dureeTotale = dureeTotale;
        this.nbreBonus = nbreBonus;
        this.autresLangues = new ArrayList<>();
        this.sousTitres = new ArrayList<>();
    }

    public long getCode() {
        return code;
    }

    public String getDureeTotale() {
        return dureeTotale;
    }

    public byte getNbreBonus() {
        return nbreBonus;
    }

    public List<String> getAutresLangues() {
        return autresLangues;
    }

    public List<String> getSousTitres() {
        return sousTitres;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DVD dvd = (DVD) o;
        return code == dvd.code;
    }

    @Override
    public int hashCode() {
        return Objects.hash(code);
    }

    //TODO check this method
    @Override
    public String toString() {

        return "\n-- DVD --\n" + super.toString() +
                "\nCode : " + code +
                "\nDurée Totale : " + dureeTotale +
                "\tNombre de bonus : " + nbreBonus;
    }
}
