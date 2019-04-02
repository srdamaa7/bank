
package Admin;
import static User.user.decode;
import static User.user.incode;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author srdam
 */
public class Employees extends admin{
    Path employefilenotall=null;
    public void money() throws IOException{
        adminfile = new BufferedReader(new FileReader(new File("C:\\Users\\srdam\\Desktop\\programer\\bank\\Admin\\moneyFill.txt")));
        Path monyfillpath = Paths.get("C:\\Users\\srdam\\Desktop\\programer\\bank\\Admin\\moneyFill.txt");
        List <String> monyfile=Files.readAllLines(monyfillpath);
        Double allmoney=0.0;
        for(String allmoney1:monyfile){
        allmoney1=allmoney1.substring(allmoney1.lastIndexOf(incode("     ")),allmoney1.length()-1);
        allmoney=allmoney+Double.parseDouble(decode(allmoney1));
        }
        System.out.println("bank money is:"+allmoney);
        for(String money:monyfile){
            System.out.println(decode(money));
        }
        }
    
    
    
    public void Employees() throws IOException{
        Object[] values = {"Add an employe", "Remove an employe","show an emlopye's profile and edit on it","show employees lise"};
        chois =JOptionPane.showInputDialog(null, "what do you want to do", "", JOptionPane.PLAIN_MESSAGE, null, values, values[0]);
        if(chois =="Add an employe"){
        addemploye();
        }else if(chois=="Remove an employe"){
        removeemploye();
        }else if(chois=="show an emlopye's profile and edit on it"){
        editemploye();
        }
        else if(chois=="show employees lise"){
        showlist();
        }
    }
    
    
    
    public void showlist(){
    File employelist=new File("C:\\Users\\srdam\\Desktop\\programer\\bank\\Admin\\Employees");
        for(String employename:employelist.list()){
            System.out.println(employename.substring(0, employename.indexOf(".")));
        }
    }
    
    
    
    public void addemploye() throws IOException{
        BufferedWriter add ;
        while(true){
            String Fullname1=JOptionPane.showInputDialog("input employe's Fullname");
        if(Fullname1!=null){
        Fullname=Fullname1;
        break;
        }else{
            System.out.println("you must input a name");
        }
        }
        String Jop=null;
        while(true){
            String Jop1=JOptionPane.showInputDialog("input employe's Jop");
        if(Jop1!=null){
        Jop=Jop1;
        break;
        }else{
            System.out.println("you must input a Jop");
        }
        }
        String email1=null;
            while(true){
                try{
                email1=JOptionPane.showInputDialog("input your email");//Â‰« Ìÿ·» „‰ «·„” Œœ„ ≈œŒ«· «Ì„Ì·Â ÊÌÊÃœ »⁄÷ «·‘—Êÿ ≈–« ·„   Õﬁﬁ ”Ê› Ì⁄«œ ÿ·» «·«Ì„Ì·
            if(email1.length()>=7&&".com".equals(email1.substring(email1.length()-4, email1.length()))&&email1.contains("@")&&email1.charAt(email1.length()-5)!=('@')){
            email=email1;
            break;
            }else{
            JOptionPane.showMessageDialog(null, "your account is not allow try again");
            }}catch(Exception e){
                    System.out.println(e.getMessage());
            }}
        while(true){
            try{    
            
            Integer phone1=Integer.parseInt(JOptionPane.showInputDialog("input your phone number"));//Â‰« Ìÿ·» ≈œŒ«· —ﬁ„ «·Â« › ÊÌ‘ —ÿ √‰ Ì»œ√ »—ﬁ„  ”⁄… 
            String phone2=phone1.toString();
            if(phone2.length()==9&&phone2.charAt(0)=='9'){
            phone=phone1;
            break;
            }else{
                System.out.println("your phone number must begen with 9 and contanes 9 numbers");
            }
            }catch(Exception e){
            JOptionPane.showMessageDialog(null, "your phone number is incorrect try again");
            }}
        Double salary=0.0;
        while(true){
            Double salary1=Double.parseDouble(JOptionPane.showInputDialog("input employe's salary"));
        if(salary1!=null){
        salary=salary1;
        break;
        }else{
            System.out.println("you must input a salary");
        }
        }
        add=new BufferedWriter(new FileWriter(new File("C:\\Users\\srdam\\Desktop\\programer\\bank\\Admin\\Employees\\"+Fullname+".txt")));
        add.write(incode(Fullname)+'\n');
        add.write(incode(email)+'\n');
        add.write(incode(phone.toString())+'\n');
        add.write(incode(Jop)+'\n');
        add.write(incode(salary.toString())+'\n');
        add.write(incode(sdf.format(date))+'\n');
        add.close();
        BufferedWriter addnottoall=new BufferedWriter(new FileWriter(new File("C:\\Users\\srdam\\Desktop\\not for all\\Employees\\"+Fullname+".txt")));
        addnottoall.write((Fullname)+'\n');
        addnottoall.write((email)+'\n');
        addnottoall.write((phone.toString())+'\n');
        addnottoall.write((Jop)+'\n');
        addnottoall.write((salary.toString())+'\n');
        addnottoall.write((sdf.format(date))+'\n');
        addnottoall.close();
    }
    Path employefile;
    
    
    
    public void removeemploye() throws IOException{
    while(true){
    try{
        showlist();
        Fullname=JOptionPane.showInputDialog("input employe's Fullname");
        employefile = Paths.get("C:\\Users\\srdam\\Desktop\\programer\\bank\\Admin\\Employees\\"+Fullname+".txt");
        employefilenotall = Paths.get("C:\\Users\\srdam\\Desktop\\not for all\\Employees\\"+Fullname+".txt");
        Files.delete(employefile);
        Files.delete(employefilenotall);
        System.out.println("employ removed");
        break;
    }catch(Exception e){
        System.out.println("there aren't employe with this name");
    }}}
    
    
    public void editemploye() throws IOException{
        boolean editcomleat=true;
        while(true){
            try{
        Fullname=JOptionPane.showInputDialog("input employe's Fullname");
        File chekfilel=new File("C:\\Users\\srdam\\Desktop\\programer\\bank\\Admin\\Employees\\"+Fullname+".txt");
        if(chekfilel.exists()){
        employefile = Paths.get("C:\\Users\\srdam\\Desktop\\programer\\bank\\Admin\\Employees\\"+Fullname+".txt");
        employefilenotall = Paths.get("C:\\Users\\srdam\\Desktop\\not for all\\Employees\\"+Fullname+".txt");
        break;
        }else{
        JOptionPane.showMessageDialog(null, "there aren't employe with this name");
        }
            }catch(Exception e){
            JOptionPane.showMessageDialog(null, "there aren't employe with this name");
            }
        }
        List<String> employedata= Files.readAllLines(employefile);
        for(String data:employedata){
        System.out.println(decode(data));
        }
        Fullname=decode(employedata.get(0));
        email=decode(employedata.get(1));
        phone =Integer.parseInt(decode(employedata.get(2)));
        String[] newemployedata =new String[6];
        newemployedata[0]=employedata.get(0);
        int editname=JOptionPane.showConfirmDialog(null,"Do you want to edit employe Fullname?","",
                              JOptionPane.YES_NO_OPTION,
                              JOptionPane.QUESTION_MESSAGE);
        String newname=null;
        if(editname==0){
        while(true){
        try{
        newname=JOptionPane.showInputDialog("what is the new Fullname");
        if(newname!=null){
        newemployedata[0]=newname;
        editcomleat=true;
        break;
        }else{
        JOptionPane.showMessageDialog(null,"You must input a nmae");
        }
        }catch(Exception e){
        JOptionPane.showMessageDialog(null,e.getMessage());
        }
        }
        }else if(editname==1){
        newemployedata[0]=decode(employedata.get(0));
        editcomleat=false;
        }
        int editemail=JOptionPane.showConfirmDialog(null,"Do you want to edit employe email?","",
                              JOptionPane.YES_NO_OPTION,
                              JOptionPane.QUESTION_MESSAGE);
        if(editemail==0){
        while(true){
        try{
        String newemail=JOptionPane.showInputDialog("what is the new email");
        if(newemail.length()>=7&&".com".equals(newemail.substring(newemail.length()-4, newemail.length()))&&newemail.contains("@")&&newemail.charAt(newemail.length()-5)!=('@')){
        newemployedata[1]=newemail;
        break;
        }else{
        JOptionPane.showMessageDialog(null,"your email is not allow try again");
        }
        }catch(Exception e){
        JOptionPane.showMessageDialog(null,"your email is not allow try again");
        }
        }
        }else if(editemail==1){
        newemployedata[1]=decode(employedata.get(1));
        }
        int editphone=JOptionPane.showConfirmDialog(null,"Do you want to edit employ phone number?","",
                              JOptionPane.YES_NO_OPTION,
                              JOptionPane.QUESTION_MESSAGE);
        if(editphone==0){
        while(true){
        try{
        Integer newphon1=Integer.parseInt(JOptionPane.showInputDialog("what is the new phone number"));
        String newphon=newphon1.toString();
        if(newphon.charAt(0)=='9'&&newphon.length()==9){
        newemployedata[2]=newphon;
        break;
        }else{
        JOptionPane.showMessageDialog(null, "your phon number is incorrect try again");
        }}catch(Exception e){
        JOptionPane.showMessageDialog(null, "your phon number is incorrect try again");
        }}
        }else if(editphone==1){
        newemployedata[2]=decode(employedata.get(2));
        }
        int editjop=JOptionPane.showConfirmDialog(null,"Do you want to edit employ jop?","",
                              JOptionPane.YES_NO_OPTION,
                              JOptionPane.QUESTION_MESSAGE);
        if(editjop==0){
        while(true){
        try{
        
        String newpassword=JOptionPane.showInputDialog("what is the new jop");
        newemployedata[3]=newpassword;
        break;
        }catch(Exception e){
        JOptionPane.showMessageDialog(null, e.getMessage());
        }}
        }else if(editjop==1){
        newemployedata[3]=decode(employedata.get(3));
        }int editsalary=JOptionPane.showConfirmDialog(null,"Do you want to edit employ salary?","",
                              JOptionPane.YES_NO_OPTION,
                              JOptionPane.QUESTION_MESSAGE);
        if(editsalary==0){
        while(true){
        try{
        
        Integer newpassword1=Integer.parseInt(JOptionPane.showInputDialog("what is the new salary"));
        String newpassword =newpassword1.toString();
        
        newemployedata[4]=newpassword;
        break;
        }catch(Exception e){
        JOptionPane.showMessageDialog(null, e.getMessage());
        }}
        }else if(editsalary==1){
        newemployedata[4]=decode(employedata.get(4));
        }
        newemployedata[5]=decode(employedata.get(5));
        if(editcomleat==true){
        BufferedWriter newdataW=new BufferedWriter(new FileWriter(new File("C:\\Users\\srdam\\Desktop\\programer\\bank\\Admin\\Employees\\"+(newemployedata[0])+".txt")));
        BufferedWriter newdataWnotall=new BufferedWriter(new FileWriter(new File("C:\\Users\\srdam\\Desktop\\not for all\\Employees\\"+(newemployedata[0])+".txt")));
        for(String newdata:newemployedata){
        newdataW.write(incode(newdata)+'\n');
        newdataWnotall.write((newdata)+'\n');
        }
        newdataW.close();
        newdataWnotall.close();
        Files.delete(employefilenotall);
        Files.delete(employefile);
        }else if(editcomleat==false){
        BufferedWriter newdataW=new BufferedWriter(new FileWriter(new File("C:\\Users\\srdam\\Desktop\\programer\\bank\\Admin\\Employees\\"+(newemployedata[0])+".txt")));
        BufferedWriter newdataWnotall=new BufferedWriter(new FileWriter(new File("C:\\Users\\srdam\\Desktop\\not for all\\Employees\\"+(newemployedata[0])+".txt")));        
        for(String newdata:newemployedata){
        newdataW.write(incode(newdata)+'\n');
        newdataWnotall.write((newdata)+'\n');
        }
        newdataW.close();
        newdataWnotall.close();
        }}}
