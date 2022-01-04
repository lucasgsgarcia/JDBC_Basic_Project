package utfpr.lucasGarcia.bd2;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class BD2_Atividades {
	
	public static void main(String[] args) {

		//test_criaConexao();
		//test_lerTabela();

		
		atv1();
		atv2();
		atv3();
		atv4();
		atv5();
		atv6();
	}
	
	public static void test_criaConexao() {

		String url = "jdbc:postgresql://localhost/bd2";
		Properties props = new Properties();
		props.setProperty("user", "postgres");
		props.setProperty("password", "123");

		Connection conn;

		try {
			
			
			conn = DriverManager.getConnection(url, props);
			System.out.println("Conexao criada: " + conn);

			if (conn != null)
				conn.close();
			
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}
	
	
	private static void test_lerTabela() {

		String url = "jdbc:postgresql://localhost/bd2";
		Properties props = new Properties();
		props.setProperty("user", "postgres");
		props.setProperty("password", "123");

		Connection conn = null;
		Statement stmt = null;

		try {
			conn = DriverManager.getConnection(url, props);

			stmt = conn.createStatement();

			String sql = "SELECT codigo, nome, dataNasc FROM Aluno";
			ResultSet rs = stmt.executeQuery(sql);
			
			System.out.println("Lendo Tabela...");

			System.out.println("Codigo \t" + "Nome \t" + "Data de Nascimento \t");
			while (rs.next()) {

				int codigo = rs.getInt("Codigo");
				String nome = rs.getString("nome");
				String dataNasc = rs.getString("dataNasc");

				System.out.println(codigo + "\t" + nome + "\t" + dataNasc + "\t");

			}

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {

			try {
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}

		}
	}
	
	
	private static void atv1() {

		String url = "jdbc:postgresql://localhost/bd2";
		Properties props = new Properties();
		props.setProperty("user", "postgres");
		props.setProperty("password", "123");

		Connection conn = null;
		Statement stmt = null;

		try {
			conn = DriverManager.getConnection(url, props);

			stmt = conn.createStatement();

			String sql = "SELECT codigo, nome, descricao FROM Disciplina WHERE codigo = 1";
			ResultSet rs = stmt.executeQuery(sql);
			
			System.out.println("ATIVIDADE 1");

			System.out.println("Codigo \t" + "Nome \t" + "Descrição \t");
			while (rs.next()) {

				int codigo = rs.getInt("Codigo");
				String nome = rs.getString("nome");
				String descricao = rs.getString("descricao");

				System.out.println(codigo + "\t" + nome + "\t" + descricao + "\t");

			}

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {

			try {
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}

		}
	}
	
	private static void atv2() {

		String url = "jdbc:postgresql://localhost/bd2";
		Properties props = new Properties();
		props.setProperty("user", "postgres");
		props.setProperty("password", "123");

		Connection conn = null;
		Statement stmt = null;

		try {
			conn = DriverManager.getConnection(url, props);

			stmt = conn.createStatement();

			String sql = "SELECT codigo, nome, descricao FROM Disciplina WHERE descricao = 'Disciplina para eng software'";
			ResultSet rs = stmt.executeQuery(sql);
			
			System.out.println("\n ... ATIVIDADE 2 ...");

			System.out.println("Codigo \t" + "Nome \t" + "Descrição \t");
			while (rs.next()) {

				int codigo = rs.getInt("Codigo");
				String nome = rs.getString("nome");
				String descricao = rs.getString("descricao");

				System.out.println(codigo + "\t" + nome + "\t" + descricao + "\t");

			}

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {

			try {
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}

		}
	}
	
	private static void atv3() {

		String url = "jdbc:postgresql://localhost/bd2";
		Properties props = new Properties();
		props.setProperty("user", "postgres");
		props.setProperty("password", "123");

		Connection conn = null;
		Statement stmt = null;

		try {
			conn = DriverManager.getConnection(url, props);

			stmt = conn.createStatement();

			String sql = "SELECT codigo, nome, descricao FROM Disciplina WHERE codigo in (SELECT codigoDisciplina FROM turma WHERE professor = 'Huff')";
			ResultSet rs = stmt.executeQuery(sql);
			
			System.out.println("\n ... ATIVIDADE 3 ...");

			System.out.println("Codigo \t" + "Nome \t" + "Descrição \t");
			while (rs.next()) {

				int codigo = rs.getInt("Codigo");
				String nome = rs.getString("nome");
				String descricao = rs.getString("descricao");

				System.out.println(codigo + "\t" + nome + "\t" + descricao + "\t");

			}

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {

			try {
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}

		}
	}
	
	private static void atv4() {

		String url = "jdbc:postgresql://localhost/bd2";
		Properties props = new Properties();
		props.setProperty("user", "postgres");
		props.setProperty("password", "123");

		Connection conn = null;
		Statement stmt = null;

		try {
			conn = DriverManager.getConnection(url, props);

			stmt = conn.createStatement();

			String sql = "SELECT codigo, nome, descricao FROM Disciplina WHERE codigo in (SELECT codigoAluno FROM alunoTurma WHERE codigoAluno in (SELECT codigo FROM aluno WHERE nome = 'Lucas'))";
			ResultSet rs = stmt.executeQuery(sql);
			
			System.out.println("\n ... ATIVIDADE 4 ...");

			System.out.println("Codigo \t" + "Nome \t" + "Descrição \t");
			while (rs.next()) {

				int codigo = rs.getInt("Codigo");
				String nome = rs.getString("nome");
				String descricao = rs.getString("descricao");

				System.out.println(codigo + "\t" + nome + "\t" + descricao + "\t");

			}

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {

			try {
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}

		}
	}
	
	private static void atv5() {

		String url = "jdbc:postgresql://localhost/bd2";
		Properties props = new Properties();
		props.setProperty("user", "postgres");
		props.setProperty("password", "123");

		Connection conn = null;
		Statement stmt = null;

		try {
			conn = DriverManager.getConnection(url, props);

			stmt = conn.createStatement();

			String sql = "SELECT codigoDisciplina, COUNT(codigoDisciplina) AS Qtd FROM alunoTurma GROUP BY codigoDisciplina HAVING COUNT(codigoDisciplina) > 1 ORDER BY COUNT(codigoDisciplina) DESC limit 1";
			ResultSet rs = stmt.executeQuery(sql);
			
			System.out.println("\n ... ATIVIDADE 5 ...");

			System.out.println("Codigo \t" + "Disciplina \t");
			while (rs.next()) {

				int codigo = rs.getInt("codigoDisciplina");
				int qtd = rs.getInt("Qtd");

				System.out.println(codigo + "\t" + qtd + "\t");

			}

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {

			try {
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}

		}
	}
	
	private static void atv6() {

		String url = "jdbc:postgresql://localhost/bd2";
		Properties props = new Properties();
		props.setProperty("user", "postgres");
		props.setProperty("password", "123");

		Connection conn = null;
		Statement stmt = null;

		try {
			conn = DriverManager.getConnection(url, props);
			Statement stm = conn.createStatement();

            DatabaseMetaData md = conn.getMetaData();

            String[] types = {"TABLE"};
            ResultSet rs = md.getTables("bd2", null, "%", types);
            int i = 0;
            while (rs.next()) {
            	i++;
            }
            System.out.println("\n O número de tabelas é: "+i);

		} catch (SQLException e) {

			e.printStackTrace();
		} 
	}
	

	
	
	
	
	

}
