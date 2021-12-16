package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CaculatorController {

    @RequestMapping("/caculator")
    public String calculate(Model model, @RequestParam(name = "num1", defaultValue = "0") int num1,
                            @RequestParam(name = "num1", defaultValue = "0") int num2,
                            @RequestParam(name = "calculator", defaultValue = "") String caculat) {

        int result = 0;
        switch (caculat) {
            case "Addition(+)":
                result = num1 + num2;
                caculat = "Addition";
                break;
            case "Subtraction(-)":
                result = num1 - num2;
                caculat = "Subtraction";
                break;
            case "Multiplication(X)":
                result = num1 * num2;
                caculat = "Multiplication";
                break;
            case "Division(/)":
                result = num1 / num2;
                caculat = "Division";
                break;
        }
        model.addAttribute("num1", num1);
        model.addAttribute("num2", num2);
        model.addAttribute("caculat", caculat);
        model.addAttribute("result", result);
        return "index";
    }
}
