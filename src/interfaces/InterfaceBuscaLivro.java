package interfaces;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import data.Livro;
import data.connectPost;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.awt.event.ActionListener;

public class InterfaceBuscaLivro extends JFrame {
	
	
	private JPanel contentPane;
	private JTextField nomeBuscado;
	private final Action action = new SwingAction();
	connectPost connect= new connectPost();
	
	private JPanel contentPane2;
	private JTextField textNome;
	private JTextField textAutor;
	private JTextField textGenero;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfaceBuscaLivro frame = new InterfaceBuscaLivro();
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
	public InterfaceBuscaLivro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 347, 274);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Digite o nome a ser buscado");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Sylfaen", Font.PLAIN, 15));
		lblNewLabel.setBounds(10, 23, 311, 50);
		contentPane.add(lblNewLabel);
		
		nomeBuscado = new JTextField();
		nomeBuscado.setHorizontalAlignment(SwingConstants.CENTER);
		nomeBuscado.setBounds(10, 98, 311, 25);
		contentPane.add(nomeBuscado);
		nomeBuscado.setColumns(10);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Livro livro= connect.procurarPorNome(nomeBuscado.getText());
					
					
					telaResultadoBusca(livro.getNomeLivro(), livro.getNomeAutor(), livro.getGenero());
						
					
					connect.finishConnection();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		btnPesquisar.setBounds(101, 174, 131, 50);
		contentPane.add(btnPesquisar);
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
	
	public void telaResultadoBusca(String nome,String nomeAutor, String genero) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane2 = new JPanel();
		contentPane2.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane2);
		contentPane2.setLayout(null);
		
		textNome = new JTextField(nome);
		textNome.setBounds(147, 55, 213, 20);
		contentPane2.add(textNome);
		textNome.setColumns(10);
		System.out.println(nome);
		
		
		JLabel lblNewLabel = new JLabel("Nome");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(44, 57, 72, 14);
		contentPane2.add(lblNewLabel);
		
		JLabel lblNomeAutor = new JLabel("Nome Autor");
		lblNomeAutor.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNomeAutor.setBounds(44, 114, 72, 14);
		contentPane2.add(lblNomeAutor);
		
		JLabel lblGenero = new JLabel("Genero");
		lblGenero.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblGenero.setBounds(44, 170, 72, 14);
		contentPane2.add(lblGenero);
		
		textAutor = new JTextField(nomeAutor);
		textAutor.setColumns(10);
		textAutor.setBounds(147, 112, 213, 20);
		contentPane2.add(textAutor);
		
		textGenero = new JTextField(genero);
		textGenero.setColumns(10);
		textGenero.setBounds(147, 168, 213, 20);
		contentPane2.add(textGenero);
	}
}
