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
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ReserveInfo extends JPanel /*implements Serializable*/ {

	private MainFrame mf;
	private JPanel ReserveInfo;
	private JLabel infoTitle;
	JTextField text;
	JLabel re;
	int i;

	// MovieInfo
	private List<MovieInfo> mif = new ArrayList<>();
	
	private JPanel reList; // 정보 출력될 패널
	/*
	 * 	
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

	public ReserveInfo(MainFrame mf) {
		this.mf = mf;
		this.ReserveInfo= this;

		
		this.setLayout(null);
		this.setBackground(Color.white);
		
		System.out.println(mif.size());
		
		// 라벨 패널에 부착
		JLabel label = new JLabel("예매 번호 입력 : ");
		label.setBounds(15, 15, 200, 50);
		label.setFont(label.getFont().deriveFont(15.0f));
		this.add(label);
 
		// 텍스트 필드 생성 후 패널에 부착
		JTextField text = new JTextField(15);
		text.setBounds(132, 22, 150, 30);
		this.add(text);
		
		JLabel re = new JLabel(" "); // 추후 예매번호 틀릴 시 내용 변경 "번호를 다시 확인해주십시오."됨.
		re.setBounds(380, 15, 300, 50);
		re.setFont(label.getFont().deriveFont(15.0f));
		re.setForeground(Color.GREEN);
		this.add(re);
	 
		
		JButton backbt = new JButton("이  전");
		backbt.setBounds(670, 10, 80, 40);
		backbt.setBackground(Color.white);
		backbt.setBorder(BorderFactory.createLineBorder(new Color(33, 150, 83)));
		this.add(backbt);
		// 이전버튼 클릭시 메인 페이지
		backbt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new MainFrame();
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
			// 텍스트 상자로 다시 포커스 가져가기
			text.requestFocus();
						
			minfo(); // 예매정보
					
			int index = -1; //for문은 0부터 돌기 때문에 index를 0으로 설정하면 내가 찾는 값과 배열의 담긴 값이 같지 않아도 출력될 수 있기 때문.
			for(int i = 0; i < mif.size(); i++) {   //mif라는 객체배열 전체 크기만큼 돌아서
				if(text.equals(mif.get(i).getmNumber()/*예매번호*/){  //이미 저장되있는 예매번호와 사용자에게 입력받은 text가 일치하는지 여부 확인 
					index = i;
				}
			}
			if(index > -1) { //일치 값이 있어서 인덱스가 값이 변했다면, 일치한 i번째 값을 모두 가져와 JLabel에 넣고 위치지정하여 보여준다.(예매번호는 중복되지 않으므로 배열사용 안 함)
				int count = 1;
				   // 순번
				   JLabel relabel1 = new JLabel(count++ +"", JLabel.CENTER);
				   relabel1.setBounds(30, (20 + (30)), 100, 20);
				   reList.add(relabel1);
				   // 날짜
				   JLabel relabel2 = new JLabel(mif.get(i).getmDate1(), JLabel.CENTER);
				   relabel2.setBounds(100, (20 + (30)), 100, 20);
				   reList.add(relabel2);
				   // 제목
				   JLabel relabel3 = new JLabel(mif.get(i).getmTitle(), JLabel.CENTER);
				   relabel3.setBounds(240, (20 + (30)), 200, 20);
				   reList.add(relabel3);
				   // 시간
				   JLabel relabel4 = new JLabel(mif.get(i).getmTime(), JLabel.CENTER);
				   relabel4.setBounds(380, (20 + (30)), 100, 20);
				   reList.add(relabel4);
				   // 좌석
				   JLabel relabel5 = new JLabel(mif.get(i).getmSeat(), JLabel.CENTER);
				   relabel5.setBounds(480, (20 + (30)), 100, 20);
				   reList.add(relabel5);
				   // 지점
				   JLabel relabel6 = new JLabel(mif.get(i).getmLocation(), JLabel.CENTER);
				   relabel6.setBounds(590, (20 + (30)), 100, 20);
				   reList.add(relabel6);
				   // 예약번호
				   JLabel relabel7 = new JLabel(mif.get(i).getmNumber, JLabel.CENTER);
				   relabel7.setBounds(640, (20 + (30)), 100, 20);
				   reList.add(relabel7);			
				  
			}else { // 중복되는 값이 없을 경우
				re.setText("번호를 다시 확인하여 주십시오."); // false일 시 번호를 다시 확인해달라는 라벨 띄움					
			}
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
				//String mNumber = dis.readUTF(); //예매번호
				
				mif.add(new MovieInfo(mDate, mLocation, mTitle, mTime, mSeat, mNumber));			
			}	
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (EOFException e) {
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

  
