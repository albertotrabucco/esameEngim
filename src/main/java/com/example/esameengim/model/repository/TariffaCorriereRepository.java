package com.example.esameengim.model.repository;

import com.example.esameengim.model.TariffaCorriere;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TariffaCorriereRepository {

    static final String DB_URL = "jdbc:mysql://localhost:3306/esame_engim";
    static final String USER = "esame";
    static final String PASS = "esame";

    public static List<TariffaCorriere> getTariffeCorrieri(){
        // creo una lista da restituire
        List<TariffaCorriere> tariffeCorrieri = new ArrayList<>();
        try{
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            PreparedStatement stmt = conn.prepareStatement("select * from tariffe_corrieri");
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){

                // creo una fermata con i dati del DB
                TariffaCorriere tariffaCorriere = new TariffaCorriere(
                        rs.getInt("Id"),
                        rs.getString("nome_corriere"),
                        rs.getString("nome_tariffa"),
                        rs.getFloat("peso_massimo"),
                        rs.getFloat("costo")
                );
                // aggiungo alla lista
                tariffeCorrieri.add(tariffaCorriere);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        //restituisco la lista
        return tariffeCorrieri;
    }
}
