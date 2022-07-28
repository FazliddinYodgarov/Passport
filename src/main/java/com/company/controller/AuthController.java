package com.company.controller;

import com.company.dto.AuthorizationDTO;
import com.company.dto.ProfileDTO;
import com.company.type.ProfileRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/")
    public String asdasd() {
        System.out.println("asdasdasd");
        return "index";
    }
    @PostMapping("/authorization")
    public String authorization(@ModelAttribute AuthorizationDTO dto) {

        Authentication authenticate = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(dto.getUsername(), dto.getPassword()));

        UserDetails user = (UserDetails) authenticate.getPrincipal();
        @SuppressWarnings("unchecked")
        Optional<SimpleGrantedAuthority> optional = (Optional<SimpleGrantedAuthority>)
                user.getAuthorities().stream().findAny();

        UsernamePasswordAuthenticationToken
                authentication = new UsernamePasswordAuthenticationToken(user,
                null, user.getAuthorities());

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String role = "";
        if (optional.isPresent()) {
            role = optional.get().getAuthority();
        }
        if (role.equals("ROLE_ADMIN")) {
            return "redirect:/equipment/";
        } else if (role.equals("ROLE_USER")) {
            return "redirect:/equipment/";
        }
        return "redirect:/go_to_login";
    }


}
