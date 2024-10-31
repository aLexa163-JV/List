package pro.sky.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT)
public class EmployeeNotFoundException extends RuntimeException {

    //сотрудник не найден
    public EmployeeNotFoundException(String i) {
        super(i);
    }
}
