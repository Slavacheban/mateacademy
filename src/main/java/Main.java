import models.User;
import services.UserService;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserService();
        User user = new User("Masha",26, "Odessa");
        userService.saveUser(user);
    }
}
