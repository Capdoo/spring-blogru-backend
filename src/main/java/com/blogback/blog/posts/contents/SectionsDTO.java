package com.blogback.blog.posts.contents;

import java.util.List;

public class SectionsDTO {

    private long idSection;

    private String nameSection;

    private boolean isVisibleName;

    private List<HeadersDTO> listHeaders;

    private List<ParagraphsDTO> listParagraphs;

    public SectionsDTO() {
    }

    public SectionsDTO(long idSection, String nameSection, boolean isVisibleName, List<HeadersDTO> listHeaders, List<ParagraphsDTO> listParagraphs) {
        this.idSection = idSection;
        this.nameSection = nameSection;
        this.isVisibleName = isVisibleName;
        this.listHeaders = listHeaders;
        this.listParagraphs = listParagraphs;
    }

    public long getIdSection() {
        return idSection;
    }

    public void setIdSection(long idSection) {
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

    public List<HeadersDTO> getListHeaders() {
        return listHeaders;
    }

    public void setListHeaders(List<HeadersDTO> listHeaders) {
        this.listHeaders = listHeaders;
    }

    public List<ParagraphsDTO> getListParagraphs() {
        return listParagraphs;
    }

    public void setListParagraphs(List<ParagraphsDTO> listParagraphs) {
        this.listParagraphs = listParagraphs;
    }
}
