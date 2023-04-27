package bibliotheque.mvp.view;

import bibliotheque.metier.*;
import bibliotheque.utilitaires.Utilitaire;

import static bibliotheque.utilitaires.Utilitaire.affListe;

public class ExemplaireViewConsole extends AbstractViewConsole<Exemplaire> {
    @Override
    protected void rechercher() {

    }

    @Override
    protected void modifier() {

    }

    @Override
    protected void ajouter() {
        System.out.println("matricule ");
        String mat=sc.next();
        System.out.println("etat  ");
        String etat=sc.next();
        System.out.println("ouvrage ");
        //TODO choisir ouvrage
        Ouvrage obidon = null;
        try {
            obidon = new Livre("zzz",0,null,1,"","","",1, TypeLivre.ROMAN,"");
        } catch (Exception e) {
            System.out.println("erreur :"+e);
        }
        Exemplaire ex = null;
        try {
            ex = new Exemplaire(mat,etat,obidon);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        presenter.add(ex);
        //TODO attribuer rayon , les rayons sont triès par ordre de code
    }

    @Override
    protected void special() {

    }
}
