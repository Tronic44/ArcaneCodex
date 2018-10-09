import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.PopupMenuEvent;

import org.json.JSONException;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class CharPanel extends JPanel {

	JPanel panel;
	private JTextField tFfinalinit;
	private JTextField tFfinalAngriffManöver;
	private JTextField tFRuestung;
	private JTextField tFSchockresistenz;
	private JTextField tFGeistigerWiderstand;
	private JTextField Verteidigungswert;
	private JTextField tFAngriffboni;
	private JTextField tFSchadensboni;
	private JTextField tFfinalSchadenManöver;
	private String cBCharselect;
	private JTextField tFWaffenAngriff;
	private JTextField tFWaffenSchaden;
	private JTextField tfKampfmodiAngriff;
	private JTextField tfKampfmodiSchaden;
	private int charinit;
	private int kampftechnikeninitbonus;
	private int geschicklichkeitsbonus;
	private int wahrnehmnungsbonus;
	private char größenklasse;
	private int konstitutionsbonus;
	private int stärkebonus;
	private int willenskraftbonus;
	private int intelligenzbonus;
	private int[] waffenfertigkeitsboni;
	private int waffenfertigkeitsbonus;


	private void initChar(String player,JFrame frame) {
		try {
			charinit = Reader.getCharinit(player);
			kampftechnikeninitbonus = Reader.getKampftechnikeninitbonus(player);
			geschicklichkeitsbonus = Reader.getGeschicklichkeitsbonus(player);
			wahrnehmnungsbonus = Reader.getWahrnehmnungsbonus(player);
			größenklasse = Reader.getGrößenklasse(player);
			konstitutionsbonus = Reader.getKonstitutionsbonus(player);
			stärkebonus = Reader.getStärkebonus(player);
			willenskraftbonus = Reader.getWillenskraftbonus(player);
			intelligenzbonus = Reader.getIntelligenzbonus(player);
			waffenfertigkeitsboni = Reader.getWaffenfertigkeitsbonus(player);

		} catch (JSONException e) {
			JOptionPane.showMessageDialog(frame,
					e.toString() + "\n" + "Du solltest nach einer Änderung der JSON Datei das Prgrogramm neustarten",
					"Da ist was schief gelaufen", JOptionPane.ERROR_MESSAGE);
		}
	}

	public CharPanel(JFrame frame) {

		panel = new JPanel();
		tFfinalinit = new JTextField();
		tFfinalAngriffManöver = new JTextField();
		tFRuestung = new JTextField();
		tFfinalSchadenManöver = new JTextField();
		tFWaffenAngriff = new JTextField();
		tFWaffenSchaden = new JTextField();
		tfKampfmodiAngriff = new JTextField();
		tfKampfmodiSchaden = new JTextField();
		tFSchockresistenz = new JTextField();
		tFGeistigerWiderstand = new JTextField();
		Verteidigungswert = new JTextField();
		tFAngriffboni = new JTextField();
		tFSchadensboni = new JTextField();
		initpanelcompents();

//		JComboBox<String> cBchangeChar = new JComboBox<String>(Reader.getList());
		JComboBox cBchangeChar = new JComboBox(Reader.getList());
		cBchangeChar.setBackground(Color.WHITE);
		cBchangeChar.setBounds(8, 11, 156, 20);
		cBchangeChar.addPopupMenuListener(new PopupListener(cBchangeChar) {
			public void popupMenuWillBecomeInvisible(PopupMenuEvent arg0) {
				if (cBchangeChar.getSelectedItem() == null) {
					return;
				}
				if (cBCharselect == null) {
					cBCharselect = cBchangeChar.getSelectedItem().toString();
					initChar(cBchangeChar.getSelectedItem().toString(),frame);
				}
				if (!cBchangeChar.getSelectedItem().toString().equals(cBCharselect)) {
					cBCharselect = cBchangeChar.getSelectedItem().toString();
					initChar(cBchangeChar.getSelectedItem().toString(),frame);
				}
			}
		});
		cBchangeChar.setSelectedIndex(-1);
		panel.add(cBchangeChar);

		JButton btnInit = new JButton("Init");
		btnInit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tFfinalinit.setText("" + (1 + charinit + (int) (Math.random() * 10)));
			}
		});
		btnInit.setBounds(19, 485, 86, 20);
		panel.add(btnInit);

		JButton btnKampfmodi = new JButton("Kampfmodi");
		btnKampfmodi.setBounds(7, 239, 103, 23);
		panel.add(btnKampfmodi);

		JButton btnManvöer = new JButton("Manöver");
		btnManvöer.setBounds(7, 271, 103, 23);
		panel.add(btnManvöer);

//		JComboBox<String> cBWundgrad = new JComboBox<String>(new String[] { "Gesund", "Angeschlagen", "Verletzt",
		JComboBox cBWundgrad = new JComboBox(new String[] { "Gesund", "Angeschlagen", "Verletzt",

				"Verwundet", "Schwer verwundet", "Außer Gefecht" });
		cBWundgrad.setBounds(70, 99, 95, 20);
		panel.add(cBWundgrad);

//		JComboBox<String> cBKampfart = new JComboBox<String>(
		JComboBox cBKampfart = new JComboBox(new String[] { "Angreifen", "Abblocken", "Parieren", "Ausweichen" });
		cBKampfart.setBounds(70, 127, 95, 20);
		panel.add(cBKampfart);

		JButton btnWaffe = new JButton("Waffe");
		btnWaffe.setBounds(7, 305, 103, 23);
		panel.add(btnWaffe);

		JButton btnRstung = new JButton("Rüstung");
		btnRstung.setBounds(8, 67, 103, 23);
		panel.add(btnRstung);

		JSpinner spMehrfachaktion = new JSpinner();
		spMehrfachaktion.setBounds(120, 208, 47, 20);
		spMehrfachaktion.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				if ((int) spMehrfachaktion.getValue() < 0) {
					spMehrfachaktion.setValue(0);
				} else {
					if ((int) spMehrfachaktion.getValue() > 9) {
						spMehrfachaktion.setValue(9);
					}
				}
			}
		});
		panel.add(spMehrfachaktion);

		JSpinner spKP = new JSpinner();
		spKP.setBounds(120, 155, 47, 20);
		spKP.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				if ((int) spKP.getValue() < 0) {
					spKP.setValue(0);
				} else {
					if ((int) spKP.getValue() > 20) {
						spKP.setValue(20);
					}
				}
			}
		});
		panel.add(spKP);

		JSpinner spErfolge = new JSpinner();
		spErfolge.setBounds(120, 181, 47, 20);
		spErfolge.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				if ((int) spErfolge.getValue() < 0) {
					spErfolge.setValue(0);
				} else {
					if ((int) spErfolge.getValue() > 999) {
						spErfolge.setValue(999);
					}
				}
			}
		});
		panel.add(spErfolge);

		JSpinner spSonstigesSchaden = new JSpinner();
		spSonstigesSchaden.setBounds(130, 335, 37, 20);
		spSonstigesSchaden.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				if ((int) spSonstigesSchaden.getValue() < -99) {
					spSonstigesSchaden.setValue(-99);
				} else {
					if ((int) spSonstigesSchaden.getValue() > 99) {
						spSonstigesSchaden.setValue(99);
					}
				}
			}
		});
		panel.add(spSonstigesSchaden);

		JSpinner spLP = new JSpinner();
		spLP.setBounds(120, 37, 47, 20);
		spLP.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				if ((int) spLP.getValue() < 0) {
					spLP.setValue(0);
				} else {
					if ((int) spLP.getValue() > 999) {
						spLP.setValue(999);
					}
				}
			}
		});
		panel.add(spLP);

		JSpinner spSonstigesAngriff = new JSpinner();
		spSonstigesAngriff.setBounds(92, 335, 37, 20);
		spSonstigesAngriff.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				if ((int) spSonstigesAngriff.getValue() < -99) {
					spSonstigesAngriff.setValue(0);
				} else {
					if ((int) spSonstigesAngriff.getValue() > 99) {
						spSonstigesAngriff.setValue(99);
					}
				}
			}
		});
		panel.add(spSonstigesAngriff);

		JButton btnBerechne = new JButton("Berechne");
		btnBerechne.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tFAngriffboni.setText(" " + (waffenfertigkeitsbonus + (int) spKP.getValue()
						+ Integer.parseInt(tfKampfmodiAngriff.getText())
						+ Integer.parseInt(tFfinalAngriffManöver.getText()) + (int) spSonstigesAngriff.getValue()
						- (int) spErfolge.getValue() - (4 * (int) spMehrfachaktion.getValue())));
				tFSchadensboni.setText("" + (Integer.parseInt(tfKampfmodiSchaden.getText()) + stärkebonus
						+ (int) spErfolge.getValue() - Integer.parseInt(tFRuestung.getText())
						+ Integer.parseInt(tFfinalSchadenManöver.getText())));
			}
		});
		btnBerechne.setBounds(23, 363, 127, 23);
		panel.add(btnBerechne);

		// Das ausklammern, um das Panel im Editor zu bearbeiten
		add(panel);
	}

	private void initpanelcompents() {

		panel.setBackground(new Color(255, 255, 225));
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(0, 0, 173, 516);
		panel.setLayout(null);

		JLabel lblWundgrad = new JLabel("Wundgrad");
		lblWundgrad.setBounds(7, 102, 65, 14);
		panel.add(lblWundgrad);

		tFfinalinit.setBackground(Color.WHITE);
		tFfinalinit.setEditable(false);
		tFfinalinit.setBounds(123, 485, 33, 20);
		panel.add(tFfinalinit);

		JLabel lblKp = new JLabel("KP");
		lblKp.setBounds(7, 158, 33, 14);
		panel.add(lblKp);

		tFfinalAngriffManöver.setText("0");
		tFfinalAngriffManöver.setBackground(Color.WHITE);
		tFfinalAngriffManöver.setEditable(false);
		tFfinalAngriffManöver.setColumns(1);
		tFfinalAngriffManöver.setBounds(120, 272, 20, 20);
		panel.add(tFfinalAngriffManöver);

		JLabel lblErfolge = new JLabel("Erfolge");
		lblErfolge.setBounds(7, 184, 47, 14);
		panel.add(lblErfolge);

		JLabel lblKampfart = new JLabel("Kampfart");
		lblKampfart.setBounds(7, 130, 65, 14);
		panel.add(lblKampfart);

		tFRuestung.setText("0");
		tFRuestung.setBackground(Color.WHITE);
		tFRuestung.setEditable(false);
		tFRuestung.setBounds(120, 68, 47, 20);
		panel.add(tFRuestung);

		JLabel lblMehrfachaktion = new JLabel("Mehrfachaktionen");
		lblMehrfachaktion.setBounds(7, 208, 113, 20);
		panel.add(lblMehrfachaktion);

		JLabel lblSchockresistenz = new JLabel("SR");
		lblSchockresistenz.setBounds(70, 431, 33, 20);
		panel.add(lblSchockresistenz);

		JLabel lblGeistigerWiderstand = new JLabel("GW");
		lblGeistigerWiderstand.setBounds(121, 431, 33, 20);
		panel.add(lblGeistigerWiderstand);

		tFSchockresistenz.setBackground(Color.WHITE);
		tFSchockresistenz.setEditable(false);
		tFSchockresistenz.setBounds(70, 453, 33, 20);
		panel.add(tFSchockresistenz);

		tFGeistigerWiderstand.setBackground(Color.WHITE);
		tFGeistigerWiderstand.setEditable(false);
		tFGeistigerWiderstand.setColumns(10);
		tFGeistigerWiderstand.setBounds(121, 453, 33, 20);
		panel.add(tFGeistigerWiderstand);

		Verteidigungswert.setBackground(Color.WHITE);
		Verteidigungswert.setEditable(false);
		Verteidigungswert.setColumns(10);
		Verteidigungswert.setBounds(19, 453, 33, 20);
		panel.add(Verteidigungswert);

		JLabel lblVerteidigungswert = new JLabel("VW");
		lblVerteidigungswert.setBounds(19, 431, 33, 20);
		panel.add(lblVerteidigungswert);

		tFAngriffboni.setBackground(Color.WHITE);
		tFAngriffboni.setEditable(false);
		tFAngriffboni.setBounds(92, 390, 37, 20);
		panel.add(tFAngriffboni);

		tFSchadensboni.setBackground(Color.WHITE);
		tFSchadensboni.setEditable(false);
		tFSchadensboni.setBounds(130, 411, 37, 20);
		panel.add(tFSchadensboni);

		JLabel lblSonstiges = new JLabel("Sonstiges");
		lblSonstiges.setBounds(8, 338, 77, 14);
		panel.add(lblSonstiges);

		JLabel lblAngriffboni = new JLabel("Angriffsboni:");
		lblAngriffboni.setBounds(8, 396, 93, 14);
		panel.add(lblAngriffboni);

		JLabel lblSchadensboni = new JLabel("Schadensboni:");
		lblSchadensboni.setBounds(8, 417, 90, 14);
		panel.add(lblSchadensboni);

		JLabel lblLebenspunkte = new JLabel("Lebenspunkte");
		lblLebenspunkte.setBounds(7, 40, 98, 14);
		panel.add(lblLebenspunkte);

		tFfinalSchadenManöver.setText("0");
		tFfinalSchadenManöver.setEditable(false);
		tFfinalSchadenManöver.setColumns(1);
		tFfinalSchadenManöver.setBackground(Color.WHITE);
		tFfinalSchadenManöver.setBounds(144, 272, 20, 20);
		panel.add(tFfinalSchadenManöver);

		tFWaffenAngriff.setText("0");
		tFWaffenAngriff.setEditable(false);
		tFWaffenAngriff.setColumns(1);
		tFWaffenAngriff.setBackground(Color.WHITE);
		tFWaffenAngriff.setBounds(120, 306, 20, 20);
		panel.add(tFWaffenAngriff);

		tFWaffenSchaden.setText("0");
		tFWaffenSchaden.setEditable(false);
		tFWaffenSchaden.setColumns(1);
		tFWaffenSchaden.setBackground(Color.WHITE);
		tFWaffenSchaden.setBounds(144, 306, 20, 20);
		panel.add(tFWaffenSchaden);

		tfKampfmodiAngriff.setText("0");
		tfKampfmodiAngriff.setEditable(false);
		tfKampfmodiAngriff.setColumns(1);
		tfKampfmodiAngriff.setBackground(Color.WHITE);
		tfKampfmodiAngriff.setBounds(120, 240, 20, 20);
		panel.add(tfKampfmodiAngriff);

		tfKampfmodiSchaden.setText("0");
		tfKampfmodiSchaden.setEditable(false);
		tfKampfmodiSchaden.setColumns(1);
		tfKampfmodiSchaden.setBackground(Color.WHITE);
		tfKampfmodiSchaden.setBounds(144, 240, 20, 20);
		panel.add(tfKampfmodiSchaden);
	}

}
