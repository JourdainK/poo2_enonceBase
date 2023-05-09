package bibliotheque.mvp.presenter;

import bibliotheque.metier.Exemplaire;
import bibliotheque.metier.Lecteur;
import bibliotheque.mvp.model.DAO;
import bibliotheque.mvp.model.SpecialLecteur;
import bibliotheque.mvp.view.ViewInterface;

import java.util.*;

public class LecteurPresenter extends Presenter<Lecteur> implements SpecialLecteurPresenter {


    public LecteurPresenter(DAO<Lecteur> model, ViewInterface<Lecteur> view) {
        super(model,view);
    }

    @Override
    public List<Lecteur> getAll(){
        //final int sens = -1;
        List<Lecteur> ldatas;
        ldatas = model.getAll();
        Comparator<Lecteur> cmp = (l1,l2)-> l1.getNom().compareToIgnoreCase(l2.getNom());
        cmp = cmp.thenComparing((l1,l2)->l1.getPrenom().compareToIgnoreCase(l2.getPrenom()));
        ldatas.sort(cmp);
        /*
        Collections.sort(ldatas, new Comparator<Lecteur>() {
            @Override
            public int compare(Lecteur o1, Lecteur o2) {
                int nameCompare = o1.getNom().compareToIgnoreCase(o2.getNom())*sens;
                int prenCompare = o2.getPrenom().compareToIgnoreCase(o2.getPrenom())*sens;
                return (nameCompare==0)? prenCompare : nameCompare;
            }
        });

         */
        return ldatas;
    }
    @Override
    public void exemplairesEnLocation(Lecteur l) {
        List<Exemplaire> lex =   ((SpecialLecteur)model).exemplairesEnLocation(l);
        if(lex==null || lex.isEmpty()) view.affMsg("aucun exemplaire trouvé");
        else view.affList(lex);
    }
    @Override
    public void exemplairesLoues(Lecteur l) {
        List<Exemplaire> lex =   ((SpecialLecteur)model).exemplairesLoues(l);
        if(lex==null || lex.isEmpty()) view.affMsg("aucun exemplaire trouvé");
        else view.affList(lex);
    }

    public Map<String, Lecteur> getMapAll(){
        Map<String, Lecteur> mdatas = new HashMap<>();
        mdatas = model.getMapAll();
        return mdatas;}
}
