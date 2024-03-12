package fr.gsb.rv.modeles;

import java.util.ArrayList;
import java.util.List ;

import fr.gsb.rv.entites.Cadeau;
import fr.gsb.rv.entites.Praticiens;
import fr.gsb.rv.entites.Visiteur;

public class ModeleGSB {

    private static ModeleGSB modele = null ;

    private List<Visiteur> lesVisiteurs = new ArrayList<Visiteur>() ;

    private List<Praticiens> lesPraticiens = new ArrayList<Praticiens>() ;

    private List<Cadeau> lesQuantites = new ArrayList<Cadeau>();

    private ModeleGSB(){
        super() ;
        this.peupler() ;
    }

    public static ModeleGSB getInstance(){
        if( ModeleGSB.modele == null ){
            modele = new ModeleGSB() ;
        }
        return ModeleGSB.modele ;
    }



    private void peupler(){
        this.lesVisiteurs.add( new Visiteur("a131","azerty","Villechalane","Louis") ) ;
        this.lesVisiteurs.add( new Visiteur("b13","azerty","Bentot","Pascal") ) ;
        this.lesVisiteurs.add( new Visiteur("b16","azerty","Bioret","Luc") ) ;
        this.lesVisiteurs.add( new Visiteur("a17","azerty","Andre","David") ) ;
        this.lesVisiteurs.add( new Visiteur("a","a","Vicente","Téo") ) ;

        this.lesPraticiens.add( new Praticiens(1, "Vicente", "Téo", "46 rue", 94300, "Vincennes", 5)) ;
        this.lesPraticiens.add( new Praticiens(2, "Braas", "Bastien", "48 rue", 75000, "Le peureux", 1)) ;
        this.lesPraticiens.add( new Praticiens(3, "Gambo", "Adam", "4 rue", 72000, "Nogent", 3)) ;
        this.lesPraticiens.add( new Praticiens(4, "Fert", "Timothée", "15696 rue", 93000, "Paris", 4)) ;

        this.lesQuantites.add(new Cadeau(1)) ;
    }

    public Visiteur seConnecter(String matricule, String mdp){

        for( Visiteur unVisiteur : this.lesVisiteurs ){
            if( unVisiteur.getMatricule().equals(matricule) && unVisiteur.getMdp().equals(mdp) ){
                return unVisiteur ;
            }
        }

        return null ;

    }

    public List<Praticiens> listPraticiens(){
        ArrayList<Praticiens> listePraticien = new ArrayList<>();
        for (int i = 0 ; i < this.lesPraticiens.size() ; i++ ){
            listePraticien.add(lesPraticiens.get(i)) ;
        }
        return listePraticien ;
    }

    public ArrayList<Cadeau> getLesEchantillons( Integer ){

    }

    public Object getLesEchantillons(Integer posEchantillons) {
    }

    public static int getQte() {

    }
}
