package com.vchitr.entity;

import java.sql.Date;
import java.time.LocalDateTime;
import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "users", schema = "security")
public class users {


   /*
    * Entity marks this class as an entity class
    * Table(name = users) -> name of table
    * (schema = security) -> name of the schema ( in postgre, DATABASE -> SCHEMA -> Tables whereas in mysql, DATABASE = SCHEMA)
    * ID annotation -> marks the primary key
    * GeneratedValue annotation -> marks the auto increment strategy ( tells spring to let postgres's IDENTITY auto increment feature handle id generation)
    * GeneratedValue annotaion ensures that spring/hibernate do not change value 
    */ 



   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer user_id;

   @Column(name = "user_name", nullable = false)
   private String userName;

   @Column(name = "email", nullable =  false, unique = true)
   private String email;
    
   @Column(name = "password_hash")
   private String passwordHash;

   @Column(name = "is_active", nullable = false)
   private boolean isActive;

   @Column(name = "created_at", nullable = false)
   private LocalDateTime createdAt;

   /*
    * Columns for external auth users ( google + 0auth2.0)
    * 
    * */
    @Column(name = "provider", nullable = false)
    private Enum provider;


}
