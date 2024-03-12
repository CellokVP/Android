package fr.gsb.rv.entites;

public class Medicament {

    private String med_depotlegal ;
    private String med_nomcommercial ;
    private String med_composition ;
    private String med_effets ;
    private String med_contreindic ;
    private String med_prixechantillon ;

    public Medicament( String med_composition, String med_contreindic, String med_depotlegal, String med_nomcommercial, String med_effets, String med_prixechantillon){
        this.med_composition = med_composition ;
        this.med_contreindic = med_contreindic ;
        this.med_depotlegal = med_depotlegal ;
        this.med_effets = med_effets ;
        this.med_prixechantillon = med_prixechantillon ;
        this.med_nomcommercial = med_nomcommercial ;
    }

    public void setMed_depotlegal(String med_depotlegal) {
        this.med_depotlegal = med_depotlegal;
    }

    public String getMed_nomcommercial() {
        return med_nomcommercial;
    }

    public void setMed_nomcommercial(String med_nomcommercial) {
        this.med_nomcommercial = med_nomcommercial;
    }

    public String getMed_composition() {
        return med_composition;
    }

    public void setMed_composition(String med_composition) {
        this.med_composition = med_composition;
    }

    public String getMed_effets() {
        return med_effets;
    }

    public void setMed_effets(String med_effets) {
        this.med_effets = med_effets;
    }

    public String getMed_contreindic() {
        return med_contreindic;
    }

    public void setMed_contreindic(String med_contreindic) {
        this.med_contreindic = med_contreindic;
    }

    public String getMed_prixechantillon() {
        return med_prixechantillon;
    }

    public void setMed_prixechantillon(String med_prixechantillon) {
        this.med_prixechantillon = med_prixechantillon;
    }

    @Override
    public String toString() {
        return "Medicament{" +
                "med_depotlegal='" + med_depotlegal + '\'' +
                ", med_nomcommercial='" + med_nomcommercial + '\'' +
                ", med_composition='" + med_composition + '\'' +
                ", med_effets='" + med_effets + '\'' +
                ", med_contreindic='" + med_contreindic + '\'' +
                ", med_prixechantillon='" + med_prixechantillon + '\'' +
                '}';
    }
}
