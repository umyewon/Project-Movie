
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class JoinR extends JPanel{
	private MainFrame mf;
	private JPanel JoinR;
	private JTextField idT;
	private JTextField pwT;
	private JTextField nameT;
	private JTextField telT;
	
	public JoinR(MainFrame mf) {
		this.mf = mf;
		this.JoinR = this;
		
		// 패널
		JoinR = new JPanel();
		setBackground(Color.white);	
	
		
		// 패널 생성
		JPanel panel = new JPanel();
		panel.setBackground(Color.white);
		
		// 폰트
		Font font1 = new Font("맑은 고딕", Font.BOLD, 23);
		Font font2 = new Font("맑은 고딕", Font.PLAIN, 20);
		
		// 공백
		JLabel tab1 = new JLabel();
		tab1.setText("* * * * * * * * * * * * * *");
		tab1.setFont(font1);
		tab1.setForeground(new Color(33, 150, 83));
		
		// id
		JLabel idL = new JLabel();
		idL.setText("                        ID");
		idL.setFont(font1);
		idL.setForeground(new Color(33, 150, 83));
		
		idT = new JTextField(13);
		idT.setFont(font2);	
		
		// pw
		JLabel pwL = new JLabel();
		pwL.setText("               Password");
		pwL.setFont(font1);
		pwL.setForeground(new Color(33, 150, 83));
		
		pwT = new JPasswordField(13);
		pwT.setFont(font2);	
		
		// name
		JLabel nameL = new JLabel();
		nameL.setText("                   Name");
		nameL.setFont(font1);
		nameL.setForeground(new Color(33, 150, 83));
		
		nameT = new JTextField(13);
		nameT.setFont(font2);		
		
		// tel
		JLabel telL = new JLabel();
		telL.setText("                      Tel");
		telL.setFont(font1);
		telL.setForeground(new Color(33, 150, 83));
		
		telT = new JTextField(13);
		telT.setFont(font2);	
		
		// 공백
		JLabel tab2 = new JLabel();
		tab2.setText("* * * * * * * * * * * * * *");
		tab2.setFont(font1);
		tab2.setForeground(new Color(33, 150, 83));
		
		// 버튼		
		JButton join = new JButton();
		join.setText("회원가입");
		join.setFont(font1);
		join.setForeground(Color.white);
		join.setBackground(new Color(33, 150, 83));
	
		
		// 버튼 액션 - 회원 정보 저장하고 예매 페이지로 이동
		join.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(idT.getText().isEmpty() || pwT.getText().isEmpty() || nameT.getText().isEmpty() || telT.getText().isEmpty()) { 
					return;
				} else {
					fileSave();
					new LoginR(mf);
				}
				setVisible(false);
			}
		});
		
				
		// 패널에 올리기
		panel.add(tab1);
		panel.add(idL);
		panel.add(idT);
		panel.add(pwL);
		panel.add(pwT);
		panel.add(nameL);
		panel.add(nameT);
		panel.add(telL);
		panel.add(telT);
		panel.add(tab2);
		panel.add(join);
				
		panel.setPreferredSize(new Dimension(250, 500));
		add(panel);
		
		mf.add(this);
		
	}
	
	// 회원 정보 파일 저장
	public void fileSave() {
		try(BufferedWriter bw = new BufferedWriter(new FileWriter("user.txt", true))){
			bw.write(idT.getText() + ",");
			bw.write(pwT.getText() + ",");
			bw.write(nameT.getText() + ",");
			bw.write(telT.getText() + ",");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// 아이디 movie.txt에 저장 => 추후 회원 조회할때 아이디 값으로 비교
		try(BufferedWriter bw = new BufferedWriter(new FileWriter("movie.txt", true))){
			bw.write(idT.getText() + ",");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
}
