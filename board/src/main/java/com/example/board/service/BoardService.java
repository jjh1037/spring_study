package com.example.board.service;

import com.example.board.dto.BoardDto;
import com.example.board.mappers.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BoardService {

    @Autowired
    BoardMapper boardMapper;

    public List<BoardDto> getSearch(String searchType, String words) {

        Map<String, Object> map = new HashMap<>();

        String searchQuery = "";
        if( searchType.equals("subject") || searchType.equals("writer") ) {
            searchQuery = "WHERE " + searchType + " = '" + words + "'";

        }else if( searchType.equals("content") ) {
            searchQuery = "WHERE " + searchType + " LIKE '%"+words+"%'";

        }else {
            searchQuery = "";
        }

        map.put("searchQuery", searchQuery);

        return boardMapper.getList(map);

    }

    public int getSearchCnt(String searchType, String words) {

        Map<String, Object> map = new HashMap<>();

        String searchQuery = "";
        if( searchType.equals("subject") || searchType.equals("writer") ) {
            searchQuery = "WHERE " + searchType + " = '" + words + "'";

        }else if( searchType.equals("content") ) {
            searchQuery = "WHERE " + searchType + " LIKE '%"+words+"%'";

        }else {
            searchQuery = "";
        }

        map.put("searchQuery", searchQuery);
        return boardMapper.getListCount(map);

    }

    public void setDelete(int id) {
        if( id > 0 ) {
            BoardDto bd = boardMapper.getView(id);
            boardMapper.setDelete(id);

            String removeFile = bd.getSavedFilePathName();
            if(removeFile != null) {
                File f = new File(removeFile);
                if( f.exists() ) {
                    f.delete();
                }
            }
        }
    }
}
