package exOne;

import java.time.LocalDate;
import java.util.Objects;
import static exOne.TypeOuvrage.LIVRE;

public class Livre extends Ouvrage{
    private String isbn, resume;

    private TypeLivre tl;
    private int nombrePages;


    public Livre(String titre, LocalDate dateParution, String langue, String genre, byte ageMin, double prixLocation, Auteur auteur, String isbn, TypeLivre typeLivre, String resume, int nombrePages) {
        super(titre, dateParution, langue, genre, LIVRE, ageMin, prixLocation, auteur);
        this.isbn = isbn;
        this.resume = resume;
        this.tl = typeLivre;
        this.nombrePages = nombrePages;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getResume() {
        return resume;
    }

    public TypeLivre getTypeLivre() {
        return tl;
    }

    public int getNombrePages() {
        return nombrePages;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public void setTypeLivre(TypeLivre typeLivre) {
        this.tl = typeLivre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Livre livre = (Livre) o;
        return Objects.equals(isbn, livre.isbn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isbn);
    }

    @Override
    public String toString() {
        return  "\n-- Livre --\n" + super.toString() +
                "\nN° isbn : " + isbn +
                "\n\nRésumé : " + resume +
                "\nType de livre : " + tl +
                "\t\tnombre de pages : " + nombrePages;
    }
}
