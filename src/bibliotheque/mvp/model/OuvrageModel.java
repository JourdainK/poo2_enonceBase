package bibliotheque.mvp.model;

import bibliotheque.metier.Exemplaire;
import bibliotheque.metier.Ouvrage;

import java.util.List;

public class OuvrageModel extends AbstractModel<Ouvrage> implements SpecialOuvrage {
    @Override
    public List<Exemplaire> listerExemplaire(Ouvrage o) {
        return o.listerExemplaires();
    }

    @Override
    public List<Exemplaire> listerExemplaire(Ouvrage o, boolean enLocation) {
        return o.listerExemplaires(enLocation);
    }

    @Override
    public double amendeRetard(Ouvrage o, int nj) {
        return o.amendeRetard(nj);
    }
}
