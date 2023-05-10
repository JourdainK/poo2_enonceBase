package bibliotheque.mvp.presenter;

import bibliotheque.metier.*;
import bibliotheque.mvp.model.DAO;
import bibliotheque.mvp.model.SpecialAuteur;
import bibliotheque.mvp.view.ViewInterface;

import java.util.Comparator;


public class AuteurPresenter extends Presenter<Auteur> implements SpecialAuteurPresenter {


    public AuteurPresenter(DAO<Auteur> model, ViewInterface<Auteur> view, Comparator<Auteur>cmp) {
        super(model, view,cmp);
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
