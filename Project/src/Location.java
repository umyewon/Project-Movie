
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
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Location extends JPanel {
	private MainFrame mf;
	private JPanel pnlocation;
	JButton previous; // 이전으로 버튼 (메인화면)
	JButton next; // 다음으로 버튼 (영화 선택)
	JTextField input;
	JButton search;
	String ll;

	public Location(MainFrame mf) {
		this.mf = mf;
		this.pnlocation = this;

		pnlocation = new JPanel();
		pnlocation.setLayout(null);
		pnlocation.setBackground(Color.white);

		Font font = new Font("HY견고딕", Font.PLAIN, 24);
		Font fontip = new Font("맑은고딕", Font.PLAIN, 20);
		Font fontth = new Font("맑은고딕", Font.BOLD, 20);
		Font fontbtn = new Font("맑은고딕", Font.BOLD, 17);

		// 타이틀
		JLabel title = new JLabel("지  점  선  택");
		title.setFont(font);
		title.setBounds(320, 30, 150, 30);
		pnlocation.add(title);

		// 사용자 입력 받기
		input = new JTextField(30);
		input.setBounds(160, 90, 410, 55);
		input.setFont(fontip);
		input.setForeground(new Color(33, 150, 83));

		Icon btn1 = new ImageIcon("icon/search.png");
		search = new JButton(btn1);
		search.setBounds(565, 90, 50, 50);
		search.setBorderPainted(false);
		search.setFocusPainted(false);
		search.setContentAreaFilled(false);

		this.add(input);
		this.add(search);

		// 영화 지점
		JButton th1 = new JButton("논  현");
		th1.setFont(fontth);
		th1.setBounds(110, 190, 100, 50);
		th1.setForeground(new Color(33, 150, 83));
		th1.setBackground(new Color(234, 234, 234));
		th1.setBorderPainted(false);
		th1.setFocusPainted(false);
		JButton th2 = new JButton("도  곡");
		th2.setFont(fontth);
		th2.setBounds(260, 190, 100, 50);
		th2.setForeground(new Color(33, 150, 83));
		th2.setBackground(new Color(234, 234, 234));
		th2.setBorderPainted(false);
		th2.setFocusPainted(false);
		JButton th3 = new JButton("강  남");
		th3.setFont(fontth);
		th3.setBounds(410, 190, 100, 50);
		th3.setForeground(new Color(33, 150, 83));
		th3.setBackground(new Color(234, 234, 234));
		th3.setBorderPainted(false);
		th3.setFocusPainted(false);
		JButton th4 = new JButton("삼  성");
		th4.setFont(fontth);
		th4.setBounds(560, 190, 100, 50);
		th4.setForeground(new Color(33, 150, 83));
		th4.setBackground(new Color(234, 234, 234));
		th4.setBorderPainted(false);
		th4.setFocusPainted(false);
		JButton th5 = new JButton("신  사");
		th5.setFont(fontth);
		th5.setBounds(110, 270, 100, 50);
		th5.setForeground(new Color(33, 150, 83));
		th5.setBackground(new Color(234, 234, 234));
		th5.setBorderPainted(false);
		th5.setFocusPainted(false);
		JButton th6 = new JButton("압구정");
		th6.setFont(fontth);
		th6.setBounds(260, 270, 100, 50);
		th6.setForeground(new Color(33, 150, 83));
		th6.setBackground(new Color(234, 234, 234));
		th6.setBorderPainted(false);
		th6.setFocusPainted(false);
		JButton th7 = new JButton("역  삼");
		th7.setFont(fontth);
		th7.setBounds(410, 270, 100, 50);
		th7.setForeground(new Color(33, 150, 83));
		th7.setBackground(new Color(234, 234, 234));
		th7.setBorderPainted(false);
		th7.setFocusPainted(false);
		JButton th8 = new JButton("청  담");
		th8.setFont(fontth);
		th8.setBounds(560, 270, 100, 50);
		th8.setForeground(new Color(33, 150, 83));
		th8.setBackground(new Color(234, 234, 234));
		th8.setBorderPainted(false);
		th8.setFocusPainted(false);

		this.add(th1);
		this.add(th2);
		this.add(th3);
		this.add(th4);
		this.add(th5);
		this.add(th6);
		this.add(th7);
		this.add(th8);

		
		// **** 버튼 클릭 이벤트 처리 ****
		// 1. 검색 버튼 클릭 : 사용자가 검색한 지점이 표시됨
		// 존재하지 않는 지점 선택 시 다시 입력
		search.addMouseListener(new MouseAdapter() {
			String[] str = { "논현", "도곡", "강남", "삼성", "신사", "압구정", "역삼", "청담" };

			@Override
			public void mousePressed(MouseEvent e) {

				for (int i = 0; i < str.length; i++) {

					if (input.getText().contains(str[0])) {
						th1.setForeground(new Color(246, 246, 246));
						th1.setBackground(new Color(33, 150, 83).darker());
						System.out.println(str[0] + " 점");
					} else if (input.getText().contains(str[1])) {
						th2.setForeground(new Color(246, 246, 246));
						th2.setBackground(new Color(33, 150, 83).darker());
						System.out.println(str[1] + " 점");
						ll = str[1];
					} else if (input.getText().contains(str[2])) {
						th3.setForeground(new Color(246, 246, 246));
						th3.setBackground(new Color(33, 150, 83).darker());
						System.out.println(str[2] + " 점");
						ll = str[2];
					} else if (input.getText().contains(str[3])) {
						th4.setForeground(new Color(246, 246, 246));
						th4.setBackground(new Color(33, 150, 83).darker());
						System.out.println(str[3] + " 점");
						ll = str[3];
					} else if (input.getText().contains(str[4])) {
						th5.setForeground(new Color(246, 246, 246));
						th5.setBackground(new Color(33, 150, 83).darker());
						System.out.println(str[4] + " 점");
						ll = str[4];
					} else if (input.getText().contains(str[5])) {
						th6.setForeground(new Color(246, 246, 246));
						th6.setBackground(new Color(33, 150, 83).darker());
						System.out.println(str[5] + " 점");
						ll = str[5];
					} else if (input.getText().contains(str[6])) {
						th7.setForeground(new Color(246, 246, 246));
						th7.setBackground(new Color(33, 150, 83).darker());
						System.out.println(str[6] + " 점");
						ll = str[6];
					} else if (input.getText().contains(str[7])) {
						th8.setForeground(new Color(246, 246, 246));
						th8.setBackground(new Color(33, 150, 83).darker());
						System.out.println(str[7] + " 점");
						ll = str[7];
					} else {
						input.setText("존재하지 않는 지점입니다 다시 입력하세요.");
					}
				}
			}

		});

		
		// 이전, 다음 버튼
		JButton previous = new JButton("이  전");
		previous.setFont(fontbtn);
		previous.setBounds(20, 380, 90, 40);
		previous.setForeground(new Color( 234, 234, 234 ));
		previous.setBackground(new Color( 33, 150, 83));
		previous.setBorderPainted(false);
		previous.setFocusPainted(false);
		this.add(previous);

		
		JButton next = new JButton("다 음");
		next.setFont(fontbtn);
		next.setBounds(670, 380, 90, 40);
		next.setForeground(new Color(234, 234, 234 ));
		next.setBackground(new Color( 33, 150, 83));
		next.setBorderPainted(false);
		next.setFocusPainted(false);
		this.add(next);
		
		previous.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e){
				previous.setForeground(new Color(33, 150, 83));
				previous.setBackground(new Color(246, 246, 246 ));
				// 날짜선택으로
			}
		});
		
		next.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e){
				next.setForeground(new Color(33, 150, 83));
				next.setBackground(new Color(246, 246, 246 ));
				// 영화선택으로
			}
		});



		mf.add(this);
	}
	
	// 좌석 정보 유저 파일에 저장   
		public void fileSave() {
			try(DataOutputStream dout = new DataOutputStream(new FileOutputStream("user.txt"))){
				dout.writeUTF(ll);
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}


}
