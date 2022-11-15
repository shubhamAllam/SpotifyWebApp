package com.niit.SongService.services;

import UserDefinedException.SongNotExsistException;
import UserDefinedException.UserAlreadyExistsException;
import UserDefinedException.UserNotFoundException;
import com.niit.SongService.model.Song;
import com.niit.SongService.model.User;
import com.niit.SongService.proxy.UserAuthProxy;
import com.niit.SongService.repository.UserSongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class SongServiceImpl implements SongService{

    private UserSongRepository userSongRepository;
    private UserAuthProxy userAuthProxy;

    @Autowired
    public SongServiceImpl(UserSongRepository userSongRepository, UserAuthProxy userAuthProxy){
        this.userSongRepository = userSongRepository;
        this.userAuthProxy = userAuthProxy;
    }

    @Override
    public User saveUserAndPlaylists(User user) throws UserAlreadyExistsException {
        if(userSongRepository.findById(user.getEmail()).isPresent()){
            throw new UserAlreadyExistsException();
        }
        ResponseEntity<?> response = userAuthProxy.registerUser(user);
        if(response.getStatusCodeValue() == 201){
            return userSongRepository.save(user);
        }else{
            return null;
        }
    }

    @Override
    public User updateUserAndPlaylist(User user, String email) throws UserNotFoundException {
        if(userSongRepository.findById(email).isEmpty()){
            throw new UserNotFoundException();
        }
        return userSongRepository.save(user);
    }

    @Override
    public User addNewSongToPlaylist(Song song, String email) throws UserNotFoundException {
        if(userSongRepository.findById(email).isEmpty()){
            throw new UserNotFoundException();
        }
        User user = userSongRepository.findByEmail(email);
        if(user.getPlaylist() == null){
            user.setPlaylist(Arrays.asList(song));
        }else{
            List<Song> playlists = user.getPlaylist();
            playlists.add(song);
            user.setPlaylist(playlists);
        }
        return userSongRepository.save(user);
    }

    @Override
    public boolean removeSongFromPlaylist(Song song, String email) throws UserNotFoundException, SongNotExsistException {
        if(userSongRepository.findById(email).isEmpty()){
            throw new UserNotFoundException();
        }
        User user = userSongRepository.findByEmail(email);
        if(user.getPlaylist() == null){
            throw new SongNotExsistException();
        }else{
            List<Song> playlist = user.getPlaylist();
            playlist.remove(song);
            user.setPlaylist(playlist);
        }
        return true;
    };

    @Override
    public User getUserByEmail(String email) throws UserNotFoundException {
        if(userSongRepository.findById(email).isEmpty()){
            throw new UserNotFoundException();
        }
        return userSongRepository.findByEmail(email);
    }

}
