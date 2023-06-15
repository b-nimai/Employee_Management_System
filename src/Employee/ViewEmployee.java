package Employee;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import net.proteanit.sql.DbUtils;

public class ViewEmployee extends JFrame implements ActionListener {

    JTable table;
    Choice cEmpId;
    JButton Search, print,update, back;
    ViewEmployee(){

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("Employees Details");
        heading.setForeground(Color.red);
        heading.setBounds(350, -80, 400, 200);
        heading.setFont(new Font("Raleway", Font.BOLD, 25));
        add(heading);


        JLabel search = new JLabel("Search by Employee Id");
        search.setBounds(20,50, 150,20);
        add(search);

        cEmpId = new Choice();
        cEmpId.setBounds(180, 50, 150, 20);
        add(cEmpId);

        table = new JTable();

        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from employee");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception ae){
            ae.printStackTrace();
        }

        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from employee");
            while (rs.next()){
                cEmpId.add(rs.getString("employeeid"));
            }
        } catch (Exception ae){
            ae.printStackTrace();
        }

        JScrollPane jsp =  new JScrollPane(table);
        jsp.setBounds(0, 150, 900, 600);
        add(jsp);

        Search = new JButton("Search");
        Search.setBounds(20, 100, 80, 20);
        Search.addActionListener(this);
        add(Search);

        print = new JButton("Print");
        print.setBounds(120, 100, 80, 20);
        print.addActionListener(this);
        add(print);

        update = new JButton("Update");
        update.setBounds(220, 100, 80, 20);
        update.addActionListener(this);
        add(update);

        back = new JButton("Back");
        back.setBounds(320, 100, 80, 20);
        back.addActionListener(this);
        add(back);


        setSize(900, 700);
        setLocation(10,10);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {

        new ViewEmployee();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == Search) {
            String query = "select * from employee where employeeid = '"+cEmpId.getSelectedItem()+"'";
            try {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (Exception ae){
                ae.printStackTrace();
            }
        }else if(e.getSource() == print){
            try {
                table.print();
            } catch (Exception ae){
                ae.printStackTrace();
            }
        }else if(e.getSource() == update){
            setVisible(false);
            new UpdateEmployee(cEmpId.getSelectedItem());
        }else{
            setVisible(false);
            new Home();
        }
    }
}
