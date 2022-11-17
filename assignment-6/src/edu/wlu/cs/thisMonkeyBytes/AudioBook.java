/**
 * 
 */
package edu.wlu.cs.thisMonkeyBytes;

/**
 * @author marshalljones
 *
 */
public class AudioBook extends MediaItem {
	
	String author;
	String narrator;

	/**
	 * @param author
	 * @param narrator
	 * @param title
	 * @param isPresent
	 * @param playingTime
	 * @param copyrightYear
	 */
	public AudioBook(String author, String narrator, String title, boolean isPresent, int playingTime, int copyrightYear) {
		super(title, isPresent, playingTime, copyrightYear);
		this.author = author;
		this.narrator = narrator;
	}

	/**
	 * @param author
	 * @param narrator
	 * @param title
	 * @param playingTime
	 * @param copyrightYear
	 */
	public AudioBook(String author, String narrator, String title, int playingTime, int copyrightYear) {
		super(title, playingTime, copyrightYear);
		this.author = author;
		this.narrator = narrator;
	}

	/**
	 * @return author the author
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * @return narrator the narrator
	 */
	public String getNarrator() {
		return narrator;
	}

	@Override
	public String toString() {
		return (author != null ? "author: " + author + "\n" : "")
				+ (narrator != null ? "narrator: " + narrator + "\n" : "")
				+ (title != null ? "title: " + title + "\n" : "") + "present: " + isPresent + "\nplaying time: "
				+ playingTime + "\ncopyright year: " + copyrightYear;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		AudioBook wimpyKid = new AudioBook("Jeff Kinney", "Ramon De Ocampo", "Diary of a Wimpy Kid", 117, 2007);
		System.out.println("Jeff Kinney");
		System.out.println(wimpyKid.getAuthor());
		
		System.out.println("Ramon De Ocampo");
		System.out.println(wimpyKid.getNarrator());
		
		System.out.println(wimpyKid.toString());
	}

}
