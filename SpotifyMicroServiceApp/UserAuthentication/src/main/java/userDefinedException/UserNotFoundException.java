package userDefinedException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT, reason = "The User you trying to reach is not in the DataBase Or Credential given are wrong!")
public class UserNotFoundException extends Exception{
}
