package demo;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

///////////////////////////////////////////////////// DemoDrawing2
public class DemoDrawing2 extends JFrame {

    //===================================================== fields
    private DrawingArea left = new DrawingArea();
    private DrawingArea rite = new DrawingArea();

    //================================================ Constructor
    public DemoDrawing2() {
        left.setBackground(Color.white);
        rite.setBackground(Color.black);

        JButton changeColorBtn = new JButton("Randomize Colors");
        changeColorBtn.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    left.setMyColor(randomColor());
                    rite.setMyColor(randomColor());
                }
            });

        //... Add components to layout
        JPanel content = new JPanel();
        content.setLayout(new BorderLayout(5, 5));
        content.add(changeColorBtn, BorderLayout.NORTH);
        content.add(left, BorderLayout.WEST);
        content.add(rite, BorderLayout.EAST);

        //... Set window characteristics
        setContentPane(content);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Demo Drawing");
        setLocationRelativeTo(null);  // Center window.
        pack();
    }


    //=================================================== randomColor
    private static Color randomColor() {
        return new Color((int) (Math.random() * 256),  // Red
                         (int) (Math.random() * 256),  // Green
                         (int) (Math.random() * 256)); // Blue
    }


    //========================================================== main
    public static void main(String[] args) {
        JFrame window = new DemoDrawing2();
        window.setVisible(true);
    }
}