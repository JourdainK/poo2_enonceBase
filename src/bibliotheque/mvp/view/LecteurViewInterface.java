package bibliotheque.mvp.view;

import bibliotheque.metier.Exemplaire;
import bibliotheque.metier.Lecteur;
import bibliotheque.mvp.presenter.LecteurPresenter;
import bibliotheque.mvp.presenter.LecteurPresenterV1;


import java.util.List;

public interface LecteurViewInterface {
    public void setPresenter(LecteurPresenterV1 presenter);

    public void setListDatas(List<Lecteur> lecteurs);

    public void affMsg(String msg);


    void affList(List<Exemplaire> lex);

    Lecteur selectionner(List<Lecteur> all);
}
