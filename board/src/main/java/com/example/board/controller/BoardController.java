package com.example.board.controller;

import com.example.board.dto.BoardDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@Controller
public class BoardController {

    @Value("${fileDir}")
    String fileDir;

    @GetMapping("/board/list")
    public String getList() {
        return "board/list";
    }

    @GetMapping("/board/write")
    public String getWrite() {
        return "board/write";
    }

    @PostMapping("/board/write")
    public String setWrite(@ModelAttribute BoardDto boardDto, @RequestParam("file") MultipartFile mf) {
        String orgName = mf.getOriginalFilename();
        String ext = orgName.substring(orgName.lastIndexOf("."));
        String uuid = UUID.randomUUID().toString();

        String savedFileName = uuid + ext;
        String savedFilePathName = fileDir + savedFileName;

        // db에 넣기전에 객체에 넣어야 함
        boardDto.setOrgName(orgName);
        boardDto.setSavedFileName(savedFileName);
        boardDto.setSavedFilePathName(savedFilePathName);
        boardDto.setSavedFileSize(mf.getSize());

        System.out.println(boardDto.toString());
        return  "redirect:/board/list";
    }
}
