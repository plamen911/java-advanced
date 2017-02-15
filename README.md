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

`Locale.setDefault(new Locale("bg", "BG"));`

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
```
List<Integer> params = Stream.of(reader.readLine().split("\\s+"))
    .map(Integer::valueOf)
    .collect(Collectors.toList());
```

List to array
```
List<String> result = new ArrayList<>();
// ...
String[] names = result.toArray(new String[result.size()]);
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

Split string and remove empty entries

```
List<String> words = Arrays.stream(reader.readLine().split("[\\s,\\.\\?\\!]"))
    .filter(item -> item != null && !"".equals(item))
    .collect(Collectors.toList());
```

```
ArrayList<Integer> divisors = Arrays.stream(reader.readLine().split("\\s+"))
    .map(String::trim)
    .map(Integer::parseInt)
    .collect(Collectors.toCollection(ArrayList::new));
```

```
TreeSet<String> palindromes = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
```

```
Character[] letters = {' ', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
List<Character> alphabet = Arrays.asList(letters);
```

Join array of numbers with space

```
String[] result = Arrays.toString(numbers).split("[\\[\\]]")[1].split(", ");
System.out.println(String.join(" ", result));
```

```
System.out.printf("%s%n", String.join(" ", s.getGrades().stream().map(String::valueOf).collect(Collectors.toList())));
```

Count unique characters in string

```
List<Character> chars = sb.toString().chars().mapToObj(e->(char)e).collect(Collectors.toList());
long count = chars.stream().distinct().count();
```

### Incomplete points: 

Multidimensional Arrays - Exercises
- https://judge.softuni.bg/Contests/Practice/Index/387#10 - 12. StringMatrixRotationTests (80 / 100) 














