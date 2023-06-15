package Employee;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Home extends JFrame implements ActionListener {

    JButton Add, view, update, remove;
    Home(){

        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icon/home.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1120, 630, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 1120, 630);
        add(image);

        JLabel heading = new JLabel("Employee Management System");
        heading.setForeground(Color.red);
        heading.setBounds(550, -50, 400, 200);
        heading.setFont(new Font("Raleway", Font.BOLD, 25));
        image.add(heading);

        Add = new JButton("Add Employee");
        Add.setBounds(550, 80, 150, 35);
        Add.setBackground(Color.BLUE);
        Add.setForeground(Color.WHITE);
        Add.addActionListener(this);
        image.add(Add);

        view = new JButton("View Employees");
        view.setBounds(720, 80, 150, 35);
        view.setBackground(Color.BLUE);
        view.setForeground(Color.WHITE);
        view.addActionListener(this);
        image.add(view);

        update = new JButton("Update Employee");
        update.setBounds(550, 130, 150, 35);
        update.setBackground(Color.BLUE);
        update.setForeground(Color.WHITE);
        update.addActionListener(this);
        image.add(update);

        remove = new JButton("Remove Employee");
        remove.setBounds(720, 130, 150, 35);
        remove.setBackground(Color.BLUE);
        remove.setForeground(Color.WHITE);
        remove.addActionListener(this);
        image.add(remove);

        setSize(1120, 630);
        setLocation(50, 10);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Home();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Add){
            setVisible(false);
            new AddEmployee();
        }else if(e.getSource() == view) {
            setVisible(false);
            new ViewEmployee();
        }else if(e.getSource() == update) {
            setVisible(false);
            new ViewEmployee();
        }else{
            setVisible(false);
            new RemoveEmp();
        }
    }
}
