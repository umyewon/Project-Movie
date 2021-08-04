import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;


public class MainFrame extends JFrame{

	public MainFrame() {
		super("Movie");
		this.setBounds(600, 250, 800, 500);
		this.setResizable(false);	
		
		// 아이콘 이미지
		try {
			this.setIconImage(ImageIO.read(new File("Icon2.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// 메인 페이지
		new Main(this);

		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}
