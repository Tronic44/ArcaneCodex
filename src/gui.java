import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;

public class gui {

	JFrame frame;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Create the application.
	 */
	public gui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1599, 900);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 186, 850);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(20, 14, 122, 20);
		panel.add(comboBox);
		
		JLabel lblNewLabel = new JLabel("Belastung");
		lblNewLabel.setBounds(10, 45, 65, 14);
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(85, 42, 86, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblWundgrad = new JLabel("Wundgrad");
		lblWundgrad.setBounds(38, 123, 76, 14);
		panel.add(lblWundgrad);
		
		JButton btnNewButton = new JButton("Berechne Init");
		btnNewButton.setBounds(20, 68, 122, 23);
		panel.add(btnNewButton);
		
		textField_1 = new JTextField();
		textField_1.setBounds(67, 92, 33, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Angeschlagen");
		rdbtnNewRadioButton.setBounds(10, 144, 109, 23);
		panel.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnVerletzt = new JRadioButton("Verletzt");
		rdbtnVerletzt.setBounds(10, 167, 109, 23);
		panel.add(rdbtnVerletzt);
		
		JRadioButton rdbtnVerwundet = new JRadioButton("Verwundet");
		rdbtnVerwundet.setBounds(10, 189, 109, 23);
		panel.add(rdbtnVerwundet);
		
		JRadioButton rdbtnSchwerVerwundet = new JRadioButton("Schwer verwundet");
		rdbtnSchwerVerwundet.setBounds(10, 215, 132, 23);
		panel.add(rdbtnSchwerVerwundet);
		
		JRadioButton rdbtnAuerGefecht = new JRadioButton("Außer Gefecht");
		rdbtnAuerGefecht.setBounds(10, 238, 109, 23);
		panel.add(rdbtnAuerGefecht);
		
		JRadioButton rdbtnKoma = new JRadioButton("Koma");
		rdbtnKoma.setBounds(10, 263, 109, 23);
		panel.add(rdbtnKoma);
	}
}
