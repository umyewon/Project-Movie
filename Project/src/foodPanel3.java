import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class foodPanel3 extends JPanel
{
	public static int count_food1 = 0;
	public static int count_food2 = 0;
	public static int count_food3 = 0;
	
	private MainFrame fm;
	private JPanel foodPanel3;
	
	private SpinnerNumberModel numberModel1,numberModel2,numberModel3;
	private static JSpinner spinner1,spinner2,spinner3;
	
	public foodPanel3(MainFrame fm)
	{		
		this.fm = fm;
		this.foodPanel3 = this;

		this.setLayout(new GridLayout(2,3));
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();
		JPanel panel4 = new JPanel();
		JPanel panel5 = new JPanel();
		JPanel panel6 = new JPanel();
		
		panel4.setLayout(new FlowLayout(FlowLayout.CENTER,200,10));
		panel5.setLayout(new FlowLayout(FlowLayout.CENTER,200,10));
		panel6.setLayout(new FlowLayout(FlowLayout.CENTER,200,10));
		
		fm.add(this);
		
		JButton button_ok = new JButton("결 정");
		button_ok.setBackground(new Color(33, 150, 83));
		button_ok.setForeground(Color.white);
		button_ok.setFont(new Font("",Font.PLAIN,20));
		JButton button_left = new JButton("◀");
		button_left.setBackground(new Color(33, 150, 83));
		button_left.setForeground(Color.white);
		button_left.setFont(new Font("",Font.PLAIN,20));
		JButton button_right = new JButton("▶");
		button_right.setBackground(new Color(33, 150, 83));
		button_right.setForeground(Color.white);
		button_right.setFont(new Font("",Font.PLAIN,20));
		
		Image icon1 = new ImageIcon("image/food7.PNG").getImage().getScaledInstance(230, 230, 0);
		Image icon2 = new ImageIcon("image/food8.PNG").getImage().getScaledInstance(230, 230, 0);
		Image icon3 = new ImageIcon("image/food9.PNG").getImage().getScaledInstance(230, 230, 0);
		
		JLabel label1 = new JLabel(new ImageIcon(icon1));
		JLabel label2 = new JLabel(new ImageIcon(icon2));
		JLabel label3 = new JLabel(new ImageIcon(icon3));
			
		panel1.add(label1);
		panel2.add(label2);
		panel3.add(label3);
		
		JLabel money1 = new JLabel("2000원");
		money1.setFont(new Font("",Font.PLAIN,20));
		panel4.add(money1);
		
		JLabel money2 = new JLabel("2000원");
		money2.setFont(new Font("",Font.PLAIN,20));
		panel5.add(money2);
		
		JLabel money3 = new JLabel("2000원");
		money3.setFont(new Font("",Font.PLAIN,20));
		panel6.add(money3);
		
		numberModel1 = new SpinnerNumberModel(count_food1,0,9,1);
		spinner1 = new JSpinner(numberModel1);
		panel4.add(spinner1);
		
		numberModel2 = new SpinnerNumberModel(count_food2,0,9,1);
		spinner2 = new JSpinner(numberModel2);
		panel5.add(spinner2);
		
		numberModel3 = new SpinnerNumberModel(count_food3,0,9,1);
		spinner3 = new JSpinner(numberModel3);
		panel6.add(spinner3);
		
		panel4.add(new JLabel(" "));
		panel5.add(new JLabel(" "));
		panel6.add(new JLabel(" "));
		
		panel4.add(button_left);
		panel5.add(button_ok);
		panel6.add(button_right);
		
		panel5.add(new JLabel(" "));
		JLabel menu_name = new JLabel("음료 메뉴");
		menu_name.setFont(new Font("",Font.PLAIN,20));
		panel5.add(menu_name);
		
		button_ok.addMouseListener(new MyMouseAdapterToBill());
		button_left.addMouseListener(new MyMouseAdapter());
		
		this.setBackground(Color.white);
		panel1.setBackground(Color.white);
		panel2.setBackground(Color.white);
		panel3.setBackground(Color.white);
		panel4.setBackground(Color.white);
		panel5.setBackground(Color.white);
		panel6.setBackground(Color.white);
		
		foodPanel3.add(panel1);
		foodPanel3.add(panel2);
		foodPanel3.add(panel3);
		foodPanel3.add(panel4);
		foodPanel3.add(panel5);
		foodPanel3.add(panel6);
	}
	class MyMouseAdapter extends MouseAdapter
	{
		@Override
		public void mouseClicked(MouseEvent e)
		{
			count_food1 = (int) spinner1.getValue();
			count_food2 = (int) spinner2.getValue();
			count_food3 = (int) spinner3.getValue();
			ChangePanel.ChangePanel(fm,foodPanel3,new foodPanel2(fm));
		}
	}
	
	public static int getSpinner1()
	{
		return (int) spinner1.getValue();
	}
	public static int getSpinner2()
	{
		return (int) spinner2.getValue();
	}
	public static int getSpinner3()
	{
		return (int) spinner3.getValue();
	}
	
	class MyMouseAdapterToBill extends MouseAdapter
	{
		@Override
		public void mouseClicked(MouseEvent e)
		{
			String menu = "";
	
			int num1 = foodPanel1.getSpinner1();
			int num2 = foodPanel1.getSpinner2();
			int num3 = foodPanel1.getSpinner3();
			int num4 = foodPanel2.getSpinner1();
			int num5 = foodPanel2.getSpinner2();
			int num6 = foodPanel2.getSpinner3();
			int num7 = (int) spinner1.getValue();
			int num8 = (int) spinner2.getValue();
			int num9 = (int) spinner3.getValue();
			
			count_food1 = (int) spinner1.getValue();
			count_food2 = (int) spinner2.getValue();
			count_food3 = (int) spinner3.getValue();
			
			if(num1 > 0)
				menu += "기본 팝콘" + num1 + "개 ";
			if(num2 > 0)
				menu += "캬라멜 팝콘" + num2 + "개 ";
			if(num3 > 0)
				menu += "치즈 팝콘" + num3 + "개 ";
			if(num4 > 0)
				menu += "나초" + num4 + "개 ";
			if(num5 > 0)
				menu += "감자칩" + num5 + "개 ";
			if(num6 > 0)
				menu += "프레첼" + num6 + "개 ";
			if(num7 > 0)
				menu += "콜라" + num7 + "개 ";
			if(num8 > 0)
				menu += "사이다" + num8 + "개 ";
			if(num9 > 0)
				menu += "환타" + num9 + "개 ";
			
			if(menu == "")
			{
				int result = JOptionPane.showConfirmDialog(null, "아무것도 구매하지 않으시겠습니까?","확인 창",JOptionPane.YES_NO_OPTION);
				
				if(result == 0)
				{
					ChangePanel.ChangePanel(fm,foodPanel3,new bill(fm));
				}
				else if(result == 1)
				{
					JOptionPane.showMessageDialog(null,  "음식 구매 취소", "구매 취소",JOptionPane.ERROR_MESSAGE);
				}
			}
			else
			{
				menu+=" 구매하시겠습니까?";
				int result = JOptionPane.showConfirmDialog(null, menu,"확인 창",JOptionPane.YES_NO_OPTION);
				
				if(result == 0)
				{
					ChangePanel.ChangePanel(fm,foodPanel3,new bill(fm));
				}
				else if(result == 1)
				{
					JOptionPane.showMessageDialog(null,  "음식 구매 취소", "구매 취소",JOptionPane.ERROR_MESSAGE);
				}
			}
		}
	}
}
