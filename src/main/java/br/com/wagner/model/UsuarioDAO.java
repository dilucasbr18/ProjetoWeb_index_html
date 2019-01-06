package br.com.wagner.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.wagner.conexao.ConexaoBD;
import br.com.wagner.persistencia.Usuario;

public class UsuarioDAO {

	public void createUsuario(Usuario usuario) {
		String sql = "insert into usuario (nome,login ,senha) values(?,?,?)";
		try {
			PreparedStatement pst = ConexaoBD.getConexao().prepareStatement(sql);
			pst.setString(1, usuario.getNome());
			pst.setString(2, usuario.getLogin());
			pst.setString(3, usuario.getSenha());
			pst.execute();
			//JOptionPane.showMessageDialog(null, "Conexao OK!");
			pst.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "erro de conexao");
		}

	}

	public void alterarUsuario(Usuario usuario) {

		String sql = "update usuario set nome=?,login=?,senha=?  where id=?";
		try {
			PreparedStatement pst = ConexaoBD.getConexao().prepareStatement(sql);
			pst.setString(1, usuario.getNome());
			pst.setString(2, usuario.getLogin());
			pst.setString(3, usuario.getSenha());
			pst.setInt(4, usuario.getId());
			pst.executeUpdate();
			JOptionPane.showMessageDialog(null, "susario alterado com sucesso");
			pst.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void excluirUsuario(int id) {
		String sql = "delete from usuario where id=?";
		try {
			PreparedStatement pst = ConexaoBD.getConexao().prepareStatement(sql);
			pst.setInt(1, id);
			pst.execute();
			JOptionPane.showMessageDialog(null, "usuario excluido com sucesso");
			pst.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Usuario buscarUsuario(int id) {
		// List<Usuario> usudao=new ArrayList();
		String sql = "select * from usuario where id=?";
		try {
			PreparedStatement pst = ConexaoBD.getConexao().prepareStatement(sql);
			pst.setInt(1, id);
			ResultSet rs = null;
			rs = pst.executeQuery();
			if (rs.next()) {
				Usuario u = new Usuario();
				u.setId(rs.getInt(1));
				u.setNome(rs.getString(2));
				u.setLogin(rs.getString(3));
				u.setSenha(rs.getString(4));
				return u;
				// usudao.add(u);
			}
			pst.close();
			rs.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	public List<Usuario> buscarTodos() {
		List<Usuario> usuario = new ArrayList();
		String sql = "select * from usuario order by id";
		try {
			PreparedStatement pst = ConexaoBD.getConexao().prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				Usuario u = new Usuario();
				u.setId(rs.getInt(1));
				u.setNome(rs.getString(2));
				u.setLogin(rs.getString(3));
				u.setSenha(rs.getString(4));
				usuario.add(u);
			}

		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return usuario;

	}
public boolean verificaAcesso(Usuario usuario) {
	
	String sql="select * from usuario where login=? and senha=?";
	
	try {
		PreparedStatement pst=ConexaoBD.getConexao().prepareStatement(sql);
		pst.setString(1, usuario.getLogin());
		pst.setString(2,usuario.getSenha());
		ResultSet rs=pst.executeQuery();
		if(rs.next()) {
			return true;
		}else {
			return false;
		}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

return false;
}


}
