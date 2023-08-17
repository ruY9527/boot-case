package com.yang.boot.security.login.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/***********************************************************************
 *<PRE>
 *
 *  File Name       : 
 *
 *  Creation Date   : 19-12-29
 *
 *  Author          : Gavin
 *
 *  Purpose         : 
 *
 *  History         : 
 *
 *</PRE>
 ***************************************************************************/

@RestController
@RequestMapping("/admin/api")
public class AdminController {

    @GetMapping("/hello")
    public String hello(){
        return "Hello,Api!!!";
    }

}
