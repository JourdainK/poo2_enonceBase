package bibliotheque.mvp.presenter;

import bibliotheque.metier.Auteur;
import bibliotheque.mvp.model.DAOAuteur;
import bibliotheque.mvp.model.DAOLecteur;
import bibliotheque.mvp.view.AuteurViewConsole;
import bibliotheque.mvp.view.AuteurViewInterface;
import bibliotheque.mvp.view.LecteurViewInterface;

import java.util.List;

public class AuteurPresenter {

    private DAOAuteur model;

    private AuteurViewInterface view;

    public AuteurPresenter(DAOAuteur model, AuteurViewInterface view){
        this.model = model;
        this.view = view;
        this.view.setPresenter(this);
    }

    public void start(){ view.setListDatas(getAll());}

    public List<Auteur> getAll(){ return model.getAuteurs(); }

    public void addAuteur(Auteur auteur){
        Auteur aut = model.addAuteur(auteur);
        if(aut!=null) view.affMsg("Auteur ajouté");
        else  view.affMsg("Erreur lors de la création de l'auteur");
        List<Auteur> lAuteur = model.getAuteurs();
        view.setListDatas(lAuteur);
    }

    public void removeAuteur(Auteur auteur){
        boolean check = model.removeAuteur(auteur);

        if(check){
            view.affMsg("Auteur effacé");
            List<Auteur> lAuteurs = model.getAuteurs();
            view.setListDatas(lAuteurs);
        }
        else view.affMsg("Erreur, auteur non effacé");
    }

    public void updateAuteur(Auteur aut){
        Auteur tmpAut = model.updateAuteur(aut);
        if(tmpAut==null) view.affMsg("Erreur lors de la mise à jour");
        else {
            view.affMsg("Mise à jour effectuée");
            List<Auteur> lAut = model.getAuteurs();
            view.setListDatas(lAut);
        }
    }

    //have to create a tmpAut to verify if it's already in
    public Auteur readAuteur(Auteur aut){
        Auteur tmpAuteur = model.readAuteur(aut);
        boolean check = false;
        if(tmpAuteur!=null){
            view.affMsg("Cet auteur n'est pas enregistré");
            check = true;
            return tmpAuteur;
        }
        else {
            view.affMsg(tmpAuteur.toString());
            return tmpAuteur;
        }
    }

    public List<Auteur> lAuthorByName(String name){
        List<Auteur> lauthor = model.listAuthorByName(name);
        if(lauthor==null){
            view.affMsg("Pas d'auteur(s) trouvé avec ce nom");
            return null;
        }
        else return lauthor;
    }

    //TODO specials-> crud all classes are done




}

