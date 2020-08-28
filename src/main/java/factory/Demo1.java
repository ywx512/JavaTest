package factory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Demo1 {
    static List<Factory<? extends Demo1>> partFactories = new ArrayList<>();

    static {
        partFactories.add(new Filter1.Factory());
        partFactories.add(new Filter2.Factory());
        partFactories.add(new Belt1.Factory());
        partFactories.add(new Belt2.Factory());
    }

    private static Random random = new Random(40);

    public static Demo1 createRandom() {
        int n = random.nextInt(partFactories.size());
        return partFactories.get(n).create();
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(Demo1.createRandom());
        }
    }

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }
}

class Filter extends Demo1 {
}

class Filter1 extends Filter {
    public static class Factory implements factory.Factory<Filter1> {
        @Override
        public Filter1 create() {
            return new Filter1();
        }
    }
}

class Filter2 extends Filter {
    public static class Factory implements factory.Factory<Filter2> {
        @Override
        public Filter2 create() {
            return new Filter2();
        }
    }
}

class Belt extends Demo1 {
}

class Belt1 extends Belt {
    public static class Factory implements factory.Factory<Belt1> {
        @Override
        public Belt1 create() {
            return new Belt1();
        }
    }
}

class Belt2 extends Belt {
    public static class Factory implements factory.Factory<Belt2> {
        @Override
        public Belt2 create() {
            return new Belt2();
        }
    }
}
