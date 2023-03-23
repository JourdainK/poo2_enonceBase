package bibliotheque.mvp.model;

import bibliotheque.metier.Auteur;
import bibliotheque.metier.Ouvrage;
import bibliotheque.metier.TypeLivre;
import bibliotheque.metier.TypeOuvrage;

import java.util.List;

public class AuteurModel implements DAOAuteur,SpecialAuteur{
    //TODO all the above

    @Override
    public Auteur addAuteur(Auteur aut) {
        return null;
    }

    @Override
    public boolean removeAuteur(Auteur aut) {
        return false;
    }

    @Override
    public Auteur updateAuteur(Auteur aut) {
        return null;
    }

    @Override
    public Auteur readAuteur(Auteur aut) {
        return null;
    }

    @Override
    public List<Auteur> getAuteurs() {
        return null;
    }

    @Override
    public List<Ouvrage> listerOuvrages(Auteur aut) {
        return null;
    }

    @Override
    public List<Ouvrage> listerOuvrages(TypeOuvrage to, TypeLivre tl) {
        return null;
    }

    @Override
    public List<Ouvrage> listerOuvrages(String genre) {
        return null;
    }
}
