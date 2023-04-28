package bibliotheque.mvp.model;

import bibliotheque.metier.Exemplaire;
import bibliotheque.metier.Ouvrage;
import bibliotheque.mvp.presenter.ExemplairePresenter.*;

import java.util.ArrayList;
import java.util.List;

public class OuvrageModelV2 implements DAO<Ouvrage>, SpecialOuvrage{
    private int numOUvrage = 0;
    private List<Ouvrage> ldatas = new ArrayList<>();

    @Override
    public Ouvrage add(Ouvrage ouvrage) {
        if(ldatas.contains(ouvrage)) return null;
        ldatas.add(ouvrage);
        return ouvrage;
    }

    @Override
    public boolean remove(Ouvrage ouvrage) { return ldatas.remove(ouvrage); }

    @Override
    public Ouvrage update(Ouvrage ouvrage) {
        int pos = ldatas.indexOf(ouvrage);
        if(pos < 0) return null;
        ldatas.set(pos,ouvrage);
        return ouvrage;
    }

    @Override
    public Ouvrage read(Ouvrage rech) {
        int pos = ldatas.indexOf(rech);
        if(pos < 0) return null;
        return ldatas.get(pos);
    }

    @Override
    public List<Ouvrage> getAll() { return ldatas; }

    @Override
    public List<Exemplaire> listerExemplaire(Ouvrage o) {
        return null;
    }

    @Override
    public List<Exemplaire> listerExemplaire(Ouvrage o, boolean enLocation) {
        return null;
    }

    @Override
    public double amendeRetard(Ouvrage o, int nj) {
        return 0;
    }
}
