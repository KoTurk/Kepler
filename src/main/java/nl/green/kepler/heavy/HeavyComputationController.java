package nl.green.kepler.heavy;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("heavy")
public class HeavyComputationController {

    @GetMapping
    public String heavy() {
        long startTime = System.currentTimeMillis();
        int count = 0;
        int limit = 10_000_000;

        for (int i = 2; i < limit; i++) {
            if (isPrime(i)) {
                count++;
            }
        }

        long endTime = System.currentTimeMillis();
        System.out.println("Number of prime numbers found: " + count);
        System.out.println("Time in ms: " + (endTime - startTime));

        return "Done with heavy computation. Found " + count + " prime numbers up to " + limit + " in " + (endTime - startTime) + " ms.";
    }


    private static boolean isPrime(int number) {
        if (number <= 1) return false;
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) return false;
        }
        return true;
    }

}
