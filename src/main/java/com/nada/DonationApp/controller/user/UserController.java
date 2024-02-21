package com.nada.DonationApp.controller.user;

import com.nada.DonationApp.entity.UserEntity;
import com.nada.DonationApp.repository.UserRepository;
import com.nada.DonationApp.service.user.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    private final UserService userService;
    private final UserRepository userRepository;

    public UserController(UserService userService, UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserEntity> getUserInfo(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

//    @PutMapping("/update")
//    public ResponseEntity<String> updateUser(@RequestParam Long userId, @RequestBody UpdateUserRequest updateUserStatusRequest) {
//        try {
//            userService.updateUserStatus(userId, updateUserStatusRequest);
//
//
//        } catch (IllegalArgumentException e) {
////            System.out.println("Error please write ACTIVE or INACTIVE");
//            return ResponseEntity.badRequest().body("Error");
//        }
//        return ResponseEntity.ok("A User Has Been Updated");
//    }

//    @GetMapping("/profile")
//    public ResponseEntity<UserProfileResponse> getUserProfile(@RequestParam Long userId) {
//        UserProfileResponse userInfo = userService.getUserInfo(userId);
//        return ResponseEntity.ok(userInfo);
//    }
}

