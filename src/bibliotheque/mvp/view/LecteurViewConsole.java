package bibliotheque.mvp.view;


import bibliotheque.metier.Lecteur;


import bibliotheque.mvp.presenter.LecteurPresenter;
import bibliotheque.mvp.presenter.SpecialLecteurPresenter;

import static bibliotheque.utilitaires.Utilitaire.*;

import java.time.LocalDate;



public class LecteurViewConsole extends AbstractViewConsole<Lecteur> implements SpecialLecteurViewConsole {


  protected  void rechercher() {
      try{
        System.out.println("numLecteur : ");
        int idLecteur = lireInt();
        Lecteur rech = null;
        rech = new Lecteur(idLecteur,"N","P",null,null,null,null);
        presenter.search(rech);
      } catch (Exception e) {
          System.out.println("erreur "+e);
      }
    }

   protected  void modifier() {
        int choix = choixElt(ldatas);
        Lecteur l = ldatas.get(choix-1);
         do {
            try {
            String nom = modifyIfNotBlank("nom", l.getNom());
            String prenom = modifyIfNotBlank("prénom", l.getPrenom());
            String date = modifyIfNotBlank("date de naissance", getDateFrench(l.getDn()));
            String[] jma = date.split(" ");
            int j = Integer.parseInt(jma[0]);
            int m = Integer.parseInt(jma[1]);
            int a = Integer.parseInt(jma[2]);
            LocalDate dn = LocalDate.of(a, m, j);
            String adr = modifyIfNotBlank("adresse", l.getAdresse());
            String mail = modifyIfNotBlank("mail", l.getMail());
            String tel = modifyIfNotBlank("tel", l.getTel());
            l.setNom(nom);
            l.setPrenom(prenom);
            l.setDn(dn);
            l.setAdresse(adr);
            l.setMail(mail);
            l.setTel(tel);
            break;
            } catch (Exception e) {
                System.out.println("erreur :" + e);
            }
        }while(true);
       presenter.update(l);
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
      do {
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
              presenter.add(lec);
              break;
          } catch (Exception e) {
              System.out.println("erreur : " + e);
          }
      }
        while(true);
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
                 switch (ch) {
                    case 1:
                        exemplairesLocation(lec);
                        break;
                    case 2:
                        exemplairesLoues(lec);
                        break;
                    case 3: return;
                    default:
                        System.out.println("choix invalide recommencez ");
                }
            } while (true);


        }

    @Override
    public void exemplairesLoues(Lecteur lec) {
        ((SpecialLecteurPresenter)presenter).exemplairesLoues(lec);
    }

    @Override
    public void exemplairesLocation(Lecteur lec) {
        ((SpecialLecteurPresenter)presenter).exemplairesEnLocation(lec);
    }
}


