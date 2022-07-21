package com.example.esameengim.model;


import java.sql.Date;
import java.sql.Timestamp;


public class Ordine {

    private int Id;
    private int Numero;
    private Date Data;

    public Ordine(int id, int numero, Date data) {
        Id = id;
        Numero = numero;
        Data = data;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getNumero() {
        return Numero;
    }

    public void setNumero(int numero) {
        Numero = numero;
    }

    public Date getData() {
        return Data;
    }

    public void setData(Date data) {
        Data = data;
    }

    @Override
    public String toString() {
        return "Ordine{" +
                "Id=" + Id +
                ", Numero=" + Numero +
                ", Data=" + Data +
                '}';
    }
}
