package DAO;

import static DAO.DAO_Games.tc;
import Entidad.Games;
import Entidad.Partners;
import static Metodos.metodos.isLetra;
import static Metodos.metodos.isNum;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author AlumMati
 */
public class DAO_Partners {


    /*
    public void prestar(Connection con) throws Exception {
        Statement stmt = null;
        PreparedStatement stmt2 = null;
        ResultSet rs = null;

        try {

            System.out.println("\n*****New Prestamo*****");
            String aux;
            int alquiler_day, alquiler_month, alquiler_year;
            int entrega_day, entrega_month, entrega_year;
            boolean val = false, moroso = false;

            System.out.print("Nombre: ");
            String nombre = tc.readLine();
            isLetra(nombre);

            ArrayList<Games> juegos = new ArrayList();
            rs = stmt.executeQuery("SELECT * FROM juegos");
            while (rs.next()) {
                String codigo = rs.getString("codigo");
                String titulo = rs.getString("titulo");
                String descripcion = rs.getString("descripcion");
                int cantidad = rs.getInt("cantidad");
                juegos.add(new Games(codigo, titulo, descripcion, cantidad));
            }

            System.out.print("Juego: ");
            String juego = tc.readLine();

            while (!val) {
                for (int i = 0; i < juegos.size(); i++) {
                    if (juegos.get(i).getCodigo().equalsIgnoreCase(juego) && juegos.get(i).getCantidad() < 0) {
                        System.out.print("Error, introduce un juego que no este prestado: ");
                        juego = tc.readLine();
                    } else {
                        val = true;
                    }
                }
            }

            do {
                System.out.print("Alquiler Day: ");
                aux = tc.readLine();

                while (isNum(aux) == false) {
                    System.out.print("Error, enter numbers: ");
                    aux = tc.readLine();
                }
                alquiler_day = Integer.parseInt(aux);
                if (alquiler_day < 1 || alquiler_day > 31) {
                    System.out.print("That day is not valid: ");
                    alquiler_day = Integer.parseInt(tc.readLine());
                } else {
                    val = true;
                }
            } while (!val);

            do {
                System.out.print("Alquiler Month: ");
                aux = tc.readLine();

                while (isNum(aux) == false) {
                    System.out.print("Error, enter numbers: ");
                    aux = tc.readLine();
                }
                alquiler_month = Integer.parseInt(aux);
                if (alquiler_month < 1 || alquiler_month > 12) {
                    System.out.println("That month is not valid: ");
                    alquiler_month = Integer.parseInt(tc.readLine());
                } else {
                    val = true;
                }
            } while (!val);

            do {
                System.out.print("Alquiler Year: ");
                aux = tc.readLine();

                while (isNum(aux) == false) {
                    System.out.print("Error, enter numbers: ");
                    aux = tc.readLine();
                }
                alquiler_year = Integer.parseInt(aux);
                if (alquiler_year < 1900) {
                    System.out.println("That year is not valid: ");
                    alquiler_year = Integer.parseInt(tc.readLine());
                } else {
                    val = true;
                }
            } while (!val);

            alquiler_month--;
            alquiler_year -= 1900;

            Date alquiler = new Date(alquiler_year, alquiler_month, alquiler_day);

            do {
                System.out.print("Entrega Day: ");
                aux = tc.readLine();

                while (isNum(aux) == false) {
                    System.out.print("Error, enter numbers: ");
                    aux = tc.readLine();
                }
                entrega_day = Integer.parseInt(aux);
                if (entrega_day < 1 || entrega_day > 31) {
                    System.out.print("That day is not valid: ");
                    entrega_day = Integer.parseInt(tc.readLine());
                } else {
                    val = true;
                }
            } while (!val);

            do {
                System.out.print("Entrega Month: ");
                aux = tc.readLine();

                while (isNum(aux) == false) {
                    System.out.print("Error, enter numbers: ");
                    aux = tc.readLine();
                }
                entrega_month = Integer.parseInt(aux);
                if (entrega_month < 1 || entrega_month > 12) {
                    System.out.println("That month is not valid: ");
                    entrega_month = Integer.parseInt(tc.readLine());
                } else {
                    val = true;
                }
            } while (!val);

            do {
                System.out.print("Entrega Year: ");
                aux = tc.readLine();

                while (isNum(aux) == false) {
                    System.out.print("Error, enter numbers: ");
                    aux = tc.readLine();
                }
                entrega_year = Integer.parseInt(aux);
                if (entrega_year < 1900) {
                    System.out.println("That year is not valid: ");
                    entrega_year = Integer.parseInt(tc.readLine());
                } else {
                    val = true;
                }
            } while (!val);

            entrega_month--;
            entrega_year -= 1900;

            Date entrega = new Date(entrega_year, entrega_month, entrega_day);

            Partners s = new Partners(nombre, juego, alquiler, entrega, moroso);

            stmt2 = con.prepareStatement("INSERT INTO prestamos (nombre, juego, alquiler, entrega, moroso) VALUES (?,?,?,?)");
            stmt2.setString(1, s.getNombre());
            stmt2.setString(2, s.getJuego());
            stmt2.setDate(3, s.getAlquiler());
            stmt2.setDate(4, s.getEntrega());
            stmt2.setBoolean(5, s.isMoroso());
            stmt2.executeUpdate();
            System.out.println("\nPrestamo guardado");

        } catch (SQLException e) {
            System.out.println("Error adding prestamo: " + e.getMessage());
        } finally {
            if (!stmt2.isClosed()) {
                stmt2.close();
            }
        }
    }
    */

    public void show(Connection conexion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void add(Connection conexion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void update(Connection conexion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void search(Connection conexion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void delete(Connection conexion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void consultar_defaulters(Connection conexion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
