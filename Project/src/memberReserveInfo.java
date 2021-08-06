

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;



public class memberReserveInfo extends JPanel /*implements Serializable*/ {
	

	private MainFrame mf;
	private JPanel memberReserveInfo;
	private JLabel infoTitle;

	// 입력된 값
	private JTextField idT;
	private JTextField pwT;
	private JTextField nameT;
	private JTextField telT;
	// UserInfo
	private List<UserInfo> uif = new ArrayList<>();
	private List<MovieInfo> mif = new ArrayList<>();
	
	private JPanel reList; // 정보 출력될 패널
	/*
	private String userID;
	private String userPW;
	private String userName;
	private String userPhone;
	private String mDate;
	private String mTitle;
	private String mTime;
	private String mSeat;
	private String mNumber;
	*/
	
	public memberReserveInfo(MainFrame mf) {
		this.mf = mf;
		this.memberReserveInfo= this;
		
		this.setLayout(null);
		this.setBackground(Color.white);
		
		JLabel label = new JLabel();
		label.setText("회원 예매 내역");
		label.setFont(label.getFont().deriveFont(30.0f));  // 글씨크기
		label.setBounds(290, 8, 400, 50);
		this.add(label);
		
		JButton backbt = new JButton("이  전");
		backbt.setBounds(60, 10, 80, 40);
		backbt.setBackground(Color.white);
		backbt.setBorder(BorderFactory.createLineBorder(new Color(33, 150, 83)));
		this.add(backbt);
		// 이전버튼 클릭시 메인 페이지
		backbt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new Main(mf);
				setVisible(false);
			}
		});
			
		JButton checkbt = new JButton("조 회");
		checkbt.setBounds(350, 380, 90, 40);
		checkbt.setFont(checkbt.getFont().deriveFont(15.0f));
		checkbt.setForeground(Color.white);
		checkbt.setBackground(new Color(33, 150, 83));
		checkbt.setBorder(BorderFactory.createLineBorder(new Color(33, 150, 83)));
		this.add(checkbt);
		
		
		JLabel list1 = new JLabel("순번", JLabel.CENTER);
		JLabel list2 = new JLabel("날짜", JLabel.CENTER);
		JLabel list3 = new JLabel("영화",JLabel.CENTER);
		JLabel list4 = new JLabel("시간", JLabel.CENTER);
		JLabel list5 = new JLabel("좌석", JLabel.CENTER);
		JLabel list6 = new JLabel("지점", JLabel.CENTER);
		JLabel list7 = new JLabel("예약번호", JLabel.CENTER);
		
		
		list1.setBounds(30, 70, 100, 20); // 순번
		list2.setBounds(100, 70, 100, 20); // 날짜
		list3.setBounds(240, 70, 100, 20); // 영화
		list4.setBounds(380, 70, 100, 20); // 시간
		list5.setBounds(480, 70, 100, 20); // 좌석
		list6.setBounds(590, 70, 100, 20); // 지점
		list7.setBounds(640, 70, 100, 20); // 예약번호
		
		this.add(list1);
		this.add(list2);
		this.add(list3);
		this.add(list4);
		this.add(list5);
		this.add(list6);
		this.add(list7);
		
		// 조회 버튼 클릭시 조회된 정보 출력
		checkbt.addActionListener(new Myevent());
		reList = new JPanel();
		reList.setBounds(0, 100, 800, 260);
		reList.setLayout(null);
		this.add(reList);
		
		// 메인프레임에 추가
		mf.add(this);
	}



	class Myevent implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent event) {
			uinfo(); // 회원정보
			minfo(); // 예매정보
			
			int count = 1;
			for(int i = 0; i < uif.size(); i++) {
			   // 순번
			   JLabel relabel1 = new JLabel(count++ +"", JLabel.CENTER);
			   relabel1.setBounds(30, (20 + (i*30)), 100, 20);
			   reList.add(relabel1);
			   // 날짜
			   JLabel relabel2 = new JLabel(mif.get(i).getmDate1(), JLabel.CENTER);
			   relabel2.setBounds(100, (20 + (i*30)), 100, 20);
			   reList.add(relabel2);
			   // 제목
			   JLabel relabel3 = new JLabel(mif.get(i).getmTitle(), JLabel.CENTER);
			   relabel3.setBounds(240, (20 + (i*30)), 200, 20);
			   reList.add(relabel3);
			   // 시간
			   JLabel relabel4 = new JLabel(mif.get(i).getmTime(), JLabel.CENTER);
			   relabel4.setBounds(380, (20 + (i*30)), 100, 20);
			   reList.add(relabel4);
			   // 좌석
			   JLabel relabel5 = new JLabel(mif.get(i).getmSeat(), JLabel.CENTER);
			   relabel5.setBounds(480, (20 + (i*30)), 100, 20);
			   reList.add(relabel5);
			   // 지점
			   JLabel relabel6 = new JLabel(mif.get(i).getmLocation(), JLabel.CENTER);
			   relabel6.setBounds(590, (20 + (i*30)), 100, 20);
			   reList.add(relabel6);
			   // 예약번호
			   JLabel relabel7 = new JLabel("12345", JLabel.CENTER);
			   relabel7.setBounds(640, (20 + (i*30)), 100, 20);
			   reList.add(relabel7);
			}	
		}
	}
	
	
	// 유저 파일읽어오기
	public void uinfo() {
		
		try(DataInputStream dis = new DataInputStream(new FileInputStream("user.txt"))){
			
			while(true) {
				String userID = dis.readUTF();
				String userPW = dis.readUTF();
				String userName = dis.readUTF();
				String userPhone = dis.readUTF();
				//String renumber = dis.readUTF();  //예약번호 => 나중에 예약같은지 확인
				
				uif.add(new UserInfo(userID, userPW, userName, userPhone)); // 여기 다읽어와서 eofec출력
			}
				
				
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (EOFException e) {
			JOptionPane.showMessageDialog(null, "조회 완료되었습니다.", "", JOptionPane.INFORMATION_MESSAGE);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public void minfo() {
		
		try(DataInputStream dis = new DataInputStream(new FileInputStream("movie.txt"))){
			
			while(true) {
				
				String mDate = dis.readUTF(); // 날짜 하나로 합침
				String mLocation = dis.readUTF();
				String mTitle = dis.readUTF();
				String mTime = dis.readUTF();
				String mSeat = dis.readUTF();
				//String mNumber = dis.readUTF(); //예약번호
				
				mif.add(new MovieInfo(mDate, mLocation, mTitle, mTime, mSeat));
				
			}
		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (EOFException e) {
			//JOptionPane.showMessageDialog(null, "조회 완료되었습니다.", "", JOptionPane.INFORMATION_MESSAGE);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

  
