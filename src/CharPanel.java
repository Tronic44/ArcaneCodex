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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SpinnerNumberModel;
import javax.swing.JSeparator;

@SuppressWarnings("serial")
public class CharPanel extends JPanel {

	JPanel panel;
	JTextField tFfinalinit;
	private JTextField tFSchockresistenz;
	private JTextField tFGeistigerWiderstand;
	private JTextField tFVerteidigungswert;
	private JTextField tFAngriffboni;
	private JTextField tFSchadensboni;
	private String cBCharselect;
	private JTextField tFWaffenAngriff;
	private JTextField tFWaffenSchaden;
	private JTextField tfKampfmodiAngriff;
	private JTextField tfKampfmodiSchaden;
	int charinit;
	int init;
	private int kampftechnikeninitbonus;
	private int geschicklichkeitsbonus;
	int wahrnehmnungsbonus;
	private char größenklasse;
	private int konstitutionsbonus;
	private int stärkebonus;
	private int willenskraftbonus;
	private int intelligenzbonus;
	private int[] waffenfertigkeitsboni;
	private int waffenfertigkeitsbonus;
	private int verteidigungswertbonus;
	private int schockresistenzbonus;
	private int geistigerWiderstandbonus;
	private int[] rüstung;
	private JTextField tFRüstungsschutz;
	JTextField tFBelastung;
	private JTextField tFSchadensschutz;
	private int index;
	private JTextField tFWundgrad;

	private void initChar(String player, JFrame frame, int index) {
		try {
			gui.panellist.get(index).charinit = Reader.getCharinit(player);
			gui.panellist.get(index).kampftechnikeninitbonus = Reader.getKampftechnikeninitbonus(player);
			gui.panellist.get(index).geschicklichkeitsbonus = Reader.getGeschicklichkeitsbonus(player);
			gui.panellist.get(index).wahrnehmnungsbonus = Reader.getWahrnehmnungsbonus(player);
			gui.panellist.get(index).größenklasse = Reader.getGrößenklasse(player);
			gui.panellist.get(index).konstitutionsbonus = Reader.getKonstitutionsbonus(player);
			gui.panellist.get(index).stärkebonus = Reader.getStärkebonus(player);
			gui.panellist.get(index).willenskraftbonus = Reader.getWillenskraftbonus(player);
			gui.panellist.get(index).intelligenzbonus = Reader.getIntelligenzbonus(player);
			gui.panellist.get(index).waffenfertigkeitsboni = Reader.getWaffenfertigkeitsbonus(player);
			gui.panellist.get(index).verteidigungswertbonus = Reader.getVerteidigungswertbonus(player);
			gui.panellist.get(index).schockresistenzbonus = Reader.getSchockresistenzbonus(player);
			gui.panellist.get(index).geistigerWiderstandbonus = Reader.getGeistigerWiderstandbonus(player);

		} catch (JSONException e) {
			JOptionPane.showMessageDialog(frame,
					e.toString() + "\n" + "Du solltest nach einer Änderung der JSON Datei das Prgrogramm neustarten",
					"Da ist was schief gelaufen", JOptionPane.ERROR_MESSAGE);
		}
	}

	public CharPanel(JFrame frame, int i) {
		index = i;
		panel = new JPanel();
		tFfinalinit = new JTextField();
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
					gui.panellist.get(index).initChar(cBchangeChar.getSelectedItem().toString(), frame, index);
				}
				if (!cBchangeChar.getSelectedItem().toString().equals(cBCharselect)) {
					cBCharselect = cBchangeChar.getSelectedItem().toString();
					gui.panellist.get(index).initChar(cBchangeChar.getSelectedItem().toString(), frame, index);
				}
			}
		});
		cBchangeChar.setSelectedIndex(-1);
		panel.add(cBchangeChar);

		JButton btnKampfmodi = new JButton("Kampfmodi");
		btnKampfmodi.setBounds(7, 272, 103, 23);
		panel.add(btnKampfmodi);

//		JComboBox<String> cBKampfart = new JComboBox<String>(
		JComboBox cBKampfart = new JComboBox(new String[] { "Angreifen", "Abblocken", "Parieren", "Ausweichen" });
		cBKampfart.setBounds(70, 110, 95, 20);
		panel.add(cBKampfart);

		JButton btnWaffe = new JButton("Waffe");
		btnWaffe.setBounds(7, 298, 103, 23);
		panel.add(btnWaffe);

		JButton btnRstung = new JButton("Rüstung");
		btnRstung.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				new RüstungPanel(stärkebonus, index);

			}
		});
		btnRstung.setBounds(8, 60, 103, 23);
		panel.add(btnRstung);

		JSpinner spMehrfachaktion = new JSpinner();
		spMehrfachaktion.setModel(new SpinnerNumberModel(0, 0, 10, 1));
		spMehrfachaktion.setToolTipText("Anzahl der Mehrfachaktionen");
		spMehrfachaktion.setBounds(117, 247, 47, 20);
		panel.add(spMehrfachaktion);

		JSpinner spKP = new JSpinner();
		spKP.setModel(new SpinnerNumberModel(0, 0, 99, 1));
		spKP.setToolTipText("KP");
		spKP.setBounds(117, 200, 47, 20);
		panel.add(spKP);

		JSpinner spErfolge = new JSpinner();
		spErfolge.setModel(new SpinnerNumberModel(0, 0, 99, 1));
		spErfolge.setToolTipText("Erfolge");
		spErfolge.setBounds(117, 224, 47, 20);
		panel.add(spErfolge);

		JSpinner spSonstigesSchaden = new JSpinner();
		spSonstigesSchaden.setModel(new SpinnerNumberModel(0, -99, 99, 1));
		spSonstigesSchaden.setBounds(130, 325, 37, 20);
		panel.add(spSonstigesSchaden);

		JSpinner spLP = new JSpinner();
		spLP.setModel(new SpinnerNumberModel(0, 0, 999, 1));
		spLP.setToolTipText("Lebenspunkte");
		spLP.setBounds(117, 37, 47, 20);
		panel.add(spLP);

		JSpinner spSonstigesAngriff = new JSpinner();
		spSonstigesAngriff.setModel(new SpinnerNumberModel(0, -99, 99, 1));
		spSonstigesAngriff.setBounds(92, 325, 37, 20);
		panel.add(spSonstigesAngriff);

		JSpinner spVW = new JSpinner();
		spVW.setModel(new SpinnerNumberModel(0, 0, 999, 1));
		spVW.setBounds(17, 149, 37, 20);
		panel.add(spVW);

		JSpinner spSR = new JSpinner();
		spSR.setModel(new SpinnerNumberModel(0, 0, 999, 1));
		spSR.setBounds(69, 149, 37, 20);
		panel.add(spSR);

		JSpinner spGW = new JSpinner();
		spGW.setModel(new SpinnerNumberModel(0, 0, 999, 1));
		spGW.setBounds(121, 149, 37, 20);

		JButton btnBerechne = new JButton("Berechne");
		btnBerechne.setToolTipText("Berechnet die unten Stehenden Werte");
		btnBerechne.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tFAngriffboni.setText(" " + (gui.panellist.get(index).waffenfertigkeitsbonus + (int) spKP.getValue()
						+ Integer.parseInt(gui.panellist.get(index).tfKampfmodiAngriff.getText())
						+ (int) spSonstigesAngriff.getValue() - (int) spErfolge.getValue()
						+ Integer.parseInt(gui.panellist.get(index).tFBelastung.getText())
						- (4 * (int) spMehrfachaktion.getValue())));
				tFSchadensboni.setText("" + (Integer.parseInt(gui.panellist.get(index).tfKampfmodiSchaden.getText())
						+ gui.panellist.get(index).stärkebonus + (int) spSonstigesSchaden.getValue()
						+ (int) spErfolge.getValue()));
				tFSchadensschutz.setText("" + Integer.parseInt(gui.panellist.get(index).tFRüstungsschutz.getText()));
				tFVerteidigungswert.setText("" + (14 + gui.panellist.get(index).geschicklichkeitsbonus
						+ gui.panellist.get(index).verteidigungswertbonus + gui.panellist.get(index).wahrnehmnungsbonus
						+ (int) spVW.getValue()));
				tFGeistigerWiderstand.setText("" + (14 + gui.panellist.get(index).konstitutionsbonus
						+ gui.panellist.get(index).geistigerWiderstandbonus + gui.panellist.get(index).stärkebonus
						+ (int) spGW.getValue()));
				tFSchockresistenz.setText("" + (14 + gui.panellist.get(index).willenskraftbonus
						+ gui.panellist.get(index).schockresistenzbonus + gui.panellist.get(index).intelligenzbonus
						+ (int) spSR.getValue()));
			}
		});
		btnBerechne.setBounds(23, 348, 127, 23);
		panel.add(btnBerechne);

		panel.add(spGW);

		tFWundgrad = new JTextField();
		tFWundgrad.setEditable(false);
		tFWundgrad.setBounds(70, 87, 95, 20);
		panel.add(tFWundgrad);
		tFWundgrad.setColumns(10);

		JSeparator separator = new JSeparator();
		separator.setBounds(0, 196, 183, 1);
		panel.add(separator);

		// Das ausklammern, um das Panel im Editor zu bearbeiten
		add(panel);

	}

	protected static void setRüstung(int[] rs, int index) {
		gui.panellist.get(index).rüstung = rs;
		gui.panellist.get(index).tFRüstungsschutz.setText(gui.panellist.get(index).rüstung[0] + "");
		gui.panellist.get(index).tFBelastung.setText(gui.panellist.get(index).rüstung[1] + "");

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
		lblKp.setBounds(7, 203, 33, 14);
		panel.add(lblKp);

		JLabel lblSchadensminderung = new JLabel("Schadensminderung:");
		lblSchadensminderung.setBounds(7, 418, 132, 14);
		panel.add(lblSchadensminderung);

		tFSchadensschutz.setToolTipText("Die Verminderung des Schadens ( Rüstungsschutz)");
		tFSchadensschutz.setEditable(false);
		tFSchadensschutz.setBackground(Color.WHITE);
		tFSchadensschutz.setBounds(129, 415, 37, 20);
		panel.add(tFSchadensschutz);

		JLabel lblErfolge = new JLabel("Erfolge");
		lblErfolge.setBounds(7, 227, 47, 14);
		panel.add(lblErfolge);

		JLabel lblKampfart = new JLabel("Kampfart");
		lblKampfart.setBounds(7, 113, 65, 14);
		panel.add(lblKampfart);

		JLabel lblMehrfachaktion = new JLabel("Mehrfachaktionen");
		lblMehrfachaktion.setBounds(7, 247, 113, 20);
		panel.add(lblMehrfachaktion);

		JLabel lblSchockresistenz = new JLabel("SR");
		lblSchockresistenz.setToolTipText("Schockresistenz");
		lblSchockresistenz.setBounds(78, 129, 20, 20);
		panel.add(lblSchockresistenz);

		JLabel lblGeistigerWiderstand = new JLabel("GW");
		lblGeistigerWiderstand.setToolTipText("Geistiger Widerstand");
		lblGeistigerWiderstand.setBounds(126, 129, 20, 20);
		panel.add(lblGeistigerWiderstand);

		tFSchockresistenz.setBackground(Color.WHITE);
		tFSchockresistenz.setEditable(false);
		tFSchockresistenz.setBounds(72, 172, 30, 20);
		panel.add(tFSchockresistenz);

		tFGeistigerWiderstand.setBackground(Color.WHITE);
		tFGeistigerWiderstand.setEditable(false);
		tFGeistigerWiderstand.setColumns(10);
		tFGeistigerWiderstand.setBounds(122, 172, 30, 20);
		panel.add(tFGeistigerWiderstand);

		tFVerteidigungswert.setBackground(Color.WHITE);
		tFVerteidigungswert.setEditable(false);
		tFVerteidigungswert.setColumns(10);
		tFVerteidigungswert.setBounds(22, 172, 30, 20);
		panel.add(tFVerteidigungswert);

		JLabel lblVerteidigungswert = new JLabel("VW");
		lblVerteidigungswert.setToolTipText("Verteidigungswert");
		lblVerteidigungswert.setBounds(30, 129, 20, 20);
		panel.add(lblVerteidigungswert);

		tFAngriffboni.setBackground(Color.WHITE);
		tFAngriffboni.setEditable(false);
		tFAngriffboni.setBounds(91, 375, 37, 20);
		panel.add(tFAngriffboni);

		tFSchadensboni.setBackground(Color.WHITE);
		tFSchadensboni.setEditable(false);
		tFSchadensboni.setBounds(129, 395, 37, 20);
		panel.add(tFSchadensboni);

		JLabel lblSonstiges = new JLabel("Sonstiges");
		lblSonstiges.setBounds(8, 328, 77, 14);
		panel.add(lblSonstiges);

		JLabel lblAngriffboni = new JLabel("Angriffsboni:");
		lblAngriffboni.setBounds(7, 378, 93, 14);
		panel.add(lblAngriffboni);

		JLabel lblSchadensboni = new JLabel("Schadensboni:");
		lblSchadensboni.setBounds(7, 398, 93, 14);
		panel.add(lblSchadensboni);

		JLabel lblLebenspunkte = new JLabel("Lebenspunkte");
		lblLebenspunkte.setBounds(7, 40, 98, 14);
		panel.add(lblLebenspunkte);

		tFWaffenAngriff.setText("0");
		tFWaffenAngriff.setEditable(false);
		tFWaffenAngriff.setColumns(1);
		tFWaffenAngriff.setBackground(Color.WHITE);
		tFWaffenAngriff.setBounds(120, 299, 20, 20);
		panel.add(tFWaffenAngriff);

		tFWaffenSchaden.setText("0");
		tFWaffenSchaden.setEditable(false);
		tFWaffenSchaden.setColumns(1);
		tFWaffenSchaden.setBackground(Color.WHITE);
		tFWaffenSchaden.setBounds(144, 299, 20, 20);
		panel.add(tFWaffenSchaden);

		tfKampfmodiAngriff.setText("0");
		tfKampfmodiAngriff.setEditable(false);
		tfKampfmodiAngriff.setColumns(1);
		tfKampfmodiAngriff.setBackground(Color.WHITE);
		tfKampfmodiAngriff.setBounds(120, 273, 20, 20);
		panel.add(tfKampfmodiAngriff);

		tfKampfmodiSchaden.setText("0");
		tfKampfmodiSchaden.setEditable(false);
		tfKampfmodiSchaden.setColumns(1);
		tfKampfmodiSchaden.setBackground(Color.WHITE);
		tfKampfmodiSchaden.setBounds(144, 273, 20, 20);
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
