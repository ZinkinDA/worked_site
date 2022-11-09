package com.example.demo.controllers;

import com.example.demo.model.Role;
import com.example.demo.model.User;
import com.example.demo.model.dto.UserDTO;
import com.example.demo.service.Role.RoleService;
import com.example.demo.service.User.UserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/account")
public class UserRestController {

    private final UserService userService;

    private final RoleService roleService;

    public UserRestController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }
    @ApiOperation(value = "Получение профиля пользователей(UserDTO)")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Пользователь по id получен."),
            @ApiResponse(code = 400, message = "Введите id пользователя.\n" +
                    "Пока мы разрабатываем без spring security,в будущем это будет страница авторизованного ползователя."),
            @ApiResponse(code = 404, message = "Пользователь не найден")})
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
    @ApiOperation(value = "Получение всех пользователей (UserDTO)")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Пользователи получены."),
            @ApiResponse(code = 400, message = "Пользователей у сайта нет")})
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

    @ApiOperation(value = "Регистрация аккаунта.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Пользователь зарегистрирован"),
            @ApiResponse(code = 400, message = "Пользователь не создан."),
            @ApiResponse(code = 424, message = "Присваиваемой Роли не существует")})
    @PostMapping("/registration")
    public ResponseEntity<?> registrationAccount(@RequestBody UserDTO userDTO){
        Optional<Role> standartRole = roleService.findAll().stream().filter(x -> x.getName().equals("CLIENT")).findFirst();
        if(standartRole.isPresent()) {
            if (userDTO.getRole() != null && userDTO.getEmail() != null
                    && userDTO.getName() != null && userDTO.getSurname() != null
                    && userDTO.getPassword() != null) {
                User user = User.builder()
                        .role(standartRole.get())
                        .name(userDTO.getName())
                        .surname(userDTO.getSurname())
                        .email(userDTO.getEmail())
                        .password(userDTO.getPassword())
                        .executed(new ArrayList<>())
                        .ordersList(new ArrayList<>())
                        .Reputation(0L)
                        .build();
                userService.saveUser(user);
                return ResponseEntity.ok().body("Пользователь создан успешно");
            }
            return ResponseEntity.badRequest().body("Пользователь не создан.");
        }
        return ResponseEntity.status(424).body("Присваемой пользователю роли не существует.");
    }
    @ApiOperation(value = "Удаление аккаунта.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Пользователь удален"),
            @ApiResponse(code = 400, message = "Пользователя не существует")})
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteAccount(@PathVariable Long id){
        Optional<User> user = userService.findById(id);
        if(user.isPresent()) {
            userService.deleteAccount(id);
            return ResponseEntity.ok().body("Аккаунт удaлен.");
        }
        return ResponseEntity.badRequest().body("Пользователя и так не существует.");
    }

}
