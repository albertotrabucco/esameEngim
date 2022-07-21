package com.example.esameengim.model;

public class Voce {

    private int Id_ordine;
    private int articolo;
    private int quantità;

    public Voce(int id_corriere, int articolo, int quantità) {
        Id_ordine = id_corriere;
        this.articolo = articolo;
        this.quantità = quantità;
    }

    public int getId_ordine() {
        return Id_ordine;
    }

    public void setId_ordine(int id_ordine) {
        Id_ordine = id_ordine;
    }

    public int getArticolo() {
        return articolo;
    }

    public void setArticolo(int articolo) {
        this.articolo = articolo;
    }

    public int getQuantità() {
        return quantità;
    }

    public void setQuantità(int quantità) {
        this.quantità = quantità;
    }

    @Override
    public String toString() {
        return "Voce{" +
                "Id_corriere=" + Id_ordine +
                ", articolo=" + articolo +
                ", quantità=" + quantità +
                '}';
    }
}
