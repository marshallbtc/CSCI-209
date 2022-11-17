/**
 * 
 */
package edu.wlu.cs.thisMonkeyBytes;

/**
 * @author marshalljones
 *
 */
public class Driver {

	/**
	 * 
	 */
	public Driver() {
	}

	/**
	 * @param args
	 * 
	 * Tests MediaItem and its child classes
	 */
	public static void main(String[] args) {
		CD loveAintLove = new CD("Yonder Mountain String Band", 13, "Love. Ain't Love", 53, 2017);
		CD mountainTracks = new CD("Yonder Mountain String Band", 24, "Mountain Tracks, Vol. 5", 117, 2008);
		
		DVD pirateMovie = new DVD("PG-13", 15, "Pirates of the Antarctic", 134, 2003);
		DVD pirateMovie2 = new DVD("PG-13", 0, "Pirates of the Caribbean: The Curse of the Black Pearl", 143, 2003);
		
		AudioBook wimpyKid = new AudioBook("Jeff Kinney", "Ramon De Ocampo", "Diary of a Wimpy Kid", 117, 2007);
		AudioBook wimpyKid2 = new AudioBook("Jeff Kinney", "Ramon De Ocampo", "Diary of a Wimpy Kid: The Last Straw", 135, 2009);
		
		MediaItem[] library = new MediaItem[] {loveAintLove, mountainTracks, pirateMovie, pirateMovie2, wimpyKid, wimpyKid2};
		
		System.out.println("Welcome to the library! See below for our catalog and availability.\n\n---------");
		for (MediaItem i: library) {
			System.out.println(i.toString());
			System.out.println("---------");
		}
		
		System.out.println("\n");
		
		for (MediaItem i: library) {
			i.setPresent(false);
			System.out.println("Checked out \"" + i.getTitle() + ".\" Did you know know the copyright year is " + i.getCopyrightYear() + "?");
		}
		
		System.out.println("\nMEDIA ITEMS STATUS UPDATE");
		for (MediaItem i: library) {
			System.out.println(i.getTitle());
			System.out.println("Available: " + i.isPresent());
			System.out.println("---------");
		}
		System.out.println("\n");
		
		for (MediaItem i: library) {
			i.setPresent(true);
			System.out.println("Returning \"" + i.getTitle() + "\" to the library. It took me " + i.getPlayingTime() + " minutes to finish!");
		}
		
		System.out.println("\nMEDIA ITEMS STATUS UPDATE");
		for (MediaItem i: library) {
			System.out.println(i.getTitle());
			System.out.println("Available: " + i.isPresent());
			System.out.println("---------");
		}
		System.out.println("\n");
		
		System.out.println("Now that everything has been returned, let's sort the library!\nOriginal order:");
		for (MediaItem i: library) {
			System.out.println(i.getTitle());
		}
		
		MediaItem temp;
		for (int i = 0; i < library.length; i++) {
			for (int j = i+1; j < library.length; j++) {
				if ( library[j].compareTo(library[i]) < 0 ) {
					temp = library[j];
					library[j] = library[i];
					library[i] = temp;
				}
			}
		}
		
		System.out.println("\nSorting complete\n\nLIBRARY ORDER UPDATE");
		for (MediaItem i: library) {
			System.out.println(i.getTitle());
		}
	}

}
