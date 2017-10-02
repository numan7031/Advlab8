package thread;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Command1 {

	private JFrame frame;
	private JTextField textField1;
	private JButton button1, button2;
	private JTextPane textPane1, textPane2, textPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Command1 window = new Command1();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Command1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 522, 470);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		textField1 = new JTextField();
		textField1.setBounds(10, 11, 96, 20);
		frame.getContentPane().add(textField1);
		textField1.setColumns(10);

		button2 = new JButton("Exit");
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				frame.dispose();
			}
		});
		button2.setBounds(257, 10, 89, 23);
		frame.getContentPane().add(button2);

		JLabel label1 = new JLabel("Baht");
		label1.setBounds(23, 53, 46, 14);
		frame.getContentPane().add(label1);

		textPane1 = new JTextPane();
		textPane1.setBounds(10, 77, 131, 316);
		frame.getContentPane().add(textPane1);

		JLabel label2 = new JLabel("U.S.Dollor");
		label2.setBounds(180, 53, 73, 14);
		frame.getContentPane().add(label2);

		textPane2 = new JTextPane();
		textPane2.setBounds(167, 77, 125, 316);
		frame.getContentPane().add(textPane2);

		JLabel label3 = new JLabel("Euro");
		label3.setBounds(356, 53, 46, 14);
		frame.getContentPane().add(label3);

		textPane = new JTextPane();
		textPane.setBounds(329, 77, 125, 316);
		frame.getContentPane().add(textPane);

		button1 = new JButton("Compute");
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double num;
				num = Double.parseDouble(textField1.getText());
				Bath bt = new Bath(num, textPane1);
				USA usa = new USA(num, textPane2);
				EURO eur = new EURO(num, textPane);

				bt.start();
				usa.start();
				eur.start();
			}
		});
		frame.getRootPane().setDefaultButton(button1);
		button1.requestFocus();
		button1.setBounds(143, 10, 89, 23);
		frame.getContentPane().add(button1);

	}

	class Bath extends Thread {
		String sum1;
		String output1 = "";
		double s1;
		JTextPane textPane1;
		double num;

		public Bath(double num, JTextPane textPane1) {
			this.textPane1 = textPane1;
			this.num = num;
		}

		public void run() {

			s1 = num / 29.99;
			sum1 = String.format("%.2f", s1);
			output1 = "=" + sum1 + "\tUSD\n";
			textPane1.setText(output1);

			s1 = num / 42.75;
			sum1 = String.format("%.2f", s1);
			output1 = output1 + "=" + sum1 + "\tEUR\n";
			textPane1.setText(output1);

			s1 = num / 39.03;
			sum1 = String.format("%.2f", s1);
			output1 = output1 + "=" + sum1 + "\tJPY\n";
			textPane1.setText(output1);

			s1 = num / 3.91;
			sum1 = String.format("%.2f", s1);
			output1 = output1 + "=" + sum1 + "\tHKD\n";
			textPane1.setText(output1);

			s1 = num / 24.99;
			sum1 = String.format("%.2f", s1);
			output1 = output1 + "=" + sum1 + "\tSGD\n";
			textPane1.setText(output1);

			s1 = num / 4.81;
			sum1 = String.format("%.2f", s1);
			output1 = output1 + "=" + sum1 + "\tCNY\n";
			textPane1.setText(output1);

			s1 = num / 33.15;
			sum1 = String.format("%.2f", s1);
			output1 = output1 + "=" + sum1 + "\tAUD\n";
			textPane1.setText(output1);

			s1 = num / 5.73;
			sum1 = String.format("%.2f", s1);
			output1 = output1 + "=" + sum1 + "\tDKK\n";
			textPane1.setText(output1);

			s1 = num / 26.62;
			sum1 = String.format("%.2f", s1);
			output1 = output1 + "=" + sum1 + "\tNZD\n";
			textPane1.setText(output1);

			s1 = num / 31.37;
			sum1 = String.format("%.2f", s1);
			output1 = output1 + "=" + sum1 + "\tCAD\n";
			textPane1.setText(output1);

			s1 = num / 0.76;
			sum1 = String.format("%.2f", s1);
			output1 = output1 + "=" + sum1 + "\tPHP\n";
			textPane1.setText(output1);

			s1 = num / 0.03;
			sum1 = String.format("%.2f", s1);
			output1 = output1 + "=" + sum1 + "\tKRW\n";
			textPane1.setText(output1);

			s1 = num / 24.96;
			sum1 = String.format("%.2f", s1);
			output1 = output1 + "=" + sum1 + "\tBND\n";
			textPane1.setText(output1);

			s1 = num / 5.80;
			sum1 = String.format("%.2f", s1);
			output1 = output1 + "=" + sum1 + "\tZAR\n";
			textPane1.setText(output1);

			s1 = num / 1.25;
			sum1 = String.format("%.2f", s1);
			output1 = output1 + "=" + sum1 + "\tRUB\n";
			textPane1.setText(output1);
		}

	}

	class USA extends Thread {
		String sum1;
		String output1 = "";
		double s1;
		JTextPane textPane2;
		double num;

		public USA(double num, JTextPane textPane2) {
			this.textPane2 = textPane2;
			this.num = num;
		}

		public void run() {

			s1 = num * 29.99;
			sum1 = String.format("%.2f", s1);
			output1 = "=" + sum1 + "\tBAHT\n";
			textPane2.setText(output1);

			s1 = num * 29.99 / 42.75;
			sum1 = String.format("%.2f", s1);
			output1 = output1 + "=" + sum1 + "\tEUR\n";
			textPane2.setText(output1);

			s1 = num * 29.99 / 39.03;
			sum1 = String.format("%.2f", s1);
			output1 = output1 + "=" + sum1 + "\tJPY\n";
			textPane2.setText(output1);

			s1 = num * 29.99 / 3.91;
			sum1 = String.format("%.2f", s1);
			output1 = output1 + "=" + sum1 + "\tHKD\n";
			textPane2.setText(output1);

			s1 = num * 29.99 / 24.99;
			sum1 = String.format("%.2f", s1);
			output1 = output1 + "=" + sum1 + "\tSGD\n";
			textPane2.setText(output1);

			s1 = num * 29.99 / 4.81;
			sum1 = String.format("%.2f", s1);
			output1 = output1 + "=" + sum1 + "\tCNY\n";
			textPane2.setText(output1);

			s1 = num * 29.99 / 33.15;
			sum1 = String.format("%.2f", s1);
			output1 = output1 + "=" + sum1 + "\tAUD\n";
			textPane2.setText(output1);

			s1 = num * 29.99 / 5.73;
			sum1 = String.format("%.2f", s1);
			output1 = output1 + "=" + sum1 + "\tDKK\n";
			textPane2.setText(output1);

			s1 = num * 29.99 / 26.62;
			sum1 = String.format("%.2f", s1);
			output1 = output1 + "=" + sum1 + "\tNZD\n";
			textPane2.setText(output1);

			s1 = num * 29.99 / 31.37;
			sum1 = String.format("%.2f", s1);
			output1 = output1 + "=" + sum1 + "\tCAD\n";
			textPane2.setText(output1);

			s1 = num * 29.99 / 0.76;
			sum1 = String.format("%.2f", s1);
			output1 = output1 + "=" + sum1 + "\tPHP\n";
			textPane2.setText(output1);

			s1 = num * 29.99 / 0.03;
			sum1 = String.format("%.2f", s1);
			output1 = output1 + "=" + sum1 + "\tKRW\n";
			textPane2.setText(output1);

			s1 = num * 29.99 / 24.96;
			sum1 = String.format("%.2f", s1);
			output1 = output1 + "=" + sum1 + "\tBND\n";
			textPane2.setText(output1);

			s1 = num * 29.99 / 5.80;
			sum1 = String.format("%.2f", s1);
			output1 = output1 + "=" + sum1 + "\tZAR\n";
			textPane2.setText(output1);

			s1 = num * 29.99 / 1.25;
			sum1 = String.format("%.2f", s1);
			output1 = output1 + "=" + sum1 + "\tRUB\n";
			textPane2.setText(output1);
		}
	}

	class EURO extends Thread {
		String sum1;
		String output1 = "";
		double s1;
		JTextPane textPane3;
		double num;

		public EURO(double num, JTextPane textPane3) {
			this.textPane3 = textPane3;
			this.num = num;
		}

		public void run() {

			s1 = num * 42.75;
			sum1 = String.format("%.2f", s1);
			output1 = "=" + sum1 + "\tBAHT\n";
			textPane3.setText(output1);

			s1 = num * 42.75 / 29.99;
			sum1 = String.format("%.2f", s1);
			output1 = output1 + "=" + sum1 + "\tUSD\n";
			textPane3.setText(output1);

			s1 = num * 42.75 / 39.03;
			sum1 = String.format("%.2f", s1);
			output1 = output1 + "=" + sum1 + "\tJPY\n";
			textPane3.setText(output1);

			s1 = num * 42.75 / 3.91;
			sum1 = String.format("%.2f", s1);
			output1 = output1 + "=" + sum1 + "\tHKD\n";
			textPane3.setText(output1);

			s1 = num * 42.75 / 24.99;
			sum1 = String.format("%.2f", s1);
			output1 = output1 + "=" + sum1 + "\tSGD\n";
			textPane3.setText(output1);

			s1 = num * 42.75 / 4.81;
			sum1 = String.format("%.2f", s1);
			output1 = output1 + "=" + sum1 + "\tCNY\n";
			textPane3.setText(output1);

			s1 = num * 42.75 / 33.15;
			sum1 = String.format("%.2f", s1);
			output1 = output1 + "=" + sum1 + "\tAUD\n";
			textPane3.setText(output1);

			s1 = num * 42.75 / 5.73;
			sum1 = String.format("%.2f", s1);
			output1 = output1 + "=" + sum1 + "\tDKK\n";
			textPane3.setText(output1);

			s1 = num * 42.75 / 26.62;
			sum1 = String.format("%.2f", s1);
			output1 = output1 + "=" + sum1 + "\tNZD\n";
			textPane3.setText(output1);

			s1 = num * 42.75 / 31.37;
			sum1 = String.format("%.2f", s1);
			output1 = output1 + "=" + sum1 + "\tCAD\n";
			textPane3.setText(output1);

			s1 = num * 42.75 / 0.76;
			sum1 = String.format("%.2f", s1);
			output1 = output1 + "=" + sum1 + "\tPHP\n";
			textPane3.setText(output1);

			s1 = num * 42.75 / 0.03;
			sum1 = String.format("%.2f", s1);
			output1 = output1 + "=" + sum1 + "\tKRW\n";
			textPane3.setText(output1);

			s1 = num * 42.75 / 24.96;
			sum1 = String.format("%.2f", s1);
			output1 = output1 + "=" + sum1 + "\tBND\n";
			textPane3.setText(output1);

			s1 = num * 42.75 / 5.80;
			sum1 = String.format("%.2f", s1);
			output1 = output1 + "=" + sum1 + "\tZAR\n";
			textPane3.setText(output1);

			s1 = num * 42.75 / 1.25;
			sum1 = String.format("%.2f", s1);
			output1 = output1 + "=" + sum1 + "\tRUB\n";
			textPane3.setText(output1);
		}
	}

}
