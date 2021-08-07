// user파일에 저장된 순서
public class UserInfo /*implements Serializable*/ {

	private String userID;
	private String userPW;
	private String userName;
	private String userPhone;

	
	public UserInfo() {}


	public UserInfo(String userID, String userPW, String userName, String userPhone) {
		super();
		this.userID = userID;
		this.userPW = userPW;
		this.userName = userName;
		this.userPhone = userPhone;
	}


	public String getUserID() {
		return userID;
	}


	public void setUserID(String userID) {
		this.userID = userID;
	}


	public String getUserPW() {
		return userPW;
	}


	public void setUserPW(String userPW) {
		this.userPW = userPW;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getUserPhone() {
		return userPhone;
	}


	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}


	@Override
	public String toString() {
		return "UserInfo [userID=" + userID + ", userPW=" + userPW + ", userName=" + userName + ", userPhone="
				+ userPhone + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((userID == null) ? 0 : userID.hashCode());
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
		result = prime * result + ((userPW == null) ? 0 : userPW.hashCode());
		result = prime * result + ((userPhone == null) ? 0 : userPhone.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserInfo other = (UserInfo) obj;
		if (userID == null) {
			if (other.userID != null)
				return false;
		} else if (!userID.equals(other.userID))
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		if (userPW == null) {
			if (other.userPW != null)
				return false;
		} else if (!userPW.equals(other.userPW))
			return false;
		if (userPhone == null) {
			if (other.userPhone != null)
				return false;
		} else if (!userPhone.equals(other.userPhone))
			return false;
		return true;
	}

	
}
