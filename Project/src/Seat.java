

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Seat extends JFrame {
	JPanel pnSeat;
	JButton previous;    // 이전으로 버튼 (영화선택)
 	JButton next;		 // 다음으로 버튼 (매점)
 	JComboBox clist;	 // 예매인원 
 	int count;			 // 예매 인원 읽어올 변수
 	int slt;		 // 클릭 읽어올 변수
 	JLabel seat1;
 	JLabel seat2;
 	JLabel seat3;
 	JLabel seat4;
 	JDialog wrong = new JDialog(this, "에러");
 	RoundedButtonw[] s = new RoundedButtonw[40];
 	Font font = new Font("HY견고딕", Font.PLAIN, 24);
 	Font fontbtn = new Font("맑은고딕", Font.BOLD, 17);
 	Font fontcnt = new Font("HY견고딕", Font.PLAIN, 18);
 	Font fontclist = new Font("맑은고딕", Font.PLAIN, 15);
 	Font fonts = new Font("HY견고딕", Font.PLAIN, 14);
 	
 	
 	
	public Seat() {
		this.setSize(800, 500);
		wrong.setBounds(150, 200, 200, 250);
		
		pnSeat = new JPanel();
		pnSeat.setLayout(null);
		pnSeat.setBackground(Color.white);
		
		// 타이틀
		JLabel title = new JLabel("좌 석 선 택");
		title.setFont(font);
		title.setBounds(320, 10, 150, 30);
		pnSeat.add(title);
		
		
		
		// 예매인원 - 콤보박스
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
		clist.setSelectedIndex(0);     // 처음 선택 되어 있을 인원 수 
		clist.setBounds(610, 51, 50, 25);
		clist.setForeground(new Color(33, 150, 83));
		clist.setFont(fontclist);
		pnSeat.add(clist);
		
		
		
		
		// *** 버튼 클릭 이벤트 처리 ***
		
		clist.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				clist.setEnabled(false);
				JComboBox person = (JComboBox) e.getSource();
				count = Integer.parseInt((String) person.getSelectedItem());
				
			}
			
		});
		
		
		
		// 좌석 버튼
		JLabel screen = new JLabel(new ImageIcon("icon/screen.PNG"));
		screen.setBounds(160, 100, 440, 25);
		pnSeat.add(screen);
		
		seat1 = new JLabel("");
		seat1.setFont(fonts);
		seat1.setBounds(300, 380, 80, 40);
		
		
		int xy1 = 55;
		int sum1 =0;
		int sum2 =0;
		int xy2 = 55;
		int sum3 =0;
		int xy3 = 55;
		int sum4 =0;
		int xy4 = 55;
	
		for(int i = 0; i < s.length; i++) {
			String str = Integer.valueOf(i+1).toString();
				s[i] = new RoundedButtonw(str);
				s[i].setBorderPainted(false);
				s[i].setFocusPainted(false);
				s[i].setContentAreaFilled(false);
				s[i].setText(str);
				s[i].setFont(fonts);
				
				if(i == 0 ) {					
					s[i].setBounds(100, 150,45, 45);
				}else if (i > 0 && i < 10) {
					sum1 += xy1;	
					s[i].setBounds(100+sum1, 150, 45, 45);
				}
				
				if( i == 10) {						
					s[i].setBounds(100, 205, 45, 45);
				}else if (i > 10 && i < 20 ) {
					sum2 += xy2;
					s[i].setBounds(100+sum2, 205, 45, 45);			
				}
				if( i == 20) {						
					s[i].setBounds(100, 260, 45, 45);
				}else if (i > 20 && i < 30) {
					sum3 += xy3;
					s[i].setBounds(100+sum3, 260, 45, 45);			
				}
				if( i == 30) {						
					s[i].setBounds(100, 315, 45, 45);
				}else if (i > 30 && i < 40) {
					sum4 += xy4;
					s[i].setBounds(100+sum4, 315, 45, 45);		}
					
					
					// *** 버튼 이벤트 처리 ***
					s[i].addMouseListener(new MouseAdapter() {
						String sum ="";
						@Override
						public void mouseClicked(MouseEvent e){
							System.out.println(str + " 번 좌석");
							
						}
				
						public void mousePressed(MouseEvent e) {
							int ck = Integer.parseInt(str);
							s[ck-1].setIcon(new ImageIcon("icon/greenbox.PNG"));
							}
					});
					pnSeat.add(s[i]);
				}
					
					
	
		
		
		
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
		
	
		
		// *** 버튼 클릭 이벤트 처리 ***
		previous.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// 영화 조회 화면
			}
			
		});
		
		next.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// 매점 화면
			}
			
		});
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
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
