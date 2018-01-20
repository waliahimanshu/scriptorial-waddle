package com.scriptorial.waddle.home;

import com.google.firebase.auth.FirebaseUser;
import com.scriptorial.waddle.database.user.User;
import com.scriptorial.waddle.database.user.UserRepository;


public class HomeViewModel {

    private final HomeNavigator homeNavigator;
    private final FirebaseWrapper firebaseWrapper;
    private final UserRepository userRepository;

    public HomeViewModel(HomeNavigator homeNavigator, FirebaseWrapper firebaseWrapper, UserRepository userRepository) {
        this.homeNavigator = homeNavigator;
        this.firebaseWrapper = firebaseWrapper;
        this.userRepository = userRepository;
    }

    private void doUserLogin() {
        homeNavigator.launchLoginScreen();
    }

    private void doUserSignOut() {
        homeNavigator.launchLoginScreen();
    }

    private void addPost() {
        homeNavigator.launchWriterInputScreen();
    }

    public void handleLogin() {
        FirebaseUser currentUser = firebaseWrapper.getFirebaseAuthentication().getCurrentUser();
        if (currentUser == null) {
            doUserLogin();
        } else {
            String[] split = currentUser.getDisplayName().split(" ");

            if (userRepository.findUserById(currentUser.getUid()) != null) {
                userRepository.insertUser(
                        new User(currentUser.getUid(), split[0], split[1], currentUser.getPhotoUrl().toString()));
            }
        }
    }
}
