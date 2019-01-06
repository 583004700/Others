package readSource;

import org.apache.ibatis.type.TypeReference;

import java.util.ArrayList;

public class TestTypeReference extends TypeReference<ArrayList<Integer>> {
    public static void main(String[] args) {
        TestTypeReference testTypeReference = new TestTypeReference();
        System.out.println(testTypeReference.getRawType());
    }
}
