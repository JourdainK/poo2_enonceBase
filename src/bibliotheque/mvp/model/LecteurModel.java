package bibliotheque.mvp.model;

import bibliotheque.metier.Exemplaire;
import bibliotheque.metier.Lecteur;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class LecteurModel extends AbstractModel<Lecteur> implements SpecialLecteur {
    private int numLecteur = 0;
    private List<Lecteur> lecteurs = new ArrayList<>();
    private Map<String,Lecteur> hml= new HashMap<>();
    public Lecteur add(Lecteur nl){
        Lecteur l = super.add(nl);
        if(l!=null) {
            l.setNumlecteur(++numLecteur);
            hml.put(l.getMail(),l);
        }
        return  l;
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
        return hml.get(mail);
    }

    public List<Lecteur> lectFichier(){
        File Fichier = new File("C:/Users/Kevin/IdeaProjects/poo2_enonceBase/src/bibliotheque/utilitaires/nouveaux_lecteurs.txt");
        String ph;
        List<String> ldat = new ArrayList<>();
        Set<Lecteur> sLect = new HashSet<>();
        Lecteur tmpLect;
        try(FileReader in = new FileReader(Fichier)){
            Scanner sca = new Scanner(in);
            while(sca.hasNext()){
                ph = sca.nextLine();
                ldat.add(ph);
            }
        }catch (FileNotFoundException e){
            System.out.println("Erreur fichier introuvble  : " +e.getMessage());
        }catch (IOException e){
            System.out.println("Problème d'accès : " + e.getMessage());
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        int i = 0;
        while(ldat.get(i) !=null){
            List<String> oneLect = ldat.subList(0,7);
            int id = Integer.parseInt(oneLect.get(0));
            String nom = oneLect.get(1);
            String pren = oneLect.get(2);

            LocalDate dn = LocalDate.parse(oneLect.get(3),formatter);
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
            for(int j = 0; j < 6; j++){
                ldat.remove(oneLect.get(j));
            }
        }
        List<Lecteur> llect = new ArrayList<>(sLect);
        for(Lecteur l: llect){
            this.add(l);
        }

        return llect;
    }
}