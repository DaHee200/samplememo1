package com.sparta.samplememo1.controller;

import com.sparta.samplememo1.dto.SignupRequestDto;
import com.sparta.samplememo1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {

        this.userService = userService;
    }

    //로그인
    @GetMapping("/user/login")
    public String login() {

        return "login";
    }

    //로그인 에러
    @GetMapping("/user/login/error")
    public String loginError(Model model) {
        model.addAttribute("loginError", true);
        return "login";
    }



//    //Login을 통해서 사용자 정보와 JWT Token을 발급
//    @RequestMapping(value = "/api/login", method = RequestMethod.POST)
//    public ResponseEntity<Message> createToken(@RequestBody AuthenticationRequestDto requestDto) throws Exception {
//        // 토큰 생성하는 서비스
//        AuthenticationResponse token = tokenService.createToken(requestDto);
//        //입력받은 사용자를 찾는 부분
//        Optional<User> getUser = userService.findOne(requestDto.getUsername());
//        //메세지를 만들어서 여러 responsebody를 내려줄 수 있도록 한다.
//        Message message = Message.builder()
//                .message1(token)
//                .message2(getUser)
//                .build();
//        //200ok 일 경우에만 responsebody에 넣어주는 부분
//        return new ResponseEntity<Message>(message, HttpStatus.OK);
//    }

//    //사용자 정보 수정
//    @PutMapping("/api/userEdit")
//    public void updateUser(@RequestBody RegisterRequestDto requestDto) {
//        userService.update(requestDto);
//    }
//
//    //사용자 삭제
//    @DeleteMapping("/api/unregister/{username}")
//    public void deleteUser(@PathVariable String username){
//        userService.deleteUser(username);
//    }

    //회원가입
    @GetMapping("/user/signup")//왜 허가가 없지??
    public String signup(){

        return "signup";
    }

//    //회원가입
//    @PostMapping("/user/signup")
//    public void registerUser(@RequestBody RegisterRequestDto requestDto) {
//        registerService.registerUser(requestDto);
//    }
//

//    // 회원 가입 요청 처리
//    @PostMapping("/user/signup")
//    public String registerUser(SignupRequestDto requestDto) {
//        userService.registerUser(requestDto);
//        return "redirect:/";
//    }
//
//    // Admin 전용
//    @Secured("ROLE_ADMIN")
//    @GetMapping("/admin/users")
//    public List<User> getUsersforAdmin(){
//        return userService.getUsers();
//    }
//
//    @Secured("ROLE_ADMIN")
//    @DeleteMapping("/admin/users/{username}")
//    public void deleteUserAdmin(@PathVariable String username) {
//        userService.deleteUser(username);
//    }

}