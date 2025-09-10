import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Mywork1 extends JPanel implements ActionListener {

    private int height = 0;
    private JProgressBar progressBar;

    public Mywork1() {
        setPreferredSize(new Dimension(400, 400));

        // progress bar
        progressBar = new JProgressBar(0, 100);
        progressBar.setStringPainted(true);

        JFrame frame = new JFrame("Rectangle Fill Progress");
        frame.setLayout(new BorderLayout());
        frame.add(this, BorderLayout.CENTER);
        frame.add(progressBar, BorderLayout.SOUTH);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);


        Timer ti=new Timer(100, this);
        ti.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);


        g.setColor(Color.LIGHT_GRAY);
        g.drawRect(100, 50, 200, 300);


        g.setColor(Color.BLUE);
        g.fillRect(100,350-height,200,height);
    }

    public static void main(String[] args) {
       // SwingUtilities.invokeLater(Mywork1::new);
        new Mywork1();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

            if (height < 300) {
                height += 3;
                progressBar.setValue(height / 3);
                repaint();
            }
    }
}
