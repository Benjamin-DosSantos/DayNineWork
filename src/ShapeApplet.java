import java.applet.Applet;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.util.Random;

public class ShapeApplet extends Applet{
	
	static Random ran = new Random();
	
	static Color bgcolor = Color.DARK_GRAY;
	
	static Graphics g;
	
	static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	static int screen_width = (int)(screenSize.getWidth());
	static int screen_height = (int)(screenSize.getHeight());
	
	
	public void init(){
		this.setSize(new Dimension(screen_width, screen_height));
		this.setBackground(bgcolor);
	}// End of init
	
	public void paint(Graphics g){
		this.g = g;
		for(int i = 0; i <= 100; i++){
			drawShape();
		}
	}// End of paint method
	
	public void drawShape(){
		int choice = selectShape();
		
		if(choice == 0){
			drawOval();
		}else if(choice == 1){
			drawRectangle();
		}else if(choice == 2){
			drawLine();
		}else{
			drawArc();
		}
	}// End of drawShape method
	
	public int selectShape(){
		 return ran.nextInt(4);
	}// End of selectShape method
	
	public void drawOval(){
		int xPos = ran.nextInt(450) + 50,
			yPos = ran.nextInt(300) + 600,
			width = ran.nextInt(200) + 50,
			height = ran.nextInt(125) + width/2;
	
		g.setColor(selectColor());
		g.fillOval(xPos, yPos, width, height);
	}// End of drawOval method

	public void drawRectangle(){
		int xPos = ran.nextInt(750) + 50,
			yPos = ran.nextInt(xPos / 2),
			width = ran.nextInt(100) + 100,
			height = ran.nextInt(100) + 100;
			
		if(height == width){
			height -= 1;
		}
			
		g.setColor(selectColor());
		g.fillRect(xPos, yPos, width, height);
	}// End of drawRectangle method
	
	public void drawLine(){
		int xPos = ran.nextInt(screen_width),
			yPos = ran.nextInt(screen_height),
			xDif = (ran.nextInt(40) + 10),
			yDif = (ran.nextInt(40) + 10),
			xPos2 = ran.nextInt(xPos),
			yPos2 = ran.nextInt(xPos);
				
		if(ran.nextInt(1) == 0){
			xDif *= -1;
		}
		
		if(ran.nextInt(1) == 0){
			yDif *= -1;
		}
		
		xPos2 += xDif;
		yPos2 += yDif;
		
		g.setColor(selectColor());
		g.drawLine(xPos, yPos, xPos2, yPos2);
	}// End of drawLine method
	
	public void drawArc(){
		int xPos = ran.nextInt(screen_width),
			yPos = ran.nextInt(screen_height),
			width = ran.nextInt(275) + 75,
			height = ran.nextInt(275) + 75,
			startPos = ran.nextInt(365),
			degrees = ran.nextInt(314) + 50;
					
		g.setColor(selectColor());
		g.fillArc(xPos, yPos, width, height, startPos, degrees);
	}// End of drawArk method
	
	private Color selectColor() {
		Color shapeColor = new Color(ran.nextInt(255), ran.nextInt(255), ran.nextInt(255));
		return shapeColor;
	}// End of selectColor method
}// End of class
