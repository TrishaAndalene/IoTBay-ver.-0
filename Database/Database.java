package Database;
import java.util.List;
import java.util.ArrayList;

public class Database {
    private List<User> userDatabase = new ArrayList<>();




    public Database(){
        userDatabase.add(new User("bob", "bob", "bob@bob.com", "123456", 040000000));
    }


    public void addToDatabase(User user){
        userDatabase.add(user);

    }

}


