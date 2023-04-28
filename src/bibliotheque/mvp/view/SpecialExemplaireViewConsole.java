package bibliotheque.mvp.view;

import bibliotheque.metier.Exemplaire;

public interface SpecialExemplaireViewConsole {
    void enLocation(Exemplaire ex);

    void joursRetard(Exemplaire ex);

    void enRetard(Exemplaire ex);

    void mailLecteurs(Exemplaire ex);

    void mailLecteurActuel(Exemplaire ex);

    void lecteurs(Exemplaire ex);

    void lecteurActuel(Exemplaire ex);

    void changeEtat(Exemplaire ex);
}
