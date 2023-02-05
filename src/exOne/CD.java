package exOne;

import java.util.Objects;

public class CD extends Ouvrage{
    private long code;
    private byte nbrePlages;
    private String dureeTotale;

    public CD(String titre, String dateParution, String langue, String genre, TypeOuvrage typeOuvrage, byte ageMin, double prixLocation, long code, byte nbrePlages, String dureeTotale) {
        super(titre, dateParution, langue, genre, typeOuvrage, ageMin, prixLocation);
        this.code = code;
        this.nbrePlages = nbrePlages;
        this.dureeTotale = dureeTotale;
    }

    public long getCode() {
        return code;
    }

    public byte getNbrePlages() {
        return nbrePlages;
    }

    public String getDureeTotale() {
        return dureeTotale;
    }

    public void setDureeTotale(String dureeTotale){
        this.dureeTotale = dureeTotale;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CD cd = (CD) o;
        return code == cd.code;
    }

    @Override
    public int hashCode() {
        return Objects.hash(code);
    }

    @Override
    public String toString() {
        return "\n-- CD --\n" + super.toString() +
                "\nCode : " + code +
                "\nNoombre de pistes : " + nbrePlages +
                "\tDurée totale : " + dureeTotale;
    }

}
