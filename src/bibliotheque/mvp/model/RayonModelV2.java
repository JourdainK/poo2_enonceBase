package bibliotheque.mvp.model;

import bibliotheque.metier.Exemplaire;
import bibliotheque.metier.Rayon;


import java.util.ArrayList;
import java.util.List;

public class RayonModelV2 implements DAO<Rayon> ,SpecialRayon{

    private List<Rayon> ldatas = new ArrayList<>();

    @Override
    public boolean remove(Rayon elt) {
        return ldatas.remove(elt);
    }

    @Override
    public Rayon update(Rayon elt) {
        int p = ldatas.indexOf(elt);
        if (p < 0) return null;
        ldatas.set(p, elt);
        return elt;
    }

    @Override
    public Rayon read(Rayon rech) {
        int p = ldatas.indexOf(rech);
        if (p < 0) return null;
        return ldatas.get(p);
    }

    @Override
    public List<Rayon> getAll() {
        return ldatas;
    }

    public Rayon add(Rayon nl) {
        if (ldatas.contains(nl)) return null;
        ldatas.add(nl);
        return nl;
    }

    @Override
    public List<Exemplaire> listerExemplaires(Rayon r) {
        return r.listerExemplaires();
    }
}
