package trustPayProgram;
public class MainApp {
    public static void main(String[] args) {
        EWalletApp.getInstance().loadData();
        EWalletApp.getInstance().showLoginScreen();         
    }
    public static void exitProgram() {
    	EWalletApp.getInstance().getUserManager().saveData();
        System.exit(0);
    }
}
