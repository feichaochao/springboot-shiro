//package com.heimao.wuye.controller;
//
//
//import org.apache.shiro.SecurityUtils;
//import org.apache.shiro.authc.AuthenticationException;
//import org.apache.shiro.authc.UsernamePasswordToken;
//import org.apache.shiro.subject.Subject;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//
//import com.heimao.wuye.entity.Users;
//
//@Controller
//public class HelloController {
//
//    @RequestMapping(value = "/login", method = RequestMethod.GET)
//    public String login(Model model, String name, String password) {
//        Subject subject = SecurityUtils.getSubject();
//        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(name, password);
//        try {
//            subject.login(usernamePasswordToken);
//            return "redirect:/index";
//        } catch (AuthenticationException e) {
//            usernamePasswordToken.clear();
//            return "login";
//        }
//    }
//
//    @RequestMapping(value = "/index", method = RequestMethod.GET)
//    public String index(Model model) {
//        Users user = (Users) SecurityUtils.getSubject().getPrincipal();
//        model.addAttribute("name", user.getName());
//        return "index";
//    }
//
//
//    @RequestMapping(value = "/guest", method = RequestMethod.GET)
//    public String guest(Model model) {
//        return "guest";
//    }
//
//    @RequestMapping(value = "/logout", method = RequestMethod.GET)
//    public String logout(Model model) {
//        SecurityUtils.getSubject().logout();
//        return "redirect:/login";
//    }
//
//}
