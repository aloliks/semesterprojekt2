/*
 * Denne klasse skal kunne følgende:
 * - oprette forbindelse til databasen
 * - skrive målinger til databasen
 * - returnere målinger fra databasen
 */

import java.sql.*;

public class Database {

    Connection conn = null;
    Statement stmt = null;

    //Opretter forbindelse til databasen
    public void initConn() {
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:EKG.sqlite");
            System.out.println("Der er oprettet forbindelse til database");

            initTable("Undersøgelse");
            initTable("Målinger");

        } catch (Exception e) {
            System.out.println("Database-test: " + e.getMessage());              // udskriv fejlmeddelelse
            e.printStackTrace();                                                // udskriv stacktrace

        }

    }

    //Tjekker om tabel allerede eksisterer - hvis ikke oprettes tabellen
    public void initTable(String name) {
        try {

            DatabaseMetaData dbm = conn.getMetaData();

            // Tjek om tabellen allerede eksisterer
            ResultSet tables = dbm.getTables(null, null, name, null);
            if (tables.next()) {
                // Hvis tabellen allerede eksisterer, kald metoden writeTo
                System.out.println("Tabellen eksisterer allerede");
                writeTo();
                
                //Hvis tabellen ikke eksisterer, opret den og kald derefter metoden writeTo
            } else {

                System.out.println("Opretter tabel " + name);
                stmt = conn.createStatement();
                String tabelnavn = "CREATE TABLE " + name;
                if (name == "Undersøgelse") {
                    stmt.executeUpdate(tabelnavn + "(id INT NOT NULL PRIMARY KEY)");
                    System.out.println("Opretter tabel med navnet undersøgelse");
                } else {
                    stmt.executeUpdate(tabelnavn + "(id INT NOT NULL PRIMARY KEY, værdi INT NOT NULL)");
                    System.out.println("Opretter anden tabel");
                }
                writeTo();
            }

        } catch (Exception e) {
             System.out.println("Tabel-test: " + e.getMessage());                              // udskriv fejlmeddelelse
            e.printStackTrace();

        }
    }

    //Skriv til tabellen
    public void writeTo() {
        try {

        } catch (Exception e) {

        }
    }

    //Hent data fra tabel
    public void getData() {
        try {

        } catch (Exception e) {

        }
    }

    //Test af database
    public static void main(String[] args) {
        // TODO code application logic here
        Database test = new Database();
        test.initConn();
        System.exit(0);
    }

}
