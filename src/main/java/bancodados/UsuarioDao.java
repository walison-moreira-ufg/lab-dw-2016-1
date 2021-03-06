package bancodados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * DAO = Data Access Object.
 */
public class UsuarioDao {

	private static final String URL = "jdbc:derby:db;create=true";

	public static void inclui(int codigo, String nome, String login, String senha) throws SQLException {
		// Abrir uma conexão com o banco de dados.
		Connection conn = DriverManager.getConnection(URL);
		// Executar instrução SQL.
		String sql = "insert into usuario (codigo, nome, login, senha) values (?, ?, ?, ?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, codigo);
		pstmt.setString(2, nome);
		pstmt.setString(3, login);
		pstmt.setString(4, senha);
		pstmt.executeUpdate();
		// Fechar sentença.
		pstmt.close();
		// Fechar conexão.
		conn.close();
	}

	public static void alterar(int codigo, String nome, String login, String senha) throws SQLException {
		// Abrir uma conexão com o banco de dados.
		Connection conn = DriverManager.getConnection(URL);
		// Executar instrução SQL.
		String sql = "update usuario set nome = ?, login = ?, senha = ? where codigo = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, nome);
		pstmt.setString(2, login);
		pstmt.setString(3, senha);
		pstmt.setInt(4, codigo);
		pstmt.executeUpdate();
		// Fechar sentença.
		pstmt.close();
		// Fechar conexão.
		conn.close();
	}

	public static void excluir(int codigo) throws SQLException {
		// Abrir uma conexão com o banco de dados.
		Connection conn = DriverManager.getConnection(URL);
		// Executar instrução SQL.
		String sql = "delete from usuario where codigo = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, codigo);
		pstmt.executeUpdate();
		// Fechar sentença.
		pstmt.close();
		// Fechar conexão.
		conn.close();
	}

	public static ArrayList<Usuario> listar() throws SQLException {
		// Abrir uma conexão com o banco de dados.
		Connection conn = DriverManager.getConnection(URL);
		// Executar instrução SQL.
		String sql = "select codigo, nome, login, senha from usuario";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		//Executa a consulta. 
		ResultSet rs = pstmt.executeQuery();
		// Percorrer resultados.
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		while (rs.next()) {
			int codigo = rs.getInt("codigo");
			String nome = rs.getString("nome");
			String login = rs.getString("login");
			String senha = rs.getString("senha");

			Usuario usuario = new Usuario(codigo, nome, login, senha);
			usuarios.add(usuario);
		}
		// Fechar resultado.
		rs.close();
		// Fechar sentença.
		pstmt.close();
		// Fechar conexão.
		conn.close();
		
		return usuarios;
	}
}
