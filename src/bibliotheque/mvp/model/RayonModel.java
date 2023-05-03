package bibliotheque.mvp.model;

import bibliotheque.metier.Exemplaire;
import bibliotheque.metier.Rayon;

import java.util.List;
import java.util.Map;

public class RayonModel extends AbstractModel<Rayon> implements SpecialRayon{
    @Override
    public List<Exemplaire> listerExemplaires(Rayon r) {
        return r.listerExemplaires();
    }

    @Override
    public Map<String, Rayon> getMapAll() {
        //TODO
        return null;
    }
}
