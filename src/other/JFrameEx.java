package other;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class JFrameEx extends JFrame{

	public static void main(String[] args) {

		new JFrameEx().setVisible(true);
	}
	private JFrameEx(){
		super("Combats");
		setSize(800, 600); //1024x768, 800x600
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		setLayout(new FlowLayout());
		
		JButton button = new JButton("Inventory");
		
		add(button);
	}
}
