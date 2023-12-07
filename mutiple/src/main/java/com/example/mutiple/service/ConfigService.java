package com.example.mutiple.service;

import com.example.mutiple.dto.ConfigDto;
import com.example.mutiple.mapper.ConfigMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConfigService {

    @Autowired
    ConfigMapper configMapper;

    public int getCheckConfigCode(String configCode) { //controller

        return configMapper.getCheckConfigCode(configCode); // mapper
    }

    public void setConfig(ConfigDto configDto) {
        configMapper.setConfig(configDto);
    }

    public List<ConfigDto> getConfigList() {
        return configMapper.getConfigList();
    }

    public void getColorChange(int id, String color) {
        configMapper.getColorChange(id, color);
    }

    public void deleteConfig(String configCode) {
        configMapper.deleteConfig(configCode);
    }

    public void makeBoard(String configCode) {
        configMapper.makeBoard(configCode);
    }

    public void makeFile(String configCode) {
        configMapper.makeFile(configCode);
    }

    public void makeComment(String configCode) {
        configMapper.makeComment(configCode);
    }

    public void dropBoard(String configCode) {
        configMapper.dropBoard(configCode);
    }

    public void dropFile(String configCode) {
        configMapper.dropFile(configCode);
    }

    public void dropComment(String configCode) {
        configMapper.dropComment(configCode);
    }


}
