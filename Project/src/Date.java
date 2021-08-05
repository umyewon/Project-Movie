
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Date extends JPanel implements ActionListener {
	private MainFrame mf;
	JPanel pnmonth; // 타이틀, 달력, 버튼 패널
	JLabel month_value;
	JButton[] date_value = new JButton[49];
	JButton left;   // 왼쪽 버튼
	JButton right;  // 오른쪽 버튼
	JButton previous;    // 이전으로 버튼 (메인화면)
 	JButton next;		 // 다음으로 버튼 (지점 선택)
	calendar calendar = new calendar();
	String dd;
	
	public Date(MainFrame mf) {
		this.mf = mf;
		this.pnmonth = this;
		setLayout(null);
		setBackground(Color.white);
		
		
		
		// 폰트
		Font monthfont = new Font("HY견고딕", Font.PLAIN, 22);    // 타이틀 
		Font dayfont = new Font("맑은고딕", Font.BOLD, 18);  		// 요일 
		Font datefont = new Font("맑은고딕", Font.PLAIN, 16);		// 일 
		Font btnfont = new Font("맑은고딕", Font.BOLD, 13);		// 버튼
		
		
		// 타이틀
		left = new JButton(new ImageIcon("icon/left.png"));  // 왼쪽으로 넘기는 버튼
		left.setBounds(250, 40, 60, 60);
		left.setBorderPainted(false);      // 버튼 경계선 제거
		left.setFocusPainted(false);       // 버튼 선택한 표시 제거
		left.setContentAreaFilled(false);  // 버튼 영역 배경 제거
		pnmonth.add(left); 
		left.addActionListener(this);      // 이전 달 버튼 클릭
		
		month_value = new JLabel(); // 달력 월 표시
		month_value.setBounds(330, 40, 180, 60);
		month_value.setFont(monthfont);
		month_value.setText(calendar.getCalText());
		pnmonth.add(month_value);
		
		right = new JButton(new ImageIcon("icon/right.png"));  // 오른쪽으로 넘기는 버튼
		right.setBounds(470, 40, 60, 60);
		right.setBorderPainted(false);     
		right.setFocusPainted(false);       
		right.setContentAreaFilled(false);  
		pnmonth.add(right);
		right.addActionListener(this);      // 다음 달 버튼 클릭
		
		
		
		 // 이전 다음 버튼
		previous = new JButton("이  전");
		previous.setFont(btnfont);
		previous.setBounds(20, 20, 100, 35);
		previous.setBorderPainted(false);
		previous.setFocusPainted(false);
		previous.setForeground(new Color(246, 246, 246));
		previous.setBackground(new Color( 33, 150, 83));
		pnmonth.add(previous);
	
		
		next = new JButton("다  음");
		next.setFont(btnfont);
		next.setBounds(660, 20, 100, 35);
		next.setBorderPainted(false);
		next.setFocusPainted(false);
		next.setBackground(new Color(246, 246, 246));
		next.setForeground(new Color( 33, 150, 83));
		pnmonth.add(next);
		
		
		
		// *** 버튼 클릭 이벤트 처리 ***
		previous.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// 로그인화면
			}
		});

		next.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// 영화 조회 화면
			}
		});
		
		
		
		
		
		// 캘린더 (요일, 일)
		JPanel pndate = new JPanel();    // 요일,일
		pndate.setBackground(Color.white);
		pndate.setLayout(new GridLayout(0,7,5,5));  // 일은 그리드 레이아웃으로 설정
		String dd = "";
		
		for(int i =0; i < date_value.length; i++) { 
			String[] d= {"  일  ", "  월  ", "  화  ", "  수  ", "  목  ", "  금  ", "  토  "};
		
			
			date_value[i] = new JButton();
			date_value[i].setFont(datefont);
			date_value[i].setBorderPainted(false);
			date_value[i].setContentAreaFilled(false);
			date_value[i].setFocusPainted(false);
			
			
			if(i < 7) {
				date_value[i].setText(d[i]);
				date_value[i].setFont(dayfont);
				date_value[i].setForeground(Color.green.darker().darker());
			}
		
			pndate.add(date_value[i]);
			dd = date_value[i].getText(); 
		}
		
		
		// 캘린더 날짜 선택 이벤트 처리
		date_value[7].addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
					date_value[7].setIcon(new ImageIcon("icon/circle.png"));
					String dd = "1일";
					System.out.println(dd);
			}
		});
		
		date_value[8].addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
					date_value[8].setIcon(new ImageIcon("icon/circle.png"));
					String dd = "2일";
					System.out.println(dd);
			}
		});
		date_value[9].addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
					date_value[9].setIcon(new ImageIcon("icon/circle.png"));
					String dd = "3일";
					System.out.println(dd);
			}
		});
		date_value[10].addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
					date_value[10].setIcon(new ImageIcon("icon/circle.png"));
					String dd = "4일";
					System.out.println(dd);
			}
		});
		date_value[11].addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
					date_value[11].setIcon(new ImageIcon("icon/circle.png"));
					String dd = "5일";
					System.out.println(dd);
			}
		});
		date_value[12].addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
					date_value[12].setIcon(new ImageIcon("icon/circle.png"));
					String dd = "6일";
					System.out.println(dd);
			}
		});
		date_value[13].addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
					date_value[13].setIcon(new ImageIcon("icon/circle.png"));
					String dd = "7일";
					System.out.println(dd);
			}
		});
		date_value[14].addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
					date_value[14].setIcon(new ImageIcon("icon/circle.png"));
					String dd = "8일";
					System.out.println(dd);
			}
		});
		date_value[15].addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
					date_value[15].setIcon(new ImageIcon("icon/circle.png"));
					String dd = "9일";
					System.out.println(dd);
			}
		});
		
		date_value[16].addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
					date_value[16].setIcon(new ImageIcon("icon/circle.png"));
					String dd = "10일";
					System.out.println(dd);
			}
		});
		date_value[17].addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
					date_value[17].setIcon(new ImageIcon("icon/circle.png"));
					String dd = "11일";
					System.out.println(dd);
			}
		});
		date_value[18].addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
					date_value[18].setIcon(new ImageIcon("icon/circle.png"));
					String dd = "12일";
					System.out.println(dd);
			}
		});date_value[19].addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
					date_value[19].setIcon(new ImageIcon("icon/circle.png"));
					String dd = "13일";
					System.out.println(dd);
			}
		});
		date_value[20].addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
					date_value[20].setIcon(new ImageIcon("icon/circle.png"));
					String dd = "14일";
					System.out.println(dd);
			}
		});
		date_value[21].addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
					date_value[21].setIcon(new ImageIcon("icon/circle.png"));
					String dd = "15일";
					System.out.println(dd);
			}
		});
		date_value[22].addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
					date_value[22].setIcon(new ImageIcon("icon/circle.png"));
					String dd = "16일";
					System.out.println(dd);
			}
		});
		date_value[23].addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
					date_value[23].setIcon(new ImageIcon("icon/circle.png"));
					String dd = "17일";
					System.out.println(dd);
			}
		});
		date_value[24].addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
					date_value[24].setIcon(new ImageIcon("icon/circle.png"));
					String dd = "18일";
					System.out.println(dd);
			}
		});
		date_value[25].addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
					date_value[25].setIcon(new ImageIcon("icon/circle.png"));
					String dd = "19일";
					System.out.println(dd);
			}
		});
		date_value[26].addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
					date_value[26].setIcon(new ImageIcon("icon/circle.png"));
					String dd = "20일";
					System.out.println(dd);
			}
		});
		date_value[27].addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
					date_value[27].setIcon(new ImageIcon("icon/circle.png"));
					String dd = "21일";
					System.out.println(dd);
			}
		});date_value[28].addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
					date_value[28].setIcon(new ImageIcon("icon/circle.png"));
					String dd = "22일";
					System.out.println(dd);
			}
		});
		date_value[29].addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
					date_value[29].setIcon(new ImageIcon("icon/circle.png"));
					String dd = "23일";
					System.out.println(dd);
			}
		});
		date_value[30].addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
					date_value[30].setIcon(new ImageIcon("icon/circle.png"));
					String dd = "24일";
					System.out.println(dd);
			}
		});
		date_value[31].addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
					date_value[31].setIcon(new ImageIcon("icon/circle.png"));
					String dd = "25일";
					System.out.println(dd);
			}
		});
		date_value[32].addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
					date_value[32].setIcon(new ImageIcon("icon/circle.png"));
					String dd = "26일";
					System.out.println(dd);
			}
		});
		date_value[33].addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
					date_value[33].setIcon(new ImageIcon("icon/circle.png"));
					String dd = "27일";
					System.out.println(dd);
			}
		});
		date_value[34].addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
					date_value[34].setIcon(new ImageIcon("icon/circle.png"));
					String dd = "28일";
					System.out.println(dd);
			}
		});
		date_value[35].addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
					date_value[35].setIcon(new ImageIcon("icon/circle.png"));
					String dd = "29일";
					System.out.println(dd);
			}
		});
		date_value[36].addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
					date_value[36].setIcon(new ImageIcon("icon/circle.png"));
					String dd = "30일";
					System.out.println(dd);
			}
		});
		
		date_value[37].addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
					date_value[36].setIcon(new ImageIcon("icon/circle.png"));
					String dd = "31일";
					System.out.println(dd);	
			}
		});
		
		calendar.setButton(date_value);
		calendar.calSet();
		
		
		
		
		this.add(pnmonth);
		this.add(pndate, "South");
		this.setVisible(true);
		
		mf.add(this);
	}
	
	// 날짜 선택 정보 유저 파일에 저장   
		public void fileSave() {
			try(DataOutputStream dout = new DataOutputStream(new FileOutputStream("user.txt"))){
				dout.writeUTF(dd);
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
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
	
}
