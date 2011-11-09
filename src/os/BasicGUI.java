package os;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BasicGUI implements ActionListener {
	private final int MAXFRAMES = 8;
	
	private JFrame frame;
	private JPanel panel;
	private JPanel buttonPanel;
	private JPanel framePanel;
	
	private JLabel[] frameLabels;
	private JButton[] frameButtons;
	private JButton step;
	
	public BasicGUI() {
		frame = new JFrame("Memory Management");
		frameLabels = new JLabel[MAXFRAMES];
		frameButtons = new JButton[MAXFRAMES];
		panel = new JPanel(new BorderLayout());
		buttonPanel = new JPanel(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
		framePanel = new JPanel(new BoxLayout(framePanel, BoxLayout.Y_AXIS));
		
		step = new JButton("Step");
		step.addActionListener(this);
		
		frame.add(panel);
		panel.add(framePanel, BorderLayout.LINE_START);
		panel.add(buttonPanel, BorderLayout.CENTER);
		panel.add(step, BorderLayout.PAGE_END);
		
		setUp();
	}

	public void setUp() {
		for (int i = 0; i < MAXFRAMES; i++) {
			frameLabels[i] = new JLabel("Frame " + i + ": ");
		}
		
		for (int i = 0; i < MAXFRAMES; i++) {
			frameButtons[i] = new JButton("Empty");
			frameButtons[i].addActionListener(this);
		}
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
