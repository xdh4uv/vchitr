package com.vichitr.springboot.vchitr.Controllers.LandingPage;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.vichitr.springboot.vchitr.DTO.landingPageDTO.userLoginDTO;
import com.vichitr.springboot.vchitr.Services.landingPageService.*;


@RestController
@RequestMapping("/welcome")
public class landingPageController {
    @PostMapping("/login")
    public ResponseEntity<?> landingLogin(@RequestBody userLoginDTO userLoginDto) {
        try {
            userLoginDTO response = landingPageService.landingLogin(userLoginDto);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
