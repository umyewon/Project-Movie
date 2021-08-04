
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JFrame {		// 예매 로그인
	private JButton login, join;
	private JTextField idT, pwT;

	public Login() {

		this.setBounds(600, 250, 800, 500);

		Font font = new Font("맑은 고딕", Font.BOLD, 25);
		Font font2 = new Font("맑은 고딕", Font.PLAIN, 20);

		JPanel panel = new JPanel();

		panel.setLayout(null);

		// 라벨
		JLabel idL = new JLabel();
		idL.setBounds(170, 130, 60, 50);
		idL.setText("ID");
		idL.setFont(font);
		idL.setForeground(new Color(33, 150, 83));

		JLabel pwL = new JLabel();
		pwL.setBounds(170, 210, 60, 50);
		pwL.setText("PW");
		pwL.setFont(font);
		pwL.setForeground(new Color(33, 150, 83));

		// 텍스트 필드
		idT = new JTextField(10);
		idT.setBounds(245, 140, 200, 30);
		idT.setFont(font2);

		pwT = new JPasswordField(10);
		pwT.setBounds(245, 220, 200, 30);
		pwT.setFont(font2);

		login = new JButton();
		login.setBounds(480, 130, 140, 50);
		login.setText("로그인");
		login.setFont(font);
		login.setForeground(Color.white);
		login.setBackground(new Color(33, 150, 83));
		
		join = new JButton();
		join.setBounds(480, 210, 140, 50);
		join.setText("회원가입");
		join.setFont(font);
		join.setForeground(Color.white);
		join.setBackground(new Color(33, 150, 83));

		panel.add(idL);
		panel.add(idT);
		panel.add(pwL);
		panel.add(pwT);
		panel.add(login);
		panel.add(join);

		login.addActionListener(new userFile());		// 로그인 버튼 누르면 로그인 오류 or 성공
		join.addActionListener(new ActionListener() {   // 회원가입 누르면 가입 창으로
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new Join();
				setVisible(false);
			}
		});
		

		this.add(panel);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);

	}
	
	private class userFile implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			try(DataInputStream din = new DataInputStream(new FileInputStream("user.txt"))){
				String id = din.readUTF();
				String pw = din.readUTF();
				
				if(id.equals(idT.getText()) && pw.equals(pwT.getText())) {
					// 예매 창으로 이동
					setVisible(false);
				} else if(!id.equals(idT.getText())) {
					JOptionPane.showMessageDialog(null, "존재하지 않는 회원입니다."," ", JOptionPane.ERROR_MESSAGE);
				} else if(!pw.equals(pwT.getText())) {
					JOptionPane.showMessageDialog(null, "비밀번호가 일치하지 않습니다.", " ", JOptionPane.ERROR_MESSAGE);
				}
				
				setVisible(false);
			} catch (FileNotFoundException e1) {			
				JOptionPane.showMessageDialog(null, "존재하지 않는 회원입니다."," ", JOptionPane.ERROR_MESSAGE);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			
		}
		
	}

	public static void main(String[] args) {
		new Login();
	}

}
