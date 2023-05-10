package bibliotheque.mvp.view;

import bibliotheque.metier.*;
import bibliotheque.mvp.presenter.AuteurPresenter;
import bibliotheque.mvp.presenter.OuvragePresenter;
import bibliotheque.mvp.presenter.SpecialOuvragePresenter;
import bibliotheque.utilitaires.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static bibliotheque.utilitaires.Utilitaire.*;
import static bibliotheque.utilitaires.Utilitaire.modifyIfNotBlank;

public class OuvrageViewConsole extends AbstractViewConsole<Ouvrage> implements SpecialOuvrageViewConsole {
    @Override
    protected void rechercher() {
      //TODO rechercher ouvrage
    }

    @Override
    protected void modifier() {
        int choix = choixElt(ldatas);
        Ouvrage o = ldatas.get(choix-1);
         do {
            try {
                double ploc =Double.parseDouble(modifyIfNotBlank("prix location",""+o.getPrixLocation()));
                o.setPrixLocation(ploc);
                break;
            } catch (Exception e) {
                System.out.println("erreur :" + e);
            }
        }while(true);
        presenter.update(o);
        ldatas=presenter.getAll();//rafraichissement
        affListe(ldatas);

    }

    @Override
    protected void ajouter() {
        TypeOuvrage[] tto = TypeOuvrage.values();
        List<TypeOuvrage> lto = new ArrayList<>(Arrays.asList(tto));
        int choix = Utilitaire.choixListe(lto);
        Ouvrage o = null;
        List<OuvrageFactory> lof = new ArrayList<>(Arrays.asList(new LivreFactory(),new CDFactory(),new DVDFactory()));
        o = lof.get(choix-1).create();
        presenter.add(o);
        Auteur a = ((OuvragePresenter)presenter).choixAuteur();
        o.addAuteur(a);
    }

    @Override
    protected void special() {
        int choix =  choixElt(ldatas);
        Ouvrage o = ldatas.get(choix-1);

        List options = new ArrayList<>(Arrays.asList("lister exemplaires", "lister exemplaires en location", "lister exemplaires libres","fin"));
        do {
            int ch = choixListe(options);

            switch (ch) {

                case 1:
                    exemplaires(o);
                    break;
                case 2:
                    enLocation(o, true);
                    break;
                case 3:
                    enLocation(o, false);
                    break;

                case 4 :return;
            }
        } while (true);




    }

    @Override
    public void enLocation(Ouvrage o, boolean enLocation) {
        ((SpecialOuvragePresenter) presenter).listerExemplaire(o, enLocation);
    }

    @Override
    public void exemplaires(Ouvrage o) {
        ((SpecialOuvragePresenter)presenter).listerExemplaire(o);
    }
}
