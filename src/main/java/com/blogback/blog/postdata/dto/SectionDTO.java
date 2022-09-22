package com.blogback.blog.postdata.dto;

import com.blogback.blog.postdata.elements.HeadersElement;
import com.blogback.blog.postdata.elements.ParagraphsElement;

import java.util.List;

public class SectionDTO {

    private int idSection;

    private long idPostData;

    private String nameSection;

    private List<HeadersElement> listHeaders;

    private List<ParagraphsElement> listParagraphs;

    private boolean isVisible;

    public SectionDTO() {
    }

    public SectionDTO(int idSection, long idPostData, String nameSection, List<HeadersElement> listHeaders, List<ParagraphsElement> listParagraphs, boolean isVisible) {
        this.idSection = idSection;
        this.idPostData = idPostData;
        this.nameSection = nameSection;
        this.listHeaders = listHeaders;
        this.listParagraphs = listParagraphs;
        this.isVisible = isVisible;
    }

    public int getIdSection() {
        return idSection;
    }

    public void setIdSection(int idSection) {
        this.idSection = idSection;
    }

    public long getIdPostData() {
        return idPostData;
    }

    public void setIdPostData(long idPostData) {
        this.idPostData = idPostData;
    }

    public String getNameSection() {
        return nameSection;
    }

    public void setNameSection(String nameSection) {
        this.nameSection = nameSection;
    }

    public List<HeadersElement> getListHeaders() {
        return listHeaders;
    }

    public void setListHeaders(List<HeadersElement> listHeaders) {
        this.listHeaders = listHeaders;
    }

    public List<ParagraphsElement> getListParagraphs() {
        return listParagraphs;
    }

    public void setListParagraphs(List<ParagraphsElement> listParagraphs) {
        this.listParagraphs = listParagraphs;
    }

    public boolean isVisible() {
        return isVisible;
    }

    public void setVisible(boolean visible) {
        isVisible = visible;
    }
}
