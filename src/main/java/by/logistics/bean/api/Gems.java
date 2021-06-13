package by.logistics.bean.api;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "gems")
public class Gems implements Serializable {

    @Column(name = "attestat")
    private String attestat;

    @Column(name = "name_ru")
    private String name_ru;

    @Column(name = "grani")
    private String grani;
}
