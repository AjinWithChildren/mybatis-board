package bit.edu.user.controller;

import bit.edu.user.dto.UserDetailsDto;
import bit.edu.user.dto.UserLoginDto;
import bit.edu.user.service.UserService;
import java.util.List;
import java.util.Objects;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

/**
 * Some description here.
 *
 * @author : 강명관
 * @since : 1.0
 **/
@Slf4j
@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/")
    public String homeController() {
        return "/login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute UserLoginDto userLoginDto,
                        HttpServletRequest request) {

        log.info("userLoginDto {}", userLoginDto);

        List<UserDetailsDto> userDetailsDto = userService.loginUser(userLoginDto);



        log.info("userDetailsDto {}", userDetailsDto);
        HttpSession session = request.getSession(true);
        session.setAttribute("userDetails", userDetailsDto);

        return "redirect:/boards";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);

        if (Objects.nonNull(session)) {
            session.invalidate();
        }

        return "redirect:/";
    }
}
