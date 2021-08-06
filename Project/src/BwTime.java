

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
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class BwTime extends JPanel /*implements Serializable*/ {
	
	private MainFrame mf;
	private JPanel BwTime;
	
	public BwTime(MainFrame mf) {  
		this.mf = mf;
		this.BwTime = this;
		
		this.setBackground(Color.white);
		this.setLayout(null);
		
		JLabel label = new JLabel();
		label.setText("상영 시간");
		label.setFont(label.getFont().deriveFont(30.0f));  // 글씨크기
		label.setBounds(320, 8, 200, 50);
		this.add(label);
		
		// 이전버튼
		JButton backbt = new JButton("이  전");
		backbt.setBounds(60, 10, 80, 40);
		backbt.setBackground(Color.white);
		backbt.setBorder(BorderFactory.createLineBorder(new Color(33, 150, 83)));
		this.add(backbt);
		// 이전버튼 클릭시 상영영화 페이지
		backbt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new PlayingMovie(mf);
				setVisible(false);
			}
		});
		
		// 영화이미지
		Image i1 = new ImageIcon("movie/blackwidow.png").getImage().getScaledInstance(200, 250, Image.SCALE_SMOOTH);
		JLabel mImage1 = new JLabel(new ImageIcon(i1));
		mImage1.setBounds(60, 90, 200, 250);
		this.add(mImage1);
		// 제목
		JLabel mTitle1 = new JLabel("블랙 위도우 (134분)", JLabel.CENTER);
		mTitle1.setFont(mTitle1.getFont().deriveFont(15.0f)); 
		mTitle1.setBounds(60, 370, 200, 20);
		this.add(mTitle1);
		
		// 라디오버튼
		JRadioButton rButton1 = new JRadioButton();
		rButton1.setBackground(Color.white);
		JRadioButton rButton2 = new JRadioButton();
		rButton2.setBackground(Color.white);
		JRadioButton rButton3 = new JRadioButton();
		rButton3.setBackground(Color.white);
		JRadioButton rButton4 = new JRadioButton();
		rButton4.setBackground(Color.white);
		JRadioButton rButton5 = new JRadioButton();
		rButton5.setBackground(Color.white);
		JRadioButton rButton6 = new JRadioButton();
		rButton6.setBackground(Color.white);
		JRadioButton rButton7 = new JRadioButton();
		rButton7.setBackground(Color.white);
		JRadioButton rButton8 = new JRadioButton();
		rButton8.setBackground(Color.white);
		JRadioButton rButton9 = new JRadioButton();
		rButton9.setBackground(Color.white);
		
		// 시간
		JLabel time1 = new JLabel("06:00", JLabel.CENTER);
		time1.setOpaque(true);
		time1.setBackground(new Color(33, 150, 83));
		time1.setBorder(BorderFactory.createLineBorder(new Color(33, 150, 83)));
		time1.setFont(time1.getFont().deriveFont(15.0f));
		time1.setForeground(Color.white);
		JLabel time2 = new JLabel("08:30", JLabel.CENTER);
		time2.setOpaque(true);
		time2.setBackground(new Color(33, 150, 83));
		time2.setBorder(BorderFactory.createLineBorder(new Color(33, 150, 83)));
		time2.setFont(time2.getFont().deriveFont(15.0f));
		time2.setForeground(Color.white);
		JLabel time3 = new JLabel("11:00", JLabel.CENTER);
		time3.setOpaque(true);
		time3.setBackground(new Color(33, 150, 83));
		time3.setBorder(BorderFactory.createLineBorder(new Color(33, 150, 83)));
		time3.setFont(time3.getFont().deriveFont(15.0f));
		time3.setForeground(Color.white);
		JLabel time4 = new JLabel("13:30", JLabel.CENTER);
		time4.setOpaque(true);
		time4.setBackground(new Color(33, 150, 83));
		time4.setBorder(BorderFactory.createLineBorder(new Color(33, 150, 83)));
		time4.setFont(time4.getFont().deriveFont(15.0f));
		time4.setForeground(Color.white);
		JLabel time5 = new JLabel("16:00", JLabel.CENTER);
		time5.setOpaque(true);
		time5.setBackground(new Color(33, 150, 83));
		time5.setBorder(BorderFactory.createLineBorder(new Color(33, 150, 83)));
		time5.setFont(time5.getFont().deriveFont(15.0f));
		time5.setForeground(Color.white);
		JLabel time6 = new JLabel("18:30", JLabel.CENTER);
		time6.setOpaque(true);
		time6.setBackground(new Color(33, 150, 83));
		time6.setBorder(BorderFactory.createLineBorder(new Color(33, 150, 83)));
		time6.setFont(time6.getFont().deriveFont(15.0f));
		time6.setForeground(Color.white);
		JLabel time7 = new JLabel("21:00", JLabel.CENTER);
		time7.setOpaque(true);
		time7.setBackground(new Color(33, 150, 83));
		time7.setBorder(BorderFactory.createLineBorder(new Color(33, 150, 83)));
		time7.setFont(time7.getFont().deriveFont(15.0f));
		time7.setForeground(Color.white);
		JLabel time8 = new JLabel("23:30", JLabel.CENTER);
		time8.setOpaque(true);
		time8.setBackground(new Color(33, 150, 83));
		time8.setBorder(BorderFactory.createLineBorder(new Color(33, 150, 83)));
		time8.setFont(time8.getFont().deriveFont(15.0f));
		time8.setForeground(Color.white);
		JLabel time9 = new JLabel("26:00", JLabel.CENTER);
		time9.setOpaque(true);
		time9.setBackground(new Color(33, 150, 83));
		time9.setBorder(BorderFactory.createLineBorder(new Color(33, 150, 83)));
		time9.setFont(time9.getFont().deriveFont(15.0f));
		time9.setForeground(Color.white);	
		
		// 위치 및 크기
		rButton1.setBounds(300, 100, 25, 25);		
		time1.setBounds(330, 90, 80, 50);
		rButton2.setBounds(450, 100, 25, 25);		
		time2.setBounds(480, 90, 80, 50);
		rButton3.setBounds(600, 100, 25, 25);		
		time3.setBounds(630, 90, 80, 50);
		rButton4.setBounds(300, 170, 25, 25);		
		time4.setBounds(330, 160, 80, 50);
		rButton5.setBounds(450, 170, 25, 25);		
		time5.setBounds(480, 160, 80, 50);
		rButton6.setBounds(600, 170, 25, 25);		
		time6.setBounds(630, 160, 80, 50);
		rButton7.setBounds(300, 240, 25, 25);		
		time7.setBounds(330, 230, 80, 50);
		rButton8.setBounds(450, 240, 25, 25);		
		time8.setBounds(480, 230, 80, 50);
		rButton9.setBounds(600, 240, 25, 25);		
		time9.setBounds(630, 230, 80, 50);	
		// 라디오버튼 그룹화
		ButtonGroup rbg = new ButtonGroup();
		rbg.add(rButton1);
		rbg.add(rButton2);
		rbg.add(rButton3);
		rbg.add(rButton4);
		rbg.add(rButton5);
		rbg.add(rButton6);
		rbg.add(rButton7);
		rbg.add(rButton8);
		rbg.add(rButton9);
		// 패널에 올리기
		this.add(time1);
		this.add(time2);
		this.add(time3);
		this.add(time4);
		this.add(time5);
		this.add(time6);
		this.add(time7);
		this.add(time8);
		this.add(time9);		
		this.add(rButton1);
		this.add(rButton2);
		this.add(rButton3);
		this.add(rButton4);
		this.add(rButton5);
		this.add(rButton6);
		this.add(rButton7);
		this.add(rButton8);
		this.add(rButton9);
		
		// 확인 문구
		JLabel msg = new JLabel("시간 선택해 주십시오.", JLabel.CENTER);
		msg.setBounds(370, 300, 300, 50);
		msg.setFont(msg.getFont().deriveFont(15.0f));
		this.add(msg);
		// 확인 버튼
		JButton checkbt = new JButton("확 인");
		checkbt.setBounds(470, 360, 90, 40);
		checkbt.setFont(checkbt.getFont().deriveFont(15.0f));
		checkbt.setForeground(Color.white);
		checkbt.setBackground(new Color(33, 150, 83));
		checkbt.setBorder(BorderFactory.createLineBorder(new Color(33, 150, 83)));
		this.add(checkbt);
		// 확인버튼 클릭시 좌석선택 페이지
		checkbt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 확인버튼 클릭시 시간 정보 파일에 저장
				if(msg.getText().contains(time1.getText())) {
					fileSave(time1.getText());
				} else if(msg.getText().contains(time2.getText())) {
					fileSave(time2.getText());
				} else if(msg.getText().contains(time3.getText())) {
					fileSave(time3.getText());
				} else if(msg.getText().contains(time4.getText())) {
					fileSave(time4.getText());
				} else if(msg.getText().contains(time5.getText())) {
					fileSave(time5.getText());
				} else if(msg.getText().contains(time6.getText())) {
					fileSave(time6.getText());
				} else if(msg.getText().contains(time7.getText())) {
					fileSave(time7.getText());
				} else if(msg.getText().contains(time8.getText())) {
					fileSave(time8.getText());
				} else if(msg.getText().contains(time9.getText())) {
					fileSave(time9.getText());
				}
				// 좌석 선택 화면으로
				new Seat(mf);				
				setVisible(false);
			}
		});
		
		// 시간 선택시 문구 출력 
		rButton1.addMouseListener(new MouseAdapter() {
			@Override  
			public void mouseClicked(MouseEvent e) { 
				msg.setText(mTitle1.getText()+ " " + time1.getText() + " 예매 맞습니까?");
			}
		});
		rButton2.addMouseListener(new MouseAdapter() {
			@Override  
			public void mouseClicked(MouseEvent e) { 
				msg.setText(mTitle1.getText()+ " " + time2.getText() + " 예매 맞습니까?");
			}
		});
		rButton3.addMouseListener(new MouseAdapter() {
			@Override  
			public void mouseClicked(MouseEvent e) {  
				msg.setText(mTitle1.getText()+ " " + time3.getText() + " 예매 맞습니까?");
			}
		});
		rButton4.addMouseListener(new MouseAdapter() {
			@Override  
			public void mouseClicked(MouseEvent e) {  
				msg.setText(mTitle1.getText()+ " " + time4.getText() + " 예매 맞습니까?");
			}
		});
		rButton5.addMouseListener(new MouseAdapter() {
			@Override  
			public void mouseClicked(MouseEvent e) {
				msg.setText(mTitle1.getText()+ " " + time5.getText() + " 예매 맞습니까?");
			}
		});
		rButton6.addMouseListener(new MouseAdapter() {
			@Override  
			public void mouseClicked(MouseEvent e) {  
				msg.setText(mTitle1.getText()+ " " + time6.getText() + " 예매 맞습니까?");
			}
		});
		rButton7.addMouseListener(new MouseAdapter() {
			@Override  
			public void mouseClicked(MouseEvent e) { 
				msg.setText(mTitle1.getText()+ " " + time7.getText() + " 예매 맞습니까?");
			}
		});
		rButton8.addMouseListener(new MouseAdapter() {
			@Override  
			public void mouseClicked(MouseEvent e) {
				msg.setText(mTitle1.getText()+ " " + time8.getText() + " 예매 맞습니까?");
			}
		});
		rButton9.addMouseListener(new MouseAdapter() {
			@Override  
			public void mouseClicked(MouseEvent e) { 
				msg.setText(mTitle1.getText()+ " " + time9.getText() + " 예매 맞습니까?");
			}
		});
		
		// 메인프레임에 패널 추가		
		mf.add(this);
	}	
	
	public void fileSave(String str) {
		// 영화 시간 내역 파일에 저장
		try(DataOutputStream dout = new DataOutputStream(new FileOutputStream("user.txt"))){
			
			dout.writeUTF(str); // 영화시간
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
