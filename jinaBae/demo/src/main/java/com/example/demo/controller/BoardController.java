package com.example.demo.controller;

import com.example.demo.controller.request.BoardRequest;
import com.example.demo.controller.request.FindBoardRequest;
import com.example.demo.controller.request.UpdateBoardRequest;
import com.example.demo.entity.Board;
import com.example.demo.repository.BoardRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
public class BoardController {

    @Autowired
    private BoardRepository boardRepository;

    @GetMapping("/board/test")
    public Board JustCreateBoard(){
        return new Board("title", "content");
    }

    @PostMapping("/board/create")
    public Board createBoard(@RequestBody BoardRequest request){
        log.info("createBoard -> request: {}", request);
        Board boardRequest = request.toBoard();

        return boardRepository.save(boardRequest);
    }
    @PostMapping("/board/find")
    public Board findBoard(@RequestBody FindBoardRequest request){
        Long boardId = request.getBoardId();
        // JpaRepository에 해당하는 인터페이에서
        // findById()를 하면 실제 DB 테이블에서 id 값에 해당하는 정보를 검색해서 가져옵니다.
        // 이 때 데이터가 존재하지 않을 수 있기 때문에 Optional<Entity> 형태로 표현합니다.
        // 그래서 변수 이름은 maybeBoard 이기도 합니다.
        Optional<Board> maybeBoard = boardRepository.findById(boardId);

        // 만약 정말 아무것도 없다면
        if(maybeBoard.isEmpty()){
            // 그냥 아무것도 하지 말아라
            return null;
        }

        // 실제 존재한다면 해당 정보(Board)를 리턴해라.
        return maybeBoard.get();
    }
    @GetMapping("/board/read/{id}")
    public Board readBoard(@PathVariable Long id){
        log.info("readBoard -> id: {}", id);
        Optional<Board> maybeBoard = boardRepository.findById(id);
        if(maybeBoard.isEmpty()){
            return null;
        }
        return maybeBoard.get();
    }

    @GetMapping("/board/list")
    public List<Board> readAllBoards(){
        log.info("List boards");
        // 전체 정보 조회에는 findAll()을 사용합니다.
        return boardRepository.findAll();
    }

    @GetMapping("/board/delete")
    public void deleteBoard(@RequestParam Long boardId){
        // @RequestParam 을 통해 URL을 통해 boardId를 전달할 수 있습니다.
        log.info("deleteBoard -> id: {}", boardId);

        //특정 id 값(pk)을 기반으로 정보 삭제
        boardRepository.deleteById(boardId);
    }

    @PostMapping("/board/update")
    public Board updateBoard(@RequestBody UpdateBoardRequest request){
        log.info("updateBoard -> request: {}", request);
        Long boardId = request.getBoardId();

        Optional<Board> maybeBoard = boardRepository.findById(boardId);
        if(maybeBoard.isEmpty()){
            return null;
        }
        Board foundBoard = maybeBoard.get();
        foundBoard.setTitle(request.getTitle());
        foundBoard.setContent(request.getContent());

        return boardRepository.save(foundBoard);
    }

}
