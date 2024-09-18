package View.GUI;

import Model.DAO.DAOVehicule;
import Model.DataAccessLayerVehicule;

import Model.Entities.Body;
import Model.Entities.Pilote;
import Model.Entities.Tire;
import Model.Entities.Vehicule;

import View.VehiculeFileManager;
import View.ViewVehicule;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.text.DecimalFormat;

public class JDialogVehicules extends JFrame implements ViewVehicule
{
    private JPanel contentPane;
    private final JTable vehiculeTable;
    private final JTextField textFieldA;
    private final JTextField textFieldH;
    private final JTextField textFieldS;
    private final JTextField textFieldT;
    private final JTextField textFieldW;
    private JButton buttonOK;
    private JButton buttonCancel;
    private final Body b;
    private final Pilote p;
    private final Tire t;
    private Vehicule v;

    public JDialogVehicules(Vehicule v, Body b, Pilote p, Tire t)
    {
        super("Laboratoire de conception de voitures");

        contentPane = new JPanel(new GridLayout(3, 1));
        buttonOK = new JButton("Ok");
        buttonCancel = new JButton("Quitter");

        buttonCancel.addActionListener(e -> System.exit(0));

        // Intialisation des variables pour accès dans toute le JDialog :
        this.b = b;
        this.p = p;
        this.t = t;
        this.v = v;

        vehiculeTable = new JTable();
        addANewVehicule(v);
        displayVehicule(v);

        JPanel row1 = new JPanel(new GridLayout(1, 3));
        vehiculeTable.setRowHeight(130);
        row1.add(new JScrollPane(vehiculeTable));

        JPanel row2 = new JPanel(new GridLayout(5, 1));

        DecimalFormat df = new DecimalFormat("#.##");

        textFieldA = new JTextField("Acceleration :" + df.format(v.getAcceleration()));
        textFieldH = new JTextField("Handling :" + df.format(v.getHandling()));
        textFieldS = new JTextField("Speed :" + df.format(v.getSpeed()));
        textFieldT = new JTextField("Traction :" + df.format(v.getTraction()));
        textFieldW = new JTextField("Weight :" + df.format(v.getWeight()));

        textFieldA.setEditable(false);
        textFieldH.setEditable(false);
        textFieldS.setEditable(false);
        textFieldT.setEditable(false);
        textFieldW.setEditable(false);

        row2.add(textFieldA);
        row2.add(textFieldH);
        row2.add(textFieldS);
        row2.add(textFieldT);
        row2.add(textFieldW);

        JPanel row3 = new JPanel(new GridLayout(1, 2));

        buttonOK.addActionListener(e ->
        {
            if (!this.v.equals(null))
            {
                Vehicule vehicule = new Vehicule(v.getBody(),v.getPilot(),v.getTire());
                JFrameSimulationSetUp simulationSetUp = new JFrameSimulationSetUp(vehicule);
                setVisible(false);
                simulationSetUp.setVisible(true);
            }
            else
            {
                showErrorMessage("Véhicule non reconnu !");
            }
        });

        row3.add(buttonOK);
        row3.add(buttonCancel);

        contentPane.add(row1);
        contentPane.add(row2);
        contentPane.add(row3);

        setContentPane(contentPane);

        setSize(750, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public Vehicule getVehicule()
    {
        return v;
    }

    @Override
    public Vehicule addANewVehicule(Vehicule vehicule)
    {
        DataAccessLayerVehicule dao = new DAOVehicule();
        dao.addVehicule(vehicule);
        return vehicule;
    }

    @Override
    public void displayVehicule(Vehicule v)
    {
        vehiculeTable.setModel(new VehiculeTableModel(v));
        vehiculeTable.setColumnModel(new VehiculeTableColumnModel());
    }

    @Override
    public void showMessage(String message)
    {
        JOptionPane.showMessageDialog(this, message, "Pour votre information...", JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    public void showErrorMessage(String message)
    {
        JOptionPane.showMessageDialog(this, message, "Pour votre information...", JOptionPane.ERROR_MESSAGE);
    }

    /*public void main(String[] args)
    {
        Body body = new Body(b.getAcceleration(),b.getHandling(),b.getImage().toString(),b.getName(),b.getSpeed(),b.getTraction(),b.getWeight());
        Pilote pilote = new Pilote(p.getAcceleration(),p.getHandling(),p.getImage().toString(),p.getName(),p.getSpeed(),p.getTraction(),p.getWeight());
        Tire tire = new Tire(t.getAcceleration(),t.getHandling(),t.getImage().toString(),t.getName(),t.getSpeed(),t.getTraction(),t.getWeight());
        Vehicule vehicule = new Vehicule(body, pilote, tire);

        JDialogVehicules fenetreVehicule = new JDialogVehicules(parent,vehicule, body, pilote, tire);
        fenetreVehicule.addANewVehicule(vehicule);
        fenetreVehicule.displayVehicule(vehicule);
        fenetreVehicule.runV();
    }*/
}
