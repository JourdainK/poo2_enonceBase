package bibliotheque.mvp.presenter;

import bibliotheque.metier.Exemplaire;
import bibliotheque.metier.Lecteur;
import bibliotheque.metier.Location;

public interface SpecialLocationPresenter {
    void setExemplairePresenter(Presenter<Exemplaire> exemplairePresenter);

    void setLecteurPresenter(Presenter<Lecteur> lecteurPresenter);

    Exemplaire choixExemplaire();

    Lecteur choixLecteur();

    void calculerAmende(Location l);

    void enregistrerRetour(Location l);
}
