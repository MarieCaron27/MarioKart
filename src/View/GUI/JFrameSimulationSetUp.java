package View.GUI;

import Model.DAO.DAOCircuit;
import Model.DataAccessLayerCircuit;
import Model.Entities.*;
import View.ViewSimulation;

import javax.swing.*;
import java.awt.*;

public class JFrameSimulationSetUp extends JFrame implements ViewSimulation
{
    private JPanel contentPane;
    private Simulation simulation;
    private Circuit selectedCircuit = null;
    private final Vehicule myVehicule;
    private final JButton confirmButton;
    private final JLabel rainLabel;
    private final JSlider slider;

    public JFrameSimulationSetUp(Vehicule vehicule)
    {
        contentPane = new JPanel();

        setTitle("Sélection de Circuit");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        myVehicule = vehicule;
        simulation = new Simulation(selectedCircuit, myVehicule, 0.0f);

        JPanel row1 = new JPanel();
        row1.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));

        for (int i = 1; i <= 2; i++)
        {
            JButton circuitButton = new JButton(new ImageIcon("C:\\Users\\Utilisateur\\IdeaProjects\\Laboratoire_conception_voitures\\src\\Model\\Pictures\\Track\\circuit_" + i + ".png"));
            circuitButton.setText("Circuit " + i);
            circuitButton.setPreferredSize(new Dimension(300, 300));
            circuitButton.addActionListener(e -> selectedCircuit = getCircuitByName(((JButton) e.getSource()).getText()));

            row1.add(circuitButton);
        }

        add(row1, BorderLayout.NORTH);

        JPanel row2 = new JPanel();
        row2.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 0));

        rainLabel = new JLabel();
        rainLabel.setText("Indice de pluie: ");
        row2.add(rainLabel);

        slider = new JSlider(0, 10, 5);
        slider.setMajorTickSpacing(1);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.setLabelTable(slider.createStandardLabels(1));
        row2.add(slider);

        confirmButton = new JButton("Confirmer");

        confirmButton.addActionListener(e ->
        {
            if (selectedCircuit != null)
            {
                System.out.println(selectedCircuit.getName());
                Simulation simulation = new Simulation(selectedCircuit, myVehicule, slider.getValue() / 10.0);
                JDialogShowSimulation dialogWindow = new JDialogShowSimulation(simulation);
                dialogWindow.setVisible(true);
            }
            else
            {
                showErrorMessage("Veuillez sélectionner le circuit");
            }
        });

        row2.add(confirmButton);
        add(row2, BorderLayout.SOUTH);

        contentPane.add(row1);
        contentPane.add(row2);

        setSize(800, 500);
        setContentPane(contentPane);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private Circuit getCircuitByName(String name)
    {
        DataAccessLayerCircuit daoCircuit = new DAOCircuit();

        if(name.equals("Circuit 1")  || name.equals("Circuit 2"))
        {
            return daoCircuit.getCircuitByName(name);
        }

        return daoCircuit.getCircuitByName(name);
    }

    @Override
    public Simulation addSimulation()
    {
        return null;
    }

    @Override
    public void runSimulation()
    {
        setVisible(true);
    }

    @Override
    public void showErrorMessage(String message)
    {
        JOptionPane.showMessageDialog(this, message, "Pour votre information...", JOptionPane.ERROR_MESSAGE);
    }

    public void main(String[] args)
    {
        Vehicule vehicule = new Vehicule(myVehicule.getBody(),myVehicule.getPilot(),myVehicule.getTire());

        JFrameSimulationSetUp fenetreSimulation = new JFrameSimulationSetUp(vehicule);
        fenetreSimulation.addSimulation();
        fenetreSimulation.runSimulation();
    }
}
