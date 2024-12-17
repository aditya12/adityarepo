package com.aditya.rapidapi;

public class MovieBean {

	
//	+ "(`id`, `link`, `image`, `title`,"
 	//	+ " `theatrical-year`,"
 	//	+ " `release-year`, `streaming-date/date`, `streaming-date/soon`,"
 	//	+ " `streaming-date/unknown`, `streaming-date/display`, `category`,"
 	//	+ " `genre`, `languages`, `platform`, `recommended`, `recommendation`) "
	
	String id;
	
	String image;
	
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	String link;
	
	String title;
	
	String theatricalYear;
	
	String releaseYear;
	
	String streamingDate;
	
	String streamingDateSoon;
	
	String sreamingDateUnknown;
	
	public String getSreamingDateUnknown() {
		return sreamingDateUnknown;
	}

	public void setSreamingDateUnknown(String sreamingDateUnknown) {
		this.sreamingDateUnknown = sreamingDateUnknown;
	}

	String streamingDisplay;
	
	String category;
	
	String genre;
	
	String languages;
	
	String platform;
	
	String recommendation;
	
	String recommended;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTheatricalYear() {
		return theatricalYear;
	}

	public void setTheatricalYear(String theatricalYear) {
		this.theatricalYear = theatricalYear;
	}

	public String getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(String releaseYear) {
		this.releaseYear = releaseYear;
	}

	public String getStreamingDate() {
		return streamingDate;
	}

	public void setStreamingDate(String streamingDate) {
		this.streamingDate = streamingDate;
	}

	public String getStreamingDateSoon() {
		return streamingDateSoon;
	}

	public void setStreamingDateSoon(String streamingDateSoon) {
		this.streamingDateSoon = streamingDateSoon;
	}

	public String getStreamingDisplay() {
		return streamingDisplay;
	}

	public void setStreamingDisplay(String streamingDisplay) {
		this.streamingDisplay = streamingDisplay;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getLanguages() {
		return languages;
	}

	public void setLanguages(String languages) {
		this.languages = languages;
	}

	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}

	public String getRecommendation() {
		return recommendation;
	}

	public void setRecommendation(String recommendation) {
		this.recommendation = recommendation;
	}

	public String getRecommended() {
		return recommended;
	}

	public void setRecommended(String recommended) {
		this.recommended = recommended;
	}
	
	
}
