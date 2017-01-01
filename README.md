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
