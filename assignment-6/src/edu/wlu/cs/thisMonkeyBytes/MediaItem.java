/**
 * 
 */
package edu.wlu.cs.thisMonkeyBytes;

/**
 * @author marshalljones
 *
 */
public abstract class MediaItem implements Comparable<MediaItem> {

	String title;
	boolean isPresent;
	int playingTime;
	int copyrightYear;
	
	/**
	 * @param title
	 * @param isPresent
	 * @param playingTime
	 * @param copyrightYear
	 */
	public MediaItem(String title, boolean isPresent, int playingTime, int copyrightYear) {
		super();
		this.title = title;
		this.isPresent = isPresent;
		this.playingTime = playingTime;
		this.copyrightYear = copyrightYear;
	}

	/**
	 * @param title
	 * @param playingTime
	 * @param copyrightYear
	 */
	public MediaItem(String title, int playingTime, int copyrightYear) {
		this(title, true, playingTime, copyrightYear);
	}

	/**
	 * @return isPresent the boolean value representing whether or not 
	 * the item is in stock
	 */
	public boolean isPresent() {
		return isPresent;
	}

	/**
	 * @param isPresent sets the value representing whether or not
	 * the item is in stock
	 */
	public void setPresent(boolean isPresent) {
		this.isPresent = isPresent;
	}

	/**
	 * @return title the name of the media item
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @return playing time the length in minutes of the media item
	 */
	public int getPlayingTime() {
		return playingTime;
	}

	/**
	 * @return copyrightYear the year that the media item went under copyright
	 */
	public int getCopyrightYear() {
		return copyrightYear;
	}

	@Override
	public String toString() {
		return "title: " + title + "\npresent: " + isPresent + "\nplaying time: " + playingTime
				+ "\ncopyright year: " + copyrightYear;
	}
	
	@Override
	public int compareTo(MediaItem o) {
		int output = this.title.compareTo(o.title);
		return output;
	}
	
	
	
}
