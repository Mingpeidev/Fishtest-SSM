package com.mao.controller;

import com.mao.proj.User;
import com.mao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpSession;

/**
 * @author Mingpeidev
 * 这里用了@SessionAttributes，可以直接把model中的user(也就key)放入其中,这样保证了session中存在user这个对象
 */
@Controller
@RequestMapping("/user")
@SessionAttributes("user")
public class UserController {

    @Autowired
    private UserService userService;


    // 正常访问login页面
    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    // 表单提交过来的路径
    @RequestMapping("/checkLogin")
    public String checkLogin(User user, Model model) {
        // 调用service方法
        user = userService.checkLogin(user.getUsername(), user.getPassword());
        // 若有user则添加到model里并且跳转到成功页面
        if (user != null) {
            model.addAttribute("user", user);
            return "success";
        }
        return "fail";
    }

    // 测试超链接跳转到另一个页面是否可以取到session值
    @RequestMapping("/anotherpage")
    public String hrefpage() {
        return "anotherpage";
    }

    // 注销方法
    @RequestMapping("/outLogin")
    public String outLogin(HttpSession session) {
        // 通过session.invalidata()方法来注销当前的session
        session.invalidate();
        return "login";
    }
}
