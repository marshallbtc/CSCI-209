/**
 * 
 */
package edu.wlu.cs.thisMonkeyBytes;

/**
 * @author marshalljones
 *
 */
public class DVD extends MediaItem {
	
	String rating;
	int bonusFeatureTime;

	/**
	 * @param title
	 * @param isPresent
	 * @param playingTime
	 * @param copyrightYear
	 */
	public DVD(String rating, int bonusFeatureTime, String title, boolean isPresent, int playingTime, int copyrightYear) {
		super(title, isPresent, playingTime, copyrightYear);
		this.rating = rating;
		this.bonusFeatureTime = bonusFeatureTime;
	}

	/**
	 * @param title
	 * @param playingTime
	 * @param copyrightYear
	 */
	public DVD(String rating, int bonusFeatureTime, String title, int playingTime, int copyrightYear) {
		super(title, playingTime, copyrightYear);
		this.rating = rating;
		this.bonusFeatureTime = bonusFeatureTime;
	}

	/**
	 * @return rating the rating
	 */
	public String getRating() {
		return rating;
	}

	/**
	 * @return bonusFeatureTime the bonus feature time
	 */
	public int getBonusFeatureTime() {
		return bonusFeatureTime;
	}
	
	/**
	 * @return playingTime the playing time
	 */
	@Override
	public int getPlayingTime() {
		return playingTime + bonusFeatureTime;
	}

	@Override
	public String toString() {
		return (rating != null ? "rating: " + rating + "\n" : "") + "bonus feature time: " + bonusFeatureTime
				+ "\n" + (title != null ? "title: " + title + "\n" : "") + "present: " + isPresent + "\nplayingTime: "
				+ playingTime + "\ncopyright year: " + copyrightYear;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DVD pirateMovie = new DVD("PG-13", 15, "Pirates of the Antarctic", 134, 2003);
		System.out.println("PG-13");
		System.out.println(pirateMovie.getRating());
		
		System.out.println("15");
		System.out.println("" + pirateMovie.getBonusFeatureTime());
		
		System.out.println("" + (15+134));
		System.out.println("" + pirateMovie.getPlayingTime());
		
		System.out.println(pirateMovie.toString());
	}

}
