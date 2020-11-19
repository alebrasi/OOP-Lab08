/**
 * 
 */
package it.unibo.oop.lab.simplegui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.LayoutManager;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * This class is a simple application that writes a random number on a file.
 * 
 * This application does not exploit the model-view-controller pattern, and as
 * such is just to be used to learn the basics, not as a template for your
 * applications.
 */
public class MiniGUI {

    private static final String TITLE = "A very simple GUI application";
    private static final int PROPORTION = 5;
    private final Random rng = new Random();
    private final JFrame frame = new JFrame(TITLE);

    /**
     * 
     */
    public MiniGUI() {
        final JPanel canvas = new JPanel();
        canvas.setLayout(new BorderLayout());
        final JButton write = new JButton("Print a random number on standard output");
        canvas.add(write, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setContentPane(canvas);

        //Ex 01.01
        firstEx(write, canvas);

        //Ex 01.02
        final TextField result = new TextField();

        canvas.add(result, BorderLayout.NORTH);

        /*
         * Handlers
         */
        write.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                //System.out.println(rng.nextInt());
                result.setText(String.valueOf(rng.nextInt()));
            }
        });
    }

    private void firstEx(final JButton btn, final JPanel canvas) {
        final JPanel p1 = new JPanel();
        p1.setLayout(new BoxLayout(p1, BoxLayout.LINE_AXIS));
        p1.add(btn, BorderLayout.CENTER);
        canvas.add(p1, BorderLayout.CENTER);
    }

    private void display() {
        /*
         * Make the frame one fifth the resolution of the screen. This very method is
         * enough for a single screen setup. In case of multiple monitors, the
         * primary is selected. In order to deal coherently with multimonitor
         * setups, other facilities exist (see the Java documentation about this
         * issue). It is MUCH better than manually specify the size of a window
         * in pixel: it takes into account the current resolution.
         */
        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screen.getWidth();
        final int sh = (int) screen.getHeight();
        frame.setSize(sw / PROPORTION, sh / PROPORTION);
        /*
         * Instead of appearing at (0,0), upper left corner of the screen, this
         * flag makes the OS window manager take care of the default positioning
         * on screen. Results may vary, but it is generally the best choice.
         */
        frame.setLocationByPlatform(true);
        /*
         * OK, ready to pull the frame onscreen
         */
        frame.setVisible(true);
        frame.pack();
    }
    
    /**
     * @param args ignored
     */
    public static void main(final String... args) {
       new MiniGUI().display();
    }

}
