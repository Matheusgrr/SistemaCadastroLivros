package interfaces;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaInicial extends JFrame {

	CadastroLivro telaCadastro= new CadastroLivro();
	InterfaceBuscaLivro telaBusca= new InterfaceBuscaLivro();
	TelaListaLivros telaListaLivros= new TelaListaLivros();
	
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaInicial frame = new TelaInicial();
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
	public TelaInicial() {
		setAutoRequestFocus(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 376);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSistemaArmazenamentoLivros = new JLabel("Sistema Armazenamento Livros");
		lblSistemaArmazenamentoLivros.setBounds(0, 0, 434, 55);
		lblSistemaArmazenamentoLivros.setHorizontalAlignment(SwingConstants.CENTER);
		lblSistemaArmazenamentoLivros.setFont(new Font("Tahoma", Font.BOLD, 20));
		contentPane.add(lblSistemaArmazenamentoLivros);
		
		JButton btnCadastrarLivro = new JButton("Cadastrar Livro");
		btnCadastrarLivro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				telaCadastro.main(null);
				
			}
		});
		btnCadastrarLivro.setForeground(Color.BLACK);
		btnCadastrarLivro.setBackground(Color.DARK_GRAY);
		btnCadastrarLivro.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnCadastrarLivro.setBounds(118, 117, 174, 27);
		contentPane.add(btnCadastrarLivro);
		
		JButton btnPesquisarLivro = new JButton("Pesquisar Livro");
		btnPesquisarLivro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				telaBusca.main(null);
			}
		});
		btnPesquisarLivro.setForeground(Color.BLACK);
		btnPesquisarLivro.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnPesquisarLivro.setBackground(Color.DARK_GRAY);
		btnPesquisarLivro.setBounds(118, 186, 174, 27);
		contentPane.add(btnPesquisarLivro);
		
		JButton btnMostrarTodosOs = new JButton("Mostrar Livros");
		btnMostrarTodosOs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				telaListaLivros.main(null);
			}
		});
		btnMostrarTodosOs.setForeground(Color.BLACK);
		btnMostrarTodosOs.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnMostrarTodosOs.setBackground(Color.DARK_GRAY);
		btnMostrarTodosOs.setBounds(118, 251, 174, 27);
		contentPane.add(btnMostrarTodosOs);
	}
	
	
}
