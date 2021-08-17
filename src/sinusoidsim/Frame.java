package sinusoidsim;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;

@SuppressWarnings("serial")
class Frame extends JFrame
{
	protected Panel p;
	protected TrigPanel tp;
	public StartButton b;
	public static Boolean state = false;

	public Frame()
	{
	    initUI();
	}
	
	private void initUI()
	{  
	    p = new Panel();
	    tp = new TrigPanel();
	    b = new StartButton();
		
	    setTitle("Sinusoid Simulation");
        setPreferredSize(new Dimension(1000, 650));
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBackground(new Color(255, 255, 255));
    	pack();
		setLocationRelativeTo(null);
        setVisible(true);
		setFocusable(false);
		setLayout(null);
		
		add(p);
		add(tp);
		add(b);
	}
}

