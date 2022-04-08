import java.util.HashMap;

public class Lagrange {

    // ТУТ ВАЩЕ НИЧЕГО СЛОЖНОГО. У него есть формула, которая написана в getValue, там по сути ряд, у этого ряда есть переменная l, у которой своя формула. Формулы я приложил.


    private static Double l(int index, Double[] X, Double x){
        Double l = 1.0;
        for (int i = 0; i < X.length; i++){
            if(i != index){
                l *= (x-X[i])/(X[index] - X[i]);
            }
        }

        return l;
    }

    public static Double getValue(Double[] X, Double[] Y, Double x){
        Double y = 0.0;
        for (int i = 0; i < X.length; i++){
            y += Y[i] * l(i, X, x);
        }

        return y;
    }

    public static double F(Double x){
        return -1 * x + 6 + x*x;
    }
    public static void main(String[] args) {
        // Сама суть метода - найти значение функции между двумя уже известными выколотыми точками
        // Массив X - это набор наших точек
        Double[] X = new Double[] {0.0, 1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0};
        // Массив Y - значения функции в этих точках
        Double[] Y = new Double[X.length];
        for (int i = 0; i < X.length; i++){
            Y[i] = F(X[i]);
        }
        Double x;
        Double y;
        // А здесь мы с шагом 0.5 смотрим чему будет равна функция в точке i. То есть в точке 0.5, 1.5, 2.5, и т.д
        for (Double i = 0.5; i < X.length; i += 1) {
            x = i;
            y = Lagrange.getValue(X, Y, x);
            System.out.println("x = " + x + " y = " + y);
        }
     }
}
