package bibliotheque.mvp.view;

import bibliotheque.metier.Exemplaire;
import bibliotheque.mvp.presenter.ExemplairePresenter;

import java.util.List;

public interface ExemplaireViewInterface {
    public void setPresenter(ExemplairePresenter presenter);
    public void setListDatas(List<Exemplaire> lexemp);
}
