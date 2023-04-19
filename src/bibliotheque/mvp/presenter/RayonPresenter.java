package bibliotheque.mvp.presenter;

import bibliotheque.metier.Lecteur;
import bibliotheque.metier.Rayon;
import bibliotheque.mvp.model.DAORayon;
import bibliotheque.mvp.view.RayonViewInterface;

import java.util.List;

public class RayonPresenter {
    private DAORayon model;
    private RayonViewInterface view;

    public RayonPresenter(DAORayon model,RayonViewInterface view){
        this.model = model;
        this.view = view;
        this.view.setPresenter(this);
    }

    public void start(){ view.setListDatas(getAll());}

    public List<Rayon> getAll(){ return model.getRayons(); }

    public void addRayon(Rayon rayon){
        Rayon ray = model.addrayon(rayon);
        if(ray!=null) view.affMsg("Création du rayon : " + ray);
        else view.affMsg("Erreur lors de la création du rayon");
        List<Rayon> lRayons = model.getRayons();
    }

    public void removeLecteur(Rayon rayon){
        boolean check = model.removeRayon(rayon);
        if(check) view.affMsg("Rayon effacé");
        else view.affMsg("Erreur, rayon non effacé");
    }

    public void updateRayon(Rayon rayon){
        Rayon ray = model.updateRayon(rayon);
        if(ray==null) view.affMsg("Erreur : mise à jour annulée");
        else view.affMsg("Mise à jour effectuée");
    }

    //TODO rayon specials
}
