package bibliotheque.mvp.view;

import bibliotheque.metier.Lecteur;
import bibliotheque.mvp.presenter.LecteurPresenter;


import java.util.List;

public interface LecteurViewInterface {
    public void setPresenter(LecteurPresenter presenter);

    public void setListDatas(List<Lecteur> lecteurs);

    public void affMsg(String msg);


}
