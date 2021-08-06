

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class PlayingMovie extends JPanel /*implements Serializable*/ {
	
	private MainFrame mf;
	private JPanel PlayingMovie;
	
	public PlayingMovie(MainFrame mf) {
		this.mf = mf;
		this.PlayingMovie = this;
		
		this.setLayout(null);
		this.setBackground(Color.white);
		
		JLabel label = new JLabel();
		label.setText("상영 영화");
		label.setFont(label.getFont().deriveFont(30.0f));  // 글씨크기
		label.setBounds(320, 8, 200, 50);
		this.add(label);
		
		// 이전버튼
		JButton backBt = new JButton("이  전");
		backBt.setBounds(60, 10, 80, 40);
		backBt.setBackground(Color.white);
		backBt.setBorder(BorderFactory.createLineBorder(new Color(33, 150, 83)));
		this.add(backBt);
		// 이전버튼 클릭시 영화관 검색창
		backBt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new Location(mf);
				//new Date(mf); 
				setVisible(false);
			}
		});
		
		// 영화 이미지
		Image i1 = new ImageIcon("movie/blackwidow.png").getImage().getScaledInstance(110, 150, Image.SCALE_SMOOTH);
		Image i2 = new ImageIcon("movie/mogadishu.png").getImage().getScaledInstance(110, 150, Image.SCALE_SMOOTH);
		Image i3 = new ImageIcon("movie/phoenix.png").getImage().getScaledInstance(110, 150, Image.SCALE_SMOOTH);
		Image i4 = new ImageIcon("movie/rangjong.png").getImage().getScaledInstance(110, 150, Image.SCALE_SMOOTH);
		
		JLabel mImage1 = new JLabel(new ImageIcon(i1));
		JLabel mImage2 = new JLabel(new ImageIcon(i2));
		JLabel mImage3 = new JLabel(new ImageIcon(i3));
		JLabel mImage4 = new JLabel(new ImageIcon(i4));
		
		mImage1.setBounds(60, 90, 120, 160);
		mImage2.setBounds(240, 90, 120, 160);
		mImage3.setBounds(420, 90, 120, 160);
		mImage4.setBounds(600, 90, 120, 160);
		
		this.add(mImage1);
		this.add(mImage2);
		this.add(mImage3);
		this.add(mImage4);
		// 블랙위도우
		JLabel mTitle1 = new JLabel("제목 : ", JLabel.CENTER);
		JLabel mDirector1 = new JLabel("감독 : 케이트 쇼트랜드", JLabel.CENTER);
		JLabel mGrade1 = new JLabel("평점 : 9.08", JLabel.CENTER);
		// 모가디슈
		JLabel mTitle2 = new JLabel("제목 : ", JLabel.CENTER);
		JLabel mDirector2 = new JLabel("감독 : 류승완", JLabel.CENTER);
		JLabel mGrade2 = new JLabel("평점 : 9.16", JLabel.CENTER);
		// 피닉스
		JLabel mTitle3 = new JLabel("제목 : ", JLabel.CENTER);
		JLabel mDirector3 = new JLabel("감독 : 크리스티안 펫졸드", JLabel.CENTER);
		JLabel mGrade3 = new JLabel("평점 : 8.43", JLabel.CENTER);
		// 랑종
		JLabel mTitle4 = new JLabel("제목 : ", JLabel.CENTER);
		JLabel mDirector4 = new JLabel("감독 : 반종 피산다나쿤", JLabel.CENTER);
		JLabel mGrade4 = new JLabel("평점 : 6.82", JLabel.CENTER);
		
		// 제목 따로 생성
		JLabel mTitle11 = new JLabel("블랙 위도우 (134분)", JLabel.CENTER);
		JLabel mTitle22 = new JLabel("모가디슈 (121분)", JLabel.CENTER);
		JLabel mTitle33 = new JLabel("피닉스 (98분)", JLabel.CENTER);
		JLabel mTitle44 = new JLabel("랑종 (131분)", JLabel.CENTER);
		mTitle11.setBounds(38, 260, 200, 20);
		mTitle22.setBounds(215, 260, 200, 20);
		mTitle33.setBounds(397, 260, 200, 20);
		mTitle44.setBounds(578, 260, 200, 20);
		this.add(mTitle11);
		this.add(mTitle22);
		this.add(mTitle33);
		this.add(mTitle44);
		
		
		mTitle1.setBounds(40, 260, 50, 20);
		mDirector1.setBounds(16, 300, 200, 20);
		mGrade1.setBounds(16, 340, 200, 20);
		
		mTitle2.setBounds(225, 260, 50, 20);
		mDirector2.setBounds(198, 300, 200, 20);
		mGrade2.setBounds(198, 340, 200, 20);
		
		mTitle3.setBounds(415, 260, 50, 20);
		mDirector3.setBounds(380, 300, 200, 20);
		mGrade3.setBounds(380, 340, 200, 20);
		
		mTitle4.setBounds(600, 260, 50, 20);
		mDirector4.setBounds(560, 300, 200, 20);
		mGrade4.setBounds(560, 340, 200, 20);
		// 패널 올리기
		this.add(mTitle1);
		this.add(mDirector1);
		this.add(mGrade1);
		this.add(mTitle2);
		this.add(mDirector2);
		this.add(mGrade2);
		this.add(mTitle3);
		this.add(mDirector3);
		this.add(mGrade3);
		this.add(mTitle4);
		this.add(mDirector4);
		this.add(mGrade4);
		
		// 예매버튼
		JButton mButton1 = new JButton("영화 예매");
		JButton mButton2 = new JButton("영화 예매");
		JButton mButton3 = new JButton("영화 예매");
		JButton mButton4 = new JButton("영화 예매");
	
		mButton1.setBounds(70, 380, 100, 40);
		mButton2.setBounds(250, 380, 100, 40);
		mButton3.setBounds(430, 380, 100, 40);
		mButton4.setBounds(610, 380, 100, 40);
		// 버튼 배경색
		mButton1.setBackground(new Color(33, 150, 83));
		mButton2.setBackground(new Color(33, 150, 83));
		mButton3.setBackground(new Color(33, 150, 83));
		mButton4.setBackground(new Color(33, 150, 83));
		// 버튼 테두리색
		mButton1.setBorder(BorderFactory.createLineBorder(new Color(33, 150, 83)));
		mButton2.setBorder(BorderFactory.createLineBorder(new Color(33, 150, 83)));
		mButton3.setBorder(BorderFactory.createLineBorder(new Color(33, 150, 83)));
		mButton4.setBorder(BorderFactory.createLineBorder(new Color(33, 150, 83)));
		// 버튼 글자색
		mButton1.setForeground(Color.white);
		mButton2.setForeground(Color.white);
		mButton3.setForeground(Color.white);
		mButton4.setForeground(Color.white);
		// 패널 올리기
		this.add(mButton1);
		this.add(mButton2);
		this.add(mButton3);
		this.add(mButton4);
		
		// 예매버튼 클릭시
		mButton1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				fileSave(mTitle11.getText()); // 버튼 클릭시 영화제목 파일 저장
				new BwTime(mf);
				setVisible(false);
			}
		});
		mButton2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				fileSave(mTitle22.getText());
				new MgTime(mf);
				setVisible(false);
			}
		});
		mButton3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				fileSave(mTitle33.getText());
				new PnTime(mf);
				setVisible(false);
			}
		});
		mButton4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				fileSave(mTitle44.getText());
				new RjTime(mf);
				setVisible(false);
			}
		});
		
		// 메인프레임에 패널 추가
		mf.add(this);
	}
	
	
	public void fileSave(String str) {
		// 영화 예매 내역 파일에 저장
		try(DataOutputStream dout = new DataOutputStream(new FileOutputStream("user.txt"))){
			
			dout.writeUTF(str); // 영화제목
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
