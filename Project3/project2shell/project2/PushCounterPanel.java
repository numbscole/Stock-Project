package project2;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Label;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.ScrollPane;
import java.awt.TextArea;

public class PushCounterPanel extends JPanel{
	private int count;
	private JButton push;
	private JButton clear;
	private JLabel label;
	private JLabel oddEven;
	private Data myData;
	private JLabel label_1;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	
	public PushCounterPanel() {
		myData = new Data("/project2/dow_jones_index.data");
		
		count = 0;
		push = new JButton ("Push Me!");
		push.setBounds(5, 5, 98, 23);
		push.addActionListener(new ButtonListener());
		clear = new JButton ("Clear");
		clear.setBounds(113, 5, 77, 23);
		clear.addActionListener(new ButtonListener2());		
		label = new JLabel ("Pusheds: "+count);		
		label.setBounds(200, 9, 72, 14);
		oddEven = new JLabel ("Odd");
		oddEven.setBounds(269, 9, 47, 14);
		oddEven.setVisible(false);
		setLayout(null);
		
		
		add (push);
		add(clear);
		add(label);
		add(oddEven);
		setBackground(Color.cyan);
		setPreferredSize(new Dimension(395, 346));
		
		TextArea textArea = new TextArea();
		textArea.setBounds(10, 81, 380, 160);
		add(textArea);
		textArea.setText(myData.getStocksWeek(2, 2).toString());

		


	}

	private class ButtonListener implements ActionListener {
		public void actionPerformed (ActionEvent event){
			count++;
			label.setText ("Pushes: "+count);
			if (count%2==1)
				oddEven.setVisible(true);
			else
				oddEven.setVisible(false);
		}
	}	
	private class ButtonListener2 implements ActionListener {
		public void actionPerformed (ActionEvent event){
			count = 0;
			label.setText ("Pushes: "+count);
			oddEven.setVisible(false);
		}
	}
}
