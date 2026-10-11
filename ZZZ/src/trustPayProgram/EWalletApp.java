package trustPayProgram;
import javax.swing.*;
public class EWalletApp {
    private static final EWalletApp instance = new EWalletApp();
    private final UserManager userManager = new UserManager();
    private final MainMenuScreen mainMenuScreen = new MainMenuScreen(userManager);

    public static EWalletApp getInstance() {
        return instance;
    }

    public UserManager getUserManager() {
        return userManager; 
    }
    public void loadData() {
        userManager.loadData();
    }

    public void saveData() {
        userManager.saveData();
    }
    public void showLoginScreen() {
    	JFrame loginFrame = new JFrame("Trust Pay Login");
        LoginScreen loginScreen = new LoginScreen(userManager, mainMenuScreen, loginFrame);
        loginScreen.showLoginScreen();  
    }
}
