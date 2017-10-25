package unsynchronised;


/**
 * 进行减少操作的线程。
 * @author cary
 * @version 1.0.0
 */
public class DecreaseThread extends Thread
{
    private NumberHolder numberHolder;

    public DecreaseThread(NumberHolder numberHolder)
    {
        this.numberHolder = numberHolder;
    }

    @Override
    public void run()
    {
        for (int i = 0; i < 20; ++i)
        {
            /**
             * 进行一定的延时
             */
            try
            {
                Thread.sleep((long) Math.random() * 1000);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }

            /**
             * 进行减少操作
             */
            numberHolder.decrease();
        }
    }

} 