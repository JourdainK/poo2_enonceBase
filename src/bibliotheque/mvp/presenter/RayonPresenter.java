package bibliotheque.mvp.presenter;

import bibliotheque.metier.Rayon;
import bibliotheque.mvp.model.DAO;
import bibliotheque.mvp.model.SpecialRayon;
import bibliotheque.mvp.view.ViewInterface;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class RayonPresenter extends Presenter<Rayon> implements SpecialRayonPresenter {
    public RayonPresenter(DAO<Rayon> model, ViewInterface<Rayon> view) {
        super(model, view);
    }

    @Override
    public List<Rayon> getAll(){
        final int sens = 1;
        List<Rayon> ldatas;
        ldatas = model.getAll();
        Collections.sort(ldatas, new Comparator<Rayon>() {
            @Override
            public int compare(Rayon o1, Rayon o2) {
                return o1.getCodeRayon().compareToIgnoreCase(o2.getCodeRayon()) * sens;
            }
        });

        return ldatas;
    }

    @Override
    public void listerExemplaires(Rayon r){
        view.affList(((SpecialRayon)model).listerExemplaires(r));
    }
}