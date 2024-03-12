package fr.gsb.rv.technique;

import fr.gsb.rv.entites.Visiteur;
import fr.gsb.rv.modeles.ModeleGSB;

public class Session extends Visiteur {
    private static Session session = null ;
    private Visiteur unVisiteur ;


    public Session(Visiteur leVisiteur) {
        super();
    }

    private void Session(Visiteur unVisiteur) {
        this.unVisiteur = unVisiteur ;
    }

    public static void ouvrir(Visiteur unVisiteur){
        if(session == null){
            Session session = new Session(unVisiteur) ;
        }
    }

    public static Session getSession(){
        return session ;
    }

    public static void fermer(){
        session = null ;
    }



}
