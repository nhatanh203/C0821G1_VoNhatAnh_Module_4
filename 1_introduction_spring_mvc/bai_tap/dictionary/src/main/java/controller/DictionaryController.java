package controller;

import model.Dictionary;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.DictionaryService;

import java.util.List;

@Controller
public class DictionaryController {
    private DictionaryService dictionaryService = new DictionaryService();

    @GetMapping("/search")
    public String search() {
        return "search";
    }

    @PostMapping("/result")
    public String result(@RequestParam String word, Model model) {
        List<Dictionary> dictionary = this.dictionaryService.findAll();
        for (int i = 0; i < dictionary.size(); i++) {
            if (word.equals(dictionary.get(i).getEnglish())) {
                model.addAttribute("word", dictionary.get(i).getVietNam());
                model.addAttribute("key", word);
                return "result";
            }
        }
        return "result";
    }
}
