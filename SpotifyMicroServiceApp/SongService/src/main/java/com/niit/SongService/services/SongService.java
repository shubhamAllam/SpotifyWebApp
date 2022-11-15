package com.niit.SongService.services;

import UserDefinedException.SongNotExsistException;
import UserDefinedException.UserAlreadyExistsException;
import UserDefinedException.UserNotFoundException;
import com.niit.SongService.model.Song;
import com.niit.SongService.model.User;

public interface SongService {

    User saveUserAndPlaylists(User user) throws UserAlreadyExistsException;
    User updateUserAndPlaylist(User user, String email) throws UserNotFoundException;
    User addNewSongToPlaylist(Song song, String email) throws UserNotFoundException;
    User getUserByEmail(String email) throws UserNotFoundException;

    boolean removeSongFromPlaylist(Song song, String email) throws UserNotFoundException, SongNotExsistException;
}
