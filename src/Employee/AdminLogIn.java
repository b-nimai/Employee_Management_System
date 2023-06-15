package Employee;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
//import java.awt.*;

public class AdminLogIn  extends JFrame implements ActionListener {

    AdminLogIn(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
//		setExtendedState(JFrame.MAXIMIZED_BOTH);

        JLabel heading = new JLabel ("EMPLOYEE MANAGMENT SYSTEM");
        heading.setBounds(80, 30, 1200, 60);
        heading.setFont(new Font("serif", Font.PLAIN, 60));
        heading.setForeground(Color.red);
        add(heading);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icon/front.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1100, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(50, 100, 1050, 500);
        add(image);


        JButton btn = new JButton("CLICK HERE FOR MANAGE DATA");
        btn.setBounds(400, 400, 300, 70);
        btn.setBackground(Color.BLUE);
        btn.setForeground(Color.WHITE);
        btn.addActionListener(this);
        image.add(btn);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1170, 650);

    }


    public static void main(String[] args) {
        AdminLogIn admin = new AdminLogIn();
        admin.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        setVisible(false);
        LogIn frame = new LogIn();
        frame.setVisible(true);
    }

}
