    package bibliotheque.mvp;

    import bibliotheque.metier.*;
    import bibliotheque.mvp.model.*;
    import bibliotheque.mvp.presenter.*;
    import bibliotheque.mvp.view.*;
    import bibliotheque.utilitaires.Utilitaire;

    import java.time.LocalDate;
    import java.time.LocalTime;
    import java.util.Arrays;
    import java.util.List;

    public class GestBiblio {

        private DAO<Lecteur> lm;
        private ViewInterface<Lecteur> lv;
        private Presenter<Lecteur> lp;

        private DAO<Rayon> rm;
        private ViewInterface<Rayon> rv;
        private Presenter<Rayon> rp;
        private DAO<Auteur> am;
        private ViewInterface<Auteur> av;
        private Presenter<Auteur> ap;

        private DAO<Ouvrage> om;
        private ViewInterface<Ouvrage> ov;
        private Presenter<Ouvrage> op;


        private DAO<Exemplaire> em;
        private ViewInterface<Exemplaire> ev;
        private Presenter<Exemplaire> ep;


        private DAO<Location> locm;
        private ViewInterface<Location> locv;
        private Presenter<Location> locp;

        public void gestion(){
            lm = new LecteurModel();
            lv = new LecteurViewConsole();
            lp = new LecteurPresenter(lm, lv);//création et injection de dépendance

            rm = new RayonModel();
            rv = new RayonViewConsole();
            rp = new RayonPresenter(rm,rv);//création et injection de dépendance

            om = new OuvrageModel();
            ov = new OuvrageViewConsole();
            op = new OuvragePresenter(om,ov);//création et injection de dépendance

            em = new ExemplaireModel();
            ev = new ExemplaireViewConsole();
            ep = new ExemplairePresenter(em,ev);//création et injection de dépendance

            am = new AuteurModel();
            av = new AuteurViewConsole();
            ap = new AuteurPresenter(am,av);//création et injection de dépendance

            locm = new LocationModel();
            locv = new LocationViewConsole();
            locp = new LocationPresenter(locm,locv);//création et injection de dépendance
    try {
        populate();
    }
    catch (Exception e) {
        System.out.println("erreur lors du populate : " + e);
        System.exit(1);
    }
            List<String> loptions = Arrays.asList("lecteurs","rayon","ouvrages","exemplaires","auteurs","locations","fin");
            do {
                int ch = Utilitaire.choixListe(loptions);
                switch (ch){
                    case 1: lp.start();
                        break;
                    case 2: rp.start();
                        break;
                    case 3: op.start();
                        break;
                    case 4: ep.start();
                        break;
                    case 5: ap.start();
                        break;
                    case 6: locp.start();
                        break;

                    case 7 : System.exit(0);
                }
            }while(true);
        }
        public void populate() throws Exception{

            Auteur a = new Auteur("Verne","Jules","France");
            am.add(a);
            a = new Auteur("Spielberg","Steven","USA");
            am.add(a);
            a = new Auteur("Kubrick","Stanley","GB");
            am.add(a);

            Rayon r = new Rayon("r001","SF");
            rm.add(r);
            r= new Rayon("r002","Techno");
            rm.add(r);
            r = new Rayon("r003","aventure");
            rm.add(r);
            r = new Rayon("r004","POP");
            rm.add(r);

            Lecteur lec = new Lecteur(0,"Dupont","Jean", LocalDate.of(2000,1,4),"Mons","jean.dupont@mail.com","0458774411");
            lm.add(lec);
            lec = new Lecteur(0,"Durant","Aline",LocalDate.of(1980,10,10),"Binche","aline.durant@mail.com","045874444");
            lm.add(lec);

            Livre l = new Livre("Vingt mille lieues sous les mers",10, LocalDate.of(1880,1,1),1.50,"français","aventure","a125",350, TypeLivre.ROMAN,"histoire de sous-marin");
            om.add(l);
            am.getAll().get(0).addOuvrage(l);

            DVD d = new DVD("AI",12,LocalDate.of(2000,10,1),2.50,"anglais","SF",4578l, LocalTime.of(2,0,0),(byte)2);
            d.getAutresLangues().add("français");
            d.getAutresLangues().add("italien");
            d.getSousTitres().add("néerlandais");
            om.add(d);

            am.getAll().get(1).addOuvrage(d);
            am.getAll().get(2).addOuvrage(d);


            CD c = new CD("The Compil 2023",0,LocalDate.of(2023,1,1),2,"English","POP",1245,(byte)20,LocalTime.of(1,40,0));
            om.add(c);


            Exemplaire e = new Exemplaire("m12","état neuf",om.getAll().get(0));
            em.add(e);
            rm.getAll().get(2).addExemplaire(e);



            e = new Exemplaire("d12","griffé",om.getAll().get(1));
            em.add(e);
            rm.getAll().get(0).addExemplaire(e);




            Location loc = new Location(LocalDate.of(2023,2,1),LocalDate.of(2023,3,1),lm.getAll().get(0),em.getAll().get(0));
            locm.add(loc);
            loc.setDateRestitution(LocalDate.of(2023,2,4));



            loc = new Location(LocalDate.of(2023,2,5),LocalDate.of(2023,3,5),lm.getAll().get(1),em.getAll().get(1));
            locm.add(loc);

        }

        public static void main(String[] args) {
            GestBiblio gb = new GestBiblio();
            gb.gestion();
        }


    }
