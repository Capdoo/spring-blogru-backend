package com.blogback.blog.postdata.elements;

public class HeadersElement {

    private int idHeader;

    private String content;

    private boolean isVisible;

    public HeadersElement() {
    }

    public HeadersElement(int idHeader, String content, boolean isVisible) {
        this.idHeader = idHeader;
        this.content = content;
        this.isVisible = isVisible;
    }

    public int getIdHeader() {
        return idHeader;
    }

    public void setIdHeader(int idHeader) {
        this.idHeader = idHeader;
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
}
