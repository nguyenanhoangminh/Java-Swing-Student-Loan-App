
/*
Program Name: InputForm.java
	Author: Ming
	Date: Jul. 24, 2019 5:30:19 p.m.
Description: this class use to build Input Form
*/
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.event.WindowEvent;

public class InputForm  extends JFrame
{
	//declare
	private JPanel inputPanel,buttonPanel;
	private JTextField studentIDTxtBox, surnameTxtBox, middleNameTxtBox,firstNameTxtBox,aptNumberTxtBox,streetNumberTxtBox,streetNameTxtBox,
	cityTxtBox,postalCodeTxtBox, cslLoanAmountTxtBox, oslLoanAmountTxtBox;
	private JButton submitBtn,viewBtn;
	private JLabel studentIDLable, surnameLable, middleNameLable,firstNameLable,aptNumberLable,streetNumberLable,streetNameLable,
	cityLable,provinceLable,postalCodeLable, cslLoanAmountLable, oslLoanAmountLable;
	private JFrame frame;
	private JComboBox<String> provinceOptions;

	InputForm()
	{
    frame = new JFrame("Input Form"); 
		buildInputPanel();
		buildButtonPanel();
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setSize(800, 400);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setLayout(new BorderLayout());
		frame.add(inputPanel,"Center");
		frame.add(buttonPanel,"South");
		// add event listener
		submitBtnListener nanny = new submitBtnListener();
		submitBtn.addActionListener(nanny);
		viewBtnListener nannyView = new viewBtnListener();
		viewBtn.addActionListener(nannyView);
	}
	public void clearTxtBox(JTextField txtBox)
	{
		txtBox.setText("");
	}
	private class viewBtnListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e)
		{
			frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
			new RepaymentCalculationForm();
		}
	}
	
	private class submitBtnListener implements ActionListener 
	{

		@Override
		public void actionPerformed(ActionEvent e)
		{
		if(isNumeric(studentIDTxtBox.getText()))
		{
			if(studentIDTxtBox.getText().length()<8)
				{
				if(isNumeric(cslLoanAmountTxtBox.getText())&&isNumeric(oslLoanAmountTxtBox.getText()))
				{
				try
				{
				if(Double.parseDouble(cslLoanAmountTxtBox.getText())<0)
					throw new M_NegativeValueException(); 
				if(Double.parseDouble(oslLoanAmountTxtBox.getText())<0)
					throw new M_NegativeValueException(); 
				}
				catch(Exception ex)
				{
					JOptionPane.showMessageDialog(frame, "Can't Enter A Negative Value In Either Of  CSL Loan Amount And OSL Loan Amount",  
		           "Bad input",  
		           JOptionPane.WARNING_MESSAGE); 
					JOptionPane.showMessageDialog(frame, "the negative number will be convert to positive",  
		           "information",  
		           JOptionPane.INFORMATION_MESSAGE); 
				}
				finally{
					if(Double.parseDouble(cslLoanAmountTxtBox.getText())<0)
					{
						cslLoanAmountTxtBox.setText(Double.toString(Double.parseDouble(cslLoanAmountTxtBox.getText())*(-1)));
					}
					if(Double.parseDouble(oslLoanAmountTxtBox.getText())<0)
					{
						oslLoanAmountTxtBox.setText(Double.toString(Double.parseDouble(oslLoanAmountTxtBox.getText())*(-1)));
					}
				}
				Student obj = new Student(studentIDTxtBox.getText(),surnameTxtBox.getText(),middleNameTxtBox.getText(),firstNameTxtBox.getText(),
																aptNumberTxtBox.getText(),streetNumberTxtBox.getText(),streetNameTxtBox.getText(),cityTxtBox.getText(),(String)(provinceOptions.getSelectedItem())
																,postalCodeTxtBox.getText(),Double.parseDouble(cslLoanAmountTxtBox.getText()),Double.parseDouble(oslLoanAmountTxtBox.getText()));
				StudentLoanApp.studentList.add(obj);
			
			
			
					JOptionPane.showMessageDialog(frame, "Student personal data and amounts of their loan have been saved",  
           "Success Saved",  
           JOptionPane.INFORMATION_MESSAGE); 
			 // clear text box
			 clearTxtBox(studentIDTxtBox);
			 clearTxtBox(surnameTxtBox);
			 clearTxtBox(middleNameTxtBox);
			 clearTxtBox(firstNameTxtBox);
			 clearTxtBox(aptNumberTxtBox);
			 clearTxtBox(streetNumberTxtBox);
			 clearTxtBox(streetNameTxtBox);
			 clearTxtBox(cityTxtBox);
			 provinceOptions.setSelectedIndex(6);
			 clearTxtBox(postalCodeTxtBox);
			 clearTxtBox(cslLoanAmountTxtBox);
			 clearTxtBox(oslLoanAmountTxtBox);
			}
			 else
					JOptionPane.showMessageDialog(frame, "Loan Amount Must Be A Number",  
	            "ERROR", JOptionPane.ERROR_MESSAGE);
			 }
			else
					JOptionPane.showMessageDialog(frame, "Student ID Just Consisting 7 Character",  
	            "ERROR", JOptionPane.ERROR_MESSAGE);
			}
			else 
				JOptionPane.showMessageDialog(frame, "Student ID Must Be Number",  
            "ERROR", JOptionPane.ERROR_MESSAGE); 
		}
		
	}
	public static boolean isNumeric(String strNum)
	{
		try
		{
			 Double.parseDouble(strNum);
		}
		catch(NumberFormatException | NullPointerException nfe)
		{
			return false;
		}
		return true;
	}
	public void buildInputPanel()
	{
		inputPanel = new JPanel();
		inputPanel.setLayout(new GridLayout(12,2,5,3));
		
		String provinceCanada[] = {"Alberta", "British Columbia", "Manitoba", "New Brunswick", "Newfoundland and Labrador", "Nova Scotia", "Ontario", "Prince Edward Island", "Quebec", "Saskatchewan"};
		provinceOptions = new JComboBox<String>(provinceCanada);
		provinceOptions.setSelectedIndex(6);
		studentIDTxtBox = new JTextField();
		surnameTxtBox = new JTextField();
		middleNameTxtBox = new JTextField();
		firstNameTxtBox = new JTextField();
		aptNumberTxtBox = new JTextField();
		streetNumberTxtBox = new JTextField();
		streetNameTxtBox = new JTextField();
		cityTxtBox = new JTextField();
		postalCodeTxtBox = new JTextField();
		cslLoanAmountTxtBox = new JTextField();
		oslLoanAmountTxtBox = new JTextField();
		
		studentIDLable= new JLabel("Please Enter Your Student ID"); 
		surnameLable= new JLabel("Please Enter Your Surname");
		 middleNameLable= new JLabel("Please Enter Your Middle Name");
		firstNameLable= new JLabel("Please Enter Your First Name");
		aptNumberLable= new JLabel("Please Enter Your Apartment Number");
		streetNumberLable= new JLabel("Please Enter Your Street Number");
		streetNameLable= new JLabel("Please Enter Your Street Name");
		cityLable= new JLabel("Please Enter Your City");
		provinceLable= new JLabel("Please Enter Your Province");
		postalCodeLable= new JLabel("Please Enter Your Postal Code"); 
		cslLoanAmountLable= new JLabel("Please Enter Your Canada Student Loan Amount");
		 oslLoanAmountLable= new JLabel("Please Enter Your Ontario Student Loan Amount");

		
		inputPanel.add(studentIDLable);
		inputPanel.add(studentIDTxtBox);
		
		inputPanel.add(surnameLable);
		inputPanel.add(surnameTxtBox);
		
		inputPanel.add(middleNameLable);
		inputPanel.add(middleNameTxtBox);
		
		inputPanel.add(firstNameLable);
		inputPanel.add(firstNameTxtBox);
		
		inputPanel.add(aptNumberLable);
		inputPanel.add(aptNumberTxtBox);
		
		inputPanel.add(streetNumberLable);
		inputPanel.add(streetNumberTxtBox);
		
		inputPanel.add(streetNameLable);
		inputPanel.add(streetNameTxtBox);
		
		inputPanel.add(cityLable);
		inputPanel.add(cityTxtBox);
		
		inputPanel.add(provinceLable);
		inputPanel.add(provinceOptions);
		
		inputPanel.add(postalCodeLable);
		inputPanel.add(postalCodeTxtBox);
		
		inputPanel.add(cslLoanAmountLable);
		inputPanel.add(cslLoanAmountTxtBox);
		
		inputPanel.add(oslLoanAmountLable);
		inputPanel.add(oslLoanAmountTxtBox);
	}
	public void buildButtonPanel()
	{
		buttonPanel = new JPanel();
		submitBtn = new JButton("submit");
		buttonPanel.add(submitBtn);
		viewBtn= new JButton("View");
		buttonPanel.add(viewBtn);

	}

}
