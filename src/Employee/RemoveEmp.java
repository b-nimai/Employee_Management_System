package Employee;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

public class RemoveEmp extends JFrame implements ActionListener {

    Choice EmpId;
    JButton delete, back;
    RemoveEmp(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel empid = new JLabel("Employee Id");
        empid.setBounds(50,50,100,30);
        add(empid);

        EmpId = new Choice();
        EmpId.setBounds(200, 55, 150, 30);
        add(EmpId);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from employee");
            while (rs.next()){
                EmpId.add(rs.getString("employeeid"));
            }
        } catch (Exception ae){
            ae.printStackTrace();
        }

        JLabel EmpName = new JLabel("Name");
        EmpName.setBounds(50,125,100,30);
        add(EmpName);

        JLabel lblname = new JLabel();
        lblname.setBounds(200,125,100,30);
        add(lblname);

        JLabel jldesig = new JLabel("Designation");
        jldesig.setBounds(50,150,100,30);
        add(jldesig);

        JLabel lbldesig = new JLabel();
        lbldesig.setBounds(200,150,100,30);
        add(lbldesig);

        JLabel jldepid = new JLabel("Department Id");
        jldepid.setBounds(50,175,100,30);
        add(jldepid);

        JLabel lbldepid = new JLabel();
        lbldepid.setBounds(200,175,100,30);
        add(lbldepid);

        JLabel jlsal = new JLabel("Salary");
        jlsal.setBounds(50,200,100,30);
        add(jlsal);

        JLabel lblsal = new JLabel();
        lblsal.setBounds(200,200,100,30);
        add(lblsal);

        JLabel jlempid = new JLabel("Employee Id");
        jlempid.setBounds(50,225,100,30);
        add(jlempid);

        JLabel lblempid = new JLabel();
        lblempid.setBounds(200,225,100,30);
        add(lblempid);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from employee where employeeid = '"+EmpId.getSelectedItem()+"'");
            while (rs.next()){
                lblname.setText(rs.getString("name"));
                lbldesig.setText(rs.getString("designation"));
                lbldepid.setText(rs.getString("deprtmentid"));
                lblsal.setText(rs.getString("salary"));
                lblempid.setText(rs.getString("employeeid"));

            }
        } catch (Exception ae){
            ae.printStackTrace();
        }

        EmpId.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                try {
                    Conn c = new Conn();
                    ResultSet rs = c.s.executeQuery("select * from employee where employeeid = '"+EmpId.getSelectedItem()+"'");
                    while (rs.next()){
                        lblname.setText(rs.getString("name"));
                        lbldesig.setText(rs.getString("designation"));
                        lbldepid.setText(rs.getString("deprtmentid"));
                        lblsal.setText(rs.getString("salary"));
                        lblempid.setText(rs.getString("employeeid"));

                    }
                } catch (Exception ae){
                    ae.printStackTrace();
                }
            }
        });

        delete = new JButton("Delete");
        delete.setBounds(80,300,100,30);
        delete.setBackground(Color.BLACK);
        delete.setForeground(Color.WHITE);
        delete.addActionListener(this);
        add(delete);

        back = new JButton("Back");
        back.setBounds(280,300,100,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);


        setSize(700,500);
        setLocation(150,15);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new RemoveEmp();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == delete){
            try{
                Conn c = new Conn();
                String query = "delete from employee where employeeid = '"+EmpId.getSelectedItem()+"'";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Employee Data Deleted Successfully");
                setVisible(false);
                new Home();
            } catch (Exception ae){
                ae.printStackTrace();
            }

        }else{
            setVisible(false);
            new Home();
        }
    }
}
