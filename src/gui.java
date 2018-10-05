import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;

public class gui {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gui window = new gui();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

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
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("New radio button");
		rdbtnNewRadioButton.setBounds(10, 144, 109, 23);
		panel.add(rdbtnNewRadioButton);
		
		JRadioButton radioButton = new JRadioButton("New radio button");
		radioButton.setBounds(10, 167, 109, 23);
		panel.add(radioButton);
		
		JRadioButton radioButton_1 = new JRadioButton("New radio button");
		radioButton_1.setBounds(10, 189, 109, 23);
		panel.add(radioButton_1);
		
		JRadioButton radioButton_2 = new JRadioButton("New radio button");
		radioButton_2.setBounds(10, 215, 109, 23);
		panel.add(radioButton_2);
		
		JRadioButton radioButton_3 = new JRadioButton("New radio button");
		radioButton_3.setBounds(10, 238, 109, 23);
		panel.add(radioButton_3);
		
		JRadioButton radioButton_4 = new JRadioButton("New radio button");
		radioButton_4.setBounds(10, 263, 109, 23);
		panel.add(radioButton_4);
		
		JRadioButton radioButton_5 = new JRadioButton("New radio button");
		radioButton_5.setBounds(10, 289, 109, 23);
		panel.add(radioButton_5);
	}
}
