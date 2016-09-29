package edu.si.saam.api.models;

/**
 * POJO representation of a Smithsonian American Art Museum Publication.
 *
 * Created by richard on 4/20/16.
 */
public class Publication {

    public int id;
    public String actionType;

    public String getActionType() {
        return actionType;
    }

    public void setActionType(String actionType) {
        this.actionType = actionType;
    }

    public String type;
    public String internalTitle;
    public String author;
    public String publisher;
    public String exhibitionCode;
    public String bookTitleDisplay;
    public String authorDisplay;
    public String coPublisherDisplay;
    public String blurbText;
    public String pages;
    public String IsbnNoHardcover;
    public String IsbnNoSoftcover;
    public int yearPublished;
    public String dimensions;
    public String subjectType;
    public String relatedConstituent;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getInternalTitle() {
        return internalTitle;
    }

    public void setInternalTitle(String internalTitle) {
        this.internalTitle = internalTitle;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getExhibitionCode() {
        return exhibitionCode;
    }

    public void setExhibitionCode(String exhibitionCode) {
        this.exhibitionCode = exhibitionCode;
    }

    public String getBookTitleDisplay() {
        return bookTitleDisplay;
    }

    public void setBookTitleDisplay(String bookTitleDisplay) {
        this.bookTitleDisplay = bookTitleDisplay;
    }

    public String getAuthorDisplay() {
        return authorDisplay;
    }

    public void setAuthorDisplay(String authorDisplay) {
        this.authorDisplay = authorDisplay;
    }

    public String getCoPublisherDisplay() {
        return coPublisherDisplay;
    }

    public void setCoPublisherDisplay(String coPublisherDisplay) {
        this.coPublisherDisplay = coPublisherDisplay;
    }

    public String getBlurbText() {
        return blurbText;
    }

    public void setBlurbText(String blurbText) {
        this.blurbText = blurbText;
    }

    public String getPages() {
        return pages;
    }

    public void setPages(String pages) {
        this.pages = pages;
    }

    public String getIsbnNoHardcover() {
        return IsbnNoHardcover;
    }

    public void setIsbnNoHardcover(String IsbnNoHardcover) {
        this.IsbnNoHardcover = IsbnNoHardcover;
    }

    public String getIsbnNoSoftcover() {
        return IsbnNoSoftcover;
    }

    public void setIsbnNoSoftcover(String IsbnNoSoftcover) {
        this.IsbnNoSoftcover = IsbnNoSoftcover;
    }

    public int getYearPublished() {
        return yearPublished;
    }

    public void setYearPublished(int yearPublished) {
        this.yearPublished = yearPublished;
    }

    public String getDimensions() {
        return dimensions;
    }

    public void setDimensions(String dimensions) {
        this.dimensions = dimensions;
    }

    public String getSubjectType() {
        return subjectType;
    }

    public void setSubjectType(String subjectType) {
        this.subjectType = subjectType;
    }

    public String getRelatedConstituent() {
        return relatedConstituent;
    }

    public void setRelatedConstituent(String relatedConstituent) {
        this.relatedConstituent = relatedConstituent;
    }
}
