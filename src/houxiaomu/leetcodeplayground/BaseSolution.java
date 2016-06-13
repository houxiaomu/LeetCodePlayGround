package houxiaomu.leetcodeplayground;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by houxiaomu on 16-6-13.
 */
public class BaseSolution {

    public void runTestCases() {
        Method method = getRunMethod();
        Type[] genericParameterTypes = method.getGenericParameterTypes();
        BufferedReader reader = null;
        try {
            InputStream is = this.getClass().getResourceAsStream("./testcase.txt");
            reader = new BufferedReader(new InputStreamReader(is));
            Object[] params = new Object[genericParameterTypes.length];
            int i = 0;
            while (true) {
                String line = reader.readLine();
                if (line == null) break;

                if (i < genericParameterTypes.length) {
                    params[i] = convertToParams(genericParameterTypes[i], line);
                    i++;
                    if (i == genericParameterTypes.length) {
                        i = 0;
                        try {
                            Object result = method.invoke(this, params);
                            printResult(result);
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        } catch (InvocationTargetException e) {
                            e.printStackTrace();
                        }
                    }
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (Exception e) {
                }
            }
        }
    }

    private Method getRunMethod() {
        Method[] methods = this.getClass().getDeclaredMethods();
        String packageName = this.getClass().getPackage().getName();
        String lastPackageName = packageName.substring(packageName.lastIndexOf(".") + 1);
        Method method = null;
        for (int i = 0; i < methods.length; i++) {
            if (methods[i].getName().compareToIgnoreCase(lastPackageName) == 0) {
                method = methods[i];
                break;
            }
        }
        return method;
    }

    private Object convertToParams(Type type, String inputParam) {
        String typeName = type.toString();
        if (typeName.equals("int")) {
            return Integer.valueOf(inputParam);
        } else if (typeName.equals("class [I")) {
            return readIntArray(inputParam);
        } else if (typeName.equals(ListNode.class.toString())) {
            return readListNode(inputParam);
        }
        return null;
    }


    private int[] readIntArray(String line) {
        ArrayList<String> list = new ArrayList<>();
        String regex = "[0-9]";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(line);
        while (m.find()) {
            list.add(m.group(0));
        }

        int[] result = new int[list.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = Integer.valueOf(list.get(i));
        }
        return result;
    }

    private ListNode readListNode(String line) {
        ListNode head = null;
        ListNode prevNode = null;
        String regex = "[0-9]";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(line);
        while (m.find()) {
            ListNode newNode = new ListNode(Integer.valueOf(m.group(0)));
            if (head == null) {
                head = newNode;
            }
            if (prevNode != null) {
                prevNode.next = newNode;
            }
            prevNode = newNode;
        }
        return head;
    }

    private void printResult(Object result) {
        String name = result.getClass().getName();
        if (name.startsWith("[I")) {
            System.out.println(Arrays.toString((int[]) result));
        } else if (name.equals(ListNode.class.getName())) {
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            ListNode node = (ListNode) result;
            while (node != null) {
                sb.append(node.val);
                sb.append(",");
                node = node.next;
            }
            sb.deleteCharAt(sb.length() - 1);
            sb.append("]");
            System.out.println(sb.toString());
        } else {
            System.out.println(result);
        }
    }
}
