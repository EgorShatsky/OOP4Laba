import javax.swing.JComponent;
import java.awt.*;
import java.awt.image.BufferedImage;

public class JImageDisplay extends JComponent {//Наследуем от базового класса JComponent, который предназначен для Swing-компонентов, но также и для пользовательских компонентов.
    private final BufferedImage image;

    public JImageDisplay(int w, int h){//Класс принимает целочисленные значения ширины и высоты
        if (w <= 0)
            throw new IllegalArgumentException("w must be > 0; got " + w);

        if (h <= 0)
            throw new IllegalArgumentException("h must be > 0; got " + h);

        image = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);//Инициализация объекта BufferedImage.
        Dimension dimension = new Dimension(w, h);//Новое изображение с этой шириной и высотой, и типом изображения TYPE_INT_RGB. Тип определяет, как цвета каждого пикселя будут

        super.setPreferredSize(dimension);//Конструктор вызвает метод setPreferredSize() родительского класса метод с указанной шириной и высотой.
    }

    @Override // Показываю, что далее я собираюсь переопределять метод базового класса.
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);// Нужно вызывать метод суперкласса paintComponent (g) так, чтобы объекты отображались правильно


        g.drawImage (image, 0, 0, image.getWidth(), image.getHeight(), null);// Рисовка изображения в компоненте
    }

    public void clearImage() {// Метод, который устанавливает все пиксели изображения в черный цвет (значение RGB 0)
        Graphics2D imageGraphics = image.createGraphics();
        imageGraphics.setColor(new Color(0, 0, 0));

        imageGraphics.fillRect(0, 0, image.getWidth(), image.getHeight());
    }

    public void drawPixel (int x, int y, int rgbColor){
        image.setRGB(x, y, rgbColor);
    }// Устанавливает пиксель в определенный цвет.
}

