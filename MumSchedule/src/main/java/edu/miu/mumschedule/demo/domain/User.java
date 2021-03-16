package edu.miu.mumschedule.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "FirstName required!")
    private String firstName;
    @NotBlank(message = "LastName required!")
    private String lastName;
    @NotBlank(message = "Email required!")
    private String email;

    @ManyToOne
//    @JoinColumn(nullable = true)
    private Role role;
    //added

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn
    @Valid
    private Credential credential;






}