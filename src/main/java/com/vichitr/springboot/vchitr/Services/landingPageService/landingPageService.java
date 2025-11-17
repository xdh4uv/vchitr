package com.vichitr.springboot.vchitr.Services.landingPageService;

import com.vichitr.springboot.vchitr.DTO.landingPageDTO.userLoginDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;


@Service
public interface landingPageService {

    String landingLogin(userLoginDTO userLoginDto);
}
