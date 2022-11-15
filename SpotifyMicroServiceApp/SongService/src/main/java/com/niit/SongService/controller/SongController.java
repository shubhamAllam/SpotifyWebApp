package com.niit.SongService.controller;

import UserDefinedException.SongNotExsistException;
import UserDefinedException.UserAlreadyExistsException;
import UserDefinedException.UserNotFoundException;
import com.niit.SongService.model.Song;
import com.niit.SongService.model.User;
import com.niit.SongService.services.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController @RequestMapping("/app/spotify-service/")
public class SongController {

    private ResponseEntity responseEntity;
    private SongService songService;

    @Autowired
    public SongController(SongService songService){
        this.songService = songService;
    }

    @PostMapping("user")
    public ResponseEntity<?> saveUserDetails(@RequestBody User user) throws UserAlreadyExistsException{
        try{
            songService.saveUserAndPlaylists(user);
            responseEntity = new ResponseEntity(user, HttpStatus.CREATED);
        }catch (UserAlreadyExistsException ex){
            throw ex;
        }catch (Exception e){
            responseEntity = new ResponseEntity("Error while registering User", HttpStatus.INTERNAL_SERVER_ERROR);
            e.printStackTrace();
        }
        return responseEntity;
    }

    @PutMapping("updates/{email}")
    public ResponseEntity<?> updateUser(@RequestBody User user, @PathVariable String email) throws UserNotFoundException{
        try{
            songService.updateUserAndPlaylist(user, email);
            responseEntity = new ResponseEntity(user, HttpStatus.OK);
        }catch (UserNotFoundException ex2){
            throw ex2;
        }catch (Exception e){
            responseEntity = new ResponseEntity("Error while updating", HttpStatus.INTERNAL_SERVER_ERROR);
            e.printStackTrace();
        }
        return responseEntity;
    }

    @PutMapping("user/playlist/{email}")
    public ResponseEntity<?> addSongToList(@RequestBody Song song, @PathVariable String email) throws UserNotFoundException {
        try{
            songService.addNewSongToPlaylist(song, email);
            responseEntity = new ResponseEntity("Song Added!", HttpStatus.OK);
        }catch (UserNotFoundException ex2){
            throw ex2;
        }catch (Exception e){
            responseEntity = new ResponseEntity("Error while Adding!", HttpStatus.INTERNAL_SERVER_ERROR);
            e.printStackTrace();
        }
        return responseEntity;
    }

    @PutMapping("user/playlist/remove/{email}")
    public ResponseEntity<?> removeSongFromList(@RequestBody Song song, @PathVariable String email) throws UserNotFoundException, SongNotExsistException{
        try{
            songService.removeSongFromPlaylist(song, email);
            responseEntity = new ResponseEntity("Song Removed!", HttpStatus.OK);
        }catch (UserNotFoundException | SongNotExsistException ex1){
            throw ex1;
        } catch (Exception e){
            responseEntity = new ResponseEntity("Error while Deleting!", HttpStatus.INTERNAL_SERVER_ERROR);
            e.printStackTrace();
        }
        return responseEntity;
    }

    @GetMapping("user/{email}")
    public ResponseEntity<?> getUser(@PathVariable String email) throws UserNotFoundException{
        try{
            User user = songService.getUserByEmail(email);
            responseEntity = new ResponseEntity(user, HttpStatus.OK);
        }catch (UserNotFoundException ex){
            throw ex;
        }catch (Exception e){
            responseEntity = new ResponseEntity("Error", HttpStatus.INTERNAL_SERVER_ERROR);
            e.printStackTrace();
        }
        return responseEntity;
    }
}
