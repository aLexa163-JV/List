package pro.sky.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT)
public class EmployeeAlreadyAdded extends RuntimeException {

    //Сотрудник уже существует
    public EmployeeAlreadyAdded(String i) {
        super(i);
    }

}
