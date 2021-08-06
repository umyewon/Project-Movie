// movie.txt 파일에 입력되는 순서
public class MovieInfo {

	String mDate1;
	//String mDate2;	
	String mLocation;
	String mTitle ;
	String mTime;
	String mSeat;
	
	
	public MovieInfo() {}

	public MovieInfo(String mDate1, String mLocation, String mTitle, String mTime, String mSeat) {
		super();
		this.mDate1 = mDate1;
		this.mLocation = mLocation;
		this.mTitle = mTitle;
		this.mTime = mTime;
		this.mSeat = mSeat;
		
	}

	public String getmDate1() {
		return mDate1;
	}

	public void setmDate1(String mDate1) {
		this.mDate1 = mDate1;
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

	
	@Override
	public String toString() {
		return "MovieInfo [mDate1=" + mDate1 + ", mLocation=" + mLocation + ", mTitle=" + mTitle
				+ ", mTime=" + mTime + ", mSeat=" + mSeat + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((mDate1 == null) ? 0 : mDate1.hashCode());
		result = prime * result + ((mLocation == null) ? 0 : mLocation.hashCode());
		result = prime * result + ((mSeat == null) ? 0 : mSeat.hashCode());
		result = prime * result + ((mTime == null) ? 0 : mTime.hashCode());
		result = prime * result + ((mTitle == null) ? 0 : mTitle.hashCode());
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
		if (mDate1 == null) {
			if (other.mDate1 != null)
				return false;
		} else if (!mDate1.equals(other.mDate1))
			return false;
		if (mLocation == null) {
			if (other.mLocation != null)
				return false;
		} else if (!mLocation.equals(other.mLocation))
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
		return true;
	}
	
	
}
