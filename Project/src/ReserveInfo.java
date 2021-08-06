
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ReserveInfo extends JPanel { // 비회원 예매내역 조회, 예매번호 입력 받음.

	private MainFrame mf;
	private JPanel ReserveInfo;
	

	public ReserveInfo(MainFrame mf) {
		this.mf = mf;
		this.ReserveInfo = this;
			
		this.setBackground(Color.white);
		this.setLayout(null);
				
		Font font = new Font("맑은 고딕", Font.BOLD, 15);
		
		// 라벨 패널에 부착
		JLabel lb = new JLabel("예매 번호 입력 : ");
		lb.setBounds(15, 18, 200, 50);
		lb.setFont(font);
		this.add(lb);
		// 텍스트 필드 생성 후 패널에 부착
		JTextField text = new JTextField(15);
		text.setBounds(130, 28, 150, 30);
		this.add(text);

		// 버튼 생성
		JButton btn = new JButton("확인");
		btn.setFont(font);
		btn.setBounds(280, 28, 80, 30);
		btn.setForeground(Color.white);
		btn.setBackground(new Color(33, 150, 83));
		
		this.add(btn);
		
		JLabel re = new JLabel(" "); // 추후 예매번호 틀릴 시 내용 변경 됨.
		re.setBounds(380, 15, 300, 50);
		re.setFont(font);
		re.setForeground(Color.GREEN);
		this.add(re);

		
		// 버튼 클릭 시 예매 정보 불러옴.
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 텍스트 상자로 다시 포커스 가져가기
				text.requestFocus();

		
				// if문을 사용하여 true일 시 예매정보 내역 불러오기, 조건문에 text와 예매번호(타클래스에서 이미 생성 된 5자리 숫자)매칭 여부 확인
				if (text.equals(text/*추후 movie클래스의 예매번호 변수로 수정할 것.*/)) {
					try(DataInputStream dis = new DataInputStream(new FileInputStream("movie.txt"))){				
						while(true) {
							String nonuserNumber = dis.readUTF();  //비회원 랜덤5자리 예매번호 변수 nonuserNumber로 우선 가설정. 추후 확정 변수로 수정.
							String mDate = dis.readUTF();
							String mLocation = dis.readUTF();
							String mTitle = dis.readUTF();
							String mTime = dis.readUTF();
							String mSeat = dis.readUTF();
							String mNumber = dis.readUTF();				
						}
					} catch (IOException e1) {
						e1.printStackTrace();
					}			
				// 제대로 입력 시 번호 다시 확인해달라는 라벨 화면에서 사라짐.						
			    re.setText(" "); 
			    
			   
				} else {
					re.setText("번호를 다시 확인하여 주십시오."); // false일 시 번호를 다시 확인해달라는 라벨 띄움	
				}
			}
		});

		// 이전버튼
		JButton backBt = new JButton("이  전");
		backBt.setBounds(350, 380, 90, 40);
		backBt.setBackground(Color.white);
		backBt.setBorder(BorderFactory.createLineBorder(new Color(33, 150, 83)));
		this.add(backBt);
		// 이전버튼 클릭시 메인화면 페이지??
		backBt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 메인화면으로
				// new Main(mf);
				new MainFrame();
				setVisible(false);
			}
		});
		

		// 조회정보 올라갈 패널
		JPanel jj = new JPanel();
		this.add(jj);
		// jj.setSize(50, 50);
		jj.setBounds(0, 100, 800, 260);

		JLabel info1 = new JLabel("순번", JLabel.CENTER);
		info1.setBounds(50, 70, 50, 20);
		JLabel info2 = new JLabel("예약번호", JLabel.CENTER);
		info2.setBounds(130, 70, 100, 20);
		JLabel info3 = new JLabel("영화", JLabel.CENTER);
		info3.setBounds(280, 70, 100, 20);
		JLabel info4 = new JLabel("시간", JLabel.CENTER);
		info4.setBounds(460, 70, 100, 20);
		JLabel info5 = new JLabel("좌석", JLabel.CENTER);
		info5.setBounds(630, 70, 100, 20);

		this.add(info1);
		this.add(info2);
		this.add(info3);
		this.add(info4);
		this.add(info5);
		mf.add(this);
		
		

		// 메인프레임에 패널 추가
		mf.add(this);
		
	
		}
	}

