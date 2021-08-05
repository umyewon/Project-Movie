package Reservation.seat;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Seat extends JFrame {
	JPanel pnSeat;
	JButton previous;    // 이전으로 버튼 (영화선택)
 	JButton next;		 // 다음으로 버튼 (매점)
 	JComboBox clist;
 	Font font = new Font("HY견고딕", Font.PLAIN, 24);
 	Font fontbtn = new Font("맑은고딕", Font.BOLD, 17);
 	Font fontcnt = new Font("HY견고딕", Font.PLAIN, 18);
 	Font fontclist = new Font("맑은고딕", Font.PLAIN, 15);
 	Font fonts = new Font("HY견고딕", Font.PLAIN, 16);
 	
 	
 	
	public Seat() {
		this.setSize(800, 500);
		
		pnSeat = new JPanel();
		pnSeat.setLayout(null);
		pnSeat.setBackground(Color.white);
		
		// 타이틀
		JLabel title = new JLabel("좌 석 선 택");
		title.setFont(font);
		title.setBounds(320, 10, 150, 30);
		pnSeat.add(title);
		
		
		
		// 예매인원 - 스피너
		JLabel cnt = new JLabel("예매 인원");
		cnt.setFont(fontcnt);
		cnt.setBounds(520, 50, 100, 30);
		pnSeat.add(cnt);
		
		JLabel notice = new JLabel("*최대 4명 선택 가능");
		notice.setFont(new Font("맑은고딕", Font.ITALIC, 13));
		notice.setForeground(Color.red.darker());
		notice.setBounds(530, 35, 140, 15);
		pnSeat.add(notice);
		
		String[] person = {"0", "1", "2", "3", "4"};
		clist = new JComboBox(person);
		clist.setSelectedIndex(0);
		clist.setBounds(610, 51, 50, 25);
		clist.setForeground(new Color(33, 150, 83));
		clist.setFont(fontclist);
		pnSeat.add(clist);
		
		
		
		
		
		// 좌석 버튼
		JLabel screen = new JLabel(new ImageIcon("icon/screen.PNG"));
		screen.setBounds(160, 100, 440, 25);
		pnSeat.add(screen);
		
		RoundedButtonw s1 = new RoundedButtonw(" 1 ");
		s1.setFont(fonts);
		s1.setBounds(100, 150, 45, 45);
		RoundedButtonw s2 = new RoundedButtonw(" 2 ");
		s2.setFont(fonts);
		s2.setBounds(155, 150, 45, 45);
		RoundedButtonw s3 = new RoundedButtonw(" 3 ");
		s3.setFont(fonts);
		s3.setBounds(210, 150, 45, 45);
		RoundedButtonw s4 = new RoundedButtonw(" 4 ");
		s4.setFont(fonts);
		s4.setBounds(265, 150, 45, 45);
		RoundedButtonw s5 = new RoundedButtonw(" 5 ");
		s5.setFont(fonts);
		s5.setBounds(320, 150, 45, 45);
		RoundedButtonw s6 = new RoundedButtonw(" 6 ");
		s6.setFont(fonts);
		s6.setBounds(375, 150, 45, 45);
		RoundedButtonw s7 = new RoundedButtonw(" 7 ");
		s7.setFont(fonts);
		s7.setBounds(430, 150, 45, 45);
		RoundedButtonw s8 = new RoundedButtonw(" 8 ");
		s8.setFont(fonts);
		s8.setBounds(485, 150, 45, 45);
		RoundedButtonw s9 = new RoundedButtonw(" 9 ");
		s9.setFont(fonts);
		s9.setBounds(540, 150, 45, 45);
		RoundedButtonw s10 = new RoundedButtonw(" 10 ");
		s10.setFont(fonts);
		s10.setBounds(595, 150, 45, 45);
		RoundedButtonw s11 = new RoundedButtonw(" 11 ");
		s11.setFont(fonts);
		s11.setBounds(100, 205, 45, 45);
		RoundedButtonw s12 = new RoundedButtonw(" 12 ");
		s12.setFont(fonts);
		s12.setBounds(155, 205, 45, 45);
		RoundedButtonw s13 = new RoundedButtonw(" 13 ");
		s13.setFont(fonts);
		s13.setBounds(210, 205, 45, 45);
		RoundedButtonw s14 = new RoundedButtonw(" 14 ");
		s14.setFont(fonts);
		s14.setBounds(265, 205, 45, 45);
		RoundedButtonw s15 = new RoundedButtonw(" 15 ");
		s15.setFont(fonts);
		s15.setBounds(320, 205, 45, 45);
		RoundedButtonw s16 = new RoundedButtonw(" 16 ");
		s16.setFont(fonts);
		s16.setBounds(375, 205, 45, 45);
		RoundedButtonw s17 = new RoundedButtonw(" 17 ");
		s17.setFont(fonts);
		s17.setBounds(430, 205, 45, 45);
		RoundedButtonw s18 = new RoundedButtonw(" 18 ");
		s18.setFont(fonts);
		s18.setBounds(485, 205, 45, 45);
		RoundedButtonw s19 = new RoundedButtonw(" 19 ");
		s19.setFont(fonts);
		s19.setBounds(540, 205, 45, 45);
		RoundedButtonw s20 = new RoundedButtonw(" 20 ");
		s20.setFont(fonts);
		s20.setBounds(595, 205, 45, 45);
		RoundedButtonw s21 = new RoundedButtonw(" 21 ");
		s21.setFont(fonts);
		s21.setBounds(100, 260, 45, 45);
		RoundedButtonw s22 = new RoundedButtonw(" 22 ");
		s22.setFont(fonts);
		s22.setBounds(155, 260, 45, 45);
		RoundedButtonw s23 = new RoundedButtonw(" 23 ");
		s23.setFont(fonts);
		s23.setBounds(210, 260, 45, 45);
		RoundedButtonw s24 = new RoundedButtonw(" 24 ");
		s24.setFont(fonts);
		s24.setBounds(265, 260, 45, 45);
		RoundedButtonw s25 = new RoundedButtonw(" 25 ");
		s25.setFont(fonts);
		s25.setBounds(320, 260, 45, 45);
		RoundedButtonw s26 = new RoundedButtonw(" 26 ");
		s26.setFont(fonts);
		s26.setBounds(375, 260, 45, 45);
		RoundedButtonw s27 = new RoundedButtonw(" 27 ");
		s27.setFont(fonts);
		s27.setBounds(430, 260, 45, 45);
		RoundedButtonw s28 = new RoundedButtonw(" 28 ");
		s28.setFont(fonts);
		s28.setBounds(485, 260, 45, 45);
		RoundedButtonw s29 = new RoundedButtonw(" 29 ");
		s29.setFont(fonts);
		s29.setBounds(540, 260, 45, 45);
		RoundedButtonw s30 = new RoundedButtonw(" 30 ");
		s30.setFont(fonts);
		s30.setBounds(595, 260, 45, 45);
		RoundedButtonw s31 = new RoundedButtonw(" 31 ");
		s31.setFont(fonts);
		s31.setBounds(100, 315, 45, 45);
		RoundedButtonw s32 = new RoundedButtonw(" 32 ");
		s32.setFont(fonts);
		s32.setBounds(155, 315, 45, 45);
		RoundedButtonw s33 = new RoundedButtonw(" 33 ");
		s33.setFont(fonts);
		s33.setBounds(210, 315, 45, 45);
		RoundedButtonw s34 = new RoundedButtonw(" 34 ");
		s34.setFont(fonts);
		s34.setBounds(265, 315, 45, 45);
		RoundedButtonw s35 = new RoundedButtonw(" 35 ");
		s35.setFont(fonts);
		s35.setBounds(320, 315, 45, 45);
		RoundedButtonw s36 = new RoundedButtonw(" 36 ");
		s36.setFont(fonts);
		s36.setBounds(375, 315, 45, 45);
		RoundedButtonw s37 = new RoundedButtonw(" 37 ");
		s37.setFont(fonts);
		s37.setBounds(430, 315, 45, 45);
		RoundedButtonw s38 = new RoundedButtonw(" 38 ");
		s38.setFont(fonts);
		s38.setBounds(485, 315, 45, 45);
		RoundedButtonw s39 = new RoundedButtonw(" 39 ");
		s39.setFont(fonts);
		s39.setBounds(540, 315, 45, 45);
		RoundedButtonw s40 = new RoundedButtonw(" 40 ");
		s40.setFont(fonts);
		s40.setBounds(595, 315, 45, 45);
		
		
		
		pnSeat.add(s1);
		pnSeat.add(s2);
		pnSeat.add(s3);
		pnSeat.add(s4);
		pnSeat.add(s5);
		pnSeat.add(s6);
		pnSeat.add(s7);
		pnSeat.add(s8);
		pnSeat.add(s9);
		pnSeat.add(s10);
		pnSeat.add(s11);
		pnSeat.add(s12);
		pnSeat.add(s13);
		pnSeat.add(s14);
		pnSeat.add(s15);
		pnSeat.add(s16);
		pnSeat.add(s17);
		pnSeat.add(s18);
		pnSeat.add(s19);
		pnSeat.add(s20);
		pnSeat.add(s21);
		pnSeat.add(s22);
		pnSeat.add(s23);
		pnSeat.add(s24);
		pnSeat.add(s25);
		pnSeat.add(s26);
		pnSeat.add(s27);
		pnSeat.add(s28);
		pnSeat.add(s29);
		pnSeat.add(s30);
		pnSeat.add(s31);
		pnSeat.add(s32);
		pnSeat.add(s33);
		pnSeat.add(s34);
		pnSeat.add(s35);
		pnSeat.add(s36);
		pnSeat.add(s37);
		pnSeat.add(s38);
		pnSeat.add(s39);
		pnSeat.add(s40);
		
		
		
		
		
		
		
		
		
		
		
		// 이전, 다음 버튼 
		RoundedButtonw previous = new RoundedButtonw("이  전");
		previous.setFont(fontbtn);
		previous.setBounds(20, 380, 90, 40);
		previous.setBorderPainted(false);
		previous.setFocusPainted(false);
		previous.setContentAreaFilled(false);
		
		RoundedButton next = new RoundedButton("다 음");
		next.setFont(fontbtn);
		next.setBounds(670, 380, 90, 40);
		next.setBorderPainted(false);
		next.setFocusPainted(false);
		next.setContentAreaFilled(false);
		
		pnSeat.add(previous);
		pnSeat.add(next);
		
		this.add(pnSeat);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	// 버튼 둥글게 처리 - 초록 버튼
		public class RoundedButton extends JButton {
		      public RoundedButton() { super(); decorate(); } 
		      public RoundedButton(String text) { super(text); decorate(); } 
		      public RoundedButton(Action action) { super(action); decorate(); } 
		      public RoundedButton(Icon icon) { super(icon); decorate(); } 
		      public RoundedButton(String text, Icon icon) { super(text, icon); decorate(); } 
		      protected void decorate() { setBorderPainted(false); setOpaque(false); }
		      @Override 
		      protected void paintComponent(Graphics g) {
		         Color c=new Color(33, 150, 83); //배경색 결정
		         Color o=new Color(255,255,255); //글자색 결정
		         int width = getWidth(); 
		         int height = getHeight(); 
		         Graphics2D graphics = (Graphics2D) g; 
		         graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); 
		         if (getModel().isArmed()) { graphics.setColor(c.darker()); } 
		         else if (getModel().isRollover()) { graphics.setColor(c.brighter()); } 
		         else { graphics.setColor(c); } 
		         graphics.fillRoundRect(0, 0, width, height, 10, 10); 
		         FontMetrics fontMetrics = graphics.getFontMetrics(); 
		         Rectangle stringBounds = fontMetrics.getStringBounds(this.getText(), graphics).getBounds(); 
		         int textX = (width - stringBounds.width) / 2; 
		         int textY = (height - stringBounds.height) / 2 + fontMetrics.getAscent(); 
		         graphics.setColor(o); 
		         graphics.setFont(getFont()); 
		         graphics.drawString(getText(), textX, textY); 
		         graphics.dispose(); 
		         super.paintComponent(g); 
		         }
		      }
		
		
		// 버튼 둥글게 처리 - 회색버튼
		public class RoundedButtonw extends JButton {
		      public RoundedButtonw() { super(); decorate(); } 
		      public RoundedButtonw(String text) { super(text); decorate(); } 
		      public RoundedButtonw(Action action) { super(action); decorate(); } 
		      public RoundedButtonw(Icon icon) { super(icon); decorate(); } 
		      public RoundedButtonw(String text, Icon icon) { super(text, icon); decorate(); } 
		      protected void decorate() { setBorderPainted(false); setOpaque(false); }
		      @Override 
		      protected void paintComponent(Graphics g) {
		         Color c=new Color(234, 234, 234); //배경색 결정
		         Color o=new Color(33,150,83); //글자색 결정
		         int width = getWidth(); 
		         int height = getHeight(); 
		         Graphics2D graphics = (Graphics2D) g; 
		         graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); 
		         if (getModel().isArmed()) { graphics.setColor(c.darker()); } 
		         else if (getModel().isRollover()) { graphics.setColor(c.lightGray); } 
		         else { graphics.setColor(c); } 
		         graphics.fillRoundRect(0, 0, width, height, 10, 10); 
		         FontMetrics fontMetrics = graphics.getFontMetrics(); 
		         Rectangle stringBounds = fontMetrics.getStringBounds(this.getText(), graphics).getBounds(); 
		         int textX = (width - stringBounds.width) / 2; 
		         int textY = (height - stringBounds.height) / 2 + fontMetrics.getAscent(); 
		         graphics.setColor(o); 
		         graphics.setFont(getFont()); 
		         graphics.drawString(getText(), textX, textY); 
		         graphics.dispose(); 
		         super.paintComponent(g); 
		         }
		      }

}
