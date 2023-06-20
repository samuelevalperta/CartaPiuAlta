package it.unibs.ing.fp.lab.cartaalta;

public enum TipoMazzo {
    ITALIANO("ITALIANO", new String[] { "SPADE", "BASTONI", "DENARI", "COPPE" }, ValoreCarteItaliane.values()),
    FRANCESE("FRANCESE", new String[] { "CUORI", "QUADRI", "FIORI", "PICCHE" }, ValoreCarteFrancesi.values());

    private String nome;
    private String[] semi;
    private IValoreCarta[] valori;

    TipoMazzo(String nome, String[] semi, IValoreCarta[] valori) {
        this.nome = nome;
        this.semi = semi;
        this.valori = valori;
    }

    public String getNome() {
        return nome;
    }

    public String[] getSemi() {
        return semi;
    }

    public IValoreCarta[] getValori() {
        return valori;
    }
}
