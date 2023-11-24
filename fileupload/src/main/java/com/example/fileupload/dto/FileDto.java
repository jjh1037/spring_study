package com.example.fileupload.dto;

public class FileDto {

    private String oriName;
    private String saveFileName;
    private String savedPathFileName;
    private Long savedFileSize;

    public String getOriName() {
        return oriName;
    }

    public FileDto(String oriName, String saveFileName, String savedPathFileName, Long savedFileSize) {
        this.oriName = oriName;
        this.saveFileName = saveFileName;
        this.savedPathFileName = savedPathFileName;
        this.savedFileSize = savedFileSize;
    }

    public void setOriName(String oriName) {
        this.oriName = oriName;
    }

    public String getSaveFileName() {
        return saveFileName;
    }

    public void setSaveFileName(String saveFileName) {
        this.saveFileName = saveFileName;
    }

    public String getSavedPathFileName() {
        return savedPathFileName;
    }

    public void setSavedPathFileName(String savedPathFileName) {
        this.savedPathFileName = savedPathFileName;
    }

    public Long getSavedFileSize() {
        return savedFileSize;
    }

    public void setSavedFileSize(Long savedFileSize) {
        this.savedFileSize = savedFileSize;
    }
}
