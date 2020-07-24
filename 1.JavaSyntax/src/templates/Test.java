package templates;

import java.io.IOException;

public class Test {

    public static void main(String[] args) throws IOException {

        System.out.println(booleanExpression(true,false, true, false));
        System.out.println(booleanExpression(true,false, false, false));
        System.out.println(booleanExpression(true,true, true, false));
    }

    public static boolean booleanExpression(boolean a, boolean b, boolean c, boolean d) {
        return (a && b)^(c && d) || (a && c)^(b && d) || (a && d)^(c && b);
    }

}





