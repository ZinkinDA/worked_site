package com.example.demo.controllers;

import com.example.demo.model.User;
import com.example.demo.model.dto.UserDTO;
import com.example.demo.service.User.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/account")
public class UserRestController {

    private final UserService userService;

    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/profile")
    public ResponseEntity<?> getAccountProfile(@RequestParam(required = false) Long id){
        if(id == null){
            return ResponseEntity.badRequest().body("Введите id пользователя.\n" +
                    " Пока мы разрабатываем без spring security,в будущем это будет страница авторизованного ползователя.");
        }
        Optional<User> optionalUser = userService.findById(id);
        if(optionalUser.isPresent()){
            UserDTO userDTO = UserDTO.builder()
                    .id(optionalUser.get().getId())
                    .name(optionalUser.get().getName())
                    .surname(optionalUser.get().getSurname())
                    .email(optionalUser.get().getEmail())
                    .role(optionalUser.get().getRole().getName())
                    .Reputation(optionalUser.get().getReputation())
                    .build();
            return ResponseEntity.ok(userDTO);
        }
        return ResponseEntity.status(404).body("Пользователь не найден");
    }

    @GetMapping("/users")
    public ResponseEntity<?> getAllAccount(){
        List<User> listUser = userService.findAll();
        if(!listUser.isEmpty()){
           List<UserDTO> dtoList = new ArrayList<>();
            for (User user:listUser) {
                dtoList.add(UserDTO.builder()
                                .id(user.getId())
                                .name(user.getName())
                                .surname(user.getSurname())
                                .email(user.getEmail())
                                .role(user.getRole().getName())
                                .Reputation(user.getReputation())
                            .build());
            }
            return ResponseEntity.ok().body(dtoList);
        }
        return ResponseEntity.badRequest().body("Пользователей у сайта нет.");
    }
}
