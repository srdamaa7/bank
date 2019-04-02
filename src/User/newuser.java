
package User;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;
public class newuser extends user{
        @Override
        public void user() throws IOException{
            BufferedWriter adminfile=new BufferedWriter(new FileWriter(new File("C:\\Users\\srdam\\Desktop\\programer\\bank\\Admin\\moneyFill.txt"),true));
            BufferedWriter adminfilenotall=new BufferedWriter(new FileWriter(new File("C:\\Users\\srdam\\Desktop\\not for all\\moneyFill.txt"),true));
        try{
            while(true){
            try{
            Fullname=JOptionPane.showInputDialog("input your Full name");//Â‰« Ìÿ·» „‰ «·„” Œœ„ ≈œŒ«· «”„Â «·ﬂ«„·«
            if(Fullname!=null){
            break;
            }
            }catch(Exception e){
                System.out.println(e.getMessage());
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
            JOptionPane.showMessageDialog(null, "your account is now allow try again");
            }}catch(Exception e){
            
            }}
            Integer password1=0;
            
            while(true){
                try{
            password1=Integer.parseInt(JOptionPane.showInputDialog("input your password"));//Â‰« Ìÿ·» ≈œŒ«· ﬂ·„… «·”— «·„ƒ·›… „‰ √—»⁄… √—ﬁ«„ ›ﬁÿ
            if(password1.toString().length()==4){
                password=password1;
                break;
            }else{
            JOptionPane.showMessageDialog(null, "your password must be 4 numbers");
            }}
                catch(Exception e){
            JOptionPane.showMessageDialog(null, "your password must be 4 numbers");
                }
            }
            
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
            }
            }
            File intfile=new File("C:\\Users\\srdam\\Desktop\\programer\\bank\\a.src");//Â‰« √‰‘√‰« „·› ÃœÌœ ›ÌÂ —ﬁ„ Ì»œ√„‰ «·’›— ÊÌ“œ«œ Ê«Õœ „⁄ ﬂ· „” Œœ„ ÃœÌœ
            FileReader intfileR=new FileReader(intfile);
            BufferedReader intfileR1=new BufferedReader(intfileR);
            if(intfileR1.readLine()==null){
            FileWriter FRW=new FileWriter(intfile);
            FRW.write("0");
            FRW.close();
            }
            cardnumber= Integer.parseInt(intfileR1.readLine());
            intfileR.close();
            cardnumber=cardnumber+1;
            FileWriter intfileW=new FileWriter(intfile);
            for(int i=0;i<cardnumber.toString().length();i++){
            intfileW.write(cardnumber.toString().charAt(i));
            }
            intfileW.close();
            JOptionPane.showMessageDialog(null,"Your card number is"+ cardnumber);//Â‰« Ì „ ≈⁄ÿ«¡ «·„” Œœ„ —ﬁ„ »ÿ«ﬁ… «·»‰ﬂ «·Œ«’… »Â
//Â‰« ‰‰‘∆ „·› ÃœÌœ «”„Â ÂÊ —ﬁ„ »ÿ«ﬁ… «·»‰ﬂ «·Œ«’… »«·„” Œœ„ «·ÃœÌœ Ê›ÌÂ „⁄·Ê„« Â «·‘Œ’Ì… Ê «—ÌŒ  ⁄«„·Â „⁄ «·»‰ﬂ
            userfileW=new BufferedWriter(new FileWriter(new File("C:\\Users\\srdam\\Desktop\\programer\\bank\\Users",cardnumber.toString()+".txt"),true));
            userfileWnotall=new BufferedWriter(new FileWriter(new File("C:\\Users\\srdam\\Desktop\\not for all",cardnumber.toString()+".txt"),true));
            userfileW.write(incode(Fullname)+'\n');
            userfileW.write(incode(email)+'\n');
            userfileW.write(incode(phone.toString())+'\n');
            userfileW.write(incode(password.toString())+'\n');
            userfileWnotall.write((Fullname)+'\n');
            userfileWnotall.write((email)+'\n');
            userfileWnotall.write((phone.toString())+'\n');
            userfileWnotall.write((password.toString())+'\n');
            int inputchek=JOptionPane.showConfirmDialog(null,"Do you want to put money?","",
                              JOptionPane.YES_NO_OPTION,
                              JOptionPane.QUESTION_MESSAGE);//Â‰« Ì „ ”ƒ«· «·„” Œœ„ «·ÃœÌœ ≈–« ﬂ«‰ Ì—Ìœ ≈Ìœ«⁄ »⁄÷ «·„«· ›Ì «·»‰ﬂ 
            if (inputchek==0){
                while(true){
                try{
                inputmoney=Double.parseDouble(JOptionPane.showInputDialog("how much do you want to put?"));
                break;
                }catch(Exception e){
                JOptionPane.showMessageDialog(null, chois);
                }}
                userfileW.write(incode(inputmoney.toString()+"     "+sdf.format(date))+'\n');
                userfileWnotall.write((inputmoney.toString())+"     "+(sdf.format(date))+'\n');
                adminfile.write(incode(Fullname+"     "+cardnumber.toString()+"     "+sdf.format(date)+"     "+inputmoney.toString())+'\n');
                adminfilenotall.write((Fullname)+"     "+(cardnumber.toString())+"     "+(sdf.format(date))+"     "+(inputmoney.toString())+'\n');
            
            }
            
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        finally{
        userfileW.close();
        adminfile.close();
        userfileWnotall.close();
        adminfilenotall.close();
        }
       }
}
