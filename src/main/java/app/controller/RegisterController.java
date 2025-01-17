package app.controller;

import app.dto.RegistrationDto;
import app.dto.SignUpDto;
import app.model.Account;
import app.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class RegisterController implements Controller {
    private final AccountService accountService;

    @Autowired
    public RegisterController(AccountService accountService) {
        this.accountService = accountService;
    }

    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        if (request.getMethod().equalsIgnoreCase("post")) {
            accountService.register(RegistrationDto.builder()
                    .firstName(request.getParameter("firstName"))
                    .lastName(request.getParameter("lastName"))
                    .login(request.getParameter("login"))
                    .password(request.getParameter("password"))
                    .build());
            modelAndView.setViewName("profile");
            Account account = accountService.signUp(SignUpDto.builder()
                    .login(request.getParameter("login"))
                    .password(request.getParameter("password"))
                    .build());
            modelAndView.addObject("account", RegistrationDto.builder()
                    .login(account.getLogin())
                    .firstName(account.getFirstName())
                    .lastName(account.getLastName())
                    .password(account.getPassword())
                    .build());
        } else {
            modelAndView.setViewName("register");
        }
        return modelAndView;
    }
}
