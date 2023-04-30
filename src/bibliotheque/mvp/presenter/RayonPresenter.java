package bibliotheque.mvp.presenter;

import bibliotheque.metier.Rayon;
import bibliotheque.mvp.model.DAO;
import bibliotheque.mvp.model.SpecialRayon;
import bibliotheque.mvp.view.ViewInterface;
import bibliotheque.utilitaires.SortRayon;

import java.util.Collections;
import java.util.List;


public class RayonPresenter extends Presenter<Rayon> implements SpecialRayonPresenter {
    public RayonPresenter(DAO<Rayon> model, ViewInterface<Rayon> view) {
        super(model, view);
    }

    @Override
    public List<Rayon> getAll(){
        List<Rayon> ldatas;
        ldatas = model.getAll();
        Collections.sort(ldatas,new SortRayon());

        return ldatas;
    }

    @Override
    public void listerExemplaires(Rayon r){
        view.affList(((SpecialRayon)model).listerExemplaires(r));
    }
}