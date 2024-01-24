package com.scaler.userservice.Service;

import com.scaler.userservice.Models.User;
import com.scaler.userservice.Models.UserAddress;
import com.scaler.userservice.Models.UserAddressGeo;
import com.scaler.userservice.Models.UserName;
import com.scaler.userservice.dtos.FakeStoreUserDto;
import com.scaler.userservice.exceptions.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service("fakeStoreUserService")
public class FakeStoreUserService implements ServiceInterface{

    private RestTemplate restTemplate;

    @Autowired
    public FakeStoreUserService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    private final String fakeStoreUserUrl = "https://fakestoreapi.com/users";
    @Override
    public List<User> getAllUsers() {
        return null;
    }

//    public User convertFakeStoreUserDtoToUser(FakeStoreUserDto fakeStoreUserDto){
//        User user = new User();
//        user.setEmail(fakeStoreUserDto.getEmail());
//        user.setUsername(fakeStoreUserDto.getUsername());
//        user.setPassword(fakeStoreUserDto.getPassword());
//
//        user.getName().setFirstName(fakeStoreUserDto.getName().getFirstName());
//        user.getName().setLastName(fakeStoreUserDto.getName().getLastName());
//
//        user.getAddress().setCity(fakeStoreUserDto.getAddress().getCity());
//        user.getAddress().setStreet(fakeStoreUserDto.getAddress().getStreet());
//        user.getAddress().setNumber(fakeStoreUserDto.getAddress().getNumber());
//        user.getAddress().setZipcode(fakeStoreUserDto.getAddress().getZipcode());
//
//        user.getAddress().getGeo().setLatitude(fakeStoreUserDto.getAddress().getGeo().getLatitude());
//        user.getAddress().getGeo().setLongitude(fakeStoreUserDto.getAddress().getGeo().getLongitude());
//
////        UserName userName = new UserName();
////        userName.setFirstName(fakeStoreUserDto.getName().getFirstName());
////        userName.setLastName(fakeStoreUserDto.getName().getLastName());
////        user.setName(userName);
////
////        UserAddress userAddress = getUserAddress(fakeStoreUserDto);
////        user.setAddress(userAddress);
//        user.setPhone(fakeStoreUserDto.getPhone());
//
//        return user;
//    }


    private User convertFakeStoreUserDtoToUser(FakeStoreUserDto fakeStoreUser) {
        if(fakeStoreUser == null){
            return new User();
        }
        User user = new User();
        user.setId(fakeStoreUser.getId());
        user.setUsername(fakeStoreUser.getUsername());
        user.setEmail(fakeStoreUser.getEmail());
        user.setPassword(fakeStoreUser.getPassword());
        user.setName(new UserName());
        user.getName().setFirstName(fakeStoreUser.getName().getFirstName());
        user.getName().setLastName(fakeStoreUser.getName().getLastName());
        user.setAddress(new UserAddress());
        user.getAddress().setCity(fakeStoreUser.getAddress().getCity());
        user.getAddress().setStreet(fakeStoreUser.getAddress().getStreet());
        user.getAddress().setNumber(fakeStoreUser.getAddress().getNumber());
        user.getAddress().setZipcode(fakeStoreUser.getAddress().getZipcode());
        user.getAddress().setGeo(new UserAddressGeo());
        user.getAddress().getGeo().setLatitude(fakeStoreUser.getAddress().getGeo().getLatitude());
        user.getAddress().getGeo().setLongitude(fakeStoreUser.getAddress().getGeo().getLongitude());
        user.setPhone(fakeStoreUser.getPhone());
        return user;
    }

    private static UserAddress getUserAddress(FakeStoreUserDto fakeStoreUserDto) {

        UserAddress userAddress = new UserAddress();
        userAddress.setCity(fakeStoreUserDto.getAddress().getCity());
        userAddress.setStreet(fakeStoreUserDto.getAddress().getStreet());
        userAddress.setNumber(fakeStoreUserDto.getAddress().getNumber());
        userAddress.setZipcode(fakeStoreUserDto.getAddress().getZipcode());

        UserAddressGeo userAddressGeo = new UserAddressGeo();
        userAddressGeo.setLatitude(fakeStoreUserDto.getAddress().getGeo().getLatitude());
        userAddressGeo.setLongitude(fakeStoreUserDto.getAddress().getGeo().getLongitude());

        userAddress.setGeo(userAddressGeo);
        return userAddress;
    }

    @Override
    public User getSingleUser(Long id) throws ProductNotFoundException {
//        int i= 1 / 0;
        FakeStoreUserDto fakeStoreUserDto = restTemplate.getForObject(
                fakeStoreUserUrl + "/" + id,
                FakeStoreUserDto.class
        );

        if (fakeStoreUserDto == null){
            throw new ProductNotFoundException(
                    "User with id " + id + " nahi mila re baba"
            );
        }
        return convertFakeStoreUserDtoToUser(fakeStoreUserDto);



    }

    @Override
    public User createUser(User user) {
        FakeStoreUserDto userDto = restTemplate.postForObject(
                fakeStoreUserUrl,
                convertUserToFakeStoreUser(user),
                FakeStoreUserDto.class
        );
        return convertFakeStoreUserDtoToUser(userDto);
    }

    private FakeStoreUserDto convertUserToFakeStoreUser(User user) {
        FakeStoreUserDto fakeStoreUserDto = new FakeStoreUserDto();
        fakeStoreUserDto.setEmail(user.getEmail());
        fakeStoreUserDto.setUsername(user.getUsername());
        fakeStoreUserDto.setPassword(user.getPassword());

        fakeStoreUserDto.getName().setFirstName(user.getName().getFirstName());
        fakeStoreUserDto.getName().setLastName(user.getName().getLastName());

        fakeStoreUserDto.getAddress().setCity(user.getAddress().getCity());
        fakeStoreUserDto.getAddress().setStreet(user.getAddress().getStreet());
        fakeStoreUserDto.getAddress().setNumber(user.getAddress().getNumber());
        fakeStoreUserDto.getAddress().setZipcode(user.getAddress().getZipcode());

        fakeStoreUserDto.getAddress().getGeo().setLatitude(user.getAddress().getGeo().getLatitude());
        fakeStoreUserDto.getAddress().getGeo().setLongitude(user.getAddress().getGeo().getLongitude());

        fakeStoreUserDto.setPhone(user.getPhone());

        return fakeStoreUserDto;
    }

    @Override
    public User updateUser(Long id, User user) {
        return null;
    }

    @Override
    public boolean deleteUser(Long id) {
        return false;
    }

    @Override
    public User userLogin(String username, String password) {
        return null;
    }
}
