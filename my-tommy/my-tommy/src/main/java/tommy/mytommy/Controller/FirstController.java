package tommy.mytommy.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FirstController {

    @GetMapping("/")
    public String niceToMeetYou(Model model) {
        model.addAttribute("data", "Tommy");
        return "tommy";
    }
}
