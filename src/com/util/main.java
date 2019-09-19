package com.util;

public class main {

    private static String str =null;

    public static void main(String[] args) {

        /*String JDBC_URL_REGEX = "jdbc:mysql:\\/\\/(localhost|((25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?))(:([0-5]?[0-9][0-9]?[0-9]?|6[0-4][0-9]{3}|65[0-4][0-9]{2}|655[0-2][0-9]|6553[0-5]))?\\/.+$";
        String url = "jdbc:mysql://172.16.0.95:3436/";
        if(!matches(JDBC_URL_REGEX,url)){
            System.out.println(1111);
        }*/

        /*DateTime currentTime = DateTime.now();

        System.out.println(currentTime.getYear());
        System.out.println(currentTime.getMonthOfYear());
        System.out.println(currentTime.getDayOfMonth());*/

        /*String error1 = "";

        System.out.println("test exception");
        try {
            if(str.equals("name")){
                System.out.println("test exception");
            }
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            System.out.println(e.toString());
            System.out.println(e.getMessage());
        }*/


        /*String realPath = "doc/1557487314529_20190510_530节点计划追踪表.xlsx";

        String fileName = realPath.substring(realPath.lastIndexOf(File.separator) + 1);

        System.out.println("fileName="+fileName);*/

        /*String start = "1543593600000";
        String end = "1548039600000";


        String start1 = "1561910399999";
        String end1 = "1552739220000";

        String start3 = "1553936400000";
        String end3 = "1553947200000";


        long endLong = Long.parseLong(end);
        long startLong = Long.parseLong(start);
        long endLong1 = Long.parseLong(end1);
        long startLong1 = Long.parseLong(start1);

        long endLong3 = Long.parseLong(end3);
        long startLong3 = Long.parseLong(start3);

        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("=======process start=="+simpleDateFormat1.format(startLong));
        System.out.println("=======process end=="+simpleDateFormat1.format(endLong));

        System.out.println("=============");

        System.out.println("=======monitor start=="+simpleDateFormat1.format(startLong1));
        //System.out.println("=======monitor end=="+simpleDateFormat1.format(endLong1));

        System.out.println("=============");

        System.out.println("=======monitor start3=="+simpleDateFormat1.format(startLong3));
        System.out.println("=======monitor end3=="+simpleDateFormat1.format(endLong3));*/
        //List<Long> dimensions = Arrays.asList(new Long [] {1L,2L,3L,4L,5L,6L,7L,8L});


        /*List<Long> dimensions = new ArrayList<>();
        List<Object> datapoints = new ArrayList();

        int totalCount = dimensions.size();
        int pageCount = totalCount / 50;
        //阿里接口dimensionSize最大限制50，作分页处理
        for(int i=0;i<=pageCount;i++){
            int fromIndex = i*50;
            int toIndex = Math.min(totalCount,(i+1) * 50);

            List<Long> subList = dimensions.subList(fromIndex,toIndex);

            //总数不到一页或者刚好等于一页的时候,只需要处理一次就可以退出for循环了
            if(toIndex == totalCount){
                break;
            }
        }*/
    }
}
