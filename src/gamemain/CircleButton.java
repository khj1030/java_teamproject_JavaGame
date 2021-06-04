package gamemain;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JButton;

public class CircleButton extends JButton {
   private Color backColor; //���� ����
   private Color textColor; //���ڻ� ����
   
   public Color getBackColor() {
	   return this.backColor;
   }
   
   public Color getTextColor() {
	   return this.textColor;
   }
   
   public void setBackColor(Color color) {
	   this.backColor = color;
   }
   
   public void setTextColor(Color color) {
	   this.textColor = color;
   }
   
   public CircleButton() { 
	   super(); 
	   decorate(); 
   } 
   public CircleButton(String text) { 
	   super(text); 
	   decorate(); 
   } 
   public CircleButton(Action action) { 
	   super(action); 
	   decorate(); 
   } 
   public CircleButton(Icon icon) { 
	   super(icon); 
	   decorate(); 
   } 
   public CircleButton(String text, Icon icon) { 
	   super(text, icon); 
	   decorate(); 
   } 
   protected void decorate() { 
	   setBorderPainted(false); 
	   setOpaque(false); 
   }
   
   @Override 
   protected void paintComponent(Graphics g) {
	   
	   int width = getWidth(); 
	   int height = getHeight(); 
	   
	   Graphics2D graphics = (Graphics2D) g;
	   
	   graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); 
	   if (getModel().isArmed()) { 
		   graphics.setColor(getBackColor().darker()); 
	   } else if (getModel().isRollover()) { 
		   graphics.setColor(getBackColor().brighter()); 
	   } else { 
		   graphics.setColor(getBackColor()); 
	   } 
	   graphics.fillArc(0, 0, width, height, 0, 360); 
	   
	   FontMetrics fontMetrics = graphics.getFontMetrics(); 
	   Rectangle stringBounds = fontMetrics.getStringBounds(this.getText(), graphics).getBounds(); 
	   
	   int textX = (width - stringBounds.width) / 2; 
	   int textY = (height - stringBounds.height) / 2 + fontMetrics.getAscent(); 
	   
	   graphics.setColor(textColor); 
	   graphics.setFont(getFont()); 
	   graphics.drawString(getText(), textX, textY); 
	   graphics.dispose(); 
	   
	   super.paintComponent(g); 
	     
   }

}
