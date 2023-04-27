package bibliotheque.mvp.view;

import bibliotheque.metier.Auteur;
import bibliotheque.metier.Rayon;

import static bibliotheque.utilitaires.Utilitaire.affListe;

public class AuteurViewConsole extends AbstractViewConsole<Auteur>{
    @Override
    protected void rechercher() {

    }

    @Override
    protected void modifier() {

    }

    @Override
    protected void ajouter() {
        Auteur a=null;
        do {
            try {
                System.out.println("nom ");
                String nom = sc.nextLine();
                System.out.println("prénom ");
                String prenom = sc.nextLine();
                System.out.println("nationalité");
                String nat = sc.nextLine();
                a = new Auteur(nom, prenom, nat);
                break;
            } catch (Exception e) {
                System.out.println("une erreur est survenue : "+e.getMessage());
            }
        }while(true);
        presenter.add(a);

        //TODO attribuer ouvrages , les ouvrages sont triés par ordre de titre
    }

    @Override
    protected void special() {

    }
}
