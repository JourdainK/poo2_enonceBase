package bibliotheque.mvp.presenter;


import bibliotheque.metier.Auteur;
import bibliotheque.metier.Ouvrage;
import bibliotheque.mvp.model.DAO;
import bibliotheque.mvp.model.SpecialOuvrage;
import bibliotheque.mvp.view.ViewInterface;

import java.util.Comparator;


public class OuvragePresenter extends Presenter<Ouvrage> implements SpecialOuvragePresenter{

    private Presenter<Auteur> auteurPresenter;

    public OuvragePresenter(DAO<Ouvrage> model, ViewInterface<Ouvrage> view, Comparator<Ouvrage>cmp) {
        super(model,view,cmp);
    }
    @Override
    public void setAuteurPresenter(Presenter<Auteur> auteurPresenter) {
        this.auteurPresenter = auteurPresenter;
    }

    @Override
    public Auteur choixAuteur(){
       return  auteurPresenter.selection();
    }



    @Override
    public void  listerExemplaire(Ouvrage o){
        view.affList(((SpecialOuvrage)model).listerExemplaire(o));
    }
    @Override
    public void listerExemplaire(Ouvrage o, boolean enLocation){
        view.affList(((SpecialOuvrage)model).listerExemplaire(o,enLocation));
    }
}
