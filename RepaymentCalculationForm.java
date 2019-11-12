import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/*
Program Name: RepaymentCalculationForm.java
	Author: Ming
	Date: Jul. 26, 2019 9:53:25 p.m.
Description: this class use to build Repayments Calculation Form
*/
public class RepaymentCalculationForm extends JFrame implements M_LoanPayable
	{
	//declare
	private JTextField studentIDTxtBox,addressTxtBox,fullNameTxtBox,cslLoanAmountTxtBox,oslLoanAmountTxtBox,
	currentPrimeInterestRateTxtBox,amortizationPeriodInMonthTxtBox,monthlyCslPaymentAmountTxtBox,monthlyOslPaymentAmountTxtBox,
	totalMonthlyPaymentAmountTxtBox,totalAmountRepaidLoanTxtBox,totalAmountBorrowedTxtBox,totalInterestTxtBox;
	private JLabel studentIDLable, adressLable,fullNameLable,cslLoanAmountLable,oslLoanAmountLable,
	currentPrimeInterestRateLable,amortizationPeriodInMonthLable,monthlyCslPaymentAmountLable,monthlyOslPaymentAmountLable,
	totalMonthlyPaymentAmountLable,totalAmountRepaidLoanLable,totalAmountBorrowedLable,totalInterestLable;
	private JPanel outputPanel,buttonPanel;
	private JButton calculatePaymentBtn,clearFieldBtn,nextBtn,previousBtn;
	private int studentListIndex=0;
	private JFrame frame;
	
	
	RepaymentCalculationForm()
	{
		frame= new JFrame("Repayment Calculation Form ");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setSize(800, 400);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setLayout(new BorderLayout());
		buildOutputPanel();
		buildButtonPanel();
		frame.add(outputPanel,"Center");
		frame.add(buttonPanel,"South");
		calculatePaymentListener nannyCalPayment = new calculatePaymentListener();
		clearFieldListener nannyClear = new clearFieldListener();
		nextBtnListener nannyNext = new nextBtnListener();
		previousBtnListener nannyPrevious = new previousBtnListener();

		
		calculatePaymentBtn.addActionListener(nannyCalPayment);
		clearFieldBtn.addActionListener(nannyClear);
		
		nextBtn.addActionListener(nannyNext);
		previousBtn.addActionListener(nannyPrevious);


	}
	public void viewStudentData(int index)
	{
		if(StudentLoanApp.studentList.size()!=0)
		{
		Student studentObj =StudentLoanApp.studentList.get(index);
		String fullAddress ="";//student full address
		fullAddress+=studentObj.getStreetNumber();
		fullAddress+=" ";
		fullAddress+=studentObj.getStreetName();
		fullAddress+=", #";
		fullAddress+=studentObj.getAptNumber();
		fullAddress+=" ";
		fullAddress+=studentObj.getCity();
		fullAddress+=", ";
		fullAddress+=studentObj.getProvince();
		fullAddress+=", ";
		fullAddress+=studentObj.getPostalCode();
		
		String fullName ="";//student full name
		fullName+=studentObj.getSurname();
		fullName+=", ";
		fullName+=studentObj.getMiddleName();
		fullName+=" ";
		fullName+=studentObj.getFirstName();
		
		//output
		studentIDTxtBox.setText(String.format("%07d",Integer.parseInt(studentObj.getStudentID())));
		addressTxtBox.setText(fullAddress);
		fullNameTxtBox.setText(fullName);
		cslLoanAmountTxtBox.setText("$"+String.format("%.2f", studentObj.getCslLoanAmount()));
		oslLoanAmountTxtBox.setText("$"+String.format("%.2f", studentObj.getOslLoanAmount()));
		}
		else//if no data
		{
			JOptionPane.showMessageDialog(frame, "Currently, There Are None Student Data In The ArrayList. User Must Enter Student Data First",  
          "Input First",JOptionPane.WARNING_MESSAGE);
			new InputForm();
			frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));

		}
	}
	public void buildOutputPanel()
	{
		outputPanel=new JPanel();
		outputPanel.setLayout(new GridLayout(13,2,5,3));
		//create lable
		studentIDLable = new JLabel("Student Number ");
		adressLable = new JLabel("Full Address ");
		fullNameLable = new JLabel("Full Name ");
		cslLoanAmountLable= new JLabel("Canada Student Loan Amount ");
		oslLoanAmountLable= new JLabel("Ontario Student Loan Amount ");
		currentPrimeInterestRateLable= new JLabel("Current Prime Interest Rate ");
		amortizationPeriodInMonthLable= new JLabel("Amortization Period In Months ");
		monthlyCslPaymentAmountLable= new JLabel("Monthly CSL Payment Amount ");
		monthlyOslPaymentAmountLable= new JLabel("Monthly OSL Payment Amount ");
		totalMonthlyPaymentAmountLable= new JLabel("Total Monthly Payment Amount ");
		totalAmountRepaidLoanLable= new JLabel("Total Amount Of Your Repaid Loan ");
		totalAmountBorrowedLable= new JLabel("Total Amount You Borrowed ");
		totalInterestLable= new JLabel("Total Interest On Your Loans ");
		
		
		
		//create text field
		studentIDTxtBox = new JTextField();
		addressTxtBox = new JTextField();
		fullNameTxtBox = new JTextField();
		cslLoanAmountTxtBox = new JTextField();
		oslLoanAmountTxtBox = new JTextField();
		currentPrimeInterestRateTxtBox=new JTextField();
		amortizationPeriodInMonthTxtBox=new JTextField();
		monthlyCslPaymentAmountTxtBox=new JTextField();
		monthlyOslPaymentAmountTxtBox=new JTextField();
		totalMonthlyPaymentAmountTxtBox=new JTextField();
		totalAmountRepaidLoanTxtBox=new JTextField();
		totalAmountBorrowedTxtBox=new JTextField();
		totalInterestTxtBox=new JTextField();
		
		viewStudentData(studentListIndex);//output
		// add all to the panel
		outputPanel.add(studentIDLable);
		outputPanel.add(studentIDTxtBox);
		
		outputPanel.add(adressLable);
		outputPanel.add(addressTxtBox);
		
		outputPanel.add(fullNameLable);
		outputPanel.add(fullNameTxtBox);
		
		outputPanel.add(cslLoanAmountLable);
		outputPanel.add(cslLoanAmountTxtBox);
		
		outputPanel.add(oslLoanAmountLable);
		outputPanel.add(oslLoanAmountTxtBox);
		
		outputPanel.add(currentPrimeInterestRateLable);
		outputPanel.add(currentPrimeInterestRateTxtBox);

		outputPanel.add(amortizationPeriodInMonthLable);
		outputPanel.add(amortizationPeriodInMonthTxtBox);
		
		outputPanel.add(monthlyCslPaymentAmountLable);
		outputPanel.add(monthlyCslPaymentAmountTxtBox);

		outputPanel.add(monthlyOslPaymentAmountLable);
		outputPanel.add(monthlyOslPaymentAmountTxtBox);
		
		outputPanel.add(totalMonthlyPaymentAmountLable);
		outputPanel.add(totalMonthlyPaymentAmountTxtBox);
		
		outputPanel.add(totalAmountRepaidLoanLable);
		outputPanel.add(totalAmountRepaidLoanTxtBox);
		
		outputPanel.add(totalAmountBorrowedLable);
		outputPanel.add(totalAmountBorrowedTxtBox);
		
		outputPanel.add(totalInterestLable);
		outputPanel.add(totalInterestTxtBox);
	}
	public void buildButtonPanel()
	{
		//panel
		buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(2,2,5,5));
		//create button
		calculatePaymentBtn = new JButton("Calculate payment");
		clearFieldBtn = new JButton("Clear fields");
		nextBtn= new JButton("Next");
		previousBtn= new JButton("Previous");
		//add buutton to panel
		buttonPanel.add(calculatePaymentBtn);
		buttonPanel.add(clearFieldBtn);
		buttonPanel.add(nextBtn);
		buttonPanel.add(previousBtn);

	}
	
	private class calculatePaymentListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			if(!currentPrimeInterestRateTxtBox.getText().isEmpty()||!amortizationPeriodInMonthTxtBox.getText().isEmpty())
			{
			if(Double.parseDouble(currentPrimeInterestRateTxtBox.getText())%0.25==0)
			{
				if(isInt(amortizationPeriodInMonthTxtBox.getText()))
				{
				// calculate loan amount
				double cslLoanAmount = Double.parseDouble(cslLoanAmountTxtBox.getText().substring(1));
				double oslLoanAmount = Double.parseDouble(oslLoanAmountTxtBox.getText().substring(1));
				double annualPrimeInterestRate = Double.parseDouble(currentPrimeInterestRateTxtBox.getText());
				int periodInMonth = Integer.parseInt(amortizationPeriodInMonthTxtBox.getText());
			
				
				double cslAnnualPrimeInterestRate = annualPrimeInterestRate+2.5;
				double oslAnnualPrimeInterestRate = annualPrimeInterestRate+1.0;
	
				double monthlyCslPaymentAmount= Math.round(calculateLoanPayment(cslLoanAmount,cslAnnualPrimeInterestRate,periodInMonth)*100.0)/100.0;
				double monthlyOslPaymentAmount=  Math.round(calculateLoanPayment(oslLoanAmount,oslAnnualPrimeInterestRate,periodInMonth)*100.0)/100.0;
				double totalMonthlyPaymentAmount =  monthlyCslPaymentAmount+monthlyOslPaymentAmount;
				double totalAmountRepaidLoan =  totalMonthlyPaymentAmount*periodInMonth;
				double totalAmountBorrowed = cslLoanAmount+oslLoanAmount;
				double totalInterest = Math.round((totalAmountRepaidLoan-totalAmountBorrowed)*100.0)/100.0;
				
				//display text box in the left
				monthlyCslPaymentAmountTxtBox.setHorizontalAlignment(JTextField.RIGHT);
				monthlyOslPaymentAmountTxtBox.setHorizontalAlignment(JTextField.RIGHT);
				totalMonthlyPaymentAmountTxtBox.setHorizontalAlignment(JTextField.RIGHT);
				totalAmountBorrowedTxtBox.setHorizontalAlignment(JTextField.RIGHT);
				totalInterestTxtBox.setHorizontalAlignment(JTextField.RIGHT);
				totalAmountRepaidLoanTxtBox.setHorizontalAlignment(JTextField.RIGHT);

				//display value to text box
				monthlyCslPaymentAmountTxtBox.setText("$"+String.format("%.2f", monthlyCslPaymentAmount));
				monthlyOslPaymentAmountTxtBox.setText("$"+String.format("%.2f",monthlyOslPaymentAmount));
				totalMonthlyPaymentAmountTxtBox.setText("$"+String.format("%.2f",totalMonthlyPaymentAmount));
				totalAmountBorrowedTxtBox.setText("$"+String.format("%.2f",totalAmountBorrowed));
				totalInterestTxtBox.setText("$"+String.format("%.2f",totalInterest));
				totalAmountRepaidLoanTxtBox.setText("$"+String.format("%.2f",totalAmountRepaidLoan));
				}
				else
					JOptionPane.showMessageDialog(frame, "Period In moth must be a interger type",  
		          "ERROR", JOptionPane.ERROR_MESSAGE); 
			}
			else
				JOptionPane.showMessageDialog(frame, "Current Prime Interest Rate Must Measured In Quater Percent",  
	          "ERROR", JOptionPane.ERROR_MESSAGE);
			}
			else
				JOptionPane.showMessageDialog(frame, "Must enter period In Month and annual Prime Interest Rate to calculate Loan amount",  
	          "ERROR", JOptionPane.ERROR_MESSAGE);
		}
		
	}
	private class clearFieldListener implements ActionListener//clear text field
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			clearTextField();
			currentPrimeInterestRateTxtBox.requestFocusInWindow();
		}
	}
	private void clearTextField()
	{
		currentPrimeInterestRateTxtBox.setText("");
		amortizationPeriodInMonthTxtBox.setText("");

		monthlyCslPaymentAmountTxtBox.setText("");
		monthlyOslPaymentAmountTxtBox.setText("");
		totalMonthlyPaymentAmountTxtBox.setText("");
		totalAmountBorrowedTxtBox.setText("");
		totalInterestTxtBox.setText("");
		totalAmountRepaidLoanTxtBox.setText("");
	}
	private class nextBtnListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e)
		{
			if(studentListIndex<StudentLoanApp.studentList.size()-1)
			{
			studentListIndex++;
			clearTextField();
			viewStudentData(studentListIndex);
			}
		}
		
	}
	private class previousBtnListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e)
		{
			if(studentListIndex>0)
			{
			studentListIndex--;
			clearTextField();
			viewStudentData(studentListIndex);
			}
		}
		
	}
	
	public static boolean isInt(String strNum)
	{
		try
		{
			 Integer.parseInt(strNum);
		}
		catch(NumberFormatException | NullPointerException nfe)
		{
			return false;
		}
		return true;
	}
	
	@Override
  public double calculateLoanPayment(double studentLoandAmount,double annualPrimeInterestRate,int periodInMonth)
	{
		double monthlyPrimeInterestRate= annualPrimeInterestRate* ANNUAL_RATE_TO_MONTHLY_RATE;
		double loanPayment;
		loanPayment = studentLoandAmount*monthlyPrimeInterestRate*Math.pow((1+monthlyPrimeInterestRate),periodInMonth)/(Math.pow((1+monthlyPrimeInterestRate),periodInMonth)-1);
		return loanPayment;
	}
}