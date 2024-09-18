package View.GUI;

import Controller.ControllerParameters;
import Model.DAO.DAOParameters;
import Model.DataAccessLayerParameters;
import Model.Entities.*;

import View.VehiculeFileManager;
import View.ViewParameters;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;

import com.formdev.flatlaf.FlatDarculaLaf;
import com.formdev.flatlaf.FlatLightLaf;

public class JFrameParameters extends JFrame implements ViewParameters
{
    private final JTable drivers;
    private final JTable karts;
    private final JTable tires;
    private Pilote selectedDriver = null;
    private Body selectedBody = null;
    private Tire selectedTire = null;
    private final JButton confirmationButton;

    public JFrameParameters()
    {
        super("Laboratoire de conception de voitures");

        JPanel mainPanel;
        JButton saveData;
        JButton loadData;
        JButton exitButton;

        mainPanel = new JPanel(new GridLayout(4, 1));
        confirmationButton = new JButton("Confirmation");
        saveData = new JButton("Sauvegarder un véhicule");
        loadData = new JButton("Charger un véhicule");
        exitButton = new JButton("Quitter");


        exitButton.addActionListener(e -> System.exit(0));

        drivers = new JTable();
        karts = new JTable();
        tires = new JTable();

        JMenuBar menuBar = new JMenuBar();
        createMenu(menuBar);
        setJMenuBar(menuBar);

        JPanel row1 = new JPanel(new GridLayout(1, 1));
        drivers.setRowHeight(130);
        row1.add(new JScrollPane(drivers));

        JPanel row2 = new JPanel(new GridLayout(1, 1));
        karts.setRowHeight(130);
        row2.add(new JScrollPane(karts));

        JPanel row3 = new JPanel(new GridLayout(1, 1));
        tires.setRowHeight(130);
        row3.add(new JScrollPane(tires));

        JPanel row4 = new JPanel(new GridLayout(1, 4));

        saveData.addActionListener(e -> saveVehicule());
        loadData.addActionListener(e -> loadVehicule());

        row4.add(confirmationButton);
        row4.add(saveData);
        row4.add(loadData);
        row4.add(exitButton);

        mainPanel.add(row1);
        mainPanel.add(row2);
        mainPanel.add(row3);
        mainPanel.add(row4);

        setContentPane(mainPanel);

        setSize(750, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void createMenu(JMenuBar menuBar)
    {
        JMenuItem menuItemFlatDark;
        JMenuItem menuItemFlatLight;

        JMenu menuCustomize = new JMenu("Personnaliser interface");
        menuItemFlatDark = new JMenuItem("Rendre plus sombre");
        menuItemFlatDark.addActionListener(e -> setLookAndFeel(new FlatDarculaLaf()));
        menuCustomize.add(menuItemFlatDark);

        menuItemFlatLight = new JMenuItem("Rendre plus claire");
        menuItemFlatLight.addActionListener(e -> setLookAndFeel(new FlatLightLaf()));
        menuCustomize.add(menuItemFlatLight);

        menuCustomize.addSeparator();

        JMenuItem menuCustomizeItemQuit = new JMenuItem("Quitter");
        menuCustomizeItemQuit.addActionListener(e -> System.exit(0));
        menuCustomize.add(menuCustomizeItemQuit);

        menuBar.add(menuCustomize);
        setJMenuBar(menuBar);
    }

    private void saveVehicule()
    {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Choisissez un emplacement pour sauvegarder le véhicule");
        int userSelection = fileChooser.showSaveDialog(this);

        if (userSelection == JFileChooser.APPROVE_OPTION)
        {
            File fileToSave = fileChooser.getSelectedFile();
            Vehicule v = new Vehicule(selectedBody,selectedDriver,selectedTire);
            VehiculeFileManager.saveVehiculeToFile(v, fileToSave.getAbsolutePath());
            showMessage("Véhicule sauvegardé avec succès !");
        }
    }

    private void loadVehicule()
    {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Choisissez un fichier pour charger le véhicule");
        int userSelection = fileChooser.showOpenDialog(this);

        if (userSelection == JFileChooser.APPROVE_OPTION)
        {
            File fileToLoad = fileChooser.getSelectedFile();
            Vehicule loadedVehicule = VehiculeFileManager.loadVehiculeFromFile(fileToLoad.getAbsolutePath());

            if (loadedVehicule != null)
            {
                JDialogVehicules dialogWindow = new JDialogVehicules(loadedVehicule,loadedVehicule.getBody(),loadedVehicule.getPilot(),loadedVehicule.getTire());
                setVisible(false);
                dialogWindow.setVisible(true);
                showMessage("Véhicule chargé avec succès !");
            }
            else
            {
                showErrorMessage("Erreur lors du chargement du véhicule.");
            }
        }
    }

    private void setLookAndFeel(LookAndFeel laf)
    {
        try
        {
            UIManager.setLookAndFeel(laf);

            /*
                UIManager.setLookAndFeel est une méthode statique de la classe UIManager qui
                change le Look and Feel global de l'application. laf doit être une instance de
                LookAndFeel ou une de ses sous-classes, comme FlatDarculaLaf ou FlatLightLaf.
            */

            SwingUtilities.updateComponentTreeUI(this);

            /*
                SwingUtilities.updateComponentTreeUI est une méthode statique qui actualise
                le composant spécifié (et tous ses sous-composants) pour utiliser le nouveau
                Look and Feel. this fait référence à l'instance actuelle de JFrameParameters,
                donc toute l'interface utilisateur de cette fenêtre sera mise à jour
            */
        }
        catch (UnsupportedLookAndFeelException e)
        {
            showErrorMessage("Impossible d'appliquer le Look and Feel : " + e.getMessage());
        }
    }

    @Override
    public void addANewParameter(Parameters param)
    {
        DataAccessLayerParameters dao = new DAOParameters();

        int id = dao.addParameter(param);

        if (id != -1)
        {
            ArrayList<Parameters> parameters = dao.getParametersList();
            displayParameters(parameters);
        }
    }

    @Override
    public void displayParameters(ArrayList<Parameters> param)
    {
        ArrayList<Pilote> pilotesList = new ArrayList<>();
        ArrayList<Body> kartsList = new ArrayList<>();
        ArrayList<Tire> tireList = new ArrayList<>();

        for (Parameters p : param)
        {
            if (p instanceof Pilote)
            {
                pilotesList.add((Pilote) p);
            }
            else if (p instanceof Body)
            {
                kartsList.add((Body) p);
            }
            else if (p instanceof Tire)
            {
                tireList.add((Tire) p);
            }
        }

        drivers.setModel(new ParametersTableModel<>(pilotesList));
        drivers.setColumnModel(new ParametersTableColumnModel());
        drivers.getColumnModel().getColumn(1).setCellRenderer(new CenteredRenderer());

        karts.setModel(new ParametersTableModel<>(kartsList));
        karts.setColumnModel(new ParametersTableColumnModel());
        karts.getColumnModel().getColumn(1).setCellRenderer(new CenteredRenderer());

        tires.setModel(new ParametersTableModel<>(tireList));
        tires.setColumnModel(new ParametersTableColumnModel());
        tires.getColumnModel().getColumn(1).setCellRenderer(new CenteredRenderer());
    }

    @Override
    public void setControllerParameters(ControllerParameters c)
    {
        drivers.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e)
            {
                if (e.getClickCount() == 1)
                {
                    JTable target = (JTable) e.getSource();
                    int rowDriver = target.getSelectedRow();
                    selectedDriver = (Pilote) ((ParametersTableModel) target.getModel()).getParameterAt(rowDriver);
                }
            }
        });

        karts.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e)
            {
                if (e.getClickCount() == 1)
                {
                    JTable target = (JTable) e.getSource();
                    int rowBody = target.getSelectedRow();
                    selectedBody = (Body) ((ParametersTableModel) target.getModel()).getParameterAt(rowBody);
                }
            }
        });

        tires.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e)
            {
                if (e.getClickCount() == 1)
                {
                    JTable target = (JTable) e.getSource();
                    int rowTire = target.getSelectedRow();
                    selectedTire = (Tire) ((ParametersTableModel) target.getModel()).getParameterAt(rowTire);
                }
            }
        });

        confirmationButton.addActionListener(e ->
        {
            if (selectedDriver != null && selectedBody != null && selectedTire != null)
            {
                Vehicule v = new Vehicule(selectedBody, selectedDriver, selectedTire);
                JDialogVehicules dialogWindow = new JDialogVehicules(v,selectedBody,selectedDriver,selectedTire);
                setVisible(false);
                dialogWindow.setVisible(true);
            }
            else
            {
                showErrorMessage("Vous devez sélectionner un pilote, une carrosserie et des pneus.");
            }
        });
    }

    @Override
    public void runParameters()
    {
        setVisible(true);
    }

    @Override
    public void showMessage(String message)
    {
        JOptionPane.showMessageDialog(this,
                message,
                "Pour votre information...",
                JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    public void showErrorMessage(String message)
    {
        JOptionPane.showMessageDialog(this,
                message,
                "Pour votre information...",
                JOptionPane.ERROR_MESSAGE);
    }

    /* MAIN : */

    public static void main(String[] args)
    {
        JFrameParameters window = new JFrameParameters();
        window.runParameters();

        DataAccessLayerParameters dao = new DAOParameters();
        ArrayList<Parameters> parameters = dao.getParametersList();

        for(Parameters p:parameters)
        {
            window.addANewParameter(p);
        }
    }
}