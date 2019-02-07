package threads;

public class ThreadInterupt {

    public static void main(String[] args) throws InterruptedException {


        Thread thread1 = new Thread(() -> {
            int i = 1;
            /*try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
            while (Thread.interrupted()) ;
            System.out.println(i++);
        });
        thread1.start();

        Thread.sleep(90);
        thread1.interrupt();

    }
}