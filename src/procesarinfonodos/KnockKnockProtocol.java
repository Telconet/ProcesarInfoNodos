/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package procesarinfonodos;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.StringTokenizer;

/**
 *
 * @author DMedina
 */
public class KnockKnockProtocol {

    public String processInput(String theInput) {

        Connection miConexion;
        miConexion = ConexionDB.GetConnection();
        Statement st;

        StringTokenizer campos = new StringTokenizer(theInput, ",");

        String sql;
        if (campos.countTokens() == 21) {
            sql = "INSERT INTO Mediciones (id_nodo,fecha,hora,corrienteDC_1,temperatura_1,"
                    + "corrienteAC_3,voltajeDC_2,corrienteDC_2,temperatura_2,corrienteAC_4,"
                    + "voltajeDC_3,corrienteDC_3,temperatura_3,voltajeDC_4,corrienteDC_4,voltajeAC_1,"
                    + "humedad,corrienteAC_1,voltajeAC_2,corrienteAC_2,voltajeDC_1) "
                    + "VALUES (" + campos.nextToken() + ",'" + campos.nextToken() + "','" + campos.nextToken() + "'," + campos.nextToken() + "," + campos.nextToken() + ","
                    + "" + campos.nextToken() + "," + campos.nextToken() + "," + campos.nextToken() + "," + campos.nextToken() + "," + campos.nextToken() + ","
                    + "" + campos.nextToken() + "," + campos.nextToken() + "," + campos.nextToken() + "," + campos.nextToken() + "," + campos.nextToken() + "," + campos.nextToken() + ","
                    + "" + campos.nextToken() + "," + campos.nextToken() + "," + campos.nextToken() + "," + campos.nextToken() + "," + campos.nextToken() + " )";
            try {
                st = miConexion.createStatement();
                st.executeUpdate(sql);
                miConexion.close();
                return ("OK");
            } catch (SQLException ex) {
                return ("Error: " + ex.toString());
            }
        } else if (campos.countTokens() == 23) {
            sql = "INSERT INTO Mediciones (id_nodo,fecha,hora,corrienteDC_1,temperatura_1,"
                    + "corrienteAC_3,voltajeDC_2,corrienteDC_2,temperatura_2,corrienteAC_4,"
                    + "voltajeDC_3,corrienteDC_3,temperatura_3,voltajeDC_4,corrienteDC_4,voltajeAC_1,"
                    + "humedad,corrienteAC_1,voltajeAC_2,corrienteAC_2,voltajeDC_1,aire_principal,aire_backup) "
                    + "VALUES (" + campos.nextToken() + ",'" + campos.nextToken() + "','" + campos.nextToken() + "'," + campos.nextToken() + "," + campos.nextToken() + ","
                    + campos.nextToken() + "," + campos.nextToken() + "," + campos.nextToken() + "," + campos.nextToken() + "," + campos.nextToken() + ","
                    + campos.nextToken() + "," + campos.nextToken() + "," + campos.nextToken() + "," + campos.nextToken() + "," + campos.nextToken() + "," + campos.nextToken() + ","
                    + campos.nextToken() + "," + campos.nextToken() + "," + campos.nextToken() + "," + campos.nextToken() + "," + campos.nextToken() + ","
                    + campos.nextToken() + "," + campos.nextToken() + " )";
            try {
                st = miConexion.createStatement();
                st.executeUpdate(sql);
                miConexion.close();
                return ("OK");
            } catch (SQLException ex) {
                return ("Error: " + ex.toString());
            }
        } 
        else if (campos.countTokens() == 4) {
            sql = "INSERT INTO Eventos (id_nodo,fecha,hora,evento) "
                    + "VALUES (" + campos.nextToken() + ",'" + campos.nextToken() + "','" + campos.nextToken() + "', '" + campos.nextToken() + "' )";
            try {
                st = miConexion.createStatement();
                st.executeUpdate(sql);
                miConexion.close();
                return ("OK");
            } catch (SQLException ex) {
                return ("Error: " + ex.toString());
            }
        }         
        else {
            return ("FALLO con " + theInput);
        }

    }
}
