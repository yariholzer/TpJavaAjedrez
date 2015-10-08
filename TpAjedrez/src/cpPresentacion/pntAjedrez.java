package cpPresentacion;


import java.awt.Color;

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

import cpLogica.*;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.LineBorder;

public class pntAjedrez extends JFrame {


	private static final long serialVersionUID = 3096520898632450419L;
	private JPanel contentPane;
	private JTextField txtTurno;
	private JTextField txtOrigen;
	private JTextField txtDestino;
	
	CtrlAjedrez ctrl;
	private JTable table;
	
	/**
	 * Create the frame.
	 * @param ctrl 
	 */

	public pntAjedrez(CtrlAjedrez c) {
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
					mostrarTablero();
				
				
			}
		});
		
		txtTurno = new JTextField();
		txtTurno.setColumns(10);
		
		txtOrigen = new JTextField();
		txtOrigen.setColumns(10);
		
		txtDestino = new JTextField();
		txtDestino.setText("");
		txtDestino.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblTurno)
							.addGap(18)
							.addComponent(txtTurno, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 182, GroupLayout.PREFERRED_SIZE))
					.addGap(37)
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
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblDestino)
								.addComponent(txtDestino, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnMover)
							.addContainerGap())
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE)
							.addGap(22))))
		);
		
		table = new JTable(8,9);
		
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
			},
			new String[] {
				"a", "b", "c", "d", "e", "f", "g", "h", ""
			}
		));
		table.getColumnModel().getColumn(8).setCellRenderer(table.getTableHeader().getDefaultRenderer());
		table.setBorder(null);
		scrollPane.setViewportView(table);
		contentPane.setLayout(gl_contentPane);
		table.setRowSelectionAllowed(false);
		table.setEnabled(false);
		
		mostrarTablero();
		
		txtTurno.setText(ctrl.devolverTurno().getNombre());
	}
	
	protected void realizarJugada(String origen, String destino) {
		try {
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
					{boolean gano;
					gano=ctrl.moverPiezas(origen, destino);
					if (gano){
						this.setVisible(false);
					}
					txtTurno.setText(ctrl.devolverTurno().getNombre());}
					
					else JOptionPane.showMessageDialog(null, "la fila de destino ingresada es incorrecta ");
			
				}else 
					JOptionPane.showMessageDialog(null, "la columna de destino ingresada es incorrecta ");}
			
					}
		 catch (Exception e) {
			e.printStackTrace();
		 	}	
					
}


	protected void guardarPartida() {

		int opcion;
		opcion = JOptionPane.YES_NO_CANCEL_OPTION;
		JOptionPane.showConfirmDialog(null,"¿Desea guardar la partida antes de salir?","Guardar",opcion);
		if (opcion == JOptionPane.YES_OPTION){
			ctrl.guardarPartida();
		};
		
	}
	
	protected void mostrarTablero(){
		setearcolores();
		String valor,posicion;
		
		for (int i = 1; i<=8; i++) {
			table.setValueAt( i,(i-1) , 8);
			for (char j = 'a'; j <= 'h'; j++) {
				posicion= j + Integer.toString(i);
				valor =ctrl.recuperarFicha(posicion);
				table.setValueAt(valor,(i-1),(j-97) );	
			}
		} 
	}
	
	private void setearcolores() {
		table.setBackground(new Color(184, 134, 11));
	}


}


