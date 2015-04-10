

// Demonstrating mouse events.
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseEvent;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Circle extends JFrame
{
   private static final Color[] ColorArray = {Color.BLACK, Color.RED, Color.YELLOW, Color.BLUE};
private JPanel mousePanel; // panel in which mouse events will occur
   private JLabel statusBar; // label that displays event information



   // MouseTrackerFrame constructor sets up GUI and 
   // registers mouse event handlers
   
   public Circle()
   {
      super( "Demonstrating Mouse Events" );
      
      

      mousePanel = new JPanel(); // create panel
      mousePanel.setBackground( Color.WHITE ); // set background color
      add( mousePanel, BorderLayout.CENTER ); // add panel to JFrame

      statusBar = new JLabel( "Mouse outside JPanel" ); 
      add( statusBar, BorderLayout.SOUTH ); // add label to JFrame

      // create and register listener for mouse and mouse motion events
      
      MouseHandler handler = new MouseHandler(); 
      mousePanel.addMouseListener( handler ); 
      mousePanel.addMouseMotionListener( handler ); 
   } // end MouseTrackerFrame constructor

   private class MouseHandler implements MouseListener, 
      MouseMotionListener 
   {
      // MouseListener event handlers
      // handle event when mouse released immediately after press
      public void mouseClicked( MouseEvent event )
      {
         statusBar.setText( String.format( "Clicked at [%d, %d]", 
            event.getX(), event.getY() ) );
         
         draw(event.getX(), event.getY());
         
         
          
      } // end method mouseClicked

      // handle event when mouse pressed
      public void mousePressed( MouseEvent event )
      {
         statusBar.setText( String.format( "Pressed at [%d, %d]", 
            event.getX(), event.getY() ) );
         


         
 
      } // end method mousePressed

      // handle event when mouse released 
      public void mouseReleased( MouseEvent event )
      {
         statusBar.setText( String.format( "Released at [%d, %d]", 
            event.getX(), event.getY() ) );
         
      } // end method mouseReleased

      

 // handle event when mouse enters area
      public void mouseEntered( MouseEvent event )
      {
         statusBar.setText( String.format( "Mouse entered at [%d, %d]", 
            event.getX(), event.getY() ) );
         mousePanel.setBackground( Color.GREEN );
         
      } // end method mouseEntered

      // handle event when mouse exits area
      public void mouseExited( MouseEvent event )
      {
        statusBar.setText( "Mouse outside JPanel" );
//         mousePanel.setBackground( Color.WHITE );
      } // end method mouseExited

      // MouseMotionListener event handlers
      // handle event when user drags mouse with button pressed
      public void mouseDragged( MouseEvent event )
      {
         statusBar.setText( String.format( "Dragged at [%d, %d]", 
            event.getX(), event.getY() ) );
         

         
      } // end method mouseDragged

      // handle event when user moves mouse
      public void mouseMoved( MouseEvent event )
      {
         statusBar.setText( String.format( "Moved at [%d, %d]", 
            event.getX(), event.getY() ) );
      } // end method mouseMoved
   } // end inner class MouseHandler

private void draw(int x, int y) {
  // TODO Auto-generated method stub
 
       Graphics g = this.getGraphics();
      // g.setColor(getRandomColor());
          //g.setColor(Color.BLACK);
       Random rand = new Random();
       int col =rand.nextInt(4);
       g.setColor(ColorArray[col]);
          g.fillOval(x, y, 36, 36);
 }


}
