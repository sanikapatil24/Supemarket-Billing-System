import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Login extends JFrame implements ActionListener 
{
    JLabel l2, l3, l4,background;
    JTextField t;
    JPasswordField p;
    JButton b;

    Login() 
	{
		ImageIcon img=new ImageIcon("bg1.png");
		background=new JLabel("",img,JLabel.CENTER);
		background.setBounds(0,0,500,500);
		
        Font f1 = new Font("Calibri", Font.BOLD, 25);
        Font f2 = new Font("Calibri", Font.BOLD, 40);

        l2 = new JLabel("Login");
        l2.setBounds(180, 30, 400, 50);
        l2.setFont(f2);
        l2.setForeground(Color.white);

        l3 = new JLabel("Username:");
        l3.setBounds(50, 120, 150, 50);
		l3.setFont(f1);
		l3.setForeground(Color.white);
        t = new JTextField();
        t.setBounds(220, 120, 150, 40);
		

        l4 = new JLabel("Password:");
        l4.setBounds(50, 180, 150, 50);
		l4.setFont(f1);
		l4.setForeground(Color.white);
        p = new JPasswordField();
        p.setBounds(220, 180, 150, 40);
        p.setEchoChar('*');

        b = new JButton("LOGIN");
        b.setBounds(220, 240, 100, 40);
        b.addActionListener(this);
		
		add(background);
        background.add(l2);
        background.add(l3);
        background.add(l4);
        background.add(t);
        background.add(p);
        background.add(b);

        setSize(500, 500);
        setLayout(null);
        setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    public void actionPerformed(ActionEvent e) 
	{
        String str = t.getText();
        String str1 = new String(p.getPassword());

        if (str.equals("") || str1.equals("")) 
		{
            JOptionPane.showMessageDialog(null,"All details are mandatory!!!");
        } 
		else 
		{
            if (str.equals("avenue") && str1.equals("avenue@123"))
				{
                JOptionPane.showMessageDialog(null,"Login successful!!!");
				new supermarket_bill();
				dispose();
            }
			else 
			{
				JOptionPane.showMessageDialog(null,"Please fill valid details!!!");
            }
        }
    }

    public static void main(String args[]) {
        new Login();
    }
}
