import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class WaitingC extends JPanel{	//조회
	private MainFrame mf;
	private JPanel WaitingC;
	
	public WaitingC(MainFrame mf) {
		this.mf = mf;
		this.WaitingC = this;
		
		// 패널
		WaitingC = new JPanel();
		setLayout(null);
		setBackground(Color.white);	

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
		// 회원 - 조회 로그인 페이지로 이동
		member.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new LoginC(mf);		// 버튼 클릭 시 클래스 전환
				setVisible(false);	// 기존 창 보이지 않게
			}
		});
				
		
		// 비회원 - 조회 페이지로 이동
		Nmem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//new Waiting();		// 버튼 클릭 시 클래스 전환
				setVisible(false);	// 기존 창 보이지 않게
			}
		});
		
			
		add(member);
		add(Nmem);
		add(back);
		
		mf.add(this);
	}
}
