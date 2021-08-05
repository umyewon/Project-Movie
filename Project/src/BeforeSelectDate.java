package Reservation.calendar;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class BeforeSelectDate extends JFrame implements ActionListener {
	JPanel pnmonth; // 월이 들어갈 패널
	JPanel pndate;  // 일이 들어갈 패널
	JPanel pnbtn;   // 이전, 다음 버튼 들어갈 패널
	JLabel month_value;
	JButton[] date_value = new JButton[49];
	Font font;      // 타이틀 글씨
	Font monthfont;
	Font dayfont;   // 요일 글씨
	Font datefont;  // 일 글씨
	JButton left;   // 왼쪽 버튼
	JButton right;  // 오른쪽 버튼
	JButton previous;    // 이전으로 버튼 (메인화면)
 	JButton next;		 // 다음으로 버튼 (지점 선택)
 	Icon btn1 = new ImageIcon("icon/after.png");
 	Icon btn2 = new ImageIcon("icon/before.png");
	
	calendar calendar = new calendar();

	public BeforeSelectDate() {
		
		super("영화티켓 예매");
		this.setSize(800, 600);
		pnbtn = new JPanel();
		pnbtn.setBackground(Color.white);
		
		pnmonth = new JPanel();  // 월
		pnmonth.setBackground(Color.white);
		
		pndate = new JPanel();    // 요일,일
		pndate.setBackground(Color.white);
		pndate.setLayout(new GridLayout(0,7,5,5));  // 일은 그리드 레이아웃으로 설정
		
		font = new Font("굴림체", Font.BOLD, 21);     // 타이틀 폰트 지정
		monthfont = new Font("굴림체", Font.BOLD, 21);     // 타이틀 폰트 지정
		dayfont = new Font("굴림체", Font.BOLD, 18);  // 요일 폰트 지정
		datefont = new Font("Arial", Font.PLAIN, 16); // 일 폰트 지정
		
		
		left = new JButton(new ImageIcon("icon/left.png"));  // 왼쪽으로 넘기는 버튼
		left.setPreferredSize(new Dimension(100,100));
		left.setBorderPainted(false); // 버튼 경계선 제거
		left.setFocusPainted(false); // 버튼 선택한 표시 제거
		left.setContentAreaFilled(false);  // 버튼 영역 배경 제거
		pnmonth.add(left); 
		left.addActionListener(this); // 이전 달 버튼 클릭
		
		month_value = new JLabel(); // 달력 월 표시
		month_value.setFont(monthfont);
		month_value.setText(calendar.getCalText());
		pnmonth.add(month_value);
		
		right = new JButton(new ImageIcon("icon/right.png"));  // 오른쪽으로 넘기는 버튼
		right.setPreferredSize(new Dimension(100,100));
		right.setBorderPainted(false); // 버튼 경계선 제거
		right.setFocusPainted(false); // 버튼 선택한 표시 제거
		right.setContentAreaFilled(false);  // 버튼 영역 배경 제거
		pnmonth.add(right);
		right.addActionListener(this); // 다음 달 버튼 클릭
		
		
		for(int i =0; i < date_value.length; i++) { // 달력 요일 , 일
			String[] d= {"  일  ", "  월  ", "  화  ", "  수  ", "  목  ", "  금  ", "  토  "};
		
			
			date_value[i] = new JButton();
			date_value[i].setFont(datefont);
			date_value[i].setBorderPainted(false);
			date_value[i].setContentAreaFilled(false);
			//date_value[i].addActionListener(this);  this 말고 익명클래스로 해서 this 대신 넣기
			date_value[i].setFocusPainted(false);
			
			
			if(i < 7) {
				date_value[i].setText(d[i]);
				date_value[i].setFont(dayfont);
				date_value[i].setForeground(Color.green.darker().darker());
			}
		
			pndate.add(date_value[i]);
			
		}
		
		calendar.setButton(date_value);
		calendar.calSet();
		
		
		
		previous = new JButton(btn2);
		previous.setPreferredSize(new Dimension(350, 80));
		previous.addActionListener(this);
		previous.setBorderPainted(false);
		previous.setFocusPainted(false);
		previous.setContentAreaFilled(false);
		pnbtn.add(previous);
	
		
		next = new JButton(btn1);
		//next.setBounds(480,15,170,50);
		next.setPreferredSize(new Dimension(350, 80));
		next.setBorderPainted(false);
		next.setFocusPainted(false);
		next.setContentAreaFilled(false);
		next.addActionListener(this);
		pnbtn.add(next);
		
	
		this.add(pnmonth,"North");
		this.add(pndate, "Center");
		this.add(pnbtn, "South");
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
	}
	
	
	private class calendar {
		Calendar calendar;
		int year;
		int month;
		JButton[] btn;
		
		public calendar() {
			calendar = Calendar.getInstance();
			year = calendar.get(Calendar.YEAR);
			month = calendar.get(Calendar.MONTH) + 1;
		}
		
		public void setButton(JButton[] btn) {
			this.btn = btn;
		}
		
		
		// 년월 수정
		public void calInput(int gap) {
			month += gap;
			if(month <= 0) { // 1월에서 이전 버튼 눌렀을 때 이전 년도로
				month = 12;
				year--;
			} else if (month >= 13) { // 12월에서 다음 버튼 눌렀을 때 다음 년도로
				month = 1;
				year++;
			}
		}
		
		public String getCalText() {  // 라벨에 출력할 문자
			String str = year + "년 " + month + "월";
			return str;
		}

		public void calSet() {
			calendar.set(year, month-1, 1);
			int firstday = calendar.get(Calendar.DAY_OF_WEEK)-1;
			for(int i = 1; i <= calendar.getActualMaximum(Calendar.DATE); i++) {
				btn[6 + firstday + i].setText(String.valueOf(i));
			}
		}
		
		
		// 달력을 새로운 년월로 그리기
		public void allInit(int gap) {
			// 버튼의 날짜 지우기
			for(int i = 7; i < btn.length; i++) {
				btn[i].setText("");
			}
			// 년월 수정
			calInput(gap);
			calSet();
		}
		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == left) {  // 이전달
			calendar.allInit(-1);
			month_value.setText(calendar.getCalText());
		} else if(e.getSource() == right) {  // 다음달
			calendar.allInit(1);
			month_value.setText(calendar.getCalText());
		}
		
	}
	
}
