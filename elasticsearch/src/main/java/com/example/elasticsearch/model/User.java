package com.example.elasticsearch.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

/**
 * @desc:
 * @author: merickbao
 * @since: 2023/8/22 23:00
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "index_user")
public class User {

    @Id
    private String id;

    private String name;

    private String email;

    private Integer age;
}
