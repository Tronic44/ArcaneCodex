import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.EventQueue;
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

public class RüstungPanel {

	private JFrame frmRstungsauswahl;
	private int cBRüsungselect;
	private int[][] rüstungswerte = { { 0, 0, 0 }, { 7, -2, 4 }, { 6, -3, 3 }, { 4, -1, 2 }, { 3, -1, 2 }, { 7, -2, 4 },
			{ 6, -2, 4 }, { 4, -1, 2 }, { 3, -1, 2 }, { 9, -3, 5 }, { 4, -1, 2 }, { 6, -2, 3 }, { 5, -2, 3 },
			{ 1, 0, 1 }, { 12, -4, 6 }, { 2, -1, 1 }, { 8, -3, 4 } };
	private JTextField tFRS;
	private JTextField tFBL;
	private JTextField tFMS;
	private JSpinner spRS;
	private JSpinner spBL;
	private JSpinner spMS;
	private static int stärke;

	public static int[] initRüstungPanel(int stärkebonus) {
		stärke = stärkebonus + 5;
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RüstungPanel window = new RüstungPanel();
					window.frmRstungsauswahl.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

		return null;
	}

	public RüstungPanel() {

		frmRstungsauswahl = new JFrame();
		tFRS = new JTextField();
		tFBL = new JTextField();
		tFMS = new JTextField();
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
		cBAuswahl.setBounds(60, 36, 146, 20);
		frmRstungsauswahl.getContentPane().add(cBAuswahl);

		JButton btnNewButton = new JButton("Fertig");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				fertig();
			}
		});
		btnNewButton.setBounds(84, 160, 89, 23);
		frmRstungsauswahl.getContentPane().add(btnNewButton);

		spRS = new JSpinner();
		spRS.setBounds(191, 67, 29, 20);
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
		spBL.setBounds(191, 98, 29, 20);
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

		spMS = new JSpinner();
		spMS.setBounds(191, 129, 29, 20);
		spMS.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				if ((int) spMS.getValue() < -10) {
					spMS.setValue(-10);
				} else {
					if ((int) spMS.getValue() > 10) {
						spMS.setValue(10);
					}
				}
			}
		});
		frmRstungsauswahl.getContentPane().add(spMS);

	}

	private void printRüstung(int select) {
		tFRS.setText(rüstungswerte[select][0] + "");
		tFBL.setText(rüstungswerte[select][1] + "");
		tFMS.setText(rüstungswerte[select][2] + "");
		spRS.setValue(0);
		spBL.setValue(0);
		spMS.setValue(0);

	}

	private void fertig() {

		frmRstungsauswahl.dispose();
		CharPanel.setRüstung((new int[] { (rüstungswerte[cBRüsungselect][0] + (int) spRS.getValue()),
				(rüstungswerte[cBRüsungselect][1] + (int) spBL.getValue()) }));

	}

	private void initpanelcompents() {
		frmRstungsauswahl.setTitle("RüstungsAuswahl");
		frmRstungsauswahl.setResizable(false);
		frmRstungsauswahl.setBounds(100, 100, 273, 225);
		frmRstungsauswahl.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmRstungsauswahl.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Welche Rüstung wird getragen?");
		lblNewLabel.setBounds(36, 11, 184, 14);
		frmRstungsauswahl.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Rüstungsschutz");
		lblNewLabel_1.setBounds(25, 70, 89, 14);
		frmRstungsauswahl.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Belastung");
		lblNewLabel_2.setBounds(25, 101, 89, 14);
		frmRstungsauswahl.getContentPane().add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Mindeststärke");
		lblNewLabel_3.setBounds(25, 132, 89, 14);
		frmRstungsauswahl.getContentPane().add(lblNewLabel_3);

		JLabel lbl1 = new JLabel("+");
		lbl1.setBounds(172, 70, 21, 14);
		frmRstungsauswahl.getContentPane().add(lbl1);

		JLabel lbl2 = new JLabel("+");
		lbl2.setBounds(172, 101, 21, 14);
		frmRstungsauswahl.getContentPane().add(lbl2);

		JLabel lbl3 = new JLabel("+");
		lbl3.setBounds(172, 132, 21, 14);
		frmRstungsauswahl.getContentPane().add(lbl3);

		tFMS.setColumns(10);
		tFMS.setBounds(111, 129, 51, 20);
		tFMS.setBackground(Color.WHITE);
		tFMS.setEditable(false);
		frmRstungsauswahl.getContentPane().add(tFMS);

		tFBL.setColumns(10);
		tFBL.setBounds(111, 98, 51, 20);
		tFBL.setBackground(Color.WHITE);
		tFBL.setEditable(false);
		frmRstungsauswahl.getContentPane().add(tFBL);

		tFRS.setBounds(111, 67, 51, 20);
		tFRS.setBackground(Color.WHITE);
		tFRS.setEditable(false);
		tFRS.setColumns(10);
		frmRstungsauswahl.getContentPane().add(tFRS);

		tFMS.setText("0");
		tFBL.setText("0");
		tFRS.setText("0");

	}
}