package com.example.esameengim.model.repository;

import com.example.esameengim.model.Articolo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ArticoloRepository {

    static final String DB_URL = "jdbc:mysql://localhost:3306/esame_engim";
    static final String USER = "esame";
    static final String PASS = "esame";

    public static List<Articolo> getArticoli(){
        // creo una lista da restituire
        List<Articolo> articoli = new ArrayList<>();
        try{
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            PreparedStatement stmt = conn.prepareStatement("select * from articoli");
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){

                // creo una fermata con i dati del DB
                Articolo articolo = new Articolo(
                        rs.getInt("Id"),
                        rs.getString("Codice"),
                        rs.getString("Descrizione"),
                        rs.getFloat("Peso")
                );
                // aggiungo alla lista
                articoli.add(articolo);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        //restituisco la lista
        return articoli;
    }

}
