package nulp.cs.carrentalrestservice.util;

import jakarta.persistence.Convert;
import nulp.cs.carrentalrestservice.model.Status;
import org.springframework.core.convert.converter.Converter;

public class StringToEnumConverter implements Converter<String, Status> {

    @Override
    public Status convert(String source) {
        return Status.valueOf(source.toUpperCase());
    }
}
