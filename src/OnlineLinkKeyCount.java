import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OnlineLinkKeyCount {
    public static void main(String[] args){
        //请求的url
        URL url = null;
        //请求的输入流
        BufferedReader in = null;
        //输入流的缓冲
        StringBuffer sb = new StringBuffer();
        try{
            url = new URL("https://mbd.baidu.com/newspage/data/landingsuper?context=%7B%22nid%22%3A%22news_8764542097761323658%22%7D&n_type=0&p_from=1\n");
            in = new BufferedReader(new InputStreamReader(url.openStream(),"UTF-8") );
            String str = null;
            //一行一行进行读入
            while((str = in.readLine()) != null) {
                sb.append( str );
            }
        } catch (Exception ex) {

        } finally{
            try{
                if(in!=null) {
                    in.close(); //关闭流
                }
            }catch(IOException ex) {

            }
        }
        String result =sb.toString();
        String findText = "国际";
        int num = appearNumber(result, findText);

        System.out.print(num);

    }

    public static int appearNumber(String srcText, String findText) {
        int count = 0;
        Pattern p = Pattern.compile(findText);
        Matcher m = p.matcher(srcText);
        while (m.find()) {
            count++;
        }
        return count;
    }

}
