package fr.gsb.rv.entites;

public class Cadeau {

    private int qte ;

    public Cadeau(int qte) {
        this.qte = qte;
    }

    public int getQte() {
        return qte;
    }

    public void setQte(int qte) {
        this.qte = qte;
    }

    @Override
    public String toString() {
        return "Cadeau{" +
                "qte=" + qte +
                '}';
    }

}
