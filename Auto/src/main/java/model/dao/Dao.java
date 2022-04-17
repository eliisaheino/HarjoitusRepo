package model.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.MalliAuto;

public class Dao {
	private Connection con=null;
	private ResultSet rs = null;
	private PreparedStatement stmtPrep=null; 
	private String sql;
	private String db ="Autot.sqlite";
	
	private Connection yhdista(){
    	Connection con = null;    	
    	String path = System.getProperty("catalina.base");    	
    	path = path.substring(0, path.indexOf(".metadata")).replace("\\", "/"); //Eclipsessa
    	//path += "/webapps/"; //Tuotannossa. Laita tietokanta webapps-kansioon
    	String url = "jdbc:sqlite:"+path+db;    	
    	try {	       
    		Class.forName("org.sqlite.JDBC");
	        con = DriverManager.getConnection(url);	
	        System.out.println("Yhteys avattu.");
	     }catch (Exception e){	
	    	 System.out.println("Yhteyden avaus epäonnistui.");
	        e.printStackTrace();	         
	     }
	     return con;
	}
	
	public ArrayList<MalliAuto> listaaKaikki(){
		ArrayList<MalliAuto> autot = new ArrayList<MalliAuto>();
		sql = "SELECT * FROM autot";       
		try {
			con=yhdista();
			if(con!=null){ //jos yhteys onnistui
				stmtPrep = con.prepareStatement(sql);        		
        		rs = stmtPrep.executeQuery();   
				if(rs!=null){ //jos kysely onnistui
					//con.close();	
					//Jos tietoa löytyi tehdään ensin auto-olio
					//Annetaan sille arvot
					//Työnnetään luotu Auto add-metodilla arraylistiin
					while(rs.next()){
						MalliAuto auto = new MalliAuto();
						auto.setRekno(rs.getString(1)); //Hae taulun ensimmäisestä sarakkeesta arvo ja aseta se reknro paikalle
						auto.setMerkki(rs.getString(2)); //Hae taulun toisesta sarakkeesta arvo ja aseta se merkin paikalle
						auto.setMalli(rs.getString(3));	 //Hae taulun kolmannesta sarakkeesta arvo ja aseta se mallin paikalle
						auto.setVuosi(rs.getInt(4));	//Hae taulun neljännestä sarakkeesta arvo ja aseta se vuoden paikalle
						autot.add(auto);
					}					
				}				
			}	
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return autot;
	}
}
