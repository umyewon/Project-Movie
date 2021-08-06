import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Info {
	
	private List<UserInfo> uif = new ArrayList<>();
	private List<MovieInfo> mif = new ArrayList<>();
	
	public void uinfo() {
		
		try(DataInputStream dis = new DataInputStream(new FileInputStream("user.txt"))){
				while(true) {
				String userID = dis.readUTF();
				String userPW = dis.readUTF();//
				String userName = dis.readUTF();
				String userPhone = dis.readUTF();
				
				System.out.println("유저출");
				uif.add(new UserInfo(userID, userPW, userName, userPhone));
				System.out.println(uif.get(0));

			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (EOFException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void minfo() {
		
		try(DataInputStream dis = new DataInputStream(new FileInputStream("movie.txt"))){
			
			while(true) {
				String mDate1 = dis.readUTF();
				//String mDate2 = dis.readUTF();//
				String mLocation = dis.readUTF();
				String mTitle = dis.readUTF();
				String mTime = dis.readUTF();
				String mSeat = dis.readUTF();
				//String mNumber = dis.readUTF();
				
				System.out.println("무비출");
				mif.add(new MovieInfo(mDate1, mLocation, mTitle, mTime, mSeat));
			}
		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (EOFException e) {
			e.printStackTrace();
		    // JOptionPane.showMessageDialog(null, "조회 완료되었습니다.", " ", JOptionPane.ERROR_MESSAGE);catch (IOException e) {
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
