package Employee;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class AddEmployee extends JFrame implements ActionListener {

    Random ran = new Random();
    int number = ran.nextInt(999999);

    JTextField jtname, jtdepid, jtsal;
    JComboBox jcbdeg;
    JLabel jtempid;
    JButton Add, back;

    AddEmployee(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("Add Employee Details");
        heading.setBounds(320, 30, 500, 50);
        heading.setFont(new Font("serif", Font.BOLD, 25));
        add(heading);

        JLabel name = new JLabel("Full Name");
        name.setBounds(50, 150, 150, 30);
        name.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        add(name);

        jtname = new JTextField();
        jtname.setBounds(180,155,150,25);
        add(jtname);

        JLabel deg = new JLabel("Designation");
        deg.setBounds(400, 150, 150, 30);
        deg.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        add(deg);

        String designation[] = {"Choose Designation", "Software Engineer", "Hardware Engineer", "Network Engineer"};
        jcbdeg = new JComboBox(designation);
        jcbdeg.setBackground(Color.WHITE);
        jcbdeg.setBounds(520,155,150,25);
        add(jcbdeg);

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

        jtempid = new JLabel(""+ number);
        jtempid.setBounds(180,255,150,25);
        add(jtempid);

        Add = new JButton("Add Employee");
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
        new AddEmployee();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == Add) {
            String name = jtname.getText();
            String designation = (String) jcbdeg.getSelectedItem();
            String depid = jtdepid.getText();
            String salary = jtsal.getText();
            String employeeid = jtempid.getText();

            try {
                Conn conn = new Conn();
                String query = "insert into employee values('"+name+"', '"+designation+"', '"+depid+"', '"+salary+"', '"+employeeid+"')";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Details added Successfully");
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
