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

public class gui extends JFrame implements ActionListener{

	JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	
	private JTextField tFcountFighters;
	private JButton starteProgramm;

	/**
	 * Create the application.
	 */
	public gui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * Mein Plan wäre, dass erst ein Fenster erscheint wo man eingeben soll, wie viele Kämpfer am Kampf teilnehmen und dann mit dem Bestätigen erscheint ein
	 * neues Fenster mit der angegebenen Anzahl an Kämpferslots. In diese Kämpferslots können dann per Auswahl bestimmte Personen reingeladen oder neu erstellt
	 * werden. Dann muss man nurnoch auswählen, wer genau gegen wen kämpft und schon bekommt man die benötigten Mindestwerte angezeigt.
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
		comboBox.setBounds(32, 14, 122, 20);
		panel.add(comboBox);

		JLabel lblNewLabel = new JLabel("Belastung");
		lblNewLabel.setBounds(11, 45, 65, 14);
		panel.add(lblNewLabel);

		textField = new JTextField();
		textField.setBounds(87, 42, 86, 20);
		panel.add(textField);
		textField.setColumns(10);

		JLabel lblWundgrad = new JLabel("Wundgrad");
		lblWundgrad.setBounds(38, 123, 76, 14);
		panel.add(lblWundgrad);

		JButton btnNewButton = new JButton("Berechne Init");
		btnNewButton.setBounds(32, 68, 122, 23);
		panel.add(btnNewButton);

		textField_1 = new JTextField();
		textField_1.setBounds(76, 92, 33, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);

		ButtonGroup wundgrad = new ButtonGroup();

		JRadioButton rdbtnAngeschlagen = new JRadioButton("Angeschlagen");
		rdbtnAngeschlagen.setBounds(10, 144, 144, 23);
		panel.add(rdbtnAngeschlagen);
		wundgrad.add(rdbtnAngeschlagen);

		JRadioButton rdbtnVerletzt = new JRadioButton("Verletzt");
		rdbtnVerletzt.setBounds(10, 167, 144, 23);
		panel.add(rdbtnVerletzt);
		wundgrad.add(rdbtnVerletzt);

		JRadioButton rdbtnVerwundet = new JRadioButton("Verwundet");
		rdbtnVerwundet.setBounds(10, 189, 144, 23);
		panel.add(rdbtnVerwundet);
		wundgrad.add(rdbtnVerwundet);

		JRadioButton rdbtnSchwerVerwundet = new JRadioButton("Schwer verwundet");
		rdbtnSchwerVerwundet.setBounds(10, 215, 144, 23);
		panel.add(rdbtnSchwerVerwundet);
		wundgrad.add(rdbtnSchwerVerwundet);

		JRadioButton rdbtnAuerGefecht = new JRadioButton("Außer Gefecht");
		rdbtnAuerGefecht.setBounds(10, 238, 144, 23);
		panel.add(rdbtnAuerGefecht);
		wundgrad.add(rdbtnAuerGefecht);

		JRadioButton rdbtnKoma = new JRadioButton("Koma");
		rdbtnKoma.setBounds(10, 263, 144, 23);
		panel.add(rdbtnKoma);
		wundgrad.add(rdbtnKoma);

	}
	
	private void initializeFirstDialog(){
		frame = new JFrame();
		frame.setBounds(300, 300, 300, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 284, 262);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		tFcountFighters = new JTextField();
		tFcountFighters.setBounds(100, 100, 100, 30);
		panel.add(tFcountFighters);
		tFcountFighters.setColumns(10);
		
		JLabel lblFrage = new JLabel("Wie viele Kämpfer?");
		lblFrage.setBounds(100, 65, 106, 20);
		panel.add(lblFrage);
		
		starteProgramm = new JButton("weiter");
		starteProgramm.setBounds(100, 141, 100, 23);
		panel.add(starteProgramm);
		starteProgramm.addActionListener(this);
	}
	
	//das Objekt "FighterPanel" (noch nicht erstellt) was die GUI für einen Kämpfer ist wird erstellt und die werte werden abgefragt...
	//es bräuchte einen Array wo alle FPanels abgespeichert sind um darauf zugreifen zu können... Und einen Indexgleichen Array wo dann alle Kämpfer
	//(die Werte von ihnen) abgespeichert werden.
	private void initializeFighters(){
		
	}
	
	//ActionListener. Mehr nicht.
	public void actionPerformed (ActionEvent ae){
        if(ae.getSource() == this.starteProgramm){
            System.out.println("Button starteProgramm wurde gedrückt");
            System.out.println(tFcountFighters.getText());
        }
    }
}
