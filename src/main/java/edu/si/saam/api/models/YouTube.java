package edu.si.saam.api.models;

import java.sql.Timestamp;

/**
 * Created by Kaylin on 9/24/16.
 */
public class YouTube {

    public String id;
    public String url;
    public String relatedConstituent;
    public String exhibitionCode;
    public Timestamp uploadDate;
    public String title;
    public String thumbnail;
    public String isbnNoSoftcover;
    public String isbnNoHardcover;
    public String subjectGeneral;
    public String subjectSpecific;
    public String description;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getRelatedConstituent() {
        return relatedConstituent;
    }

    public void setRelatedConstituent(String relatedConstituent) {
        this.relatedConstituent = relatedConstituent;
    }

    public String getExhibitionCode() {
        return exhibitionCode;
    }

    public void setExhibitionCode(String exhibitionCode) {
        this.exhibitionCode = exhibitionCode;
    }

    public Timestamp getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(Timestamp uploadDate) {
        this.uploadDate = uploadDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getIsbnNoSoftcover() {
        return isbnNoSoftcover;
    }

    public void setIsbnNoSoftcover(String isbnNoSoftcover) {
        this.isbnNoSoftcover = isbnNoSoftcover;
    }

    public String getPagesIsbnNoHardcover() {
        return isbnNoHardcover;
    }

    public void setIsbnnoHardcover(String isbnNoHardcover) {
        this.isbnNoHardcover = isbnNoHardcover;
    }

    public String getSubjectGeneral() {
        return subjectGeneral;
    }

    public void setSubjectGeneral(String subjectGeneral) {
        this.subjectGeneral = subjectGeneral;
    }

    public String getSubjectSpecific() {
        return subjectSpecific;
    }

    public void setSubjectSpecific(String subjectSpecific) {
        this.subjectSpecific = subjectSpecific;
    }

    public String getDescription() { return description; }

    public void setDescription(String description) {
        this.description = description;
    }
}