package bibliotheque.mvp.view;

import bibliotheque.metier.Auteur;
import bibliotheque.metier.Exemplaire;
import bibliotheque.mvp.presenter.AuteurPresenter;

import java.util.List;

public class AuteurViewConsole implements AuteurViewInterface{

    //TODO methods auteur View

    @Override
    public void setPresenter(AuteurPresenter presenter) { }

    @Override
    public void setListDatas(List<Auteur> auteurs) { }

    @Override
    public void affList(List<Exemplaire> lex) { }

    @Override
    public void affMsg(String msg) { }


}
