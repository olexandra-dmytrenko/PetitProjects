package ua.kpi.tef.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProfessorResponse {
    Long id;
    String name;
    String surname;
    Date birthday;
}
