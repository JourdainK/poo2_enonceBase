package bibliotheque.mvp.presenter;

import bibliotheque.metier.Auteur;
import bibliotheque.metier.TypeLivre;

public interface SpecialAuteurPresenter {
    void listerOuvrages(Auteur a);

    void listerLivre(Auteur a, TypeLivre tl);

    void listerOuvrages(Auteur a, String genre);
}
