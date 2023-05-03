package bibliotheque.mvp.presenter;


import bibliotheque.metier.Auteur;
import bibliotheque.metier.Ouvrage;
import bibliotheque.mvp.model.DAO;
import bibliotheque.mvp.model.SpecialOuvrage;
import bibliotheque.mvp.view.ViewInterface;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class OuvragePresenter extends Presenter<Ouvrage> implements SpecialOuvragePresenter{

    private Presenter<Auteur> auteurPresenter;
    @Override
    public void setAuteurPresenter(Presenter<Auteur> auteurPresenter) {
        this.auteurPresenter = auteurPresenter;
    }

    @Override
    public List<Ouvrage> getAll(){
        final int sens = 1;
        List<Ouvrage> ldatas;
        ldatas = model.getAll();
        Collections.sort(ldatas, new Comparator<Ouvrage>() {
            @Override
            public int compare(Ouvrage o1, Ouvrage o2) {
                return o1.getTitre().compareToIgnoreCase(o2.getTitre()) * sens;
            }
        });
        return  ldatas;
    }
    @Override
    public Auteur choixAuteur(){
       return  auteurPresenter.selection();
    }

    public OuvragePresenter(DAO<Ouvrage> model, ViewInterface<Ouvrage> view) {
        super(model,view);
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
