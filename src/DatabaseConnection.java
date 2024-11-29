import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/MasterParking";
    private static final String USER = "root";
    private static final String PASSWORD = "25012006Pmf?";

    //conexão com o BD
    public static Connection getConnection(){
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch(SQLException e){
            e.printStackTrace();
            throw new RuntimeException("Erro ao Conectar com o banco de dados");
        }
    }

    //fechar conexão
    public static void closeConnection(Connection conn){
        if (conn != null){
            try{
                conn.close();
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
    }

    //Fechar preparedStatement
    public static void closeStatement(PreparedStatement stmt){
        if(stmt != null){
            try{
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void closeResultSet(ResultSet rs){
        if(rs != null){
            try{
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
