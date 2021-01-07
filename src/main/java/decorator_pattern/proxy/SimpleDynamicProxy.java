package decorator_pattern.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author: yuweixiong
 * @Date: 2020-07-11 16:30:41
 * @Description: 简单动态代理类
 */
public class SimpleDynamicProxy {
    public static void consumer(Interaface1 interaface1) {
        interaface1.doSomething();
        interaface1.somethingElse("hello");
    }

    public static void main(String[] args) {
        RealObject real = new RealObject();
        consumer(real);

        Interaface1 proxy = (Interaface1) Proxy.newProxyInstance(Interaface1.class.getClassLoader(),
                new Class[]{Interaface1.class}, new DynamicProxyHandler(real));
        consumer(proxy);

        Interaface1 proxy2 = (Interaface1) Proxy.newProxyInstance(Interaface1.class.getClassLoader(),
                new Class[]{Interaface1.class}, new MethodSelector(real));
        consumer(proxy2);
    }
}

class DynamicProxyHandler implements InvocationHandler {
    private Object proxied;

    public DynamicProxyHandler(Object proxied) {
        this.proxied = proxied;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("****** decorator_pattern.proxy: " + proxy.getClass() + ", method: " + method + ", args: " + args);

        if (args != null) {
            for (Object arg : args) {
                System.out.println("  " + arg);
            }
        }

        return method.invoke(proxied, args);
    }
}

class MethodSelector implements InvocationHandler {
    private Object proxied;

    public MethodSelector(Object proxied) {
        this.proxied = proxied;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("****** decorator_pattern.proxy: " + proxy.getClass() + ", method: " + method + ", args: " + args);

        if (method.getName().equals("somethingElse")) {
            System.out.println("Proxy detected the somethingElse");
        }

        if (method.getName().equals("somethingElse")) {
            System.out.println("args: " + args[0]);
            System.out.println("Proxy detected the somethingElse");
        }

        return method.invoke(proxied, args);
    }
}
