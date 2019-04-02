
package bank;

import Admin.admin;
import User.user;
import javax.swing.JOptionPane;
public class Bank {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try{
        Object[] values = {"admin", "user"};
        Object chois =JOptionPane.showInputDialog(null, "who are you", "", JOptionPane.PLAIN_MESSAGE, null, values, values[0]);
        if(chois=="admin"){
            admin a=new admin();
            a.admin();
        }else if(chois=="user"){
            user a=new user();
            a.user();
            
        }
    }catch(Exception e){
    }
}
}