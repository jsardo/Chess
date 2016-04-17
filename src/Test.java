/**
 * Created by johnsardo on 2016-04-17.
 */
public class Test {
    public static void main(String[] args)
    {
        System.out.println('a' <= 'b');
        System.out.println(Character.getNumericValue('3'));
        TestEnum foo = TestEnum.FOO;
        System.out.println(foo.getAbbreviation());
    }
}

enum TestEnum
{
    FOO("F"), BAR("B");

    private String abbreviation;
    TestEnum(String abbreviation) { this.abbreviation = abbreviation; }

    String getAbbreviation() { return abbreviation; }
}
