
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

public class foodPanel2 extends JPanel
{
	public static int count_food1 = 0;
	public static int count_food2 = 0;
	public static int count_food3 = 0;
	
	private MainFrame fm;
	private JPanel foodPanel2;
	
	private SpinnerNumberModel numberModel1,numberModel2,numberModel3;
	private static JSpinner spinner1,spinner2,spinner3;
	
	public foodPanel2(MainFrame fm)
	{		
		this.fm = fm;
		this.foodPanel2 = this;

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
		
		JButton button_ok = new JButton("ê²? ? •");
		button_ok.setBackground(new Color(33, 150, 83));
		button_ok.setForeground(Color.white);
		button_ok.setFont(new Font("",Font.PLAIN,20));
		JButton button_left = new JButton("??");
		button_left.setBackground(new Color(33, 150, 83));
		button_left.setForeground(Color.white);
		button_left.setFont(new Font("",Font.PLAIN,20));
		JButton button_right = new JButton("?–¶");
		button_right.setBackground(new Color(33, 150, 83));
		button_right.setForeground(Color.white);
		button_right.setFont(new Font("",Font.PLAIN,20));
		
		Image icon1 = new ImageIcon("image/food4.PNG").getImage().getScaledInstance(230, 230, 0);
		Image icon2 = new ImageIcon("image/food5.PNG").getImage().getScaledInstance(230, 230, 0);
		Image icon3 = new ImageIcon("image/food6.PNG").getImage().getScaledInstance(230, 230, 0);
		
		JLabel label1 = new JLabel(new ImageIcon(icon1));
		JLabel label2 = new JLabel(new ImageIcon(icon2));
		JLabel label3 = new JLabel(new ImageIcon(icon3));
			
		panel1.add(label1);
		panel2.add(label2);
		panel3.add(label3);
		
		JLabel money1 = new JLabel("4000?›");
		money1.setFont(new Font("",Font.PLAIN,20));
		panel4.add(money1);
		
		JLabel money2 = new JLabel("3000?›");
		money2.setFont(new Font("",Font.PLAIN,20));
		panel5.add(money2);
		
		JLabel money3 = new JLabel("3000?›");
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
		JLabel menu_name = new JLabel("ê°„ì‹ ë©”ë‰´");
		menu_name.setFont(new Font("",Font.PLAIN,20));
		panel5.add(menu_name);
		
		button_ok.addMouseListener(new MyMouseAdapterToBill());
		button_left.addMouseListener(new MyMouseAdapter1());
		button_right.addMouseListener(new MyMouseAdapter2());
		
		this.setBackground(Color.white);
		panel1.setBackground(Color.white);
		panel2.setBackground(Color.white);
		panel3.setBackground(Color.white);
		panel4.setBackground(Color.white);
		panel5.setBackground(Color.white);
		panel6.setBackground(Color.white);
		
		foodPanel2.add(panel1);
		foodPanel2.add(panel2);
		foodPanel2.add(panel3);
		foodPanel2.add(panel4);
		foodPanel2.add(panel5);
		foodPanel2.add(panel6);
	}
	class MyMouseAdapter1 extends MouseAdapter
	{
		@Override
		public void mouseClicked(MouseEvent e)
		{
			count_food1 = (int) spinner1.getValue();
			count_food2 = (int) spinner2.getValue();
			count_food3 = (int) spinner3.getValue();
			ChangePanel.ChangePanel(fm,foodPanel2,new foodPanel1(fm));
		}
	}
	class MyMouseAdapter2 extends MouseAdapter
	{
		@Override
		public void mouseClicked(MouseEvent e)
		{
			count_food1 = (int) spinner1.getValue();
			count_food2 = (int) spinner2.getValue();
			count_food3 = (int) spinner3.getValue();
			ChangePanel.ChangePanel(fm,foodPanel2,new foodPanel3(fm));
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
			int num4 = (int) spinner1.getValue();
			int num5 = (int) spinner2.getValue();
			int num6 = (int) spinner3.getValue();
			int num7 = foodPanel3.getSpinner1();
			int num8 = foodPanel3.getSpinner2();
			int num9 = foodPanel3.getSpinner3();
			
			count_food1 = (int) spinner1.getValue();
			count_food2 = (int) spinner2.getValue();
			count_food3 = (int) spinner3.getValue();
			
			if(num1 > 0)
				menu += "ê¸°ë³¸ ?Œì½?" + num1 + "ê°? ";
			if(num2 > 0)
				menu += "ìº¬ë¼ë©? ?Œì½?" + num2 + "ê°? ";
			if(num3 > 0)
				menu += "ì¹˜ì¦ˆ ?Œì½?" + num3 + "ê°? ";
			if(num4 > 0)
				menu += "?‚˜ì´?" + num4 + "ê°? ";
			if(num5 > 0)
				menu += "ê°ìì¹?" + num5 + "ê°? ";
			if(num6 > 0)
				menu += "?”„? ˆì²?" + num6 + "ê°? ";
			if(num7 > 0)
				menu += "ì½œë¼" + num7 + "ê°? ";
			if(num8 > 0)
				menu += "?‚¬?´?‹¤" + num8 + "ê°? ";
			if(num9 > 0)
				menu += "?™˜??" + num9 + "ê°? ";
			
			if(menu == "")
			{
				int result = JOptionPane.showConfirmDialog(null, "?•„ë¬´ê²ƒ?„ êµ¬ë§¤?•˜ì§? ?•Š?œ¼?‹œê² ìŠµ?‹ˆê¹??","?™•?¸ ì°?",JOptionPane.YES_NO_OPTION);
				
				if(result == 0)
				{
					ChangePanel.ChangePanel(fm,foodPanel2,new bill(fm));
				}
				else if(result == 1)
				{
					JOptionPane.showMessageDialog(null,  "?Œ?‹ êµ¬ë§¤ ì·¨ì†Œ", "êµ¬ë§¤ ì·¨ì†Œ",JOptionPane.ERROR_MESSAGE);
				}
			}
			else
			{
				menu+=" êµ¬ë§¤?•˜?‹œê² ìŠµ?‹ˆê¹??";
				int result = JOptionPane.showConfirmDialog(null, menu,"?™•?¸ ì°?",JOptionPane.YES_NO_OPTION);
				
				if(result == 0)
				{
					ChangePanel.ChangePanel(fm,foodPanel2,new bill(fm));
				}
				else if(result == 1)
				{
					JOptionPane.showMessageDialog(null,  "?Œ?‹ êµ¬ë§¤ ì·¨ì†Œ", "êµ¬ë§¤ ì·¨ì†Œ",JOptionPane.ERROR_MESSAGE);
				}
			}
		}
	}
}
