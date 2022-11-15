package com.niit.SongService.proxy;

import com.niit.SongService.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "USER-AUTH")
public interface UserAuthProxy {

    @PostMapping("/app/authentication/register")
    public ResponseEntity registerUser(@RequestBody User user);
}
