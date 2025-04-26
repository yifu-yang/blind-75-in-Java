import java.util.*;

public class Codec {

    // 编码：将字符串列表编码为单个字符串
    public String encode(List<String> strs) {
        StringBuilder encoded = new StringBuilder();
        for (String str : strs) {
            encoded.append(str.length()).append("#").append(str);
        }
        return encoded.toString();
    }

    // 解码：将编码后的字符串解码为字符串列表
    public List<String> decode(String s) {
        List<String> decoded = new ArrayList<>();
        int i = 0;
        while (i < s.length()) {
            // 找到分隔符 #
            int delimiterIndex = s.indexOf('#', i);
            // 提取字符串长度
            int length = Integer.parseInt(s.substring(i, delimiterIndex));
            // 提取对应长度的字符串
            String str = s.substring(delimiterIndex + 1, delimiterIndex + 1 + length);
            decoded.add(str);
            // 更新索引位置
            i = delimiterIndex + 1 + length;
        }
        return decoded;
    }

    public static void main(String[] args) {
        Codec codec = new Codec();
        List<String> strs = Arrays.asList("hello", "world");
        String encoded = codec.encode(strs);
        System.out.println("Encoded: " + encoded); // 输出: "5#hello5#world"
        List<String> decoded = codec.decode(encoded);
        System.out.println("Decoded: " + decoded); // 输出: ["hello", "world"]
    }
}