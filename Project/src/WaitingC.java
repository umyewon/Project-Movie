import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Waiting2 extends JFrame{	//조회
	public Waiting2() {
		
		this.setTitle("대기 화면");
		this.setBounds(600, 250, 800, 500);
		this.setResizable(false);
		
		// 아이콘 이미지 변경
		try {
			this.setIconImage(ImageIO.read(new File("Icon2.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// 배경패널
		JPanel back = new JPanel();	
		
		// 버튼 생성- 회원, 비회원
		Font font = new Font("맑은 고딕", Font.BOLD, 40);
		
		JButton member = new JButton();
		member.setText("회원");
		member.setFont(font);
		member.setForeground(Color.white);
		member.setBounds(70, 120, 300, 200);
		member.setBackground(new Color(33, 150, 83));
		
		JButton Nmem = new JButton();
		Nmem.setText("비회원");
		Nmem.setFont(font);
		Nmem.setForeground(Color.white);
		Nmem.setBounds(420, 120, 300, 200);
		Nmem.setBackground(new Color(33, 150, 83));
		
		// 버튼 클릭 액션
		// 회원 - 로그인 페이지로 이동
		member.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new Login();		// 버튼 클릭 시 클래스 전환
				setVisible(false);	// 기존 창 보이지 않게
			}
		});
				
		
		// 비회원 - 예매 페이지로 이동
		Nmem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//new Waiting();		// 버튼 클릭 시 클래스 전환
				setVisible(false);	// 기존 창 보이지 않게
			}
		});
		
			
		this.add(member);
		this.add(Nmem);
		this.add(back);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

}
