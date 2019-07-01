import java.io.*;
import java.util.*;

public class rank {
    private lofter[] pg;
    private pagehot[]pgh;
    private TreeMap ranks;
    private TreeMap ranksh;
    private TreeMap ranktt;
    private List<Map.Entry<String, Integer>> list = new ArrayList<>();
    public rank(lofter[]pg,pagehot[]pgh){
        this.pg=pg;
        this.pgh=pgh;
        int i=0;
        ranks=new TreeMap<String,Integer>();
        ranksh=new TreeMap<String,Integer>();
        ranktt=new TreeMap<String,Integer>();
        for(lofter pp:this.pg)for(String tags :pp.getTag()){
            assert ranks != null;
            assert ranktt != null;
            if(ranks.containsKey(tags)){
                i=(int)ranks.get(tags);
                i=i+1;
                i=i+pp.getPop_index();
                i=i+pp.getComment_count()*10;
                ranks.put(tags,i);
            }
            else{
                ranks.put(tags,1);
            }
            if(ranktt.containsKey(tags)){
                i=(int)ranktt.get(tags);
                i=i+1;
                i=i+pp.getPop_index();
                i=i+pp.getComment_count()*10;
                ranktt.put(tags,i);
            }
            else{
                ranktt.put(tags,1);
            }
        }
        for(pagehot pp:this.pgh){
            for(String tags :pp.getTag()){
                assert ranksh != null;
                if(ranksh.containsKey(tags)){
                    i=(int)ranksh.get(tags);
                    i=i+1;
                    i=i+pp.getHotIndex();
                    i=i+pp.getCommentNum()*10;
                    ranksh.put(tags,i);
                }
                else{
                    ranksh.put(tags,1);
                }
                if(ranktt.containsKey(tags)){
                    i=(int)ranktt.get(tags);
                    i=i+1;
                    i=i+pp.getHotIndex();
                    i=i+pp.getCommentNum()*10;
                    ranktt.put(tags,i);
                }
                else{
                    ranktt.put(tags,1);
                }
            }
        }

    }
    public Map getRanksh() {
        return ranksh;
    }

    public Map getRanks() {
        return ranks;
    }

    public void showranks(){
        List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>(ranks.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String,Integer>>() {
            public int compare(Map.Entry<String,Integer> o1, Map.Entry<String, Integer> o2) {
                return o1.getValue() < o2.getValue() ? 1:-1;
            }
        });
        for( Map.Entry<String, Integer> ee:list){
            System.out.println("话题："+ee.getKey()+"\t 热度："+ee.getValue());
        }
        /*
        String key;
        Integer integ = null;
        Iterator iter = ranks.entrySet().iterator();
        while(iter.hasNext()) {
            Map.Entry entry = (Map.Entry)iter.next();
            // 获取key
            key = (String)entry.getKey();
            // 获取value
            integ = (Integer)entry.getValue();
            System.out.println("话题："+key+"\t 热度："+integ);
        }
         */
    }
    public void showranksh(){
        List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>(ranksh.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String,Integer>>() {
            public int compare(Map.Entry<String,Integer> o1, Map.Entry<String, Integer> o2) {
                return o1.getValue() < o2.getValue() ? 1:-1;
            }
        });
        for( Map.Entry<String, Integer> ee:list){
            System.out.println("话题："+ee.getKey()+"\t 热度："+ee.getValue());
        }
        /*String key;
        Integer integ = null;
        Iterator iter = ranksh.entrySet().iterator();
        while(iter.hasNext()) {
            Map.Entry entry = (Map.Entry)iter.next();
            // 获取key
            key = (String)entry.getKey();
            // 获取value
            integ = (Integer)entry.getValue();
            System.out.println("话题："+key+"\t 热度："+integ);
        }
        */

    }
    public void showranktt(){
        List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>(ranktt.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String,Integer>>() {
            public int compare(Map.Entry<String,Integer> o1, Map.Entry<String, Integer> o2) {
                return o1.getValue() < o2.getValue() ? 1:-1;
            }
        });
        for( Map.Entry<String, Integer> ee:list){
            System.out.println("话题："+ee.getKey()+"\t 热度："+ee.getValue());
        }
    }
    public void ranktotxt() throws IOException {
        BufferedReader brr = null;
        File writeName = null;
        FileWriter writer = null;
        BufferedWriter out = null;
        try {
            writeName = new File("C:\\Users\\zyc14588\\IdeaProjects\\nlp\\rank.txt"); // 相对路径，如果没有则要建立一个新的output.txt文件
            writeName.createNewFile(); // 创建新文件,有同名的文件的话直接覆盖
            writer = new FileWriter(writeName);
            out= new BufferedWriter(writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>(ranktt.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String,Integer>>() {
            public int compare(Map.Entry<String,Integer> o1, Map.Entry<String, Integer> o2) {
                return o1.getValue() < o2.getValue() ? 1:-1;
            }
        });
        for( Map.Entry<String, Integer> ee:list){
            out.write("话题："+ee.getKey()+"\t 热度："+ee.getValue()+"\n");
            out.flush();
        }
    }
    public void ranknewtotxt() throws IOException {
        BufferedReader brr = null;
        File writeName = null;
        FileWriter writer = null;
        BufferedWriter out = null;
        try {
            writeName = new File("C:\\Users\\zyc14588\\IdeaProjects\\nlp\\rank_new.txt"); // 相对路径，如果没有则要建立一个新的output.txt文件
            writeName.createNewFile(); // 创建新文件,有同名的文件的话直接覆盖
            writer = new FileWriter(writeName);
            out= new BufferedWriter(writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>(ranks.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String,Integer>>() {
            public int compare(Map.Entry<String,Integer> o1, Map.Entry<String, Integer> o2) {
                return o1.getValue() < o2.getValue() ? 1:-1;
            }
        });
        for( Map.Entry<String, Integer> ee:list){
            out.write("话题："+ee.getKey()+"\t 热度："+ee.getValue()+"\n");
            out.flush();
        }
    }
    public void rankhottotxt() throws IOException {
        BufferedReader brr = null;
        File writeName = null;
        FileWriter writer = null;
        BufferedWriter out = null;
        try {
            writeName = new File("C:\\Users\\zyc14588\\IdeaProjects\\nlp\\rank_hot.txt"); // 相对路径，如果没有则要建立一个新的output.txt文件
            writeName.createNewFile(); // 创建新文件,有同名的文件的话直接覆盖
            writer = new FileWriter(writeName);
            out= new BufferedWriter(writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>(ranksh.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String,Integer>>() {
            public int compare(Map.Entry<String,Integer> o1, Map.Entry<String, Integer> o2) {
                return o1.getValue() < o2.getValue() ? 1:-1;
            }
        });
        for( Map.Entry<String, Integer> ee:list){
            out.write("话题："+ee.getKey()+"\t 热度："+ee.getValue()+"\n");
            out.flush();
        }
    }
}
