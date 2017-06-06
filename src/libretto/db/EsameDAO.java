package libretto.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import it.polito.tdp.libretto.model.Esame;

public class EsameDAO {
	
		public Esame find(String codice){
			
			String sql =
						"SELECT codice, titolo, docente, superato, voto, data_superamento "+
						"FROM esame "+
						"WHERE codice=?";	
			String jdbcURL = "jdbc:mysql://localhost/libretto?user=root";
			Esame result = null;
			try {
				Connection conn= DriverManager.getConnection(jdbcURL);
				
				PreparedStatement st = conn.prepareStatement(sql);
				
				st.setString(1, codice);
				ResultSet res = st.executeQuery();
				if(res.next()){
					Esame ex = new Esame(res.getString("codice"), res.getString("titolo"), res.getString("docente"));
					result = ex;
				}
				else {
					result = null;
				}
				conn.close();
				return result;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
		}
}
