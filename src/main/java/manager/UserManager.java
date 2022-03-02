package manager;

import model.User;

public interface UserManager extends Manager<User, Integer>{

    User getByEmailAndPassword(String username, String password);

}
