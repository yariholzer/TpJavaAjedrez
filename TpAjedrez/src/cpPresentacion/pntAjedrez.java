package cpPresentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;

import cpLogica.Controlador;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class pntAjedrez extends JFrame {

	private JPanel contentPane;
	private JTextField txtBlancas;
	private JTextField txtNegras;
	private JTextField txtTurno;
	private JTextField txtOrigen;
	private JTextField txtDestino;
	Controlador ctrl = new Controlador();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					pntAjedrez frame = new pntAjedrez();
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
	public pntAjedrez() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				guardarPartida();
			}
		});
		setTitle("Juego de Ajedrez");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblBlancas = new JLabel("Blancas:");
		
		JLabel lblNegras = new JLabel("Negras:");
		
		JButton btnJugar = new JButton("Jugar");
		btnJugar.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				
				btnJugarClicked();
				
			}
		});
		
		JLabel lblTurno = new JLabel("Turno:");
		
		JLabel lblOrigen = new JLabel("Posicion Origen:");
		
		JLabel lblDestino = new JLabel("Posicion Destino:");
		
		JButton btnMover = new JButton("Mover");
		
		txtBlancas = new JTextField();
		txtBlancas.setColumns(10);
		
		txtNegras = new JTextField();
		txtNegras.setColumns(10);
		
		txtTurno = new JTextField();
		txtTurno.setColumns(10);
		
		txtOrigen = new JTextField();
		txtOrigen.setColumns(10);
		
		txtDestino = new JTextField();
		txtDestino.setText("");
		txtDestino.setColumns(10);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblBlancas)
							.addGap(18)
							.addComponent(txtBlancas, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 148, Short.MAX_VALUE)
							.addComponent(btnJugar)
							.addGap(31))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblOrigen)
								.addComponent(lblDestino))
							.addGap(14)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(txtOrigen, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtDestino, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
									.addGap(10)
									.addComponent(btnMover)))
							.addGap(16))
						.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNegras)
								.addComponent(lblTurno))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(txtTurno)
								.addComponent(txtNegras, GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE))
							.addContainerGap(240, Short.MAX_VALUE))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(20)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnJugar)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblBlancas)
							.addComponent(txtBlancas, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNegras)
						.addComponent(txtNegras, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(37)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTurno)
						.addComponent(txtTurno, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblOrigen)
						.addComponent(txtOrigen, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblDestino)
						.addComponent(txtDestino, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnMover)
					.addContainerGap(28, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}

	protected void btnJugarClicked() {
		
		String color = "BLANCO";
		ctrl.inicializar(color);
		
	}
	
	protected void guardarPartida() {
		
		int opcion;
		opcion = JOptionPane.YES_NO_CANCEL_OPTION;
		JOptionPane.showConfirmDialog(null,"¿Desea guardar la partida antes de salir?","Guardar",opcion);
		if (opcion == JOptionPane.YES_OPTION){};
		
	}
}
