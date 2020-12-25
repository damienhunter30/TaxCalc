package calculations;

import java.awt.*;
import java.awt.event.*;
import java.text.*;
import javax.swing.*;

public class Gui extends JFrame implements ActionListener{
	public JLabel salary, paye, prsi, usc, payable, net;
	public JTextField salaryField, payeField, prsiField, uscField, payableField, netField;
	public JRadioButton marriedButton, singleButton;
	public ButtonGroup group = new ButtonGroup();
	public JButton submit, clear;
	public Container container = getContentPane();
	
	public Gui(){
		super("Tax Calculator 2021");
		setSize(450, 250);
		setLocation(100, 100);
		container.setLayout(null);
		
		singleButton = new JRadioButton("Single");
		container.add(singleButton);
		singleButton.addActionListener(this);
		singleButton.setBounds(310, 30, 100, 20);
		group.add(singleButton);
		
		marriedButton = new JRadioButton("Married");
		container.add(marriedButton);
		marriedButton.addActionListener(this);
		marriedButton.setBounds(310, 55, 100, 20);
		group.add(marriedButton);
		
		salary = new JLabel("Annual Salary");
		container.add(salary);
		salary.setBounds(10, 30, 200, 20);
		
		salaryField = new JTextField("");
		container.add(salaryField);
		salaryField.setBounds(105, 30, 200, 20);
		salaryField.addActionListener(this);
		
		paye = new JLabel("PAYE");
		container.add(paye);
		paye.setBounds(10, 55, 200, 20);
		
		payeField = new JTextField("");
		container.add(payeField);
		payeField.setBounds(105, 55, 200, 20);
		payeField.addActionListener(this);
		payeField.setEditable(false);
		
		prsi = new JLabel("PRSI");
		container.add(prsi);
		prsi.setBounds(10, 80, 200, 20);
		
		prsiField = new JTextField("");
		container.add(prsiField);
		prsiField.setBounds(105, 80, 200, 20);
		prsiField.addActionListener(this);
		prsiField.setEditable(false);
		
		usc = new JLabel("USC");
		container.add(usc);
		usc.setBounds(10, 105, 200, 20);
		
		uscField = new JTextField("");
		container.add(uscField);
		uscField.setBounds(105, 105, 200, 20);
		uscField.addActionListener(this);
		uscField.setEditable(false);
		
		payable = new JLabel("Payable");
		container.add(payable);
		payable.setBounds(10, 130, 200, 20);
		
		payableField = new JTextField("");
		container.add(payableField);
		payableField.setBounds(105, 130, 200, 20);
		payableField.addActionListener(this);
		payableField.setEditable(false);
		
		net = new JLabel("Net");
		container.add(net);
		net.setBounds(10, 155, 200, 20);
		
		netField = new JTextField("");
		container.add(netField);
		netField.setBounds(105, 155, 200, 20);
		netField.addActionListener(this);
		netField.setEditable(false);
		
		submit = new JButton("Submit");
		container.add(submit);
		submit.setBounds(10, 180, 200, 20);
		submit.addActionListener(this);
		
		clear = new JButton("Clear");
		container.add(clear);
		clear.setBounds(220, 180, 200, 20);
		clear.addActionListener(this);
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
	}
	
	public void actionPerformed(ActionEvent e){
		if(e.getSource() == submit){
			String status = "";
			
			if(marriedButton.isSelected()){
				status = "married";
			}
			if(singleButton.isSelected()){
				status = "married";
			}
			
			double salary = Double.parseDouble(salaryField.getText());
			double prsi = PayrollCalculator.prsiCalculate(salary), paye = PayrollCalculator.payeCalculate(salary, status), usc = PayrollCalculator.uscCalculate(salary);			
			NumberFormat formatter = new DecimalFormat("#0.00");

			payeField.setText("€" + formatter.format(paye));
			prsiField.setText("€" + formatter.format(prsi));
			uscField.setText("€" + formatter.format(usc));
			payableField.setText("€" + formatter.format(prsi + paye + usc));
			netField.setText("€" + formatter.format(salary - (prsi + paye + usc)));
		}
		if(e.getSource() == clear){
			salaryField.setText("");
			payeField.setText("");
			prsiField.setText("");
			uscField.setText("");
			payableField.setText("");
			netField.setText("");
		}
	}
	
	public static void main(String[] args){
		Gui a = new Gui();
	}
}