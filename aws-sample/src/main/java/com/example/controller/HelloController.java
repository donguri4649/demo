package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.domain.ec2.Ec2Info;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class HelloController {

    @Autowired
    private Ec2Info ec2Info;

    @GetMapping(value = { "/", "/hello" })
    public String getHello(Model model) {
        
        log.info(ec2Info.toString());
        model.addAttribute("ec2Info", ec2Info);

        return "hello";
    }
    
    
  //管理人室ログインパスワード
  	@PostMapping("/janitor")
  	@ResponseBody
  	public String passwordJanitor (@RequestParam String note) {
  		
  		
  		System.out.println("test1:" + note);
  		String password = "%E3%83%80%E3%82%A6%E3%83%B3%E3%83%AD%E3%83%BC%E3%83%89%E5%A4%B1%E6%95%97";
  		String[] passwordStr = note.split(",");
  		
  		if(("1").equals(passwordStr[1])) {
  			if(("%E3%82%B9%E3%82%AD%E3%83%AB%E3%82%B7%E3%83%BC%E3%83%88%E3%83%80%E3%82%A6%E3%83%B3%E3%83%AD%E3%83%BC%E3%83%89").equals(passwordStr[0])) {
  				password = "%E3%83%80%E3%82%A6%E3%83%B3%E3%83%AD%E3%83%BC%E3%83%89123";
  				password = password + "," + "/aws-sample/s3/download/スキルシート.xlsx";
  			}
  			//System.out.println("test2:" + password);
  		}else if(("2").equals(passwordStr[1])) {
  			if(("%E6%9D%91%E4%B8%8A%E5%A4%A7%E6%A8%B9").equals(passwordStr[0])) {
  				password = "%E3%83%80%E3%82%A6%E3%83%B3%E3%83%AD%E3%83%BC%E3%83%89123";
  				password = password + "," + "/aws-sample/s3/download/設計書.zip";
  			}
  			//System.out.println("test3:" + password);
  		}
  		
  		return password;
  	}
}
