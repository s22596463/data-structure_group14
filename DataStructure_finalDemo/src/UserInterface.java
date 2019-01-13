import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

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
import javax.swing.DropMode;

public class UserInterface {

	private JFrame frame;
	protected JTextField textField;
	protected JTextField textField_1;
	private JLabel lblKeyword;
	private JLabel lblWeight;
	private JLabel lblImage;
	private JTextPane textPane;
	private JLabel lblNewLabel;
	private JTextPane outcome;
	Viewcontrol vc = new Viewcontrol();

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
		frame.setBounds(100, 100, 858, 622);
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
		
		
		lblNewLabel = new JLabel("*Your Keywords and weights\uFF1A");
		lblNewLabel.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 20));
		
		outcome = new JTextPane();
		outcome.setFont(new Font("微軟正黑體", Font.PLAIN, 20));

		//系統自動生成的
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(76)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnAdd)
							.addGap(18)
							.addComponent(btnEnter))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(lblWeight, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblKeyword, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(textField, Alignment.TRAILING)
								.addComponent(textField_1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED))
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addGap(10)
							.addComponent(textPane, GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)
							.addGap(11)))
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(63)
							.addComponent(lblImage, GroupLayout.PREFERRED_SIZE, 414, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(outcome, GroupLayout.PREFERRED_SIZE, 405, GroupLayout.PREFERRED_SIZE)
							.addGap(27))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(168)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblKeyword)
						.addComponent(textField, GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblWeight)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE))
					.addGap(30)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnEnter)
						.addComponent(btnAdd))
					.addGap(30)
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textPane, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
					.addGap(50))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(outcome, GroupLayout.PREFERRED_SIZE, 203, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblImage, GroupLayout.PREFERRED_SIZE, 372, GroupLayout.PREFERRED_SIZE)
					.addGap(0, 0, Short.MAX_VALUE))
		);
		frame.getContentPane().setLayout(groupLayout);
	}
	
	//控制button按下的動作的內部class
	class buttonListenerEnter implements ActionListener{
		  public void actionPerformed(ActionEvent e){
			//outcome.setText("a");
			outcome.show(true);
			Facade facade = new Facade();
			try {
				facade.execute(vc.get());
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			outcome.setText("三立: "+facade.showOutcome1()+"\nTVBS: "+facade.showOutcome2()+"\n民視: "+facade.showOutcome3()+"\n聯合: "+facade.showOutcome4());
			
					  
		   //System.exit(0);
		  }
	 }
	
	class buttonListenerAdd implements ActionListener{
		  public void actionPerformed(ActionEvent e){
			  //顯示出關鍵字與權重
			  textPane.show(true);
			  String showtext = textPane.getText() + textField.getText()+","+textField_1.getText() +  "  /  " ;
			  textPane.setText(showtext);
			  //寫進arraylist裡面
			  String name = textField.getText();
			  int weight = Integer.parseInt(textField_1.getText());
			  vc.catchInput(name,weight);
		  }
		 }
}
