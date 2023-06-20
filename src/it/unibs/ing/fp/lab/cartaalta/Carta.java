package it.unibs.ing.fp.lab.cartaalta;

public class Carta {
    private String seme;
    private IValoreCarta valore;

    public Carta(String seme, IValoreCarta valore) {
        this.seme = seme;
        this.valore = valore;
    }

    public String getSeme() {
        return seme;
    }

    public IValoreCarta getValore() {
        return valore;
    }

    public int compareTo(Carta carta) {
        return valore.getValore() - carta.getValore().getValore();
    }

    @Override
    public String toString() {
        return valore.getNome() + " di " + this.seme;
    }
}
