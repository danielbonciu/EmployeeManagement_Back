package com.ausy_technologies.demospring.Controller;

import com.ausy_technologies.demospring.Model.DAO.Role;
import com.ausy_technologies.demospring.Model.DAO.User;
import com.ausy_technologies.demospring.Service.UserService;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;



    @PostMapping("/addRole")
    public Role saveRole(@RequestBody Role role) {


        Role roleAdded = this.userService.saveRole(role);
        return roleAdded;
    }




    @PostMapping("/addUser")
    public User saveUser(@RequestBody User user) {
        User userAdded = this.userService.saveUser(user);
        return userAdded;
    }

    @PostMapping("/addUser2/{idRole}")
    public User saveUser2(@RequestBody User user, @PathVariable int idRole)
    {
        return this.userService.saveUser2(user,idRole);

    }

    @PostMapping("/addUser3/{roleList}")
    public User saveUser3(@RequestBody User user , @PathVariable List<Role> roleList)
    {
        return this.userService.saveUser3(user,roleList);
    }

    @GetMapping("/findRoleBy/{id}")
    public Role findRoleById(@PathVariable int id)
    {
        return this.userService.findRoleById(id);
    }

    @GetMapping("/findUserBy/{id}")
    public User findUserById(@PathVariable int id)
    {
        return userService.findUserById(id);
    }

    @GetMapping("/findAllRoles")
    public List<Role> findAllRoles()
    {
        return  userService.findAllRoles();
    }


    @GetMapping("/allUsers")
    public List<User> findAllUsers()
    {
        return this.userService.findAllUsers();
    }

    @DeleteMapping("/deleteUserById/{id}")
    public void deleteUser(@PathVariable int id)
    {
        this.userService.deleteUserById(id);

    }

    @PutMapping("/updateUser/{roleList}/{id}")
    public User updateUser(@RequestBody User user , @PathVariable List<Role> roleList, @PathVariable int id)
    {
        return this.userService.updateUser(user,roleList,id);
    }

    @PutMapping("/updateRole/{id}")
    public Role updateRole(@RequestBody Role role, @PathVariable int id)
    {
        return this.userService.updateRole(role, id);
    }
}
