package com.lawmate.personalproject.user;

import com.lawmate.personalproject.common.component.Messenger;
import com.lawmate.personalproject.user.model.UserDto;
import com.lawmate.personalproject.user.service.UserServiceImpl;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequiredArgsConstructor
@ApiResponses(value = {
        @ApiResponse(responseCode = "400", description = "Invalid ID supplied"),
        @ApiResponse(responseCode = "404", description = "Customer not found")})
@RequestMapping("api/users")
@Slf4j
public class UserController {
    private final UserServiceImpl service;

    @PostMapping(path = "/save")
    public ResponseEntity<Messenger> save(@RequestBody UserDto param) {
        log.info("입력받은 User 정보 : { }" + param);
        return ResponseEntity.ok(service.save(param));
    }
    @GetMapping("/list")
    public ResponseEntity<List<UserDto>> findAll() {
        log.info("입력받은 User 정보 : { }"+service.findAll().toString());
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/detail")
    public ResponseEntity<UserDto> findById(@RequestParam("id") Long id) {
        log.info("입력받은 User 정보 : { }" + id);
        return ResponseEntity.ok(service.findById(id).orElseGet(UserDto::new));
    }
    @DeleteMapping("/delete")
    public ResponseEntity<Messenger> deleteById(@RequestParam("id") Long id){
        log.info("입력받은 UserDelete 정보 : { }" + id);
        return ResponseEntity.ok(service.deleteById(id));
    }
    @GetMapping("/count")
    public ResponseEntity<Long> count(){
        return ResponseEntity.ok(service.count());
    }

    @PutMapping("/modify")
    public ResponseEntity<Messenger> modify(@RequestBody UserDto param) {
        log.info("입력받은 User 정보 : { }" + param);
        return ResponseEntity.ok(service.modify(param));
    }

    @GetMapping("/logout")
    public ResponseEntity<Boolean> logout(@RequestHeader("Authorization") String accessToken){
        log.info("1- logout request : {}", accessToken);
        var flag = service.logout(accessToken); // 토큰이 있으면 false, 없으면 true
        return ResponseEntity.ok(flag);
    }

    @PostMapping("/update")
    public ResponseEntity<Messenger> update(@RequestBody UserDto param){
        log.info("입력받은 정보 : {}", param );
        return ResponseEntity.ok(service.update(param));
    }

    //    @GetMapping("/list")
//    public ResponseEntity<List<UserDto>> getUsersById() {
//        log.info("입력받은 User 정보 : { }"+service.getUsersById().toString());
//        return ResponseEntity.ok(service.getUsersById());
//    }
}
