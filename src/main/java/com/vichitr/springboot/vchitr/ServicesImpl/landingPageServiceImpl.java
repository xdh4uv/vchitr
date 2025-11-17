package com.vichitr.springboot.vchitr.ServicesImpl;
import com.vichitr.springboot.vchitr.DTO.landingPageDTO.userLoginDTO;
import com.vichitr.springboot.vchitr.Services.landingPageService.landingPageService;


public class landingPageServiceImpl implements landingPageService {

    @Override
    public String landingLogin(userLoginDTO userLoginDto){
        return "abc";
    }
}
