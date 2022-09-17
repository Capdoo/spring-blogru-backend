package com.blogback.blog.posts.contents;

public class ParagraphsDTO {

    private long idParagraph;

    private long idHeader;

    private String content;

    private boolean isVisible;

    public ParagraphsDTO() {
    }

    public ParagraphsDTO(long idParagraph, long idHeader, String content, boolean isVisible) {
        this.idParagraph = idParagraph;
        this.idHeader = idHeader;
        this.content = content;
        this.isVisible = isVisible;
    }

    public long getIdParagraph() {
        return idParagraph;
    }

    public void setIdParagraph(long idParagraph) {
        this.idParagraph = idParagraph;
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
