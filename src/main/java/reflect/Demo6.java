package reflect;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * @author: yuweixiong
 * @Date: 2020-07-12 11:13:19
 * @Description:
 */
public class Demo6 {
    public static void main(String[] args) {
//		countPets(new PetDemoCreator());
//		PetCounter.countPets(Pet.CREATOR);

        PetCounter2 petCounter2 = new PetCounter2();
        for (Pet pet : Pet.createArray(10)) {
            System.out.println("Pet: " + pet.getClass().getSimpleName());
            petCounter2.count(pet);
        }
        System.out.println(petCounter2.toString());
    }
}

class PetCounter extends HashMap<String, Integer> {
    public void count(String type) {
        Integer quantity = get(type);
        if (quantity == null) {
            put(type, 1);
        } else {
            put(type, quantity + 1);
        }
    }

    public static void countPets(PetCreator creator) {
        PetCounter counter = new PetCounter();
        for (Pet pet : creator.createArray(10)) {
            System.out.println(pet.getClass().getSimpleName());
            if (pet instanceof Pet) {
                counter.count("Pet");
            }
            if (pet instanceof Pet1) {
                counter.count("Pet1");
            }
            if (pet instanceof Pet2) {
                counter.count("Pet2");
            }
            if (pet instanceof Pet3) {
                counter.count("Pet3");
            }
        }
        System.out.println("count: " + counter.toString());
    }
}

class PetCounter2 extends LinkedHashMap<Class<? extends Pet>, Integer> {
    private static Map<Class<? extends Pet>, Integer> petMap = new LinkedHashMap<Class<? extends Pet>, Integer>();

    static {
        List<Class<? extends Pet>> types = PetDemoCreator2.types;
        petMap = types.stream().collect(Collectors.toMap(v -> v, v -> 0));
    }

    public PetCounter2() {
        super(petMap);
    }

    public void count(Pet pet) {
        for (Map.Entry<Class<? extends Pet>, Integer> pair : entrySet()) {
            if (pair.getKey().isInstance(pet)) {
                put(pair.getKey(), pair.getValue() + 1);
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Map.Entry<Class<? extends Pet>, Integer> pair : entrySet()) {
            builder.append(pair.getKey().getSimpleName());
            builder.append("-");
            builder.append(pair.getValue());
            builder.append(",");
        }
        return builder.toString();
    }
}

abstract class PetCreator {
    private Random random = new Random();

    public abstract List<Class<? extends Pet>> types();

    public Pet randomPet() {
        int n = random.nextInt(types().size());

        try {
            return types().get(n).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public Pet[] createArray(int size) {
        Pet[] result = new Pet[size];
        for (int i = 0; i < size; i++) {
            result[i] = randomPet();
        }
        return result;
    }

    public ArrayList<Pet> arrayList(int size) {
        ArrayList<Pet> pets = new ArrayList<Pet>();
        Collections.addAll(pets, createArray(size));
        return pets;
    }
}

class PetDemoCreator extends PetCreator {
    public static List<Class<? extends Pet>> types = new ArrayList<Class<? extends Pet>>();

    private static String[] typesName = {"reflect.Pet1", "reflect.Pet2", "reflect.Pet3"};

    @SuppressWarnings("unchecked")
    private static void loader() {
        try {
            for (String name : typesName) {
                types.add((Class<? extends Pet>) Class.forName(name));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    static {
        loader();
    }

    @Override
    public List<Class<? extends Pet>> types() {
        return types;
    }
}

class PetDemoCreator2 extends PetCreator {
    public static final List<Class<? extends Pet>> types = Collections
            .unmodifiableList(Arrays.asList(Pet1.class, Pet2.class, Pet3.class));

    @Override
    public List<Class<? extends Pet>> types() {
        return types;
    }

    public static void main(String[] args) {
        System.out.println(types);
    }
}

class Pet {
    public static final PetCreator CREATOR = new PetDemoCreator2();

    public static Pet randomPet() {
        return CREATOR.randomPet();
    }

    public static Pet[] createArray(int size) {
        return CREATOR.createArray(size);
    }

    public static ArrayList<Pet> arrayList(int size) {
        return CREATOR.arrayList(size);
    }
}

class Pet1 extends Pet {

}

class Pet2 extends Pet {

}

class Pet3 extends Pet {

}