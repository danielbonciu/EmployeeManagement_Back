package com.ausy_technologies.demospring.Service;

import com.ausy_technologies.demospring.Model.DAO.Role;
import com.ausy_technologies.demospring.Model.DAO.User;
import com.ausy_technologies.demospring.Model.DTO.UserDto;
import com.ausy_technologies.demospring.Repository.RoleRepository;
import com.ausy_technologies.demospring.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;


    public Role saveRole(Role role) {
        return this.roleRepository.save(role);
    }


    public User saveUser(User user) {
        return this.userRepository.save(user);
    }

    public User saveUser2(User user ,int idRole)
    {
        if(this.roleRepository.findById(idRole).isPresent()) {
            Role role = this.roleRepository.findById(idRole).get();
            List<Role> roleList =new ArrayList<>();
            roleList.add(role);
            user.setRoleList(roleList);
            return this.userRepository.save(user);
        }
        else
       {
           throw new RuntimeException("Role not found");
       }
    }

    public User saveUser3(  User user ,List<Role> roleList)
    {
        user.setRoleList(roleList);
        return this.userRepository.save(user);
    }

    public Role findRoleById(int id)
    {
        return this.roleRepository.findById(id).get();

    }

    public User findUserById(int id)
    {
        return this.userRepository.findById(id);

    }

    public List<Role> findAllRoles()
    {
        return this.roleRepository.findAll();
    }

    public List<User> findAllUsers()
    {
        return this.userRepository.findAll();
    }

    public void deleteUserById(int id)
    {
        this.userRepository.deleteById(id);
    }

    public User updateUser(User user ,List<Role> roleList, int id)
    {
        User updatedUser = this.userRepository.findById(id);
        updatedUser.setFirstName(user.getFirstName());
        updatedUser.setLastName(user.getLastName());
        updatedUser.setBirthday(user.getBirthday());
        updatedUser.setEmail(user.getEmail());
        updatedUser.setUsername(user.getUsername());
        updatedUser.setRoleList(roleList);
        return this.userRepository.save(updatedUser);
    }

    public Role updateRole(Role role, int id)
    {
        Role updatedRole;

        updatedRole = this.roleRepository.findById(id).get();
        updatedRole.setName(role.getName());
        this.roleRepository.save(updatedRole);

        return updatedRole;
    }

    private UserDto UserMapping(User user){
        if(user != null){
            UserDto userDto = new UserDto();
            userDto.setId(user.getId());
            userDto.setUsername(user.getUsername());
            userDto.setEmail(user.getEmail());
            List<String> roleList;
            roleList = user.getRoleList().stream().map(r -> r.getName()).collect(Collectors.toList());
            userDto.setRoleList(roleList);
            return userDto;
        }
        return null;
    }

    public UserDto findUserDtoById(int id){
        return UserMapping(this.userRepository.findById(id));
    }

    public List<UserDto> findAllUsersDto(){
        List<UserDto> userDtoList = new ArrayList<>();

        List<User> userList = this.userRepository.findAll();

        for(User temp : userList){
            userDtoList.add(UserMapping(temp));
        }

        return userDtoList;
    }

}
