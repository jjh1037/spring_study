package com.example.fileupload.controller;

import com.example.fileupload.dto.FileDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
public class V2Controller {

    @Value("${fileDir}")
    String fileDir;

    @GetMapping("/v2/upload")
        public String getUpload() {
            return "v2/uploadForm";
        }

    @PostMapping("/v2/upload")
        public String setUpload(@RequestParam("files")List<MultipartFile> files, Model model) throws IOException {

        List<FileDto> list = new ArrayList<>();

        for(MultipartFile mf : files) {
            String oriName = mf.getOriginalFilename();
            String uuid = UUID.randomUUID().toString();
            String ext = oriName.substring(oriName.lastIndexOf("."));

            String saveFileName = uuid + ext;
            String savedPathFileName = fileDir + saveFileName;
            Long savedFileSize = mf.getSize();

//          File 주소 + 이름
            mf.transferTo(new File(savedPathFileName));
            list.add(new FileDto(oriName, saveFileName, savedPathFileName ,savedFileSize));
        }
        model.addAttribute("imgs", list);
        return "v2/uploadView";
    }


}
