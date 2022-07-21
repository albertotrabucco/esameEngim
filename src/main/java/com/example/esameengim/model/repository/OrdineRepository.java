package com.example.esameengim.model.repository;
import com.example.esameengim.model.Ordine;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrdineRepository {
    static final String DB_URL = "jdbc:mysql://localhost:3306/esame_engim";
    static final String USER = "esame";
    static final String PASS = "esame";

    public static List<Ordine> getOrdini(){
        // creo una lista da restituire
        List<Ordine> ordini = new ArrayList<>();
        try{
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            PreparedStatement stmt = conn.prepareStatement("select * from ordini");
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){

                // creo una fermata con i dati del DB
                Ordine ordine = new Ordine(
                        rs.getInt("Id"),
                        rs.getInt("Numero"),
                        rs.getDate("Data")
                        );
                // aggiungo alla lista
                ordini.add(ordine);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        //restituisco la lista
        return ordini;
    }
}
