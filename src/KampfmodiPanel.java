import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.PopupMenuEvent;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class KampfmodiPanel {

	JFrame frmRstungsauswahl;
	private int cBRüsungselect;
	private int[][] rüstungswerte = { { 0, 0, 0 }, { 7, -2, 4 }, { 6, -3, 3 }, { 4, -1, 2 }, { 3, -1, 2 }, { 7, -2, 4 },
			{ 6, -2, 4 }, { 4, -1, 2 }, { 3, -1, 2 }, { 9, -3, 5 }, { 4, -1, 2 }, { 6, -2, 3 }, { 5, -2, 3 },
			{ 1, 0, 1 }, { 12, -4, 6 }, { 2, -1, 1 }, { 8, -3, 4 } };	//{{RS, Bel, Mindeststärke}...}
	private JTextField tFRS;
	private JTextField tFBL;
	private JSpinner spRS;
	private JSpinner spBL;
	private static int stärke;

	public KampfmodiPanel(int stärkebonus, int index) {
		stärke = stärkebonus + 5;
		frmRstungsauswahl = new JFrame();
		tFRS = new JTextField();
		tFBL = new JTextField();
		frmRstungsauswahl.setVisible(true);
		initpanelcompents();

		JComboBox cBAuswahl = new JComboBox(new String[] { "Keine", "Bänderpanzer", "Bronzepanzer", "Fellrüstung",
				"Holzrüstung", "Kettenrüstung", "Lamellenpanzer", "Leder", "Leichte Lederrüstung", "Plattenpanzer",
				"Schlingpflanzen (lebende)", "Schuppenpanzer", "Schweres Leder (beschlagen)", "Verstärkte Kleidung",
				"Vollplatte (Ritterrüstung)", "Wattierter Waffenrock", "Zwergenplattenpanzer" });
		cBAuswahl.addPopupMenuListener(new PopupListener(cBAuswahl) {
			public void popupMenuWillBecomeInvisible(PopupMenuEvent arg0) {
				if (cBAuswahl.getSelectedItem() == null) {
					return;
				}
				if (!(cBAuswahl.getSelectedIndex() == cBRüsungselect)) {
					cBRüsungselect = cBAuswahl.getSelectedIndex();
					if (stärke >= rüstungswerte[cBRüsungselect][2]) {
						printRüstung(cBAuswahl.getSelectedIndex());
					} else {

						JOptionPane.showMessageDialog(null,
								"Du bist zu schwach um diese Rüstung zu tragen? Bist du sicher das du keinen Fehler gemacht hast?",
								"Da ist was schief gelaufen", JOptionPane.ERROR_MESSAGE);
						cBAuswahl.setSelectedIndex(0);
						cBRüsungselect = 0;
						printRüstung(cBAuswahl.getSelectedIndex());
					}
				}
			}

		});
		cBAuswahl.setBounds(35, 46, 197, 20);
		frmRstungsauswahl.getContentPane().add(cBAuswahl);

		JButton btnNewButton = new JButton("Fertig");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				fertig(index);
			}
		});
		btnNewButton.setBounds(84, 154, 89, 23);
		frmRstungsauswahl.getContentPane().add(btnNewButton);

		spRS = new JSpinner();
		spRS.setBounds(191, 82, 29, 20);
		spRS.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				if ((int) spRS.getValue() < -10) {
					spRS.setValue(-10);
				} else {
					if ((int) spRS.getValue() > 10) {
						spRS.setValue(10);
					}
				}
			}
		});
		frmRstungsauswahl.getContentPane().add(spRS);

		spBL = new JSpinner();
		spBL.setBounds(191, 118, 29, 20);
		spBL.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				if ((int) spBL.getValue() < -10) {
					spBL.setValue(-10);
				} else {
					if ((int) spBL.getValue() > 10) {
						spBL.setValue(10);
					}
				}
			}
		});
		frmRstungsauswahl.getContentPane().add(spBL);

	}

	private void printRüstung(int select) {
		tFRS.setText(rüstungswerte[select][0] + "");
		tFBL.setText(rüstungswerte[select][1] + "");
		spRS.setValue(0);
		spBL.setValue(0);

	}

	private void fertig(int index) {

		frmRstungsauswahl.dispose();
		gui.panellist.get(index)
				.setRüstung((new int[] { (this.rüstungswerte[cBRüsungselect][0] + (int) spRS.getValue()),
						(this.rüstungswerte[cBRüsungselect][1] + (int) spBL.getValue()) }), index);

	}

	private void initpanelcompents() {
		frmRstungsauswahl.setTitle("RüstungsAuswahl");
		frmRstungsauswahl.setResizable(false);
		frmRstungsauswahl.setBounds(100, 100, 273, 225);
		frmRstungsauswahl.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmRstungsauswahl.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Welche Rüstung wird getragen?");
		lblNewLabel.setBounds(36, 16, 184, 14);
		frmRstungsauswahl.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Rüstungsschutz");
		lblNewLabel_1.setBounds(25, 85, 89, 14);
		frmRstungsauswahl.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Belastung");
		lblNewLabel_2.setBounds(25, 121, 89, 14);
		frmRstungsauswahl.getContentPane().add(lblNewLabel_2);

		JLabel lbl1 = new JLabel("+");
		lbl1.setBounds(172, 85, 21, 14);
		frmRstungsauswahl.getContentPane().add(lbl1);

		JLabel lbl2 = new JLabel("+");
		lbl2.setBounds(172, 121, 21, 14);
		frmRstungsauswahl.getContentPane().add(lbl2);

		tFBL.setColumns(10);
		tFBL.setBounds(111, 118, 51, 20);
		tFBL.setBackground(Color.WHITE);
		tFBL.setEditable(false);
		frmRstungsauswahl.getContentPane().add(tFBL);

		tFRS.setBounds(111, 82, 51, 20);
		tFRS.setBackground(Color.WHITE);
		tFRS.setEditable(false);
		tFRS.setColumns(10);
		frmRstungsauswahl.getContentPane().add(tFRS);
		tFBL.setText("0");
		tFRS.setText("0");

	}
}
