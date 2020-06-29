package sk.fri.uniza.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.NaturalId;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.Valid;

@org.hibernate.annotations.NamedQueries({
        @org.hibernate.annotations.NamedQuery(name = "IotNode_findAll",
                query = "from IotNode"),
        @org.hibernate.annotations.NamedQuery(name = "houshold_id",
                query = "from IotNode"),

})

@Entity
public class IotNode {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @ApiModelProperty(example = "1")
    private Long id;

    @NotEmpty
    @ApiModelProperty(example = "Marek")
    private String Name;


    @Valid
    private HouseHold houseHold;
    @OneToMany(fetch = FetchType.LAZY,
            mappedBy = "household", cascade = CascadeType.REMOVE)



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public HouseHold getHouseHold() {
        return houseHold;
    }

    public void setHouseHold(HouseHold houseHold) {
        this.houseHold = houseHold;
    }
}
