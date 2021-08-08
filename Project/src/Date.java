
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
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
	JPanel pnmonth, pndate; // 타이틀 + 버튼 패널 / 달력 패널
	JLabel month_value;
	JButton[] date_value = new JButton[49];
	JButton left;        // 이전 달 버튼
	JButton right;       // 다음 달 버튼
	JButton previous;    // 이전으로 버튼 (메인화면)
 	JButton next;		 // 다음으로 버튼 (지점 선택)
	calendar calendar = new calendar();
	String dd;
	int clickcnt;
	
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
		this.add(previous);
	
		
		next = new JButton("다  음");
		next.setFont(btnfont);
		next.setBounds(660, 20, 100, 35);
		next.setBorderPainted(false);
		next.setFocusPainted(false);
		next.setBackground(new Color(246, 246, 246));
		next.setForeground(new Color( 33, 150, 83));
		this.add(next);
		
		
		
		// *** 버튼 클릭 이벤트 처리 ***
		previous.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new Main(mf);
				setVisible(false);
			}
		});

		next.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				// 날짜 변경 됐을 때 변경된 값만 저장하게 무비 파일에 저장할 날짜 정보 여기서 입력
				if(dd.equals("1일"))
					fileSave(calendar.getCalText() + " " +dd);
				else if(dd.equals("2일"))
					fileSave(calendar.getCalText() + " " +dd);
				else if(dd.equals("3일"))
					fileSave(calendar.getCalText() + " " +dd);
				else if(dd.equals("4일"))
					fileSave(calendar.getCalText() + " " +dd);
				else if(dd.equals("5일"))
					fileSave(calendar.getCalText() + " " +dd);
				else if(dd.equals("6일"))
					fileSave(calendar.getCalText() + " " +dd);
				else if(dd.equals("7일"))
					fileSave(calendar.getCalText() + " " +dd);
				else if(dd.equals("8일"))
					fileSave(calendar.getCalText() + " " +dd);
				else if(dd.equals("9일"))
					fileSave(calendar.getCalText() + " " +dd);
				else if(dd.equals("10일"))
					fileSave(calendar.getCalText() + " " +dd);
				else if(dd.equals("11일"))
					fileSave(calendar.getCalText() + " " +dd);
				else if(dd.equals("12일"))
					fileSave(calendar.getCalText() + " " +dd);
				else if(dd.equals("13일"))
					fileSave(calendar.getCalText() + " " +dd);
				else if(dd.equals("14일"))
					fileSave(calendar.getCalText() + " " +dd);
				else if(dd.equals("15일"))
					fileSave(calendar.getCalText() + " " +dd);
				else if(dd.equals("16일"))
					fileSave(calendar.getCalText() + " " +dd);
				else if(dd.equals("17일"))
					fileSave(calendar.getCalText() + " " +dd);
				else if(dd.equals("18일"))
					fileSave(calendar.getCalText() + " " +dd);
				else if(dd.equals("19일"))
					fileSave(calendar.getCalText() + " " +dd);
				else if(dd.equals("20일"))
					fileSave(calendar.getCalText() + " " +dd);
				else if(dd.equals("21일"))
					fileSave(calendar.getCalText() + " " +dd);
				else if(dd.equals("22일"))
					fileSave(calendar.getCalText() + " " +dd);
				else if(dd.equals("23일"))
					fileSave(calendar.getCalText() + " " +dd);
				else if(dd.equals("24일"))
					fileSave(calendar.getCalText() + " " +dd);
				else if(dd.equals("25일"))
					fileSave(calendar.getCalText() + " " +dd);
				else if(dd.equals("26일"))
					fileSave(calendar.getCalText() + " " +dd);
				else if(dd.equals("27일"))
					fileSave(calendar.getCalText() + " " +dd);
				else if(dd.equals("28일"))
					fileSave(calendar.getCalText() + " " +dd);
				else if(dd.equals("28일"))
					fileSave(calendar.getCalText() + " " +dd);
				else if(dd.equals("29일"))
					fileSave(calendar.getCalText() + " " +dd);
				else if(dd.equals("30일"))
					fileSave(calendar.getCalText() + " " +dd);
				else if(dd.equals("31일"))
					fileSave(calendar.getCalText() + " " +dd);
				
				
				// 지점 선택 화면으로 이동
				new Location(mf);
				setVisible(false);
			}
		});
		
		
		
		
		
		// 캘린더 (요일, 일)
		pndate = new JPanel();    // 요일,일
		pndate.setBackground(Color.white);
		pndate.setLayout(new GridLayout(0,7,5,5));  // 일은 그리드 레이아웃으로 설정
		pndate.setBounds(100,110, 600, 400);
		dd = "";
		
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
		
		
		// **** 캘린더 날짜 선택 시 이벤트 처리 : 선택 된 날짜 표시하고, 날짜 변경 시 표시된 위치 바뀜
		clickcnt = 0;  // 클릭 횟수
		date_value[7].addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
					date_value[7].setIcon(new ImageIcon("icon/circle.png"));
					dd ="1일"; 
					++clickcnt;
					if(clickcnt % 2 == 0) {
						date_value[7].setIcon(null);
						dd="";
					}
			}
		});
		
		date_value[8].addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
					date_value[8].setIcon(new ImageIcon("icon/circle.png"));
					dd = "2일";
					++clickcnt;
					if(clickcnt % 2 == 0) {
						date_value[8].setIcon(null);
						dd="";
					}
					
			}
		});
		date_value[9].addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
					date_value[9].setIcon(new ImageIcon("icon/circle.png"));
					 dd = "3일";
					 ++clickcnt;
					if(clickcnt % 2 == 0) {
						date_value[9].setIcon(null);
						dd="";
					}
			}
		});
		date_value[10].addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
					date_value[10].setIcon(new ImageIcon("icon/circle.png"));
					dd = "4일";
					++clickcnt;
					if(clickcnt % 2 == 0) {
						date_value[10].setIcon(null);
						dd="";
					}
			}
		});
		date_value[11].addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
					date_value[11].setIcon(new ImageIcon("icon/circle.png"));
					dd = "5일";
					++clickcnt;
					if(clickcnt % 2 == 0) {
						date_value[11].setIcon(null);
						dd="";
					}
			}
		});
		date_value[12].addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
					date_value[12].setIcon(new ImageIcon("icon/circle.png"));
					dd = "6일";
					++clickcnt;
					if(clickcnt % 2 == 0) {
						date_value[12].setIcon(null);
						dd="";
					}
			}
		});
		date_value[13].addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
					date_value[13].setIcon(new ImageIcon("icon/circle.png"));
					dd = "7일";
					++clickcnt;
					if(clickcnt % 2 == 0) {
						date_value[13].setIcon(null);
						dd="";
					}
			}
		});
		date_value[14].addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
					date_value[14].setIcon(new ImageIcon("icon/circle.png"));
					dd = "8일";
					++clickcnt;
					if(clickcnt % 2 == 0) {
						date_value[134].setIcon(null);
						dd="";
					}
			}
		});
		date_value[15].addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
					date_value[15].setIcon(new ImageIcon("icon/circle.png"));
					 dd = "9일";
					 ++clickcnt;
					 if(clickcnt % 2 == 0) {
							date_value[15].setIcon(null);
							dd="";
						}
			}
		});
		
		date_value[16].addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
					date_value[16].setIcon(new ImageIcon("icon/circle.png"));
					dd = "10일";
					++clickcnt;
					if(clickcnt % 2 == 0) {
						date_value[16].setIcon(null);
						dd="";
					}
			}
		});
		date_value[17].addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
					date_value[17].setIcon(new ImageIcon("icon/circle.png"));
					dd = "11일";
					++clickcnt;
					if(clickcnt % 2 == 0) {
						date_value[17].setIcon(null);
						dd="";
					}
			}
		});
		date_value[18].addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
					date_value[18].setIcon(new ImageIcon("icon/circle.png"));
					 dd = "12일";
					 ++clickcnt;
					 if(clickcnt % 2 == 0) {
							date_value[18].setIcon(null);
							dd="";
						}
			}
		});date_value[19].addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
					date_value[19].setIcon(new ImageIcon("icon/circle.png"));
					dd = "13일";
					++clickcnt;
					if(clickcnt % 2 == 0) {
						date_value[19].setIcon(null);
						dd="";
					}
			}
		});
		date_value[20].addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
					date_value[20].setIcon(new ImageIcon("icon/circle.png"));
					 dd = "14일";
					 ++clickcnt;
					 if(clickcnt % 2 == 0) {
							date_value[20].setIcon(null);
							dd="";
						}
			}
		});
		date_value[21].addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
					date_value[21].setIcon(new ImageIcon("icon/circle.png"));
					dd = "15일";
					++clickcnt;
					 if(clickcnt % 2 == 0) {
							date_value[21].setIcon(null);
							dd="";
						}
			}
		});
		date_value[22].addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
					date_value[22].setIcon(new ImageIcon("icon/circle.png"));
					dd = "16일";
					++clickcnt;
					 if(clickcnt % 2 == 0) {
							date_value[22].setIcon(null);
							dd="";
						}
			}
		});
		date_value[23].addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
					date_value[23].setIcon(new ImageIcon("icon/circle.png"));
					 dd = "17일";
					 ++clickcnt;
					 if(clickcnt % 2 == 0) {
							date_value[23].setIcon(null);
							dd="";
						}
			}
		});
		date_value[24].addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
					date_value[24].setIcon(new ImageIcon("icon/circle.png"));
					 dd = "18일";
					 ++clickcnt;
					 if(clickcnt % 2 == 0) {
							date_value[24].setIcon(null);
							dd="";
						}
			}
		});
		date_value[25].addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
					date_value[25].setIcon(new ImageIcon("icon/circle.png"));
					 dd = "19일";
					 ++clickcnt;
					 if(clickcnt % 2 == 0) {
							date_value[25].setIcon(null);
							dd="";
						}
			}
		});
		date_value[26].addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
					date_value[26].setIcon(new ImageIcon("icon/circle.png"));
					 dd = "20일";
					 ++clickcnt;
					 if(clickcnt % 2 == 0) {
							date_value[26].setIcon(null);
							dd="";
						}
			}
		});
		date_value[27].addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
					date_value[27].setIcon(new ImageIcon("icon/circle.png"));
					 dd = "21일";
					 ++clickcnt;
					 if(clickcnt % 2 == 0) {
							date_value[27].setIcon(null);
							dd="";
						}
			}
		});date_value[28].addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
					date_value[28].setIcon(new ImageIcon("icon/circle.png"));
					 dd = "22일";
					 ++clickcnt;
					 if(clickcnt % 2 == 0) {
							date_value[28].setIcon(null);
							dd="";
						}
			}
		});
		date_value[29].addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
					date_value[29].setIcon(new ImageIcon("icon/circle.png"));
					dd = "23일";
					++clickcnt;
					 if(clickcnt % 2 == 0) {
							date_value[29].setIcon(null);
							dd="";
						}
			}
		});
		date_value[30].addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
					date_value[30].setIcon(new ImageIcon("icon/circle.png"));
					dd = "24일";
					++clickcnt;
					 if(clickcnt % 2 == 0) {
							date_value[30].setIcon(null);
							dd="";
						}
			}
		});
		date_value[31].addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
					date_value[31].setIcon(new ImageIcon("icon/circle.png"));
					 dd = "25일";
					 ++clickcnt;
					 if(clickcnt % 2 == 0) {
							date_value[31].setIcon(null);
							dd="";
						}
			}
		});
		date_value[32].addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
					date_value[32].setIcon(new ImageIcon("icon/circle.png"));
					dd = "26일";
					++clickcnt;
					 if(clickcnt % 2 == 0) {
							date_value[32].setIcon(null);
							dd="";
						}
			}
		});
		date_value[33].addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
					date_value[33].setIcon(new ImageIcon("icon/circle.png"));
					 dd = "27일";
					 ++clickcnt;
					 if(clickcnt % 2 == 0) {
							date_value[33].setIcon(null);
							dd="";
						}
			}
		});
		date_value[34].addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
					date_value[34].setIcon(new ImageIcon("icon/circle.png"));
					dd = "28일";
					++clickcnt;
					 if(clickcnt % 2 == 0) {
							date_value[34].setIcon(null);
							dd="";
						}
			}
		});
		date_value[35].addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
					date_value[35].setIcon(new ImageIcon("icon/circle.png"));
					dd = "29일";
					++clickcnt;
					 if(clickcnt % 2 == 0) {
							date_value[35].setIcon(null);
							dd="";
						}
			}
		});
		date_value[36].addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
					date_value[36].setIcon(new ImageIcon("icon/circle.png"));
					dd = "30일";
					++clickcnt;
					 if(clickcnt % 2 == 0) {
							date_value[36].setIcon(null);
							dd="";
						}
			}
		});
		
		date_value[37].addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
					date_value[36].setIcon(new ImageIcon("icon/circle.png"));
					dd = "31일";
					++clickcnt;
					 if(clickcnt % 2 == 0) {
							date_value[37].setIcon(null);
							dd="";
						}
			}
		});
		
		calendar.setButton(date_value);
		calendar.calSet();
		
		this.add(pndate, "Center");
		this.setVisible(true);
		
		mf.add(this);
	}
	
	// 날짜 선택 정보 무비 파일에 저장   
	// DataOutput/InputStream 사용하니깐 계속 EOFException 오류나서 BufferedWirter/Reader로 변경
	// 콤마는 split 사용하기 위해 구분자 입력
	public void fileSave(String str) {
		try(BufferedWriter bw = new BufferedWriter(new FileWriter("movie.txt", true))){
			bw.write(str + ","); 				
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// <, > 아이콘 클릭 시 이전달, 다음달 달력으로 이동
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
