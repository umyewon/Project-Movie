import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class ReserveInfo extends JPanel {

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


		// 메인화면으로 돌아가기 버튼 생성
		JButton btn1 = new JButton("메인 화면");
		btn1.setFont(font);
		btn1.setBounds(680, 32, 100, 30);
		btn1.setForeground(Color.white);
		btn1.setBackground(new Color(33, 150, 83));

		this.add(btn1);
		btn1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new MainFrame();   
				setVisible(false); 

			}

		});

		// 메인프레임에 패널 추가
		mf.add(this);

	}

}
