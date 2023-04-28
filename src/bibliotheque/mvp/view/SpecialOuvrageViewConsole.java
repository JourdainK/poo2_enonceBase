package bibliotheque.mvp.view;

import bibliotheque.metier.Ouvrage;

public interface SpecialOuvrageViewConsole {
    void enLocation(Ouvrage o, boolean enLocation);

    void exemplaires(Ouvrage o);
}
