package com.example.esameengim.model;

public class Articolo {

    private int Id;
    private String Codice;
    private String Descrizione;
    private float Peso;

    public Articolo(int id, String codice, String descrizione, float peso) {
        Id = id;
        Codice = codice;
        Descrizione = descrizione;
        Peso = peso;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getCodice() {
        return Codice;
    }

    public void setCodice(String codice) {
        Codice = codice;
    }

    public String getDescrizione() {
        return Descrizione;
    }

    public void setDescrizione(String descrizione) {
        Descrizione = descrizione;
    }

    public float getPeso() {
        return Peso;
    }

    public void setPeso(float peso) {
        Peso = peso;
    }

    @Override
    public String toString() {
        return "Articolo{" +
                "Id=" + Id +
                ", Codice='" + Codice + '\'' +
                ", Descrizione='" + Descrizione + '\'' +
                ", Peso=" + Peso +
                '}';
    }
}
