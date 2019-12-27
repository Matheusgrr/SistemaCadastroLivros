package controllers;

import data.Livro;
import data.connectPost;
import interfaces.CadastroLivro;
import interfaces.TelaInicial;

public class ControleLivro {
	
	
	public void chamarTelaCadastroLivro() {
		CadastroLivro telaCadastro= new CadastroLivro();
		
	}
	
	public void criarLivro(String nome, String autor, String genero) {
		
		System.out.println("Cheguei aqui "+nome);
		try {
			connectPost connect= new connectPost();
			connect.inserirLivro(nome, autor, genero);
			connect.finishConnection();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
}
