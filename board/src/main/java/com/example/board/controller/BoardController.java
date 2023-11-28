package com.example.board.controller;

import com.example.board.dto.BoardDto;
import com.example.board.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.UriUtils;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.UUID;

@Controller
public class BoardController {

    @Autowired
    BoardMapper boardMapper;

    @Value("${fileDir}")
    String fileDir;

    @GetMapping("/board/list")
    public String getList(Model model) {
        model.addAttribute("cnt", boardMapper.getListCount());
        model.addAttribute("list", boardMapper.getList());
        return "board/list";
    }

    @GetMapping("/board/write")
    public String getWrite() {
        return "board/write";
    }

    @PostMapping("/board/write")
    public String setWrite(@ModelAttribute BoardDto boardDto, @RequestParam("file") MultipartFile mf) throws IOException {


        if(!mf.isEmpty()) {
            String folderName = new SimpleDateFormat("yyyyMMdd").format(System.currentTimeMillis());
//            File makeFolder = new File(fileDir + "/" + folderName);
            File makeFolder = new File(fileDir + folderName);

            if(!makeFolder.exists()) {
                makeFolder.mkdir();
            }

            String orgName = mf.getOriginalFilename();
            String ext = orgName.substring(orgName.lastIndexOf("."));
            String uuid = UUID.randomUUID().toString();
            String savedFileName = uuid + ext;
            String savedFilePathName = fileDir + folderName + "/" + savedFileName;

            // db에 넣기전에 객체에 넣어야 함
            // boardDto => db
            boardDto.setOrgName(orgName);
            boardDto.setSavedFileName(savedFileName);
            boardDto.setSavedFilePathName(savedFilePathName);
            boardDto.setSavedFileSize(mf.getSize());
            boardDto.setFolderName(folderName);
            boardDto.setExt(ext);

            // 파일 업로드 쓰기
            mf.transferTo(new File(savedFilePathName));
        }
        int maxGrp = boardMapper.getMaxGrp();
        boardDto.setGrp(maxGrp);

        boardMapper.setWrite(boardDto);

        return  "redirect:/board/list";
    }

    @GetMapping("/board/view")
    public String getView(@RequestParam int id, Model model) {
        boardMapper.updateVisit(id);

        model.addAttribute("view", boardMapper.getView(id));
        return "board/view";
    }

    @GetMapping("/download")
    public ResponseEntity<Resource> getDownload(@RequestParam String filename) throws MalformedURLException {

        UrlResource resource = new UrlResource("file:" + filename);
        String encodedFileName = UriUtils.encode(filename, StandardCharsets.UTF_8);
        String contentDisposition = "attachment; filename=\"" +encodedFileName+ "\"";

        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, contentDisposition).body(resource);
    }

}
