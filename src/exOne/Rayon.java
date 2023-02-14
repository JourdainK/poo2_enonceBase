package exOne;

import java.util.ArrayList;
import java.util.List;

public class Rayon {
    private String codeRayon, genre;
    private List<Exemplaire> listExemplaires;

    public Rayon(){
        this.codeRayon = "";
        this.genre = "";
        listExemplaires = new ArrayList<>();
    }

    public Rayon(String codeRayon, String genre){
        this.codeRayon = codeRayon;
        this.genre = genre;
        listExemplaires = new ArrayList<>();
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

        return "\nRayon n° :" + codeRayon +
                "\tGenre :" + genre;
    }

}
