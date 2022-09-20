package com.blogback.blog.postdata.dto;

public class HeaderDTO {

    private int idHeader;

    private long idPostData;

    private int idSection;

    private String content;

    private boolean isVisible;

    public HeaderDTO() {
    }

    public HeaderDTO(int idHeader, long idPostData, int idSection, String content, boolean isVisible) {
        this.idHeader = idHeader;
        this.idPostData = idPostData;
        this.idSection = idSection;
        this.content = content;
        this.isVisible = isVisible;
    }

    public int getIdHeader() {
        return idHeader;
    }

    public void setIdHeader(int idHeader) {
        this.idHeader = idHeader;
    }

    public int getIdSection() {
        return idSection;
    }

    public void setIdSection(int idSection) {
        this.idSection = idSection;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isVisible() {
        return isVisible;
    }

    public void setVisible(boolean visible) {
        isVisible = visible;
    }

    public long getIdPostData() {
        return idPostData;
    }

    public void setIdPostData(long idPostData) {
        this.idPostData = idPostData;
    }
}
