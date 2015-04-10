import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import javax.swing.JFrame;

class Robotm extends JFrame implements KeyListener {
	int count = 0;
	javax.swing.Timer timer;
	Robot robot;

	public Robotm() {
		Circle mouseDrawFrame = new Circle();

		mouseDrawFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mouseDrawFrame.setSize(600, 800); // set frame size
		mouseDrawFrame.setVisible(true); // display frame
		RandomDraw();
		mouseDrawFrame.addKeyListener(this);
	}

	public void RandomDraw() {

		try {

			robot = new Robot();

			ActionListener listen = new ActionListener() {
				public void actionPerformed(ActionEvent eve) {
					Random rand = new Random();
					if (count > 60)
						timer.stop();
					count++;
					int x = rand.nextInt(600);// pick a random location
					int y = rand.nextInt(800);
					robot.mouseMove(x, y);
					robot.mousePress(InputEvent.BUTTON1_MASK);// simulate a
																// click, call
																// circle class
																// to draw
					robot.mouseRelease(InputEvent.BUTTON1_MASK);

				}
			};
			timer = new javax.swing.Timer(1000, listen);
			timer.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {

		new Robotm();
	}

	@Override
	public void keyPressed(KeyEvent e) {

		if (e.getKeyCode() == KeyEvent.VK_R) {
			System.out.println(e + "KEY PRESSED");

		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_R) {
			System.out.println(e + "KEY RELEASED: ");
			new Robotm();
		}

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}
}