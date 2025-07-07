package com.example.demo.bja.board.service;

import com.example.demo.bja.board.entity.ShoppingBoard;
import com.example.demo.bja.board.repository.ShoppingBoardRepository;
import com.example.demo.bja.board.service.request.ShoppingBoardRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class ShoppingBoardServiceImple implements ShoppingBoardService {

    final private ShoppingBoardRepository shoppingBoardRepository;

    @Override
    public ShoppingBoard create(ShoppingBoardRequest shoppingBoardRequest) {
        log.info("create -> shoppingBoardRequest: {}",shoppingBoardRequest);
        ShoppingBoard shoppingBoard = shoppingBoardRequest.toShoppingBoardCreate();
        return shoppingBoardRepository.save(shoppingBoard);
    }

    @Override
    public ShoppingBoard findById(Long id) {
        log.info("findById -> shoppingBoardId: {}",id);
        Optional<ShoppingBoard> maybeShoppingBoard = shoppingBoardRepository.findById(id);
        if(maybeShoppingBoard.isEmpty()){
            return null;
        }
        return maybeShoppingBoard.get();
    }

    @Override
    public List<ShoppingBoard> findShoppingBoardAll() {
        log.info("ShoppingBoardAll");
        return shoppingBoardRepository.findAll();
    }

    @Override
    public ShoppingBoard update(ShoppingBoardRequest shoppingBoardRequest) {
        log.info("update -> shoppingBoardRequest: {}",shoppingBoardRequest);
        Long shoppingBoardId = shoppingBoardRequest.getId();

        Optional<ShoppingBoard> maybeShoppingBoard = shoppingBoardRepository.findById(shoppingBoardId);
        if(maybeShoppingBoard.isEmpty()){
            return null;
        }
        ShoppingBoard foundShoppingBoard = maybeShoppingBoard.get();
        foundShoppingBoard.setTitle(shoppingBoardRequest.getTitle());
        foundShoppingBoard.setContent(shoppingBoardRequest.getContent());

        return shoppingBoardRepository.save(foundShoppingBoard);
    }

    @Override
    public void delete(Long id) {
        log.info("delete -> shoppingBoardId: {}",id);
        shoppingBoardRepository.deleteById(id);
    }
}
