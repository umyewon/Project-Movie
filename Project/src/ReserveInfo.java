
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class ReserveInfo extends JPanel {  // 비회원 예매내역 조회, 예매번호 입력 받음.

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

		btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// 텍스트 상자로 다시 포커스 가져가기
				text.requestFocus();

				// ***예매조회 정보 불러오는 코드 작성

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
