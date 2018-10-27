package lambda;

public class TestLambda {
    public static void main(String[] args){
        UserTest userTest = new UserTest() {
            @Override
            public int test(int a,int b) {
                System.out.println("使用匿名内部类实现");
                return a+b;
            }
        };

        System.out.println(userTest.test(1,2));


        UserTest ut1 = (m,n) -> {
            System.out.println("使用Lambda表达式实现");
            return m+n;
        };

        System.out.println(ut1.test(10,20));

        //一个参数时，可以省略小括号，方法体只有一条语句时，可以省略大括号和return
        UserTest2 userTest2 = a -> a;
        userTest2 = new UserTest2() {
            int m = 100;
            @Override
            public int test(int a) {
                System.out.println(m);
                return m;
            }
        };

        //引用类方法ref
        UserTest2 userTest21 = TestLambda::ref;
        System.out.println(userTest21.test(10000));

        //实例方法引用
        UserTest2 userTest22 = userTest2::test;
        userTest22.test(1000);

        //或者
        UserTest3 userTest33 = new UserTest3() {
            @Override
            public User getUser() {
                return new User();
            }
        };

        //--------------------如果用静态的话，对应方法的第一个参数一定是类的对象
        UserTest4 userTest4 = UserTest3::getUser;
        userTest4.getUser(userTest33);

        //构造器引用
        UserTest3 userTest3 = User::new;
        User user = userTest3.getUser();
        System.out.println(user);
    }

    public static int ref(int m){
        return m;
    }
}

@FunctionalInterface
interface UserTest{
    int test(int a, int b);
}


@FunctionalInterface
interface UserTest4{
    User getUser(UserTest3 ref);
}

@FunctionalInterface
interface UserTest2{
    int test(int a);
}

@FunctionalInterface
interface UserTest3{
    User getUser();
}

class User{


}
