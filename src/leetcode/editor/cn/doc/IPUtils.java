package leetcode.editor.cn.doc;

/**
 * @program: LeetCode
 * @description:
 * @author: Silince
 * @create: 2021-03-21 14:12
 **/
public class IPUtils {
    /**
     * ip地址转成long型数字  219.239.110.138
     * 将IP地址转化成整数的方法如下：
     * 1、通过String的split方法按.分隔得到4个长度的数组
     * 2、通过左移位操作（<<）给每一段的数字加权，第一段的权为2的24次方，第二段的权为2的16次方，第三段的权为2的8次方，最后一段的权为1
     * @param strIp
     * @return
     */
    public static long ipToLong(String strIp) {
        String[]ip = strIp.split("\\.");
        return (Long.parseLong(ip[0]) << 24)
                + (Long.parseLong(ip[1]) << 16)
                + (Long.parseLong(ip[2]) << 8)
                + Long.parseLong(ip[3]);
    }

    /**
     * 将十进制整数形式转换成127.0.0.1形式的ip地址
     * 将整数形式的IP地址转化成字符串的方法如下：
     * 1、将整数值进行右移位操作（>>>），右移24位，右移时高位补0，得到的数字即为第一段IP。
     * 2、通过与操作符（&）将整数值的高8位设为0，再右移16位，得到的数字即为第二段IP。
     * 3、通过与操作符吧整数值的高16位设为0，再右移8位，得到的数字即为第三段IP。
     * 4、通过与操作符吧整数值的高24位设为0，得到的数字即为第四段IP。
     * @param
     * @return
     */
    public static String longToIP(String s) {
        Long longIP = Long.valueOf(s);
        System.out.println(longIP);
        StringBuilder builder = new StringBuilder();
        builder.append((longIP>>>24)+"."); // 直接右移24位
        builder.append(((longIP&0x00FFFFFF)>>>16)+"."); // 将高8位置0，然后右移16位
        builder.append(((longIP&0x0000FFFF)>>>8)+"."); // 将高16位置0，然后右移8位
        builder.append((longIP&0x000000FF)); // 将高24位置0

        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(ipToLong("1.26.220.0"));
        System.out.println(longToIP("18537472"));
    }

}

