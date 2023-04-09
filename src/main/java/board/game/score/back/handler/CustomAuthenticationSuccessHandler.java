package board.game.score.back.handler;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.fasterxml.jackson.databind.ObjectMapper;

import board.game.score.back.service.UserService;

public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    UserService userService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response,
                                        Authentication authentication)
            throws IOException {
        response.setStatus(HttpStatus.ACCEPTED.value());
        Map<String, Object> hashMap = new HashMap<>();
        hashMap.put("role", authentication.getAuthorities());
        hashMap.put("user", userService.getUserByEmail(authentication.getName()));
        response.getOutputStream().println(objectMapper.writeValueAsString(hashMap));
    }

}
