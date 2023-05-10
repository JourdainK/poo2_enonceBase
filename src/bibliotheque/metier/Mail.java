package bibliotheque.metier;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Mail {
    private String objet;
    private String message;
    private String dateEnvoi;

    public Mail(String objet, String message, String dateEnvoi) {
        this.objet = objet;
        this.message = message;
        this.dateEnvoi = dateEnvoi;
    }

    public String getObjet() {
        return objet;
    }

    public void setObjet(String objet) {
        this.objet = objet;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDateEnvoi() {
        return dateEnvoi;
    }

    public void setDateEnvoi(String dateEnvoi) {
        this.dateEnvoi = dateEnvoi;
    }

    @Override
    public String toString() {
        return "Mail{" +
                "objet='" + objet + '\'' +
                ", message='" + message + '\'' +
                ", dateEnvoi='" + dateEnvoi + '\'' +
                '}';
    }

    public void envoi(String mailDestinataire){
        File mailFile;
        StringBuilder ph = new StringBuilder();
        ph.append("C:\\Users\\Kevin\\IdeaProjects\\poo2_enonceBase\\src\\bibliotheque\\utilitaires\\mails\\");
        ph.append(mailDestinataire);
        ph.append(".txt");

        String pathfile = ph.toString();
        mailFile = new File(pathfile);

        //add true to mailFile, true -> append new mail to old mails
        try(FileWriter out = new FileWriter(mailFile, true)){
            PrintWriter pw = new PrintWriter(out);
            pw.println(this.objet);
            pw.println(this.message);
            pw.println("La Bibliothèque");
        }catch (IOException e){
            System.out.println("");
        }
    }
}
