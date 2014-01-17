package fi.ov.ovrss.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.TreeSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fi.ov.ovrss.rss.RssEntry;
import fi.ov.ovrss.rss.RssFeed;
import fi.ov.ovrss.rss.RssParser;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		RssParser parser = new RssParser();

		String[] urls = {"http://rss.kauppalehti.fi/rss/yritysuutiset.jsp",
						"http://rss.kauppalehti.fi/rss/auto.jsp",
						"http://rss.kauppalehti.fi/rss/startup.jsp",
						"http://blogit.kauppalehti.fi/evs/aid/4/recent/50/"};
		TreeSet<RssEntry> entries = new TreeSet<RssEntry>();

		List<RssFeed> feeds = new ArrayList<RssFeed>();
		for (String url : urls) {
			RssFeed feed = parser.getFeed(url);
			entries.addAll(feed.getEntries());
			feeds.add(feed);
		}
		
		model.addAttribute("feeds", feeds);
		model.addAttribute("entries", entries);
		
		return "home";
	}
	
}
