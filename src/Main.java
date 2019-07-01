import java.io.*;

public class Main {
       public static void main(String[] args) throws IOException {
           /*keyword txt=new keyword();
           word_dev dev=new word_dev();
           txtload op=new txtload();
            String xx="";
            String str="";
            while(true) {
                xx=op.Readln();
                 if (xx==null) break;
                if(xx.equals("main:")){
                   str=null;
                    while(true){
                        xx=op.Readln();
                         if(xx.equals("other:"))break;
                        str = str+xx;
                  }
                 }
            else continue;
                if(str.length()<200)continue;
                 txt.Reset(str);
                 op.Write(txt.GetKeyWord(10));
             }
           */
           jsonherotag jht=new jsonherotag();
           tagdev tgd=new tagdev(jht.getHh(),jht.getTg(),jht.getPg(),jht.getPgh());
           tgd.rename();
           tgd.devcp();
           tgd.removedup();
           rank rr=new rank(tgd.getPg(),tgd.getPgh());
           rr.showranks();
           rr.showranksh();
           rr.showranktt();
           rr.ranktotxt();
           rr.rankhottotxt();
           rr.ranknewtotxt();
           /*jsonherotag jst=new jsonherotag();
           BufferedReader brr = null;
           File writeName = null;
           FileWriter writer = null;
           BufferedWriter out = null;
           try {
               writeName = new File("C:\\Users\\zyc14588\\IdeaProjects\\nlp\\test_key_word.txt"); // 相对路径，如果没有则要建立一个新的output.txt文件
               writeName.createNewFile(); // 创建新文件,有同名的文件的话直接覆盖
               writer = new FileWriter(writeName);
               out= new BufferedWriter(writer);
           } catch (IOException e) {
               e.printStackTrace();
           }
           for(lofter ll:jst.getPg()){
               if(ll.getText().length()<200)continue;
               keyword kk=new keyword(ll.getText());
               //word_dev wd=new word_dev(ll.getText());
               //System.out.println("关键词:"+kk.GetKeyWord(5));
               out.write(ll.getText());
               out.write("\n"+"关键词:"+kk.GetKeyWord(5)+"\n");
               out.flush();
           }
        */
    }
}
