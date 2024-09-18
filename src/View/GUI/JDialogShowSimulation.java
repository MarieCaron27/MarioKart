package View.GUI;

import Model.Entities.Simulation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JDialogShowSimulation extends JDialog
{
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField showTime;

    public JDialogShowSimulation(Simulation simulation)
    {
        // Initialisation du contentPane
        contentPane = new JPanel();
        contentPane.setLayout(new GridLayout(2,1));

        // Initialisation des boutons
        buttonOK = new JButton("OK");
        buttonCancel = new JButton("Cancel");

        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        // Configuration de la fenêtre principale
        setTitle("Temps de parcours");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(2,1));

        showTime = new JTextField("Temps de parcours : " + simulation.calculateTime());
        showTime.setEditable(false);

        JPanel row1 = new JPanel(new GridLayout(1, 1));
        row1.add(new JScrollPane(showTime));

        JPanel row2 = new JPanel(new GridLayout(1, 2));

        buttonOK.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        row2.add(buttonOK);
        row2.add(buttonCancel);

        contentPane.add(row1);
        contentPane.add(row2);

        setSize(350, 400);
        setContentPane(contentPane);
    }

    private void onOK()
    {
        dispose();
    }

    private void onCancel()
    {
        dispose();
    }
}
