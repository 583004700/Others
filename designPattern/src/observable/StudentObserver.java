package observable;

public class StudentObserver implements Observer{
    private String name;
    private Subject subject;

    /**
     * 每创建一个学生，自动添加到被通知对象
     * @param name
     * @param subject
     */
    public StudentObserver(String name,Subject subject){
        this.name = name;
        this.subject = subject;
        subject.addObserver(this);
    }

    /**
     * 接收通知
     * @param info
     */
    @Override
    public void update(String info){
        System.out.println("学生"+name+"收到作业"+info);
    }
}
