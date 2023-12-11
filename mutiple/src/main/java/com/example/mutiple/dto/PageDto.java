package com.example.mutiple.dto;


public class PageDto {
    private int startNum;
    private int pageCount = 10;
    private int blockCount = 5;
    private int page; // 현재 페이지 수
    private int totalPage; // 전체 페이지 수
    private int startPage; // 시작 페이지
    private int endPage; // 끝 페이지 < > 때문에 필요함

    public int getStartNum() {
        return startNum;
    }

    public void setStartNum(int startNum) {
        this.startNum = startNum;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getBlockCount() {
        return blockCount;
    }

    public void setBlockCount(int blockCount) {
        this.blockCount = blockCount;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getStartPage() {
        return startPage;
    }

    public void setStartPage(int startPage) {
        this.startPage = startPage;
    }

    public int getEndPage() {
        return endPage;
    }

    public void setEndPage(int endPage) {
        this.endPage = endPage;
    }

    @Override
    public String toString() {
        return "PageDto{" +
                "startNum=" + startNum +
                ", pageCount=" + pageCount +
                ", blockCount=" + blockCount +
                ", page=" + page +
                ", totalPage=" + totalPage +
                ", startPage=" + startPage +
                ", endPage=" + endPage +
                '}';
    }
}
