package readSource;

import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.support.DefaultConversionService;

public class ConverterTest {
    public static void main(String[] args) {
        DefaultConversionService service = new DefaultConversionService();
        service.addConverter(new PointConverter());
        Point point = service.convert("5:8", Point.class);

        System.out.println(TypeDescriptor.forObject("5:8"));
        System.out.println(TypeDescriptor.valueOf(Point.class));

        System.out.println(point.getX());
        System.out.println(point.getY());
    }
}
