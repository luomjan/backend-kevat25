package viikko2.t3.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import viikko2.t3.model.Friend;

@Controller
public class FriendController {

    private static List<Friend> friendList = new ArrayList<>();

    @GetMapping("/add")
    public String addNewFriend(Model model) {
        model.addAttribute("friend", new Friend());
        return "add";
    }

    @PostMapping("/saveFriend")
    public String saveFriend(@ModelAttribute Friend friend) {
        friendList.add(friend);
        return "redirect:/result";
    }

    @GetMapping("/result")
    public String showFriends(Model model) {
        model.addAttribute("friends", friendList);
        return "result";
    }

}
