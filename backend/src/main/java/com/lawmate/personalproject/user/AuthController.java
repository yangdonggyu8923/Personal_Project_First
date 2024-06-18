package com.lawmate.personalproject.user;

import com.lawmate.personalproject.common.component.Messenger;
import com.lawmate.personalproject.lawyer.model.LawyerDto;
import com.lawmate.personalproject.lawyer.service.LawyerServiceImpl;
import com.lawmate.personalproject.user.model.UserDto;
import com.lawmate.personalproject.user.service.UserServiceImpl;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequiredArgsConstructor
@ApiResponses(value = {
        @ApiResponse(responseCode = "400", description = "Invalid ID supplied"),
        @ApiResponse(responseCode = "404", description = "Customer not found")})
@RequestMapping(path = "/api/auth")
@Slf4j
public class AuthController {

    private final UserServiceImpl service;
    private final LawyerServiceImpl lawyerService;

    @PostMapping("/login")
    public ResponseEntity<Messenger> login(@RequestBody UserDto param) {
        log.info("로그인 컨트롤러에 들어온 파라미터 : " + param);
        return ResponseEntity.ok(service.login(param));
    }

    @PostMapping("/llogin")
    public ResponseEntity<Messenger> lawLogin(@RequestBody LawyerDto param) {
        log.info("변호사 로그인 컨트롤러에 들어온 파라미터 : " + param);
        return ResponseEntity.ok(lawyerService.login(param));
    }

    @GetMapping("/exists-username")
    public ResponseEntity<Boolean> existsByUsername(@RequestParam("username") String username) {
        log.info("existsByUsername 파라미터 : " + username);
        return ResponseEntity.ok(service.existsByUsername(username));
    }

    @GetMapping("/exists-law-username")
    public ResponseEntity<Boolean> existsByLawUsername(@RequestParam("username") String username) {
        log.info("existsByUsername 파라미터 : " + username);
        return ResponseEntity.ok(lawyerService.existsByUsername(username));
    }


}