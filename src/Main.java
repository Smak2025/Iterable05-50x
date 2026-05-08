import ru.gr0550x.EvenNumbers;
import ru.gr0550x.OddNumbers;

import ru.gr0550x.BoundedUniqueCollection;

void showCollectionContent(Collection<?> c){
    for (var e: c){
        System.out.println(e.toString());
    }
    System.out.println();
}

void main() {
    var odds = new OddNumbers(10);
    for (var num: odds){
        System.out.print(num+" ");
        if (num >= 10) break;
    }
    System.out.println();
    for (var num: odds){
        System.out.print(num + " ");
    }
    var evens = new EvenNumbers(10);
    System.out.println();
    for (var num: evens){
        System.out.print(num + " ");
    }
    System.out.println();
    // Пример работы с BoundedUniqueCollection
    Collection<String> lang = new BoundedUniqueCollection<>(3);
    lang.add("Java");
    showCollectionContent(lang);
    lang.add("C#");
    showCollectionContent(lang);
    lang.add("Java");
    showCollectionContent(lang);
    lang.add("Kotlin");
    showCollectionContent(lang);
    try {
        lang.add("Python");
    } catch (Exception e) {
        System.out.println(e.getMessage());
    }
    showCollectionContent(lang);

    System.out.println(lang.contains("CSharp"));
    System.out.println(lang.contains("C#"));
}