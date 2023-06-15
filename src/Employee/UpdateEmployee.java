package Employee;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Random;

public class UpdateEmployee extends JFrame implements ActionListener {


    JTextField jtname, jtdepid, jtsal, tfdeg;
    JLabel jtempid;
    JButton Add, back;
    String employeeid;

    UpdateEmployee(String employeeid){

        this.employeeid = employeeid;
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("Update Employee Details");
        heading.setBounds(320, 30, 500, 50);
        heading.setFont(new Font("serif", Font.BOLD, 25));
        add(heading);

        JLabel name = new JLabel("Full Name");
        name.setBounds(50, 150, 150, 30);
        name.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        add(name);

        JLabel jtname = new JLabel();
        jtname.setBounds(180,155,150,25);
        add(jtname);

        JLabel deg = new JLabel("Designation");
        deg.setBounds(400, 150, 150, 30);
        deg.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        add(deg);

        tfdeg = new JTextField();
        tfdeg.setBounds(520,155,150,25);
        add(tfdeg);

        JLabel depid = new JLabel("Department Id");
        depid.setBounds(50, 200, 150, 30);
        depid.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        add(depid);

        jtdepid = new JTextField();
        jtdepid.setBounds(180,205,150,25);
        add(jtdepid);

        JLabel sal = new JLabel("Salary");
        sal.setBounds(400, 200, 150, 30);
        sal.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        add(sal);

        jtsal = new JTextField();
        jtsal.setBounds(520,205,150,25);
        add(jtsal);

        JLabel empid = new JLabel("Employee Id");
        empid.setBounds(50, 250, 150, 30);
        empid.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        add(empid);

        jtempid = new JLabel();
        jtempid.setBounds(180,255,150,25);
        add(jtempid);

        try{
            Conn c = new Conn();
            String query = "select * from employee where employeeid = '"+employeeid+"'";
            ResultSet rs = c.s.executeQuery(query);
            while (rs.next()){
                jtname.setText(rs.getString("name"));
                jtempid.setText(rs.getString("employeeid"));

            }
        } catch (Exception ae){
            ae.printStackTrace();
        }

        Add = new JButton("Update Employee");
        Add.setBounds(150, 350, 150, 35);
        Add.setBackground(Color.BLACK);
        Add.setForeground(Color.WHITE);
        Add.addActionListener(this);
        add(Add);

        back = new JButton("Back");
        back.setBounds(450, 350, 150, 35);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        setSize(900, 700);
        setLocation(50, 60);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new UpdateEmployee("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == Add) {
//            String name = jtname.getText();
            String designation = (String) tfdeg.getText();
            String depid = jtdepid.getText();
            String salary = jtsal.getText();
            String employeeid = jtempid.getText();

            try {
                Conn conn = new Conn();
                String query = "update employee set designation = '"+designation+"', deprtmentid = '"+depid+"', salary = '"+salary+"' where employeeid = '"+employeeid+"'";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Details Updated Successfully");
                setVisible(false);
                new Home();
            } catch (Exception ae){
                ae.printStackTrace();
            }
        }else if (e.getSource() == back){
            setVisible(false);
            new Home();
        }
    }
}
