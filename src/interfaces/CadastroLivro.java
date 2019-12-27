package interfaces;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controllers.ControleLivro;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CadastroLivro extends JFrame {

	private JPanel contentPane;
	private JTextField nomeLivro;
	private JTextField nomeAutor;
	private JTextField genero;
	ControleLivro controle= new ControleLivro();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroLivro frame = new CadastroLivro();
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CadastroLivro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 419, 377);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNomeLivro = new JLabel("Nome Livro");
		lblNomeLivro.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNomeLivro.setBounds(24, 98, 101, 24);
		contentPane.add(lblNomeLivro);
		
		JLabel lblNewLabel = new JLabel("Cadastro de Livros");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(0, 0, 403, 46);
		contentPane.add(lblNewLabel);
		
		JLabel lblNomeAutor = new JLabel("Nome Autor");
		lblNomeAutor.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNomeAutor.setBounds(24, 152, 101, 24);
		contentPane.add(lblNomeAutor);
		
		JLabel lblGenero = new JLabel("G\u00EAnero");
		lblGenero.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblGenero.setBounds(24, 210, 101, 24);
		contentPane.add(lblGenero);
		
		nomeLivro = new JTextField();
		nomeLivro.setBounds(135, 102, 215, 20);
		contentPane.add(nomeLivro);
		nomeLivro.setColumns(10);
		
		nomeAutor = new JTextField();
		nomeAutor.setColumns(10);
		nomeAutor.setBounds(135, 156, 215, 20);
		contentPane.add(nomeAutor);
		
		genero = new JTextField();
		genero.setColumns(10);
		genero.setBounds(135, 214, 215, 20);
		contentPane.add(genero);
		
		JButton enviarDados = new JButton("Enviar");
		enviarDados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				controle.criarLivro(nomeLivro.getText(), nomeAutor.getText(), genero.getText());
				dispose();
			}
		});
		enviarDados.setFont(new Font("Tahoma", Font.BOLD, 17));
		enviarDados.setBounds(120, 279, 173, 34);
		contentPane.add(enviarDados);
	}
}
