package app.controller;

import app.dto.RegistrationDto;
import app.dto.signUpDto;
import app.model.Account;
import app.service.AccountService;
import app.service.AccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class RegisterController implements Controller {
    private AccountService accountService;

    @Autowired
    public RegisterController(AccountService accountService) {
        this.accountService = accountService;
    }
    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        if(request.getMethod().equalsIgnoreCase("post")) {
            accountService.register(RegistrationDto.builder()
                            .firstName(request.getParameter("firstname"))
                            .lastName(request.getParameter("lastname"))
                            .login(request.getParameter("login"))
                            .password(request.getParameter("password"))
                    .build());
            modelAndView.setViewName("profile");
            Account account = accountService.signUp(signUpDto.builder()
                    .login(request.getParameter("login"))
                    .password(request.getParameter("password"))
                    .build());
            modelAndView.addObject("account",RegistrationDto.builder()
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
