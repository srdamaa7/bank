
package User;

import AC.AC;
import java.io.IOException;
import javax.swing.JOptionPane;

public class user extends AC{
        @Override
        public void user() throws IOException{//��� ���� ����� �������� ��� ��� ��� ���� �� ����� ����� ��� �� ���� ���� ��� ������ ����� ������
        Object[] values = {"new", "alreday have an account"};
        chois =JOptionPane.showInputDialog(null, "Are you ", "", JOptionPane.PLAIN_MESSAGE, null, values, values[0]);
        if(chois=="new"){
        newuser a=new newuser();
        a.user();
        }else if(chois=="alreday have an account"){
        olduser a=new olduser();
        a.user();
        }
        }
        public static String incode(String a){//��� ���� ������� ��� ������� ������
        char[]b=a.toCharArray();
        String c ="";
        for(char x:b){
        x=(char) (x+10);
        c=c+x;
        }
            return c;
        }
        public static String decode(String a){//��� ���� ��� ������� ��� ��� ��������� �� �����
        char[]b=a.toCharArray();
        String c="";
        for(char x:b){
        x=(char) (x-10);
        c=c+x;
        }   
            return c;
        }
        
}
