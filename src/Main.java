import ru.gr0550x.OddNumbers;

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
}