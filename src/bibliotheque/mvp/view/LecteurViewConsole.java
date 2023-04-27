package bibliotheque.mvp.view;


import bibliotheque.metier.Lecteur;


import bibliotheque.mvp.presenter.LecteurPresenter;
import static bibliotheque.utilitaires.Utilitaire.*;

import java.time.LocalDate;



public class LecteurViewConsole extends AbstractViewConsole<Lecteur> {


  protected  void rechercher() {
        System.out.println("numLecteur : ");
        int idLecteur = sc.nextInt();
      Lecteur rech = null;
      try {
          rech = new Lecteur(idLecteur,"zzz","zzz",null,null,null,null);
      } catch (Exception e) {
          throw new RuntimeException(e);
      }
      presenter.search(rech);
    }

   protected  void modifier() {
        int choix = choixElt(ldatas);
        Lecteur l = ldatas.get(choix-1);
        String nom = modifyIfNotBlank("nom",l.getNom());
        String prenom = modifyIfNotBlank("prénom",l.getPrenom());
        String date = modifyIfNotBlank("date de naissance",getDateFrench(l.getDn()));
        String[] jma = date.split(" ");
        int j = Integer.parseInt(jma[0]);
        int m = Integer.parseInt(jma[1]);
        int a = Integer.parseInt(jma[2]);
        LocalDate dn = LocalDate.of(a, m, j);
        String adr = modifyIfNotBlank("adresse",l.getAdresse());
        String mail= modifyIfNotBlank("mail",l.getMail());
        String tel =modifyIfNotBlank("tel",l.getTel());
       Lecteur lec = null;
       try {
           lec = new Lecteur(l.getNumlecteur(), nom, prenom, dn, adr, mail, tel);
       } catch (Exception e) {
           System.out.println("erreur :"+e);
       }
       presenter.update(lec);
        ldatas=presenter.getAll();//rafraichissement
        affListe(ldatas);
    }

    protected  void retirer() {
        int choix = choixElt(ldatas);
        Lecteur lecteur = ldatas.get(choix-1);
        presenter.remove(lecteur);
        ldatas=presenter.getAll();//rafraichissement
        affListe(ldatas);
    }


    protected  void ajouter() {
        System.out.println("nom ");
        String nom = sc.nextLine();
        System.out.println("prénom ");
        String prenom = sc.nextLine();
        System.out.println("date de naissance");
        String[] jma = sc.nextLine().split(" ");
        int j = Integer.parseInt(jma[0]);
        int m = Integer.parseInt(jma[1]);
        int a = Integer.parseInt(jma[2]);
        LocalDate dn = LocalDate.of(a, m, j);
        System.out.println("adresse");
        String adr = sc.nextLine();
        System.out.println("mail");
        String mail = sc.nextLine();
        System.out.println("tel ");
        String tel = sc.nextLine();
        Lecteur lec = null;
        try {
            lec = new Lecteur(0, nom, prenom, dn, adr, mail, tel);
        } catch (Exception e) {
            System.out.println("erreur : "+e);
        }
        presenter.add(lec);
        ldatas=presenter.getAll();//rafraichissement
        affListe(ldatas);
    }
    protected  void special() {
        int choix =  choixElt(ldatas);
        Lecteur lec = ldatas.get(choix-1);
            do {
                System.out.println("1.Exemplaire en location\n2.Exemplaires loués\n3.menu principal");
                System.out.println("choix : ");
                int ch = lireInt();
                sc.skip("\n");
                switch (ch) {
                    case 1:
                        ((LecteurPresenter)presenter).exemplairesEnLocation(lec);
                        break;
                    case 2:
                        ((LecteurPresenter)presenter).exemplairesLoues(lec);
                        break;
                    case 3: return;
                    default:
                        System.out.println("choix invalide recommencez ");
                }
            } while (true);


        }
    }


