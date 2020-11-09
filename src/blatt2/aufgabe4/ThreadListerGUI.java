package blatt2.aufgabe4;

import blatt2.aufgabe3.ThreadLister;

import javax.accessibility.AccessibleValue;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ThreadListerGUI {
    JFrame window;

    ThreadListerGUI(){
        this.window = new JFrame();
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setVisible(true);
        window.setSize(400, 400);
        window.setTitle("ThreadLister");
        window.setLayout(new FlowLayout());
        initialize();
    }

    private void initialize(){
        JButton listButton = new JButton("List");
        JTextArea threadLabel = new JTextArea("");
        threadLabel.setSize(350, 350);
        listButton.setSize(100, 50);
        window.add(threadLabel);
        window.add(listButton);
        listButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ThreadLister t = new ThreadLister();
                threadLabel.setText(t.allThreadToString());

            }
        });
    }
    public static void main(String [] args){
        new ThreadListerGUI();
    }
}
