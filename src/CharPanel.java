import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JComboBox;
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

@SuppressWarnings("serial")
public class CharPanel extends JPanel {

	JPanel panel;
	private JTextField tFfinalinit;
	private JTextField tFKP;
	private JTextField tFfinalkampfmodi;
	private JTextField tFfinalManoever;
	private JTextField tFErfolge;
	private JTextField tFWaffe;
	private JTextField tFRuestung;
	private JTextField tFSchockresistenz;
	private JTextField tFGeistigerWiderstand;
	private JTextField Verteidigungswert;
	private JTextField tFSonstiges;
	private JTextField tFAngriffboni;
	private JTextField tFSchadensboni;
	private JTextField tF_LP;
	private String cBCharselect;
	private int charinit;
	private int kampftechnikeninitbonus;
	private int geschicklichkeitsbonus;
	private int wahrnehmnungsbonus;
	private char größenklasse;
	private int konstitutionsbonus;
	private int stärkebonus;
	private int willenskraftbonus;
	private int intelligenzbonus;
	private int[] waffenfertigkeitsbonus;

	private void initChar(String player) {
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
			waffenfertigkeitsbonus = Reader.getWaffenfertigkeitsbonus(player);

		} catch (JSONException e) {
			JOptionPane.showMessageDialog(null,
					e.toString() + "\n" + "Du solltest nach einer Änderung der JSON Datei das Prgrogramm neustarten",
					"Da ist was schief gelaufen", JOptionPane.ERROR_MESSAGE);
		}
	}

	public CharPanel() {

		panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(0, 0, 173, 516);
		panel.setLayout(null);

		JComboBox<String> cBchangeChar = new JComboBox<String>(Reader.getList());
		cBchangeChar.setBounds(7, 11, 103, 20);
		cBchangeChar.addPopupMenuListener(new PopupListener(cBchangeChar) {
			public void popupMenuWillBecomeInvisible(PopupMenuEvent arg0) {
				if (cBchangeChar.getSelectedItem() == null) {
					return;
				}
				if (cBCharselect == null) {
					cBCharselect = cBchangeChar.getSelectedItem().toString();
					initChar(cBchangeChar.getSelectedItem().toString());
				}
				if (!cBchangeChar.getSelectedItem().toString().equals(cBCharselect)) {
					cBCharselect = cBchangeChar.getSelectedItem().toString();
					initChar(cBchangeChar.getSelectedItem().toString());
				}
			}
		});
		cBchangeChar.setSelectedIndex(-1);
		panel.add(cBchangeChar);

		JLabel lblWundgrad = new JLabel("Wundgrad");
		lblWundgrad.setBounds(7, 80, 65, 14);
		panel.add(lblWundgrad);

		JButton btnInit = new JButton("Init");
		btnInit.setBounds(19, 485, 86, 20);
		panel.add(btnInit);

		tFfinalinit = new JTextField();
		tFfinalinit.setEditable(false);
		tFfinalinit.setBounds(123, 485, 33, 20);
		panel.add(tFfinalinit);

		JLabel lblKp = new JLabel("KP");
		lblKp.setBounds(19, 136, 33, 14);
		panel.add(lblKp);

		tFKP = new JTextField();
		tFKP.setBounds(70, 133, 86, 20);
		panel.add(tFKP);

		tFfinalkampfmodi = new JTextField();
		tFfinalkampfmodi.setEditable(false);
		tFfinalkampfmodi.setColumns(1);
		tFfinalkampfmodi.setBounds(118, 187, 47, 20);
		panel.add(tFfinalkampfmodi);

		JButton btnKampfmodi = new JButton("Kampfmodi");
		btnKampfmodi.setBounds(8, 186, 103, 23);
		panel.add(btnKampfmodi);

		JButton btnManvoeer = new JButton("Manoever");
		btnManvoeer.setBounds(8, 218, 103, 23);
		panel.add(btnManvoeer);

		tFfinalManoever = new JTextField();
		tFfinalManoever.setEditable(false);
		tFfinalManoever.setColumns(1);
		tFfinalManoever.setBounds(118, 219, 47, 20);
		panel.add(tFfinalManoever);

		tFErfolge = new JTextField();
		tFErfolge.setColumns(10);
		tFErfolge.setBounds(70, 156, 86, 20);
		panel.add(tFErfolge);

		JLabel lblErfolge = new JLabel("Erfolge");
		lblErfolge.setBounds(18, 159, 47, 14);
		panel.add(lblErfolge);

		JComboBox<String> cBWundgrad = new JComboBox<String>(new String[] { "Gesund", "Angeschlagen", "Verletzt",
				"Verwundet", "Schwer verwundet", "Außer Gefecht" });
		cBWundgrad.setBounds(70, 77, 95, 20);
		panel.add(cBWundgrad);

		JLabel lblKampfart = new JLabel("Kampfart");
		lblKampfart.setBounds(7, 108, 65, 14);
		panel.add(lblKampfart);

		JComboBox<String> cBKampfart = new JComboBox<String>(
				new String[] { "Angreifen", "Abblocken", "Parieren", "Ausweichen" });
		cBKampfart.setBounds(70, 105, 95, 20);
		panel.add(cBKampfart);

		JButton btnWaffe = new JButton("Waffe");
		btnWaffe.setBounds(7, 252, 103, 23);
		panel.add(btnWaffe);

		tFWaffe = new JTextField();
		tFWaffe.setEditable(false);
		tFWaffe.setBounds(117, 253, 47, 20);
		panel.add(tFWaffe);

		tFRuestung = new JTextField();
		tFRuestung.setEditable(false);
		tFRuestung.setBounds(118, 46, 47, 20);
		panel.add(tFRuestung);

		JButton btnRstung = new JButton("Rüstung");
		btnRstung.setBounds(8, 45, 103, 23);
		panel.add(btnRstung);

		JSpinner spMehrfachaktion = new JSpinner();
		spMehrfachaktion.setBounds(23, 286, 29, 20);
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

		JLabel lblMehrfachaktion = new JLabel("Mehrfachaktion");
		lblMehrfachaktion.setBounds(75, 286, 90, 20);
		panel.add(lblMehrfachaktion);

		JLabel lblSchockresistenz = new JLabel("SR");
		lblSchockresistenz.setBounds(70, 431, 33, 20);
		panel.add(lblSchockresistenz);

		JLabel lblGeistigerWiderstand = new JLabel("GW");
		lblGeistigerWiderstand.setBounds(121, 431, 33, 20);
		panel.add(lblGeistigerWiderstand);

		tFSchockresistenz = new JTextField();
		tFSchockresistenz.setEditable(false);
		tFSchockresistenz.setBounds(70, 453, 33, 20);
		panel.add(tFSchockresistenz);

		tFGeistigerWiderstand = new JTextField();
		tFGeistigerWiderstand.setEditable(false);
		tFGeistigerWiderstand.setColumns(10);
		tFGeistigerWiderstand.setBounds(121, 453, 33, 20);
		panel.add(tFGeistigerWiderstand);

		Verteidigungswert = new JTextField();
		Verteidigungswert.setEditable(false);
		Verteidigungswert.setColumns(10);
		Verteidigungswert.setBounds(19, 453, 33, 20);
		panel.add(Verteidigungswert);

		JLabel lblVerteidigungswert = new JLabel("VW");
		lblVerteidigungswert.setBounds(19, 431, 33, 20);
		panel.add(lblVerteidigungswert);

		JButton btnBerechne = new JButton("Berechne");
		btnBerechne.setBounds(42, 345, 89, 23);
		panel.add(btnBerechne);

		JLabel lblSonstiges = new JLabel("Sonstiges");
		lblSonstiges.setBounds(16, 320, 77, 14);
		panel.add(lblSonstiges);

		tFSonstiges = new JTextField();
		tFSonstiges.setBounds(83, 317, 86, 20);
		panel.add(tFSonstiges);

		tFAngriffboni = new JTextField();
		tFAngriffboni.setEditable(false);
		tFAngriffboni.setBounds(118, 379, 47, 20);
		panel.add(tFAngriffboni);

		JLabel lblAngriffboni = new JLabel("Angriffsboni:");
		lblAngriffboni.setBounds(12, 382, 93, 14);
		panel.add(lblAngriffboni);

		tFSchadensboni = new JTextField();
		tFSchadensboni.setEditable(false);
		tFSchadensboni.setBounds(118, 400, 47, 20);
		panel.add(tFSchadensboni);

		JLabel lblSchadensboni = new JLabel("Schadensboni:");
		lblSchadensboni.setBounds(12, 403, 90, 14);
		panel.add(lblSchadensboni);

		tF_LP = new JTextField();
		tF_LP.setColumns(10);
		tF_LP.setBounds(118, 11, 47, 20);
		panel.add(tF_LP);

		add(panel);
	}
}
