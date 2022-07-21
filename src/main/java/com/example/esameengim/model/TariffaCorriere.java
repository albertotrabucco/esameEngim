package com.example.esameengim.model;

public class TariffaCorriere {

    private int Id;
    private String nome_corriere;
    private String nome_tariffa;
    private float peso_massimo;
    private float costo;

    public TariffaCorriere(int id, String nome_corriere, String nome_tariffa, float peso_massimo, float costo) {
        Id = id;
        this.nome_corriere = nome_corriere;
        this.nome_tariffa = nome_tariffa;
        this.peso_massimo = peso_massimo;
        this.costo = costo;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getNome_corriere() {
        return nome_corriere;
    }

    public void setNome_corriere(String nome_corriere) {
        this.nome_corriere = nome_corriere;
    }

    public String getNome_tariffa() {
        return nome_tariffa;
    }

    public void setNome_tariffa(String nome_tariffa) {
        this.nome_tariffa = nome_tariffa;
    }

    public float getPeso_massimo() {
        return peso_massimo;
    }

    public void setPeso_massimo(float peso_massimo) {
        this.peso_massimo = peso_massimo;
    }

    public float getCosto() {
        return costo;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }

    @Override
    public String toString() {
        return "TariffaCorriere{" +
                "Id=" + Id +
                ", nome_corriere='" + nome_corriere + '\'' +
                ", nome_tariffa='" + nome_tariffa + '\'' +
                ", peso_massimo=" + peso_massimo +
                ", costo=" + costo +
                '}';
    }
}
