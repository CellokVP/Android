package fr.gsb.rv.entites;

import java.util.Map;

public class RapportVisite {
    private int rap_num ;
    private String rap_date_visite ;
    private String rap_bilan ;
    private String rap_motif ;
    private String rap_coefconfiance ;
    private String rap_datesaisie ;


    public RapportVisite(int rap_num, String rap_date_visite, String rap_bilan){
        this.rap_num = rap_num ;
        this.rap_date_visite = rap_date_visite ;
        this.rap_bilan = rap_bilan ;
    }

    public int getRap_num(){
        return rap_num ;
    }

    public void setRap_num( int rap_num ){
        this.rap_num = rap_num ;
    }

    public String getRap_bilan(){
        return rap_bilan;
    }

    public void setRap_bilan( String rap_bilan ){
        this.rap_bilan = rap_bilan ;
    }

    public String getRap_date_visite(){
        return rap_date_visite ;
    }

    public void setRap_date_visite( String rap_date_visite ){
        this.rap_date_visite = rap_date_visite ;
    }

    public String toString(){
        return "Numéro du rapport de visite : " + rap_num + "\n" +
               "Bilan du rapport de visite : " + rap_bilan + "\n" +
               "Date du rapport de visite : " + rap_date_visite ;
    }





}
