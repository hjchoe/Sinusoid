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
class Panel extends JPanel
{
	private ArrayList<Coord> points;
	private Coord xpoint;
	Coord ypoint;
	private Theta theta;
	private int angle;
	private Indicator ind;
	double x = 0;
	double y = 0;
	
	public Panel()
	{
		points = new ArrayList<Coord>();
		theta = new Theta();
		xpoint = new Coord(0d, 0d, 5);
		ypoint = new Coord(0d, 0d, 5);
		xpoint.y = xpoint.translateX(130d);
		ypoint.x = ypoint.translateX(130d);
		ind = new Indicator();
		angle = 0;
		
		initUI();
	}

    private void initUI()
    {
    	setOpaque(true);
		setSize(new Dimension(500, 500));
		setLocation(0, 50);
		setBackground(new Color(255, 255, 255));
		setBorder(BorderFactory.createLineBorder(Color.BLUE));
		setFocusable(true);
		requestFocus();
		setLayout(null);
		
		add(theta);
    }
    
    @Override
	public void paintComponent(Graphics g)
	{
		Graphics2D g2d = (Graphics2D)g;
		super.paintComponent(g2d);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        for (Coord p : points)
        {
            g2d.setColor(Color.RED);
            g2d.fill(p);
        }
        
        g2d.setColor(Color.ORANGE);
        g2d.draw(xpoint);
        g2d.setColor(Color.GREEN);
        g2d.draw(ypoint);
        
        g2d.setColor(Color.CYAN);
        g2d.draw(ind);
        
        
        g2d.setColor(Color.BLACK);
        g2d.draw(new Line2D.Float(250f, 0f, 250f, 500f));
        g2d.setColor(Color.BLACK);
        g2d.draw(new Line2D.Float(0f, 250f, 500f, 250f));
	}
    
    public void tick()
    {
    	if (angle == 360)
    	{
    		angle = 0;
    		points.clear();
    	}
    	else angle++;
    	
    	theta.setText("θ = " + Integer.toString(angle) + "°");
		double th = (angle * Math.PI)/180;
		x = Math.cos(th) * 125;
		y = Math.sin(th) * 125;
		
		xpoint.x = xpoint.translateX(x);
		ypoint.y = ypoint.translateY(y);
		points.add(new Coord(x, y, 1));
		ind.x2 = xpoint.translateX(x);
		ind.y2 = ypoint.translateY(y);
		
		repaint();
    }
}
