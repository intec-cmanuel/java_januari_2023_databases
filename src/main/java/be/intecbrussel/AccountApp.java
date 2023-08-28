package be.intecbrussel;

import be.intecbrussel.model.Account;
import be.intecbrussel.model.User;
import be.intecbrussel.service.LoginService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class AccountApp {
    public static void main(String[] args) {
        System.out.println("Hello visitor");
        System.out.println("1. Register - 2. Login - 3. Add Multiple Users");
        Scanner scanner = new Scanner(System.in);
        int userChoice = scanner.nextInt();




        switch (userChoice) {
            case 1:
                register();
                break;
            case 2:
                login();
                break;
            case 3 :
                batchInsert();
                break;
            default:
                System.out.println("WRONG INPUT");

        }
    }

    private static void batchInsert() {
        List<User> userList = new ArrayList<>();

        for (int i = 5; i > 0; i-- ) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("first name");
            String fname = scanner.nextLine();

            System.out.println("last name");
            String lname = scanner.nextLine();

            System.out.println("email");
            String email = scanner.nextLine();

            System.out.println("password");
            String passw = scanner.nextLine();

            User user = new User(fname,lname,new Account(email, passw));
            userList.add(user);
        }

        LoginService loginService = new LoginService();
        loginService.registerManyUsers(userList);
    }

    private static void register() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What is your first name");
        String fname = scanner.nextLine();

        System.out.println("What is your last name");
        String lname = scanner.nextLine();

        System.out.println("What is your email");
        String email = scanner.nextLine();

        System.out.println("What is your password");
        String passw = scanner.nextLine();

        LoginService loginService = new LoginService();
        boolean success = loginService.register(fname, lname, email, passw);

        if (success) {
            System.out.printf("Welcome %s %s. Your account has been registered", fname, lname);
        } else {
            System.out.println("Something went boom.");
        }
    }

    private static void login() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("What is your email");
        String email = scanner.nextLine();

        System.out.println("What is your password");
        String passw = scanner.nextLine();

        LoginService loginService = new LoginService();

        Optional<User> userSuccessLogin = loginService.login(email, passw);

        if (userSuccessLogin.isPresent()) {
            System.out.println(userSuccessLogin.get());
            System.out.println("Successfully logged in");
        } else {
            System.out.println("Email or password don't match");
        }


    }
}

