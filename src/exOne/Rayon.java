package exOne;

import java.util.List;

public class Rayon {
    private String codeRayon, genre;
    private List<Exemplaire> listExemplaires;

    public Rayon(){
        this.codeRayon = "";
        this.genre = "";
    }

    public Rayon(String codeRayon, String genre){
        this.codeRayon = codeRayon;
        this.genre = genre;
    }

    public String getCodeRayon() {
        return codeRayon;
    }

    public String getGenre() {
        return genre;
    }

    public List<Exemplaire> getListExemplaires() {
        return listExemplaires;
    }

    public void setCodeRayon(String codeRayon) {
        this.codeRayon = codeRayon;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setListExemplaires(List<Exemplaire> listExemplaires) {
        this.listExemplaires = listExemplaires;
    }

    //TODO check method if <Examplaire> isn't in the List > return boolean
    //TODO add method that add an <Examplaire>/copy to the List if check is false (not found)

    @Override
    public String toString() {
        String listCopies = "";

        for(Exemplaire l:listExemplaires) {
            listCopies += String.valueOf(l.getMatricule());
            listCopies += " \tétat : " + l.getDescriptionEtat() + "\n";
        }

        return "\nRayon n° :" + codeRayon +
                "\tGenre :" + genre +
                "Liste des exemplaires : " + listCopies;
    }

}
