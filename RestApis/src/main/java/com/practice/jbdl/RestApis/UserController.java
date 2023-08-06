package com.practice.jbdl.RestApis;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {


    public static HashMap<Integer,User> userInfo = new HashMap<>();

    @GetMapping(value = "/get_user")
    public  User getUser(@RequestParam(value = "userId",required = false,defaultValue = "2") int id){

        return userInfo.get(id);
    }

    @PostMapping(value = "/insert_user")
    public  void insertUser(@RequestBody User user){
        if(userInfo.containsKey(user.getUserId())){
            return;
        }
        else{
            userInfo.put(user.getUserId(),user);
        }
    }

    @GetMapping(value = "/get_users")
    public Map<Integer,User> getAllUser(){
        return userInfo;
    }

    @DeleteMapping("/delete_user/{userId}")
    public void deleteUser(@PathVariable(value = "userId") int userId){

        userInfo.remove(userId);

    }
    @PutMapping("/update_user")
    public void  updateUser(@RequestParam(value = "userId") int userId,
                            @RequestBody User user){

       // userInfo.put(userId,user);

        User user1 = userInfo.get(userId);

        if(user.getAge()!=0){
            user1.setAge(user.getAge());
        }

        if(user.getName()!=null){
            user1.setName(user.getName());
        }

        if(user.getCountry()!=null){
            user1.setName(user.getCountry());
        }

        userInfo.put(userId,user1);

    }



}
