package data;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class connectPost {
	private String url;
	private String login;
	private String senha;
	private Connection connect;
	private Statement stm;
	private String query;
	PreparedStatement preparedStatement;
	ResultSet resultadosSQL;
	
	public connectPost(){
		this.url="jdbc:postgresql://localhost:5432/postgres";
		this.login="postgres";
		this.senha="meuap101";
		
		
		try {
			Class.forName("org.postgresql.Driver");
			connect= DriverManager.getConnection(url, login, senha);
			this.stm=connect.createStatement();
			System.out.println("Connection with postgres was activate");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public void inserirLivro(String nomeP, String autorP, String generoP) {
		try {
			
			query= "insert into livros(id, nome, autor, genero)"+"values(default, ?, ?, ?)";
			preparedStatement= connect.prepareStatement(query);
			preparedStatement.setString(1, nomeP);
			preparedStatement.setString(2, autorP);
			preparedStatement.setString(3, generoP);
			preparedStatement.execute();
			System.out.println("Armazenado :"+nomeP+autorP+generoP);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public String mostrarTabela() {
		String nomesLivros=" ";
		try {
			stm= connect.createStatement();
			resultadosSQL=stm.executeQuery("SELECT nome from livros");
			while(resultadosSQL.next()) {
				String nomeResultado= resultadosSQL.getString("nome");
				System.out.println(nomeResultado);
				nomesLivros=(nomesLivros+"; "+nomeResultado);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Deu errado aqui"+ e);
			
		}
		return nomesLivros;
	}
	
	public Livro procurarPorNome(String nomeBuscado) {
		
		try {
			stm= connect.createStatement();
			query="SELECT autor, genero FROM livros WHERE nome=?";
			preparedStatement = connect.prepareStatement(query);
			preparedStatement.setString(1, nomeBuscado);
			resultadosSQL= preparedStatement.executeQuery();
			
			while(resultadosSQL.next()) {
				
				
				System.out.println(resultadosSQL.getString("autor")+" e "+resultadosSQL.getString("genero"));
				Livro livro=new Livro(nomeBuscado, resultadosSQL.getString("autor"),resultadosSQL.getString("genero"));
				return livro;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Deu errado aqui"+ e);
			
		}
		Livro livro=new Livro("Não encontrado",null,null);
		return livro;
	}
	public void finishConnection() {
		try {
			connect.close();
			System.out.println("Connection close");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	
}
