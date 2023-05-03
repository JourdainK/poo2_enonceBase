package bibliotheque.mvp.presenter;

import bibliotheque.metier.*;
import bibliotheque.mvp.model.DAO;
import bibliotheque.mvp.model.SpecialAuteur;
import bibliotheque.mvp.view.ViewInterface;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class AuteurPresenter extends Presenter<Auteur> implements SpecialAuteurPresenter {

    @Override
    public List<Auteur> getAll(){
        final int sens = 1;
        List<Auteur> ldatas;
        ldatas = model.getAll();
        Collections.sort(ldatas, new Comparator<Auteur>() {
            @Override
            public int compare(Auteur o1, Auteur o2) {
                int NameCompare = o1.getNom().compareToIgnoreCase(o2.getNom()) * sens;
                int PrenCompare = o1.getPrenom().compareToIgnoreCase(o2.getPrenom()) * sens;

                return (NameCompare == 0)? PrenCompare: NameCompare;
            }
        });

        return null;
    }

    public AuteurPresenter(DAO<Auteur> model, ViewInterface<Auteur> view) {
        super(model, view);
    }
    @Override
    public void  listerOuvrages(Auteur a) {

        view.affList (((SpecialAuteur)model).listerOuvrages(a));
    }


    @Override
    public void listerLivre(Auteur a, TypeLivre tl) {

        view.affList (((SpecialAuteur)model).listerLivre(a,tl));
    }

    @Override
    public void listerOuvrages(Auteur a, String genre) {
        view.affList (((SpecialAuteur)model).listerOuvrages(a,genre));
    }
}
