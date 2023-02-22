package exOne;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Mail {
    private String objet;
    private String message;
    private LocalDateTime dateEnvoi;

    public Mail(String objet,String message, LocalDateTime dateEnvoi){
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

    public LocalDateTime getDateEnvoi() {
        return dateEnvoi;
    }

    public void setDateEnvoi(LocalDateTime dateEnvoi) {
        this.dateEnvoi = dateEnvoi;
    }

    @Override
    public String toString() {
        return "\n--- Mail ---" +
                "\nObjet : " + objet +
                "\nMessage : " + message +
                "\nDate d'envoi" + dateEnvoi;
    }
}
