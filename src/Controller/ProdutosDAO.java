
package Controller;
 
import Model.Produtos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class ProdutosDAO {
    private final Connection conn;
    
    public ProdutosDAO(){
        this.conn = new ConexaoBanco().pegarConexao();
    }
    
    public List<Produtos>listar(){
        List<Produtos> lista = new ArrayList<>();
        try {
            String sql = "select * from tb_produto";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                Produtos obj = new Produtos();
                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setPreco(rs.getDouble("preco"));
                lista.add(obj);
            }
            return lista;
            
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao criar a lista"+erro);
        }
        return null;
    }
    
    public List<Produtos>filtrar(String nome){
        List<Produtos> lista = new ArrayList<>();
        try {
            String sql = "select * from tb_produto where nome like ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, nome);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                Produtos obj = new Produtos();
                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setPreco(rs.getDouble("preco"));
                lista.add(obj);
            }
            return lista;
            
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao criar a lista"+erro);
        }
        return null;
    }
}
