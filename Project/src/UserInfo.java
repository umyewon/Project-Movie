// user파일에 저장된 순서
public class UserInfo /*implements Serializable*/ {

	
	private String userID;
	private String userPW;
	private String userName;
	private String userPhone;
	private String mDate;
	private String mTitle;
	private String mTime;
	private String mSeat;
	private String mNumber;
	
	public UserInfo() {}

	public UserInfo(String userID, String userPW, String userName, String userPhone, String mDate, String mTitle,
			String mTime, String mSeat, String mNumber) {
		super();
		this.userID = userID;
		this.userPW = userPW;
		this.userName = userName;
		this.userPhone = userPhone;
		this.mDate = mDate;
		this.mTitle = mTitle;
		this.mTime = mTime;
		this.mSeat = mSeat;
		this.mNumber = mNumber;
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

	public String getmDate() {
		return mDate;
	}

	public void setmDate(String mDate) {
		this.mDate = mDate;
	}

	public String getmTitle() {
		return mTitle;
	}

	public void setmTitle(String mTitle) {
		this.mTitle = mTitle;
	}

	public String getmTime() {
		return mTime;
	}

	public void setmTime(String mTime) {
		this.mTime = mTime;
	}

	public String getmSeat() {
		return mSeat;
	}

	public void setmSeat(String mSeat) {
		this.mSeat = mSeat;
	}

	public String getmNumber() {
		return mNumber;
	}

	public void setmNumber(String mNumber) {
		this.mNumber = mNumber;
	}

	@Override
	public String toString() {
		return "UserInfo [userID=" + userID + ", userPW=" + userPW + ", userName=" + userName + ", userPhone="
				+ userPhone + ", mDate=" + mDate + ", mTitle=" + mTitle + ", mTime=" + mTime + ", mSeat=" + mSeat
				+ ", mNumber=" + mNumber + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((mDate == null) ? 0 : mDate.hashCode());
		result = prime * result + ((mNumber == null) ? 0 : mNumber.hashCode());
		result = prime * result + ((mSeat == null) ? 0 : mSeat.hashCode());
		result = prime * result + ((mTime == null) ? 0 : mTime.hashCode());
		result = prime * result + ((mTitle == null) ? 0 : mTitle.hashCode());
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
		if (mDate == null) {
			if (other.mDate != null)
				return false;
		} else if (!mDate.equals(other.mDate))
			return false;
		if (mNumber == null) {
			if (other.mNumber != null)
				return false;
		} else if (!mNumber.equals(other.mNumber))
			return false;
		if (mSeat == null) {
			if (other.mSeat != null)
				return false;
		} else if (!mSeat.equals(other.mSeat))
			return false;
		if (mTime == null) {
			if (other.mTime != null)
				return false;
		} else if (!mTime.equals(other.mTime))
			return false;
		if (mTitle == null) {
			if (other.mTitle != null)
				return false;
		} else if (!mTitle.equals(other.mTitle))
			return false;
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
