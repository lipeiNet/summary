package com.lp.summary.searchs;

/**
 * Created by Administrator on 2017/3/2.
 */
public class KeyWords {
   private static String[] keyWords={"abstract","assert","boolean","break","byte","case",
           "catch","char","continue","default","do","double","else","extend","false","final",
   "finally","float","for","if","implements","import","instaceof","in","interface",
   "long","native","new","null","package","private","protectd","public","return","short",
   "static","super","switch","synchronized","this","throw","transient","true","try","void","volatile","while"};
    private static class IndexItem implements Comparable<IndexItem>{
        String frist;
        int start;
        public IndexItem(String frist,int start){
            this.frist=frist;
            this.start=start;
        }
        public int compareTo(IndexItem o) {
            return this.frist.compareTo(o.frist);
        }
        private static IndexItem[] index;
        static {
            index = new IndexItem[26];
            int i = 0, j = 0, size = 0;
            for (i = 0; j < keyWords.length && i < index.length; i++) {
                char ch = keyWords[j].charAt(0);
                IndexItem item = new IndexItem(ch + "", j);
                if (item != null) {
                    index[i] = item;
                    size++;
                }
                j++;
                while (j < keyWords.length && keyWords[j].charAt(0) == ch) {
                    j++;
                }
            }
            int oldCount = index.length;
            if (size < oldCount) {
                IndexItem[] items = index;
                index = new IndexItem[size];
                for (int m = 0; m < size; m++) {
                    index[m]  = items[m];
                }
            }
        }
        public static boolean isKeyWord(String str){
            IndexItem indexItem=new IndexItem(str.substring(0,1),-1);
            int pos=BSArry.binarySearch(index,indexItem);
            int begin=index[pos].start;
            int end;
            if (pos==index.length-1){
                end=keyWords.length-1;
            }else {
                 end=index[pos+1].start-1;
            }
            return BSArry.binarySearch(keyWords,begin,end,str)>=0;
        }

        public static void main(String[] args) {
            String str="while";
            System.out.println(str+(isKeyWord(str)?"":"不")+"是关键字");
            str="lenght";
            System.out.println(str+(isKeyWord(str)?"":"不")+"是关键字");
        }
    }
}
