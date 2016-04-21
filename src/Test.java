/**
 * Created by johnsardo on 2016-04-17.
 */
public class Test {
    public static void main(String[] args)
    {
        int[] test = {0,2,3};
        for (int i : test) {
            System.out.println(i);
        }
    }
}

enum TestEnum
{
    FOO("F"), BAR("B");

    private String abbreviation;
    TestEnum(String abbreviation) { this.abbreviation = abbreviation; }

    String getAbbreviation() { return abbreviation; }
}
