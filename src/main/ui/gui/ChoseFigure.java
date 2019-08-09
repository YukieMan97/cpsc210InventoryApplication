package ui.gui;

import model.items.Figure;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ChoseFigure extends JFrame {
    private ArrayList<Figure> figureArrayList;
    private JFrame chosenFigureFrame;

    public ChoseFigure() {
        figureArrayList = Figure.FIGURE_LIST;
    }


    public Figure checkFigure(JTextField enterItemField) {
        String text = enterItemField.getText();
        for (Figure f : figureArrayList) {
            if (f.containsNameOrTitle(text)) {
//                chosenFigureFrame(f);
                return f;
            }
        }
        return null;
    }

    public void chosenFigureFrame(Figure figure) {
        chosenFigureFrame = new JFrame("To Do With Figure");
        chosenFigureFrame.getContentPane().setLayout(new FlowLayout());

        JLabel figureStatus = new JLabel("This figure is found!" + figure.getInformation());
        add(figureStatus);

        JLabel toDoWithFigure = new JLabel("What would you like to do with this figure?");
        add(toDoWithFigure);

        TheHandler handler = new TheHandler();
        JTextField purchaseFigureField = new JTextField();
        purchaseFigureField.addActionListener(handler);
        chosenFigureFrame.getContentPane().add(purchaseFigureField);
    }

    private class TheHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String cmd = e.getActionCommand();
            JOptionPane.showMessageDialog(chosenFigureFrame, "Purchase?" + cmd);
        }
    }
}


