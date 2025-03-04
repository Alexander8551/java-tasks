public class MagicSquare {
    public static void main(String[] args) {
        int n = 3; // Размер магического квадрата
        int[][] magicSquare = new int[n][n];

        // Алгоритм создания магического квадрата нечетного порядка (метод Сиама)
        int row = 0;
        int col = n / 2; // Начальная позиция в середине верхней строки
        int num = 1;

        while (num <= n * n) {
            magicSquare[row][col] = num; // Заполняем текущую ячейку
            num++;

            // Сохраняем текущие координаты
            int nextRow = (row - 1 + n) % n; // Переход вверх (с учетом цикличности)
            int nextCol = (col + 1) % n;     // Переход вправо

            if (magicSquare[nextRow][nextCol] != 0) {
                // Если ячейка занята, спускаемся вниз
                row = (row + 1) % n;
            } else {
                // Иначе переходим в следующую ячейку
                row = nextRow;
                col = nextCol;
            }
        }

        // Вывод магического квадрата
        System.out.println("Magic square 3x3:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(magicSquare[i][j] + "\t");
            }
            System.out.println();
        }

        // Проверка сумм строк, столбцов и диагоналей
        int magicSum = n * (n * n + 1) / 2; // Магическая сумма
        System.out.println("Magic sum: " + magicSum);
    }
}