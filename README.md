# Java Advanced май 2016 @SoftUni

Exercises for ["Java Advanced" course @Software University](https://softuni.bg/trainings/1377/advanced-java-may-2016).

#### Utils

join array elements with separator

```
private static String join(Collection<?> s, String delimiter) {
    StringBuilder builder = new StringBuilder();
    Iterator<?> iter = s.iterator();
    while (iter.hasNext()) {
        builder.append(iter.next());
        if (!iter.hasNext()) {
            break;
        }
        builder.append(delimiter);
    }
    return builder.toString();
}
```

lambda expression

```
HashSet<String> s = new HashSet<>(set.size());
set.forEach(i -> s.add(i.toString()));
System.out.printf("%s", StringUtils.join(s, " "));
```

char to int

`int power = card.charAt(0) - '0';`


https://github.com/KNikovv/SoftuniHomeworks/tree/master/AdvancedJava/2.SetsAndMaps

`Locale.setDefault(Locale.ROOT);` - code to handle doubles platform independently 

convert an integer string separated by space into an array

```
Integer[] params = Arrays.stream(scanner.nextLine().split("\\s+"))
    .map(Integer::parseInt)
    .toArray(Integer[]::new);
```
```
int[] params = Arrays.stream(scanner.nextLine().split("\\s+"))
    .mapToInt(Integer::parseInt)
    .toArray();
```

Sort list

```
List<String> lines = Files.readAllLines(pathIn);
// Collections.sort(lines);
lines.sort(String::compareTo);
```

```
HashSet<Character> punctuation = new HashSet<>();
Collections.addAll(punctuation, ',', '.', '!', '?');
```

```
private static boolean isPrime(int digit) {
    boolean prime = true;
        
    if (digit < 2) {
        prime = false;
    }

    for (int i = 2; i <= Math.sqrt(digit); i++) {
        if (digit % i == 0) {
            prime = false;
            break;
        }
    }

    return prime;
}
```

```
ArrayList<String> numbers = new ArrayList<>(Arrays.asList("0", "1", "2", "3", "4", "5", "6", "7", "8", "9"));
```

```
private static final String PROJECT_PATH = System.getProperty("user.dir") + "/src/resources/";
```


### Incomplete points: 

Multidimensional Arrays - Exercises
- https://judge.softuni.bg/Contests/Practice/Index/387#10 - 12. StringMatrixRotationTests (80 / 100) 

Stacks and Queues
- https://judge.softuni.bg/Contests/Practice/Index/187#12 - 13. Evaluate Expression (0 / 0)
- https://judge.softuni.bg/Contests/Practice/Index/187#13 - 14. Stock Span Problem (60 / 100)












