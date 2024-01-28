package com.Duhov.UserService.Auth;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/demo")
public class DemoController {
    @GetMapping
    @PreAuthorize("hasRole(client_admin)")
    public String test(){
        return "Hello from KeyCloak - ADMIN";
    }

    @GetMapping("/hello-2")
    @PreAuthorize("hasRole(client_user)")
    public String test2(){
        return "Hello from KeyCloak";
    }
}
