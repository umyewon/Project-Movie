import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ReserveInfo extends JPanel /*implements Serializable*/ {

   private MainFrame mf;
   private JPanel ReserveInfo;

   private JLabel relabel1;
   private JLabel relabel2;
   private JLabel relabel3;
   private JLabel relabel4;
   private JLabel relabel5;
   private JLabel relabel6;
   private JLabel relabel7;
   
   // MovieInfo
   private List<MovieInfo> mif = new ArrayList<>();
   
   JTextField text;
   JLabel re;
   int i;

   public ReserveInfo(MainFrame mf) {
      this.mf = mf;
      this.ReserveInfo= this;
      
      this.setLayout(null);
      this.setBackground(Color.white);
      
      Font tfont = new Font("맑은고딕", Font.BOLD, 15);
      Font font = new Font("맑은고딕", Font.BOLD, 13);
      
      
      // 라벨 패널에 부착
      JLabel label = new JLabel("예매 번호 입력 : ");
      label.setBounds(15, 15, 200, 50);
      label.setFont(tfont);
      this.add(label);
 
      // 텍스트 필드 생성 후 패널에 부착
      text = new JTextField(15);
      text.setBounds(132, 22, 150, 30);
      this.add(text);
      
      JLabel re = new JLabel(" "); // 추후 예매번호 틀릴 시 내용 변경 "번호를 다시 확인해주십시오."됨.
      re.setBounds(290, 15, 300, 50);
      re.setFont(tfont);
      re.setForeground(Color.red);
      this.add(re);
    
      JButton backbt = new JButton("이  전");
      backbt.setBounds(670, 10, 80, 40);
      backbt.setFont(font);
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
      checkbt.setFont(tfont);
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
      list2.setBounds(120, 70, 100, 20); // 날짜
      list3.setBounds(250, 70, 100, 20); // 영화
      list4.setBounds(380, 70, 100, 20); // 시간
      list5.setBounds(470, 70, 100, 20); // 좌석
      list6.setBounds(557, 70, 100, 20); // 지점
      list7.setBounds(640, 70, 100, 20); // 예약번호
      
      list1.setFont(font);
      list2.setFont(font);
      list3.setFont(font);
      list4.setFont(font);
      list5.setFont(font);
      list6.setFont(font);
      list7.setFont(font);
      
      this.add(list1);
      this.add(list2);
      this.add(list3);
      this.add(list4);
      this.add(list5);
      this.add(list6);
      this.add(list7);
      
      relabel1 = new JLabel("", JLabel.CENTER);
      relabel2 = new JLabel("", JLabel.CENTER);
      relabel3 = new JLabel("", JLabel.CENTER);
      relabel4 = new JLabel("", JLabel.CENTER);
      relabel5 = new JLabel("", JLabel.CENTER);
      relabel6 = new JLabel("", JLabel.CENTER);
      relabel7 = new JLabel("", JLabel.CENTER);
      
      relabel1.setFont(font);
      relabel2.setFont(font);
      relabel3.setFont(font);
      relabel4.setFont(font);
      relabel5.setFont(font);
      relabel6.setFont(font);
      relabel7.setFont(font);
            
      this.add(relabel1);
      this.add(relabel2);
      this.add(relabel3);
      this.add(relabel4);
      this.add(relabel5);
      this.add(relabel6);
      this.add(relabel7);

      // 조회 버튼 클릭시 조회된 정보 출력
      checkbt.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            // 텍스트 상자로 다시 포커스 가져가기
            text.requestFocus();
            
            try (BufferedReader br = new BufferedReader(new FileReader("movie.txt"))) {
               
               String line = "";
               while((line = br.readLine()) != null) {
                  
                  String[] str = line.split(",");
                  for(int i= 0; i < str.length/6; i++) {
                     mif.add(new MovieInfo(str[i*6], str[(i*6)+1], str[(i*6)+2], str[(i*6)+3], str[(i*6)+4], str[(i*6)+5]));
                  }                  
                  resultinfo();
               }
            } catch (FileNotFoundException e1) {
               JOptionPane.showMessageDialog(null, "Filenot", " ", JOptionPane.ERROR_MESSAGE);
            } catch (IOException e1) {
               e1.printStackTrace();
            }
         }
      });
      

      // 메인프레임에 추가
      mf.add(this);
   }

   
   public void resultinfo() {
      // 정보 화면 출력용
      int index = -1; //for문은 0부터 돌기 때문에 index를 0으로 설정하면 내가 찾는 값과 배열의 담긴 값이 같지 않아도 출력될 수 있기 때문.
      for(int i = 0; i < mif.size(); i++) {   //mif라는 객체배열 전체 크기만큼 돌아서
    	     	  
         if(text.getText().equals(mif.get(i).getmNumber())){  //이미 저장되있는 예매번호와 사용자에게 입력받은 text가 일치하는지 여부 확인 
        	index = i;
        	
         }
      }
      if(index > -1) { //일치 값이 있어서 인덱스가 값이 변했다면, 일치한 i번째 값을 모두 가져와 JLabel에 넣고 위치지정하여 보여준다.(예매번호는 중복되지 않으므로 배열사용 안 함)
            // 순번
            relabel1.setText("1");
            relabel1.setBounds(30, 100, 100, 20);
            // 날짜
            relabel2.setText(mif.get(i).getmDate());
            relabel2.setBounds(120, 100, 100, 20);
            // 제목
            relabel3.setText(mif.get(i).getmTitle());
            relabel3.setBounds(210, 100, 200, 20);
            // 시간
            relabel4.setText(mif.get(i).getmTime());
            relabel4.setBounds(380, 100, 100, 20);
            // 좌석
            relabel5.setText(mif.get(i).getmSeat());
            relabel5.setBounds(470, 100, 100, 20);
            // 지점
            relabel6.setText(mif.get(i).getmLocation());
            relabel6.setBounds(560, 100, 100, 20);
            // 예약번호
            relabel7.setText(mif.get(i).getmNumber());
            relabel7.setBounds(640, 100, 100, 20);
      }else { // 중복되는 값이 없을 경우
         re.setText("번호를 다시 확인하여 주십시오."); // false일 시 번호를 다시 확인해달라는 라벨 띄움               
      }   
   }
}



  
