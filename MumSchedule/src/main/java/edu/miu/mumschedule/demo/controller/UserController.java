package edu.miu.mumschedule.demo.controller;


import edu.miu.mumschedule.demo.service.CredentialService;
import edu.miu.mumschedule.demo.service.RoleService;
import edu.miu.mumschedule.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import edu.miu.mumschedule.demo.domain.User;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping(value = {"/user"})
@SessionAttributes("email")
public class UserController {
    @Autowired
    UserService userService;

    @Autowired
    CredentialService credentialService;

    @Autowired
    HttpSession session;

    @Autowired
    RoleService roleService;

    @Autowired
    PasswordEncoder passwordEncoder;


    @PostMapping(value = {"/add"})
    public String addNewUser(@Valid @ModelAttribute User user, BindingResult bindingResult, Model model) throws Exception {
        if (bindingResult.hasErrors()) {
            return "adduser";
        }
            // save product here
        System.out.println("----------5-");
        String encodePassword = passwordEncoder.encode(user.getCredential().getPassword());
        model.addAttribute("email", user.getEmail());
        user.getCredential().setPassword(passwordEncoder.encode(user.getCredential().getPassword()));
        userService.saveUser(user);
        System.out.println("-------------after");
        return "Verification";

    }

//    @GetMapping(value = "/resend_email")
//    public String reSendEmailTo(String email, Model model) throws Exception {
//        Object userEmail = model.getAttribute("email");
//        System.out.println("inside ------------ email" + email);
//        if (userEmail != null) {
//            SendEmailClass.sendMailTo(userEmail.toString());
//        }
//        return "Verification";
//    }

//    @GetMapping(value = "/send_email")
//    public String sendEmailTo(String email, Model model) throws Exception {
//        Object userEmail = model.getAttribute("email");
//        System.out.println("inside ------------ email" + email);
//        if (userEmail != null) {
//            SendEmailClass.sendMailTo(userEmail.toString());
////            model.addAttribute("user", new User());
//            System.out.println("-------sendemail");
//        }
//        return "Verification";
//    }


    @GetMapping(value = {"/get/{id}"})
    public Optional<User> getUserbyId(@PathVariable(value = "id") Long id){
        return userService.findUserById(id);
    }

    @RequestMapping(value = {"/delete/{id}"})
    public String deleteUserById(@PathVariable(value="id")Long id){
        userService.deleteUser(id);
        return "redirect:/auction/admin/listUsers";

    }

    @GetMapping(value = {"/getall"})
    public String getAllUsers(Model model){
        System.out.println("----get all------");
        model.addAttribute("listUsers",userService.findAllUsers());
       return "/listusers";
    }

    @GetMapping(value = {"edit/{userId}"})
    public String editUser(@PathVariable long userId, Model model) {
        Optional<User> user = userService.findUserById(userId);
        if (user.isPresent()) {
            model.addAttribute("user", user.get());
            return "/edituserform";
        }
        return "/getall";
    }

    //update password
    @GetMapping(value = {"/update"})
    public String upDatePassword(@ModelAttribute User user1, Model model) {
        //fake userId
        System.out.println("-----inside update" + user1.getId());
        Long uId = 1L;
        String password = user1.getFirstName();
        System.out.println(password);

        if(userService.findUserById(uId).isPresent()){
            User user = userService.findUserById(uId).get();
            System.out.println("========not saved");
            System.out.println(user.getCredential().getPassword());
            user.getCredential().setPassword(passwordEncoder.encode(password));
            userService.saveUser(user);
            System.out.println("========saved");
            return "redirect:/home/log_in";
        };
        return "/getall";
    }

//    @GetMapping(value = {"/verify/{userId}"})
//    public String verifyUser(@PathVariable("userId") Long userId, Model model) {
//        System.out.println(userId);
//        if(userService.findUserById(userId).isPresent()){
//            User user = userService.findUserById(userId).get();
//            if(Verification.verify(user.getFirstName(), user.getLicenceNumber())) {
//                user.setVerification(true);
//                model.addAttribute("user", user);
//                return "forward:/auction/admin/listUsers";
//            }
//            else
//                return "notVerified";
//            }
//
//        else
//
//    {
//        System.out.println("The user is not availbale");
//    }
//        return "forward:/auction/admin/listUsers";
//        };




    @PostMapping(value = {  "/edit"})
    public String updateUser(@Validated @ModelAttribute("user") User user,
                                 BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "/edituserform";
        }
        userService.saveUser(user);
        return "redirect:/getall";
    }
//    //biniam
//    @RequestMapping(value = {"/adduser" })
//    public String inputProduct(@ModelAttribute("user") User user, Model model) {
//        List<Role>roles=roleService.findAllRoles();
//        model.addAttribute("SELLER",roles.get(1));
//        model.addAttribute("CUSTOMER",roles.get(2));
//        return "adduser";
//    }

//    //new Verification
//    @RequestMapping(value = {"/get_verified"})
//    public String verify(@ModelAttribute String str, @RequestParam(value = "pin", required = false)  String pin, BindingResult bindingResult, Model model) throws Exception {
//        System.out.println("pin-------" + Integer.parseInt(pin));
//        if(Integer.parseInt(pin) == (SendEmailClass.pinCode())){
//            System.out.println("yes-----------");
//            Object email = model.getAttribute("email");
//            System.out.println("-------------------"+email.toString());
////            String emails = email.toString();
////            System.out.println(emails);
////            userService.findUserByEmail()
//            User usr  = userService.findUserByEmail(email.toString());
//            usr.setPinCode(true);
//            userService.saveUser(usr);
//            assert email != null;
//
//            return "emailsentforlogin";
//        };
//         return "Verification";
//    }


    //
//    @GetMapping(value = "/check_verification")
//    public boolean checkVerification(String string){
//
//        return true;
//    }
//        @GetMapping(value = "/resetPassword")
//        public String resetPasswordPage(Model model){
//            model.addAttribute("users", new User());
//            System.out.println("in the upper method");
//            return "resetPassword";
//        }

//        @GetMapping(value = "/resetPassoword_usr_email")
//        public String resetPassword(@ModelAttribute User user, Model model) throws Exception {
//            System.out.println("------");
//            String email = user.getEmail();
//            System.out.println(email);
//            String firstName = user.getFirstName();
//            System.out.println(firstName);
//            User userToBeReset = userService.getUserByEmailAndFirstName(email,firstName);
//            System.out.println(userToBeReset.toString());
//            SendEmailClass.sendMailToReset(user.getEmail());
//            return "resetVerification";
//        }

//        @GetMapping(value = "/verify_reset")
//        public String checkResetPinCode(@ModelAttribute String str, @RequestParam(value = "pin", required = false)  String pin, BindingResult bindingResult, Model model) throws Exception {
//            System.out.println("pin-------" + Integer.parseInt(pin));
//            if(Integer.parseInt(pin) == (SendEmailClass.pinCodeResetEmail())){
//                System.out.println("yes-----------");
//                Object email = model.getAttribute("email");
//                assert email != null;
//                System.out.println("--------inside checker verification");
//                return "redirect:/user/enterResetPassword";
//            };
//            return "Verification";
//        }
//
//        @GetMapping(value = "/enterResetPassword")
//        public String enterPasswordReset(Model model){
//            model.addAttribute("user", new User());
//            return "enterNewPasswordReset";
//        }

        //for logIn failed


}
