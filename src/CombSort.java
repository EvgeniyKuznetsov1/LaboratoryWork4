import java.util.*;

public class CombSort {
    public static void main(String[] args) {
        Random random = new Random();
        int[] array = new int[10];

        //  Заполнение массива случайными числами от 0 до 100
        for(int i = 0; i < array.length; i++){
            array[i] = random.nextInt(100);
        }

        System.out.print("Исходный массив:\n\t");
        System.out.println(Arrays.toString(array));

        combSort(array);
        System.out.print("Отсортированный методом расчёски массив:\n\t");
        System.out.println(Arrays.toString(array));
    }

    public static void combSort(int[] array){
        int step = array.length - 1;
        boolean isSorted = false;
        while(step >= 1 || !isSorted){
            /* Массив будет отсортирован тогда, когда !isSorted,
            т.е. условие в цикле, определяющее, будет ли совершаться замена текущего элемента
            с элементом на интервале(step), не будет выполнено ни разу за итерацию */
            isSorted = true;
            for(int i = 0; i + step < array.length; i++){
                if(array[i] > array[i + step]){
                    int temp = array[i];
                    array[i] = array[i + step];
                    array[i + step] = temp;
                    isSorted = false;
                }
            }
            step /= 1.247; // Сокращаем интервал между элементами перед следующей итерацией
        }
    }
}
