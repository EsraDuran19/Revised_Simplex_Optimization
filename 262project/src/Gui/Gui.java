package Gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

public class Gui extends JFrame {

	private JPanel contentPane;
	static double[][] A;
	static double[][] firstA;
	static ArrayList<Integer> basic;
	static ArrayList<Integer> nonbasic;
	static ArrayList<Double> b;
	static double[][] CN;
	static double[][] CB;
	static int firstn;
	static int n;
	static int m;
	static double[][] newb;
	static double[][] B;
	static double[][] sol;
	static boolean nosol = false;

	static ArrayList<String> constraintType = new ArrayList<>();
	static ArrayList<Double> c = new ArrayList<>();
	static boolean minimize = false;
	static boolean status = true;

	private JTextField textField_4;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gui frame = new Gui();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	public Gui() throws Exception {

		setResizable(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1243, 726);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 204, 204));
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		getContentPane().setLayout(null);

		JSpinner spinner = new JSpinner();
		spinner.setForeground(new Color(51, 204, 255));
		spinner.setBackground(new Color(255, 255, 224));
		spinner.setBounds(216, 195, 75, 26);
		getContentPane().add(spinner);

		JSpinner spinner_1 = new JSpinner();
		spinner_1.setForeground(new Color(102, 0, 255));
		spinner_1.setBackground(new Color(255, 255, 224));
		spinner_1.setBounds(216, 158, 75, 26);
		contentPane.add(spinner_1);

		JButton but = new JButton("Let's Goo");
		but.setForeground(new Color(139, 0, 0));
		but.setBackground(new Color(219, 112, 147));
		but.setBounds(460, 439, 89, 23);
		contentPane.add(but);

		JTextArea textArea = new JTextArea();
		textArea.setLineWrap(true);
		textArea.setBackground(new Color(255, 255, 224));
		textArea.setWrapStyleWord(true);
		textArea.setRows(4);
		textArea.setBounds(450, 232, 281, 196);
		contentPane.add(textArea);

		JLabel lblNewLabel = new JLabel("Z =");
		lblNewLabel.setBounds(41, 232, 49, 14);
		contentPane.add(lblNewLabel);

		textField_4 = new JTextField();
		textField_4.setBackground(new Color(255, 255, 224));
		textField_4.setBounds(81, 229, 288, 32);
		contentPane.add(textField_4);
		textField_4.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Number of constraints");
		lblNewLabel_1.setBounds(76, 161, 144, 20);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Number of variables");
		lblNewLabel_2.setBounds(78, 192, 132, 29);
		contentPane.add(lblNewLabel_2);

		JTextPane textPane = new JTextPane();
		textPane.setBackground(new Color(255, 204, 204));
		textPane.setBounds(66, 508, 144, 170);
		contentPane.add(textPane);

		String[] const1 = { "Minimize", "Maximize" };
		JComboBox comboBox = new JComboBox(const1);
		comboBox.setBackground(new Color(51, 255, 255));
		comboBox.setBounds(81, 287, 132, 26);
		contentPane.add(comboBox);

		JTextArea txtrPleaseFillAll = new JTextArea();
		txtrPleaseFillAll.setForeground(new Color(51, 0, 204));
		txtrPleaseFillAll.setFont(new Font("Maiandra GD", Font.BOLD, 14));
		txtrPleaseFillAll.setLineWrap(true);
		txtrPleaseFillAll.setBackground(new Color(255, 204, 204));
		txtrPleaseFillAll.setText(
				"Please fill all of the required areas  While writing the  values put a space  each of them as shown below");
		txtrPleaseFillAll.setBounds(801, 212, 418, 68);
		contentPane.add(txtrPleaseFillAll);

		JLabel lbl = new JLabel();
		lbl.setBounds(905, 242, 314, 460);
		contentPane.add(lbl);

		lbl.setIcon(new ImageIcon(getClass().getResource("/gui2.jpg")));

		JLabel lbl1 = new JLabel("New label");
		lbl1.setBounds(53, 11, 166, 136);
		contentPane.add(lbl1);
		lbl1.setIcon(new ImageIcon(getClass().getResource("/pic1.jpg")));

		JLabel lblNewLabel_3 = new JLabel("WELCOME TO REVISED SIMPLEX METHOD CALCULATOR");
		lblNewLabel_3.setForeground(new Color(102, 102, 255));
		lblNewLabel_3.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 24));
		lblNewLabel_3.setBackground(new Color(255, 204, 204));
		lblNewLabel_3.setBounds(278, 11, 611, 75);
		contentPane.add(lblNewLabel_3);

		JTextArea textArea_1 = new JTextArea();
		textArea_1.setLineWrap(true);
		textArea_1.setBackground(new Color(255, 204, 204));
		textArea_1.setBounds(414, 515, 189, 144);
		contentPane.add(textArea_1);

		JLabel lbl1_1 = new JLabel("");
		lbl1_1.setBounds(1002, 0, 250, 136);
		contentPane.add(lbl1_1);
		lbl1_1.setIcon(new ImageIcon(getClass().getResource("/koc.png")));

		but.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if ((int) spinner_1.getValue() <= 0 || (int) spinner.getValue() <= 0) {
					JOptionPane.showMessageDialog(null, "Number of constraints or variables are not suitable ");
				} else if (textArea.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Matrix cannot be empty! ");
				} else if (textField_4.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Z values cannot be empty! ");
				}

				else {

					minimize = false;
					m = (int) spinner_1.getValue();
					firstn = (int) spinner.getValue();
					n = firstn;
					firstA = new double[m][n];
					A = firstA;
					basic = new ArrayList<>();
					nonbasic = new ArrayList<>();
					b = new ArrayList<>();
					c = new ArrayList<>();
					status = true;
					constraintType = new ArrayList<>();
					nosol = false;

					String x = textArea.getText();
					String z = textField_4.getText();
					String[] forc = z.split(" ");
					for (int i = 0; i < forc.length; i++) {
						c.add(Double.parseDouble(forc[i]));
						System.out.println(forc[i]);
					}
					System.out.println(c.toString());
					if (c.size() != n) {
						JOptionPane.showMessageDialog(null,
								"Number of coefficients in objective function does not match with the number of variables! ");
					}

					if (comboBox.getSelectedIndex() == 0) {
						minimize = true;
						for (int i = 0; i < c.size(); i++) {
							c.set(i, c.get(i) * (-1));
						}
					}
					System.out.println(c.toString());

					parse(x, m, n);

					String a = solve();

					textPane.setText(a);
					textArea_1.setText(getBminus());
				}
			}
		});

	}

	public static void parse(String x, int m, int n) {
		String[] splited = x.split("\n"); // m tane string var
		if (splited.length != m) {
			JOptionPane.showMessageDialog(null,
					"Number of constraints in th matrix does not match with the number of constraints! ");
		}
		for (int i = 0; i < m; i++) {
			String[] splited1 = splited[i].split(" "); // n + 2 tane eleman var
			if (splited1.length != n + 2) {
				JOptionPane.showMessageDialog(null, "Matrix is not proper! \n Please try to leave only 1 space.");
			}
			for (int j = 0; j < n; j++) {
				A[i][j] = Double.parseDouble(splited1[j]);
			}
			constraintType.add(splited1[n]);
			b.add(Double.parseDouble(splited1[n + 1]));
		}
		System.out.println("b is");
		System.out.println(b.toString());
		System.out.println("A is");
		printarray(A);

	}

	public static String solve() {

		int numOfvariables = 0;

		constraintType = checkforequality(constraintType, m, n, b);

		for (int i = 0; i < n; i++) {
			nonbasic.add(i);
		}
		m = constraintType.size();
		constraintType = checkforconstraint(b, constraintType, m, n);

		B = new double[m][m];

		for (int i = 0; i < constraintType.size(); i++) {
			B[i][i] = 1;
			numOfvariables++;
			c.add((double) 0);
		}

		numOfvariables = n + numOfvariables;
		newb = listtoarray(b);
		initializeA(constraintType, m, n, numOfvariables, c);

		// System.out.println(c.toString());

		printA(m, numOfvariables);
		// printB(B, m);

		System.out.println("CN");
		printarray(CN);
		System.out.println("CB");
		printarray(CB);
		System.out.println();
		System.out.println(constraintType.toString());
		sol = newb;
		int x = 1;
		System.out.println((wNminusCn() != -1) + " " + status + " " + !nosol);
		while (((wNminusCn() != -1) || dual()) && status && !nosol) {

			System.out.println("----------------------------iteration " + x++);

			if (dual()) {
				dualSimplex();
			} else {
				iteration();
			}

		}
		String res;
		if (!status) {
			res = "The problem is unbounded";
		} else if (nosol) {
			res = "No feasible solution";
		} else {
			double[][] z = matMul(CB, B);
			double[] sum = mat(z, b);
			double result = 0;
			for (int i = 0; i < sum.length; i++) {
				result += sum[i];
			}
			if (minimize) {
				result *= (-1);
			}
			System.out.println(result); // 0 5 3 olmalý
			res = "The optimum solution is: \n" + result + "\n";

			sol = matMul(B, newb);
			for (int i = 0; i < basic.size(); i++) {
				if (basic.get(i) < n)
					res += "x" + (basic.get(i) + 1) + " = " + sol[i][0] + "\n";
			}

		}
		return res;

	}

	public static String getBminus() {
		String text = "B inverse is \n";

		for (int i = 0; i < B.length; i++) {
			for (int j = 0; j < B[0].length; j++) {
				String x = "";
				x += B[i][j];
				if (x.length() > 4) {
					x = x.substring(0, 4);
					text += x + "  ";
				} else if (x.charAt(0) == '-') {
					text += x + "  ";
				} else {
					text += x + "   ";
				}

			}
			text += "\n";
		}

		return text;
	}

	public static boolean isequal() {
		double[][] generalx = new double[n][1];
		double[][] row = new double[1][n];

		for (int i = 0; i < basic.size(); i++) {
			int g = basic.get(i);
			generalx[g][0] = sol[i][0];

		}
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < A[0].length; j++) {
				row[0][j] = A[i][j];
			}
			double[][] c = matMul(row, generalx);
			double q = c[0][0];
			if (constraintType.get(i).equals("<=")) {
				if (q > b.get(i)) {
					return false;
				}
			} else if (constraintType.get(i).equals(">=")) {
				if (q < b.get(i)) {
					return false;
				}
			}
		}

		return true;
	}

	public static void dualSimplex() {
		System.out.println("The Xb values are such: ");
		printarray(sol);
		System.out.println();
		double min = 0.0;
		int a = (-1);
		for (int i = 0; i < sol.length; i++) {
			System.out.println("karþýlaþtýrýyoruz" + sol[i][0]);
			if (sol[i][0] < min) {
				min = sol[i][0];
				a = i;
			}
		}
		// leaving a, 0 1 olarak basic.get(a) normal
		double[][] row0 = wm(); // 1xnonbasic kadar
		double[][] xy; // 3 row x 1 col
		ArrayList<Double> leavingrow = new ArrayList<>();
		for (int i = 0; i < nonbasic.size(); i++) {

			xy = matMul(B, getCol(nonbasic.get(i), A));
			leavingrow.add(xy[a][0]);
		}
		int enters = findLeavingfordual(row0, leavingrow);

		if (enters != -1) {
			int aa = nonbasic.get(enters);

			// printarray(getCol(aa, A));
			double[][] y = matMul(B, getCol(aa, A));

			System.out.println("Entering variable is x" + nonbasic.get(enters));

			if (a != -1) {
				System.out.println("Leaving variable is x" + basic.get(a));
				double p = y[a][0];
				System.out.println("p is " + p);
				System.out.println("y is");
				printarray(y);

				double[][] pivot = y;
				for (int i = 0; i < y.length; i++) {

					if (i == a) {

						pivot[i][0] = (1 / p);

					} else {
						pivot[i][0] = (y[i][0] / p) * (-1);

					}
				}
				int temp = nonbasic.get(enters);
				nonbasic.set(enters, basic.get(a));
				basic.set(a, temp);
				double temp1 = CN[0][enters];
				CN[0][enters] = CB[0][a];
				CB[0][a] = temp1;
				System.out.println("pivot array");
				printarray(pivot);
				updateB(pivot, a);

				System.out.println("New B");
				printarray(B);
				sol = matMul(B, newb);
				System.out.println("The Xb values are such: ");
				printarray(sol);
				System.out.println();
			} else {
				status = false;
			}
		} else {
			nosol = true;
		}

	}

	public static boolean dual() {
		for (int i = 0; i < sol.length; i++) {
			if (sol[i][0] < 0) {
				return true;
			}
		}

		return false;
	}

	public static int findLeavingfordual(double[][] row0, ArrayList<Double> xy) {
		int inds = -1;
		double min = 1000;
		for (int i = 0; i < nonbasic.size(); i++) {
			if (xy.get(i) < 0) {
				if (Math.abs(row0[0][i] / xy.get(i)) < min) {
					min = Math.abs(row0[0][i] / xy.get(i));
					inds = i;
				}
			}

		}

		return inds;
	}

	public static void initializeA(ArrayList<String> constraintType, int m, int n, int numOfvariables,
			ArrayList<Double> c) {

		double[][] tempA = new double[m][numOfvariables];
		int count = 0;
		int i;
		for (i = 0; i < m; i++) {
			if (constraintType.get(i).equals(">=")) {

				for (int j = 0; j < n; j++) {
					tempA[i][j] = A[i][j];
				}
				tempA[i][n + count] = -1;
				nonbasic.add(n + count);
				// cN.add(c.get(i))
				count++;

				tempA[i][n + count] = 1;
				basic.add(n + count);
				count++;
			} else {
				for (int j = 0; j < n; j++) {
					tempA[i][j] = A[i][j];
				}
				tempA[i][n + count] = 1;
				basic.add(n + count);
				count++;
			}

		}
		A = tempA;
		System.out.println(basic.size());
		System.out.println(nonbasic.size());
		CN = new double[1][nonbasic.size()];
		CB = new double[1][basic.size()];
		for (i = 0; i < basic.size(); i++) {
			System.out.println(i);
			CB[0][i] = c.get(basic.get(i));
		}
		for (i = 0; i < nonbasic.size(); i++) {
			CN[0][i] = c.get(nonbasic.get(i));
		}

	}

	public static double[][] listtoarray(ArrayList<Double> b) {
		double[][] x = new double[b.size()][1];
		for (int i = 0; i < b.size(); i++) {
			x[i][0] = b.get(i);
		}
		return x;
	}

	public static void printA(int m, int numOfvariables) {
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < numOfvariables; j++) {
				System.out.printf("%,3f ", A[i][j]);
			}
			System.out.println();
		}
	}

	public static void printB(double[][] B, int m) {
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < m; j++) {
				System.out.printf("%f ", B[i][j]);
			}
			System.out.println();
		}
	}

	public static void printarray(double[][] B) {
		for (int i = 0; i < B.length; i++) {
			for (int j = 0; j < B[0].length; j++) {
				System.out.print(B[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	public static void iteration() {
		System.out.println(nonbasic.toString());
		System.out.println(basic.toString());
		int enters = wNminusCn();
		int aa = nonbasic.get(enters);
		// printarray(getCol(aa, A));
		double[][] y = matMul(B, getCol(aa, A));

		System.out.println("Entering variable is x" + nonbasic.get(enters));
		int a = findLeaves(y);
		if (a != -1) {
			System.out.println("Leaving variable is x" + basic.get(a));
			double p = y[a][0];
			System.out.println("p is " + p);
			System.out.println("y is");
			printarray(y);

			double[][] pivot = y;
			for (int i = 0; i < y.length; i++) {

				if (i == a) {

					pivot[i][0] = (1 / p);

				} else {
					pivot[i][0] = (y[i][0] / p) * (-1);

				}
			}
			int temp = nonbasic.get(enters);
			nonbasic.set(enters, basic.get(a));
			basic.set(a, temp);
			double temp1 = CN[0][enters];
			CN[0][enters] = CB[0][a];
			CB[0][a] = temp1;
			System.out.println("pivot array");
			printarray(pivot);
			updateB(pivot, a);

			System.out.println("New B");
			printarray(B);
			sol = matMul(B, newb);
			System.out.println("The Xb values are such: ");
			printarray(sol);
			System.out.println();
		} else {
			status = false;
		}
	}

	public static int findLeaves(double[][] y) {

		double min = 1000000;
		int index = -1;
		for (int i = 0; i < y.length; i++) {
			if (y[i][0] > 0) {
				if (min > (sol[i][0] / y[i][0])) {
					System.out.println(min);
					min = (sol[i][0] / y[i][0]);
					System.out.println(min);
					index = i;
				}

			}
		}
		System.out.println("leave index " + index);

		return index;
	}

	public static double[][] getCol(int num, double[][] array) {

		double[][] col = new double[m][1];
		for (int i = 0; i < m; i++) {
			col[i][0] = array[i][num];

		}
		return col;
	}

	public static void updateB(double[][] pivot, int a) {
		int x = basic.size();

		System.out.println("B update edecez........");
		double[][] E = new double[x][x];
		for (int i = 0; i < x; i++) {
			E[i][i] = 1;
		}
		for (int i = 0; i < x; i++) {
			E[i][a] = pivot[i][0];
		}

		B = matMul(E, B);

	}

	public static ArrayList<String> checkforequality(ArrayList<String> constraintType, int m, int n,
			ArrayList<Double> b) {
		System.out.println("equalýty check");
		int count = 0;
		for (int i = 0; i < m; i++) {
			if (constraintType.get(i).equals("=")) {
				count++;
			}
		}
		if (count != 0) {
			double[][] temp = new double[m + count][n];

			for (int i = 0; i < m; i++) {
				temp[i] = A[i];
			}
			int x = 0;
			for (int i = 0; i < m; i++) {
				if (constraintType.get(i).equals("=")) {

					constraintType.set(i, "<=");
					constraintType.add("<=");

					b.add(b.get(i) * (-1));
					for (int j = 0; j < n; j++) {
						temp[m + x][j] = A[i][j] * (-1);

					}
					x++;
				}
			}
			A = temp;
			System.out.println("AFTER EQUALTY CHECK");
			printarray(A);
			System.out.println(constraintType.toString());
		}

		return constraintType;
	}

	public static ArrayList<String> checkforconstraint(ArrayList<Double> b, ArrayList<String> constraintType, int m,
			int n) {
		for (int i = 0; i < b.size(); i++) {
			if (constraintType.get(i).equals(">=")) {
				constraintType.set(i, "<=");
				b.set(i, b.get(i) * (-1));
				for (int j = 0; j < n; j++) {
					A[i][j] *= (-1);
				}

			}
		}

		return constraintType;

	}

	public static int wNminusCn() {
		double[][] w = matMul(CB, B);
		double[][] result = getN();
		result = matMul(w, result);
		for (int i = 0; i < nonbasic.size(); i++) {
			// System.out.println(CN[0][i]);
			result[0][i] -= CN[0][i];
		}
		System.out.println("wN-CN : ");
		printarray(result);
		double min = 0;
		int index = -1;
		for (int i = 0; i < result[0].length; i++) {
			if (result[0][i] < min) {
				min = result[0][i];
				index = i;
			}
		}
		// System.out.println(index);
		return index;

	}

	public static double[][] wm() {
		double[][] w = matMul(CB, B);
		double[][] result = getN();
		result = matMul(w, result);
		for (int i = 0; i < nonbasic.size(); i++) {
			// System.out.println(CN[0][i]);
			result[0][i] -= CN[0][i];
		}
		System.out.println("wN-CN : ");
		printarray(result);

		// System.out.println(index);
		return result;

	}

	public static double[][] getN() {
		double result[][] = new double[m][nonbasic.size()];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < nonbasic.size(); j++) {
				result[i][j] = A[i][nonbasic.get(j)];
			}
		}
		return result;
	}

	public static double[][] matMul(double[][] first, double[][] second) {
		int i, j, k;
		int r = first.length;
		int c = second[0].length;
		int x = second.length;
		double[][] mul = new double[r][c];
		// Initializing elements of matrix mult to 0.
		for (i = 0; i < r; i++) {
			for (j = 0; j < c; j++) {
				mul[i][j] = 0;
				for (k = 0; k < x; k++) {
					// System.out.println("[" + i + "]" + "[" + j + "]" + "+=" + first[i][k] + " " +
					// second[k][j]);
					mul[i][j] += first[i][k] * second[k][j];
				}
			}
		}
		return mul;
	}

	public static double[] mat(double[][] mat1, ArrayList<Double> mat2) {

		int R1 = mat1[0].length;
		double[] sum = new double[mat2.size()];
		for (int i = 0; i < R1; i++) {
			sum[i] = mat1[0][i] * mat2.get(i);

		}
		return sum;
	}
}
