package ca.ualberta.cs.lonelytwitter.lonelytweet;

import java.io.IOException;
import java.io.Serializable;
import java.util.Date;

public class NormalLonelyTweet extends LonelyTweet implements Serializable {

	private static final long serialVersionUID = 1L;
	private Date tweetDate; // Access changed to private (was protected, larger scope than necessary)
	private String tweetBody; // Access changed to private (was protected, larger scope than necessary)

	// Had a NormalLonelyTweet() constructor; this was unused.

	public NormalLonelyTweet(String text, Date date) {
		this.tweetDate = date;
		this.tweetBody = text;
	}

	public Date getTweetDate() {
		return tweetDate;
	}

	public void setTweetDate(Date tweetDate) {
		this.tweetDate = tweetDate;
	}

	public void setTweetBody(String tweetBody) {
		this.tweetBody = tweetBody;
	}

	private void writeObject(java.io.ObjectOutputStream out) throws IOException {
		out.writeObject(tweetDate);
		out.writeObject(tweetBody);
	}

	private void readObject(java.io.ObjectInputStream in) throws IOException,
			ClassNotFoundException {
		tweetDate = (Date) in.readObject();
		tweetBody = (String) in.readObject();
	}

	public boolean isValid() {
		int tweetLength = tweetBody.trim().length();
		if (tweetLength == 0 || tweetLength > 10) { // Simplified the if statement by using a new tweetLength
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return getTweetDate() + " | " + getTweetBody() ;
	}

	@Override
	public String getTweetBody() {
		return tweetBody;
	}
}