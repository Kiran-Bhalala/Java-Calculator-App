package Assignment2;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator implements ActionListener{
	
	 private JFrame frame;
	    private JTextField textField;
	    private JButton[] numberButtons = new JButton[10];
	    private JButton[] functionButtons = new JButton[9];
	    private JButton addButton, subButton, mulButton, divButton;
	    private JButton decimalButton, equalsButton, deleteButton, clearButton, negateButton;
	    private JPanel panel;
	    
	    private Font myFont = new Font("Xenara", Font.BOLD, 30);
	    
	    private double num1 = 0, num2 = 0, result = 0;
	    private char operator;

	    public Calculator() {
	        setUpUI();
	    }

	    private void setUpUI() {
	        frame = new JFrame("Calculator");
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setSize(420, 550);
	        frame.setLayout(null);

	        textField = new JTextField();
	        textField.setBounds(50, 25, 300, 50);
	        textField.setFont(myFont);
	        textField.setEditable(false);

	        addButton = new JButton("+");
	        subButton = new JButton("-");
	        mulButton = new JButton("*");
	        divButton = new JButton("/");
	        decimalButton = new JButton(".");
	        equalsButton = new JButton("=");
	        deleteButton = new JButton("Delete");
	        clearButton = new JButton("Clear");
	        negateButton = new JButton("Negate");

	        functionButtons[0] = addButton;
	        functionButtons[1] = subButton;
	        functionButtons[2] = mulButton;
	        functionButtons[3] = divButton;
	        functionButtons[4] = decimalButton;
	        functionButtons[5] = equalsButton;
	        functionButtons[6] = deleteButton;
	        functionButtons[7] = clearButton;
	        functionButtons[8] = negateButton;

	        for (int i = 0; i < 9; i++) {
	            functionButtons[i].addActionListener(this);
	            functionButtons[i].setFont(myFont);
	            functionButtons[i].setFocusable(false);
	        }

	        for (int i = 0; i < 10; i++) {
	            numberButtons[i] = new JButton(String.valueOf(i));
	            numberButtons[i].addActionListener(this);
	            numberButtons[i].setFont(myFont);
	            numberButtons[i].setFocusable(false);
	        }

	        negateButton.setBounds(50, 430, 100, 50);
	        deleteButton.setBounds(150, 430, 100, 50);
	        clearButton.setBounds(250, 430, 100, 50);

	        panel = new JPanel();
	        panel.setBounds(50, 100, 300, 300);
	        panel.setLayout(new GridLayout(4, 4, 10, 10));
	        panel.setBackground(Color.GRAY);

	        panel.add(numberButtons[1]);
	        panel.add(numberButtons[2]);
	        panel.add(numberButtons[3]);
	        panel.add(addButton);
	        panel.add(numberButtons[4]);
	        panel.add(numberButtons[5]);
	        panel.add(numberButtons[6]);
	        panel.add(subButton);
	        panel.add(numberButtons[7]);
	        panel.add(numberButtons[8]);
	        panel.add(numberButtons[9]);
	        panel.add(mulButton);
	        panel.add(decimalButton);
	        panel.add(numberButtons[0]);
	        panel.add(equalsButton);
	        panel.add(divButton);

	        frame.add(panel);
	        frame.add(negateButton);
	        frame.add(deleteButton);
	        frame.add(clearButton);
	        frame.add(textField);
	        frame.setVisible(true);
	    }

	    public static void main(String[] args) {
	        Calculator calc = new Calculator();
	    }

	    @Override
	    public void actionPerformed(ActionEvent e) {
	        for (int i = 0; i < 10; i++) {
	            if (e.getSource() == numberButtons[i]) {
	                textField.setText(textField.getText().concat(String.valueOf(i)));
	            }
	        }
	        if (e.getSource() == decimalButton) {
	            textField.setText(textField.getText().concat("."));
	        }
	        if (e.getSource() == addButton) {
	            num1 = Double.parseDouble(textField.getText());
	            operator = '+';
	            textField.setText("");
	        }
	        if (e.getSource() == subButton) {
	            num1 = Double.parseDouble(textField.getText());
	            operator = '-';
	            textField.setText("");
	        }
	        if (e.getSource() == mulButton) {
	            num1 = Double.parseDouble(textField.getText());
	            operator = '*';
	            textField.setText("");
	        }
	        if (e.getSource() == divButton) {
	            num1 = Double.parseDouble(textField.getText());
	            operator = '/';
	            textField.setText("");
	        }
	        if (e.getSource() == equalsButton) {
	            num2 = Double.parseDouble(textField.getText());

	            switch (operator) {
	                case '+':
	                    result = num1 + num2;
	                    break;
	                case '-':
	                    result = num1 - num2;
	                    break;
	                case '*':
	                    result = num1 * num2;
	                    break;
	                case '/':
	                    if (num2 != 0)
	                        result = num1 / num2;
	                    else
	                        textField.setText("Error: Divide by zero");
	                    break;
	            }
	            textField.setText(String.valueOf(result));
	            num1 = result;
	        }
	        if (e.getSource() == clearButton) {
	            textField.setText("");
	        }
	        if (e.getSource() == deleteButton) {
	            String string = textField.getText();
	            textField.setText("");
	            for (int i = 0; i < string.length() - 1; i++) {
	                textField.setText(textField.getText() + string.charAt(i));
	            }
	        }

	        if (e.getSource() == negateButton) {
	            double temp = Double.parseDouble(textField.getText());
	            temp *= -1;
	            textField.setText(String.valueOf(temp));
	        }
	    }
	}