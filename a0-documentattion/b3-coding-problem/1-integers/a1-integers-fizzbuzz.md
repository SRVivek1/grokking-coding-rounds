# Integers: Fizz Buzz interview problem
## Problem stattement:
- Given an integer `n`, return a String array (1-Indexed) where:
  - **answer[i] = "FizzBuzz"** *if `i` is divisble by 3 and 5.*
  - **answer[i] = "Fizz"** *if `i` is divisble by 3.*
  - **answer[i] = "Buzz"** *if `i` is divisble by 5.*
  - **answer[i] = i (as String)** *if none of the above conditions are true.*
- Enhance the solution to add more divisor rules.
  - **answer[i] = "Bazz"** *if `i` is divisble by 7*
  - **answer[i] = "Abcd"** *if `i` is divisble by 9*
- Implement the solution using *java 8 Streams*
- Enhance the streams solution for parallel processing*


## Soltuions:
### 1. Using If-Else Brute force

```java
    private static String[] fizzBuzzBruteForce(int n) {
        String[] result = new String[n];

        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                result[i - 1] = "FizzBuzz";
            } else if (i % 3 == 0) {
                result[i - 1] = "Fizz";
            } else if (i % 5 == 0) {
                result[i - 1] = "Buzz";
            } else {
                result[i - 1] = i + "";
            }
        }
        return result;
    }
```


### 2. Using If-Else Simplified

```java
     /**
     * Optimized Solution (Avoid Multiple Modulus Operations)
     * Instead of checking i % 3 and i % 5 multiple times, we can store the result in a StringBuilder:
     *
     * TC: O(N)
     * SC: O(N)
     * @param n max
     * @return string[]
     */
    private static String[] fizzBuzz_buzz_string_builder(int n) {
        String[] result = new String[n];

        for (int i = 1; i <= n; i++) {
            StringBuilder sb = new StringBuilder();
            if (i % 3 == 0) sb.append("Fizz");
            if (i % 5 == 0) sb.append("Buzz");

            // result[i - 1] = sb.length() > 0 ? sb.toString() : i + ""; //both works fines
            result[i - 1] = sb.isEmpty() ? i + "" : sb.toString();
        }
        return result;
    }
```


### 3. Enhance to add custom divisors rule
  - Explanation: ***TODO***


```java
    /**
     * Fizz Buzz Bazz custom divisors
     *
     * @param n     input size
     * @param rules divisors
     */
    private static String[] fizzBuzzCustomDivisors(int n, Map<Integer, String> rules) {

        final String[] result = new String[n];

        for (int i = 1; i <= n; i++) {
            StringBuilder sb = new StringBuilder();
            for (Map.Entry<Integer, String> entry : rules.entrySet()) {
                if (i % entry.getKey() == 0) {
                    sb.append(entry.getValue());
                }
            }
            //append to result array
            result[i - 1] = sb.isEmpty() ? i + "" : sb.toString();
        }

        return result;
    }
```


### 4. Implement solution using Java-Streams
  - Explanation: ***TODO***


```java
    /**
     * Implement fizz buzz using java 8 streams.
     *
     * @param n
     * @param rules
     * @return
     */
    private static String[] fizzBuzzCustomDivisorsStreams(int n, Map<Integer, String> rules) {
        return IntStream.rangeClosed(1, n).mapToObj(i -> {

            String res = rules.entrySet().stream()
                    .filter(entry -> i % entry.getKey() == 0)
                    .map(Map.Entry::getValue)
                    .reduce("", String::concat);
            return res.isEmpty() ? i + "" : res;
        }).toArray(String[]::new);
    }
```

### 5. Implement solution using Java-Streams Parallelism
  - Explanation: ***TODO***


```java
    /**
     * Implement fizz buzz using java 8 streams and parallelism.
     *
     * @param n
     * @param rules
     * @return
     */
    public static String[] fizzBuzzCustomDivisorsStreamsParallel(int n, Map<Integer, String> rules) {
        return IntStream.rangeClosed(1, n)
                .parallel() // Enables parallel execution
                .mapToObj(i -> {
                    String result = rules.entrySet().stream()
                            .filter(entry -> i % entry.getKey() == 0)
                            .map(Map.Entry::getValue)
                            .reduce("", String::concat);
                    return result.isEmpty() ? String.valueOf(i) : result; // FIXED: Use `i` instead of `N`
                })
                .toArray(String[]::new);
    }
```

---
<center>
<h1> ------ End ------ </h1>
</center>

<!-- HTML styling -->
<style>
table, th, td {
  border: 1px solid black;
  border-collapse: collapse;
}
heading {
  color: blue;
  font-size: 20px;
  }
</style>