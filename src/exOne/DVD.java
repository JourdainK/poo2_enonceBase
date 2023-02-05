package exOne;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DVD extends Ouvrage{
    private long code;
    private String dureeTotale;
    private byte nbreBonus;
    private List<String> autresLangues, sousTitres;

    public DVD(String titre, String dateParution, String langue, String genre, String typeOuvrage, byte ageMin, double prixLocation, long code, String dureeTotale, byte nbreBonus) {
        super(titre, dateParution, langue, genre, typeOuvrage, ageMin, prixLocation);
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
        String listLangs = "", listSubs = "";
        int i=1, j=1;

        for(String l:autresLangues){
            listLangs += i + " - "+ l + "\n";
            i++;
        }

        for(String s:autresLangues){
            listSubs += j + " - " + s + "\n";
            j++;
        }

        return "\n-- DVD --\n" + super.toString() +
                "\nCode : " + code +
                "\nDurée Totale : " + dureeTotale +
                "\tNombre de bonus : " + nbreBonus +
                "\nLangues disponibles :\n" + listLangs +
                "\nSous-titres disponbles : \n" + listSubs;
    }
}
