package ua.kpi.tef.ui;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;

import ua.kpi.tef.dto.ProfessorResponse;
import ua.kpi.tef.service.ProfessorService;

@Route(value="/ui/welcome", layout = MainView.class)
@RouteAlias(value = "", layout = MainView.class)

public class WelcomeView extends VerticalLayout {

    ProfessorService professorService;
    private Grid<ProfessorResponse> grid = new Grid<>(ProfessorResponse.class);

    public WelcomeView(ProfessorService professorService) {
        this.professorService = professorService;

        addClassName("list-view");
        setSizeFull();
        configureGrid();

        add(grid);
        updateList();

        Button button = new Button("I'm a button");
        HorizontalLayout layout = new HorizontalLayout(button, new DatePicker("Pick a date"));

        layout.setDefaultVerticalComponentAlignment(Alignment.END);
        add(layout);

        button.addClickListener(clickEvent ->
                add(new Text("Clicked!")));
    }

    private void configureGrid() {
        grid.addClassName("contact-grid");
        grid.setSizeFull();
        grid.setColumns("id", "name", "surname", "birthday");
    }

    private void updateList() {
        grid.setItems(professorService.getAllProfessors());
    }
}
