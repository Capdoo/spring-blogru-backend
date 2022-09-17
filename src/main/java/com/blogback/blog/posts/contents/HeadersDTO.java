package com.blogback.blog.posts.contents;

public class HeadersDTO {

    private long idHeader;

    private String content;

    private boolean isVisible;

    public HeadersDTO() {
    }

    public HeadersDTO(long idHeader, String content, boolean isVisible) {
        this.idHeader = idHeader;
        this.content = content;
        this.isVisible = isVisible;
    }

    public long getIdHeader() {
        return idHeader;
    }

    public void setIdHeader(long idHeader) {
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
