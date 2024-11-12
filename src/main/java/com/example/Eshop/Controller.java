package com.example.Eshop;
import com.example.Eshop.Dto.FakturaDto;
import com.example.Eshop.Service.FakturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/faktura")
public class Controller {

    private final FakturaService fakturaService;


    @Autowired
    public Controller(FakturaService fakturaService) {
        this.fakturaService = fakturaService;
    }


    @GetMapping("history/{perId}")
    public FakturaDto getFakturaHistory(@PathVariable long perId) {
        return fakturaService.getFakturaHistory(perId);
    }


}
