package bibliotheque.mvp.presenter;

import bibliotheque.mvp.model.DAOExemplaire;
import bibliotheque.mvp.view.ExemplaireViewInterface;

public class ExemplairePresenter {
    private DAOExemplaire model;

    private ExemplaireViewInterface view;

    public ExemplairePresenter(DAOExemplaire model, ExemplaireViewInterface view){
        this.model=model;
        this.view=view;
        this.view.setPresenter(this);
    }
}
