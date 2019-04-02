
package Admin;

import AC.AC;
import java.io.BufferedReader;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author srdam
 */
public class admin extends AC{
        BufferedReader adminfile;
        Object[] values = {"show users history", "maneger employees"};
        public void admin() throws IOException{
            Employees a=new Employees();
            try{
        while(true){
            try{
        Integer chekp=Integer.parseInt(JOptionPane.showInputDialog("input admin password"));
        if(chekp==1234){
        break;    
        }else{
        JOptionPane.showMessageDialog(null, "incorrect password");
        }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"incorrect input of password");
        }
        }
        chois =JOptionPane.showInputDialog(null, "what do you want to do", "", JOptionPane.PLAIN_MESSAGE, null, values, values[0]);
        if(chois=="show users history"){
        a.money();
        }
        else if(chois=="maneger employees"){
        a.Employees();
        }
        }catch(Exception e){
                System.out.println(e.getMessage());
        }
        }
        
}