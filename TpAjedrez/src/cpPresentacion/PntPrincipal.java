package cpPresentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;

public class PntPrincipal {

	private JFrame pntPrincipal;
	private JTextField txtDniBlancas;
	private JTextField txtDniNegras;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PntPrincipal window = new PntPrincipal();
					window.pntPrincipal.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PntPrincipal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		pntPrincipal = new JFrame();
		pntPrincipal.setTitle("Ingresar jugadores...");
		pntPrincipal.setBounds(100, 100, 392, 193);
		pntPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		txtDniBlancas = new JTextField();
		txtDniBlancas.setColumns(10);
		
		JLabel lblDniBlancas = new JLabel("DNI Jugador Blancas");
		
		txtDniNegras = new JTextField();
		txtDniNegras.setColumns(10);
		
		JLabel lblDniNegras = new JLabel("DNI Jugador Negras");
		
		JButton btnJugar = new JButton("JUGAR!!!");
		GroupLayout groupLayout = new GroupLayout(pntPrincipal.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(34)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblDniBlancas)
								.addComponent(lblDniNegras))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(txtDniNegras, Alignment.LEADING)
								.addComponent(txtDniBlancas, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(141)
							.addComponent(btnJugar, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(45, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(35)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtDniBlancas, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDniBlancas))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtDniNegras, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDniNegras))
					.addGap(18)
					.addComponent(btnJugar, GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
					.addContainerGap())
		);
		pntPrincipal.getContentPane().setLayout(groupLayout);
	}
}
