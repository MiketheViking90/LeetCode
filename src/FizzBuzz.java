import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {

    public List<String> fizzBuzz(int n) {
        List<String> solutionsList = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            boolean is3Mult = isMultipleOf3(i);
            boolean is5Mult = isMultipleOf5(i);

            if (is3Mult && is5Mult) {
                solutionsList.add("FizzBuzz");
            } else if (is3Mult) {
                solutionsList.add("Fizz");
            } else if (is5Mult) {
                solutionsList.add("Buzz");
            } else {
                String intAsString = String.valueOf(i);
                solutionsList.add(intAsString);
            }
        }

        return solutionsList;
    }

    private boolean isMultipleOf3(int i) {
        return i % 3 == 0;
    }

    private boolean isMultipleOf5(int i) {
        return i % 5 == 0;
    }

    public static void main(String[] args) {
        FizzBuzz fb = new FizzBuzz();

        List<String> res = fb.fizzBuzz(15);
        System.out.println(res);
    }
}
