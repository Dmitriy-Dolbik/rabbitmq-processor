package ru.sberinsure.rabbitmq.processor.model;

import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.AllArgsConstructor;
import lombok.Generated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@RegisterForReflection//instructs Quarkus to keep the class, its fields, and methods when creating a native executable
@AllArgsConstructor
@NoArgsConstructor//Default constructor required for Jackson serializer
@ToString
@Getter
public class Quote {

    private String id;
    private int price;
}
