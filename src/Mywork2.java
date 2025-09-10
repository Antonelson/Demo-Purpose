import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Mywork2 extends JFrame implements ActionListener {
    JProgressBar jp;
    JButton b1,b2,b3;
    int height =0;
    Mywork2()
    {
        jp=new JProgressBar(0,100);
        jp.setBackground(Color.YELLOW);
        jp.setForeground(Color.PINK);
        jp.setStringPainted(true);


        Timer ti=new Timer(50,this);


        b1=new JButton("START");
        b1.addActionListener(e->{ti.start();});
        b2=new JButton("STOP");
        b2.addActionListener(e->{
            ti.stop();
        });
        b3=new JButton("RESTART");
        b3.addActionListener(e->{
            jp.setValue(0);
            height=0;
            repaint();
        });



        JPanel jpa=new JPanel();
        jpa.setBorder(BorderFactory.createTitledBorder("PROGRESS BAR"));
        jpa.add(jp);
        jpa.add(b1);
        jpa.add(b2);
        jpa.add(b3);



        setLayout(new FlowLayout());

        add(jpa);
        setTitle("PROGRESS BAR");
        setVisible(true);
        setSize(1000,1000);
    }
    public static void main(String[] args) {
        new Mywork2();
    }

    @Override
    public void paint(Graphics g) {
        super.paintComponents(g);
       g.setColor(Color.YELLOW);
        g.fillRect(50,50,200,300);
        g.setColor(Color.PINK);
        g.fillRect(50,350-height,200,height);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(height<300)
        {
            height+=3;
            jp.setValue(height/3);
            repaint();
        }
    }
}
