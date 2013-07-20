package testing;
import java.awt.*;
import java.awt.event.*;
import java.applet.Applet;

public class MyApplet extends Applet
                         implements ActionListener, MouseListener
{

  private String message;       // The message text
  private int x, y;             // Its coordinates
  private TextField textEntry;
  private Button enter;
  private Button clear;

  public void init() {

    message = "Hello World!";
    x = 60; y = 100;
    textEntry = new TextField("Replace me!", 100);  // 20 columns
    resize(1000, 500);

    enter = new Button("Enter");
    clear = new Button("Clear");
    add(textEntry);
    add(clear);
    add(enter);
    clear.addActionListener(this);
    enter.addActionListener(this);
    addMouseListener(this);

  }

  public void paint(Graphics g) {

    g.drawString(message, x, y);

  }

  public void actionPerformed(ActionEvent e) {

    // Might be a click
    // on enter button :          set up new message,
    // or on clear button :       clear textEntry

    if (e.getSource() == clear)
      textEntry.setText("");
    if (e.getSource() == enter) {
      message = textEntry.getText();
      textEntry.setText("");
    }
    repaint();

  }

    public void mouseClicked(MouseEvent e) {

        x = e.getX();
        y = e.getY();
        repaint();

    }

    public void mouseExited(MouseEvent e) { }

    public void mouseEntered(MouseEvent e) { }

    public void mousePressed(MouseEvent e) { }

    public void mouseReleased(MouseEvent e) { }

}
