package com.ausy_technologies.demospring.Controller;

import com.ausy_technologies.demospring.Model.DAO.Role;
import com.ausy_technologies.demospring.Model.DAO.User;
import com.ausy_technologies.demospring.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    // Laurentiu a facut o treaba foarte buna

    @Autowired
    private UserService userServiceName;



    @PostMapping("/addRole")
    public Role saveRole(@RequestBody Role role) {


        Role roleAdded = this.userServiceName.saveRole(role);
        return roleAdded;
    }




    @PostMapping("/addUser")
    public User saveUser(@RequestBody User user) {
        User userAdded = this.userServiceName.saveUser(user);
        return userAdded;
    }

    @PostMapping("/addUser2/{idRole}")
    public User saveUser2(@RequestBody User user, @PathVariable int idRole)
    {
        return this.userServiceName.saveUser2(user,idRole);

    }

    @PostMapping("/addUser3/{roleList}")
    public User saveUser3(@RequestBody User user , @PathVariable List<Role> roleList)
    {
        return this.userServiceName.saveUser3(user,roleList);
    }

    @GetMapping("/findRoleBy/{id}")
    public Role findRoleById(@PathVariable int id)
    {
  return this.userServiceName.findRoleById(id);
    }

    @GetMapping("/findAllRoles")
    public List<Role> findAllRoles()
    {
        return  userServiceName.findAllRoles();
    }


    @GetMapping("/allUsers")
    public List<User> findAllUsers()
    {
        return this.userServiceName.findAllUsers();
    }

    @DeleteMapping("/deleteUserById/{id}")
    public void deleteUser(@PathVariable int id)
    {
        this.userServiceName.deleteUserById(id);

    }

}
