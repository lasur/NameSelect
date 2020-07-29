package com.example.NameSelect.Controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import javax.validation.constraints.Null;

import com.example.NameSelect.model.Name;
import com.example.NameSelect.model.NameRating;
import com.example.NameSelect.model.User;
import com.example.NameSelect.service.NameService;
import com.example.NameSelect.service.UserBean;
import com.example.NameSelect.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class LoginController
{
    @Autowired
    private UserService userService;

    @Autowired
    private NameService nameService;

    @PostMapping("/log")
    public String login(Model model, HttpServletRequest request, HttpServletResponse response){
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        UserBean login = new UserBean();
        login.username = username;
        login.password = password;

        try {
            if(userService.validate(login)) {
                HttpSession session = request.getSession();
                session.setAttribute("user", username);
                Cookie loginCookie = new Cookie("username",login.username);
                loginCookie.setPath("/");
                loginCookie.setMaxAge(30*60);
                loginCookie.setHttpOnly(true);
                response.addCookie(loginCookie);
                List<Name> names = nameService.findAll();
                model.addAttribute("names", names);
                try {
                    Long user_id = userService.getIdFromDB(login.username);
                    List<Name> imiona2 = nameService.getNamesByUserId(user_id);
                    List<NameRating> names3andRating = nameService.getNames2ByUserId(user_id);
                    List<Name> imiona3 = new ArrayList<>();
                    List<Integer> notes = new ArrayList<>();
                    for (NameRating nameRating : names3andRating) {
                        imiona3.add(nameRating.getName());
                        notes.add(nameRating.getRating());
                    }
                    if(imiona2 !=null)
                    {
                        model.addAttribute("names2", imiona2);
                    }
                    if(imiona3 !=null)
                    {
                        model.addAttribute("names3", imiona3);
                    }
                    if(notes !=null)
                    {
                        model.addAttribute("notes", notes);
                    }
                    return "login";
                }catch (Exception e) {
                    e.printStackTrace();
                }
            }else {
                return "index";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "index";
    }

    @PostMapping("/register")
    public String registerUser(@Valid User user){
        userService.createUser(user);
        return "index";
    }
    @PostMapping("/Tab2")
    public String tab2(HttpServletRequest request) {
        String name = request.getParameter("Ids");
        String[] parts = name.split(",");
        int[] numbers = parseIds(parts);
        String username = getCookie(request, "username").getValue();
        Long user_id = userService.getIdFromDB(username);
        Long name_id;
        for(int i=0;i<numbers.length;i++) {
            name_id = Long.valueOf(numbers[i]);
            userService.deleteFromTable1(name_id,user_id);
            userService.insertIntoTable1(name_id,user_id);
        }
        return "redirect:/log";
    }

    @PostMapping("/Tab3")
    public String tab3(HttpServletRequest request)
    {
        String name = request.getParameter("Ids");
        String[] parts = name.split(",");
        int[] numbers = parseIds(parts);
        String username = getCookie(request, "username").getValue();
        Long user_id = userService.getIdFromDB(username);
        Long name_id;
        for(int i=0;i<numbers.length;i++) {
            name_id = Long.valueOf(numbers[i]);
            userService.deleteFromTable2(name_id,user_id);
            userService.insertIntoTable2(name_id,user_id);
        }
        return "redirect:/log";
    }

    @PostMapping("/Note")
    public String note(HttpServletRequest request)
    {
            String name = request.getParameter("Ids");
            String notes = request.getParameter("Notes");
            String[] parts = name.split(",");
            int[] numbers = parseIds(parts);
            String[] parts2 = notes.split(",");
            int[] numbers2 = new int[parts2.length];
            for(int i=0;i<parts.length;i++) {
                numbers2[i]=0;
            }
            for(int i=0;i<numbers2.length;i++) {
                numbers2[i]=Integer.parseInt(parts2[i]);
            }
            String username = getCookie(request, "username").getValue();
            Long user_id = userService.getIdFromDB(username);
            Long name_id;
            for(int i=0;i<numbers.length;i++) {
                name_id = Long.valueOf(numbers[i]);
                if(numbers2[i]!=0) {
                    userService.updateTable2(numbers2[i], name_id,user_id);
                }
            }
        return "redirect:/log";
    }

    @PostMapping("/DeleteFromTab2")
    public String deleteFromTab2(HttpServletRequest request)
    {
        String name = request.getParameter("Ids");
        String[] parts = name.split(",");
        int[] numbers = parseIds(parts);
        String username = getCookie(request, "username").getValue();
        Long user_id = userService.getIdFromDB(username);
        Long name_id;
        for(int i=0;i<numbers.length;i++) {
            name_id = Long.valueOf(numbers[i]);
            userService.deleteFromTable1(name_id,user_id);
        }
        return "redirect:/log";
    }

    @PostMapping("/DeleteFromTab3")
    public String deleteFromTab3(HttpServletRequest request)
    {
        String name = request.getParameter("Ids");
        String[] parts = name.split(",");
        int[] numbers = parseIds(parts);
        String username = getCookie(request, "username").getValue();
        Long user_id = userService.getIdFromDB(username);
        Long name_id;
        for(int i=0;i<numbers.length;i++) {
            name_id = Long.valueOf(numbers[i]);
            userService.deleteFromTable2(name_id,user_id);
        }
        return "redirect:/log";
    }

    @GetMapping("/log")
    public String show(Model model, HttpServletRequest request){
        List<Name> names = nameService.findAll();
        model.addAttribute("names", names);
        String usern="";
        try
        {
            usern = getCookie(request, "username").getValue();
        }
        catch(NullPointerException e)
        {
            return "redirect:/";
        }
        Long user_id = userService.getIdFromDB(usern);
        List<Name> imiona2 = nameService.getNamesByUserId(user_id);
        List<NameRating> names3andRating = nameService.getNames2ByUserId(user_id);
        List<Name> imiona3 = new ArrayList<>();
        List<Integer> notes = new ArrayList<>();
        for (NameRating nameRating : names3andRating) {
            imiona3.add(nameRating.getName());
            notes.add(nameRating.getRating());
        }
        model.addAttribute("names2", imiona2);
        model.addAttribute("names3", imiona3);
        model.addAttribute("notes", notes);
        return "login";
    }

    @GetMapping("/login")
    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
        Cookie loginCookie = null;
        Cookie[] cookies = request.getCookies();
        if(cookies != null){
            for(Cookie cookie : cookies){
                if(cookie.getName().equals("username")){
                    loginCookie = cookie;
                    break;
                }
            }
        }
        if(loginCookie!=null)
        {
            loginCookie.setMaxAge(0);
            loginCookie.setPath("/");
        }
        response.addCookie(loginCookie);
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.removeAttribute("user");
            session.invalidate();
        }
        return "index";
    }

    public static Cookie getCookie(HttpServletRequest request, String name) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(name)) {
                    return cookie;
                }
            }
        }
        return null;
    }

    int[] parseIds(String[] parts)
    {
        int[] numbers = new int[parts.length];
        for(int xx=0;xx<parts.length;xx++) {
            numbers[xx]=0;
        }
        char[] numm = {'0','1','2','3','4','5','6','7','8','9'};
        int index=0;
        for (String part : parts) {
            for (int j = 0; j < part.length(); j++) {
                for (char c : numm) {
                    char check = part.charAt(j);
                    if (check == c) {
                        if (numbers[index] != 0) {
                            numbers[index] = numbers[index] * 10 + Character.getNumericValue(check);
                        } else {
                            numbers[index] = Character.getNumericValue(check);
                        }
                    }
                }
            }
            index++;
        }
        return numbers;
    }
}