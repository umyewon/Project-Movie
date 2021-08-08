import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class bill extends JPanel
{
	private MainFrame fm;
	private JPanel bill;
	
	int sum = 0;
	int sum2 = 0;
	
	public bill(MainFrame fm)
	{		
		this.fm = fm;
		this.bill = this;
		
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();
		JPanel panel4 = new JPanel();
		JPanel panel5 = new JPanel();
		JPanel panel6 = new JPanel();
		JPanel panel7 = new JPanel();
		JPanel panel8 = new JPanel();
		JPanel panel9 = new JPanel();
		
		fm.add(this);
		
		int num1 = foodPanel1.getSpinner1();
		int num2 = foodPanel1.getSpinner2();
		int num3 = foodPanel1.getSpinner3();
		int num4 = foodPanel2.getSpinner1();
		int num5 = foodPanel2.getSpinner2();
		int num6 = foodPanel2.getSpinner3();
		int num7 = foodPanel3.getSpinner1();
		int num8 = foodPanel3.getSpinner2();
		int num9 = foodPanel3.getSpinner3();
		
		this.setLayout(new BorderLayout());
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(9,1));
		
		JLabel payLabel1 = new JLabel("결제금액");
		payLabel1.setFont(new Font("",Font.BOLD,15));
		JTextField payTf1 = new JTextField(10);
		sum = num1*5000+num2*7000+num3*7000+num4*4000+num5*3000+num6*3000+num7*2000+num8*2000+num9*2000;
		sum2 = sum;
		payTf1.setText(sum + "");
		payTf1.setEditable(false);
		payTf1.setBackground(Color.white);
		payTf1.setFont(new Font("",Font.BOLD,15));
		payTf1.setHorizontalAlignment(JTextField.CENTER);
		
		JLabel saleLabel = new JLabel("할  인");
		saleLabel.setFont(new Font("",Font.BOLD,15));
		saleLabel.setHorizontalAlignment(JLabel.CENTER);
		
		JTextField payTf2 = new JTextField(10);
		payTf2.setFont(new Font("",Font.BOLD,15));
		payTf2.setEditable(false);
		payTf2.setBackground(Color.white);
		payTf2.setHorizontalAlignment(JTextField.CENTER);
		payTf2.setText(sum + "");
		
		String[] sale = {" 할인 없음 "," 멤버쉽 할인 (10%) "," 통신사 할인 (20%) "," 회원 할인 (30%) "};
		JComboBox saleList = new JComboBox(sale);
		saleList.setBackground(Color.white);
		saleList.setFont(new Font("",Font.BOLD,15));
		saleList.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				JComboBox cb = (JComboBox) e.getSource();
				String name = (String)cb.getSelectedItem();
				
				if(name.equals(" 할인 없음 "))
					sum2 = (int)(sum);
				if(name.equals(" 멤버쉽 할인 (10%) "))
					sum2 = (int)(sum * 0.9);
				if(name.equals(" 통신사 할인 (20%) "))
					sum2 = (int)(sum * 0.8);
				if(name.equals(" 회원 할인 (30%) "))
					sum2 = (int)(sum * 0.7);
				
				payTf2.setText(sum2 + "");
			}
		});	
		
		JLabel payLabel2 = new JLabel("최종금액");
		payLabel2.setFont(new Font("",Font.BOLD,15));
		
		JLabel payMethodLabel = new JLabel("결제방법");
		payMethodLabel.setFont(new Font("",Font.BOLD,15));
		JRadioButton phone = new JRadioButton("휴대폰");
		phone.setFont(new Font("",Font.BOLD,15));
		phone.setBackground(Color.white);
		JRadioButton card = new JRadioButton("신용카드");
		card.setBackground(Color.white);
		card.setFont(new Font("",Font.BOLD,15));
		ButtonGroup btnGroup = new ButtonGroup();
		btnGroup.add(phone);
		btnGroup.add(card);
		
		JLabel cardLabel = new JLabel("카드 종류");
		cardLabel.setFont(new Font("",Font.BOLD,15));
		String[] cardStr = {" 국민 카드 "," 롯데 카드 "," 신한 카드 "," 삼성 카드 "};
		JComboBox cardList = new JComboBox(cardStr);
		cardList.setBackground(Color.white);
		cardList.setFont(new Font("",Font.BOLD,15));
		cardList.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				JComboBox cb = (JComboBox) e.getSource();
				String name = (String)cb.getSelectedItem();
			}
		});
		
		JPanel cardPanel = new JPanel();
		cardPanel.add(cardLabel);
		cardPanel.add(new JLabel("                                          "));
		cardPanel.add(cardList);
		
		JLabel cardNumLabel = new JLabel("카드 번호");
		cardNumLabel.setFont(new Font("",Font.BOLD,15));
		JTextField cardNum1 = new JTextField(3);
		JTextField cardNum2 = new JTextField(3);
		JTextField cardNum3 = new JTextField(3);
		JTextField cardNum4 = new JTextField(3);
		cardNum1.setFont(new Font("",Font.BOLD,15));
		cardNum2.setFont(new Font("",Font.BOLD,15));
		cardNum3.setFont(new Font("",Font.BOLD,15));
		cardNum4.setFont(new Font("",Font.BOLD,15));
		
		JPanel cardNumPanel = new JPanel();
		cardNumPanel.add(cardNumLabel);
		cardNumPanel.add(new JLabel("   "));
		cardNumPanel.add(cardNum1);
		cardNumPanel.add(new JLabel(" - "));
		cardNumPanel.add(cardNum2);
		cardNumPanel.add(new JLabel(" - "));
		cardNumPanel.add(cardNum3);
		cardNumPanel.add(new JLabel(" - "));
		cardNumPanel.add(cardNum4);
		
		JLabel cardPwLabel1 = new JLabel("비밀 번호");
		cardPwLabel1.setFont(new Font("",Font.BOLD,15));
		JTextField cardPW = new JTextField(2);
		cardPW.setHorizontalAlignment(JTextField.CENTER);
		cardPW.setFont(new Font("",Font.BOLD,15));
		JLabel cardPwLabel2 = new JLabel("xx");		
		cardPwLabel2.setFont(new Font("",Font.BOLD,15));
		JPanel cardPwPanel = new JPanel();
		cardPwPanel.add(cardPwLabel1);
		cardPwPanel.add(new JLabel("                                                            "));
		cardPwPanel.add(cardPW);
		cardPwPanel.add(cardPwLabel2);
		
		JLabel nameLabel = new JLabel("성함");
		nameLabel.setFont(new Font("",Font.BOLD,15));
		JTextField nameTf = new JTextField(10);
		nameTf.setFont(new Font("",Font.BOLD,15));
		nameTf.setHorizontalAlignment(JLabel.CENTER);
		
		JPanel namePanel = new JPanel();
		namePanel.add(nameLabel);
		namePanel.add(new JLabel("                                                "));
		namePanel.add(nameTf);
		
		JLabel agencyLabel = new JLabel("통신사");
		agencyLabel.setFont(new Font("",Font.BOLD,15));
		String[] agencyStr = {"  SKT  ","  KT  ","  LG  "};
		JComboBox agencyList = new JComboBox(agencyStr);
		agencyList.setBackground(Color.white);
		agencyList.setFont(new Font("",Font.BOLD,15));
		cardList.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				JComboBox cb = (JComboBox) e.getSource();
				String name = (String)cb.getSelectedItem();
			}
		});
		
		JPanel agencyPanel = new JPanel();
		agencyPanel.add(agencyLabel);
		agencyPanel.add(new JLabel("                                                          "));
		agencyPanel.add(agencyList);
		
		JLabel phoneLabel = new JLabel("휴대폰 번호");
		phoneLabel.setFont(new Font("",Font.BOLD,15));
		JTextField phoneTf = new JTextField(12);
		phoneTf.setFont(new Font("",Font.BOLD,15));
		phoneTf.setHorizontalAlignment(JLabel.CENTER);
	//	phoneTf.setText("- 없이 입력해주세요");
		JPanel phoneNumPanel = new JPanel();
		phoneNumPanel.add(phoneLabel);
		phoneNumPanel.add(new JLabel("                      "));
		phoneNumPanel.add(phoneTf);
		
		cardPanel.setVisible(false);
		cardNumPanel.setVisible(false);
		cardPwPanel.setVisible(false);

		namePanel.setVisible(false);
		agencyPanel.setVisible(false);
		phoneNumPanel.setVisible(false);
		
		phone.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				cardPanel.setVisible(false);
				cardNumPanel.setVisible(false);
				cardPwPanel.setVisible(false);

				namePanel.setVisible(true);
				agencyPanel.setVisible(true);
				phoneNumPanel.setVisible(true);
			}
		});
		
		card.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				cardPanel.setVisible(true);
				cardNumPanel.setVisible(true);
				cardPwPanel.setVisible(true);

				namePanel.setVisible(false);
				agencyPanel.setVisible(false);
				phoneNumPanel.setVisible(false);
			}
		});
		
		JButton button_ok = new JButton("결제하기");
		button_ok.setFont(new Font("",Font.PLAIN,25));
		button_ok.setBackground(new Color(33, 150, 83));
		button_ok.setForeground(Color.white);
		JButton button_no = new JButton("이전으로");
		button_no.setFont(new Font("",Font.PLAIN,25));
		button_no.setBackground(Color.white);
		button_no.setForeground(new Color(33, 150, 83));
		
		button_ok.addActionListener(new MyActionListener1());
		button_no.addActionListener(new MyActionListener2());
		
		panel1.add(payLabel1);
		panel1.add(new JLabel("                                     "));
		panel1.add(payTf1);
		panel2.add(saleLabel);
		panel2.add(new JLabel("                                  "));
		panel2.add(saleList);
		panel3.add(payLabel2);
		panel3.add(new JLabel("                                     "));
		panel3.add(payTf2);
		panel4.add(payMethodLabel);
		panel4.add(new JLabel("                      "));
		panel4.add(phone);
		panel4.add(card);
		panel5.add(namePanel);
		panel5.add(cardPanel);
		panel6.add(agencyPanel);
		panel6.add(cardNumPanel);
		panel7.add(cardPwPanel);
		panel7.add(phoneNumPanel);
		panel8.add(button_ok);
		panel9.add(button_no);		
		
		namePanel.setBackground(Color.white);
		cardPanel.setBackground(Color.white);
		agencyPanel.setBackground(Color.white);
		cardNumPanel.setBackground(Color.white);
		cardPwPanel.setBackground(Color.white);
		phoneNumPanel.setBackground(Color.white);
		panel.setBackground(Color.white);
		panel1.setBackground(Color.white);
		panel2.setBackground(Color.white);
		panel3.setBackground(Color.white);
		panel4.setBackground(Color.white);
		panel5.setBackground(Color.white);
		panel6.setBackground(Color.white);
		panel7.setBackground(Color.white);
		panel8.setBackground(Color.white);
		panel9.setBackground(Color.white);
		
		panel.add(panel1);
		panel.add(panel2);
		panel.add(panel3);
		panel.add(panel4);
		panel.add(panel5);
		panel.add(panel6);
		panel.add(panel7);
		panel.add(panel8);
		panel.add(panel9);
		
		JPanel panel_west= new JPanel();
		panel_west.add(new JLabel("                                                                       "));
		panel_west.setBackground(Color.black);
		
		JPanel panel_east= new JPanel();
		panel_east.add(new JLabel("                                                                       "));
		panel_east.setBackground(Color.black);
		
		this.add(panel_west,BorderLayout.WEST);
		this.add(panel_east,BorderLayout.EAST);
		this.add(panel,BorderLayout.CENTER);
		
		/*
		this.add(panel1);
		this.add(panel2);
		this.add(panel3);
		this.add(panel4);
		this.add(panel5);
		this.add(panel6);
		this.add(panel7);
		this.add(panel8);
		this.add(panel9);
		*/
	}
	
	class MyActionListener1 implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			
			int result = JOptionPane.showConfirmDialog(null, sum2+"원 계산하시겠습니까?","계산",JOptionPane.YES_NO_OPTION);
			
			if(result == 0)
			{
				JOptionPane.showMessageDialog(null,  "계산이 완료되었습니다.", "계산 완료",JOptionPane.INFORMATION_MESSAGE);
				new Main(fm);
				setVisible(false);
			}
			else if(result == 1)
			{
				JOptionPane.showMessageDialog(null,  "계산이 취소되었습니다.", "계산 취소",JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	class MyActionListener2 implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
//			ChangePanel.ChangePanel(fm,bill,new foodPanel1(fm));
					new foodPanel1(fm);
					setVisible(false);
		}
	}
}
