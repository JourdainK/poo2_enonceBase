package bibliotheque.mvp.view;

import bibliotheque.metier.Rayon;
import bibliotheque.mvp.presenter.RayonPresenter;

import java.util.List;

public interface RayonViewInterface {
    public void setPresenter(RayonPresenter presenter);
    public void setListDatas(List<Rayon> lrayons);
    public void affMsg(String msg);
    void affList(List<Rayon> lrayons);
}
