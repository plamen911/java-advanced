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

### Incomplete points: 

- https://judge.softuni.bg/Contests/Practice/Index/387#10 - 12. StringMatrixRotationTests (Multidimensional Arrays - Exercises 80 / 100) 

### Not submitted

- https://judge.softuni.bg/Contests/Practice/Index/187#12 - 13. Evaluate Expression (Stacks and Queues - Exercises)

- https://judge.softuni.bg/Contests/Practice/Index/187#13 - 14. Stock Span Problem (Stacks and Queues - Exercises)

...






