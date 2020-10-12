/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import java.util.List;
import Entities.User;

/**
 *
 * @author acer hiba
 */
public interface IUserService {
     void addUser(User r);
     void updateUser(User r);
     void deleteUser(int id);
     List<User> getAllUsers();
     List<User> getUsersInfo();
     User findUserById(int id);
     User findUserByUsername(String username);
     User findUserByEmail(String email); 
}
