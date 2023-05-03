package bibliotheque.mvp.model;

import bibliotheque.metier.Auteur;
import bibliotheque.metier.Livre;
import bibliotheque.metier.Ouvrage;
import bibliotheque.metier.TypeLivre;

import java.util.List;
import java.util.Map;

public class AuteurModel extends AbstractModel<Auteur> implements SpecialAuteur {

    @Override
    public List<Ouvrage> listerOuvrages(Auteur a) {
        return a.listerOuvrages();
    }

    @Override
    public List<Livre> listerLivre(Auteur a, TypeLivre tl) {
        return a.listerLivres(tl);
    }

    @Override
    public List<Ouvrage> listerOuvrages(Auteur a, String genre) {
        return a.listerOuvrages(genre);
    }

    @Override
    public Map<String, Auteur> getMapAll() {
        //TODO
        return null;
    }
}
