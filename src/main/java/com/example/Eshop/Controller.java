package com.example.Eshop;
import com.example.Eshop.Dto.FakturaDto;
import com.example.Eshop.Service.FakturaService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/faktura") // URL cesta pre faktúry
public class Controller {

    private final FakturaService fakturaService;


    @Autowired
    public Controller(FakturaService fakturaService) {
        this.fakturaService = fakturaService;
    }


    @GetMapping("/{perId}")
    public FakturaDto getFaktura(@PathVariable long perId) {
        return fakturaService.getFaktura(perId);
    }


}
