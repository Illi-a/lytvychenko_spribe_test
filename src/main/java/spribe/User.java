package spribe;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.LinkedHashMap;

public class User {


    public LinkedHashMap createRandomValidUser() {
        LinkedHashMap<String, String> validUser = new LinkedHashMap<>();
        validUser.put("age", "20");
        validUser.put("gender", "male");
        validUser.put("login", RandomStringUtils.randomAlphabetic(10));
        validUser.put("password", RandomStringUtils.randomAlphabetic(10));
        validUser.put("role", "user");
        validUser.put("screenName", RandomStringUtils.randomAlphabetic(5, 10));
        return validUser;
    }

    public LinkedHashMap createCustomUser() {
        LinkedHashMap<String, String> validUser = new LinkedHashMap<>();
        validUser.put("age", "23");
        validUser.put("gender", "male");
        validUser.put("login", "cstmLogin");
        validUser.put("password", "cstmPassword");
        validUser.put("role", "user");
        validUser.put("screenName", "cstmScreenName");
        return validUser;
    }

    public LinkedHashMap createRandomUserWithCustomAge(String age) {
        LinkedHashMap<String, String> userWithCustomAge = new LinkedHashMap<>();
        userWithCustomAge.put("age", age);
        userWithCustomAge.put("gender", "male");
        userWithCustomAge.put("login", RandomStringUtils.randomAlphabetic(5, 10));
        userWithCustomAge.put("password", RandomStringUtils.randomAlphabetic(5, 10));
        userWithCustomAge.put("role", "user");
        userWithCustomAge.put("screenName", RandomStringUtils.randomAlphabetic(5, 10));
        return userWithCustomAge;
    }

    public LinkedHashMap createRandomUserWithOutAge() {
        LinkedHashMap<String, String> userWithOutAge = new LinkedHashMap<>();
        userWithOutAge.put("gender", "male");
        userWithOutAge.put("login", RandomStringUtils.randomAlphabetic(5, 10));
        userWithOutAge.put("password", RandomStringUtils.randomAlphabetic(5, 10));
        userWithOutAge.put("role", "user");
        userWithOutAge.put("screenName", RandomStringUtils.randomAlphabetic(5, 10));
        return userWithOutAge;
    }

    public LinkedHashMap createRandomUserWithCustomLogin(String login) {
        LinkedHashMap<String, String> validUserWithCustomLogin = new LinkedHashMap<>();
        validUserWithCustomLogin.put("age", "20");
        validUserWithCustomLogin.put("gender", "male");
        validUserWithCustomLogin.put("login", login);
        validUserWithCustomLogin.put("password", RandomStringUtils.randomAlphabetic(5, 10));
        validUserWithCustomLogin.put("role", "user");
        validUserWithCustomLogin.put("screenName", RandomStringUtils.randomAlphabetic(5, 10));
        return validUserWithCustomLogin;
    }

    public LinkedHashMap createRandomUserWithoutLogin() {
        LinkedHashMap<String, String> userserWithOutLogin = new LinkedHashMap<>();
        userserWithOutLogin.put("age", "20");
        userserWithOutLogin.put("gender", "male");
        userserWithOutLogin.put("password", RandomStringUtils.randomAlphabetic(5, 10));
        userserWithOutLogin.put("role", "user");
        userserWithOutLogin.put("screenName", RandomStringUtils.randomAlphabetic(5, 10));
        return userserWithOutLogin;
    }

    public LinkedHashMap createRandomUserWithCustomPasswordNumberOfChar(Integer numberOfChar) {
        LinkedHashMap<String, String> userWithCustomPassword = new LinkedHashMap<>();
        userWithCustomPassword.put("age", "20");
        userWithCustomPassword.put("gender", "male");
        userWithCustomPassword.put("login", RandomStringUtils.randomAlphabetic(5, 10));
        userWithCustomPassword.put("password", RandomStringUtils.randomAlphabetic(numberOfChar));
        userWithCustomPassword.put("role", "user");
        userWithCustomPassword.put("screenName", RandomStringUtils.randomAlphabetic(5, 10));
        return userWithCustomPassword;
    }

    public LinkedHashMap createRandomUserWithCustomPassword(String password) {
        LinkedHashMap<String, String> userWithCustomPassword = new LinkedHashMap<>();
        userWithCustomPassword.put("age", "20");
        userWithCustomPassword.put("gender", "male");
        userWithCustomPassword.put("login", RandomStringUtils.randomAlphabetic(5, 10));
        userWithCustomPassword.put("password", password);
        userWithCustomPassword.put("role", "user");
        userWithCustomPassword.put("screenName", RandomStringUtils.randomAlphabetic(5, 10));
        return userWithCustomPassword;
    }

    public LinkedHashMap createRandomUserWithOutPassword() {
        LinkedHashMap<String, String> userWithOutPassword = new LinkedHashMap<>();
        userWithOutPassword.put("age", "20");
        userWithOutPassword.put("gender", "male");
        userWithOutPassword.put("login", RandomStringUtils.randomAlphabetic(5, 10));
        userWithOutPassword.put("role", "user");
        userWithOutPassword.put("screenName", RandomStringUtils.randomAlphabetic(5, 10));
        return userWithOutPassword;
    }

    public LinkedHashMap createRandomSupervisor() {
        LinkedHashMap<String, String> userWithSupervisorRole = new LinkedHashMap<>();
        userWithSupervisorRole.put("age", "20");
        userWithSupervisorRole.put("gender", "male");
        userWithSupervisorRole.put("login", RandomStringUtils.randomAlphabetic(5, 10));
        userWithSupervisorRole.put("password", RandomStringUtils.randomAlphabetic(5, 10));
        userWithSupervisorRole.put("role", "supervisor");
        userWithSupervisorRole.put("screenName", RandomStringUtils.randomAlphabetic(5, 10));
        return userWithSupervisorRole;
    }

    public LinkedHashMap createRandomUserWithCustomScreenName(String screenName) {
        LinkedHashMap<String, String> validUserWithCustomScreenName = new LinkedHashMap<>();
        validUserWithCustomScreenName.put("age", "20");
        validUserWithCustomScreenName.put("gender", "male");
        validUserWithCustomScreenName.put("login", RandomStringUtils.randomAlphabetic(5, 10));
        validUserWithCustomScreenName.put("password", RandomStringUtils.randomAlphabetic(5, 10));
        validUserWithCustomScreenName.put("role", "user");
        validUserWithCustomScreenName.put("screenName", screenName);
        return validUserWithCustomScreenName;
    }

    public LinkedHashMap createRandomUserWithOutScreenName() {
        LinkedHashMap<String, String> validUserWithCustomScreenName = new LinkedHashMap<>();
        validUserWithCustomScreenName.put("age", "20");
        validUserWithCustomScreenName.put("gender", "male");
        validUserWithCustomScreenName.put("login", RandomStringUtils.randomAlphabetic(5, 10));
        validUserWithCustomScreenName.put("password", RandomStringUtils.randomAlphabetic(5, 10));
        validUserWithCustomScreenName.put("role", "user");
        return validUserWithCustomScreenName;
    }

    public LinkedHashMap createRandomUserWithOutRole() {
        LinkedHashMap<String, String> userWithOutRole = new LinkedHashMap<>();
        userWithOutRole.put("age", "20");
        userWithOutRole.put("gender", "male");
        userWithOutRole.put("login", RandomStringUtils.randomAlphabetic(5, 10));
        userWithOutRole.put("password", RandomStringUtils.randomAlphabetic(5, 10));
        userWithOutRole.put("screenName", RandomStringUtils.randomAlphabetic(5, 10));
        return userWithOutRole;
    }

        public LinkedHashMap createRandomUserWithEmptyRole() {
        LinkedHashMap<String, String> userWithEmptyRole = new LinkedHashMap<>();
        userWithEmptyRole.put("age", "20");
        userWithEmptyRole.put("gender", "male");
        userWithEmptyRole.put("login", RandomStringUtils.randomAlphabetic(5, 10));
        userWithEmptyRole.put("password", RandomStringUtils.randomAlphabetic(5, 10));
        userWithEmptyRole.put("role", "");
        userWithEmptyRole.put("screenName", RandomStringUtils.randomAlphabetic(5, 10));
        return userWithEmptyRole;
    }

    public LinkedHashMap createRandomUserWithCustomRole(String role) {
        LinkedHashMap<String, String> userWithCustomRole = new LinkedHashMap<>();
        userWithCustomRole.put("age", "20");
        userWithCustomRole.put("gender", "male");
        userWithCustomRole.put("login", RandomStringUtils.randomAlphabetic(5, 10));
        userWithCustomRole.put("password", RandomStringUtils.randomAlphabetic(5, 10));
        userWithCustomRole.put("role", role);
        userWithCustomRole.put("screenName", RandomStringUtils.randomAlphabetic(5, 10));
        return userWithCustomRole;
    }

    public LinkedHashMap createRandomUserWithCustomGender(String gender) {
        LinkedHashMap<String, String> validUserWithCustomGender = new LinkedHashMap<>();
        validUserWithCustomGender.put("age", "20");
        validUserWithCustomGender.put("gender", gender);
        validUserWithCustomGender.put("login", RandomStringUtils.randomAlphabetic(5, 10));
        validUserWithCustomGender.put("password", RandomStringUtils.randomAlphabetic(5, 10));
        validUserWithCustomGender.put("role", "user");
        validUserWithCustomGender.put("screenName", RandomStringUtils.randomAlphabetic(5, 10));
        return validUserWithCustomGender;
    }

    public LinkedHashMap createRandomUserWithOutGender() {
        LinkedHashMap<String, String> UserWithCustomGender = new LinkedHashMap<>();
        UserWithCustomGender.put("age", "20");
        UserWithCustomGender.put("login", RandomStringUtils.randomAlphabetic(5, 10));
        UserWithCustomGender.put("password", RandomStringUtils.randomAlphabetic(5, 10));
        UserWithCustomGender.put("role", "user");
        UserWithCustomGender.put("screenName", RandomStringUtils.randomAlphabetic(5, 10));
        return UserWithCustomGender;
    }

    public LinkedHashMap createRandomValidAdmin() {
        LinkedHashMap<String, String> validAdmin = new LinkedHashMap<>();
        validAdmin.put("age", "20");
        validAdmin.put("gender", "male");
        validAdmin.put("login", RandomStringUtils.randomAlphabetic(10));
        validAdmin.put("password", RandomStringUtils.randomAlphabetic(10));
        validAdmin.put("role", "admin");
        validAdmin.put("screenName", RandomStringUtils.randomAlphabetic(5, 10));
        return validAdmin;
    }

    public LinkedHashMap createRandomAdminWithCustomLogin(String login) {
        LinkedHashMap<String, String> validAdminWithCustomLogin = new LinkedHashMap<>();
        validAdminWithCustomLogin.put("age", "20");
        validAdminWithCustomLogin.put("gender", "male");
        validAdminWithCustomLogin.put("login", login);
        validAdminWithCustomLogin.put("password", RandomStringUtils.randomAlphabetic(10));
        validAdminWithCustomLogin.put("role", "admin");
        validAdminWithCustomLogin.put("screenName", RandomStringUtils.randomAlphabetic(5, 10));
        return validAdminWithCustomLogin;
    }
}

