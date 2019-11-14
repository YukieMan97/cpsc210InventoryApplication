package ui.gui;

import model.items.Book;
import model.items.Figure;

import javax.swing.*;
import javax.swing.plaf.ColorUIResource;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static javax.swing.JOptionPane.*;

public class GuiSearchMethods {

    private JFrame searchItemFrame;
    private ChoseFigureOrBook choseFigureOrBook;
    private JTextField enterFigureField;
    private JTextField enterBookField;
    private JButton seeFeaturedItem;
    private ArrayList<Figure> figureArrayList;

    private GuiSearchMethods() {
        choseFigureOrBook = new ChoseFigureOrBook();
        figureArrayList = Figure.FIGURE_LIST;
    }

    public static void main(String[] args) {
        GuiSearchMethods guiSearchMethods = new GuiSearchMethods();
        guiSearchMethods.initiateSearch();
    }

    private void initiateSearch() {
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
            JLabel emptySpace = new JLabel("");
            welcomeMessage.setFont(new Font("Tahoma", Font.PLAIN,18));
            JLabel searchMessage = new JLabel("Search for an item with the given options!");
            searchMessage.setFont(new Font("Tahoma", Font.PLAIN,15));
            JLabel enterFigureNameLabel = new JLabel("1. Please enter a figure name:");
            JLabel enterBookNameLabel = new JLabel("2. Please enter a book title:");
            enterFigureField = new JTextField(10);
            enterBookField = new JTextField(10);
            seeFeaturedItem = new JButton("See Today's Featured Item!");

            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.ipadx = 20;
            gbc.ipady = 20;

            add(welcomeMessage, gbc);
            gbc.gridy++;
            add(seeFeaturedItem, gbc);
            gbc.gridy++;
            add(emptySpace, gbc);
            gbc.gridy++;
            add(searchMessage, gbc);
            gbc.gridy++;
            add(enterFigureNameLabel, gbc);
            gbc.gridy++;
            add(enterFigureField, gbc);
            gbc.gridy++;
            add(enterBookNameLabel, gbc);
            gbc.gridy++;
            add(enterBookField, gbc);

            searchItemFrame.getContentPane().setLayout(new BorderLayout());

            seeFeaturedItem.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    UIManager.put("OptionPane.background", Color.pink);
                    UIManager.put("Panel.background", Color.pink);
                    String specialFeatureMessage = "<html>(ﾉ^ヮ^)ﾉ*:・ﾟ✧ Today's featured item is Albedo "
                            + "#642 Nendoroid for only " + "<li><b>80.99</b>"
                            + " !!! Wow! What a steal!!! ✧ﾟ・:ヾ(≧∇≦*)ゝ</ul></html>";
                    JLabel label = new JLabel(specialFeatureMessage);
                    label.setFont(new Font("Tahoma", Font.PLAIN, 10));
                    JOptionPane.showMessageDialog(searchItemFrame, specialFeatureMessage);
                }
            });

            TheFigureHandler tfh = new TheFigureHandler();
            enterFigureField.addActionListener(tfh);

            TheBookHandler theBookHandler = new TheBookHandler();
            enterBookField.addActionListener(theBookHandler);
        }
    }

    private class TheFigureHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent evt) {
            Figure f = choseFigureOrBook.checkFigure(enterFigureField);
            ColorUIResource lightSkyBlue = new ColorUIResource(135,206,250);
            UIManager.put("OptionPane.background", lightSkyBlue);
            UIManager.put("Panel.background", lightSkyBlue);
            if (f != null) {
                String figureFound = "This figure is found! " + f.getInformation() + ". ";
                Object[] options1 = {"Purchase This Item", "Change Quantity", "Quit"};
                JOptionPane.showConfirmDialog(searchItemFrame, figureFound);
                int result = JOptionPane.showOptionDialog(searchItemFrame, figureFound, "Title",
                        JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null,
                        options1, null);

                // TODO can't buy if there is 0 left

                if (result == YES_OPTION) {
                    f.purchaseItem();
                    String purchaseFigure = "Thanks for your purchase! There is only " + f.getQuantity()
                            + " of " + f.getName() + " left!";
                    JOptionPane.showMessageDialog(searchItemFrame, purchaseFigure);
                }

                if (result == NO_OPTION) {
                    String changeQuantity = "Reason for changing quantity?";
                    JOptionPane.showInputDialog(searchItemFrame, changeQuantity);
                }
            } else {
                JLabel figureNotFound = new JLabel("This figure is not found! Press Ok to try again.");
                ColorUIResource fireBrick = new ColorUIResource(178, 34, 34);
                figureNotFound.setForeground(fireBrick);
                JOptionPane.showMessageDialog(searchItemFrame, figureNotFound);
            }
        }
    }

    private class TheBookHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent evt) {
            Book b = choseFigureOrBook.checkBook(enterBookField);
            ColorUIResource thistle = new ColorUIResource(216,191,216);
            UIManager.put("OptionPane.background", thistle);
            UIManager.put("Panel.background", thistle);
            if (b != null) {
                String bookFound = "This book is found! " + b.getInformation() + ".";
                Object[] options1 = {"Purchase This Item", "Change Quantity", "Quit"};
                int result = JOptionPane.showOptionDialog(searchItemFrame, bookFound, "Title",
                        JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null,
                        options1, null);

                // TODO can't buy if there is 0 left
                // and when there is at most three of the same item

                if (result == YES_OPTION) {
                    b.purchaseItem();
                    String purchaseBook = "Thanks for your purchase! There is only " + b.getQuantity()
                            + " of " + b.getTitle() + " left!";
                    JOptionPane.showMessageDialog(searchItemFrame, purchaseBook);
                }

                if (result == NO_OPTION) {
                    String changeQuantity = "Reason for changing quantity?";
                    JOptionPane.showInputDialog(searchItemFrame, changeQuantity);
                }

                if (result == CANCEL_OPTION) {
                    System.exit(0);
                }
            } else {
                JLabel bookNotFound = new JLabel("This book is not found! Press Ok to try again.");
                ColorUIResource fireBrick = new ColorUIResource(178, 34, 34);
                bookNotFound.setForeground(fireBrick);
                JOptionPane.showMessageDialog(searchItemFrame, bookNotFound);
            }
        }
    }
}

