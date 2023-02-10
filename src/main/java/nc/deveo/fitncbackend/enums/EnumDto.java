package nc.deveo.fitncbackend.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class EnumDto implements IEnumDto {
    private String label;
    private String friendlyValue;
    private String value;

    public static EnumDto toEnumDto(IEnumDto iEnumDto) {
        return new EnumDto(iEnumDto.getLabel(), iEnumDto.getFriendlyValue(), iEnumDto.getValue());
    }
}
