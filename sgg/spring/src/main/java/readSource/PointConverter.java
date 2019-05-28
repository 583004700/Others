package readSource;

import org.springframework.core.convert.converter.Converter;

public class PointConverter implements Converter<String, Point> {
    @Override
    public Point convert(String source) {
        String[] splits = source.split(":");
        Point point = new Point();
        point.setX(Integer.parseInt(splits[0]));
        point.setY(Integer.parseInt(splits[1]));
        return point;
    }
}
