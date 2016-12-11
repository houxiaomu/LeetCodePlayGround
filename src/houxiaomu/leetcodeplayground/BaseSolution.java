package houxiaomu.leetcodeplayground;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by houxiaomu on 16-6-13.
 */
public class BaseSolution {

    public void runTestCases() {
        if (runCustomizedTestCases()) {
            return;
        }

        Method method = getRunMethod();
        Type[] genericParameterTypes = method.getGenericParameterTypes();
        Class<?>[] parameterTypes = method.getParameterTypes();
        BufferedReader reader = null;
        try {
            InputStream is = this.getClass().getResourceAsStream("./testcase.txt");
            reader = new BufferedReader(new InputStreamReader(is));
            Object[] params = new Object[genericParameterTypes.length];
            int i = 0;
            long time = System.currentTimeMillis();
            while (true) {
                String line = reader.readLine();
                if (line == null) break;
                if (i < genericParameterTypes.length) {
                    //Class<?> cls = (Class<?>) genericParameterTypes[i];
                    params[i] = convertToParams(genericParameterTypes[i], line);
                    i++;
                    if (i == genericParameterTypes.length) {
                        i = 0;
                        invokeRunMethod(method, params);
                    }
                }
            }
            System.out.println("total time: " + (System.currentTimeMillis() - time) + "ms");
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

    public boolean runCustomizedTestCases() {
        return false;
    }

    protected void invokeRunMethod(Method method, Object[] params) {
        try {
            Object result = method.invoke(this, params);
            printResult(params, result);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
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
        for (int i = 0; i < methods.length; i++) {
            if (methods[i].getModifiers() == Modifier.PUBLIC) {
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
        } else if (typeName.equals(String.class.toString())) {
            return readString(inputParam);
        } else if (typeName.equals("class [I")) {
            return readIntArray(inputParam);
        } else if (typeName.equals("class [Ljava.lang.String;")) {
            return readStringArray(inputParam);
        } else if (typeName.equals(ListNode.class.toString())) {
            return readListNode(inputParam);
        } else if (typeName.equals(TreeNode.class.toString())) {
            return readTreeNode(inputParam);
        } else if (typeName.equals(UndirectedGraphNode.class.toString())) {
            return readUndirectedGraphNode(inputParam);
        } else if (typeName.equals("class [Lhouxiaomu.leetcodeplayground.ListNode;")) {
            return readObjectArray(type, inputParam);
        } else if (typeName.equals("class [[C")) {
            return read2DimCharArray(type, inputParam);
        } else if (typeName.equals("class [[I")) {
            //return read2DimIntArray(type, inputParam);
            return readObjectArray(type, inputParam);
        } else if (typeName.equals("java.util.Set<java.lang.String>")) {
            return readStringSet(inputParam);
        }
        return null;
    }

    private Object readStringSet(String inputParam) {
        String[] strings = readStringArray(inputParam);
        Set<String> set = new HashSet<>();
        for (String s : strings) {
            set.add(s);
        }
        return set;
    }

    private Object readUndirectedGraphNode(String inputParam) {
        UndirectedGraphNode firstNode = null;
        inputParam = inputParam.replace("{", "");
        inputParam = inputParam.replace("}", "");
        String[] split = inputParam.split("#");
        Map<Integer, UndirectedGraphNode> map = new HashMap<>();
        for (String nodeStr : split) {
            String[] vals = nodeStr.split(",");
            int nodeVal = Integer.valueOf(vals[0]);
            UndirectedGraphNode node = map.get(nodeVal);
            if (node == null) {
                node = new UndirectedGraphNode(nodeVal);
                map.put(nodeVal, node);
            }
            if (firstNode == null) firstNode = node;
            map.put(nodeVal, node);
            for (int i = 1; i < vals.length; i++) {
                int v = Integer.valueOf(vals[i]);
                UndirectedGraphNode neighbor = map.get(v);
                if (neighbor == null) {
                    neighbor = new UndirectedGraphNode(v);
                    map.put(v, neighbor);
                }
                node.neighbors.add(neighbor);
            }
        }
        return firstNode;
    }

    private Object read2DimCharArray(Type type, String inputParam) {
        String regex = "\\\"([^\\\"]*)\\\"";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(inputParam);
        ArrayList<String> list = new ArrayList<>();
        while (m.find()) {
            String str = m.group(0);
            str = str.substring(1, str.length() - 1);
            list.add(str);
        }
        int line = list.size();
        char[][] result = new char[line][];
        for (int i = 0; i < line; i++) {
            result[i] = list.get(i).toCharArray();
        }
        return result;
    }

    private <T> T[] readObjectArray(Type type, String line) {
        try {
            String regex = "\\[([^\\[\\]]+)\\]";
            Pattern p = Pattern.compile(regex);
            Matcher m = p.matcher(line);
            ArrayList<Object> list = new ArrayList<>();
            Class componentClass = ((Class) type).getComponentType();
            while (m.find()) {
                String str = m.group(0);
                Object o = convertToParams(componentClass, str);
                list.add(o);
            }
            T[] array = (T[]) Array.newInstance(componentClass, list.size());
            return list.toArray(array);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    private String[] readStringArray(String line) {
        String regex = "\\\"([^\\\"]*)\\\"";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(line);
        ArrayList<String> list = new ArrayList<>();
        while (m.find()) {
            String str = m.group(0);
            list.add(str.substring(1, str.length() - 1));
        }
        String[] result = new String[list.size()];
        return list.toArray(result);
    }

    private String readString(String line) {
        String regex = "\\\"([^\\\"]*)\\\"";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(line);
        if (m.find()) {
            String str = m.group(0);
            return str.substring(1, str.length() - 1);
        }
        return "";
    }

    private TreeNode readTreeNode(String line) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        TreeNode root = null;
        String regex = "-?[0-9]\\d*|null";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(line);
        while (m.find()) {
            TreeNode node = queue.poll();
            if (node == null) {
                root = newNode(m.group(0));
                queue.add(root);
            } else {
                node.left = newNode(m.group(0));
                if (m.find()) {
                    node.right = newNode(m.group(0));
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return root;
    }

    private TreeNode newNode(String val) {
        if (val.equals("null")) {
            return null;
        } else {
            return new TreeNode(Integer.valueOf(val));
        }
    }


    private int[] readIntArray(String line) {
        ArrayList<String> list = new ArrayList<>();
        String regex = "-?[0-9]\\d*";
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
        String regex = "-?[0-9]\\d*";
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

    protected void printResult(Object[] params, Object result) {
        printResult(result);
    }

    protected void printResult(Object result) {
        if (result == null) {
            return;
        }

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
        } else if (name.equals(TreeNode.class.getName())) {
            TreePrinter.printNode((TreeNode) result);
        } else {
            System.out.println(result);
        }
    }
}
