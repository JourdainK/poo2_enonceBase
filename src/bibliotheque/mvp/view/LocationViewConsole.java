package bibliotheque.mvp.view;

import bibliotheque.metier.*;
import bibliotheque.mvp.presenter.LecteurPresenter;
import bibliotheque.mvp.presenter.LocationPresenter;
import bibliotheque.mvp.presenter.RayonPresenter;
import bibliotheque.mvp.presenter.SpecialLocationPresenter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static bibliotheque.utilitaires.Utilitaire.*;
import static bibliotheque.utilitaires.Utilitaire.modifyIfNotBlank;

public class LocationViewConsole extends AbstractViewConsole<Location> implements SpecialLocationViewConsole {
    @Override
    protected void rechercher() {

    }

    @Override
    protected void modifier() {
        int choix = choixElt(ldatas);
        Location l = ldatas.get(choix-1);
        do {
            try {
                l.enregistrerRetour();
                break;
            } catch (Exception e) {
                System.out.println("erreur :" + e);
            }
        }while(true);
        presenter.update(l);
        ldatas=presenter.getAll();//rafraichissement
        affListe(ldatas);
    }

    @Override
    protected void ajouter() {
        Lecteur l =((LocationPresenter)presenter).choixLecteur();
        Exemplaire ex = ((LocationPresenter)presenter).choixExemplaire();
        if(ex.enLocation()) {
            affMsg("exemplaire en location");
            return;
        }
        Location loc = new Location(l,ex);
        presenter.add(loc);
    }

    @Override
    protected void special() {
        int choix =  choixElt(ldatas);
        Location l = ldatas.get(choix-1);

        List options = new ArrayList<>(Arrays.asList("calculer amende","enregistrer retour","fin"));
        do {
            int ch = choixListe(options);

            switch (ch) {

                case 1:
                    amende(l);
                    break;
                case 2:
                    retour(l);
                    break;
                case 3 :return;
            }
        } while (true);
    }

    @Override
    public void retour(Location l) {
        if(l.getExemplaire().enLocation()) ((SpecialLocationPresenter)presenter).enregistrerRetour(l);
        else affMsg("exemplaire pas en location");
    }

    @Override
    public void amende(Location l) {
        ((SpecialLocationPresenter)presenter).calculerAmende(l);
    }
}
