import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class Convertisseur extends JFrame implements ActionListener {

    public static void main(String[] args){
        new Convertisseur().setVisible(true);
    }

    String []dv={"Devise"};
    String []unt={"Euro (EUR)","Dollar US (USD)","Livre Sterling (GBP)"};
    JFrame f=new JFrame("Convertisseur");
    JButton bcal=new JButton("Calculer");
    JButton bexit=new JButton("Quitter");

    JPanel p=new JPanel();
    JPanel p1=new JPanel();
    JPanel p2=new JPanel();
    JPanel p3=new JPanel();

    JLabel lblmesu=new JLabel("Mesure:");
    JLabel lblunite1=new JLabel("Unite:");
    JLabel lblunite2=new JLabel("Unite:");

    JComboBox mesu1=new JComboBox(dv);
    JComboBox unite1=new JComboBox();
    JComboBox unite2=new JComboBox();

    JTextField textun1=new JTextField();
    JTextField textun2=new JTextField();
    JMenuBar jmenubar1=new JMenuBar();
    JMenu jmenu1=new JMenu("?");
    JMenuItem jmenuitem1=new JMenuItem("Apropos");


    public Convertisseur(){
        this.setTitle("Convertisseur");
        this.setSize(new Dimension(550,350));
        this.setJMenuBar(jmenubar1);
        jmenubar1.add(jmenu1);
        jmenu1.add(jmenuitem1);

        this.add(p);
        p.setLayout(new GridLayout(7,1));
        p.add(lblmesu);
        p.add(mesu1);
        p.add(p1);
        p1.setLayout(new GridLayout(1,2));
        p1.add(lblunite1);
        p1.add(unite1);
        p.add(textun1);
        p.add(p2);
        p2.setLayout(new GridLayout(1,2));
        p2.add(lblunite2);
        p2.add(unite2);
        p.add(textun2);
        p3.setLayout(new GridLayout(1,2));
        p3.add(bcal);
        p3.add(bexit);
        p.add(p3);

        bexit.addActionListener(this);
        bcal.addActionListener(this);
        mesu1.addActionListener(this);
        unite1.addActionListener(this);
        unite2.addActionListener(this);
        jmenuitem1.addActionListener(this);
    }

    WindowAdapter win=new WindowAdapter() {
        public void windowClosing(WindowEvent e){ System.exit(0);}
    };
    {this.addWindowListener(win);}

    WindowAdapter win1=new WindowAdapter() {
        public void windowOpened(WindowEvent e){
            for(int i=0;i<3;i++)
                unite1.addItem(unt[i]);
            for(int i=2;i>-1;i--)
                unite2.addItem(unt[i]);
        }
    };
    {this.addWindowListener(win1);}

    public void actionPerformed(ActionEvent e){
        if(e.getSource()==jmenuitem1)
            JOptionPane.showMessageDialog(this,"by LOUAAS Aurelien","Menus",JOptionPane.INFORMATION_MESSAGE);
        if(e.getSource()==bexit)
            System.exit(0);
        if(e.getSource()==bcal)
        {
            double s=Double.valueOf(textun1.getText()).doubleValue();
            if(mesu1.getSelectedIndex()==0)
            {
                if(unite1.getSelectedIndex()==0)
                {
                    s=s*1.0609;
                    textun2.setText(""+s);
                }
                else if(unite1.getSelectedIndex()==1)
                {
                    s=s/1.0609;
                    textun2.setText(""+s);
                }
            }
        }
        if(e.getSource()==mesu1)
        {
            if(mesu1.getSelectedIndex()==0)
            {
                unite1.removeAllItems();
                unite2.removeAllItems();
                for(int i=0;i<3;i++)
                    unite1.addItem(unt[i]);
                for(int i=2;i>-1;i--)
                    unite2.addItem(unt[i]);
            }
        }
    }
}


