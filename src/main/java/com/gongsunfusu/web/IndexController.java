package com.gongsunfusu.web;

import com.gongsunfusu.pojo.user;
import com.gongsunfusu.service.IndexService;
import com.gongsunfusu.util.MyStringUtil;
import com.google.code.kaptcha.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;

@Controller
public class IndexController {
    @Autowired
    private IndexService indexService;
    @Autowired
    private Producer kaptchaProduce;

    @RequestMapping("/login")
    public String login(HttpServletRequest request){
        request.setAttribute("path", MyStringUtil.getPath(request));
        return "login";
    }

    @RequestMapping("/loginUser")
    public String loginUser(HttpServletRequest request, user user, String verification){
        String newVerification = (String) request.getSession().getAttribute("kaptcha");
        if (MyStringUtil.verificationJudge(verification,newVerification)){
            user newUser = indexService.loginUser(user);
            if (newUser != null){
                request.getSession().setAttribute("user",newUser);
                request.setAttribute("userList",indexService.selectUserList());
                return "index";
            }
        }
        request.setAttribute("path", MyStringUtil.getPath(request));
        return "login";
    }

    @RequestMapping("/registerUser")
    public String registerUser(HttpServletRequest request, user user, String verification, String newPassword){
        request.setAttribute("path", MyStringUtil.getPath(request));
        String newVerification = (String) request.getSession().getAttribute("kaptcha");
        if(MyStringUtil.verificationJudge(verification,newVerification) && newPassword.equals(user.getPassword())){
            Boolean bool = indexService.registerUser(user);
            if (bool == true){
                return "login";
            }
        }
        return "login";
    }

    @RequestMapping(path = "/kaptcha", method = RequestMethod.GET)
    public void getKaptcha(HttpServletResponse response, HttpSession session){
        //生成验证码
        String text = kaptchaProduce.createText();
        BufferedImage image = kaptchaProduce.createImage(text);

        //将验证码存入session
        session.setAttribute("kaptcha",text);

        //将图片输出给浏览器
        response.setContentType("image/png");
        try{
            OutputStream os = response.getOutputStream();
            ImageIO.write(image,"png",os);
        }catch(IOException e){
            System.out.println("验证码获取失败！");
        }
    }
}
