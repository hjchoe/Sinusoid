package sinusoidsim;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

@SuppressWarnings("serial")
class StartButton extends JButton
{
	StartButton()
	{
		setText("start");
		setSize(60, 20);
		setLocation(220, 575);
		setVisible(true);
		
		addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				if (!Main.state) Main.setState(true);
				else Main.setState(false);
			}
	    });
	}
}
