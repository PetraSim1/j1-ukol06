package cz.czechitas.ukol6;


import com.formdev.flatlaf.FlatLightLaf;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Aplikace extends JFrame {

    private JLabel HusyLabel;
    private JLabel KraliciLabel;
    private JLabel PocetHlavLabel;
    private JLabel PocetNohouLabel;
    private JTextField HusyField;
    private JTextField KraliciField;
    private JTextField PocetHlavField;
    private JTextField PocetNohouField;
    private JButton VypocitatButton;

    public static void main(String[] args) {
        FlatLightLaf.setup();
        new Aplikace().start();
    }

    public Aplikace() throws HeadlessException {
        super("Farmářka 1.0");
        this.init();
    }

    public void start() {
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void init() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setIconImage(new ImageIcon(Aplikace.class.getResource("czechitas-icon.png")).getImage());
        setLayout(new MigLayout("wrap 2", "[right]rel[50:120:150,grow,fill]"));
        setMinimumSize(new Dimension(250, 200));

        HusyField = new JTextField();
        HusyLabel = new JLabel("Husy");
        HusyLabel.setDisplayedMnemonic('H');
        HusyLabel.setLabelFor(HusyField);
        HusyField.setHorizontalAlignment(JTextField.TRAILING);
        add(HusyLabel);
        add(HusyField);

        KraliciField = new JTextField();
        KraliciLabel = new JLabel("Králíci");
        KraliciLabel.setDisplayedMnemonic('K');
        KraliciLabel.setLabelFor(KraliciField);
        KraliciField.setHorizontalAlignment(JTextField.TRAILING);
        add(KraliciLabel);
        add(KraliciField);

        add(createButtonBar(),"center, span");

        PocetHlavField = new JTextField();
        PocetHlavLabel = new JLabel("Počet hlav");
        PocetHlavField.setEditable(false);
        PocetHlavLabel.setLabelFor(PocetHlavField);
        PocetHlavField.setHorizontalAlignment(JTextField.TRAILING);
        add(PocetHlavLabel);
        add(PocetHlavField);

        PocetNohouField = new JTextField();
        PocetNohouLabel = new JLabel("Počet nohou");
        PocetNohouField.setEditable(false);
        PocetNohouLabel.setLabelFor(PocetNohouField);
        PocetNohouField.setHorizontalAlignment(JTextField.TRAILING);
        add(PocetNohouLabel);
        add(PocetNohouField);
        pack();

        getRootPane().setDefaultButton(VypocitatButton);

        VypocitatButton.addActionListener(this::handleVypocitat);

    }
    private JPanel createButtonBar() {
        VypocitatButton = new JButton("Vypočítat");
        VypocitatButton.setMnemonic('V');

        JPanel buttonBar = new JPanel(new MigLayout(null, "[right, grow]"));
        buttonBar.add(VypocitatButton);
        return buttonBar;
    }

    private void handleVypocitat(ActionEvent actionEvent)  {
        int Husy = Integer.parseInt(HusyField.getText());
        int Kralici = Integer.parseInt(KraliciField.getText());

        PocetHlavField.setText(Integer.toString(Husy + Kralici));
        PocetNohouField.setText(Integer.toString((Husy * 2) + (Kralici * 4)));
    }
    }

