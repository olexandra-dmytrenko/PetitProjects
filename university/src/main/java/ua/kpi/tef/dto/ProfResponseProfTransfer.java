package ua.kpi.tef.dto;

import ua.kpi.tef.model.Professor;

public class ProfResponseProfTransfer {

    public static ProfessorResponse to(Professor p) {
        return new ProfessorResponse(p.getId(), p.getName(), p.getSurname(), p.getBirthday());
    }

    public static Professor from(ProfessorResponse pr) {
        Professor p = new Professor();
        p.setId(pr.getId());
        p.setName(pr.getName());
        p.setSurname(pr.getSurname());
        p.setBirthday(pr.getBirthday());
        return p;
    }
}
