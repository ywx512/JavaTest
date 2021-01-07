package decorator_pattern.proxy;

/**
 * @author: yuweixiong
 * @Date: 2020-07-11 16:30:41
 * @Description: 简单代理类
 */
public class SimpleProxyDemo {
    public static void consumer(Interaface1 interaface1) {
        interaface1.doSomething();
        interaface1.somethingElse("hello");
    }

    public static void main(String[] args) {
        consumer(new RealObject());
        consumer(new SimpleProxy(new RealObject()));
    }
}

interface Interaface1 {
    void doSomething();

    void somethingElse(String args);
}

class RealObject implements Interaface1 {
    @Override
    public void doSomething() {
        System.out.println("doSomething");
    }

    @Override
    public void somethingElse(String args) {
        System.out.println("somethingElse");
    }
}

class SimpleProxy implements Interaface1 {
    private Interaface1 proxied;

    public SimpleProxy(Interaface1 proxied) {
        this.proxied = proxied;
    }

    @Override
    public void doSomething() {
        System.out.println("SimpleProxy doSomething");
        proxied.doSomething();
    }

    @Override
    public void somethingElse(String args) {
        System.out.println("SimpleProxy somthingElse" + args);
        proxied.somethingElse(args);
    }
}