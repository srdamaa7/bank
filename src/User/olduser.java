
package User;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class olduser extends user{
    @Override
    public void user() throws IOException{
        BufferedWriter adminfile=new BufferedWriter(new FileWriter(new File("C:\\Users\\srdam\\Desktop\\programer\\bank\\Admin\\moneyFill.txt"),true));
        BufferedWriter adminfilenotall=new BufferedWriter(new FileWriter(new File("C:\\Users\\srdam\\Desktop\\not for all\\moneyFill.txt"),true));
        try{
        while(true){
        cardnumber=Integer.parseInt(JOptionPane.showInputDialog("input your card number"));//Â‰« Ìÿ·» „‰ «·„” Œœ„ ≈œŒ«· —ﬁ„ »ÿ«ﬁ… «·»‰ﬂ «·Œ«’… »Â
        datapath = Paths.get("C:\\Users\\srdam\\Desktop\\programer\\bank\\Users\\"+cardnumber.toString()+".txt");
        if(new File("C:\\Users\\srdam\\Desktop\\programer\\bank\\Users\\"+cardnumber.toString()+".txt").exists()){//Â‰« Ì Õﬁﬁ «–« ﬂ«‰ «·„·› «·–Ì ÌÕ„· —ﬁ„ »ÿ«ﬁ… «·»‰ﬂ ﬂ«”„ „ÊÃÊœ «„ ·« «–« ·« ›Â–« «·—ﬁ„ €Ì— „ÊÃÊœ
        break;
        }else{
        JOptionPane.showMessageDialog(null, "incorrect card number");
        }}
        List<String> data= Files.readAllLines(datapath);//Â‰« ÌﬁÊ„ »ﬁ—«∆… ﬂ· „« ›Ì «·„·› ÊÌŒ“‰Â ›Ì „’›Ê›…
        Integer password1=0;
        int forget=0;
        while(true){//Â‰« ÌﬁÊ„ »«·”ƒ«· ⁄„ ﬂ·„… «·”— Ê«–« «Œÿ√ «·„” Œœ„ ›Ì ≈œŒ«·Â« À·«À „—«  Ì”√·Â «–« ﬂ«‰ ﬁœ ‰”ÌÂ«
        if(forget>=3){
        int forget1=JOptionPane.showConfirmDialog(null,"Do you forgat your password?","",
                              JOptionPane.YES_NO_OPTION,
                              JOptionPane.QUESTION_MESSAGE);
        switch (forget1){//«–« ﬂ«‰ «·„” Œœ„ ﬁœ ‰”ÌÂ« ”Ê› Ì”√·Â ⁄‰ ÿ—Ìﬁ… «—Ã«⁄Â« «„« »«·«Ì„Ì· «Ê »—ﬁ„ «·Â« ›
            case 0:
        Object[] values = {"by email", "by phone number"};
        Object chois =JOptionPane.showInputDialog(null, "do you want to get your password by phone number or by email", "", JOptionPane.PLAIN_MESSAGE, null, values, values[0]);
        if(chois=="by email"){
        while(true){
            try{
        String getemail=JOptionPane.showInputDialog("input your email");
        if(getemail.equals(decode(data.get(1)))){
            JOptionPane.showMessageDialog(null, "your password is:"+decode(data.get(3)));
            break;
        }else {
        JOptionPane.showMessageDialog(null, "incorrect email");
        }
        }catch(Exception e){
        }}
        }else if(chois=="by phone number"){
        while(true){
        try{
        Integer getphon=Integer.parseInt(JOptionPane.showInputDialog("input your phone number"));
        if(getphon.toString().equals(decode(data.get(2)))){
             JOptionPane.showMessageDialog(null, "your password is:"+decode(data.get(3)));
             break;
        }else{
        JOptionPane.showMessageDialog(null, "incorrect phone number");
        }
        }catch(Exception e){
        }}}}}
        try{
        password1=Integer.parseInt(JOptionPane.showInputDialog("input your password"));
        if(password1.toString().length()==4)
        {
            password=password1;
        }
        else{
            JOptionPane.showMessageDialog(null,"incorrect input of password");
        }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"incorrect input of password");
        }
        if (password.toString().equals(decode(data.get(3)))){
            break;
        }else{
        JOptionPane.showMessageDialog(null, "incorrect password");
        
        }
        forget=forget+1;
        }
        userfileW=new BufferedWriter(new FileWriter(new File("C:\\Users\\srdam\\Desktop\\programer\\bank\\Users",cardnumber.toString()+".txt"),true));
        userfileWnotall=new BufferedWriter(new FileWriter(new File("C:\\Users\\srdam\\Desktop\\not for all\\",cardnumber.toString()+".txt"),true));
        Double allmoney =0.0;
        ArrayList<String>money=new <String> ArrayList();//Â‰« ﬁ„‰« »≈‰‘«¡ „’›Ê›  ÕÊÌ Ã„Ì⁄ «·”ÿÊ— «· Ì ·Â« ⁄·«ﬁ… »«·„«· ”Ê«¡« √Œ– „«· √Ê Ì÷⁄ „«·
        for(int i=4;i<data.size();i++){
            money.add((data.get(i).substring(0,data.get(i).indexOf(incode("     ")))));
        }
            for(String money1:money){
            allmoney=allmoney+Double.parseDouble(decode(money1));//Â‰« √”‰œ‰« ≈·Ï «·„ €Ì— Ã„Ì⁄ ﬁÌ„ «·„«· «·„ÊÃÊœ… ›Ì «·„’›Ê›… «·”«»ﬁ…
            }
        Object[] values= {"input money", "get money","show and edit personal information","show account hestory","chek the balance"};//Â‰« Ì „ ”ƒ«· «·„” Œœ„ ⁄„« Ì—Ìœ √‰ Ì›⁄·Â
        chois =JOptionPane.showInputDialog(null, "what do you want to do", "", JOptionPane.PLAIN_MESSAGE, null, values, values[0]);
        if(chois=="input money"){//Â‰« ≈–« ﬂ«‰ ŒÌ«— «·„” Œœ„ «œŒ«· „«· ›”Ê› Ì‰›– Â–« «·ﬁ”„ Ê«·–Ì ”Ê› Ì”√·Â ⁄‰ ﬂ„Ì… «·„«· Ê”Ì „ ≈÷«› Â« ≈·Ï «·„·› 
        inputmoney=Double.parseDouble(JOptionPane.showInputDialog("how much do you want to put?"));
                userfileW.write(incode(inputmoney.toString()+"     "+sdf.format(date))+'\n');
                adminfile.write(data.get(0)+incode("     "+cardnumber.toString()+"     "+sdf.format(date)+"     "+inputmoney.toString())+'\n');
                userfileWnotall.write(inputmoney.toString()+"     "+sdf.format(date)+'\n');
                adminfilenotall.write(decode(data.get(0))+"     "+cardnumber.toString()+"     "+sdf.format(date)+"     "+inputmoney.toString()+'\n'); 
        }else if(chois=="get money"){//ÊÂ‰« ”Ì „ ≈÷«›… «·ﬁÌ„… «·„œŒ… „‰ ﬁ»· «·„” Œœ„ ≈–«  Õﬁﬁ √‰Â« √’€— „‰ —’Ìœ… √Ê  ”«ÊÌÂ Ê”Ì „ ≈÷«› Â« „⁄ ≈‘«—… ”«·»
        getmoney=0.0;
        while(true){
        getmoney=Double.parseDouble(JOptionPane.showInputDialog("how much do you want to get?"));
        getmoney=getmoney*-1;    
            try{
        if(allmoney+getmoney>=0){        
        userfileW.write(incode(getmoney.toString()+"     "+sdf.format(date))+'\n');
        adminfile.write(data.get(0)+incode("     "+cardnumber.toString()+"     "+sdf.format(date)+"     "+getmoney.toString())+'\n');
        userfileWnotall.write((getmoney.toString()+"     "+sdf.format(date))+'\n');
        adminfilenotall.write((decode(data.get(0))+"     "+cardnumber.toString()+"     "+sdf.format(date)+"     "+getmoney.toString())+'\n');
        adminfilenotall.close();
        adminfile.close();
        break;
        }else{
        JOptionPane.showMessageDialog(null, "you don't have this money in your account your balance is:"+allmoney);
        }}catch(Exception e){
                System.out.println(e.getMessage());        
        }}}
        
        else if(chois=="show account hestory"){//Â‰« ”Ê› Ì—Ï «·⁄„Ì· Ã„Ì⁄  ⁄«„·« Â „⁄ «·»‰ﬂ „⁄ ﬁÌ„… —’ÌœÂ
        System.out.println("your money is:"+allmoney);
        for(int i=4;i<data.size();i++){
            System.out.println(decode(data.get(i)));
        }}
        
        else if(chois=="chek the balance"){//Â‰« ”Ì—Ï «·⁄„Ì· ﬁÌ„… —’ÌœÂ ›ﬁÿ
        System.out.println("your money is:"+allmoney);
        }
        
        
        else if(chois=="show and edit personal information"){//Â‰« ”Ì „ ⁄—÷ „⁄·Ê„«  «·‘Œ’Ì… Ê«· Ì  „À· √Ê· √—»⁄ √”ÿ— „‰ «·„·› ÊÌ„ﬂ‰ ··„” Œœ„  ⁄œÌ·Â« Ã„Ì⁄« „« ⁄œ« «”„Â
        String [] newpi=new String [data.size()];
            System.out.println(decode(data.get(0))+'\n'+decode(data.get(1))+'\n'+decode(data.get(2))+'\n'+decode(data.get(3))+'\n');
        newpi[0]=decode(data.get(0));
        int editname=JOptionPane.showConfirmDialog(null,"Do you want to edit your Fullname?","",
                              JOptionPane.YES_NO_OPTION,
                              JOptionPane.QUESTION_MESSAGE);
        if(editname==0){
        while(true){
        try{
        String newname=JOptionPane.showInputDialog("what is the new Fullname");
        newpi[0]=newname;
        Path monyfillpath = Paths.get("C:\\Users\\srdam\\Desktop\\programer\\bank\\Admin\\moneyFill.txt");
        List <String> monyfile=Files.readAllLines(monyfillpath);
        String [] line=new String[monyfile.size()];
        for(int i=0;i<monyfile.size();i++){
        if(monyfile.get(i).substring(0, monyfile.get(i).indexOf(incode("     "))).equals((data.get(0)))){
            line[i]=incode(newname)+monyfile.get(i).substring(monyfile.get(i).indexOf(incode("     ")), monyfile.get(i).length()-1);
        }else{
        line[i]=monyfile.get(i);
        }}
        BufferedWriter newnamefile=new BufferedWriter(new FileWriter(new File("C:\\Users\\srdam\\Desktop\\programer\\bank\\Admin\\moneyFill.txt")));
        BufferedWriter newadminfilenotall=new BufferedWriter(new FileWriter(new File("C:\\Users\\srdam\\Desktop\\not for all\\moneyFill.txt")));
        for(String line1:line){
        newnamefile.write(line1+'\n');
        newadminfilenotall.write(decode(line1)+'\n');
        }
        newnamefile.close();
        newadminfilenotall.close();

        break;
        }catch(Exception e){
        JOptionPane.showMessageDialog(null,e.getMessage());
        }
        }
        }else if(editname==1){
        newpi[0]=decode(data.get(0));
        }
        int editemail=JOptionPane.showConfirmDialog(null,"Do you want to edit your email?","",
                              JOptionPane.YES_NO_OPTION,
                              JOptionPane.QUESTION_MESSAGE);
        if(editemail==0){
        while(true){
        try{
        String newemail=JOptionPane.showInputDialog("what is the new email");
        if(newemail.length()>=7&&".com".equals(newemail.substring(newemail.length()-4, newemail.length()))&&newemail.contains("@")&&newemail.charAt(newemail.length()-5)!=('@')){
        newpi[1]=newemail;
        break;
        }else{
        JOptionPane.showMessageDialog(null,"your account is now allow try again");
        }
        }catch(Exception e){
        JOptionPane.showMessageDialog(null,"your account is now allow try again");
        }
        }
        }else if(editemail==1){
        newpi[1]=decode(data.get(1));
        }
        int editphone=JOptionPane.showConfirmDialog(null,"Do you want to edit your phone number?","",
                              JOptionPane.YES_NO_OPTION,
                              JOptionPane.QUESTION_MESSAGE);
        if(editphone==0){
        while(true){
        try{
        Integer newphon1=Integer.parseInt(JOptionPane.showInputDialog("what is the new phone number"));
        String newphon=newphon1.toString();
        if(newphon.charAt(0)=='9'&&newphon.length()==9){
        newpi[2]=newphon;
        break;
        }else{
        JOptionPane.showMessageDialog(null, "your phon number is incorrect try again");
        }}catch(Exception e){
        JOptionPane.showMessageDialog(null, "your phon number is incorrect try again");
        }
        }
        }else if(editphone==1){
        newpi[2]=decode(data.get(2));
        }
        int editpassword=JOptionPane.showConfirmDialog(null,"Do you want to edit your password?","",
                              JOptionPane.YES_NO_OPTION,
                              JOptionPane.QUESTION_MESSAGE);
        if(editpassword==0){
        while(true){
        try{
        
        Integer newpassword1=Integer.parseInt(JOptionPane.showInputDialog("what is the new password"));
        String newpassword =newpassword1.toString();
        if(newpassword.length()==4){
        newpi[3]=newpassword;
        break;
        }else{
        JOptionPane.showMessageDialog(null, "your password must be 4 numbers");
        }}catch(Exception e){
        JOptionPane.showMessageDialog(null, "your password must be 4 numbers");
        }
        }
        }else if(editpassword==1){
        newpi[3]=decode(data.get(3));
        }
        for(int i=4;i<data.size();i++){
        newpi[i]=decode(data.get(i));
        }
        BufferedWriter newInf=new BufferedWriter(new FileWriter(new File("C:\\Users\\srdam\\Desktop\\programer\\bank\\Users",cardnumber.toString()+".txt")));
        for(String newpiW:newpi){
        newInf.write(incode(newpiW)+'\n');
        }
        newInf.close();
        BufferedWriter newInfnottoall=new BufferedWriter(new FileWriter(new File("C:\\Users\\srdam\\Desktop\\not for all",cardnumber.toString()+".txt")));
        for(String newpiW:newpi){
        newInfnottoall.write((newpiW)+'\n');
        }
        newInfnottoall.close();
        
        }
}catch(Exception e){
            System.out.println(e.getMessage());
}   finally{    
           userfileW.close();
           adminfile.close();
           userfileWnotall.close();
           adminfilenotall.close();
        }
}


}

