package codegym.com.controller;

import codegym.com.service.IDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class DictionaryController {
    @Autowired
    private IDictionaryService iDiction;
    @GetMapping("/search")
    public String search() {
        return "search";
    }

    @PostMapping("/result")
    public String result(@RequestParam(name = "engLish") String engLish, Model model) {
        model.addAttribute("result",iDiction.findAll(engLish));
        return "result";
    }
}
