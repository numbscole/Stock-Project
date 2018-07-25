package guiIntro;

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

public class PushCounterPanel extends JPanel{
	private int count;
	private JButton push;
	private JButton clear;
	private JLabel label;
	private JLabel oddEven;
	private ImageData myImages;
	private JLabel label_1;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	
	public PushCounterPanel() {
		myImages = new ImageData();
		
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
		
		label_1 = new JLabel("temp");
		label_1 = new JLabel(myImages.getImage(0));
		label_1.setSize(myImages.getImage(0).getIconWidth(), myImages.getImage(0).getIconHeight());
		label_1.setBounds(34, 39, 187, 236);
		add(label_1);
		
		for (int i=0; i<myImages.getImageCount(); i++) {
			JRadioButton rdbtnNewRadioButton = new JRadioButton(myImages.getName(i));
			rdbtnNewRadioButton.setName(""+i);
			rdbtnNewRadioButton.addActionListener(new RadioButtonListener());
			buttonGroup.add(rdbtnNewRadioButton);
			rdbtnNewRadioButton.setBounds(256, 104+40*i, 109, 23);
			add(rdbtnNewRadioButton);			
		}	

	}
	private class RadioButtonListener implements ActionListener {
		public void actionPerformed (ActionEvent event){
            JRadioButton btn = (JRadioButton) event.getSource();
            label_1.setIcon(myImages.getImage(Integer.parseInt(btn.getName())));
		}
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
