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
	private JTextField tFSchockresistenz;
	private JTextField tFGeistigerWiderstand;
	private JTextField tFVerteidigungswert;
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
	private static int[] rüstung;
	private static JTextField tFRüstungsschutz;
	private static JTextField tFBelastung;
	private JTextField tFSchadensschutz;

	private void initChar(String player, JFrame frame) {
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
		tFfinalSchadenManöver = new JTextField();
		tFSchadensschutz = new JTextField();
		tFWaffenAngriff = new JTextField();
		tFWaffenSchaden = new JTextField();
		tfKampfmodiAngriff = new JTextField();
		tfKampfmodiSchaden = new JTextField();
		tFSchockresistenz = new JTextField();
		tFGeistigerWiderstand = new JTextField();
		tFVerteidigungswert = new JTextField();
		tFAngriffboni = new JTextField();
		tFSchadensboni = new JTextField();
		tFRüstungsschutz = new JTextField();
		tFBelastung = new JTextField();
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
					initChar(cBchangeChar.getSelectedItem().toString(), frame);
				}
				if (!cBchangeChar.getSelectedItem().toString().equals(cBCharselect)) {
					cBCharselect = cBchangeChar.getSelectedItem().toString();
					initChar(cBchangeChar.getSelectedItem().toString(), frame);
				}
			}
		});
		cBchangeChar.setSelectedIndex(-1);
		panel.add(cBchangeChar);

		JButton btnInit = new JButton("Init");
		btnInit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tFfinalinit.setText(
						"" + (1 + charinit + Integer.parseInt(tFBelastung.getText()) + (int) (Math.random() * 10)));
			}
		});
		btnInit.setBounds(19, 485, 86, 20);
		panel.add(btnInit);

		JButton btnKampfmodi = new JButton("Kampfmodi");
		btnKampfmodi.setBounds(7, 210, 103, 23);
		panel.add(btnKampfmodi);

		JButton btnManvöer = new JButton("Manöver");
		btnManvöer.setBounds(7, 240, 103, 23);
		panel.add(btnManvöer);

//		JComboBox<String> cBWundgrad = new JComboBox<String>(new String[] { "Gesund", "Angeschlagen", "Verletzt",
		JComboBox cBWundgrad = new JComboBox(new String[] { "Gesund", "Angeschlagen", "Verletzt",

				"Verwundet", "Schwer verwundet", "Außer Gefecht" });
		cBWundgrad.setBounds(70, 87, 95, 20);
		panel.add(cBWundgrad);

//		JComboBox<String> cBKampfart = new JComboBox<String>(
		JComboBox cBKampfart = new JComboBox(new String[] { "Angreifen", "Abblocken", "Parieren", "Ausweichen" });
		cBKampfart.setBounds(70, 110, 95, 20);
		panel.add(cBKampfart);

		JButton btnWaffe = new JButton("Waffe");
		btnWaffe.setBounds(7, 270, 103, 23);
		panel.add(btnWaffe);

		JButton btnRstung = new JButton("Rüstung");
		btnRstung.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				RüstungPanel.initRüstungPanel(stärkebonus);
			}
		});
		btnRstung.setBounds(8, 60, 103, 23);
		panel.add(btnRstung);

		JSpinner spMehrfachaktion = new JSpinner();
		spMehrfachaktion.setToolTipText("Anzahl der Mehrfachaktionen");
		spMehrfachaktion.setBounds(120, 185, 47, 20);
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
		spKP.setToolTipText("KP");
		spKP.setBounds(120, 138, 47, 20);
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
		spErfolge.setToolTipText("Erfolge");
		spErfolge.setBounds(120, 162, 47, 20);
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
		spSonstigesSchaden.setBounds(130, 297, 37, 20);
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
		spLP.setToolTipText("Lebenspunkte");
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
		spSonstigesAngriff.setBounds(92, 297, 37, 20);
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

		JSpinner spVW = new JSpinner();
		spVW.setBounds(15, 430, 37, 20);
		spVW.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				if ((int) spVW.getValue() < -99) {
					spVW.setValue(-99);
				} else {
					if ((int) spVW.getValue() > 99) {
						spVW.setValue(99);
					}
				}
			}
		});
		panel.add(spVW);

		JSpinner spSR = new JSpinner();
		spSR.setBounds(67, 430, 37, 20);
		spSR.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				if ((int) spSR.getValue() < -99) {
					spSR.setValue(-99);
				} else {
					if ((int) spSR.getValue() > 99) {
						spSR.setValue(99);
					}
				}
			}
		});
		panel.add(spSR);

		JSpinner spGW = new JSpinner();
		spGW.setBounds(119, 430, 37, 20);
		spGW.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				if ((int) spGW.getValue() < -99) {
					spGW.setValue(-99);
				} else {
					if ((int) spGW.getValue() > 99) {
						spGW.setValue(99);
					}
				}
			}
		});

		JButton btnBerechne = new JButton("Berechne");
		btnBerechne.setToolTipText("Berechnet die unten Stehenden Werte");
		btnBerechne.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tFAngriffboni.setText(" " + (waffenfertigkeitsbonus + (int) spKP.getValue()
						+ Integer.parseInt(tfKampfmodiAngriff.getText())
						+ Integer.parseInt(tFfinalAngriffManöver.getText()) + (int) spSonstigesAngriff.getValue()
						- (int) spErfolge.getValue() - (4 * (int) spMehrfachaktion.getValue())));
				tFSchadensboni.setText("" + (Integer.parseInt(tfKampfmodiSchaden.getText()) + stärkebonus
						+ (int) spErfolge.getValue() + Integer.parseInt(tFfinalSchadenManöver.getText())));
				tFSchadensschutz.setText("" + Integer.parseInt(tFRüstungsschutz.getText()));
				tFVerteidigungswert
						.setText("" + (14 + geschicklichkeitsbonus + wahrnehmnungsbonus + (int) spVW.getValue()));
				tFGeistigerWiderstand.setText("" + (14 + konstitutionsbonus + stärkebonus + (int) spGW.getValue()));
				tFSchockresistenz.setText("" + (14 + willenskraftbonus + intelligenzbonus + (int) spSR.getValue()));
			}
		});
		btnBerechne.setBounds(23, 320, 127, 23);
		panel.add(btnBerechne);

		panel.add(spGW);

		// Das ausklammern, um das Panel im Editor zu bearbeiten
		add(panel);
	}

	protected static void setRüstung(int[] rs) {
		rüstung = rs;
		tFRüstungsschutz.setText(rüstung[0] + "");
		tFBelastung.setText(rüstung[1] + "");

	}

	private void initpanelcompents() {

		panel.setBackground(new Color(255, 255, 225));
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(0, 0, 173, 516);
		panel.setLayout(null);

		JLabel lblWundgrad = new JLabel("Wundgrad");
		lblWundgrad.setBounds(7, 90, 65, 14);
		panel.add(lblWundgrad);

		tFfinalinit.setBackground(Color.WHITE);
		tFfinalinit.setEditable(false);
		tFfinalinit.setBounds(123, 485, 33, 20);
		panel.add(tFfinalinit);

		JLabel lblKp = new JLabel("KP");
		lblKp.setBounds(7, 141, 33, 14);
		panel.add(lblKp);

		JLabel lblSchadensminderung = new JLabel("Schadensminderung:");
		lblSchadensminderung.setBounds(7, 390, 132, 14);
		panel.add(lblSchadensminderung);

		tFSchadensschutz.setToolTipText("Die Verminderung des Schadens ( Rüstungsschutz)");
		tFSchadensschutz.setEditable(false);
		tFSchadensschutz.setBackground(Color.WHITE);
		tFSchadensschutz.setBounds(129, 387, 37, 20);
		panel.add(tFSchadensschutz);

		tFfinalAngriffManöver.setText("0");
		tFfinalAngriffManöver.setBackground(Color.WHITE);
		tFfinalAngriffManöver.setEditable(false);
		tFfinalAngriffManöver.setColumns(1);
		tFfinalAngriffManöver.setBounds(120, 241, 20, 20);
		panel.add(tFfinalAngriffManöver);

		JLabel lblErfolge = new JLabel("Erfolge");
		lblErfolge.setBounds(7, 165, 47, 14);
		panel.add(lblErfolge);

		JLabel lblKampfart = new JLabel("Kampfart");
		lblKampfart.setBounds(7, 113, 65, 14);
		panel.add(lblKampfart);

		JLabel lblMehrfachaktion = new JLabel("Mehrfachaktionen");
		lblMehrfachaktion.setBounds(7, 185, 113, 20);
		panel.add(lblMehrfachaktion);

		JLabel lblSchockresistenz = new JLabel("SR");
		lblSchockresistenz.setToolTipText("Schockresistenz");
		lblSchockresistenz.setBounds(76, 410, 20, 20);
		panel.add(lblSchockresistenz);

		JLabel lblGeistigerWiderstand = new JLabel("GW");
		lblGeistigerWiderstand.setToolTipText("Geistiger Widerstand");
		lblGeistigerWiderstand.setBounds(124, 410, 20, 20);
		panel.add(lblGeistigerWiderstand);

		tFSchockresistenz.setBackground(Color.WHITE);
		tFSchockresistenz.setEditable(false);
		tFSchockresistenz.setBounds(70, 453, 30, 20);
		panel.add(tFSchockresistenz);

		tFGeistigerWiderstand.setBackground(Color.WHITE);
		tFGeistigerWiderstand.setEditable(false);
		tFGeistigerWiderstand.setColumns(10);
		tFGeistigerWiderstand.setBounds(120, 453, 30, 20);
		panel.add(tFGeistigerWiderstand);

		tFVerteidigungswert.setBackground(Color.WHITE);
		tFVerteidigungswert.setEditable(false);
		tFVerteidigungswert.setColumns(10);
		tFVerteidigungswert.setBounds(20, 453, 30, 20);
		panel.add(tFVerteidigungswert);

		JLabel lblVerteidigungswert = new JLabel("VW");
		lblVerteidigungswert.setToolTipText("Verteidigungswert");
		lblVerteidigungswert.setBounds(28, 410, 20, 20);
		panel.add(lblVerteidigungswert);

		tFAngriffboni.setBackground(Color.WHITE);
		tFAngriffboni.setEditable(false);
		tFAngriffboni.setBounds(91, 347, 37, 20);
		panel.add(tFAngriffboni);

		tFSchadensboni.setBackground(Color.WHITE);
		tFSchadensboni.setEditable(false);
		tFSchadensboni.setBounds(129, 367, 37, 20);
		panel.add(tFSchadensboni);

		JLabel lblSonstiges = new JLabel("Sonstiges");
		lblSonstiges.setBounds(8, 300, 77, 14);
		panel.add(lblSonstiges);

		JLabel lblAngriffboni = new JLabel("Angriffsboni:");
		lblAngriffboni.setBounds(7, 350, 93, 14);
		panel.add(lblAngriffboni);

		JLabel lblSchadensboni = new JLabel("Schadensboni:");
		lblSchadensboni.setBounds(7, 370, 93, 14);
		panel.add(lblSchadensboni);

		JLabel lblLebenspunkte = new JLabel("Lebenspunkte");
		lblLebenspunkte.setBounds(7, 40, 98, 14);
		panel.add(lblLebenspunkte);

		tFfinalSchadenManöver.setText("0");
		tFfinalSchadenManöver.setEditable(false);
		tFfinalSchadenManöver.setColumns(1);
		tFfinalSchadenManöver.setBackground(Color.WHITE);
		tFfinalSchadenManöver.setBounds(144, 241, 20, 20);
		panel.add(tFfinalSchadenManöver);

		tFWaffenAngriff.setText("0");
		tFWaffenAngriff.setEditable(false);
		tFWaffenAngriff.setColumns(1);
		tFWaffenAngriff.setBackground(Color.WHITE);
		tFWaffenAngriff.setBounds(120, 271, 20, 20);
		panel.add(tFWaffenAngriff);

		tFWaffenSchaden.setText("0");
		tFWaffenSchaden.setEditable(false);
		tFWaffenSchaden.setColumns(1);
		tFWaffenSchaden.setBackground(Color.WHITE);
		tFWaffenSchaden.setBounds(144, 271, 20, 20);
		panel.add(tFWaffenSchaden);

		tfKampfmodiAngriff.setText("0");
		tfKampfmodiAngriff.setEditable(false);
		tfKampfmodiAngriff.setColumns(1);
		tfKampfmodiAngriff.setBackground(Color.WHITE);
		tfKampfmodiAngriff.setBounds(120, 211, 20, 20);
		panel.add(tfKampfmodiAngriff);

		tfKampfmodiSchaden.setText("0");
		tfKampfmodiSchaden.setEditable(false);
		tfKampfmodiSchaden.setColumns(1);
		tfKampfmodiSchaden.setBackground(Color.WHITE);
		tfKampfmodiSchaden.setBounds(144, 211, 20, 20);
		panel.add(tfKampfmodiSchaden);

		tFBelastung.setText("0");
		tFBelastung.setEditable(false);
		tFBelastung.setColumns(1);
		tFBelastung.setBackground(Color.WHITE);
		tFBelastung.setBounds(144, 61, 20, 20);
		panel.add(tFBelastung);

		tFRüstungsschutz.setText("0");
		tFRüstungsschutz.setEditable(false);
		tFRüstungsschutz.setColumns(1);
		tFRüstungsschutz.setBackground(Color.WHITE);
		tFRüstungsschutz.setBounds(120, 61, 20, 20);
		panel.add(tFRüstungsschutz);

		tFfinalinit.setToolTipText("Initative");
		tFfinalAngriffManöver.setToolTipText("Angriffsbonus vom Manöver");
		tFfinalSchadenManöver.setToolTipText("Schadenssbonus vom Manöver");
		tFWaffenAngriff.setToolTipText("Angriffsbonus von der Waffe");
		tFWaffenSchaden.setToolTipText("Schadenssbonus von der Waffe");
		tfKampfmodiAngriff.setToolTipText("Angriffsbonus durch den Kampfmodus");
		tfKampfmodiSchaden.setToolTipText("Schadensbonus durch den Kampfmodus");
		tFSchockresistenz.setToolTipText("Schockresistenz");
		tFGeistigerWiderstand.setToolTipText("Geistiger Widerstand");
		tFVerteidigungswert.setToolTipText("Verteidigungswert");
		tFAngriffboni.setToolTipText("Der Bonus für dein Angriffswurf");
		tFSchadensboni.setToolTipText("Der Bonus für den Schadenswurf");
		tFRüstungsschutz.setToolTipText("Rüstungsschutz");
		tFBelastung.setToolTipText("Belastung");
		tFBelastung.setToolTipText("Belastung");

	}
}
