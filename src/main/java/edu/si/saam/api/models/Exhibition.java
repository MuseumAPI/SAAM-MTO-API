package edu.si.saam.api.models;

import java.sql.Blob;
import java.util.List;

/**
 * Created by richard on 7/11/16.
 */
public class Exhibition {
    private String exhibition_code;
    private String accession_number;
    private String headline;
    private String open_date;
    private String close_date;
    private String display_date;
    private byte permanent_exhibit;
    private int museum_id;
    private int gallery_id;
    private byte traveling;
    private String travel_beg_date;
    private String travel_end_date;
    private byte offered_for_tour;
    private String web_directory;
    private String saam_image;
    private String caption;
    private String related_constituent;
    private String relatedLinks;
    private String shortSummary;
    private String text;
    private String text_display;
    private String past_date;
    private byte publication;
    private String isbn_softcover;
    private String isbn_hardcover;
    private String publication_date;
    private String archive_date;
    private String location;
    private List<String> relatedWorks;
    private List<String> relatedPersons;
    private List<String> relatedPublications;
    private String subject_general;
    private String subject_specific;

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public byte getTraveling() {
        return traveling;
    }

    public void setTraveling(byte traveling) {
        this.traveling = traveling;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getRelatedLinks() {
        return relatedLinks;
    }

    public void setRelatedLinks(String relatedLinks) {
        this.relatedLinks = relatedLinks;
    }

    public String getShortSummary() {
        return shortSummary;
    }

    public void setShortSummary(String shortSummary) {
        this.shortSummary = shortSummary;
    }

    public List<String> getRelatedWorks() {
        return relatedWorks;
    }

    public void setRelatedWorks(List<String> relatedWorks) {
        this.relatedWorks = relatedWorks;
    }

    public List<String> getRelatedPersons() {
        return relatedPersons;
    }

    public void setRelatedPersons(List<String> relatedPersons) {
        this.relatedPersons = relatedPersons;
    }

    public List<String> getRelatedPublications() {
        return relatedPublications;
    }

    public void setRelatedPublications(List<String> relatedPublications) {
        this.relatedPublications = relatedPublications;
    }

    public String getExhibition_code() {
        return exhibition_code;
    }

    public void setExhibition_code(String exhibition_code) {
        this.exhibition_code = exhibition_code;
    }

    public String getAccession_number() {
        return accession_number;
    }

    public void setAccession_number(String accession_number) {
        this.accession_number = accession_number;
    }

    public String getOpen_date() {
        return open_date;
    }

    public void setOpen_date(String open_date) {
        this.open_date = open_date;
    }

    public String getClose_date() { return close_date; }

    public void setClose_date(String close_date) {
        this.close_date = close_date;
    }

    public String getDisplay_date() {
        return display_date;
    }

    public void setDisplay_date(String display_date) {
        this.display_date = display_date;
    }

    public byte getPermanent_exhibit() {
        return permanent_exhibit;
    }

    public void setPermanent_exhibit(byte permanent_exhibit) {
        this.permanent_exhibit = permanent_exhibit;
    }

    public int getMuseum_id() {
        return museum_id;
    }

    public void setMuesum_id(int museum_id) {
        this.museum_id = museum_id;
    }

    public int getGallery_id() {
        return gallery_id;
    }

    public void setGallery_id(int gallery_id) {
        this.gallery_id = gallery_id;
    }

    public String getTravel_beg_date() {
        return travel_beg_date;
    }

    public void setTravel_beg_date(String travel_beg_date) {
        this.travel_beg_date = travel_beg_date;
    }

    public String getTravel_end_date() {
        return travel_end_date;
    }

    public void setTravel_end_date(String travel_end_date) {
        this.travel_end_date = travel_end_date;
    }

    public byte getOffered_for_tour() { return offered_for_tour; }

    public void setOffered_for_tour(byte offered_for_tour) {
        this.offered_for_tour = offered_for_tour;
    }

    public String getWeb_directory() {
        return web_directory;
    }

    public void setWeb_directory(String web_directory) {
        this.web_directory = web_directory;
    }

    public String getSaam_image() {
        return saam_image;
    }

    public void setSaam_image(String saam_image) {
        this.saam_image = saam_image;
    }

    public String getRelated_constituent() {
        return related_constituent;
    }

    public void setRelated_constituent(String related_constituent) {
        this.related_constituent = related_constituent;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getText_display() {
        return text_display;
    }

    public void setText_display(String text_display) {
        this.text_display = text_display;
    }

    public String getPast_date() {
        return past_date;
    }

    public void setPast_date(String past_date) {
        this.past_date = past_date;
    }

    public byte getPublication() {
        return publication;
    }

    public void setPublication(byte publication) {
        this.publication = publication;
    }

    public String getIsbn_softcover() {
        return isbn_softcover;
    }

    public void setIsbn_softcover(String isbn_softcover) {
        this.isbn_softcover = isbn_softcover;
    }

    public String getIsbn_hardcover() {
        return isbn_hardcover;
    }

    public void setIsbn_hardcover(String isbn_hardcover) {
        this.isbn_hardcover = isbn_hardcover;
    }

    public String getPublication_date() {
        return publication_date;
    }

    public void setPublication_date(String publication_date) {
        this.publication_date = publication_date;
    }

    public String getArchive_date() {
        return archive_date;
    }

    public void setArchive_date(String archive_date) {
        this.archive_date = archive_date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSubject_general() { return this.subject_general; }

    public void setSubject_general( String subject_general ) { this.subject_general = subject_general; }

    public String getSubject_specific() { return this.subject_specific; }

    public void setSubject_specific( String subject_specific ) { this.subject_specific = subject_specific; }

}
