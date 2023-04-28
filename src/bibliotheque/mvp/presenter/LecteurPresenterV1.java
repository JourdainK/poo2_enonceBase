package bibliotheque.mvp.presenter;

import bibliotheque.metier.Exemplaire;
import bibliotheque.metier.Lecteur;
import bibliotheque.mvp.model.DAO;
import bibliotheque.mvp.model.SpecialLecteur;
import bibliotheque.mvp.view.LecteurViewInterface;
import bibliotheque.mvp.view.ViewInterface;

import java.util.List;

public class LecteurPresenterV1  {

    protected  DAO<Lecteur> model;
    protected  LecteurViewInterface view;

    public LecteurPresenterV1(DAO<Lecteur> model, LecteurViewInterface view) {
        this.model = model;
        this.view = view;
        this.view.setPresenter(this);
    }

    public void start() {
        view.setListDatas(getAll());
    }

    public List<Lecteur> getAll(){
        return model.getAll();
    }

    public void add(Lecteur elt) {
        Lecteur nelt = model.add(elt);
        if(nelt!=null) view.affMsg("création de :"+nelt);
        else view.affMsg("erreur de création");

    }


    public void remove(Lecteur elt) {
        boolean ok = model.remove(elt);
        if(ok) view.affMsg("élément effacé");
        else view.affMsg("élément non effacé");

    }
    public void update(Lecteur elt) {
        Lecteur nelt  =model.update(elt);
        if(nelt==null) view.affMsg("mise à jour infrucueuse");
        else view.affMsg("mise à jour effectuée : "+nelt);

    }

    public void search(Lecteur rech) {
        Lecteur elt= model.read(rech);
        if(elt==null) view.affMsg("recherche infructueuse");
        else view.affMsg(elt.toString());
    }

    public Lecteur selection(){
        return  view.selectionner(model.getAll());
    }
    public void exemplairesEnLocation(Lecteur l) {
        List<Exemplaire> lex =   ((SpecialLecteur)model).exemplairesEnLocation(l);
        if(lex==null || lex.isEmpty()) view.affMsg("aucun exemplaire trouvé");
        else view.affList(lex);
    }
    public void exemplairesLoues(Lecteur l) {
        List<Exemplaire> lex =   ((SpecialLecteur)model).exemplairesLoues(l);
        if(lex==null || lex.isEmpty()) view.affMsg("aucun exemplaire trouvé");
        else view.affList(lex);
    }
}
