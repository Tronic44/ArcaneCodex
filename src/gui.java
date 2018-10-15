import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class gui extends JFrame {

	JFrame frame;
	int line = 0;
	int frameline = 0;
	int spalte = 1;
	Dimension dim;
	int index = 0;
	static List<CharPanel> panellist = new ArrayList<>();
	private JButton btnNeueRunde;

	public gui() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 208, 60);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);

		dim = Toolkit.getDefaultToolkit().getScreenSize();
		JButton btnNewButton_1 = new JButton("Neuer Charakter");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (line < dim.getWidth() - 200 && spalte < dim.getHeight() - 500) {
					addpanel(frame);
				} else {
					spalte += 520;
					line = 0;
					if (spalte < dim.getHeight() - 500) {
						addpanel(frame);
					}

				}
			}
		});
		menuBar.add(btnNewButton_1);

		btnNeueRunde = new JButton("Neue Runde");
		btnNeueRunde.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				removeemtypanel();
				int[] inits = new int[panellist.size()];
				if (panellist.size() > 0) {
					for (int k = 0; k < panellist.size(); k++) {
						if (gui.panellist.get(k).aktivate) {
							inits[k] = 101 + (gui.panellist.get(k).charinit
									+ Integer.parseInt(gui.panellist.get(k).tFBelastung.getText())
									+ (int) (Math.random() * 10)) * inits.length;
						} else {
							inits[k] = 0 + k;
						}
					}
					for (int all = 0; all < inits.length; all++) {
						for (int k = 0; k < inits.length; k++) {
							for (int h = 0; h < inits.length; h++) {
								if (k == h) {
									continue;
								}
								if (inits[k] == inits[h]) {
									if ((int) (Math.random() * 2) > 1) {
										inits[k] += 1;
									} else {
										inits[h] += 1;
									}
								}
							}
						}
					}
					int maxinit = inits[0];
					int lastmax = 1000000000;
					int ort = 0;
					int x = 0;
					int y = 1;
					for (int all = 0; all < inits.length; all++) {
						for (int k = 0; k < inits.length; k++) {
							if (inits[k] > maxinit && inits[k] < lastmax) {
								maxinit = inits[k];
								ort = k;
							}
						}
						lastmax = maxinit;
						maxinit = -101;
						panellist.get(ort).setBounds(x, y, 173, 516);
						x += 174;
						if (x > dim.getWidth() - 300) {
							y += 520;
							x = 0;
						}
						gui.panellist.get(ort).tFfinalinit.setText(inits[ort] + "");
						panellist.get(ort).invalidate();
						panellist.get(ort).nextRound(); // Die sorgt für laggst beim drücken
						panellist.get(ort).validate();
						panellist.get(ort).repaint();
						if (all + 1 == inits.length) {
							line = gui.panellist.get(ort).getX() + 174;
						}

					}

				}
				frame.invalidate();
				frame.validate();
				frame.repaint();
			}
		});
		menuBar.add(btnNeueRunde);
		btnNeueRunde.setEnabled(false);
		btnNeueRunde.setVisible(false);

		pack();

	}

	private void removeemtypanel() {
		for (int k = 0; k < panellist.size(); k++) {
			if (!panellist.get(k).aktivate) {
				frame.remove(panellist.get(k));
				panellist.remove(k);
				for (int h = k; h < panellist.size(); h++) {
					gui.panellist.get(h).remove1index();
				}
				index--;
				k--;
			}
		}
		if (panellist.size() < 2) {
			btnNeueRunde.setEnabled(false);
			btnNeueRunde.setVisible(false);
		}
		try {
			spalte = 0;
			frameline = panellist.size() * 174;
			if (frameline > dim.getWidth() - 200) {
				spalte += 520;
				while (frameline > dim.getWidth() - 200) {
					frameline -= 174;
				}
			}
			line = 0;
			frame.setBounds(frame.getX(), frame.getY(), frameline + 6, spalte + 574);
		} catch (Exception e) {
			frameline = 0;
			line = 0;
			spalte = 1;
			frame.setBounds(100, 100, 208, 60);
		}
		frame.invalidate();
		frame.validate();
		frame.repaint();
	}

	private void addpanel(JFrame frame) {
		CharPanel panel = new CharPanel(frame, index);
		panellist.add(panel);
		if (index > 0) {
			btnNeueRunde.setEnabled(true);
			btnNeueRunde.setVisible(true);
		}
		index++;
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(line, spalte, 173, 516);
		panel.setLayout(null);
		frame.getContentPane().add(panel);
		line += 174;
		if (frameline < dim.getWidth() - 300) {
			frameline += 174;
		}
		frame.setBounds(frame.getX(), frame.getY(), frameline + 6, spalte + 574);
		frame.invalidate();
		frame.validate();
		frame.repaint();
	}
}
