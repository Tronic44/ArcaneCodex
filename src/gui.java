import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JSpinner;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class gui extends JFrame {

	JFrame frame;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_7;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField tF_LP;

	/**
	 * Create the application.
	 */
	public gui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame. Mein Plan wäre, dass erst ein Fenster
	 * erscheint wo man eingeben soll, wie viele Kämpfer am Kampf teilnehmen und
	 * dann mit dem Bestätigen erscheint ein neues Fenster mit der angegebenen
	 * Anzahl an Kämpferslots. In diese Kämpferslots können dann per Auswahl
	 * bestimmte Personen reingeladen oder neu erstellt werden. Dann muss man
	 * nurnoch auswählen, wer genau gegen wen kämpft und schon bekommt man die
	 * benötigten Mindestwerte angezeigt.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 1599, 900);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(0, 0, 173, 516);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JComboBox<String> comboBox = new JComboBox(new String[] {"","Lo","Laxus","Krato","Ezaron","Temp1","Temp2"});
		comboBox.setBounds(7, 11, 103, 20);
		panel.add(comboBox);

		JLabel lblWundgrad = new JLabel("Wundgrad");
		lblWundgrad.setBounds(7, 80, 65, 14);
		panel.add(lblWundgrad);

		JButton btnNewButton = new JButton("Init");
		btnNewButton.setBounds(19, 485, 86, 20);
		panel.add(btnNewButton);

		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setBounds(123, 485, 33, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblKp = new JLabel("KP");
		lblKp.setBounds(19, 136, 33, 14);
		panel.add(lblKp);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(70, 133, 86, 20);
		panel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		textField_3.setBounds(118, 187, 47, 20);
		panel.add(textField_3);
		
		JButton btnNahkampfmodi = new JButton("Kampfmodi");
		btnNahkampfmodi.setBounds(8, 186, 103, 23);
		panel.add(btnNahkampfmodi);
		
		JButton btnManver = new JButton("Manöver");
		btnManver.setBounds(8, 218, 103, 23);
		panel.add(btnManver);
		
		textField_4 = new JTextField();
		textField_4.setEditable(false);
		textField_4.setColumns(10);
		textField_4.setBounds(118, 219, 47, 20);
		panel.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(70, 156, 86, 20);
		panel.add(textField_5);
		
		JLabel lblErfolge = new JLabel("Erfolge");
		lblErfolge.setBounds(18, 159, 47, 14);
		panel.add(lblErfolge);
		
		JComboBox<String> comboBox_1 = new JComboBox(new String[] {"Gesund","Angeschlagen","Verletzt","Verwundet","Schwer verwundet","Außer Gefecht"});
		comboBox_1.setBounds(70, 77, 95, 20);
		panel.add(comboBox_1);
	
		
		JLabel lblKampfart = new JLabel("Kampfart");
		lblKampfart.setBounds(7, 108, 65, 14);
		panel.add(lblKampfart);
		
		JComboBox<String> comboBox_2 = new JComboBox(new String[] {"Angreifen","Abblocken","Parieren","Ausweichen"});
		comboBox_2.setBounds(70, 105, 95, 20);
		panel.add(comboBox_2);
		
		JButton btnWaffe = new JButton("Waffe");
		btnWaffe.setBounds(7, 252, 103, 23);
		panel.add(btnWaffe);
		
		textField_6 = new JTextField();
		textField_6.setEditable(false);
		textField_6.setColumns(10);
		textField_6.setBounds(117, 253, 47, 20);
		panel.add(textField_6);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBounds(118, 46, 47, 20);
		panel.add(textField);
		
		JButton btnRstung = new JButton("Rüstung");
		btnRstung.setBounds(8, 45, 103, 23);
		panel.add(btnRstung);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(23, 286, 29, 20);
		panel.add(spinner);
		
		JLabel lblMehrfachaktion = new JLabel("Mehrfachaktion");
		lblMehrfachaktion.setBounds(75, 286, 90, 20);
		panel.add(lblMehrfachaktion);
		
		JLabel lblSr = new JLabel("SR");
		lblSr.setBounds(70, 431, 33, 20);
		panel.add(lblSr);
		
		JLabel lblGw = new JLabel("GW");
		lblGw.setBounds(121, 431, 33, 20);
		panel.add(lblGw);
		
		textField_8 = new JTextField();
		textField_8.setEditable(false);
		textField_8.setColumns(10);
		textField_8.setBounds(70, 453, 33, 20);
		panel.add(textField_8);
		
		textField_9 = new JTextField();
		textField_9.setEditable(false);
		textField_9.setColumns(10);
		textField_9.setBounds(121, 453, 33, 20);
		panel.add(textField_9);
		
		textField_7 = new JTextField();
		textField_7.setEditable(false);
		textField_7.setColumns(10);
		textField_7.setBounds(19, 453, 33, 20);
		panel.add(textField_7);
		
		JLabel lblVw = new JLabel("VW");
		lblVw.setBounds(19, 431, 33, 20);
		panel.add(lblVw);
		
		JButton btnBerechne = new JButton("Berechne");
		btnBerechne.setBounds(42, 345, 89, 23);
		panel.add(btnBerechne);
		
		JLabel lblSonstiges = new JLabel("Sonstiges");
		lblSonstiges.setBounds(16, 320, 77, 14);
		panel.add(lblSonstiges);
		
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setBounds(83, 317, 86, 20);
		panel.add(textField_10);
		
		textField_11 = new JTextField();
		textField_11.setEditable(false);
		textField_11.setColumns(10);
		textField_11.setBounds(118, 379, 47, 20);
		panel.add(textField_11);
		
		JLabel lblAngriffboni = new JLabel("Angriffsboni:");
		lblAngriffboni.setBounds(12, 382, 93, 14);
		panel.add(lblAngriffboni);
		
		textField_12 = new JTextField();
		textField_12.setEditable(false);
		textField_12.setColumns(10);
		textField_12.setBounds(118, 400, 47, 20);
		panel.add(textField_12);
		
		JLabel lblSchadensboni = new JLabel("Schadensboni:");
		lblSchadensboni.setBounds(12, 403, 77, 14);
		panel.add(lblSchadensboni);
		
		tF_LP = new JTextField();
		tF_LP.setColumns(10);
		tF_LP.setBounds(118, 11, 47, 20);
		panel.add(tF_LP);

		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JButton btnNewButton_1 = new JButton("Neuer Charakter");
		menuBar.add(btnNewButton_1);

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
