package fi.ov.ovrss.rss;

import java.util.Date;
import java.util.TreeSet;

/**
 * Class for storing RSS feed properties and entries
 * 
 * @author olli
 */
public class RssFeed {
	private String url;
	private String name;
	private TreeSet<RssEntry> entries = new TreeSet<RssEntry>();
	private Date fetchTime;
	
	public TreeSet<RssEntry> getEntries() {
		return entries;
	}
	public void setEntries(TreeSet<RssEntry> entries) {
		this.entries = entries;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Date getFetchTime() {
		return fetchTime;
	}
	public void setFetchTime(Date fetchTime) {
		this.fetchTime = fetchTime;
	}
}
