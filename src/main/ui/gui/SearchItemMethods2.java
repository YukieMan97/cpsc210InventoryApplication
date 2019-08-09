package ui.gui;

import model.items.Figure;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SearchItemMethods2 implements Runnable {

    private JFrame searchItemFrame;
    private ChoseFigure choseFigure;
    private JTextField enterItemField;
    private ArrayList<Figure> figureArrayList;

    public SearchItemMethods2() {
        choseFigure = new ChoseFigure();
        figureArrayList = Figure.FIGURE_LIST;
    }

//    public void initiateSearch() {
//        searchItemFrame = new JFrame("Sakura Inventory Search Application");
//        searchItemFrame.getContentPane().setLayout(new FlowLayout());
//
////        TheHandler handler = new TheHandler();
//        enterItemField = new JTextField(10);
////        enterItemField.addActionListener(handler);
//        enterItemField.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                System.out.println(enterItemField);
////        choseFigure.checkFigure(enterItemField);
//
//                String cmd = e.getActionCommand();
//
//                JOptionPane.showMessageDialog(searchItemFrame, "Command: " + cmd);
//            }
//        });
//        searchItemFrame.getContentPane().add(new JLabel("Please enter a figure name"));
//        searchItemFrame.getContentPane().add(enterItemField);
////        choseFigure.checkFigure(enterItemField);
//
//
//        searchItemFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        searchItemFrame.setSize(220, 150);
//        searchItemFrame.setResizable(false);
//        searchItemFrame.setVisible(true);
//    }

//    @Override
//    public void actionPerformed(ActionEvent e) {
//        System.out.println(enterItemField);
//
////        choseFigure.checkFigure(enterItemField);
//
//        String cmd = e.getActionCommand();
//
//        JOptionPane.showMessageDialog(searchItemFrame, "Command: " + cmd);
//    }

    @Override
    public void run() {
        searchItemFrame = new JFrame("Sakura Inventory Search Application");
        searchItemFrame.getContentPane().setLayout(new FlowLayout());

//        TheHandler handler = new TheHandler();
        enterItemField = new JTextField(10);
//        enterItemField.addActionListener(handler);
        enterItemField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Figure f = choseFigure.checkFigure(enterItemField);
                if (f != null) {
                    JOptionPane.showMessageDialog(searchItemFrame, "This figure is found! " + f.getInformation());
                    // make another frame pop up
                    choseFigure.chosenFigureFrame(f);
                } else {
                    JOptionPane.showMessageDialog(searchItemFrame, "This figure is not found! Press Ok to try again.");
                }
            }
        });
        searchItemFrame.getContentPane().add(new JLabel("Please enter a figure name"));
        searchItemFrame.getContentPane().add(enterItemField);
//        choseFigure.checkFigure(enterItemField);


        frameSetUp();
    }

    public void frameSetUp() {
        searchItemFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        searchItemFrame.setSize(220, 150);
        searchItemFrame.setResizable(true);
        searchItemFrame.setVisible(true);
    }


//    private class TheHandler implements ActionListener {
//
//        @Override
//        public void actionPerformed(ActionEvent evt) {
//            String cmd = evt.getActionCommand();
//
//            if (evt.getSource() == enterItemField) {
//                String text = enterItemField.getText();
//                for (Figure f : figureArrayList) {
//                    if (f.containsNameOrTitle(text)) {
//                        String.format("Item Status: %s", evt.getActionCommand());
//                        return;
//                    } else {
//                        String.format("This figure is not found! Press Ok to try again.", evt.getActionCommand());
//                        return;
//                    }
//                }
//                JOptionPane.showMessageDialog(searchItemFrame, "Item Status: " + cmd);
//            }
//        }
//    }
}

