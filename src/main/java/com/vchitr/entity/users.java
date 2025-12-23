package com.vchitr.entity;

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
 
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer user_id;





}
