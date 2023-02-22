package exOne;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Lecteur {
    private long numLecteur;
    private String nom, prenom, dateNaiss, mail, adresse, tel;
    private List<Location> listLocatLecteur;

    public Lecteur(long numLecteur, String nom, String prenom, String dateNaiss, String mail, String adresse, String tel) {
        this.numLecteur = numLecteur;
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaiss = dateNaiss;
        this.mail = mail;
        this.adresse = adresse;
        this.tel = tel;
        this.listLocatLecteur = new ArrayList<>();
    }

    public long getNumLecteur() {
        return numLecteur;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getDateNaiss() {
        return dateNaiss;
    }

    public String getMail() {
        return mail;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getTel() {
        return tel;
    }

    public List<Location> getListLocatLecteur() {
        return listLocatLecteur;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lecteur lecteur = (Lecteur) o;
        return numLecteur == lecteur.numLecteur &&
                this.adresse.equals(((Lecteur) o).getAdresse()) &&
                this.nom.equals(((Lecteur) o).getNom()) &&
                this.prenom.equals(((Lecteur) o).getPrenom());
    }
    @Override
    public int hashCode() {
        return Objects.hash(numLecteur);
    }

    @Override
    public String toString() {
        return "\n-- Lecteur --" +
                "\nN° Lecteur : " + numLecteur +
                "\nNom : " + nom +
                "\tPrénom : " + prenom +
                "\nDate de naissance : " + dateNaiss +
                "\nAdresse : " + adresse +
                "\nMail : " + mail +
                "\tN° de téléphone : " + tel;
    }
}
