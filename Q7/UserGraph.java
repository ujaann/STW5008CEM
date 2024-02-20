package Q7;

import java.util.Arrays;
import java.util.LinkedList;

public class UserGraph {

    LinkedList<User> userList[];
    int vertices;
    int usersCounter;

    UserGraph(int vertices) {
        this.vertices = vertices;
        userList = new LinkedList[vertices];
        this.usersCounter = 0;
        for (int i = 0; i < vertices; i++) {
            // in array we add a linkedLister
            userList[i] = new LinkedList<>();
        }
    }

    void registerUser(User newUser) {
        userList[usersCounter].add(newUser);
        usersCounter++;
    }

    void follow(String userName, String userNameToFollow) {
        Integer userIndex = null;
        for (int i = 0; i < usersCounter; i++) {
            if (userList[i].getFirst().getUsername().equals(userName)) {
                userIndex = i;
                break;
            }
        }
        if (userIndex != null) {
            for (int i = 0; i < userList.length; i++) {
                if (userList[i].getFirst().getUsername().equals(userNameToFollow)) {
                    userList[userIndex].add(userList[i].getFirst());
                    return;
                }
            }
        }
        System.out.println("Error not user not found");
    }

    public static void main(String[] args) {
        User u1 = new User("Ujan");
        User u2 = new User("Naju");
        User u3 = new User("No3");

        UserGraph userGraph = new UserGraph(3);
        userGraph.registerUser(u1);
        userGraph.registerUser(u2);
        userGraph.registerUser(u3);

        userGraph.follow("Ujan", "Naju");
        System.out.println(Arrays.toString(userGraph.userList));
    }

}
