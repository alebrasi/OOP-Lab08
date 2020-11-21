package it.unibo.oop.lab.mvcio2;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import it.unibo.oop.lab.mvcio.Controller;
import it.unibo.oop.lab.mvcio.SimpleGUI;
/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUIWithFileChooser {

    /*
     * TODO: Starting from the application in mvcio:
     * 
     * 1) Add a JTextField and a button "Browse..." on the upper part of the
     * graphical interface.
     * Suggestion: use a second JPanel with a second BorderLayout, put the panel
     * in the North of the main panel, put the text field in the center of the
     * new panel and put the button in the line_end of the new panel.
     * 
     * 2) The JTextField should be non modifiable. And, should display the
     * current selected file.
     * 
     * 3) On press, the button should open a JFileChooser. The program should
     * use the method showSaveDialog() to display the file chooser, and if the
     * result is equal to JFileChooser.APPROVE_OPTION the program should set as
     * new file in the Controller the file chosen. If CANCEL_OPTION is returned,
     * then the program should do nothing. Otherwise, a message dialog should be
     * shown telling the user that an error has occurred (use
     * JOptionPane.showMessageDialog()).
     * 
     * 4) When in the controller a new File is set, also the graphical interface
     * must reflect such change. Suggestion: do not force the controller to
     * update the UI: in this example the UI knows when should be updated, so
     * try to keep things separated.
     */

    private SimpleGUIWithFileChooser() {
        final SimpleGUI mainGui = new SimpleGUI();
        final Controller controller = mainGui.getController();
        final JPanel canvas = mainGui.getPanel();
        final JPanel innerCanvas = new JPanel();
        final JTextField textField = new JTextField(controller.getFilePath());
        final JButton browseButton = new JButton("Browse");

        textField.setEditable(false);
        innerCanvas.setLayout(new BorderLayout());
        innerCanvas.add(textField, BorderLayout.CENTER);
        innerCanvas.add(browseButton, BorderLayout.LINE_END);

        canvas.add(innerCanvas, BorderLayout.NORTH);

        browseButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent arg0) {
                final JFileChooser chooser = new JFileChooser();
                final int choice = chooser.showSaveDialog(innerCanvas);
                switch (choice) {
                    case JFileChooser.APPROVE_OPTION :
                        controller.setCurrentFile(chooser.getSelectedFile());
                        break;

                    case JFileChooser.CANCEL_OPTION :
                        break;
                default:
                    JOptionPane.showMessageDialog(innerCanvas, "An error occured");
                    break;
                }

                textField.setText(controller.getFilePath());
            }

        });
    }

    public static void main(final String... arg) {
        new SimpleGUIWithFileChooser();
    }
}
