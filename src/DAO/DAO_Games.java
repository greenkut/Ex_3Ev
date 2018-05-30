package DAO;

import Entidad.Games;
import static Metodos.metodos.isLetra;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author AlumMati
 */
public class DAO_Games {

    static BufferedReader tc = new BufferedReader(new InputStreamReader(System.in));

    public void show(Connection con) throws Exception {
        Statement st = null;
        ResultSet rs = null;
        try {
            st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM juegos");

            System.out.println("\n*****JUEGOS*****");

            while (rs.next()) {
                String codigo = rs.getString("codigo");
                String titulo = rs.getString("titulo");
                String descripcion = rs.getString("descripcion");
                int cantidad = rs.getInt("cantidad");

                Games g = new Games(codigo, titulo, descripcion, cantidad);
                System.out.println(g.toString());
                System.out.println("*********************");
            }

        } catch (SQLException e) {
            System.out.println("Error showing games: " + e.getMessage());
        } finally {
            if (!rs.isClosed() || !st.isClosed()) {
                rs.close();
                st.close();
            }
        }
    }

    public void add(Connection con) throws Exception {
        PreparedStatement stmt = null;
        PreparedStatement stmt2 = null;
        ResultSet rs = null;

        try {

            System.out.println("\n*****New Game*****");
            String aux;
            boolean val = false;

            System.out.print("\nCodigo: ");
            String codigo = tc.readLine();

            stmt = con.prepareStatement("SELECT codigo FROM juegos");
            rs = stmt.executeQuery();

            ArrayList<String> num = new ArrayList();
            while (rs.next()) {
                String ID = rs.getString("codigo");
                num.add(ID);
            }
            rs.close();
            stmt.close();

            while (!val) {
                for (int i = 0; i < num.size(); i++) {
                    if (num.get(i).equalsIgnoreCase(codigo)) {
                        System.out.print("Error: ");
                        codigo = tc.readLine();
                    } else {
                        val = true;
                    }
                }
            }

            System.out.print("Titulo: ");
            String titulo = tc.readLine();
            isLetra(titulo);

            System.out.print("Descripcion: ");
            String descripcion = tc.readLine();

            int cantidad = 1;

            System.out.println("\nJuego guardado");

            Games g = new Games(codigo, titulo, descripcion, cantidad);

            stmt2 = con.prepareStatement("INSERT INTO juegos (codigo, titulo, descripcion, cantidad) VALUES (?,?,?,?)");
            stmt2.setString(1, g.getCodigo());
            stmt2.setString(2, g.getTitulo());
            stmt2.setString(3, g.getDescripcion());
            stmt2.setInt(4, g.getCantidad());
            stmt2.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error adding game: " + e.getMessage());
        } finally {
            if (!stmt2.isClosed()) {
                stmt2.close();
            }
        }
    }

    public void update(Connection con) throws Exception {
        PreparedStatement stmt = null;
        PreparedStatement stmt2 = null;
        ResultSet rs = null;
        try {

            System.out.println("\n*****Update Juego*****");
            String aux;
            boolean val = false;

            stmt = con.prepareStatement("SELECT codigo FROM juegos");
            rs = stmt.executeQuery();

            ArrayList<String> num = new ArrayList();
            while (rs.next()) {
                String ID = rs.getString("codigo");
                num.add(ID);
            }
            rs.close();
            stmt.close();

            System.out.print("\nEnter the game ID you want to update: ");
            String codigo = tc.readLine();

            while (!val) {
                for (int i = 0; i < num.size(); i++) {
                    if (num.get(i).equalsIgnoreCase(codigo)) {
                        val = true;
                    } else {
                        System.out.print("Error: ");
                        codigo = tc.readLine();
                    }
                }
            }

            System.out.print("New Titulo: ");
            String titulo = tc.readLine();
            isLetra(titulo);

            System.out.print("New Descripcion: ");
            String descripcion = tc.readLine();

            System.out.print("Cantidad: (0-1)");
            int cantidad = Integer.parseInt(tc.readLine());
            
            while (cantidad < 0 || cantidad > 1){
                System.out.println("Cantidad no valida: ");
                cantidad = Integer.parseInt(tc.readLine());
            }

            System.out.println("\nGame udapted");

            stmt2 = con.prepareStatement("UPDATE juegos SET Titulo = ?, Descripcion = ?, Cantidad = ? where codigo =" + codigo);
            stmt2.setString(1, titulo);
            stmt2.setString(2, descripcion);
            stmt2.setInt(3, cantidad);
            stmt2.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error updating game: " + e.getMessage());
        } finally {
            if (!stmt2.isClosed()) {
                stmt2.close();
            }
        }
    }

    public void search(Connection con) throws Exception {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {

            System.out.println("\n*****Search Game*****");

            System.out.print("\nEnter the game ID you want to search: ");
            String id = tc.readLine();

            stmt = con.prepareStatement("SELECT * FROM juegos WHERE codigo =" + id);
            rs = stmt.executeQuery();

            System.out.println("\nGame found: ");

            while (rs.next()) {
                String codigo = rs.getString("codigo");
                String titulo = rs.getString("titulo");
                String descripcion = rs.getString("descripcion");
                int cantidad = rs.getInt("cantidad");

                Games g = new Games(codigo, titulo, descripcion, cantidad);
                System.out.println(g.toString());
                System.out.println("*********************");
            }

        } catch (SQLException e) {
            System.out.println("Error searching game: " + e.getMessage());
        } finally {
            if (!rs.isClosed() || !stmt.isClosed()) {
                rs.close();
                stmt.close();
            }
        }
    }

    public void delete(Connection con) throws Exception {
        PreparedStatement stmt = null;
        try {

            System.out.println("\n*****Delete Game*****");

            System.out.print("\nEnter the game ID you want to delete: ");
            String codigo = tc.readLine();

            System.out.println("\nGame deleted");

            stmt = con.prepareStatement("DELETE FROM juegos WHERE codigo =" + codigo);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error deleting game: " + e.getMessage());
        } finally {
            if (!stmt.isClosed()) {
                stmt.close();
            }
        }
    }

    public void juegos_fillDatabase(Connection con, ArrayList<Games> juegos) throws Exception {
        PreparedStatement stmt = null;
        
        try {
            for (Games g : juegos) {
                stmt = con.prepareStatement("INSERT INTO juegos (codigo, titulo, descripcion, cantidad) VALUES (?,?,?,1)");
                stmt.setString(1, g.getCodigo());
                stmt.setString(2, g.getTitulo());
                stmt.setString(3, g.getDescripcion());
                stmt.executeUpdate();
            }
        } catch (SQLException e) {
            System.out.println("Error filling Database: " + e.getMessage());
        } finally {
            if (!stmt.isClosed()) {
                stmt.close();
            }
        }
    }
}
