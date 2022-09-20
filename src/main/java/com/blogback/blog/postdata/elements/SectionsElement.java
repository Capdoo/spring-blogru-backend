package com.blogback.blog.postdata.elements;

import java.util.List;

public class SectionsElement {

    private int idSection;

    private String nameSection;

    private boolean isVisibleName;

    private List<HeadersElement> listHeaders;

    private List<ParagraphsElement> listParagraphs;

    public SectionsElement() {
    }

    public SectionsElement(int idSection, String nameSection, boolean isVisibleName, List<HeadersElement> listHeaders, List<ParagraphsElement> listParagraphs) {
        this.idSection = idSection;
        this.nameSection = nameSection;
        this.isVisibleName = isVisibleName;
        this.listHeaders = listHeaders;
        this.listParagraphs = listParagraphs;
    }

    public int getIdSection() {
        return idSection;
    }

    public void setIdSection(int idSection) {
        this.idSection = idSection;
    }

    public String getNameSection() {
        return nameSection;
    }

    public void setNameSection(String nameSection) {
        this.nameSection = nameSection;
    }

    public boolean isVisibleName() {
        return isVisibleName;
    }

    public void setVisibleName(boolean visibleName) {
        isVisibleName = visibleName;
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
}
