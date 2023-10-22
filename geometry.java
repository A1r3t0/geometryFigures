import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import static java.lang.Math.*;

public class geometry {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<figure> figures = new ArrayList<>();
        System.out.println("Сколько фигур для создания вам потребуется?");
        String count1 = reader.readLine();
        int count = Integer.parseInt(count1);
        if (count == 0) {
            System.out.println("Вы можете создать минимум 1 фигуру!");
            System.exit(0);
        }
        for (int i = 0; i < count; i++) {
            System.out.println("Введите название фигуры, которую хотите создать с большой буквы (Прямоугольник, Квадрат, Треугольник, Круг, Точка): ");
            String figure = reader.readLine();
            switch (figure) {
                case "Прямоугольник" -> {
                    System.out.println("Введите одну из точек прямоугольника(координаты (x,y) через Enter): ");
                    String s = reader.readLine();
                    String z = reader.readLine();
                    int x1 = Integer.parseInt(s);
                    int y1 = Integer.parseInt(z);
                    System.out.println("Введите другую из точек прямоугольника, не диагональную первой (координаты (x,y) через Enter): ");
                    String n = reader.readLine();
                    String k = reader.readLine();
                    int x2 = Integer.parseInt(n);
                    int y2 = Integer.parseInt(k);
                    System.out.println("Введите третью точку прямоугольника (диагональную первой) (координаты (x,y) через Enter): ");
                    String j = reader.readLine();
                    String j1 = reader.readLine();
                    int x3 = Integer.parseInt(j);
                    int y3 = Integer.parseInt(j1);
                    System.out.println("Введите четвертую точку прямоугольника(координаты (x,y) через Enter): ");
                    String m = reader.readLine();
                    String m1 = reader.readLine();
                    int x4 = Integer.parseInt(m);
                    int y4 = Integer.parseInt(m1);
                    figures.add(new quadrangle(x1, y1, x2, y2, x3, y3, x4, y4));
                }
                case "Квадрат" -> {
                    System.out.println("Введите одну из точек квадрата(координаты (x,y) через Enter): ");
                    String s = reader.readLine();
                    String z = reader.readLine();
                    int x1 = Integer.parseInt(s);
                    int y1 = Integer.parseInt(z);
                    System.out.println("Введите другую из точек квадрата, не диагональную первой (координаты (x,y) через Enter): ");
                    String n = reader.readLine();
                    String k = reader.readLine();
                    int x2 = Integer.parseInt(n);
                    int y2 = Integer.parseInt(k);
                    System.out.println("Введите третью точку квадрата (диагональную первой) (координаты (x,y) через Enter): ");
                    String j = reader.readLine();
                    String j1 = reader.readLine();
                    int x3 = Integer.parseInt(j);
                    int y3 = Integer.parseInt(j1);
                    System.out.println("Введите четвертую точку квадрата(координаты (x,y) через Enter): ");
                    String m = reader.readLine();
                    String m1 = reader.readLine();
                    int x4 = Integer.parseInt(m);
                    int y4 = Integer.parseInt(m1);
                    figures.add(new quadrangle(x1, y1, x2, y2, x3, y3, x4, y4));
                }
                case "Круг" -> {
                    System.out.println("Введите координаты центра круга (x,y) через Enter: ");
                    String s = reader.readLine();
                    String z = reader.readLine();
                    int x1 = Integer.parseInt(s);
                    int y1 = Integer.parseInt(z);
                    System.out.println("Введите координаты точки, лежащей на окружности (x,y) через Enter: ");
                    String n = reader.readLine();
                    String n1 = reader.readLine();
                    int x2 = Integer.parseInt(n);
                    int y2 = Integer.parseInt(n1);
                    figures.add(new circle(x1, y1, x2, y2));
                }
                case "Точка" -> {
                    System.out.println("Введите координаты точки (x,y) через Enter: ");
                    String s = reader.readLine();
                    String z = reader.readLine();
                    int x1 = Integer.parseInt(s);
                    int y1 = Integer.parseInt(z);
                    figures.add(new point(x1, y1));
                }
                case "Треугольник" -> {
                    System.out.println("Введите одну из точек треугольника(координаты (x,y) через Enter): ");
                    String s = reader.readLine();
                    String z = reader.readLine();
                    int x1 = Integer.parseInt(s);
                    int y1 = Integer.parseInt(z);
                    System.out.println("Введите другую из точек треугольника (координаты (x,y) через Enter): ");
                    String n = reader.readLine();
                    String k = reader.readLine();
                    int x2 = Integer.parseInt(n);
                    int y2 = Integer.parseInt(k);
                    System.out.println("Введите третью точку треугольника (координаты (x,y) через Enter): ");
                    String j = reader.readLine();
                    String j1 = reader.readLine();
                    int x3 = Integer.parseInt(j);
                    int y3 = Integer.parseInt(j1);
                    figures.add(new trigon(x1, y1, x2, y2, x3, y3));
                }
            }
        }
        for (int i = 0; i < figures.size(); i++) {
            figures.get(i).results();
        }

    }
    public static abstract class figure {

        public abstract String perimeter();

        public abstract String square();

        public abstract String type();
        public abstract String point();
        public void results()
        {
            System.out.println("Тип фигуры: " + type());
            System.out.println("Периметр фигуры: " + perimeter());
            System.out.println("Площадь фигуры: " + square());
            System.out.println("Заданные координаты (точки) фигуры:" + point());
        }
    }
    public static class trigon extends figure {
        private double a, b, c, x1, x2, x3, y1, y2, y3;
        public trigon(double x1, double y1, double x2, double y2, double x3, double y3) {
            a = sqrt(pow(x2-x1,2)+pow(y2-y1,2));
            b = sqrt(pow(x3-x2,2)+pow(y3-y2,2));
            c = sqrt(pow(x3-x1,2)+pow(y3-y1,2));
            this.x1 = x1;
            this.x2 = x2;
            this.x3 = x3;
            this.y1 = y1;
            this.y2 = y2;
            this.y3 = y3;
        }
        @Override
        public String perimeter() {
            double Perimeter = a+b+c;
            return "" + Perimeter;
        }
        @Override
        public String square() {
            double halfOfPerimeter = (a+b+c)/2.0;
            double square = sqrt(halfOfPerimeter*(halfOfPerimeter-a)*(halfOfPerimeter-b)*(halfOfPerimeter-c));
            return "" + square;
        }
        @Override
        public String type() {
            return "Треугольник";
        }
        @Override
        public String point() {
            return "("+x1+";"+y1+")"+","+"("+x2+";"+y2+")"+","+"("+x3+";"+y3+")";
        }
    }
    public static class quadrangle extends figure {
        private double a, b, x1, x2, x3, x4, y1, y2, y3, y4;
        public quadrangle(double x1, double y1, double x2, double y2, double x3, double y3, double x4, double y4) {
            a = sqrt(pow(x2-x1,2)+pow(y2-y1,2));
            b = sqrt(pow(x3-x1,2)+pow(y3-y1, 2));
            this.x1 = x1;
            this.x2 = x2;
            this.x3 = x3;
            this.x4 = x4;
            this.y1 = y1;
            this.y2 = y2;
            this.y3 = y3;
            this.y4 = y4;
        }
        @Override
        public String perimeter() {
            double Perimeter = (a+b)*2;
            return "" + Perimeter;
        }
        @Override
        public String square() {
            double square = a*b;
            return "" + square;
        }
        @Override
        public String type() {
            return "Прямоугольник";
        }
        @Override
        public String point() {
            return "("+x1+";"+y1+")"+","+"("+x2+";"+y2+")"+","+"("+x3+";"+y3+")"+","+"("+x4+";"+y4+")";
        }
    }
    public static class point extends figure {
        private double a, b;
        @Override
        public String type() {
            return "Точка";
        }
        public point(double x, double y) {
            a = x;
            b = y;
        }
        @Override
        public String perimeter() {
            return "Точка не имеет периметр!";
        }
        @Override
        public String square() {
            return "Точка не имеет площади!";
        }
        @Override
        public String point() {
            return "("+a+";"+b+")";
        }
    }
    public static class circle extends figure {
        private double r, x1, x2, y1, y2;
        public circle(double x1, double y1, double x2, double y2) {
            r = sqrt(pow(x2-x1,2)+pow(y2-y1,2));
            this.x1 = x1;
            this.x2 = x2;
            this.y1 = y1;
            this.y2 = y2;
        }
        @Override
        public String perimeter() {
            return 2*PI*r+"";
        }
        @Override
        public String square() {
            return PI*pow(r,2)+"";
        }
        @Override
        public String point() {
            return "("+x1+";"+y1+")"+","+"("+x2+";"+y2+")";
        }
        @Override
        public String type() {
            return "Круг";
        }
    }
}