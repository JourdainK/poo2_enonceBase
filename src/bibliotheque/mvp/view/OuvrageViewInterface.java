package bibliotheque.mvp.view;

import bibliotheque.metier.Ouvrage;
import bibliotheque.mvp.presenter.OuvragePresenter;

import java.util.List;

public interface OuvrageViewInterface {

    public void setPresenter(OuvragePresenter presenter);

    public void setListDatas(List<Ouvrage> listOuvrages);

    public void affMsg(String msg);

    void affList(List<Ouvrage> louv);

}
