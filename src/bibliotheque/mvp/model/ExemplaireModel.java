package bibliotheque.mvp.model;

import bibliotheque.metier.*;

import java.time.LocalDate;
import java.util.*;

public class ExemplaireModel extends AbstractModel<Exemplaire> implements SpecialExemplaire {
    @Override
    public void modifierEtat(Exemplaire ex, String etat) {
         ex.setDescriptionEtat(etat);
    }

    @Override
    public Lecteur lecteurActuel(Exemplaire ex) {
        return ex.lecteurActuel();
    }

    @Override
    public List<Lecteur> lecteurs(Exemplaire ex) {
        return ex.lecteurs();
    }

    @Override
    public void envoiMailLecteurActuel(Exemplaire ex) {
        Lecteur lect = ex.lecteurActuel();
        String mailLect = lect.getMail();
        List<Location> loclect = lect.getLloc();
        StringBuilder phlocations = new StringBuilder();
        phlocations.append("Vous avez loués les exemplaires suivants : ");
        for(Location l:loclect){
            phlocations.append(l.toString());
            phlocations.append("\n");
        }
        LocalDate today = LocalDate.now();
        String tod = today.toString();
        String locs = phlocations.toString();
        Mail mail = new Mail("Information", locs, tod);
        mail.envoi(lect.getMail());
    }

    @Override
    public void envoiMailLecteurs(Exemplaire ex) {
     Set<Lecteur> llec = new HashSet<>();
     List<Location> lloc = ex.getLloc();

     for(Location l : lloc){
         llec.add(l.getLoueur());
     }

     StringBuilder phr = new StringBuilder();
     phr.append("Vouez avez loué : \nNuméro de matricule : ");
     phr.append(ex.getMatricule());
     phr.append("\n");
     phr.append(ex.getOuvrage().getTitre());
     phr.append("\n");
     phr.append("La bibliothèque");
     String titre = phr.toString();
     LocalDate today = LocalDate.now();
     String to = today.toString();
     for(Lecteur le : llec){
         Mail mail = new Mail("Information", titre,to);
         mail.envoi(le.getMail());
     }

    }

    @Override
    public boolean enRetard(Exemplaire ex) {
        return ex.enRetard();
    }

    @Override
    public int joursRetard(Exemplaire ex) {
        return ex.joursRetard();
    }

    @Override
    public boolean enLocation(Exemplaire ex) {
        return ex.enLocation();
    }
}
