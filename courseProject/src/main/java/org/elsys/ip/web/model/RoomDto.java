package org.elsys.ip.web.model;

import org.elsys.ip.web.model.validator.PasswordMatches;
import org.elsys.ip.web.model.validator.ValidEmail;
import org.elsys.ip.web.model.validator.ValidRoomNameFiveSymbols;
import org.elsys.ip.web.model.validator.ValidRoomWithNameAlreadyExists;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Objects;

public class RoomDto {
    private String id;

    @NotNull
    @NotEmpty
    @ValidRoomNameFiveSymbols
    @ValidRoomWithNameAlreadyExists
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoomDto roomDto = (RoomDto) o;
        return Objects.equals(id, roomDto.id) && Objects.equals(name, roomDto.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
