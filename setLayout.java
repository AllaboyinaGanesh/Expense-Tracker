package ui;

import javax.swing.*;


import java.awt.*;

public class setLayout extends JFrame {
    public setLayout() {
        setTitle("Set Layout");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(true);

        JPanel panel = new JPanel(new FlowLayout());
        JButton gridButton = new JButton("GridLayout");
        JButton borderButton = new JButton("BorderLayout");
        JButton flowButton = new JButton("FlowLayout");
        panel.add(gridButton);
        panel.add(borderButton);
        panel.add(flowButton);
        add(panel);

        gridButton.addActionListener(e -> setPanelLayout(new GridLayout(2, 2)));
        borderButton.addActionListener(e -> setPanelLayout(new BorderLayout()));
        flowButton.addActionListener(e -> setPanelLayout(new FlowLayout()));
    }

    private void setPanelLayout(LayoutManager layout) {
        getContentPane().removeAll();
        JPanel panel = new JPanel(layout);
        panel.add(new JLabel("Layout changed!"));
        add(panel);
        revalidate();
        repaint();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            setLayout frame = new setLayout();
            frame.setVisible(true);
        });
    }
}
