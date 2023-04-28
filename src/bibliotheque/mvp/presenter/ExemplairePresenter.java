package bibliotheque.mvp.presenter;

import bibliotheque.metier.Exemplaire;
import bibliotheque.metier.Lecteur;
import bibliotheque.metier.Ouvrage;
import bibliotheque.metier.Rayon;
import bibliotheque.mvp.model.DAO;
import bibliotheque.mvp.model.SpecialExemplaire;
import bibliotheque.mvp.view.ViewInterface;

import java.util.List;

public class ExemplairePresenter extends Presenter<Exemplaire> implements SpecialExemplairePresenter {
    private Presenter<Ouvrage> ouvragePresenter;



    private Presenter<Rayon> rayonPresenter;

    public ExemplairePresenter(DAO<Exemplaire> model, ViewInterface<Exemplaire> view) {
        super(model,view);
    }


    @Override
    public void setOuvragePresenter(Presenter<Ouvrage> ouvragePresenter){
        this.ouvragePresenter=ouvragePresenter;
    }
    @Override
    public void setRayonPresenter(Presenter<Rayon> rayonPresenter) {
        this.rayonPresenter = rayonPresenter;
    }
    @Override
    public Ouvrage choixOuvrage(){
        return ouvragePresenter.selection();
    }

    @Override
    public Rayon choixRayon(){
        return rayonPresenter.selection();
    }
    @Override
    public void modifierEtat(Exemplaire ex, String etat) {
        ((SpecialExemplaire)model).modifierEtat(ex,etat);
        view.affMsg("état modifié");
    }


    @Override
    public void LecteurActuel(Exemplaire ex) {
        Lecteur l =((SpecialExemplaire)model).lecteurActuel(ex);
        if(l!=null) view.affMsg(l.toString());
        else view.affMsg("aucun lecteur actuel");
    }


    @Override
    public void lecteurs(Exemplaire ex) {

       view.affList(((SpecialExemplaire)model).lecteurs(ex));
    }


    @Override
    public void envoiMailLecteurActuel(Exemplaire ex) {
        ((SpecialExemplaire)model).envoiMailLecteurActuel(ex);
        view.affMsg("mail envoyé");

    }


    @Override
    public void envoiMailLecteurs(Exemplaire ex) {
        ((SpecialExemplaire)model).envoiMailLecteurs(ex);
        view.affMsg("mails envoyés");

    }


    @Override
    public void enRetard(Exemplaire ex) {
        boolean retard = ((SpecialExemplaire)model).enRetard(ex);
        view.affMsg(retard?"en retard":"pas en retard");
    }


    @Override
    public void joursRetard(Exemplaire ex) {
        view.affMsg("jours de retard = "+((SpecialExemplaire)model).joursRetard(ex));
    }


    @Override
    public void  enLocation(Exemplaire ex) {
       boolean enLoc =  ((SpecialExemplaire)model).enLocation(ex);
       view.affMsg(enLoc?"en location":"pas en location");
    }
}
