package bibliotheque.mvp.model;


import bibliotheque.metier.Exemplaire;
import bibliotheque.metier.Lecteur;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.*;

public class LecteurModelV1 implements DAOLecteur,SpecialLecteur {
    private int numcli = 0;
    private List<Lecteur> lecteurs = new ArrayList<>();

    public LecteurModelV1(){

        try {
            populate();
        } catch (Exception e) {
            System.out.println("erreur : "+e);
        }
    }
    @Override
    public Lecteur addLecteur(Lecteur lec) {
        boolean present = lecteurs.contains(lec);
        if (!present) {
            numcli++;
            lec.setNumlecteur(numcli);
            lecteurs.add(lec);
            return lec;
        } else return null;
    }

    @Override
    public boolean removeLecteur(Lecteur lec) {
        return lecteurs.remove(lec);
    }

    @Override
    public Lecteur updateLecteur(Lecteur lecteur) {
        //int idLecteur = lecteur.getNumlecteur();
        int p = lecteurs.indexOf(lecteur);
        if (p < 0) return null;
        lecteurs.set(p, lecteur);//remplacement du lecteur à la même position
        return lecteur;
    }

    @Override
    public Lecteur readLecteur(int idLecteur) {
        for (Lecteur l : lecteurs) {
            if (l.getNumlecteur() == idLecteur) return l;
        }
        return null;
    }

    @Override
    public List<Lecteur> getLecteurs() {
        return lecteurs;
    }

    private void populate() throws Exception {
        Lecteur lec = new Lecteur(0,"Dupont","Jean", LocalDate.of(2000,1,4),"Mons","jean.dupont@mail.com","0458774411");
        addLecteur(lec);
        lec = new Lecteur(0,"Durant","Aline",LocalDate.of(1980,10,10),"Binche","aline.durant@mail.com","045874444");
        addLecteur(lec);
    }

    @Override
    public List<Exemplaire> exemplairesEnLocation(Lecteur l) {
        return l.listerExemplairesEnLocation();
    }

    @Override
    public List<Exemplaire> exemplairesLoues(Lecteur l) {
        return new ArrayList<>(l.listerExemplairesLoues());
    }

    @Override
    public Lecteur lecParMail(String mail) {
        return null;
    }

    public List<Lecteur> lectFichier(){
        File Fichier = new File("C:/Users/Kevin/IdeaProjects/poo2_enonceBase/src/bibliotheque/utilitaires/nouveaux_lecteurs.txt");
        String ph;
        List<String> ldat = new ArrayList<>();
        Set<Lecteur> sLect = new HashSet<>();
        Lecteur tmpLect;
        try(FileReader in = new FileReader(Fichier)){
            Scanner sca = new Scanner(in);
            ph = sca.nextLine();
            ldat.add(ph);
        }catch (FileNotFoundException e){
            System.out.println("Erreur fichier introuvble  : " +e.getMessage());
        }catch (IOException e){
            System.out.println("Problème d'accès : " + e.getMessage());
        }
        int i = 0;
        while(ldat.get(i) !=null){
            List<String> oneLect = ldat.subList(0,6);
            int id = Integer.parseInt(oneLect.get(0));
            String nom = oneLect.get(1);
            String pren = oneLect.get(2);
            LocalDate dn = LocalDate.parse(oneLect.get(3));
            String adr = oneLect.get(4);
            String mail = oneLect.get(5);
            String tel = oneLect.get(6);
            try{
                tmpLect = new Lecteur(id,nom,pren,dn,adr,mail,tel);
                System.out.println("Test tmplect  : " + tmpLect);
                sLect.add(tmpLect);
            }catch (Exception e){
                System.out.println("Erreur lors de la création du lecteur fichier : " + e);
            }
            for(int j = 0; i < ldat.size(); j +=6){
                oneLect.remove(j);
            }
        }

        List<Lecteur> llect = new ArrayList<>(sLect);

        return llect;
    }
}