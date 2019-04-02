
package AC;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.Date;


public abstract class AC {
    public String Fullname=null;
    public Integer phone =0;
    public Double inputmoney=0.0;
    public Double getmoney=0.0;
    public Integer password=0;
    public String email=null;
    public Object chois=null;
    public Date date=new Date();
    public SimpleDateFormat sdf=new SimpleDateFormat("E dd/MM/yyyy  hh:mm:ss a");
    public Path datapath=null;
    public BufferedWriter userfileW=null;
    public BufferedWriter userfileWnotall=null;
    public Integer cardnumber=0;
    public void user()throws IOException{};
}
