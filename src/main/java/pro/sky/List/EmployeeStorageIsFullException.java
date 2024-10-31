package pro.sky.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT)
public class EmployeeStorageIsFullException extends RuntimeException {

    //Максимальное количество сотрудников достигнуто
    public EmployeeStorageIsFullException(String i) {
        super(i);
    }
}
