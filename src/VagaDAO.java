import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class VagaDAO extends GenericDAO<Vaga>{

    @Override
    protected String getInsertQuery() {
        return "INSERT INTO vaga (estado, placaCarro) VALUES (?, ?)";
    }

    @Override
    protected String getUpdateQuery() {
        return "UPDATE vaga SET estado = ?, placaCarro = ? WHERE numero = ?";
    }

    @Override
    protected String getDeleteQuery() {
        return "DELETE FROM vaga WHERE numero = ?";
    }

    @Override
    protected String getSelectQuery() {
        return "SELECT * FROM vaga WHERE numero = ?";
    }

    @Override
    protected void setParameters(PreparedStatement stmt, Vaga vaga) throws SQLException {
        stmt.setBoolean(1, vaga.getEstado());
        stmt.setString(2, vaga.getPlacaCarro());
    }

    @Override
    protected Vaga getEntityFromResult(ResultSet rs) throws SQLException {
        Vaga vaga = new Vaga(
          rs.getBoolean("estado"),
          rs.getString("placaCarro")
        );
        vaga.setNumVaga(rs.getInt("numero"));

        return vaga;
    }

    public void deletar(int numero) {
        String sql = getDeleteQuery();
        Connection conn = null;
        PreparedStatement stmt = null;

        try{
            conn = DatabaseConnection.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, numero);
            stmt.executeUpdate();
            System.out.println("Vaga "+ numero +" deletada");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeStatement(stmt);
            DatabaseConnection.closeConnection(conn);
        }
    }

    @Override
    public void atualizar(Vaga vaga) {
        String sql = getUpdateQuery();
        Connection conn = null;
        PreparedStatement stmt = null;

        try{
            conn = DatabaseConnection.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setBoolean(1, vaga.getEstado());
            stmt.setString(2, vaga.getPlacaCarro());
            stmt.setInt(3, vaga.getNumVaga());
            stmt.executeUpdate();
            System.out.println("Vaga "+ vaga.getNumVaga() +" Atualizada");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeStatement(stmt);
            DatabaseConnection.closeConnection(conn);
        }
    }

    public void listarVagas(){
        String sql = "SELECT * FROM vaga";
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try{
            conn = DatabaseConnection.getConnection();
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            while(rs.next()){
                boolean estado = rs.getBoolean("estado");
                int numVaga = rs.getInt("numero");
                String placaCarro = rs.getString("placaCarro");

                if(estado == true){
                    System.out.println("Vaga: "+ numVaga +" | Ocupada por: "+placaCarro);
                } else {
                    System.out.println("Vaga: "+ numVaga +" | Desocupada");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeResultSet(rs);
            DatabaseConnection.closeStatement(stmt);
            DatabaseConnection.closeConnection(conn);
        }
    }

    public Vaga buscarPorNumVaga(int numVaga){
        String sql = getSelectQuery();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Vaga vaga = null;

        try{
            conn = DatabaseConnection.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, numVaga);
            rs = stmt.executeQuery();

            if(rs.next()){
                vaga = getEntityFromResult(rs);

                if(vaga.getEstado() == true){
                    System.out.println("Vaga: "+ vaga.getNumVaga() +"| Ocupada Placa do carro: "+ vaga.getPlacaCarro());
                } else {
                    System.out.println("Vaga: "+ vaga.getNumVaga() +"| Desocupada");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeResultSet(rs);
            DatabaseConnection.closeStatement(stmt);
            DatabaseConnection.closeConnection(conn);
        }

        return vaga;
    }
}
