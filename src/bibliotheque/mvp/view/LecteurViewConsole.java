package bibliotheque.mvp.view;

import bibliotheque.metier.Lecteur;
import bibliotheque.mvp.presenter.LecteurPresenter;
import bibliotheque.utilitaires.Utilitaire;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static bibliotheque.utilitaires.Utilitaire.*;

public class LecteurViewConsole implements LecteurViewInterface {
    private LecteurPresenter presenter;
    private List<Lecteur> llec;
    private Scanner sc = new Scanner(System.in);

    public LecteurViewConsole() {

    }

    @Override
    public void setPresenter(LecteurPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void setListDatas(List<Lecteur> lecteurs) {
        this.llec = lecteurs;
        Utilitaire.affListe(llec);
        menu();
    }

    @Override
    public void affMsg(String msg) {
        System.out.println("information:" + msg);
    }

    public void menu() {
        List options = new ArrayList<>(Arrays.asList("ajouter", "retirer", "modifier", "fin"));
        do {
            int ch = choixListe(options);

            switch (ch) {
                case 1:
                    ajouter();
                    break;
                case 2:
                    retirer();
                    break;
                case 3:
                    modifier();
                    break;
                case 4:
                    System.exit(0);
            }
        } while (true);
    }

    private void modifier() {
        Lecteur tmpLect;
        int choiceLect;

        choiceLect = choixListe(llec);
        tmpLect = llec.get(choiceLect-1);
        System.out.println("Séléctionné (VIEW) : " + tmpLect);

        System.out.println("Que voulez-vous modifier ? ");
        List<String> listOption = new ArrayList<>(Arrays.asList("Modifier nom","Modifier prénom","Modifier date de naissance","Moidifier adresse","Modifier mail","Modifier Téléphone"));
        int choiceOption = choixListe(listOption);
        switch (choiceOption){
            case 1 :
                System.out.println("Saisir le nouveau nom : ");
                String newnom = sc.nextLine();
                tmpLect.setNom(newnom);
                break;
            case 2 :
                System.out.println("Saisir le nouveau prénom : ");
                String newpren = sc.nextLine();
                tmpLect.setPrenom(newpren);
                break;
            case 3 :
                System.out.println("Saisir la date de naissance : ");
                LocalDate newBirth = lecDate();
                tmpLect.setDn(newBirth);
                break;
            case 4 :
                System.out.println("Saisir la nouvelle adresse");
                String newAdre = sc.nextLine();
                tmpLect.setAdresse(newAdre);
                break;
            case 5 :
                System.out.println("Saisir le nouveau mail : ");
                String newmail = sc.nextLine();
                tmpLect.setMail(newmail);
            case 6 :
                System.out.println("Saisir le nouveau n° de téléphone : ");
                String newPhone = sc.nextLine();
                tmpLect.setTel(newPhone);
                break;

        }

        presenter.modify(tmpLect);

    }

    private void retirer() {
        int choix = Utilitaire.choixElt(llec);
        Lecteur lecteur = llec.get(choix-1);
        presenter.removeLecteur(lecteur);
    }


    private void ajouter() {
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
        Lecteur lec = new Lecteur(0, nom, prenom, dn, adr, mail, tel);
        presenter.addLecteur(lec);
    }
}

