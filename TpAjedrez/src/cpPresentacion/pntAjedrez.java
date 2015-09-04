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

import javax.swing.JTable;

import org.omg.CORBA.CTX_RESTRICT_SCOPE;
import javax.swing.JScrollPane;

public class pntAjedrez extends JFrame {

	private JPanel contentPane;
	private JTextField txtTurno;
	private JTextField txtOrigen;
	private JTextField txtDestino;
	
	Controlador ctrl;
	
	/**
	 * Create the frame.
	 * @param ctrl 
	 */

	public pntAjedrez(Controlador c) {
		ctrl =c;
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
		
		JLabel lblTurno = new JLabel("Turno:");
		
		JLabel lblOrigen = new JLabel("Posicion Origen:");
		
		JLabel lblDestino = new JLabel("Posicion Destino:");
		
		JButton btnMover = new JButton("Mover");
		btnMover.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				realizarJugada((txtOrigen.getText()),(txtDestino.getText()));
			}
		});
		
		txtTurno = new JTextField();
		txtTurno.setColumns(10);
		
		txtOrigen = new JTextField();
		txtOrigen.setColumns(10);
		
		txtDestino = new JTextField();
		txtDestino.setText("");
		txtDestino.setColumns(10);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblTurno)
					.addGap(18)
					.addComponent(txtTurno, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(83)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblDestino, Alignment.LEADING)
						.addComponent(lblOrigen, Alignment.LEADING))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(10)
							.addComponent(btnMover))
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
							.addComponent(txtOrigen, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(txtDestino, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTurno)
						.addComponent(txtTurno, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtOrigen, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblOrigen))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDestino)
						.addComponent(txtDestino, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnMover)
					.addContainerGap(156, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
		
	}
	
	protected void realizarJugada(String origen, String destino) {
		
		String columnas;
		int filas;
		boolean bandera=false;
		columnas = origen.substring(0,1);
		filas =Integer.parseInt(origen.substring(1,2));
		
		if(columnas.matches("[a-h]"))
			{
				if (1<= filas && filas <= 8)
					{bandera = true;}
				else JOptionPane.showMessageDialog(null, "la fila de origen ingresada es incorrecta ");
		
			}else 
				JOptionPane.showMessageDialog(null, "la columna de origen ingresada es incorrecta ");
		
		if (bandera==true)
			{
			columnas = destino.substring(0,1);
			filas =Integer.parseInt(destino.substring(1,2));
			
			if(columnas.matches("[a-h]"))
				{
					if (1<= filas && filas <= 8)
						{ctrl.moverPiezas(origen, destino);}
					else JOptionPane.showMessageDialog(null, "la fila de destino ingresada es incorrecta ");
			
				}else 
					JOptionPane.showMessageDialog(null, "la columna de destino ingresada es incorrecta ");
			
			
			
			
		}
	}

	protected void guardarPartida() {
		
		int opcion;
		opcion = JOptionPane.YES_NO_CANCEL_OPTION;
		JOptionPane.showConfirmDialog(null,"¿Desea guardar la partida antes de salir?","Guardar",opcion);
		if (opcion == JOptionPane.YES_OPTION){};
		
	}
}
