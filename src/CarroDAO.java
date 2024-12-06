import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CarroDAO extends GenericDAO <Carro>{

    @Override
    protected String getInsertQuery() {
        return "INSERT INTO carro (placa, modelo, id_cliente) VALUES (?, ? ,?)";
    }

    @Override
    protected String getUpdateQuery() {
        return "UPDATE carro SET placa = ?, modelo = ?, WHERE id_carro = ?";
    }

    @Override
    protected String getDeleteQuery() {
        return "DELETE FROM carro WHERE placa = ?";
    }

    @Override
    protected String getSelectQuery() {
        return "SELECT * FROM carro WHERE placa = ?";
    }

    @Override
    protected void setParameters(PreparedStatement stmt, Carro carro) throws SQLException {
        stmt.setString(1, carro.getPlaca());
        stmt.setString(2, carro.getModelo());
        stmt.setInt(3, carro.getIdCliente());
    }

    @Override
    protected Carro getEntityFromResult(ResultSet rs) throws SQLException {
        Carro carro = new Carro(
                rs.getString("placa"),
                rs.getString("modelo"),
                rs.getInt("id_cliente")
        );
        carro.setId(rs.getInt("id_carro"));
        return carro;
    }

    @Override
    public void atualizar(Carro carro) {
        String sql = getUpdateQuery();
        Connection conn = null;
        PreparedStatement stmt = null;

        try{
            conn = DatabaseConnection.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, carro.getPlaca());
            stmt.setString(2, carro.getModelo());
            stmt.setInt(3, carro.getId());
            stmt.executeUpdate();
            System.out.println("Carro atualizado");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeStatement(stmt);
            DatabaseConnection.closeConnection(conn);
        }
    }

    public void listarCarros(){
        String sql = "SELECT * FROM carro";
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try{
            conn = DatabaseConnection.getConnection();
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            while(rs.next()){
                int idCarro = rs.getInt("id_carro");
                String placa = rs.getString("placa");
                String modelo = rs.getString("modelo");
                int idCliente = rs.getInt("id_cliente");

                System.out.println("ID: "+ idCarro +" | Modelo: "+ modelo +" | Placa: "+ placa +" | ID Cliente: "+ idCliente);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeResultSet(rs);
            DatabaseConnection.closeStatement(stmt);
            DatabaseConnection.closeConnection(conn);
        }
    }

    @Override
    public void deletar(String placa){
        String sql = getDeleteQuery();
        Connection conn = null;
        PreparedStatement stmt = null;

        try{
            conn = DatabaseConnection.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, placa);
            stmt.executeUpdate();
            System.out.println("Carro deletado");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeStatement(stmt);
            DatabaseConnection.closeConnection(conn);
        }
    }

    public Carro buscarPorPlaca(String placa){
        String sql = getSelectQuery();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Carro carro = null;

        try{
            conn = DatabaseConnection.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, placa);
            rs = stmt.executeQuery();

            if(rs.next()){
                carro = getEntityFromResult(rs);
                System.out.println("Carro encontrado: "+ carro.getModelo() +"| Placa: "+ carro.getPlaca() +
                                   "| id do Cliente"+ carro.getIdCliente());
            }
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeResultSet(rs);
            DatabaseConnection.closeStatement(stmt);
            DatabaseConnection.closeConnection(conn);
        }

        return carro;
    }
}
