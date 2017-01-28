import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Random;

import javax.swing.JFrame;

public class Game extends JFrame implements Runnable , MouseMotionListener , MouseListener {
	
	Thread t1 , t2 , t3 , t4 , t5 , t6;
	int x1 , x2 , x3 , y1 , y2 , y3 , xm , ym , xr , yr;
	int f1 , f2 , f3 , f4 , f5;
	int n;
	int score , level;
	
	public Game() {
		t1 = new Thread(this);
		t2 = new Thread(this);
		t3 = new Thread(this);
		t4 = new Thread(this);
		t5 = new Thread(this);
		t6 = new Thread(this);

		
		x1 = 60;
		x2 = 160;
		x3 = 260;
		y1 = y2 = y3  = 0;
		f1 = f2 = f3 = f4 = f5 = 0;
		n = 10;
		xr = 100;
		yr = 0;
		
		score = 0;
		level = 0;
		
		xm = 200;
		ym = 500;
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		t6.start();
		
		this.setVisible(true);
		this.setSize(400, 600);
		this.setTitle("Bus Crash");
		this.setResizable(false);
		this.setCursor(Cursor.TEXT_CURSOR);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addMouseMotionListener(this);
		addMouseListener(this);
		
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		if(f4 == 1)
		{
			n = 100;
			g.setFont(new Font("Ariel", Font.BOLD, 30));
			g.setColor(Color.BLUE);
			g.drawString("Click to restart", 60, 580);

			g.setFont(new Font("Ariel", Font.BOLD, 50));
			g.setColor(Color.RED);
			g.drawString("Crash..."+score, 100, 300);
		}
		else if(f4 == 2)
		{
			n = 100;
			g.setFont(new Font("Ariel", Font.BOLD, 30));
			g.setColor(Color.BLUE);
			g.drawString("Click to restart", 60, 580);

			g.setFont(new Font("Ariel", Font.BOLD, 30));
			g.setColor(Color.RED);
			g.drawString("You Hit the Footpath..."+score, 40, 300);
		}
	
		else
		{
		g.setColor(Color.DARK_GRAY);
		g.fillRect(50, -100, 300, 800);
		
		g.setColor(Color.WHITE);
		g.drawLine(150, -100, 150, 700);
		g.drawLine(250, -100, 250, 700);
		
		g.setColor(Color.RED);

		g.fillRect(xr+50, yr-20, 20, 40);
		g.fillRect(x1+10, y1+20, 60, 60);
		g.setColor(Color.GREEN);
		g.fillRect(x2+10, y2-250+20, 60, 60);
		g.setColor(Color.BLUE);
		g.fillRect(x3+10, y3-350+20, 60, 60);
		g.setColor(new Color(250, 200, 250));
		
		g.fillRect(xm-10, ym-20, 20, 40);
		
		g.fillRect(50, 0, 300, 60);
		g.fillRect(50, 550, 300, 60);
		g.setFont(new Font("Ariel", Font.BOLD, 30));
		g.setColor(Color.BLUE);
		g.drawString(" Score : " +score +"    Level : "+level, 50, 50);
		g.drawString("    Click to restart", 60, 580);
		}
		
	}
	
	@Override
	public void run() {
		while(true){
			try
			{
				if(Thread.currentThread() == t1)
				{
					y1++;
					Thread.sleep(n);
					repaint();
				}
				if(Thread.currentThread() == t2)
				{
					y2++;
					Thread.sleep(n);
					repaint();
				}
				if(Thread.currentThread() == t3)
				{
					y3++;
					Thread.sleep(n);
					repaint();
				}
				
				if(Thread.currentThread() == t6)
				{
					yr++;
					Thread.sleep(n);
					repaint();
				}
				
				if(Thread.currentThread() == t4)
				{
					if(y1>700)
						f1 = 1;
					if(y2>850)
						f2 = 1;
					if(y3>950)
						f3 = 1;
					if(yr>700)
					{
						xr = new Random().nextInt(280);
						if(xr == 0 || (xr > 80 && xr < 100) || (xr > 180 && xr < 200) || (xr > 280))
						{
						yr = 0;
						}
					}
					Thread.sleep(500);
				}
				if(Thread.currentThread() == t5)
				{
					if(f1 == 1 && f4 != 1 && f4 != 2)
					{
						y1 = -100;
						f1 = 0;
						score++;
					}
					if(f2 == 1 && f4 != 1 && f4 != 2)
					{
						y2 = -250;
						f2 = 0;
						score++;

					}
					if(f3 == 1 && f4 !=1 && f4 != 2)
					{
						y3 = -100;
						f3 = 0;
						score++;

					}
					repaint();
					Thread.sleep(1000);
				}
					if(score >= 0 && score < 5)
					{
						n = 10;
						level = 1;
					}
					else if(score >= 5 && score < 10)
					{
						n = 9;
						level = 2;
					}
					else if(score >= 10 && score < 15)
					{
						n = 8;
						level = 3;
					}
					else if(score >= 15 && score < 20)
					{
						n = 7;
						level = 4;
					}
					else if(score >= 20 && score < 25)
					{
						n = 6;
						level = 5;
					}
					else if(score >= 25 && score < 30)
					{
						n = 5;
						level = 6;
					}
					else if(score >= 30 && score < 35)
					{
						n = 4;
						level = 7;
					}
					else if(score >= 35 && score < 40)
					{
						n = 3;
						level = 8;
					}
					else if(score >= 40 && score < 45)
					{
						n = 2;
						level = 9;
					}
					else
					{
						n = 1;
						level = 10;
					}
				
				if(f4 != 2 && ((xm>xr+40 && xm<xr+80 && ym>yr-40 && ym < yr+40) || (xm>x1 && xm < x1+80 && ym>y1 && ym < y1+100) || (xm>x2 && xm < x2+80 && ym>y2-250 && ym < y2-150) || (xm>x3 && xm < x3+80 && ym>y3-350 && ym < y3-250)))
				{	
					f4 = 1;	
					repaint();
				}
				else if(f4 != 1 && (xm-10 < 50 || xm+10>350))
				{
					f4 = 2;
				}
		
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		
	}
	
	public static void main(String[] args) {
		new Game();
	}

	@Override
	public void mouseDragged(MouseEvent e) {}

	@Override
	public void mouseMoved(MouseEvent e) {
		if(e.getX()<350 && e.getX() > 50 && e.getY()>60 && e.getY()<550)
		{
			xm = e.getX();
			ym = e.getY();
	}	}

	@Override
	public void mouseClicked(MouseEvent e) {
		f1 = 0;
		f2 = 0;
		f3 = 0;
		f4 = 0;
		score = 0;
		
	}

	@Override
	public void mousePressed(MouseEvent e) {}

	@Override
	public void mouseReleased(MouseEvent e) {}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}
}