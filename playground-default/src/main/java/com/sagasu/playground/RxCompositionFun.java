package com.sagasu.playground;

import rx.Observable;

import java.util.*;

public class RxCompositionFun {
    public static void main(String[] args) {
        Object waitMonitor = new Object();
        synchronized (waitMonitor){
            UserService us = new UserService();
            Observable.from(us.fetchUserList())
                    .map((user) -> user.getSecurityStatus() != UserSecurityStatus.Adminstrator)
                    .toSortedList();
        }
    }
}

class UserService{
    private final ArrayList<User> allUsers;
    public UserService(){
        allUsers = new ArrayList<User>();
        allUsers.add(new User("bob", "doe",  UserSecurityStatus.Guest));
        allUsers.add(new User("signum", "deem",  UserSecurityStatus.Adminstrator));
        allUsers.add(new User("mat", "bat",  UserSecurityStatus.Guest));
        allUsers.add(new User("booo", "bor",  UserSecurityStatus.Moderator));
        allUsers.add(new User("foo", "bar",  UserSecurityStatus.Adminstrator));


    }

    public List<User> fetchUserList(){
        return Collections.unmodifiableList(allUsers);
    }
}

class User{

    private final String bob;
    private final String doe;
    private final UserSecurityStatus uss;

    public User(String bob, String doe, UserSecurityStatus uss) {

        this.bob = bob;
        this.doe = doe;
        this.uss = uss;
    }
    public UserSecurityStatus getSecurityStatus(){
        return uss;
    }
}
