package com.niit.SongService.repository;

import com.niit.SongService.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserSongRepository extends MongoRepository<User, String> {

    User findByEmail(String email);
}
