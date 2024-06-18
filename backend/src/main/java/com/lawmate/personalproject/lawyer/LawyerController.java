package com.lawmate.personalproject.lawyer;
import com.lawmate.personalproject.common.component.Messenger;
import com.lawmate.personalproject.lawyer.model.LawyerDto;
import com.lawmate.personalproject.lawyer.service.LawyerServiceImpl;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequiredArgsConstructor
@ApiResponses(value = {
        @ApiResponse(responseCode = "400", description = "Invalid ID supplied"),
        @ApiResponse(responseCode = "404", description = "Customer not found")})
@RequestMapping("api/lawyers")
@Slf4j
public class LawyerController {

    private final LawyerServiceImpl service;

    @PostMapping(path = "/save")
    public ResponseEntity<Messenger> save(@RequestBody LawyerDto lawyerDto) {
        log.info("입력받은 Lawyer 정보 : { }" + lawyerDto);
        return ResponseEntity.ok(service.save(lawyerDto));
    }
    @GetMapping("/list")
    public ResponseEntity<List<LawyerDto>> findAll() {
        log.info("입력받은 Lawyer 정보 : { }" + service.findAll().toString());
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/crawl")
    public ResponseEntity<Messenger> crawl() throws IOException {
        log.info("크롤링 실행");
        service.crawl();
        return ResponseEntity.ok(Messenger.builder().message("SUCCESS").build());
    }
    @GetMapping("/count")
    public ResponseEntity<Long> count(){
        return ResponseEntity.ok(service.count());
    }

    @PutMapping("/modify")
    public ResponseEntity<Messenger> modify(@RequestBody LawyerDto lawyerDto) {
        log.info("입력받은 Lawyer 정보 : { }" + lawyerDto);
        return ResponseEntity.ok(service.modify(lawyerDto));
    }
    @GetMapping("/detail")
    public ResponseEntity<LawyerDto> findById(@RequestParam("id") Long id) {
        log.info("입력받은 Lawyer 정보 : { }" + id);
        return ResponseEntity.ok(service.findById(id).orElseGet(LawyerDto::new));
    }
    @DeleteMapping("/delete")
    public ResponseEntity<Messenger> deleteById(@RequestParam("id") Long id){
        log.info("입력받은 Lawyer 정보 : { }" + id);
        return ResponseEntity.ok(service.deleteById(id));
    }

    @PostMapping("/update")
    public ResponseEntity<Messenger> update(@RequestBody LawyerDto param){
        log.info("입력받은 정보 : {}", param );
        return ResponseEntity.ok(service.update(param));
    }

    @GetMapping("/logout")
    public ResponseEntity<Boolean> logout(@RequestHeader("Authorization") String accessToken){
        log.info("1- logout request : {}", accessToken);
        var flag = service.logout(accessToken); // 토큰이 있으면 false, 없으면 true
        return ResponseEntity.ok(flag);
    }

//    @GetMapping("/list")
//    public ResponseEntity<List<LawyerDto>> getLawyersById() {
//        log.info("입력받은 Lawyer 정보 : { }" + service.getLawyersById().toString());
//        return ResponseEntity.ok(service.getLawyersById());
//    }
}
