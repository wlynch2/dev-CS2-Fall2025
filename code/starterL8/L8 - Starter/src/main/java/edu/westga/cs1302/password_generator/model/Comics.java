package edu.westga.cs1302.password_generator.model;

/** creates a comic object used to store the title and issue number of said comic
 * 
 * @author wlynch2
 * @version CS1302
 */
public class Comics {
	private String title;
	private int issueNumber;
	
	/** constructor for Comics class
	 * 
	 * @precondition title != be null issueNumber !<= 0
	 * @postcondition none
	 * 
	 * 
	 * @param title String the title of the comic
	 * @param issueNumber int the issue number of the comic
	 */
	public Comics(String title, int issueNumber) {
		if (title == null || title.isEmpty()) {
			throw new IllegalArgumentException("title cannot be null");
		}
		
		if (issueNumber <= 0) {
			throw new IllegalArgumentException("issueNumber cannot be less than 0");
		}
	
		this.title = title;
		this.issueNumber = issueNumber;
	}
	
	/**getter method for the title of the comic
	 * 
	 * @return String the current title
	 */
	public String getTitle() {
		return this.title;
	}
	
	/**getter method for the issueNumber of the comic
	 * 
	 * @return int the current issueNumber
	 */
	public int getIssueNumber() {
		return this.issueNumber;
	}
	
	@Override
	public String toString() {
		return this.title + " " + this.issueNumber;
	}
}

