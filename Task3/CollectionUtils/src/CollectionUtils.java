import java.util.*;

public class CollectionUtils {
        // Пример использования функций
        public static void main(String[] args) {
            // Пример для сортировки Map
            Map<String, Integer> unsortedMap = new HashMap<>();
            unsortedMap.put("a", 3);
            unsortedMap.put("b", 1);
            unsortedMap.put("c", 2);
            System.out.println("Сортировка Map по значению: " + sortByValue(unsortedMap));
    
            // Пример для сложения двух Map
            Map<String, Integer> map1 = new HashMap<>();
            map1.put("a", 1);
            map1.put("b", 2);
            Map<String, Integer> map2 = new HashMap<>();
            map2.put("b", 3);
            map2.put("c", 4);
            System.out.println("Сложение двух Map: " + mergeMaps(map1, map2));
    
            // Пример для нахождения повторяющихся значений в списке
            List<Integer> list = Arrays.asList(1, 2, 3, 4, 1, 2, 5);
            System.out.println("Повторяющиеся значения: " + findDuplicates(list));
    
            // Пример для нахождения пересечения двух Set
            Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3, 4));
            Set<Integer> set2 = new HashSet<>(Arrays.asList(3, 4, 5, 6));
            System.out.println("Пересечение двух Set: " + findIntersection(set1, set2));
        }

    // Функция для сортировки Map по значению ключа
    public static Map<String, Integer> sortByValue(Map<String, Integer> map) {
        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(Map.Entry.comparingByValue());

        Map<String, Integer> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }
        return sortedMap;
    }

    // Функция для сложения двух Map
    public static Map<String, Integer> mergeMaps(Map<String, Integer> map1, Map<String, Integer> map2) {
        Map<String, Integer> result = new HashMap<>(map1);
        map2.forEach((key, value) -> result.merge(key, value, Integer::sum));
        return result;
    }

    // Функция для поиска всех повторяющихся значений в списке
    public static <T> Set<T> findDuplicates(List<T> list) {
        Set<T> allItems = new HashSet<>();
        Set<T> duplicates = new HashSet<>();
        for (T item : list) {
            if (!allItems.add(item)) {
                duplicates.add(item);
            }
        }
        return duplicates;
    }

    // Функция для нахождения пересечения двух Set
    public static <T> Set<T> findIntersection(Set<T> set1, Set<T> set2) {
        Set<T> intersection = new HashSet<>(set1);
        intersection.retainAll(set2);
        return intersection;
    }
}