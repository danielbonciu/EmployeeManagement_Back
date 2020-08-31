package com.ausy_technologies.demospring.Controller;

import com.ausy_technologies.demospring.Model.DAO.Role;
import com.ausy_technologies.demospring.Model.DAO.User;
import com.ausy_technologies.demospring.Model.DTO.UserDto;
import com.ausy_technologies.demospring.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.parser.Entity;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {


    @Autowired
    private UserService userService;


    @PostMapping("/addRole")
    public ResponseEntity<Role> saveRole(@RequestBody Role role) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Responded", "SaveRole");

        this.userService.saveRole(role);
        return ResponseEntity.status(HttpStatus.ACCEPTED).headers(httpHeaders).body( role );
    }

    @PostMapping("/addUser")
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Responded", "SaveUser");

        this.userService.saveUser(user);
        return ResponseEntity.status(HttpStatus.ACCEPTED).headers(httpHeaders).body( user );
    }

    @PostMapping("/addUser2/{idRole}")
    public ResponseEntity<User> saveUser2(@RequestBody User user, @PathVariable int idRole)
    {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Responded", "SaveUser2");

        this.userService.saveUser2(user, idRole);
        return ResponseEntity.status(HttpStatus.ACCEPTED).headers(httpHeaders).body( user );
    }

    @PostMapping("/addUser3/{roleList}")
    public ResponseEntity<User> saveUser3(@RequestBody User user , @PathVariable List<Role> roleList)
    {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Responded", "SaveUser3");

        this.userService.saveUser3(user, roleList);
        return ResponseEntity.status(HttpStatus.ACCEPTED).headers(httpHeaders).body( user );
    }

    @GetMapping("/findRoleBy/{id}")
    public ResponseEntity<Role> findRoleById(@PathVariable int id)
    {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Responded", "FindRoleByID");

        Role role = this.userService.findRoleById(id);
        return ResponseEntity.status(HttpStatus.FOUND).headers(httpHeaders).body( role );
    }

    @GetMapping("/findUserBy/{id}")
    public ResponseEntity<User> findUserById(@PathVariable int id)
    {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Responded", "FindUserByID");

        User user = this.userService.findUserById(id);
        return ResponseEntity.status(HttpStatus.FOUND).headers(httpHeaders).body( user );
    }

    @GetMapping("/findAllRoles")
    public ResponseEntity<List<Role>> findAllRoles()
    {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Responded", "AllRoles");

        List<Role> roles = this.userService.findAllRoles();
        return ResponseEntity.status(HttpStatus.FOUND).headers(httpHeaders).body( roles );
    }


    @GetMapping("/allUsers")
    public ResponseEntity<List<User>> findAllUsers()
    {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Responded", "AllUsers");

        List<User> users = this.userService.findAllUsers();
        return ResponseEntity.status(HttpStatus.FOUND).headers(httpHeaders).body( users );
    }

    @DeleteMapping("/deleteUserById/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable int id)
    {
        User deletedUser = this.userService.findUserById(id);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Responded", "deleteUser");

        this.userService.deleteUserById(id);
        return ResponseEntity.status(HttpStatus.FOUND).headers(httpHeaders).body( deletedUser );
    }

    @PutMapping("/updateUser/{roleList}/{id}")
    public ResponseEntity<User> updateUser(@RequestBody User user , @PathVariable List<Role> roleList, @PathVariable int id)
    {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Responded", "updateUser");

        User updatedUser = this.userService.updateUser(user,roleList,id);
        return ResponseEntity.status(HttpStatus.FOUND).headers(httpHeaders).body(updatedUser);
    }

    @PutMapping("/updateRole/{id}")
    @ResponseBody
    public ResponseEntity<Role> updateRole(@RequestBody Role role, @PathVariable int id)
    {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Responded", "updateRole");

        Role updatedRole = userService.updateRole(role, id);;

        return ResponseEntity.status(HttpStatus.FOUND).headers(httpHeaders).body(updatedRole);
    }

    @GetMapping("/getUserDto/{id}")
    public ResponseEntity<UserDto> getUserDto(@PathVariable int id)
    {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Responded", "FindUserDto");

        UserDto userDto = this.userService.findUserDtoById(id);
        return ResponseEntity.status(HttpStatus.FOUND).headers(httpHeaders).body( userDto );
    }

    @GetMapping("/getAllUserDto")
    public ResponseEntity<List<UserDto>> getAllUserDto()
    {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Responded", "FindAllUserDto");

        List<UserDto> userDtoList = this.userService.findAllUsersDto();
        return ResponseEntity.status(HttpStatus.FOUND).headers(httpHeaders).body( userDtoList );
    }
}
