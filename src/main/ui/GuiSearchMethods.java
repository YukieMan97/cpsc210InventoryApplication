package ui;

import model.items.Book;
import model.items.Figure;

import javax.swing.*;
import javax.swing.plaf.ColorUIResource;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GuiSearchMethods {

    private JFrame searchItemFrame;
    private ChoseFigureOrBook choseFigureOrBook;
    private JTextField enterFigureField;
    private JTextField enterBookField;
    private ArrayList<Figure> figureArrayList;

    GuiSearchMethods() {
        choseFigureOrBook = new ChoseFigureOrBook();
        figureArrayList = Figure.FIGURE_LIST;
    }

    public void initiateSearch() {
        frameSetUp();
    }

    private void frameSetUp() {
        searchItemFrame = new JFrame("Sakura Inventory Search Application");
        searchItemFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        searchItemFrame.add(new MenuPane());
        searchItemFrame.setSize(350, 500);
        searchItemFrame.setResizable(true);
        searchItemFrame.setVisible(true);
    }

    public class MenuPane extends JPanel {

        MenuPane() {
            setLayout(new GridBagLayout());

            setOpaque(true);
            setBackground(Color.pink);

            JLabel welcomeMessage = new JLabel("Welcome to Sakura Inventory Search!");
            welcomeMessage.setFont(new Font("Tahoma", Font.PLAIN,18));
            JLabel searchMessage = new JLabel("Search for an item with the given options!");
            JLabel enterFigureNameLabel = new JLabel("1. Please enter a figure name:");
            JLabel enterBookNameLabel = new JLabel("2. Please enter a book title:");
            enterFigureField = new JTextField(10);
            enterBookField = new JTextField(10);

            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.ipadx = 20;
            gbc.ipady = 20;

            add(welcomeMessage, gbc);
            gbc.gridy += 2;
            add(searchMessage, gbc);
            gbc.gridy += 2;
            add(enterFigureNameLabel, gbc);
            gbc.gridy++;
            add(enterFigureField, gbc);
            gbc.gridy += 2;
            add(enterBookNameLabel, gbc);
            gbc.gridy++;
            add(enterBookField, gbc);


            searchItemFrame.getContentPane().setLayout(new BorderLayout());

            enterFigureField.addActionListener(new ActionListener() {
                //        TheHandler handler = new TheHandler();
                //        enterFigureField.addActionListener(handler);
                @Override
                public void actionPerformed(ActionEvent e) {
                    Figure f = choseFigureOrBook.checkFigure(enterFigureField);
                    ColorUIResource lightSkyBlue = new ColorUIResource(135,206,250);
                    UIManager.put("OptionPane.background", lightSkyBlue);
                    UIManager.put("Panel.background", lightSkyBlue);
                    if (f != null) {
                        JOptionPane.showMessageDialog(searchItemFrame, "This figure is found! " + f.getInformation());
                        // make another frame pop up
                        //choseFigureOrBook.chosenFigureFrame(f);
                    } else {
                        JOptionPane.showMessageDialog(searchItemFrame,
                                "This figure is not found! Press Ok to try again.");
                    }
                }
            });

            enterBookField.addActionListener(new ActionListener() {
                //        TheHandler handler = new TheHandler();
                //        enterFigureField.addActionListener(handler);
                @Override
                public void actionPerformed(ActionEvent e) {
                    Book b = choseFigureOrBook.checkBook(enterBookField);
                    ColorUIResource thistle = new ColorUIResource(216,191,216);
                    UIManager.put("OptionPane.background", thistle);
                    UIManager.put("Panel.background", thistle);
                    if (b != null) {
                        JOptionPane.showMessageDialog(searchItemFrame, "This book is found! " + b.getInformation());
                        // make another frame pop up
                        //choseFigureOrBook.chosenFigureFrame(b);
                    } else {
                        JOptionPane.showMessageDialog(searchItemFrame,
                                "This book is not found! Press Ok to try again.");
                    }
                }
            });
        }
    }


//    private class TheHandler implements ActionListener {
//
//        @Override
//        public void actionPerformed(ActionEvent evt) {
//            String cmd = evt.getActionCommand();
//
//            if (evt.getSource() == enterFigureField) {
//                String text = enterFigureField.getText();
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

