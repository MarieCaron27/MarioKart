package Model.Entities;

import java.util.ArrayList;
import java.util.List;

public class Circuit
{
    private int id;
    private String name;
    private List<Segment> sections;

    public Circuit() {
        this.sections = new ArrayList<>();
    }

    public void setId(int id){
        this.id = id;
    }

    public int getId(){
        return id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void addSection(Segment section) {
        sections.add(section);
    }

    public List<Segment> getSegments() {
        return sections;
    }

    public Circuit clone(int id)
    {
        Circuit copy = new Circuit();
        copy.setId(id);

        return copy;
    }
}

