package Employee;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.*;

public class LogIn extends JFrame implements ActionListener {

    JTextField userTf ;
    JPasswordField userTfP;
    LogIn(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("Admin Login Panel");
        heading.setFont(new Font("serif", Font.BOLD, 25));
        heading.setBounds(150, 10, 250,50);
        add(heading);

        JLabel user = new JLabel("Username");
        user.setBounds(40, 100, 100, 30);
        add(user);

        userTf = new JTextField();
        userTf.setBounds(110, 100, 150 , 30);
        add(userTf);

        JLabel userPass = new JLabel("Password");
        userPass.setBounds(40, 150, 100, 30);
        add(userPass);

        userTfP = new JPasswordField();
        userTfP.setBounds(110, 150, 150 , 30);
        add(userTfP);

        JButton login = new JButton("LOGIN");
        login.setBounds(110, 200, 150, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);


        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icon/second.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(300, 70, 200, 200);
        add(image);


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 300);
        setLocation(450, 200);

    }


    public static void main(String[] args) {
        LogIn frame = new LogIn();
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        try {
            String username = userTf.getText();
            String password = userTfP.getText();

            Conn c = new Conn();
            String query = "select * from login where username = '"+username+"' and password = '"+password+"'";
            ResultSet rs = c.s.executeQuery(query);
            if (rs.next()) {
                setVisible(false);
                new Home();
            } else {
                JOptionPane.showMessageDialog(null, "Invalid Username or Password");
//                setVisible(false);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
