package data;

public class Livro {
	private int id;
	private String nomeLivro;
	private String nomeAutor;
	private String genero;
	
	
	public Livro(String nomeLivro, String nomeAutor, String genero) {
		this.nomeLivro= nomeLivro;
		this.nomeAutor= nomeAutor;
		this.genero= genero;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNomeLivro() {
		return nomeLivro;
	}


	public void setNomeLivro(String nomeLivro) {
		this.nomeLivro = nomeLivro;
	}


	public String getNomeAutor() {
		return nomeAutor;
	}


	public void setNomeAutor(String nomeAutor) {
		this.nomeAutor = nomeAutor;
	}


	public String getGenero() {
		return genero;
	}


	public void setGenero(String genero) {
		this.genero = genero;
	}
	
}
