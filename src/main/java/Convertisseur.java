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


    String []unt={"Euro (EUR)","Dollar US (USD)","Livre Sterling (GBP)","Yen Japonais (JPY)"};
    JFrame f=new JFrame("ConvertisseurMoney");
    JButton bcal=new JButton("Calculer");
    JButton bexit=new JButton("Quitter");

    JPanel p=new JPanel();
    JPanel p1=new JPanel();
    JPanel p2=new JPanel();
    JPanel p3=new JPanel();

    JLabel lblmesu=new JLabel("Bienvenue dans mon Convertisseur de Devises");

    JLabel lblunite=new JLabel("Veuillez selectionner vos devises");
    JLabel lblunite1=new JLabel("Unite:");
    JLabel lblunite2=new JLabel("Unite:");


    JComboBox unite1=new JComboBox();
    JComboBox unite2=new JComboBox();

    JTextField textuni1=new JTextField();
    JTextField textuni2=new JTextField();
    JMenuBar jmenubar=new JMenuBar();
    JMenu jmenu=new JMenu("?");
    JMenuItem jmenuitem=new JMenuItem("Apropos");


    public Convertisseur(){
        this.setTitle("Convertisseur");
        this.setSize(new Dimension(600,400));
        this.setJMenuBar(jmenubar);
        jmenubar.add(jmenu);
        jmenu.add(jmenuitem);

        this.add(p);
        p.setLayout(new GridLayout(7,1));
        p.add(lblmesu);
        p.add(lblunite);
        p.add(p1);
        p1.setLayout(new GridLayout(1,2));
        p1.add(lblunite1);
        p1.add(unite1);
        p.add(textuni1);
        p.add(p2);
        p2.setLayout(new GridLayout(1,2));
        p2.add(lblunite2);
        p2.add(unite2);
        p.add(textuni2);
        p3.setLayout(new GridLayout(1,2));
        p3.add(bcal);
        p3.add(bexit);
        p.add(p3);

        bexit.addActionListener(this);
        bcal.addActionListener(this);
        unite1.addActionListener(this);
        unite2.addActionListener(this);
        jmenuitem.addActionListener(this);
    }

    WindowAdapter win=new WindowAdapter() {
        public void windowClosing(WindowEvent e){ System.exit(0);}
    };
    {this.addWindowListener(win);}

    WindowAdapter win1=new WindowAdapter() {
        public void windowOpened(WindowEvent e){
            for(int i=0;i<4;i++)
                unite1.addItem(unt[i]);
            for(int i=0;i<4;i++)
                unite2.addItem(unt[i]);
        }
    };
    {this.addWindowListener(win1);}

    public void actionPerformed(ActionEvent e){
        if(e.getSource()==jmenuitem)
            JOptionPane.showMessageDialog(this,"by LOUAASAurelien/MIF2/ESILV","Details",JOptionPane.INFORMATION_MESSAGE);
        if(e.getSource()==bexit)
            System.exit(0);
        if(e.getSource()==bcal)
        {
            double s=Double.valueOf(textuni1.getText()).doubleValue();
            if(unite1.getSelectedIndex()==0)
            {
                if(unite2.getSelectedIndex()==1)
                {
                    s=s*1.0609;
                    textuni2.setText(""+s);
                }
                else if(unite2.getSelectedIndex()==2)
                {
                    s=s*0.7229;
                    textuni2.setText(""+s);
                }
                else if(unite2.getSelectedIndex()==3)
                {
                    s=s*134.2042;
                    textuni2.setText(""+s);
                }
            }
            if(unite1.getSelectedIndex()==1)
            {
                if(unite2.getSelectedIndex()==0)
                {
                    s=s/1.0609;
                    textuni2.setText(""+s);
                }
                else if(unite2.getSelectedIndex()==2)
                {
                    s=s*0.6627;
                    textuni2.setText(""+s);
                }
                else if(unite2.getSelectedIndex()==3)
                {
                    s=s*123.0215;
                    textuni2.setText(""+s);
                }
            }
            if(unite1.getSelectedIndex()==2)
            {
                if(unite2.getSelectedIndex()==0)
                {
                    s=s/0.7229;
                    textuni2.setText(""+s);
                }
                else if(unite2.getSelectedIndex()==1)
                {
                    s=s/0.6627;
                    textuni2.setText(""+s);
                }
                else if(unite2.getSelectedIndex()==3)
                {
                    s=s*185.6371;
                    textuni2.setText(""+s);
                }
            }
            if(unite1.getSelectedIndex()==3)
            {
                if(unite2.getSelectedIndex()==0)
                {
                    s=s/134.2042;
                    textuni2.setText(""+s);
                }
                else if(unite2.getSelectedIndex()==1)
                {
                    s=s/123.0215;
                    textuni2.setText(""+s);
                }
                else if(unite2.getSelectedIndex()==2)
                {
                    s=s/185.6371;
                    textuni2.setText(""+s);
                }
            }
        }
    }
}


