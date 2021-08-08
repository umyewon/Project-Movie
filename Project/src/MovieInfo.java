import java.io.Serializable;

// movie.txt 파일에 입력되는 순서
public class MovieInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String userID;
	private String mDate;	
	private String mLocation;
	private String mTitle ;
	private String mTime;
	private String mSeat;
	private String mNumber;
	
	public MovieInfo() {}

	public MovieInfo(String userID, String mDate, String mLocation, String mTitle, String mTime, String mSeat,
			String mNumber) {
		super();
		this.userID = userID;
		this.mDate = mDate;
		this.mLocation = mLocation;
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

	public String getmDate() {
		return mDate;
	}

	public void setmDate(String mDate) {
		this.mDate = mDate;
	}

	public String getmLocation() {
		return mLocation;
	}

	public void setmLocation(String mLocation) {
		this.mLocation = mLocation;
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
		return "MovieInfo [userID=" + userID + ", mDate=" + mDate + ", mLocation=" + mLocation + ", mTitle=" + mTitle
				+ ", mTime=" + mTime + ", mSeat=" + mSeat + ", mNumber=" + mNumber + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((mDate == null) ? 0 : mDate.hashCode());
		result = prime * result + ((mLocation == null) ? 0 : mLocation.hashCode());
		result = prime * result + ((mNumber == null) ? 0 : mNumber.hashCode());
		result = prime * result + ((mSeat == null) ? 0 : mSeat.hashCode());
		result = prime * result + ((mTime == null) ? 0 : mTime.hashCode());
		result = prime * result + ((mTitle == null) ? 0 : mTitle.hashCode());
		result = prime * result + ((userID == null) ? 0 : userID.hashCode());
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
		MovieInfo other = (MovieInfo) obj;
		if (mDate == null) {
			if (other.mDate != null)
				return false;
		} else if (!mDate.equals(other.mDate))
			return false;
		if (mLocation == null) {
			if (other.mLocation != null)
				return false;
		} else if (!mLocation.equals(other.mLocation))
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
		return true;
	}

	
	
}
