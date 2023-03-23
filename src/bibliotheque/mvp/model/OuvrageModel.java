package bibliotheque.mvp.model;

import bibliotheque.metier.Exemplaire;
import bibliotheque.metier.Ouvrage;

import java.util.List;

public class OuvrageModel implements DAOOuvrage, SpecialOuvrage{

    //TODO all methods under (OUVRAGE) -> !!! inheritance


    @Override
    public Ouvrage addOuvrage(Ouvrage ouv) {
        return null;
    }

    @Override
    public boolean removeOuvrage(Ouvrage ouv) {
        return false;
    }

    @Override
    public Ouvrage updateOuvrage(Ouvrage ouv) {
        return null;
    }

    @Override
    public Ouvrage readOuvrage(Ouvrage ouv) {
        return null;
    }

    @Override
    public List<Ouvrage> getOuvrages() {
        return null;
    }

    @Override
    public List<Exemplaire> listerExemplaires() {
        return null;
    }

    @Override
    public List<Exemplaire> listerExemplaires(boolean enLocation) {
        return null;
    }
}
