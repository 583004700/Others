package gaoji.a20;

class Sleeper extends Thread{
    private int duration;

    public Sleeper(String name,int sleepTime){
        super(name);
        duration = sleepTime;
        start();
    }

    @Override
    public void run() {
        super.run();
        try {
            sleep(duration);
        } catch (InterruptedException e) {
            System.out.println(getName()+" Interrupted:"+this.isInterrupted());
            return;
        }
        System.out.println(getName()+" has awakened");
    }
}

class Joiner extends Thread{
    private Sleeper sleeper;

    public Joiner(String name,Sleeper sleeper){
        super(name);
        this.sleeper = sleeper;
        start();
    }

    @Override
    public void run() {
        super.run();
        try {
            sleeper.join();
        } catch (InterruptedException e) {
            System.out.println("Interrupted");
        }
        System.out.println(getName()+" join complete");
    }
}

public class Joining {
    public static void main(String[] args) {
        Sleeper sleeper = new Sleeper("Sleepy",1500);
        Sleeper grumpy = new Sleeper("Grumpy",1500);
        Joiner dopey = new Joiner("Dopey",sleeper);
        Joiner doc = new Joiner("Doc",grumpy);

        grumpy.interrupt();
    }
}
