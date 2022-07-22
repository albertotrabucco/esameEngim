package com.example.esameengim.model.repository;

import com.example.esameengim.model.TariffaCorriere;
import com.mysql.cj.protocol.Resultset;

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

    public static void deleteTariffa(int id){
        try{
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            PreparedStatement stmt = conn.prepareStatement("delete from tariffe_corrieri where Id=?");
            stmt.setInt(1,id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static TariffaCorriere addTariffa(TariffaCorriere tariffa){
        try {
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO tariffe_corrieri (Id,nome_corriere, nome_tariffa, peso_massimo, costo) VALUE (NULL,?,?,?,?)");
            stmt.setString(1, tariffa.getNome_corriere());
            stmt.setString(2, tariffa.getNome_tariffa());
            stmt.setFloat(3, tariffa.getPeso_massimo());
            stmt.setFloat(4, tariffa.getCosto());
            stmt.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return tariffa;
    }



}
