import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClienteDAO extends GenericDAO<Cliente>{

    @Override
    protected String getInsertQuery() {
        return "INSERT INTO cliente (cpf, nome_cliente) VALUES (?, ?)";
    }

    @Override
    protected String getUpdateQuery() {
        return "UPDATE cliente SET cpf = ?, nome_cliente = ? WHERE id_cliente = ?";
    }

    @Override
    protected String getDeleteQuery() {
        return "DELETE FROM cliente WHERE cpf = ?";
    }

    @Override
    protected String getSelectQuery() {
        return "SELECT * FROM cliente WHERE cpf = ?";
    }

    @Override
    protected void setParameters(PreparedStatement stmt, Cliente cliente) throws SQLException {
        stmt.setString(1, cliente.getCpf());
        stmt.setString(2, cliente.getNome());
    }

    @Override
    protected Cliente getEntityFromResult(ResultSet rs) throws SQLException {
        Cliente cliente = new Cliente (
                rs.getString("cpf"),
                rs.getString("nome_cliente")
        );
        cliente.setIdCliente(rs.getInt("id_cliente"));
        return cliente;
    }

    public void listarClientes (){
        String sql = "SELECT * FROM cliente";
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try{
            conn = DatabaseConnection.getConnection();
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            while(rs.next()){
                int id = rs.getInt("id_cliente");
                String nome = rs.getString("nome_cliente");
                String cpf = rs.getString("cpf");

                System.out.println("ID: "+ id +" | Nome: "+ nome +" | CPF: " + cpf);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeResultSet(rs);
            DatabaseConnection.closeStatement(stmt);
            DatabaseConnection.closeConnection(conn);
        }
    }

    @Override
    public void atualizar(Cliente cliente) {
        String sql = getUpdateQuery();
        Connection conn = null;
        PreparedStatement stmt = null;

        try{
            conn = DatabaseConnection.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, cliente.getCpf());
            stmt.setString(2, cliente.getNome());
            stmt.setInt(3, cliente.getIdCliente());
            stmt.executeUpdate();
            System.out.println("Cliente atualizado");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeStatement(stmt);
            DatabaseConnection.closeConnection(conn);
        }


    }

    public void deletar(String cpf){
        String sql = getDeleteQuery();
        Connection conn = null;
        PreparedStatement stmt = null;

        try{
            conn = DatabaseConnection.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, cpf);
            stmt.executeUpdate();
            System.out.println("Cliente deletado");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeStatement(stmt);
            DatabaseConnection.closeConnection(conn);
        }
    }

    public Cliente buscarPorCPF(String cpf) {
        String sql = getSelectQuery();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Cliente cliente = null;

        try{
            conn = DatabaseConnection.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, cpf);
            rs = stmt.executeQuery();

            if(rs.next()){
                cliente = getEntityFromResult(rs);
                System.out.println("Cliente encontrado nome:"+ cliente.getNome() +"| CPF: "+ cliente.getCpf()
                                  +"| ID: "+ cliente.getIdCliente());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeResultSet(rs);
            DatabaseConnection.closeStatement(stmt);
            DatabaseConnection.closeConnection(conn);
        }
        return cliente;
    }
}
