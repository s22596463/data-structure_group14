import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JTextPane;

public class UserInterface {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JLabel lblKeyword;
	private JLabel lblWeight;
	private JLabel lblImage;
	private JTextPane textPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserInterface window = new UserInterface();
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
	public UserInterface() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		//介面設計
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.setBounds(100, 100, 863, 574);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		textField = new JTextField();
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		lblKeyword = new JLabel("Keyword\uFF1A");
		lblKeyword.setHorizontalAlignment(SwingConstants.CENTER);
		lblKeyword.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		
		lblWeight = new JLabel("Weight \uFF1A");
		lblWeight.setHorizontalAlignment(SwingConstants.CENTER);
		lblWeight.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		
		JButton btnEnter = new JButton("Enter");
		btnEnter.setBackground(new Color(135, 206, 250));
		btnEnter.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setBackground(new Color(135, 206, 250));
		btnAdd.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		
		//控制button按下的動作
		btnEnter.addActionListener(new buttonListenerEnter());
		btnAdd.addActionListener(new buttonListenerAdd());

		//新增背景圖案
		lblImage = new JLabel();
		lblImage.setHorizontalAlignment(SwingConstants.CENTER);
		Image image = new ImageIcon(this.getClass().getResource("candidate3.jpg")).getImage();
		lblImage.setIcon(new ImageIcon(image));
		
		textPane = new JTextPane();
		textPane.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		textPane.show(false);

		//系統自動生成的
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup()
									.addContainerGap()
									.addComponent(btnAdd)
									.addGap(18)
									.addComponent(btnEnter)
									.addPreferredGap(ComponentPlacement.RELATED))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(86)
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addComponent(lblKeyword)
										.addComponent(lblWeight))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addComponent(textField_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
										.addComponent(textField, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE))))
							.addGap(135))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(textPane, GroupLayout.PREFERRED_SIZE, 363, GroupLayout.PREFERRED_SIZE)
							.addGap(18)))
					.addComponent(lblImage, GroupLayout.PREFERRED_SIZE, 379, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(162)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField, GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
						.addComponent(lblKeyword))
					.addGap(26)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblWeight))
					.addGap(29)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAdd)
						.addComponent(btnEnter))
					.addGap(36)
					.addComponent(textPane, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
					.addGap(74))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(122)
					.addComponent(lblImage, GroupLayout.PREFERRED_SIZE, 424, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		frame.getContentPane().setLayout(groupLayout);
	}
	
	//控制button按下的動作的內部class
	class buttonListenerEnter implements ActionListener{
		  public void actionPerformed(ActionEvent e){
		   System.exit(0);
		  }
		 }
	
	class buttonListenerAdd implements ActionListener{
		  public void actionPerformed(ActionEvent e){
			  textPane.show(true);
			  String showtext = textPane.getText() + textField.getText()+","+textField_1.getText() +  "  /  " ;
			  textPane.setText(showtext);
			  
			  
		  }
		 }
}
