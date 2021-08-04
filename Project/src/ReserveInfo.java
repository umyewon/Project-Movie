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

public class ReserveInfo extends JFrame {

	public ReserveInfo() {

		// 프레임 위치와 크기 한 번에 설정 (x, y, width, height)
		this.setBounds(600, 250, 800, 500);

		// 프레임 상단에 이름 설정
		this.setTitle("영화 예매 내역 조회");
		
		// 아이콘 이미지 변경
		try {
			this.setIconImage(ImageIO.read(new File("Icon2.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}

		// 패널 생성
		JPanel panel = new JPanel();
		
		Font font = new Font("맑은 고딕", Font.BOLD, 15);
		
		// 라벨 패널에 부착
		JLabel lb = new JLabel("예매 번호 입력 : ");
		lb.setFont(font);
		panel.add(lb);
		// 텍스트 필드 생성 후 패널에 부착
		JTextField text = new JTextField(15);
		panel.add(text);

		// 버튼 생성
		JButton btn = new JButton("확인");
		btn.setFont(font);
		btn.setForeground(Color.white);
		btn.setBackground(new Color(33, 150, 83));
		
		panel.add(btn);

		btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// 텍스트 상자로 다시 포커스 가져가기
				text.requestFocus();
				
				// ***예매조회 정보 불러오는 코드 작성
				
				

			}
		});

		this.add(panel);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);

	}



}
