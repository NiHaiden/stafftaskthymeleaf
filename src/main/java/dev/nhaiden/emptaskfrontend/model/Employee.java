package dev.nhaiden.emptaskfrontend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "staff")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Employee implements Serializable {
    @Id
    @Length(max = 6)
    @NotBlank
    @Column(name = "employee_id")
    private String id;

    @Column(name = "first_name")
    @NotBlank
    @Length(max = 255)
    @EqualsAndHashCode.Exclude
    private String firstName;

    @Column(name = "last_name")
    @NotBlank
    @Length(max = 255)
    @EqualsAndHashCode.Exclude
    private String lastName;

    @OneToMany(mappedBy = "employee")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonIgnore
    private List<Task> tasks = new ArrayList<>();
}
