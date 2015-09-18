package cpPresentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;

import cpLogica.*;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;
import java.awt.Color;

public class PntPrincipal {

	public static CtrlAjedrez ctrl = new CtrlAjedrez();
	
	private JFrame pntPrincipal;
	private JTextField txtDniBlancas;
	private JTextField txtDniNegras;
	private JTextField txtNombreBlancas;
	private JTextField txtApellidoBlancas;
	private JLabel lblJugadorNegras;
	private JLabel lblNombre;
	private JLabel lblApellido;
	private JLabel label;
	private JLabel label_1;
	private JTextField txtNombreNegras;
	private JTextField txtApellidoNegras;


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
		pntPrincipal.setBounds(100, 100, 344, 334);
		pntPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		txtDniBlancas = new JTextField();
		txtDniBlancas.setColumns(10);
		
		JLabel lblDniBlancas = new JLabel("DNI");
		lblDniBlancas.setHorizontalAlignment(SwingConstants.TRAILING);
		
		txtDniNegras = new JTextField();
		txtDniNegras.setColumns(10);
		
		JLabel lblDniNegras = new JLabel("DNI");
		
		JButton btnJugar = new JButton("JUGAR!!!");
		btnJugar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				btnJugarClicked();
				pntPrincipal.setVisible(false);
			}
		});
		
		txtNombreBlancas = new JTextField();
		txtNombreBlancas.setColumns(10);
		
		txtApellidoBlancas = new JTextField();
		txtApellidoBlancas.setColumns(10);
		
		JLabel lblJugadorBlancas = new JLabel("Jugador Blancas");
		lblJugadorBlancas.setBackground(new Color(128, 128, 128));
		lblJugadorBlancas.setHorizontalAlignment(SwingConstants.CENTER);
		
		lblJugadorNegras = new JLabel("Jugador Negras");
		lblJugadorNegras.setHorizontalAlignment(SwingConstants.CENTER);
		lblJugadorNegras.setBackground(Color.GRAY);
		
		lblNombre = new JLabel("Nombre:");
		
		lblApellido = new JLabel("Apellido");
		
		label = new JLabel("Nombre:");
		
		label_1 = new JLabel("Apellido");
		
		txtNombreNegras = new JTextField();
		txtNombreNegras.setColumns(10);
		
		txtApellidoNegras = new JTextField();
		txtApellidoNegras.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(pntPrincipal.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addGap(34)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblDniNegras)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(lblNombre, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblApellido)
										.addComponent(lblDniBlancas))
									.addGap(2))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(label, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
									.addGap(18)))
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(txtApellidoBlancas, GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
								.addComponent(txtDniNegras, 182, 182, Short.MAX_VALUE)
								.addComponent(txtNombreBlancas, GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
								.addComponent(txtDniBlancas, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
								.addComponent(lblJugadorBlancas, GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
								.addComponent(lblJugadorNegras, GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
								.addGroup(groupLayout.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(txtNombreNegras, GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE))
								.addComponent(txtApellidoNegras, GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE))))
					.addGap(228))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(113)
					.addComponent(btnJugar, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(79, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(15)
					.addComponent(lblJugadorBlancas)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDniBlancas)
						.addComponent(txtDniBlancas, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNombre)
						.addComponent(txtNombreBlancas, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblApellido)
						.addComponent(txtApellidoBlancas, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(28)
					.addComponent(lblJugadorNegras)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDniNegras)
						.addComponent(txtDniNegras, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtNombreNegras, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtApellidoNegras, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_1))
					.addGap(18)
					.addComponent(btnJugar)
					.addContainerGap(33, Short.MAX_VALUE))
		);
		pntPrincipal.getContentPane().setLayout(groupLayout);
	}

	protected void btnJugarClicked() {

		// cargar jugadores
		
		
		long dniBlancas      = Long.parseLong(txtDniBlancas.getText()); 
		String nombreBlancas = txtNombreBlancas.getText();
		String apellBlancas  = txtApellidoBlancas.getText();
		
		long dniNegras      = Long.parseLong(txtDniNegras.getText());
		String nombreNegras = txtNombreNegras.getText();
		String apellNegras  = txtApellidoNegras.getText();
		
		ctrl.nuevaPartida(dniBlancas,
						  nombreBlancas,
						  apellBlancas,
						  dniNegras,
						  nombreNegras,
						  apellNegras);
		
		try {
			pntAjedrez frame = new pntAjedrez(ctrl);
			frame.setVisible(true);
			pntPrincipal.setVisible(false);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
