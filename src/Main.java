import ru.gr0550x.BoundedUniqueCollection;

void showCollectionContent(Collection<?> c){
    for (var e: c){
        System.out.println(e.toString());
    }
    System.out.println();
}

void main() {
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