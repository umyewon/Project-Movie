
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Main extends JPanel{	
	private MainFrame mf;
	private JPanel Main, imgPanel;
	private JButton reservation, check;

	
	public Main(MainFrame mf) {
		this.mf = mf;
		this.Main = this;
		
				
		// 배경 패널
		Main = new JPanel();
		setLayout(null);
		setBackground(Color.white);		

		
		// 버튼 생성 - 예매, 조회 
		Font font = new Font("맑은 고딕", Font.BOLD, 40);
				
		reservation = new JButton("예매");
		reservation.setFont(font);
		reservation.setForeground(Color.white);
		reservation.setBackground(new Color(33, 150, 83));
		reservation.setBounds(0, 0, 380, 200);

		
		check = new JButton("조회");
		check.setFont(font);
		check.setForeground(Color.white);
		check.setBackground(new Color(33, 150, 83));
		check.setBounds(385, 0, 410, 200);
		
		
		// 이미지 라벨
		imgPanel = new JPanel();
		imgPanel.setBackground(Color.white);
		imgPanel.setBounds(45, 180, 700, 260 );
		Image img = new ImageIcon("movie.png").getImage().getScaledInstance(300, 250, 0);
		JLabel imgLabel = new JLabel(new ImageIcon(img));
		imgPanel.add(imgLabel);
		
		
		// 버튼 클릭 액션 - 회원, 비회원 선택 페이지로 이동
		// 예매 
		reservation.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new WaitingR(mf);
				setVisible(false);				
			}
		});
		
		
		// 조회
		check.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new WaitingC(mf);		// 버튼 클릭 시 클래스 전환
				setVisible(false);	// 기존 창 보이지 않게
			}
		});
		
	
		add(reservation);
		add(check);
		add(imgPanel);		
	
		
		mf.add(this);
	}

}


