package UserDefinedException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT, reason = "This Song is not in the playlist anymore!")
public class SongNotExsistException extends Exception{

}
