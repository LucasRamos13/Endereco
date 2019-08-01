
package dao;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modelo.Endereco;

public class EnderecoDao {
    
 public static boolean inserir(Endereco objeto) {
        String sql = "INSERT INTO endereco (bairro, complemento, logradouro) VALUES (?, ?, ?)";
        try {
            PreparedStatement ps = conexao.Conexao.getConexao().prepareStatement(sql);
            ps.setString(1, objeto.getBairro());
            ps.setString(2, objeto.getComplemento());
            ps.setString(3, objeto.getLogradouro());
            ps.executeUpdate();
            return true;
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }
        public static void main(String[] args) {
        Endereco objeto = new Endereco();
        objeto.setBairro("Centrinho");
        objeto.setComplemento("Fundo");
        objeto.setLogradouro("rua silva, 4150");
        
        boolean resultado = inserir(objeto);
        if (resultado) {
            JOptionPane.showMessageDialog(null, "Inserido com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Erro!");
        }
    }
          public static boolean alterar(Endereco objeto) {
        String sql = "UPDATE Endereco SET bairro = ?, logradouro = ?, complemento = ? WHERE codigo=?";
        try {
            PreparedStatement ps = conexao.Conexao.getConexao().prepareStatement(sql);
            ps.setString(1, objeto.getBairro()); 
            ps.setString(2, objeto.getLogradouro());
            ps.setString(3, objeto.getComplemento());
            ps.setInt(4, objeto.getCodigo());
            ps.executeUpdate();
            return true;
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }
            public static boolean excluir(Endereco objeto) {
        String sql = "DELETE FROM Endereco WHERE codigo=?";
        try {
            PreparedStatement ps = conexao.Conexao.getConexao().prepareStatement(sql);
            ps.setInt(1, objeto.getCodigo());
            ps.executeUpdate();
            return true;
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }
}
