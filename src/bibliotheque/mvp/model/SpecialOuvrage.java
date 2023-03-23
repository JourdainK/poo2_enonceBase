package bibliotheque.mvp.model;

import bibliotheque.metier.Exemplaire;

import java.util.List;

public interface SpecialOuvrage {

    List<Exemplaire> listerExemplaires();

    //TODO check that, not sure
    List<Exemplaire> listerExemplaires(boolean enLocation);

}
