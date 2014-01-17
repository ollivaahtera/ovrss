package fi.ov.ovrss.rss;

import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sun.syndication.feed.synd.SyndEntry;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.io.SyndFeedInput;
import com.sun.syndication.io.XmlReader;

public class RssParser {

	private static final Logger logger = LoggerFactory.getLogger(RssParser.class);
	private static Map<String, RssFeed> feedMap = new HashMap<String, RssFeed>();
	private final static long MAX_CACHE_AGE = 60;
	private final static long MAX_ENTRY_COUNT = 20;
	
	public RssFeed getFeed(String url) {
		RssFeed feed = null;
		if (feedMap.containsKey(url)) {
			logger.debug("Getting feed from cache.");
			feed = feedMap.get(url);
			if (!checkTime(feed.getFetchTime(), MAX_CACHE_AGE)) {
				feed = fetchFeed(url);
			}
		} else {
			feed = fetchFeed(url);
		}
		return feed;
	}
	
	private RssFeed fetchFeed(String url) {
		logger.debug("Feed not found in cache or too old, fetching new.");
		RssFeed feed = readFeed(url);
		feedMap.put(url, feed);
		return feed;
	}
	
	private boolean checkTime(Date date, long maxAgeInSecs) {
		GregorianCalendar now = new GregorianCalendar();
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(date);
		long ageInSecs = (now.getTimeInMillis() - cal.getTimeInMillis()) / 1000;
		return ageInSecs < maxAgeInSecs;
	}
	
	private RssFeed readFeed(String feedUrl) {
		RssFeed rss = new RssFeed();
		XmlReader reader = null;
		try {

			URL url = new URL(feedUrl);

			reader = new XmlReader(url);
			SyndFeed feed = new SyndFeedInput().build(reader);

			rss.setUrl(feedUrl);
			rss.setName(feed.getTitle());
			rss.setFetchTime(new Date());
			
			logger.debug("Feed Title: {}", feed.getTitle());
			logger.debug("Fetched {} entries", feed.getEntries().size());
			for (Object o : feed.getEntries()) {
				SyndEntry entry = (SyndEntry)o;
				RssEntry rssEntry = new RssEntry(entry);
				rssEntry.setFeedName(feed.getTitle());
				if (rss.getEntries().size() < MAX_ENTRY_COUNT) {
					rss.getEntries().add(rssEntry);
				}
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		} finally {
			if (reader != null)
				try {
					reader.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return rss;
	}

}
