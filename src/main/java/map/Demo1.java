package map;

import java.util.HashMap;
import java.util.Objects;

/**
 * @author yuweixiong
 * @date 2020/09/24 11:12
 * @description
 */
public class Demo1 {
    public static void main(String[] args){

        HashMap<Key, Value> map1 = new HashMap<>();
        Key k1 = new Key("a", 1);
        Key k2 = new Key("a", 2);
    }

    static class Key{
        String name;
        Integer seqId;

        public Key(String name, Integer seqId) {
            this.name = name;
            this.seqId = seqId;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Key key = (Key) o;
            return name.equals(key.name) &&
                    seqId.equals(key.seqId);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, seqId);
        }
    }

    class Value{
        String value1;
        Integer value2;
    }
}
