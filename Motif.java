package fr.gsb.rv.entites;

public class Motif {
    private int num_motif ;

    private String motif ;

    public Motif(int num_motif, String motif) {
        this.num_motif = num_motif;
        this.motif = motif;
    }

    public int getNum_motif() {
        return num_motif;
    }

    public String getMotif() {
        return motif;
    }

    public void setNum_motif(int num_motif) {
        this.num_motif = num_motif;
    }

    public void setMotif(String motif) {
        this.motif = motif;
    }

    @Override
    public String toString() {
        return "Motif{" +
                "num_motif=" + num_motif +
                ", motif='" + motif + '\'' +
                '}';
    }
}
