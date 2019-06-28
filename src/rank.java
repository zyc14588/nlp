import java.util.*;

public class rank {
    private page[] pg;
    private pagehot[]pgh;
    private Map ranks;
    private Map ranksh;
    private List<Map.Entry<String, Integer>> list = new ArrayList<>();
    public rank(page[]pg,pagehot[]pgh){
        this.pg=pg;
        this.pgh=pgh;
        int i=0;
        ranks=new HashMap();
        ranksh=new HashMap();
        ranks.put("",i);
        ranksh.put("",i);
        for(page pp:this.pg)for(String tags :pp.getTag()){
            assert ranks != null;
            if(ranks.containsKey(tags)){
                i=(int)ranks.get(tags);
                i=i+1;
                ranks.put(tags,i);
            }
            else{
                ranks.put(tags,i);
            }
        }
        for(pagehot pp:this.pgh)for(String tags :pp.getTag()){
            assert ranksh != null;
            if(ranksh.containsKey(tags)){
                i=(int)ranksh.get(tags);
                i=i+1;
                ranksh.put(tags,i);
            }
            else{
                ranksh.put(tags,i);
            }
        }
    }
    public rank(page[]pg){
        this.pg=pg;
        this.pgh=pgh;
        ranks=new HashMap();
        ranksh=new HashMap();
        int i=0;
        for(page pp:this.pg)for(String tags :pp.getTag()){
            if(ranks.containsKey(tags)){
                i=(int)ranks.get(tags);
                i=i+1;
                ranks.put(tags,i);
            }
            else{
                ranks.put(tags,i);
            }
        }
    }
    public rank(pagehot[]pgh){
        this.pg=pg;
        this.pgh=pgh;
        ranks=new HashMap<String,Integer>();
        ranksh=new HashMap<String,Integer>();
        int i=0;
        for(pagehot pp:this.pgh)for(String tags :pp.getTag()){
            if(ranksh.containsKey(tags)){
                i=(int)ranks.get(tags);
                i=i+1;
                ranksh.put(tags,i);
            }
            else{
                ranksh.put(tags,i);
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
    }
    public void showranksh(){
        List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>(ranksh.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>> () {
            //降序排序
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                //return o1.getValue().compareTo(o2.getValue());
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        String key;
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
    }
}
