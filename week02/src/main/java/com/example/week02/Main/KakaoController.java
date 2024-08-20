package com.example.week02.Main;

import com.example.week02.Dtos.ProductDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class KakaoController {

    @GetMapping("/product")
    @ResponseBody
    public String productResponse(ProductDto dto) {
        return dto.toString();
    }

}


