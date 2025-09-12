import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Mywork implements ActionListener {

    Button b1,b2,b3,b4,b5;
    JProgressBar jp;
    Mywork()
    {
        JFrame jf=new JFrame("PROGRESS");
        jp=new JProgressBar(0,100);
        jp.setPreferredSize(new Dimension(600, 30));
        jp.setStringPainted(true);

        jp.setForeground(Color.CYAN);
        jp.setBackground(Color.CYAN);

        JPanel jpa=new JPanel();
        jpa.setBorder(BorderFactory.createTitledBorder("PROGRESS BUTTONS"));
        b1=new Button(" BLUE ");
        b2=new Button("  RED ");
        b3=new Button("YELLOW");
        b4=new Button(" PINK ");
        b5=new Button("RESTART");
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        jpa.add(b1);
        jpa.add(b2);
        jpa.add(b3);
        jpa.add(b4);
        jpa.add(b5);




        jf.add(jp);
        jf.add(jpa);
        jf.setLayout(new FlowLayout());
        jf.setVisible(true);
        jf.setSize(1000,1000);
    }

    public static void main(String[] args) {
        new Mywork();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(b1==e.getSource()){
            b1.setEnabled(false);
            jp.setForeground(Color.BLUE);
            jp.setValue(jp.getValue()+25);
        } else if (b2==e.getSource()) {
            b2.setEnabled(false);
            jp.setForeground(Color.RED);
            jp.setValue(jp.getValue()+25);
        }
        else if (b3==e.getSource()) {
            b3.setEnabled(false);
            jp.setForeground(Color.YELLOW);
            jp.setValue(jp.getValue()+25);
        }
        else if (b4==e.getSource()) {
            b4.setEnabled(false);
            jp.setForeground(Color.PINK);
            jp.setValue(jp.getValue()+25);
        } else if (b5==e.getSource()) {
            jp.setValue(0);
            b1.setEnabled(true);
            b2.setEnabled(true);
            b3.setEnabled(true);
            b4.setEnabled(true);
        }
    }
}
