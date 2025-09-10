import javax.swing.*;
import java.awt.*;

public class Main {
    private static boolean running = false;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Progress Bar Start & Stop with Color Selector");
//      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 230);
        frame.setLayout(new FlowLayout());

        JProgressBar progressBar = new JProgressBar(0, 100);
        progressBar.setPreferredSize(new Dimension(400, 30));
      //  progressBar.setStringPainted(true);
        progressBar.setForeground(Color.PINK);
        progressBar.setBackground(Color.LIGHT_GRAY);

        JButton startButton = new JButton("Start");
        JButton stopButton = new JButton("Stop");
        stopButton.setEnabled(false);

        // Radio buttons for color selection
        JRadioButton pinkButton = new JRadioButton("Pink", true);

        JRadioButton blueButton = new JRadioButton("Blue");

        ButtonGroup colorGroup = new ButtonGroup();
        colorGroup.add(pinkButton);
        colorGroup.add(blueButton);

        // Panel to hold radio buttons
        JPanel colorPanel = new JPanel();
        colorPanel.setBorder(BorderFactory.createTitledBorder("Choose Progress Bar Color"));
        colorPanel.add(pinkButton);

        colorPanel.add(blueButton);

        frame.add(progressBar);
        frame.add(startButton);
        frame.add(stopButton);
        frame.add(colorPanel);
        frame.setVisible(true);

        Timer timer = new Timer(1000, null);

        timer.addActionListener(e -> {
            int value = progressBar.getValue();
            if (value < 100 && running) {
                progressBar.setValue(value + 1);
            } else {
                running = false;
                timer.stop();
                startButton.setEnabled(true);
                stopButton.setEnabled(false);
            }
        });

        startButton.addActionListener(e -> {
            if (running) return;


            if (progressBar.getValue() >= 100) {
                progressBar.setValue(0);
            }

            running = true;
            startButton.setEnabled(false);
            stopButton.setEnabled(true);
            timer.start();
        });

        stopButton.addActionListener(e -> {
            running = false;
            timer.stop();
            stopButton.setEnabled(false);
            startButton.setEnabled(true);
        });

        // Action listeners to change color dynamically
        pinkButton.addActionListener(e -> progressBar.setForeground(Color.PINK));

        blueButton.addActionListener(e -> progressBar.setForeground(Color.BLUE));
    }
}

