package fi.ov.ovrss.rss;

import java.util.Date;

import com.sun.syndication.feed.synd.SyndEntry;

/**
 * Class for single RSS Entry
 * 
 * @author olli
 */
public class RssEntry implements Comparable<RssEntry> {
	private String title;
	private Date pubDate;
	private String link;
	private String description;
	private String feedName;

	/**
	 * Constructor that parses its attributes from SyndEntry object 
	 *
	 * @param entry SyndEntry 
	 */
	public RssEntry(SyndEntry entry) {
		this.title = entry.getTitle();
		this.description = entry.getDescription().getValue();
		this.link = entry.getLink();
		this.pubDate = entry.getPublishedDate();
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getPubDate() {
		return pubDate;
	}
	public void setPubDate(Date pubDate) {
		this.pubDate = pubDate;
	}
	public String getFeedName() {
		return feedName;
	}
	public void setFeedName(String feedName) {
		this.feedName = feedName;
	}

	/**
	 * RssEntries must be comparable by date
	 */
	@Override
	public int compareTo(RssEntry o) {
		if(o != null && o.getPubDate() != null && this.getPubDate() != null) {
			return o.getPubDate().after(pubDate) ? 1 : -1;
		}
		return 0;
	}
}
