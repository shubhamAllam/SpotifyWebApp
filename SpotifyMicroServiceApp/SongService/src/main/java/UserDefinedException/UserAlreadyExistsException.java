package UserDefinedException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT, reason = "This User is already exists in the DataBase.")
public class UserAlreadyExistsException extends Exception {

    
}
