package com.blogback.blog.postdata.elements;

public class ParagraphsElement {

    private int idParagraph;

    private int idHeader;

    private String content;

    private boolean isVisible;

    public ParagraphsElement() {
    }

    public ParagraphsElement(int idParagraph, int idHeader, String content, boolean isVisible) {
        this.idParagraph = idParagraph;
        this.idHeader = idHeader;
        this.content = content;
        this.isVisible = isVisible;
    }

    public int getIdParagraph() {
        return idParagraph;
    }

    public void setIdParagraph(int idParagraph) {
        this.idParagraph = idParagraph;
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
