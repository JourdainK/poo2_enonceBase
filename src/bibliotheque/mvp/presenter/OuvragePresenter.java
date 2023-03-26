package bibliotheque.mvp.presenter;

import bibliotheque.metier.Ouvrage;
import bibliotheque.mvp.model.DAOOuvrage;
import bibliotheque.mvp.view.OuvrageViewInterface;

import java.util.List;

public class OuvragePresenter {

    private DAOOuvrage model;

    private OuvrageViewInterface view;

    public OuvragePresenter(DAOOuvrage model, OuvrageViewInterface view){
        this.model = model;
        this.view = view;
        this.view.setPresenter(this);
    }

    public void start() { view.setListDatas(getAll());}

    public List<Ouvrage> getAll() { return model.getOuvrages(); }

    public void addOuvrage(Ouvrage ouv){
        Ouvrage ouvrage = model.addOuvrage(ouv);
        if(ouvrage!=null) view.affMsg("Création de l'ouvrage : " + ouv);
        else view.affMsg("Erreur de création de l'ouvrage");
        List<Ouvrage> louvrages = model.getOuvrages();
        view.setListDatas(louvrages);
    }

    public void removeOuvrage(Ouvrage ouv){
        boolean check = model.removeOuvrage(ouv);
        if(check) {
            view.affMsg("Ouvrage effacé");
            List<Ouvrage> ouvrages = model.getOuvrages();
            view.setListDatas(ouvrages);
        }
        else view.affMsg("Ouvrage non effacé");
    }

    public void updateOuvrage(Ouvrage ouv){
        Ouvrage tmpOuv = model.updateOuvrage(ouv);
        if(tmpOuv==null) view.affMsg("Erreur lors de la mise à jour");
        else {
            view.affMsg("Mise à jour effectuée");
            List<Ouvrage> louv = model.getOuvrages();
            view.setListDatas(louv);
        }
    }

    public Ouvrage readOuvrage(String title){
        Ouvrage ouv = model.readOuvrage(title);
        if(ouv==null) {
            view.affMsg("Pas d'ouvrage trouvé avec ce titre");
            return null;
        }
        else  {
            view.affMsg(ouv.toString());
            return ouv;
        }

    }








}
