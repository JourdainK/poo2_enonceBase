package bibliotheque.metier;

import java.time.LocalDate;
import java.time.Period;
import java.util.*;

public class Exemplaire {

    private String matricule;
    private String descriptionEtat;

    private Ouvrage ouvrage;
    private Rayon rayon;

    private List<Location> lloc= new ArrayList<>();


    public Exemplaire(String matricule, String descriptionEtat,Ouvrage ouvrage) {
        this.matricule = matricule;
        this.descriptionEtat=descriptionEtat;
        this.ouvrage = ouvrage;
        this.ouvrage.getLex().add(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Exemplaire that = (Exemplaire) o;
        return Objects.equals(matricule, that.matricule);
    }

    @Override
    public int hashCode() {
        return Objects.hash(matricule);
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getDescriptionEtat() {
        return descriptionEtat;
    }

    public void setDescriptionEtat(String descriptionEtat) {
        this.descriptionEtat = descriptionEtat;
    }

     public Ouvrage getOuvrage() {
        return ouvrage;
    }

    public void setOuvrage(Ouvrage ouvrage) {
        if(this.ouvrage!=null) this.ouvrage.getLex().remove(this);
        this.ouvrage = ouvrage;
        this.ouvrage.getLex().add(this);
    }

    public Rayon getRayon() {
        return rayon;
    }

    public void setRayon(Rayon rayon) {
        if(this.rayon!=null) this.rayon.getLex().remove(this);
        this.rayon=rayon;
        this.rayon.getLex().add(this);
    }

    public List<Location> getLloc() {
        return lloc;
    }

    public void setLloc(List<Location> lloc) {
        this.lloc = lloc;
    }

    @Override
    public String toString() {
        return "Exemplaire{" +
                "matricule='" + matricule + '\'' +
                ", descriptionEtat='" + descriptionEtat + '\'' +
                ", ouvrage=" + ouvrage +
                ", rayon=" + rayon +
                '}';
    }

    public void modifierEtat(String etat){
        this.descriptionEtat = etat;
    }

    public Lecteur lecteurActuel(){
        Lecteur lectAtm;
        lectAtm = lloc.get(lloc.size()-1).getLoueur();
        LocalDate restit= lloc.get(lloc.size()-1).getDateRestitution();

        if(restit != null){
            return lectAtm;
        }
        else{
            System.out.println("Pas de lecteur actuel");
            return null;
        }

    }
    public List<Lecteur> lecteurs(){
        List<Lecteur> lectsList;

        return null;
    }

    public void envoiMailLecteurActuel(Mail mail){
        Location lastLoc;
        Lecteur lectAtm;
        String mailLectAtm;

        lastLoc = lloc.get(lloc.size()-1);
        lectAtm = lastLoc.getLoueur();
        mailLectAtm = lectAtm.getMail();

        System.out.println("Envoi du mail à " + lectAtm.getNom() + " " + lectAtm.getPrenom());
        System.out.println("Adresse email du lecteur/lectrice : " + lectAtm.getMail());
        System.out.println("--- Mail ---\n");
        System.out.println(mail);

        lastLoc = null;
        lectAtm = null;
    }
    public void envoiMailLecteurs(Mail mail){
        //TODO check / ask /test if works !!!! not sure about the map => idea was to avoid getting twice the same client in the list -> should do that before adding to the list !
        List<Lecteur> listAllLect = new ArrayList<>();
        Map<Integer,String> mMailLect = new HashMap<>();
        int tmpId;
        String tmpMail;

        for(Location l:lloc){
            tmpId = l.getLoueur().getNumlecteur();
            tmpMail = l.getLoueur().getMail();
            System.out.println(tmpMail);
            mMailLect.put(tmpId,tmpMail);
        }

        //https://stackoverflow.com/questions/46898/how-do-i-efficiently-iterate-over-each-entry-in-a-java-map
        //? https://www.baeldung.com/java-email
        for(Map.Entry<Integer,String> entry : mMailLect.entrySet()){
            System.out.println("Envoie du mail à : " + entry.getValue());
            System.out.println("---- mail ----");
            System.out.println(mail);
        }

        listAllLect = null;
        mMailLect = null;

    }

    public boolean enRetard(){
        LocalDate tday = LocalDate.now();

        Location lastLoca = lloc.get(lloc.size()-1);
        if(lastLoca.getDateRestitution().isBefore(tday)){
            return true;
        }
        else{
            return false;
        }
    }

    public int joursRetard(){
        if(enRetard()){
            int daysLate;
            LocalDate today = LocalDate.now();
            Location lastLocat = lloc.get(lloc.size()-1);
            Period p = lastLocat.getDateRestitution().until(today);
            daysLate = ((p.getYears()*12)*30) + (p.getMonths()*30) + p.getDays();

            return daysLate;
        }
        else {
            return 0;
        }

    }


    public boolean enLocation(){
        LocalDate tod = LocalDate.now();
        Location lastLtion = lloc.get(lloc.size()-1);
        if(!this.enRetard() && lastLtion.getDateRestitution().isAfter(tod)){
            return true;
        }
        else{
            return false;
        }

    }

}
