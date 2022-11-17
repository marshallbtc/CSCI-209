/**
 * 
 */
package edu.wlu.cs.thisMonkeyBytes;

/**
 * @author marshalljones
 *
 */
public class CD extends MediaItem {
	
	String artist;
	int nTracks;

	/**
	 * @param title
	 * @param isPresent
	 * @param playingTime
	 * @param copyrightYear
	 */
	public CD(String artist, int nTracks, String title, boolean isPresent, int playingTime, int copyrightYear) {
		super(title, isPresent, playingTime, copyrightYear);
		this.artist = artist;
		this.nTracks = nTracks;
	}

	/**
	 * @param title
	 * @param playingTime
	 * @param copyrightYear
	 */
	public CD(String artist, int nTracks, String title, int playingTime, int copyrightYear) {
		super(title, playingTime, copyrightYear);
		this.artist = artist;
		this.nTracks = nTracks;
	}
	
	/**
	 * @return artist the artist
	 */
	public String getArtist() {
		return artist;
	}

	/**
	 * @return nTracks the number of tracks
	 */
	public int getnTracks() {
		return nTracks;
	}

	@Override
	public String toString() {
		return (artist != null ? "artist: " + artist + "\n" : "") + "nTracks: " + nTracks + "\n"
				+ (title != null ? "title: " + title + "\n" : "") + "present: " + isPresent + "\n"
				+ "playing time: " + playingTime + "\n" + "copyright year: " + copyrightYear;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CD loveAintLove = new CD("Yonder Mountain String Band", 13, "Love. Ain't Love", 53, 2017);
		System.out.println("Yonder Mountain String Band");
		System.out.println(loveAintLove.getArtist());
		
		System.out.println("13");
		System.out.println("" + loveAintLove.getnTracks());
		
		System.out.println(loveAintLove.toString());
	}

	

}
