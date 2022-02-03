package dev.nhaiden.emptaskfrontend.model;

import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "tasks")
@Getter
@Setter
@NoArgsConstructor
@ToString

public class Task implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "description")
    @NotBlank
    @Length(max = 255)
    @EqualsAndHashCode.Exclude
    private String description;

    @Column(name = "finished_date")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @EqualsAndHashCode.Exclude
    private LocalDate finished;

    @Column(name = "hours_worked")
    @EqualsAndHashCode.Exclude
    private Integer hoursWorked;

    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    @EqualsAndHashCode.Exclude
    private Employee employee;
}
