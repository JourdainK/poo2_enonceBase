package bibliotheque.mvp.presenter;

import bibliotheque.metier.Exemplaire;
import bibliotheque.mvp.model.DAOExemplaire;
import bibliotheque.mvp.view.ExemplaireViewInterface;

import java.util.List;

public class ExemplairePresenter {
    private DAOExemplaire model;

    private ExemplaireViewInterface view;

    public ExemplairePresenter(DAOExemplaire model, ExemplaireViewInterface view){
        this.model=model;
        this.view=view;
        this.view.setPresenter(this);
    }

    public void start(){ view.setListDatas(getAll());}

    public List<Exemplaire> getAll(){ return model.getExemplaires(); }

    public void addExemplaire(Exemplaire exemplaire){
        Exemplaire exemp = model.addExemplaire(exemplaire);
        if(exemp!=null) view.affMsg("Création de l'exemplaire : " + exemplaire);
        else view.affMsg("Erreur lors de l'ajout de l'exemplaire");
    }

    public void removeExemplaire(Exemplaire exemplaire){
        boolean check = model.removeExemplaire(exemplaire);
        if(check) view.affMsg("Exemplaire effacé");
        else view.affMsg("Erreur lors de l'effacement de l'exemplaire");
    }

    public void updateExemplaire(Exemplaire exemplaire){
        Exemplaire exemp = model.updateExemplaire(exemplaire);
        if(exemp==null) view.affMsg("Erreur lors de la mise à jour");
        else view.affMsg(exemp.toString());
    }

    public void readExemplaire(String matricule){
        Exemplaire exemp = model.readExemplaire(matricule);
        if(exemp==null) view.affMsg("Pas d'exemplaire trouvé");
        else view.affMsg(exemp.toString());
    }

}
