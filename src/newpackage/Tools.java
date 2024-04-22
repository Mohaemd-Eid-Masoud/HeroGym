package newpackage;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *C:\Users\WIN(10)X64\Desktop
 * @author zdros
 */
public class Tools {
    private static String dataBaseURL = "jdbc:ucanaccess://C:\\Users\\WIN(10)X64\\Desktop\\HeroGymLastEdition\\src\\newpackage\\New_Microsoft_Access_Database.accdb";
    public static Connection dbConnection(){
        Connection dbConncetion = null;
		try {
			dbConncetion = DriverManager.getConnection(dataBaseURL);
			//System.out.print("Connected");
		} catch (SQLException e) {
			e.printStackTrace();
		}
                return dbConncetion;
    }
}
