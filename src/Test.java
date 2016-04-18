/**
 * Created by johnsardo on 2016-04-17.
 */
public class Test {
    public static void main(String[] args)
    {
        System.out.println((35/8)*8 );
    }
}

enum TestEnum
{
    FOO("F"), BAR("B");

    private String abbreviation;
    TestEnum(String abbreviation) { this.abbreviation = abbreviation; }

    String getAbbreviation() { return abbreviation; }
}
