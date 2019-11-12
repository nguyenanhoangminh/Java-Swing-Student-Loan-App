import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


/*
Program Name: StudentLoanApp.java
	Author: Ming
	Date: Jul. 24, 2019 4:50:19 p.m.
Description: this class be responsible for building the GUI
*/
public class StudentLoanApp extends JFrame
{
	//declare 
	private JButton inputFormBtn, repaymentCalculationFormBtn;
	public static ArrayList<Student> studentList = new ArrayList<>();// array list to store 
	private JFrame frame;
	private JLabel intro;
	private JPanel btnPanel;
	StudentLoanApp()
	{
		intro = new JLabel("                  This Is Minh's Student Loan Calculator");
		intro.setFont(new Font("Serif", Font.PLAIN, 30));
		frame = new JFrame("Minh Nguyen 0903260");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setSize(800, 200);
		frame.setLayout(new BorderLayout());
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		inputFormBtn = new JButton("Input Form");
		repaymentCalculationFormBtn = new JButton("Repayment Calculation Form");
		btnPanel = new JPanel();
		frame.add(intro,BorderLayout.NORTH);
		
		btnPanel.add(inputFormBtn);
		btnPanel.add(repaymentCalculationFormBtn);
		
		frame.add(btnPanel,BorderLayout.CENTER);
		inputFormListener nannyInputForm=new inputFormListener();
		repaymentCalculationFormBtnListener nannyRepaymentCalForm=new repaymentCalculationFormBtnListener();
		inputFormBtn.addActionListener(nannyInputForm);
		repaymentCalculationFormBtn.addActionListener(nannyRepaymentCalForm);

	}
	private class inputFormListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e)
		{
			frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
			new InputForm();
		}
		
	}
	private class repaymentCalculationFormBtnListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e)
		{
			frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
			new RepaymentCalculationForm();
		}
		
	}
	public static void main(String[] args)
	{
		new StudentLoanApp();
	}
	
}