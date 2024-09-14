/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Coba;

/**
 *
 * @author athif
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main extends JPanel {
    private JTree tree;
    private JPanel mainPanel;
    private JPanel handlePanel;
    private boolean isExpanded = true;
    private int expandedWidth = 200;

    public Main() {
        setLayout(new BorderLayout());

        tree = new JTree();
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(new JLabel("Main Content"), BorderLayout.CENTER);

        handlePanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g;
                g2.setColor(Color.GRAY);
                int middle = getHeight() / 2;
                g2.drawLine(2, middle - 5, 2, middle + 5);
                g2.drawLine(5, middle - 5, 5, middle + 5);
            }
        };
        handlePanel.setPreferredSize(new Dimension(10, 0));
        handlePanel.setCursor(Cursor.getPredefinedCursor(Cursor.E_RESIZE_CURSOR));
        handlePanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                toggleTreeVisibility();
            }
        });

        JScrollPane scrollPane = new JScrollPane(tree);
        scrollPane.setPreferredSize(new Dimension(expandedWidth, 0));

        add(scrollPane, BorderLayout.WEST);
        add(handlePanel, BorderLayout.CENTER);
        add(mainPanel, BorderLayout.EAST);
    }

    private void toggleTreeVisibility() {
        isExpanded = !isExpanded;
        JScrollPane scrollPane = (JScrollPane) getComponent(0);
        if (isExpanded) {
            scrollPane.setPreferredSize(new Dimension(expandedWidth, 0));
        } else {
            scrollPane.setPreferredSize(new Dimension(0, 0));
        }
        revalidate();
        repaint();
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Collapsible Tree Panel Example");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(600, 400);
            frame.add(new Main());
            frame.setVisible(true);
        });
    }
}
