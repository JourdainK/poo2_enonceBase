package bibliotheque.mvp.view;


import bibliotheque.mvp.presenter.Presenter;

import java.util.List;

public interface ViewInterface<T> {
    public void setPresenter(Presenter<T> presenter);

    public void setListDatas(List<T> datas);

    public void affMsg(String msg);

    public void affList(List l);

    public T selectionner(List<T> l);
}
