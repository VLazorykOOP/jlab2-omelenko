import static java.lang.Math.sqrt;

public class Vector {
    private short x;
    private short y;
    private short z;

    public Vector(short x, short y, short z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vector(int x, int y, int z) {
        this.x = (short) x;
        this.y = (short) y;
        this.z = (short) z;
    }

    public short getX() {return x;}
    public short getY() {return y;}
    public short getZ() {return z;}

    public void MultiByNum(short num) {
        x *= num;
        y *= num;
        z *= num;
    }

    public double Module() {
        return sqrt((x*x+y*y+z*z));
    }

    public double ScalarMulti(Vector vector1, Vector vector2) {
        return (vector1.x*vector2.x)+(vector1.y*vector2.y)+(vector1.z*vector2.z);
    }

    public Vector VectorMulti(Vector vector1, Vector vector2) {
        return new Vector(
                ((vector1.y*vector2.z)-(vector1.z*vector2.y)),
                ((vector1.z*vector2.x)-(vector1.x*vector2.z)),
                ((vector1.x*vector2.y)-(vector1.y*vector2.x))
        );
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ", " + z + ")";
    }

    public static void main(String[] args) {
        // Тестування конструкторів
        System.out.println("Тестування конструкторів:");
        Vector vector1 = new Vector((short) 1, (short) 2, (short) 3); // Конструктор з short
        System.out.println("Vector1 (short): " + vector1);

        Vector vector2 = new Vector(4, 5, 6); // Конструктор з int
        System.out.println("Vector2 (int): " + vector2);

        // Тестування множення на число
        System.out.println("\nТестування MultiByNum:");
        vector1.MultiByNum((short) 2); // Множимо vector1 на 2
        System.out.println("Vector1 після множення на 2: " + vector1);

        // Тестування модуля вектора
        System.out.println("\nТестування Module:");
        System.out.println("Модуль Vector1: " + vector1.Module());
        System.out.println("Модуль Vector2: " + vector2.Module());

        // Тестування скалярного добутку
        System.out.println("\nТестування ScalarMulti:");
        double scalar = vector1.ScalarMulti(vector1, vector2);
        System.out.println("Скалярний добуток Vector1 і Vector2: " + scalar);

        // Тестування векторного добутку
        System.out.println("\nТестування VectorMulti:");
        Vector vectorProduct = vector1.VectorMulti(vector1, vector2);
        System.out.println("Векторний добуток Vector1 і Vector2: " + vectorProduct);

        // Тестування геттерів
        System.out.println("\nТестування геттерів:");
        System.out.println("Vector2: x=" + vector2.getX() + ", y=" + vector2.getY() + ", z=" + vector2.getZ());
    }
}
