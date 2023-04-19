package bibliotheque.mvp.view;

import bibliotheque.metier.Exemplaire;
import bibliotheque.mvp.presenter.ExemplairePresenter;

import java.util.List;
import java.util.Scanner;

public class ExemplaireViewConsole implements ExemplaireViewInterface{
    private ExemplairePresenter presenter;
    private List<Exemplaire> lExemplaires;
    private Scanner sc = new Scanner(System.in);

    public void ExemplaireViewConsole(){

    }


    @Override
    public void setPresenter(ExemplairePresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void setListDatas(List<Exemplaire> lexemp) {
        this.lExemplaires = lexemp;
        menu();
    }

    public void affMsg(String msg){
        System.out.println("Information : " + msg);
    }

    public void menu(){
        //TODO menu exemplaires
    }
}
