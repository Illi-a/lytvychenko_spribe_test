package spribe_test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import spribe.PlayerController;
import static org.testng.Assert.assertEquals;

public class PlayerControllerTest {
    private final int SUPER_ID = 1;
    private final int INVOCATION_COUNT = 3;
    private final String SUPERVISOR_EDITOR = "supervisor";

    @BeforeTest (alwaysRun = true)
    public void setUp(){
        RestAssured.baseURI = "http://3.68.165.45";
    }

    @DataProvider(name = "passwordNumberOfChar")
    public static Object[][] passwordNumberOfChar() {
        return new Object[][]{{7, true}, {10, true}, {15, true}, {6, false}, {16, false}, {0, false}};
    }

    @DataProvider(name = "age")
    public static Object[][] age() {
        return new Object[][]{{"16", true}, {"17", true}, {"45", true}, {"59", true}, {"0", false}, {"15", false}, {"60", false}, {"", false}};
    }


    @Test(groups = {"General", "Crucial"}, invocationCount = INVOCATION_COUNT)
    public void userCanBeCreatedWithValidDataTest() {
        PlayerController playerController = new PlayerController();
        int userId = playerController.createValidUser();
        playerController.deleteUser(userId);
    }

    @Test(groups = {"General", "Crucial"}, invocationCount = INVOCATION_COUNT)
    public void adminCanBeCreatedWithValidDataTest() {
        PlayerController playerController = new PlayerController();
        int adminId = playerController.createRandomAdmin();
        playerController.deleteUser(adminId);
    }

    @Test(groups = {"General", "Crucial"}, invocationCount = INVOCATION_COUNT)
    public void userCanBeCreatedWithValidDataByAdminTest() {
        PlayerController playerController = new PlayerController();
        String adminLogin = "UserByAdmin";

            int adminId = playerController.createRandomAdminWithCustomLogin(adminLogin);
            int userId = 0;
        try {
            userId = playerController.createValidUserByAdminWithValidData(adminLogin);
        } finally {
            playerController.deleteUser(userId);
            playerController.deleteUser(adminId);
        }
    }


    @Test(groups = {"General"}, expectedExceptions = java.lang.AssertionError.class, dependsOnGroups = "Crucial", invocationCount = INVOCATION_COUNT)
    public void userCantBeCreatedByUserTest() {
        PlayerController playerController = new PlayerController();
        String userLogin = "UserByUser";
        int user2Id = 0;

        int user1Id = playerController.createRandomUserWithCustomLogin(userLogin);
        try {
            user2Id = playerController.createUserByUserWithValidData(userLogin);
        } finally {
            playerController.deleteUser(user1Id);
            if (user2Id != 0) {
                playerController.deleteUser(user2Id);
            }
        }
    }

    @Test(groups = {"General"}, expectedExceptions = java.lang.AssertionError.class, dependsOnGroups = "Crucial", invocationCount = INVOCATION_COUNT)
    public void userCantBeCreatedWithEmptyEditor() {
        PlayerController playerController = new PlayerController();
        int userId = playerController.createRandomUserWithEmptyEditor();
        if (userId != 0) {
            playerController.deleteUser(userId);
        }
    }

    @Test(groups = {"General"}, expectedExceptions = java.lang.AssertionError.class, dependsOnGroups = "Crucial", invocationCount = INVOCATION_COUNT)
    public void userCantBeCreatedWithSupervisorRole() {
        PlayerController playerController = new PlayerController();
        int superId = playerController.createRandomSupervisor();
        if (superId != 0) {
            playerController.deleteUser(superId);
        }
    }

    @Test(groups = {"General"}, expectedExceptions = java.lang.AssertionError.class, dependsOnGroups = "Crucial", invocationCount = INVOCATION_COUNT)
    public void userCantBeCreatedWithOutRole() {
        PlayerController playerController = new PlayerController();
        int userId = playerController.createRandomUserWithOutRole();
        if (userId != 0) {
            playerController.deleteUser(userId);
        }
    }

    @Test(groups = {"General"}, expectedExceptions = java.lang.AssertionError.class, dependsOnGroups = "Crucial", invocationCount = INVOCATION_COUNT)
    public void userCantBeCreatedWithEmptyRole() {
        PlayerController playerController = new PlayerController();
        int userId = playerController.createRandomUserWithEmptyRole();
        if (userId != 0) {
            playerController.deleteUser(userId);
        }
    }

    @Test(groups = {"General"}, expectedExceptions = java.lang.AssertionError.class, dependsOnGroups = "Crucial", invocationCount = INVOCATION_COUNT)
    public void userCantBeCreatedWithCustomRole() {
        PlayerController playerController = new PlayerController();
        int userId = playerController.createRandomUserWithCustomRole("AnyRole");
        if (userId != 0) {
            playerController.deleteUser(userId);
        }
    }

    @Test(groups = {"General"}, expectedExceptions = java.lang.AssertionError.class, dependsOnGroups = "Crucial", invocationCount = INVOCATION_COUNT)
    public void usersWithSameLoginCantBeCreated() {
        PlayerController playerController = new PlayerController();
        String usersLogin = "sameUserLogin";
        int user2Id = 0;

        int user1Id = playerController.createRandomUserWithCustomLogin(usersLogin);
        try {
            user2Id = playerController.createRandomUserWithCustomLogin(usersLogin);
        } catch (java.lang.AssertionError e) {
            playerController.deleteUser(user2Id);
        } finally {
            playerController.deleteUser(user1Id);
        }
    }

    @Test(groups = {"General"}, expectedExceptions = java.lang.AssertionError.class, dependsOnGroups = "Crucial", invocationCount = INVOCATION_COUNT)
    public void userCantBeCreatedWithEmptyLogin() {
        PlayerController playerController = new PlayerController();
        int userId = playerController.createRandomUserWithCustomLogin("");

        if (userId != 0) {
            playerController.deleteUser(userId);
        }
    }

    @Test(groups = {"General"}, expectedExceptions = java.lang.AssertionError.class, dependsOnGroups = "Crucial", invocationCount = INVOCATION_COUNT)
    public void userCantBeCreatedWithoutLogin() {
        PlayerController playerController = new PlayerController();
        int userId = playerController.createRandomUserWithOutLogin();

        if (userId != 0) {
            playerController.deleteUser(userId);
        }
    }

    @Test(groups = {"General", "Re-Testing"}, expectedExceptions = java.lang.AssertionError.class, dependsOnGroups = "Crucial", invocationCount = INVOCATION_COUNT)
    public void usersWithSameScreenNameCantBeCreated() {
        PlayerController playerController = new PlayerController();
        String usersScreenName = "sameScreenName";
        int user2Id = 0;

        int user1Id = playerController.createRandomUserWithCustomScreenName(usersScreenName);
        try {
            user2Id = playerController.createRandomUserWithCustomScreenName(usersScreenName);
        } finally {
            if (user2Id != 0) {
                playerController.deleteUser(user2Id);
            }
            playerController.deleteUser(user1Id);
        }
    }

    @Test(groups = {"General"}, expectedExceptions = java.lang.AssertionError.class, dependsOnGroups = "Crucial", invocationCount = INVOCATION_COUNT)
    public void userCantBeCreatedWithEmptyScreenName() {
        PlayerController playerController = new PlayerController();
        int userId = playerController.createRandomUserWithCustomScreenName("");
        if (userId != 0) {
            playerController.deleteUser(userId);
        }
    }

    @Test(groups = {"General"}, expectedExceptions = java.lang.AssertionError.class, dependsOnGroups = "Crucial", invocationCount = INVOCATION_COUNT)
    public void userCantBeCreatedWithoutScreenName() {
        PlayerController playerController = new PlayerController();
        int userId = playerController.createRandomUserWithOutScreenName();
        if (userId != 0) {
            playerController.deleteUser(userId);
        }
    }

    @Test(groups = {"General"}, dependsOnGroups = "Crucial", invocationCount = INVOCATION_COUNT)
    public void userCanBeCreatedWithMaleGender() {
        PlayerController playerController = new PlayerController();
        int userId = 0;
        try {
            userId = playerController.createRandomUserWithCustomGender("male");
        } finally {
            playerController.deleteUser(userId);
        }
    }

    @Test(groups = {"General"}, dependsOnGroups = "Crucial", invocationCount = INVOCATION_COUNT)
    public void userCanBeCreatedWithFemaleGender() {
        PlayerController playerController = new PlayerController();
        int userId = 0;
        try {
            userId = playerController.createRandomUserWithCustomGender("female");
        } finally {
            playerController.deleteUser(userId);
        }
    }

    @Test(groups = {"General"}, expectedExceptions = java.lang.AssertionError.class, dependsOnGroups = "Crucial", invocationCount = INVOCATION_COUNT)
    public void userCantBeCreatedWithEmptyGender() {
        PlayerController playerController = new PlayerController();
        int userId = playerController.createRandomUserWithEmptyGender();
        if (userId != 0) {
            playerController.deleteUser(userId);
        }
    }

    @Test(groups = {"General", "Re-Testing"}, expectedExceptions = java.lang.AssertionError.class, dependsOnGroups = "Crucial", invocationCount = INVOCATION_COUNT)
    public void userCantBeCreatedWithGenderDifferentThanMaleOrFemale() {
        PlayerController playerController = new PlayerController();
        int userId = playerController.createRandomUserWithCustomGender("anyGender");
        if (userId != 0) {
            playerController.deleteUser(userId);
        }
    }

    @Test(groups = {"General"}, expectedExceptions = java.lang.AssertionError.class, dependsOnGroups = "Crucial", invocationCount = INVOCATION_COUNT)
    public void userCantBeCreatedWithOutGender() {
        PlayerController playerController = new PlayerController();
        int userId = playerController.createRandomUserWithOutGender();
        if (userId != 0) {
            playerController.deleteUser(userId);
        }
    }

    @Test(groups = {"General"}, dataProvider = "passwordNumberOfChar", dependsOnGroups = "Crucial", invocationCount = INVOCATION_COUNT)
    public void userPasswordTest(Integer numberOfChar, Boolean expectedResult) {
        PlayerController playerController = new PlayerController();
        boolean actualResult = true;
        int userId = 0;
        try {
            userId = playerController.createRandomUserWithCustomPasswordNumberOfChar(numberOfChar);
        } catch (java.lang.AssertionError e) {
            actualResult = false;
        } finally {
            if (actualResult) {
                playerController.deleteUser(userId);
            }
            assertEquals(actualResult, expectedResult);
        }
    }

    @Test(groups = {"General", "Re-Testing"}, expectedExceptions = java.lang.AssertionError.class, dependsOnGroups = "Crucial", invocationCount = INVOCATION_COUNT)
    public void userCantBeCreatedWithOutPassword() {
        PlayerController playerController = new PlayerController();
        int userId = playerController.createRandomUserWithOutPassword();
        if (userId != 0) {
            playerController.deleteUser(userId);
        }
    }

    @Test(groups = {"General", "Re-Testing"}, expectedExceptions = java.lang.AssertionError.class, dependsOnGroups = "Crucial", invocationCount = INVOCATION_COUNT)
    public void userCantBeCreatedWithSpecialSymbolsInPassword() {
        PlayerController playerController = new PlayerController();

        int userId = playerController.createRandomUserWithCustomPassword("qwerty!?*");
        if (userId != 0) {
            playerController.deleteUser(userId);
        }
    }

    @Test(groups = {"General", "Re-Testing"}, dataProvider = "age", dependsOnGroups = "Crucial", invocationCount = INVOCATION_COUNT)
    public void userAgeTest(String age, Boolean expectedResult) {
        PlayerController playerController = new PlayerController();
        boolean actualResult = true;
        int userId = 0;
        try {
            userId = playerController.createRandomUserWithCustomAge(age);
        } catch (java.lang.AssertionError e) {
            actualResult = false;
        } finally {
            if (actualResult) {
                playerController.deleteUser(userId);
            }
            assertEquals(actualResult, expectedResult);
        }
    }

    @Test(groups = {"General"}, expectedExceptions = java.lang.AssertionError.class, dependsOnGroups = "Crucial", invocationCount = INVOCATION_COUNT)
    public void userCantBeCreatedWithOutAge() {
        PlayerController playerController = new PlayerController();

        int userId = playerController.createRandomUserWithOutAge();
        if (userId != 0) {
            playerController.deleteUser(userId);
        }
    }

    @Test(groups = {"General"}, dependsOnGroups = "Crucial", invocationCount = INVOCATION_COUNT)
    public void userCanBeDeletedBySupervisor() {
        PlayerController playerController = new PlayerController();
        int userId = playerController.createValidUser();
            playerController.deleteUserUsingCustomEditor(SUPERVISOR_EDITOR, userId);
    }

    @Test(groups = {"General"}, dependsOnGroups = "Crucial", invocationCount = INVOCATION_COUNT)
    public void userCanBeDeletedByAdmin() {
        PlayerController playerController = new PlayerController();
        String adminLogin = "adminDelUser";
        int adminId = playerController.createRandomAdminWithCustomLogin(adminLogin);
        int userId = playerController.createValidUser();
        try {
            playerController.deleteUserUsingCustomEditor(adminLogin, userId);
        }finally {
            playerController.deleteUser(adminId);
        }
    }

    @Test(groups = {"General", "Re-Testing"}, expectedExceptions = java.lang.AssertionError.class, dependsOnGroups = "Crucial", invocationCount = INVOCATION_COUNT)
    public void userCantBeDeletedByUser() {
        PlayerController playerController = new PlayerController();
        String userLogin = "userDelUser";
        int user1Id = playerController.createRandomUserWithCustomLogin(userLogin);
        int user2Id = playerController.createValidUser();
        try {
            playerController.deleteUserUsingCustomEditor(userLogin, user2Id);
        } catch (java.lang.AssertionError e){
            playerController.deleteUser(user2Id);
        } finally {
            playerController.deleteUser(user1Id);
        }
    }

    @Test(groups = {"General"}, dependsOnGroups = "Crucial", invocationCount = INVOCATION_COUNT)
    public void adminCanBeDeletedBySupervisor() {
        PlayerController playerController = new PlayerController();
        int userId = playerController.createValidUser();
            playerController.deleteUserUsingCustomEditor(SUPERVISOR_EDITOR, userId);
    }

    @Test(groups = {"General"}, dependsOnGroups = "Crucial", invocationCount = INVOCATION_COUNT)
    public void adminCanBeDeletedByAdmin() {
        PlayerController playerController = new PlayerController();
        String adminLogin = "adminDelAdmin";
        int admin1Id = playerController.createRandomAdminWithCustomLogin(adminLogin);
        int admin2Id = playerController.createValidUser();
        try {
            playerController.deleteUserUsingCustomEditor(adminLogin, admin2Id);
        } finally {
            playerController.deleteUser(admin1Id);
        }
    }


    @Test(groups = {"General", "Re-Testing"}, expectedExceptions = java.lang.AssertionError.class, dependsOnGroups = "Crucial", invocationCount = INVOCATION_COUNT)
    public void adminCantBeDeletedByUser() {
        PlayerController playerController = new PlayerController();
        String userLogin = "userDelAdmin";
        int userId = playerController.createRandomUserWithCustomLogin(userLogin);
        int adminId = playerController.createValidUser();
        try {
            playerController.deleteUserUsingCustomEditor(userLogin, adminId);
        } catch (java.lang.AssertionError e) {
            playerController.deleteUser(adminId);
        } finally {
            playerController.deleteUser(userId);
        }
    }

    @Test(groups = {"General"}, expectedExceptions = java.lang.AssertionError.class, dependsOnGroups = "Crucial", invocationCount = INVOCATION_COUNT)
    public void supervisorCantBeDeletedBySupervisor() {
        PlayerController playerController = new PlayerController();
        playerController.deleteUserUsingCustomEditor(SUPERVISOR_EDITOR, SUPER_ID);
    }

    @Test(groups = {"General"}, expectedExceptions = java.lang.AssertionError.class, dependsOnGroups = "Crucial", invocationCount = INVOCATION_COUNT)
    public void supervisorCantBeDeletedByAdmin() {
        PlayerController playerController = new PlayerController();
        String adminLogin = "adminDelSup";

        int adminId = playerController.createRandomAdminWithCustomLogin(adminLogin);
        try {
            playerController.deleteUserUsingCustomEditor(adminLogin, SUPER_ID);
        } finally {
            playerController.deleteUser(adminId);
        }
    }


    @Test(groups = {"General"}, expectedExceptions = java.lang.AssertionError.class, dependsOnGroups = "Crucial", invocationCount = INVOCATION_COUNT)
    public void supervisorCantBeDeletedByUser() {
        PlayerController playerController = new PlayerController();
        String userLogin = "userDelSup";
        int userId = playerController.createRandomUserWithCustomLogin(userLogin);

        try {
            playerController.deleteUserUsingCustomEditor(userLogin, 1);
        } finally {
                playerController.deleteUser(userId);
        }
    }

    @Test(groups = {"General"}, expectedExceptions = java.lang.AssertionError.class, dependsOnGroups = "Crucial", invocationCount = INVOCATION_COUNT)
    public void userCantBeDeletedByHimself() {
        PlayerController playerController = new PlayerController();
        String userLogin = "userDelHimself";
        int userId = playerController.createRandomUserWithCustomLogin(userLogin);
        try {
            playerController.deleteUserUsingCustomEditor(userLogin, userId);
        } catch (java.lang.AssertionError e) {
            playerController.deleteUser(userId);
        }
    }


    @Test(groups = {"General"}, expectedExceptions = java.lang.AssertionError.class, dependsOnGroups = "Crucial", invocationCount = INVOCATION_COUNT)
    public void userCantBeCreatedWithRandomEditor() {
        PlayerController playerController = new PlayerController();
        String editor = "RndmEditor";
        int userId = 0;
        try {
            userId = playerController.createRandomUserWithCustomEditor(editor);
        } finally {
            if (userId != 0) {
                playerController.deleteUser(userId);
            }
        }
    }

    @Test(groups = {"General"}, dependsOnGroups = "Crucial", invocationCount = INVOCATION_COUNT)
    public void userCanBeEditedBySupervisor() {
        PlayerController playerController = new PlayerController();
        int userId = playerController.createValidUser();
        try {
            playerController.editUser(SUPERVISOR_EDITOR, userId, "user");
        } finally {
            playerController.deleteUser(userId);
        }
    }

    @Test(groups = {"General"}, dependsOnGroups = "Crucial", invocationCount = INVOCATION_COUNT)
    public void adminCanBeEditedBySupervisor() {
        PlayerController playerController = new PlayerController();
        int adminId = playerController.createRandomAdmin();
        try {
            playerController.editUser(SUPERVISOR_EDITOR, adminId, "admin");
        } finally {
            playerController.deleteUser(adminId);
        }
    }

    @Test(enabled = false, groups = {"General"}, expectedExceptions = java.lang.AssertionError.class, dependsOnGroups = "Crucial", invocationCount = INVOCATION_COUNT)
    public void supervisorCantBeEditedBySupervisor() {
        PlayerController playerController = new PlayerController();
        playerController.editUser("YKvLsHsH", SUPER_ID, "admin");
    }

    @Test(groups = {"General", "Re-Testing"}, expectedExceptions = java.lang.AssertionError.class, dependsOnGroups = "Crucial", invocationCount = INVOCATION_COUNT)
    public void userCantBeEditedByAdmin() {
        PlayerController playerController = new PlayerController();
        String adminLogin = "admEditUser";
        int userId = playerController.createValidUser();
        int adminId = playerController.createRandomAdminWithCustomLogin(adminLogin);
        try {
            playerController.editUser(adminLogin, userId, "user");
        } finally {
            playerController.deleteUser(userId);
            playerController.deleteUser(adminId);
        }
    }

    @Test(groups = {"General", "Re-Testing"}, expectedExceptions = java.lang.AssertionError.class, dependsOnGroups = "Crucial", invocationCount = INVOCATION_COUNT)
    public void adminCantBeEditedByAdmin() {
        PlayerController playerController = new PlayerController();
        String adminLogin = "admEditAdm";
        int admin1Id = playerController.createRandomAdmin();
        int admin2Id = playerController.createRandomAdminWithCustomLogin(adminLogin);
        try {
            playerController.editUser(adminLogin, admin1Id, "admin");
        } finally {
            playerController.deleteUser(admin1Id);
            playerController.deleteUser(admin2Id);
        }
    }

    @Test(groups = {"General"}, dependsOnGroups = "Crucial", invocationCount = INVOCATION_COUNT)
    public void userCanBeEditedByHimself() {
        PlayerController playerController = new PlayerController();
        String userLogin = "userEdinHimself";
        int userId = playerController.createRandomUserWithCustomLogin(userLogin);
        try {
            playerController.editUser(userLogin, userId, "user");
        } finally {
            playerController.deleteUser(userId);
        }
    }

    @Test(groups = {"General", "Re-Testing"}, expectedExceptions = java.lang.AssertionError.class, dependsOnGroups = "Crucial", invocationCount = INVOCATION_COUNT)
    public void userCantBeEditedByAnotherUser() {
        PlayerController playerController = new PlayerController();
        String userLogin = "userEditUser";
        int user1Id = playerController.createRandomUserWithCustomLogin(userLogin);
        int user2Id = playerController.createValidUser();
        try {
            playerController.editUser(userLogin, user2Id, "user");
        } finally {
            playerController.deleteUser(user1Id);
            playerController.deleteUser(user2Id);
        }
    }

    @Test(groups = {"General", "Re-Testing"}, expectedExceptions = java.lang.AssertionError.class, dependsOnGroups = "Crucial", invocationCount = INVOCATION_COUNT)
    public void adminCantBeEditedByUser() {
        PlayerController playerController = new PlayerController();
        String userLogin = "userEdinAdmin";
        int userId = playerController.createRandomUserWithCustomLogin(userLogin);
        int adminId = playerController.createRandomAdmin();
        try {
            playerController.editUser(userLogin, adminId, "admin");
        } finally {
            playerController.deleteUser(userId);
            playerController.deleteUser(adminId);
        }
    }

    @Test(groups = {"General"}, dependsOnGroups = "Crucial", invocationCount = INVOCATION_COUNT)
    public void userAgeCanBeEdited(){
        PlayerController playerController = new PlayerController();
        int userId = playerController.createRandomUserWithCustomAge("25");
        try {
            playerController.editUserAge(SUPERVISOR_EDITOR, userId, 30);
        } finally {
            playerController.deleteUser(userId);
        }
    }

    @Test(groups = {"General"}, dependsOnGroups = "Crucial", invocationCount = INVOCATION_COUNT)
    public void userGenderCanBeEdited(){
        PlayerController playerController = new PlayerController();
        int userId = playerController.createRandomUserWithCustomGender("male");
        try {
            playerController.editUserSpecificField(SUPERVISOR_EDITOR, userId, "gender", "female");
        } finally {
            playerController.deleteUser(userId);
        }
    }

    @Test(groups = {"General"}, dependsOnGroups = "Crucial", invocationCount = INVOCATION_COUNT)
    public void userLoginCanBeEdited(){
        PlayerController playerController = new PlayerController();
        int userId = playerController.createRandomUserWithCustomLogin("beforeEdtLogin");
        try {
            playerController.editUserSpecificField("supervisor", userId, "login", "editedLogin");
        } finally {
            playerController.deleteUser(userId);
        }
    }

    @Test(groups = {"General"}, dependsOnGroups = "Crucial", invocationCount = INVOCATION_COUNT)
    public void userScreenNameCanBeEdited(){
        PlayerController playerController = new PlayerController();
        int userId = playerController.createRandomUserWithCustomPassword("q22ty123");
        try {
            playerController.editUserSpecificField(SUPERVISOR_EDITOR, userId, "screenName", "screen123");
        } finally {
            playerController.deleteUser(userId);
        }
    }



    @Test(groups = {"General"}, dependsOnGroups = "Crucial", invocationCount = INVOCATION_COUNT)
    public void getUserPositiveTest() {
        PlayerController playerController = new PlayerController();
        int userId = playerController.createCustomUser();
        JsonPath jsp;
        try {
            jsp = playerController.getPlayerById(userId);
        } finally {
            playerController.deleteUser(userId);
        }
        System.out.println(jsp.getString("login"));
        assertEquals(jsp.getString("login"), "cstmLogin");
        assertEquals(jsp.getString("screenName"), "cstmScreenName");
    }

    @Test(groups = {"General", "Re-Testing"}, expectedExceptions = java.lang.AssertionError.class, dependsOnGroups = "Crucial", invocationCount = INVOCATION_COUNT)
    public void getUserNegativeTest() {
        PlayerController playerController = new PlayerController();
        playerController.getPlayerByIdStatusCode(174723);
    }
}