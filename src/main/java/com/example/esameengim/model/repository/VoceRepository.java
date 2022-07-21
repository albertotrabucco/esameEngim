package com.example.esameengim.model.repository;

import com.example.esameengim.model.Voce;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VoceRepository {
    static final String DB_URL = "jdbc:mysql://localhost:3306/esame_engim";
    static final String USER = "esame";
    static final String PASS = "esame";

    public static List<Voce> getVoci(){
        // creo una lista da restituire
        List<Voce> voci = new ArrayList<>();
        try{
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            PreparedStatement stmt = conn.prepareStatement("select * from voci");
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){

                // creo una fermata con i dati del DB
                Voce voce = new Voce(
                        rs.getInt("Id_ordine"),
                        rs.getInt("articolo"),
                        rs.getInt("quantità")
                );
                // aggiungo alla lista
                voci.add(voce);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        //restituisco la lista
        return voci;
    }
}
