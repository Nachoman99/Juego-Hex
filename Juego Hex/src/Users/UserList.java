/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Users;

import java.util.ArrayList;
import java.util.TreeMap;

/**
 *
 * @author Kevin Trejos
 */
public class UserList {
 
    private TreeMap<String, User> userList;

    public UserList() {
        userList = new TreeMap<>();
    }

    public UserList(TreeMap<String, User> userList) {
        this.userList = userList;
    }
    
    
    public void addUser(User user){
        userList.put(user.getName(), user);
    }
    
    
}
