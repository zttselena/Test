package unsynchronised;

public class NumberHolder
{
    private int number;

    public void increase()
    {
        while (0 != number)
        {
        }
        // 能执行到这里说明已经被唤醒，并且number不为0
        number++;
        System.out.println(number);
    }

    public void decrease()
    {
        while (0 == number)
        {
        }
        // 能执行到这里说明已经被唤醒，并且number不为0
        number--;
        System.out.println(number);
    }

}
