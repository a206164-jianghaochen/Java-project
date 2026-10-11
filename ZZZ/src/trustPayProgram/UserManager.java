package trustPayProgram;
import java.io.*;

import java.util.*;
public class UserManager {
    private final HashMap<String, Double> userBalances = new HashMap<>();
    private final HashMap<String, Double> userRmBalances = new HashMap<>();
    private final HashMap<String, ArrayList<String>> userTransactions = new HashMap<>();
    private final HashMap<String, String> userPasswords = new HashMap<>();
    private static final String DATA_FILE = "ewallet_data.dat";

    public void addUser(String username, String password, double initialBalance) {
        userBalances.put(username, initialBalance);
        userRmBalances.put(username, 0.0);
        userTransactions.put(username, new ArrayList<>());
        userPasswords.put(username, password);
    }
    public boolean validateLogin(String username, String password) {
        return userPasswords.containsKey(username) && userPasswords.get(username).equals(password);
    }
    public double getBalance(String username) {
        return userBalances.getOrDefault(username, 0.0);
    }
    public void setBalance(String username, double amount) {
        userBalances.put(username, amount);
    }
    public ArrayList<String> getTransactions(String username) {
        return userTransactions.get(username);
    }
    public double getRmBalance(String username) {
        return userRmBalances.getOrDefault(username, 0.0);
    }

    public void setRmBalance(String username, double amount) {
        userRmBalances.put(username, amount);
    }
    public ArrayList<String> getAllUsernames() {
        return new ArrayList<>(userBalances.keySet());
    }
    public void loadData() {   	
    	    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(DATA_FILE))) {    	       
    	        userBalances.putAll((HashMap<String, Double>) ois.readObject());
    	        userRmBalances.putAll((HashMap<String, Double>) ois.readObject());
    	        userTransactions.putAll((HashMap<String, ArrayList<String>>) ois.readObject());
    	        userPasswords.putAll((HashMap<String, String>) ois.readObject());
    	    } catch (IOException | ClassNotFoundException e) {
    	        initializeDefaultUsers(); 
    	    }
    	}
    public void saveData() {
    	try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(DATA_FILE))) {
            oos.writeObject(userBalances);
            oos.writeObject(userRmBalances);
            oos.writeObject(userTransactions);
            oos.writeObject(userPasswords);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void recordTransaction(String username, String transaction) {
        userTransactions.get(username).add(transaction);
    }
    private void initializeDefaultUsers() {
        addUser("JiangHaochen", "12345", 0.0);
        addUser("YuanRunhua", "password1", 0.0);
        addUser("ZengQiLin", "password2", 0.0);
        addUser("JinJie", "password3", 0.0);
    }
}
