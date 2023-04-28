package bibliotheque.mvp.presenter;

import bibliotheque.metier.Auteur;
import bibliotheque.metier.Ouvrage;

public interface SpecialOuvragePresenter {
    void setAuteurPresenter(Presenter<Auteur> auteurPresenter);

    Auteur choixAuteur();

    void listerExemplaire(Ouvrage o);

    void listerExemplaire(Ouvrage o, boolean enLocation);
}
