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
	static List<CharPanel> panellist= new ArrayList<>();

	public gui() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 100, 60);

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

		pack();
	}

	private void addpanel(JFrame frame) {
		CharPanel panel = new CharPanel(frame, index);
		panellist.add(panel);
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
