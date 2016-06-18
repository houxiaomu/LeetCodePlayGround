package houxiaomu.leetcodeplayground.restore_ip_addresses;

import houxiaomu.leetcodeplayground.BaseSolution;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Simon on 2016/6/14.
 */
public class Solution extends BaseSolution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        HashSet<String> set = new HashSet<>();
        for (int dot1 = 0; dot1 < s.length() - 3 && dot1 < 3; dot1++) {
            String str1 = s.substring(0, dot1 + 1);
            if (!(dot1 < 2 || Integer.valueOf(str1) <= 255) || (str1.length() > 1 && str1.startsWith("0"))) {
                continue;
            }

            for (int dot2 = dot1 + 1; dot2 < s.length() - 2 && dot2 - dot1 <= 3; dot2++) {
                String str2 = s.substring(dot1 + 1, dot2 + 1);
                if (!(str2.length() <= 2 || Integer.valueOf(str2) <= 255) || (str2.length() > 1 && str2.startsWith("0"))) {
                    continue;
                }

                for (int dot3 = dot2 + 1; dot3 < s.length() - 1 && dot3 - dot2 <= 3; dot3++) {
                    String str3 = s.substring(dot2 + 1, dot3 + 1);
                    if (!(str3.length() <= 2 || Integer.valueOf(str3) <= 255) || (str3.length() > 1 && str3.startsWith("0"))) {
                        continue;
                    }

                    String str4 = s.substring(dot3 + 1);
                    if (!(str4.length() <= 2 || ((str4.length() == 3) && Integer.valueOf(str4) <= 255)) || (str4.length() > 1 && str4.startsWith("0"))) {
                        continue;
                    }

                    StringBuilder sb = new StringBuilder();
                    sb.append(Integer.valueOf(str1));
                    sb.append(".");
                    sb.append(Integer.valueOf(str2));
                    sb.append(".");
                    sb.append(Integer.valueOf(str3));
                    sb.append(".");
                    sb.append(Integer.valueOf(str4));
                    set.add(sb.toString());
//                    for (int dot4 = dot3 + 1; dot4 < s.length() && dot4 - dot3 <= 3; dot4++) {
//                        String str4 = s.substring(dot3 + 1, dot4 + 1);
//                        if (!(str4.length() <= 2 || ((str4.length() == 3) && Integer.valueOf(str4) <= 255))) {
//                            continue;
//                        }
//
//                        String ip = str1 + "." + str2 + "." + str3 + "." + str4;
//                        result.add(ip);
//                    }
                }
            }
        }
        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            result.add(it.next());
        }
        return result;
    }
}
