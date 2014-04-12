package other;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class hpbar {

	final static int interval = 1000;
	int i;
	Timer t;
	JButton btn;
	JProgressBar prg;

	// creating the constructor of HPBAR
	public hpbar() {
		// Creating the FRAME
		JFrame frame = new JFrame();

		// Creating the Frame Layout
		frame.setLayout(new FlowLayout());

		// Creating the button
		btn = new JButton("Start Ticking");

		// Creating Button Action Listener
		btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent ae) { // Settin Action
															// Performed

				i = 0; // Counter
				t.start(); // Start Timer
				btn.setEnabled(false); // Button Enabled = FALSE

			}
		});

		// Creating the Progress Bar
		prg = new JProgressBar(0, 100); // settng Min = 0 and Max to 50
		prg.setValue(0); // Set value at start
		prg.setStringPainted(true); // Set painted string in the progress bar

		frame.add(prg); // Set the probress bar to the frame
		frame.add(btn); // set the button next to the progressbar

		// creating new timer
		t = new Timer(interval, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) { // action performerd in
															// the timer

				if (i == 100) { // if counter i is equal to maximum
					t.stop(); // than timer stops ticking
					btn.setEnabled(true); // button is enabled = TRUE
				} else { // Else
					i++; // timer + 1
					prg.setValue(i); // progress bar get the value of i
				}

			}
		});

		frame.setVisible(true); // setting the frame to VISIBLE
		frame.setSize(300, 300); // setting the size of the frame
	}

	public static void main(String[] args) {
		hpbar jp = new hpbar(); // Run new Hp Bar :) 
	}

}
