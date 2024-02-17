package travel.tourism.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Signup extends JFrame implements ActionListener{
    
    JButton create, back;
    JTextField tfusername, tfname, tfLname, tfpassword, tfanswer;
    Choice security;
    Signup() {
        setBounds(400, 200, 900, 400);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        JPanel p1 = new JPanel();
        p1.setBackground(new Color(131, 193, 233)); 
        p1.setBounds(0, 0, 500, 400);
        p1.setLayout(null);
        add(p1);
        
        JLabel lblusername = new JLabel("Username");
        lblusername.setFont(new Font("Arial", Font.PLAIN, 16)); 
        lblusername.setBounds(30, 20, 125, 25);
        lblusername.setForeground(Color.white); 
        p1.add(lblusername);
        
        tfusername = new JTextField();
        tfusername.setBounds(200, 20, 180, 25);
        tfusername.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfusername);
        
        JLabel lblname = new JLabel("First Name");
        lblname.setFont(new Font("Arial", Font.PLAIN, 16));
        lblname.setBounds(30, 60, 125, 25);
        lblname.setForeground(Color.white);
        p1.add(lblname);
        
        tfname = new JTextField();
        tfname.setBounds(200, 60, 180, 25);
        tfname.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfname);
        
        JLabel lblLname = new JLabel("Last Name");
        lblLname.setFont(new Font("Arial", Font.PLAIN, 16));
        lblLname.setBounds(30, 100, 125, 25);
        lblLname.setForeground(Color.white);
        p1.add(lblLname);
        
        tfLname = new JTextField();
        tfLname.setBounds(200, 100, 180, 25);
        tfLname.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfLname);
        
        JLabel lblpassword = new JLabel("New Password");
        lblpassword.setFont(new Font("Arial", Font.PLAIN, 16));
        lblpassword.setBounds(30, 140, 125, 25);
        lblpassword.setForeground(Color.white);
        p1.add(lblpassword);
        
        tfpassword = new JTextField();
        tfpassword.setBounds(200, 140, 180, 25);
        tfpassword.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfpassword);
        
        JLabel lblsecurity = new JLabel("Security Question");
        lblsecurity.setFont(new Font("Arial", Font.PLAIN, 16));
        lblsecurity.setBounds(30, 180, 125, 25);
        lblsecurity.setForeground(Color.white);
        p1.add(lblsecurity);
        
        security = new Choice();
        security.add("Your Favorite Actor");
        security.add("Your Favorite Animal");
        security.add("Your Favorite Name");
        security.add("Your Favorite Language");
        security.add("Your Favorite Topic");
        security.setBounds(200, 180, 180, 25);
        p1.add(security);
        
        JLabel lblanswer = new JLabel("Answer");
        lblanswer.setFont(new Font("Arial", Font.PLAIN, 16));
        lblanswer.setBounds(30, 220, 125, 25);
        lblanswer.setForeground(Color.white);
        p1.add(lblanswer);
        
        tfanswer = new JTextField();
        tfanswer.setBounds(200, 220, 180, 25);
        tfanswer.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfanswer);
        
        back = new JButton("Back");
        back.setBackground(Color.white);
        back.setForeground(new Color(59, 89, 152)); // Facebook blue color
        back.setFont(new Font("Arial", Font.PLAIN, 14));
        back.setBounds(150, 280, 100, 30);
        back.addActionListener(this);
        p1.add(back);  
        
        create = new JButton("Create");
        create.setBackground(Color.white);
        create.setForeground(new Color(59, 89, 152));
        create.setFont(new Font("Arial", Font.PLAIN, 14));
        create.setBounds(320, 280, 100, 30);
        create.addActionListener(this);
        p1.add(create);  
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/signup.png"));
        Image i2 = i1.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(580, 50, 250, 250);
        add(image);
        setVisible(true);
    }
    
public void actionPerformed(ActionEvent ae) {
    if (ae.getSource() == create) {
        String username = tfusername.getText();
        String name = tfname.getText();
        String Lname = tfLname.getText();
        String password = tfpassword.getText();
        String question = security.getSelectedItem();
        String answer = tfanswer.getText();
        
        try {
            Conn c = new Conn();
            //String query = "INSERT INTO account VALUES ('" + username + "', '" + name + "', '" + Lname + "', '" + password + "', '" + question + "', '" + answer + "')";
            String query = "INSERT INTO account (username, name, Lname, password, security, answer) VALUES ('" + username + "', '" + name + "', '" + Lname + "', '" + password + "', '" + question + "', '" + answer + "')";
            int rowsAffected = c.s.executeUpdate(query);
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Successfully created account");
                setVisible(false);
                new Login();
            } else {
                JOptionPane.showMessageDialog(null, "Failed to create account");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
            e.printStackTrace();
        }
    } else if (ae.getSource() == back) {
        setVisible(false);
        new Login();
    }
}

    
public static void main(String[] args) {
        new Signup();
    }
}
