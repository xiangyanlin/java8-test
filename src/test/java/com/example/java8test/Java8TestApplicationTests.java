package com.example.java8test;


import org.junit.Test;


import java.util.*;


class Java8TestApplicationTests {


    public static void main(String[] args) {
        //addList();
        //loopThroughMap();
        //operationList();
        //String keyValue16 = KeyValue16();
        //System.out.println(keyValue16);

        List<String> list = new ArrayList<>();

        for(int i=0;i<10;i++){
            list.add(""+i);
        }
        System.out.println(list.size());
        list.add("xdclass.net");
        System.out.println(list.size());

    }

    public static void loopThroughMap(){
        Map<String,Object> map=new HashMap<String, Object>(16);
        map.put("colour","red");
        map.put("weight","50kg");
        //遍历map
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            System.out.println(entry.getKey()+":"+entry.getValue());
        }
    }

    public static void operationList() {
        List<String> list = new ArrayList<String>(10);
        list.add("1");
        list.add("2");
        list.add("3");
        System.out.println("list初始值："+list);
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            //if ("2".equals(next)){
                iterator.remove();

           // }
        }
        System.out.println("after iterator remove:"+list);
    }

    public static void addList() {
        List<String> list = new ArrayList<String>(10);
        list.add("1");
        list.add("2");
        list.add("3");
        System.out.println("list初始值："+list);
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            //if ("2".equals(next)){
            //list.add(next);
            //iterator.remove();
            System.out.println(next);
            // }
        }
        System.out.println("after iterator remove:"+list);
    }

    /**生成16位的密钥**/
    public static String KeyValue16(){
        //定义一个字符串（A-Z，a-z，0-9）即62位；
        String str="zxcvbnmlkjhgfdsaqwertyuiopQWERTYUIOPASDFGHJKLZXCVBNM1234567890";
        //由Random生成随机数
        Random random=new Random();
        StringBuffer sb=new StringBuffer();
        //长度为几就循环几次
        for(int i=0; i<16; ++i){
            //产生0-61的数字
            int number=random.nextInt(62);
            //将产生的数字通过length次承载到sb中
            sb.append(str.charAt(number));
        }
        //将承载的字符转换成字符串
        return sb.toString();
    }

}
