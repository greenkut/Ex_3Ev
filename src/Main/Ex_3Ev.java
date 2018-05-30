package Main;

import DAO.Conexion_DAO;
import DAO.DAO_Games;
import DAO.DAO_Loans;
import DAO.DAO_Partners;
import Entidad.Games;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 *
 * @author AlumMati
 */
public class Ex_3Ev {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        new Ex_3Ev();
    }

    Conexion_DAO con = new Conexion_DAO();

    static BufferedReader tc = new BufferedReader(new InputStreamReader(System.in));
    
    static ArrayList<Games> juegos = new ArrayList<>();

    public void recover() {
        try {
            FileReader entrada = new FileReader("C:\\Users\\Javier\\Documents\\NetBeansProjects\\EX_JCutillas\\juegos.txt");
            BufferedReader buffer = new BufferedReader(entrada);

            String linea = buffer.readLine();

            while (linea != null) {
                StringTokenizer token = new StringTokenizer(linea, "\t-");
                String codigo = token.nextToken();
                String titulo = token.nextToken();
                String descripcion = token.nextToken();

                juegos.add(new Games(codigo, titulo, descripcion));
                linea = buffer.readLine();
            }
            for (int i = 0; i < juegos.size(); i++) {
                System.out.println(juegos.get(i).readFile());
            }
            buffer.close();

        } catch (FileNotFoundException e) { // qué hacer si no se encuentra el fichero
            System.out.println("No se encuentra el fichero");
        } catch (IOException e) { // qué hacer si hay un error en la lectura del fichero
            System.out.println("No se puede leer el fichero ");
        }
    }

    public Ex_3Ev() throws IOException, Exception {
        con.connect_BDD();
        //dao_j.juegos_fillDatabase(con.conexion, juegos);
        start();
    }

    public void start() throws IOException, Exception {
        int opc;
        do {
            System.out.print("\n*** MENU ***\n"
                    + "1.Games\n"
                    + "2.Partners\n"
                    + "3.Loans\n"
                    + "4.Exit\n"
                    + "Choose an option: ");
            opc = Integer.parseInt(tc.readLine());

            while (opc < 1 || opc > 4) {
                System.out.print("Option not valid, enter again: ");
                opc = Integer.parseInt(tc.readLine());
            }
            menu(opc);
        } while (opc != 4);
    }

    public void menu(int opc) throws Exception {
        switch (opc) {
            case 1: // GAMES
                games();
                break;
            case 2: // PARTNERS
                partners();
                break;
            case 3: // LOANS
                loans();
                break;
            case 4: // EXIT
                System.out.println("Bye Bye");
                break;
        }
    }

    DAO_Games dao_G = new DAO_Games();
    DAO_Partners dao_P = new DAO_Partners();
    DAO_Loans dao_L = new DAO_Loans();
    
    
    
    public void games() throws IOException, Exception {
        int opc;
        do {
            System.out.print("\n*** GAMES ***\n"
                    + "1.Show\n"
                    + "2.Add\n"
                    + "3.Update\n"
                    + "4.Search\n"
                    + "5.Delete\n"
                    + "6.Back to menu\n"
                    + "Choose an option: ");
            opc = Integer.parseInt(tc.readLine());
            
            while (opc < 1 || opc > 6) {
                System.out.print("Option not valid, enter again: ");
                opc = Integer.parseInt(tc.readLine());
            }
            menu_games(opc);
        } while (opc != 6);
    }
    
    public void partners() throws IOException, Exception {
        int opc;
        do {
            System.out.print("\n*** PARTNERS ***\n"
                    + "1.Show\n"
                    + "2.Add\n"
                    + "3.Update\n"
                    + "4.Search\n"
                    + "5.Delete\n"
                    + "6.Consult defaulters\n"
                    + "7.Back to menu\n"
                    + "Choose an option: ");
            opc = Integer.parseInt(tc.readLine());
            
            while (opc < 1 || opc > 7) {
                System.out.print("Option not valid, enter again: ");
                opc = Integer.parseInt(tc.readLine());
            }
            menu_partners(opc);
        } while (opc != 7);
    }
    
    public void loans() throws IOException, Exception {
        int opc;
        do {
            System.out.print("\n*** LOANS ***\n"
                    + "1.Show\n"
                    + "2.Add\n"
                    + "3.Update\n"
                    + "4.Search\n"
                    + "5.Delete\n"
                    + "6.Back to menu\n"
                    + "Choose an option: ");
            opc = Integer.parseInt(tc.readLine());
            
            while (opc < 1 || opc > 6) {
                System.out.print("Option not valid, enter again: ");
                opc = Integer.parseInt(tc.readLine());
            }
            menu_loans(opc);
        } while (opc != 6);
    }
    
    public void menu_games(int opc) throws Exception {
        switch (opc) {
            case 1: // SHOW
                dao_G.show(con.conexion);
                break;
            case 2: // ADD
                dao_G.add(con.conexion);
                break;
            case 3: // UPDATE
                dao_G.update(con.conexion);
                break;
            case 4: // SEARCH
                dao_G.search(con.conexion);
                break;
            case 5: // DELETE
                dao_G.delete(con.conexion);
                break;
            case 6: // BACK TO MENU
                break;
        }
    }
    
    public void menu_partners(int opc) throws Exception {
        switch (opc) {
            case 1: // SHOW
                dao_P.show(con.conexion);
                break;
            case 2: // ADD
                dao_P.add(con.conexion);
                break;
            case 3: // UPDATE
                dao_P.update(con.conexion);
                break;
            case 4: // SEARCH
                dao_P.search(con.conexion);
                break;
            case 5: // DELETE
                dao_P.delete(con.conexion);
                break;
            case 6: // CONSULT DEFAULTERS
                dao_P.consultar_defaulters(con.conexion);
                break;
            case 7: // BACK TO MENU
                break;
        }
    }
    
    public void menu_loans(int opc) throws Exception {
        switch (opc) {
            case 1: // SHOW
                dao_L.show(con.conexion);
                break;
            case 2: // ADD
                dao_L.add(con.conexion);
                break;
            case 3: // UPDATE
                dao_L.update(con.conexion);
                break;
            case 4: // SEARCH
                dao_L.search(con.conexion);
                break;
            case 5: // DELETE
               dao_L.delete(con.conexion);
                break;
            case 6: // BACK TO MENU
                break;
        }
    }
}
