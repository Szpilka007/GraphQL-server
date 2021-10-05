package com.oktadeveloper.graphqldemo.model;

import io.leangen.graphql.annotations.GraphQLQuery;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Entity;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Food {

    @Id @GeneratedValue
    @GraphQLQuery(name = "id", description = "A food's id")
    private Long id;

    @GraphQLQuery(name = "temporaryId", description = "A food's temporaryId")
    private Integer temporaryId;

    @GraphQLQuery(name = "name", description = "A food's name")
    private String name;

    @GraphQLQuery(name = "price", description = "A food's price")
    private Integer price;

    @GraphQLQuery(name = "company", description = "A food's company")
    private String company;

    @GraphQLQuery(name = "amount", description = "A food's amount")
    private Integer amount;

    @Override
    public String toString() {
        return "Food{" +
            "id=" + id +
            ", name='" + name + '\'' +
            '}';
    }

}
