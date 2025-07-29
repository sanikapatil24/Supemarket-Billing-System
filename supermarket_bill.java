import java.util.Date;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import javax.swing.*;


class supermarket_bill extends JFrame 
{
    JLabel proj_name,market_name,add_mart,cust_name_label,cust_info,cust_mob_label,city_label,item_name_label,prod_details,prod_name_label,quantity_label,background;
	JTextField cust_name_tfield,cust_mob_tfield,city_tfield,quantity_tfield;
	Choice products;
	JButton add, submit,reset;
	JTextArea bill;
	int total_bill=0;
	String bill_info="", personal_info,date,cust_name,cust_mob,p_name,city,quantity;
	int price = 0;
	
    supermarket_bill()
	{
		
		
		Date sysdate = new Date();
		int year = sysdate.getYear() + 1900; 
		int month = sysdate.getMonth() + 1;   
		int day = sysdate.getDate();          
		date = day + "/" + month + "/" + year;
		
		proj_name=new JLabel("Super Market Billing System");
		proj_name.setBounds(420,1,450,40);
		Font f0=new Font("Elephant",Font.BOLD,27);
		proj_name.setFont(f0);
		
        market_name=new JLabel("****Avenue SuperMarts****");
		market_name.setBounds(450,45,450,50);
		market_name.setForeground(Color.white);
		Font f1=new Font("Algerian",Font.BOLD,25);
		market_name.setFont(f1);
		
		add_mart=new JLabel("Address: 8805 - Gat No 2387 2388, M.no. 1880/1/2/4 A/p, Malgaon Miraj Rural Sangli, Maharashtra, 416410 India");
		add_mart.setBounds(300,100,700,40);
		add_mart.setForeground(Color.white);
		
		cust_info=new JLabel("Customer Information");
		cust_info.setBounds(500,150,250,40);
		cust_info.setForeground(Color.white);
		Font f2=new Font("Arial",Font.BOLD,20);
		cust_info.setFont(f2);
		
		cust_name_label=new JLabel("Customer Name:");
		cust_name_label.setBounds(450,200,110,40);
		cust_name_label.setForeground(Color.white);
		cust_name_tfield=new JTextField();
		cust_name_tfield.setBounds(570,200,200,40);
		
		cust_mob_label=new JLabel("Customer Mob:");
		cust_mob_label.setBounds(450,250,110,40);
		cust_mob_label.setForeground(Color.white);
		cust_mob_tfield=new JTextField();
		cust_mob_tfield.setBounds(570,250,200,40);
		
		city_label=new JLabel("City:");
		city_label.setBounds(450,300,110,40);
		city_label.setForeground(Color.white);
		city_tfield=new JTextField();
		city_tfield.setBounds(570,300,200,40);
		
		prod_details=new JLabel("Product Details");
		prod_details.setBounds(530,360,250,40);
		prod_details.setForeground(Color.white);
		prod_details.setFont(f2);
		
		prod_name_label=new JLabel("Product Name:");
		prod_name_label.setBounds(450,410,110,40);
		prod_name_label.setForeground(Color.white);
		products=new Choice();
		products.setBounds(570,420,200,40);
		products.add("Pencil        7 Rs");
		products.add("Bottle        150 Rs");
		products.add("Chocolate        50 Rs");
		products.add("Bags        70 Rs");
		products.add("Hankerchief        20 Rs");
		products.add("Tiffine        700 Rs");
		products.add("Soap        35 Rs");
		products.add("Headphone        350 Rs");
		products.add("Notebook        80 Rs");
		
		quantity_label=new JLabel("Product Quanity:");
		quantity_label.setBounds(450,460,110,40);
		quantity_label.setForeground(Color.white);
		quantity_tfield=new JTextField();
		quantity_tfield.setBounds(570,460,200,40);
		
		add=new JButton("Add Item");
		add.setBounds(450,520,120,40);
		submit=new JButton("Generate Bill");
		submit.setBounds(650,520,120,40);
		reset=new JButton("Reset");
		reset.setBounds(850,520,120,40);
		
		bill=new JTextArea(12,34);
		JScrollPane js=new JScrollPane(bill);
		js.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		js.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		js.setBounds(850,150,300,350);
		
		ImageIcon img=new ImageIcon("bg2.jpg");
		background=new JLabel("",img,JLabel.CENTER);
		background.setBounds(0,0,1300,650);
		
		setLayout(null);
		setVisible(true);
		setSize(1400,1000);
		add(background);
		background.add(proj_name);
		background.add(market_name);
		background.add(add_mart);
		background.add(cust_info);
		background.add(cust_name_label);
		background.add(cust_name_tfield);
		background.add(cust_mob_label);
		background.add(cust_mob_tfield);
		background.add(city_label);
		background.add(city_tfield);
		background.add(prod_details);
		background.add(prod_name_label);
		background.add(products);
		background.add(quantity_label);
		background.add(quantity_tfield);
		background.add(add);
		background.add(submit);
		background.add(reset);
		background.add(js);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		add.addMouseListener
		(
		new MouseAdapter()
		{
			public void mouseClicked(MouseEvent e)
			{
				cust_name = cust_name_tfield.getText();
				cust_mob = cust_mob_tfield.getText();
				city = city_tfield.getText();
				p_name = products.getSelectedItem();
				quantity = quantity_tfield.getText();
		
				personal_info="\tCASH RECEIPT \n__________________________________________ \nCustomer: "+cust_name+"\nAddress: "+city+"\nDate: "+date+"\n__________________________________________\n";
				
				if(cust_name.equals("")||cust_mob.equals("")||city.equals("")||p_name.equals("")||quantity.equals(""))
				{
					JOptionPane.showMessageDialog(null,"All details are mandatory!!!");
				}
				else
				{
					if(cust_mob.length()!=10)
					{
						JOptionPane.showMessageDialog(null,"Please enter valid mobile number!!!");
					}
					else
					{
					int q = Integer.parseInt(quantity);
					
					if(p_name.equals("Pencil        7 Rs"))
					{
						price=7;
						bill_info=bill_info+"\nPencil  \t"+quantity+" * "+price;
					}
					if(p_name.equals("Bottle        150 Rs"))
					{
						price=150;
						bill_info=bill_info+"\nBottle  \t"+quantity+" * "+price;
					}
					if(p_name.equals("Chocolate        50 Rs"))
					{
						price=50;
						bill_info=bill_info+"\nChocolate  \t"+quantity+" * "+price;
					}
					if(p_name.equals("Bags        70 Rs"))
					{
						price=70;
						bill_info=bill_info+"\nBags  \t"+quantity+" * "+price;
					}
					if(p_name.equals("Hankerchief        20 Rs"))
					{
						price=20;
						bill_info=bill_info+"\nHankerchief  \t"+quantity+" * "+price;
					}
					if(p_name.equals("Tiffine        700 Rs"))
					{
						price=700;
						bill_info=bill_info+"\nTiffine  \t"+quantity+" * "+price;
					}
					if(p_name.equals("Soap        35 Rs"))
					{
						price=35;
						bill_info=bill_info+"\nSoap  \t"+quantity+" * "+price;
					}
					if(p_name.equals("Headphone        350 Rs"))
					{
						price=350;
						bill_info=bill_info+"\nHeadphone  \t"+quantity+" * "+price;
					}
					if(p_name.equals("Notebook        80 Rs"))
					{
						price=80;
						bill_info=bill_info+"\nNotebook  \t"+quantity+" * "+price;
					}
			
					price=price*q;
					total_bill+=price;
					bill_info=bill_info+" = "+price;
					
					quantity_tfield.setText("");
					products.select(0);
					}
				}
			}
		}
		);
		
		submit.addMouseListener
		(
		new MouseAdapter()
		{
			public void mouseClicked(MouseEvent e)
			{
				if(total_bill>=1000)
				{
					int discount=(total_bill*7)/100;
					total_bill=total_bill-discount;
					bill.setText(personal_info+bill_info+"\n__________________________________________\nDiscount\t7%\t"+discount+"\nTotal=\t\t"+total_bill+"\n__________________________________________\n");
				}
				else
				{
				bill.setText(personal_info+bill_info+"\n__________________________________________\nTotal=\t"+total_bill+"\n__________________________________________\n");
				}
				try 
				{
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/supermarket", "root", "");
					PreparedStatement stmt = con.prepareStatement("INSERT INTO supermarket (Cust_Name, Mob_No, City, Total_Bill) VALUES (?, ?, ?, ?)");

					stmt.setString(1, cust_name);
					stmt.setString(2,cust_mob);
					stmt.setString(3, city);
					stmt.setInt(4, total_bill);

					stmt.executeUpdate();
					
					stmt.close();
					con.close();
				} 
				catch (Exception ex) 
				{
					System.out.println(ex);
				}

			}
		}
		);
		
		reset.addMouseListener
		(
			new MouseAdapter()
			{
				public void mouseClicked(MouseEvent e)
				{
					total_bill=0;
					cust_name_tfield.setText("");
					cust_mob_tfield.setText("");
					city_tfield.setText("");
					quantity_tfield.setText("");
					products.select(0);
					bill.setText("");
					price=0;
					bill_info="";
				}
			}
		);
		
    }

    public static void main(String args[]) 
	{
        new supermarket_bill();
    }
}
