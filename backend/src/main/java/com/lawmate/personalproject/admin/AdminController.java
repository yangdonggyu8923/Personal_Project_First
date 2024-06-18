package com.lawmate.personalproject.admin;

import com.lawmate.personalproject.admin.service.AdminServiceImpl;
import com.lawmate.personalproject.common.component.Messenger;
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
@RequestMapping("api/admins")
@Slf4j
public class AdminController {
    private final AdminServiceImpl service;


    @DeleteMapping("/delete-user")
    public ResponseEntity<Messenger> deleteByuserId(@RequestParam("id") Long id){
        log.info("입력받은 Lawyer 정보 : { }" + id);
        return ResponseEntity.ok(service.deleteByuserId(id));
    }

    @DeleteMapping("/delete-lawyer")
    public ResponseEntity<Messenger> deleteBylawyerId(@RequestParam("id") Long id){
        log.info("입력받은 Lawyer 정보 : { }" + id);
        return ResponseEntity.ok(service.deleteBylawyerId(id));
    }
}
