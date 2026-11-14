package sprint.example.crud_application.exeption;

public class UserCreationExeption extends RuntimeException {
    UserCreationExeption(String message){
        super(message);
    }
}
