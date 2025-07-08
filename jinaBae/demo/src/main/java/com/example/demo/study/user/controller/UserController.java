package com.example.demo.study.user.controller;

import com.example.demo.study.user.controller.request.SignInRequest;
import com.example.demo.study.user.controller.request.SignUpRequest;
import com.example.demo.study.user.controller.request.UpdateRequest;
import com.example.demo.study.user.entity.User;
import com.example.demo.study.user.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {
    @Autowired
    private UserRepository userRepository;

    // 이것을 가지고 회원가입, 로그인, 탈퇴, 비밀 번호 변경
    @PostMapping("/sign-up")
    public User signUp(@RequestBody SignUpRequest request){
        log.info("signUp() -> request: {}", request);

        User userRequest = request.toUser();
        return userRepository.save(userRequest);
    }

    @PostMapping("/sign-in")
    public Boolean login(@RequestBody SignInRequest request){
        log.info("signIp() -> request: {}", request);

        String userId = request.getUserId();
        Optional<User> maybeUser = userRepository.findByUserId(userId);
        if (maybeUser.isEmpty()){
            log.info("signIn() -> 아이디 없음");
            return Boolean.FALSE;
        }

        User user = maybeUser.get();
        String encryptedUserPassword = user.getPassword();
        Boolean loginSuccess = request.checkPassword(encryptedUserPassword);
        if (!loginSuccess){
            log.info("signIn() -> 암호 불일치");
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    @GetMapping("/delete")
    public void delete(@RequestParam("id") Long id){
        log.info("delete: {}",id);
        userRepository.deleteById(id);
    }

    @PostMapping("/password-update")
    public User passwordUpdate(@RequestBody UpdateRequest request){
        log.info("password-update: {}",request);

        String userId = request.getUserId();
        String password = request.getPassword();
        Optional<User> maybeUser = userRepository.findByUserIdAndPassword(userId, password);
        if (maybeUser.isEmpty()){
            return null;
        }
        User foundUser = maybeUser.get();
        foundUser.setPassword(request.getPassword());
        return userRepository.save(foundUser);
    }
}
