package driver;
import java.awt.Color; //import package awt
import javax.swing.JFrame; //import package swing
import java.awt.Container; //import Container from AWT
class MyFrame extends JFrame { 
    public MyFrame () {
        Container pane = this.getContentPane(); // get the content pane of the frame
        pane.setBackground(Color.MAGENTA); // set background color to MAGENTA.
    }
    public static void main(String[] args) { 
        MyFrame frame = new MyFrame(); // create frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("My GUI Frame"); // set title
        frame.setSize(350, 250); // set size
        frame.setVisible(true); // set visible
    }
}












