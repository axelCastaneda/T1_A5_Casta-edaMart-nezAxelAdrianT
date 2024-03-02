import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

class VentanaInicio extends JFrame implements ActionListener, KeyListener{
	
	GridBagLayout gbl = new GridBagLayout();
	GridBagConstraints gbc = new GridBagConstraints();
	
	JTextField cajaGradosC, cajaResultado;
	JComboBox<String> comboTemp1, comboTemp2;
	
	JButton btnConvertir;
	Font font1 = new Font("Arial", 1 , 18);
	ConversorT CT = new ConversorT();
	
	byte x1 = 0, x2 = 0, punt = 0, men = 0;
	
	public void actionPerformed(ActionEvent e) {
		Component c = (Component) e.getSource();
		if(c == comboTemp1 && x2 == 0) {
			x1 = 1;
			comboTemp2.removeAllItems();
			if(comboTemp1.getSelectedIndex() == 0) {
				cajaResultado.setText("");
			}else {
				for (int i = 0; i<comboTemp1.getItemCount();i++) {
					if(comboTemp1.getSelectedIndex() == i) {
						
					}else {
						comboTemp2.addItem(comboTemp1.getItemAt(i));
					}
				}
			}
			x1 = 0;
		}else if(c == comboTemp2 && x1 == 0) {
			x2 = 1;
			if(comboTemp2.getSelectedIndex() == 0) {
				cajaResultado.setText("");
			}else if(comboTemp1.getSelectedIndex() == 1) {
				if(comboTemp2.getSelectedIndex() == 1) {
					cajaResultado.setText(String.valueOf(CT.CAF(Double.parseDouble(cajaGradosC.getText()))));
				}else if(comboTemp2.getSelectedIndex() == 2) {
					cajaResultado.setText(String.valueOf(CT.CAK(Double.parseDouble(cajaGradosC.getText()))));
				}else if(comboTemp2.getSelectedIndex() == 3) {
					cajaResultado.setText(String.valueOf(CT.CAR(Double.parseDouble(cajaGradosC.getText()))));
				}
			}else if(comboTemp1.getSelectedIndex() == 2) {
				if(comboTemp2.getSelectedIndex() == 1) {
					cajaResultado.setText(String.valueOf(CT.FAC(Double.parseDouble(cajaGradosC.getText()))));
				}else if(comboTemp2.getSelectedIndex() == 2) {
					cajaResultado.setText(String.valueOf(CT.FAK(Double.parseDouble(cajaGradosC.getText()))));
				}else if(comboTemp2.getSelectedIndex() == 3) {
					cajaResultado.setText(String.valueOf(CT.FAR(Double.parseDouble(cajaGradosC.getText()))));
				}
			}else if(comboTemp1.getSelectedIndex() == 3) {
				if(comboTemp2.getSelectedIndex() == 1) {
					cajaResultado.setText(String.valueOf(CT.KAC(Double.parseDouble(cajaGradosC.getText()))));
				}else if(comboTemp2.getSelectedIndex() == 2) {
					cajaResultado.setText(String.valueOf(CT.KAF(Double.parseDouble(cajaGradosC.getText()))));
				}else if(comboTemp2.getSelectedIndex() == 3) {
					cajaResultado.setText(String.valueOf(CT.KAR(Double.parseDouble(cajaGradosC.getText()))));
				}
			}else if(comboTemp1.getSelectedIndex() == 4) {
				if(comboTemp2.getSelectedIndex() == 1) {
					cajaResultado.setText(String.valueOf(CT.RAC(Double.parseDouble(cajaGradosC.getText()))));
				}else if(comboTemp2.getSelectedIndex() == 2) {
					cajaResultado.setText(String.valueOf(CT.RAF(Double.parseDouble(cajaGradosC.getText()))));
				}else if(comboTemp2.getSelectedIndex() == 3) {
					cajaResultado.setText(String.valueOf(CT.RAK(Double.parseDouble(cajaGradosC.getText()))));
				}
			}
			x2 = 0;
		}
	}
	
	public VentanaInicio() {
		
		getContentPane().setLayout(gbl);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Conversor Temperaturas");
		setLocationRelativeTo(null);
		setVisible(true);
		setResizable(false);
		
		JLabel txtConversor = new JLabel("Conversor Temperaturas");
		txtConversor.setFont(font1);
		metodoMagicoQueAcomodaTodo(txtConversor, 0, 0, 3, 1);
		
		cajaGradosC = new JTextField();
		cajaGradosC.setFont(font1);
		cajaGradosC.addKeyListener(this);
		metodoMagicoQueAcomodaTodo(cajaGradosC, 0, 1, 1, 1);
		
		JLabel txtConvertirA = new JLabel("A: ");
		
		metodoMagicoQueAcomodaTodo(txtConvertirA, 0, 2, 1, 1);
		
		comboTemp1 = new JComboBox<String>();
		comboTemp1.setEnabled(false);
		
		comboTemp1.addItem("Selecciona....");
		comboTemp1.addItem("°C");
		comboTemp1.addItem("°F");
		comboTemp1.addItem("°K");
		comboTemp1.addItem("°R");
		comboTemp1.addActionListener(this);
		metodoMagicoQueAcomodaTodo(comboTemp1, 1, 1, 2, 1);

		comboTemp2 = new JComboBox<String>();
		comboTemp2.setEnabled(false);
		
		comboTemp2.addActionListener(this);
		metodoMagicoQueAcomodaTodo(comboTemp2, 1, 2, 2, 1);
		
		JLabel txtResultado = new JLabel("Resultado: ");
		metodoMagicoQueAcomodaTodo(txtResultado, 0, 3, 1, 1);
		
		
		cajaResultado = new JTextField();
		cajaResultado.setEditable(false);
		cajaResultado.setFont(font1);
		metodoMagicoQueAcomodaTodo(cajaResultado, 1, 3, 2, 1);
		
		pack();
		
	}
	
	public void metodoMagicoQueAcomodaTodo(Component c, int x, int y, int w, int h) {
		gbc.gridx = x;
		gbc.gridy = y;
		
		gbc.gridwidth = w;
		gbc.gridheight = h;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbl.setConstraints(c, gbc);
		add(c);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		int c = e.getKeyChar();
		if(!(c=='0'||c=='1'||c=='2'||c=='3'||c=='4'||c=='5'||c=='6'||c=='7'||c=='8'||c=='9'||c=='.'||c=='-')) { 
			e.consume();
		}else {
			if(c=='.') {
				if(cajaGradosC.getText().length()==0) {
					e.consume();
				}else if(cajaGradosC.getText().length()==1) {
					if(cajaGradosC.getText().charAt(0)=='-') {
						e.consume();
					}
				}else if(punt != 0) {
					e.consume();
				}else {
					punt = 1;
				}
			}
			if(c=='-') {
				if(cajaGradosC.getText().length()!=0) {
					e.consume();
				}
			}
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		//System.out.println(e.getKeyChar());
		//System.out.println(e.getKeyCode());

		
		if(!cajaGradosC.getText().contains(".")) {
			punt = 0;
		}
		if(cajaGradosC.getText().length()==0) {
			comboTemp1.setEnabled(false);
			comboTemp2.setEnabled(false);
			cajaResultado.setText("");
		}else if(cajaGradosC.getText().charAt(0)!='-' || (cajaGradosC.getText().charAt(0)=='-' && cajaGradosC.getText().length()>=2)) {
			comboTemp1.setEnabled(true);
			comboTemp2.setEnabled(true);
		}else {
			comboTemp1.setEnabled(false);
			comboTemp2.setEnabled(false);
		}
	}
}

public class pruebaConversorT {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {				
				new VentanaInicio();
			}
		});
	}
}
