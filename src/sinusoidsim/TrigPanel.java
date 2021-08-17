package sinusoidsim;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Line2D;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

@SuppressWarnings("serial")
class TrigPanel extends JPanel
{
	private ArrayList<Coord> spoints;
	private ArrayList<Coord> cpoints;
	private ArrayList<Coord> tpoints;
	int xvalue = -250;
	private Indicator sInd;
	private Indicator cInd;
	private Coord translator = new Coord(0, 0, 1);
	
	public TrigPanel()
	{
		spoints = new ArrayList<Coord>();
		cpoints = new ArrayList<Coord>();
		tpoints = new ArrayList<Coord>();
		
		sInd = new Indicator();
		sInd.x1 = 0d;
		sInd.y1 = 250d;
		cInd = new Indicator();
		cInd.x1 = 0d;
		cInd.y1 = 250d;
		
		initUI();
	}

    private void initUI()
    {
    	setOpaque(true);
		setSize(new Dimension(500, 500));
		setLocation(500, 50);
		setBackground(new Color(255, 255, 255));
		setBorder(BorderFactory.createLineBorder(Color.BLUE));
		setFocusable(true);
		requestFocus();
		setLayout(null);
    }
    
    @Override
	public void paintComponent(Graphics g)
	{
		Graphics2D g2d = (Graphics2D)g;
		super.paintComponent(g2d);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        for (Coord p : spoints)
        {
            g2d.setColor(Color.GREEN);
            g2d.fill(p);
        }
        for (Coord p : cpoints)
        {
            g2d.setColor(Color.ORANGE);
            g2d.fill(p);
        }
        for (Coord p : tpoints)
        {
            g2d.setColor(Color.MAGENTA);
            g2d.fill(p);
        }
        
        g2d.setColor(Color.BLACK);
        g2d.draw(new Line2D.Float(0f, 250f, 500f, 250f));
        
        g2d.setColor(Color.GREEN);
        g2d.draw(sInd);
        g2d.setColor(Color.ORANGE);
        g2d.draw(cInd);
	}
    
    public void sinTick(double syvalue, double cyvalue)
    {
    	if (xvalue == 250)
		{
    		xvalue = -250;
    		spoints.clear();
    		cpoints.clear();
    		tpoints.clear();
		}
    	else xvalue++;
    	spoints.add(new Coord(xvalue, syvalue, 1));
    	cpoints.add(new Coord(xvalue, cyvalue, 1));
    	tpoints.add(new Coord(xvalue, syvalue/cyvalue, 1));
    	
    	sInd.x2 = translator.translateX(xvalue);
		sInd.y2 = translator.translateY(syvalue);
		sInd.y1 = translator.translateY(syvalue);
    	cInd.x2 = translator.translateX(xvalue);
		cInd.y2 = translator.translateY(cyvalue);
		cInd.y1 = translator.translateY(cyvalue);
    	
    	repaint();
    }
}
